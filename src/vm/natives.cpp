// natives.cpp — implementação de métodos nativos da biblioteca padrão Java (java.lang, java.util, java.io)
#include "vm.h"
#include "../platform/platform.h"
#include "../platform/updater.h"
#include "../platform/cloud_save.h"
#include "../midp/midp.h"
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <cmath>
#include <fstream>
#include <sstream>
#include <algorithm>

namespace hl {

// Helper para ler string Java
static std::u16string getStr(Object* o) {
  if (!o || o->kind != K_STRING) return u"";
  return static_cast<Str*>(o)->s;
}

static std::string getStrUtf8(Object* o) {
  return toUtf8(getStr(o));
}

// -------------------------------------------------------------
// java/lang/Object
// -------------------------------------------------------------
static void Object_init(VM&, Value*, Value*) {}

static void Object_equals(VM&, Value* args, Value* ret) {
  ret[0].i = (args[0].o == args[1].o) ? 1 : 0;
}

static void Object_getClass(VM& vm, Value* args, Value* ret) {
  if (!args[0].o) vm.npe();
  ret[0].o = vm.classObjOf(args[0].o->cls);
}

static void Object_toString(VM& vm, Value* args, Value* ret) {
  if (!args[0].o) vm.npe();
  char buf[64];
  snprintf(buf, sizeof(buf), "%s@%p", args[0].o->cls->name.c_str(), (void*)args[0].o);
  ret[0].o = vm.newStrUtf8(buf);
}

// -------------------------------------------------------------
// java/lang/Class
// -------------------------------------------------------------
static void Class_getResourceAsStream(VM& vm, Value* args, Value* ret) {
  if (!args[0].o) vm.npe();
  Object* strObj = args[1].o;
  if (!strObj) { ret[0].o = nullptr; return; }
  std::string path = getStrUtf8(strObj);
  if (path.empty()) { ret[0].o = nullptr; return; }

  // Normaliza caminho (remove barra inicial)
  std::string relPath = path;
  if (relPath[0] == '/' || relPath[0] == '\\') relPath = relPath.substr(1);

  // Procura no diretório de dados
  std::string fullPath = vm.dataDir.empty() ? relPath : (vm.dataDir + "/" + relPath);
  std::vector<uint8_t> buf = Platform::readAsset(fullPath);
  if (buf.empty()) {
    buf = Platform::readAsset(relPath);
  }
  if (buf.empty()) {
    ret[0].o = nullptr;
    return;
  }

  ClassInfo* cbais = vm.mustClass("java/io/ByteArrayInputStream");
  Bais* bais = vm.alloc<Bais>(cbais, K_BAIS);
  bais->data = std::move(buf);
  bais->pos = 0;
  ret[0].o = bais;
}

static void Class_getName(VM& vm, Value* args, Value* ret) {
  if (!args[0].o) vm.npe();
  ClassObj* co = static_cast<ClassObj*>(args[0].o);
  std::string n = co->of ? co->of->name : "";
  for (char& c : n) if (c == '/') c = '.';
  ret[0].o = vm.newStrUtf8(n);
}

// -------------------------------------------------------------
// java/lang/String
// -------------------------------------------------------------
static void String_init(VM&, Value*, Value*) {}

static void String_init_bytes(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!a) vm.npe();
  int off = args[2].i;
  int len = args[3].i;
  if (off < 0 || len < 0 || off + len > a->len) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  const char* p = reinterpret_cast<const char*>(a->data.data() + off);
  s->s = fromUtf8(std::string(p, len));
}

static void String_init_chars(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!a) vm.npe();
  const char16_t* p = reinterpret_cast<const char16_t*>(a->data.data());
  s->s.assign(p, p + a->len);
}

static void String_init_chars_offset(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!a) vm.npe();
  int off = args[2].i;
  int len = args[3].i;
  if (off < 0 || len < 0 || off + len > a->len) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  const char16_t* p = reinterpret_cast<const char16_t*>(a->data.data() + off * 2);
  s->s.assign(p, p + len);
}

static void String_init_str(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Object* o2 = args[1].o;
  if (!o2) vm.npe();
  s->s = getStr(o2);
}

static void String_charAt(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  int idx = args[1].i;
  if (idx < 0 || (size_t)idx >= s->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException", std::to_string(idx));
  ret[0].i = s->s[idx];
}

static void String_compareTo(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Str* o = static_cast<Str*>(args[1].o);
  if (!s || !o) vm.npe();
  ret[0].i = s->s.compare(o->s);
}

static void String_endsWith(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Str* suf = static_cast<Str*>(args[1].o);
  if (!s || !suf) vm.npe();
  if (suf->s.size() > s->s.size()) { ret[0].i = 0; return; }
  ret[0].i = (s->s.compare(s->s.size() - suf->s.size(), suf->s.size(), suf->s) == 0) ? 1 : 0;
}

static void String_equals(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Object* o = args[1].o;
  if (!s) vm.npe();
  if (s == o) { ret[0].i = 1; return; }
  if (!o || o->kind != K_STRING) { ret[0].i = 0; return; }
  ret[0].i = (s->s == static_cast<Str*>(o)->s) ? 1 : 0;
}

static void String_indexOf_ch(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  char16_t c = (char16_t)args[1].i;
  auto pos = s->s.find(c);
  ret[0].i = (pos == std::u16string::npos) ? -1 : (int)pos;
}

static void String_indexOf_str(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Str* sub = static_cast<Str*>(args[1].o);
  if (!s || !sub) vm.npe();
  auto pos = s->s.find(sub->s);
  ret[0].i = (pos == std::u16string::npos) ? -1 : (int)pos;
}

static void String_length(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  ret[0].i = (int)s->s.size();
}

static void String_replace(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  char16_t oldC = (char16_t)args[1].i;
  char16_t newC = (char16_t)args[2].i;
  std::u16string res = s->s;
  for (auto& c : res) if (c == oldC) c = newC;
  ret[0].o = vm.newStr(res);
}

static void String_startsWith(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Str* pre = static_cast<Str*>(args[1].o);
  if (!s || !pre) vm.npe();
  if (pre->s.size() > s->s.size()) { ret[0].i = 0; return; }
  ret[0].i = (s->s.compare(0, pre->s.size(), pre->s) == 0) ? 1 : 0;
}

static void String_substring_1(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  int begin = args[1].i;
  if (begin < 0 || (size_t)begin > s->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException", std::to_string(begin));
  ret[0].o = vm.newStr(s->s.substr(begin));
}

static void String_substring_2(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  int begin = args[1].i;
  int end = args[2].i;
  if (begin < 0 || end < begin || (size_t)end > s->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  ret[0].o = vm.newStr(s->s.substr(begin, end - begin));
}

static void String_toCharArray(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  Array* arr = vm.newArray('C', (int)s->s.size());
  if (!s->s.empty()) {
    std::memcpy(arr->data.data(), s->s.data(), s->s.size() * 2);
  }
  ret[0].o = arr;
}

static void String_toLowerCase(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  std::u16string res = s->s;
  for (auto& c : res) if (c >= u'A' && c <= u'Z') c = c + (u'a' - u'A');
  ret[0].o = vm.newStr(res);
}

static void String_toUpperCase(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  std::u16string res = s->s;
  for (auto& c : res) if (c >= u'a' && c <= u'z') c = c - (u'a' - u'A');
  ret[0].o = vm.newStr(res);
}

static void String_trim(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  size_t start = 0;
  while (start < s->s.size() && s->s[start] <= 0x20) start++;
  size_t end = s->s.size();
  while (end > start && s->s[end - 1] <= 0x20) end--;
  ret[0].o = vm.newStr(s->s.substr(start, end - start));
}

static void String_valueOf_chars(VM& vm, Value* args, Value* ret) {
  Array* a = static_cast<Array*>(args[0].o);
  if (!a) vm.npe();
  const char16_t* p = reinterpret_cast<const char16_t*>(a->data.data());
  ret[0].o = vm.newStr(std::u16string(p, p + a->len));
}

static void String_valueOf_int(VM& vm, Value* args, Value* ret) {
  ret[0].o = vm.newStrUtf8(std::to_string(args[0].i));
}

// -------------------------------------------------------------
// java/lang/StringBuffer
// -------------------------------------------------------------
static void StringBuffer_init(VM&, Value*, Value*) {}

static void StringBuffer_init_str(VM& vm, Value* args, Value*) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  sb->s = getStr(args[1].o);
}

static void StringBuffer_append_chars(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!sb) vm.npe();
  if (a) {
    const char16_t* p = reinterpret_cast<const char16_t*>(a->data.data());
    sb->s.append(p, p + a->len);
  }
  ret[0].o = sb;
}

static void StringBuffer_append_char(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  sb->s.push_back((char16_t)args[1].i);
  ret[0].o = sb;
}

static void StringBuffer_append_int(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  std::u16string num = fromUtf8(std::to_string(args[1].i));
  sb->s.append(num);
  ret[0].o = sb;
}

static void StringBuffer_append_obj(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  Object* o = args[1].o;
  if (!sb) vm.npe();
  if (!o) {
    sb->s.append(u"null");
  } else if (o->kind == K_STRING) {
    sb->s.append(static_cast<Str*>(o)->s);
  } else {
    Value vr[2];
    vm.invokeVirtual(o, "toString:()Ljava/lang/String;", nullptr, 0, vr);
    sb->s.append(getStr(vr[0].o));
  }
  ret[0].o = sb;
}

static void StringBuffer_append_str(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  Object* strObj = args[1].o;
  if (!sb) vm.npe();
  if (!strObj) sb->s.append(u"null");
  else sb->s.append(getStr(strObj));
  ret[0].o = sb;
}

static void StringBuffer_charAt(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  int idx = args[1].i;
  if (idx < 0 || (size_t)idx >= sb->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  ret[0].i = sb->s[idx];
}

static void StringBuffer_delete(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  int start = args[1].i;
  int end = args[2].i;
  if (start < 0 || (size_t)start > sb->s.size() || start > end) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  if ((size_t)end > sb->s.size()) end = (int)sb->s.size();
  sb->s.erase(start, end - start);
  ret[0].o = sb;
}

static void StringBuffer_getChars(VM& vm, Value* args, Value*) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  int srcBegin = args[1].i;
  int srcEnd = args[2].i;
  Array* dst = static_cast<Array*>(args[3].o);
  int dstBegin = args[4].i;
  if (!dst) vm.npe();
  if (srcBegin < 0 || srcBegin > srcEnd || (size_t)srcEnd > sb->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  int len = srcEnd - srcBegin;
  if (dstBegin < 0 || dstBegin + len > dst->len) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  std::memcpy(dst->data.data() + dstBegin * 2, sb->s.data() + srcBegin, len * 2);
}

static void StringBuffer_length(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  ret[0].i = (int)sb->s.size();
}

static void StringBuffer_setCharAt(VM& vm, Value* args, Value*) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  int idx = args[1].i;
  if (idx < 0 || (size_t)idx >= sb->s.size()) vm.throwNew("java/lang/StringIndexOutOfBoundsException");
  sb->s[idx] = (char16_t)args[2].i;
}

static void StringBuffer_toString(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  ret[0].o = vm.newStr(sb->s);
}

// -------------------------------------------------------------
// java/lang/System
// -------------------------------------------------------------
static void System_arraycopy(VM& vm, Value* args, Value*) {
  Object* srcObj = args[0].o;
  int srcPos = args[1].i;
  Object* dstObj = args[2].o;
  int dstPos = args[3].i;
  int length = args[4].i;

  if (!srcObj || !dstObj) vm.npe();
  if (srcObj->kind != K_ARRAY || dstObj->kind != K_ARRAY) vm.throwNew("java/lang/ArrayStoreException");

  Array* src = static_cast<Array*>(srcObj);
  Array* dst = static_cast<Array*>(dstObj);

  if (src->type != dst->type) vm.throwNew("java/lang/ArrayStoreException");
  if (srcPos < 0 || dstPos < 0 || length < 0 || srcPos + length > src->len || dstPos + length > dst->len) {
    vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  }

  int elemSz = arrayElemSize(src->type);
  std::memmove(dst->data.data() + dstPos * elemSz, src->data.data() + srcPos * elemSz, length * elemSz);
}

static void System_currentTimeMillis(VM&, Value*, Value* ret) {
  ret[0].l = nowMs();
}

static void System_gc(VM& vm, Value*, Value*) {
  vm.gc();
}

static void System_getProperty(VM& vm, Value* args, Value* ret) {
  std::string key = getStrUtf8(args[0].o);
  if (key == "microedition.locale") {
    ret[0].o = vm.newStrUtf8("pt-BR");
  } else if (key == "microedition.platform") {
    ret[0].o = vm.newStrUtf8("j2me");
  } else if (key == "microedition.configuration") {
    ret[0].o = vm.newStrUtf8("CLDC-1.1");
  } else if (key == "microedition.profiles") {
    ret[0].o = vm.newStrUtf8("MIDP-2.0");
  } else {
    ret[0].o = nullptr;
  }
}

// -------------------------------------------------------------
// java/lang/Math
// -------------------------------------------------------------
static void Math_abs(VM&, Value* args, Value* ret) {
  int v = args[0].i;
  ret[0].i = (v < 0) ? -v : v;
}

static void Math_min(VM&, Value* args, Value* ret) {
  int a = args[0].i;
  int b = args[1].i;
  ret[0].i = (a < b) ? a : b;
}

// -------------------------------------------------------------
// java/lang/Integer
// -------------------------------------------------------------
static void Integer_parseInt_1(VM& vm, Value* args, Value* ret) {
  std::string s = getStrUtf8(args[0].o);
  try {
    ret[0].i = std::stoi(s);
  } catch (...) {
    vm.throwNew("java/lang/NumberFormatException", s);
  }
}

static void Integer_parseInt_2(VM& vm, Value* args, Value* ret) {
  std::string s = getStrUtf8(args[0].o);
  int radix = args[1].i;
  try {
    ret[0].i = std::stoi(s, nullptr, radix);
  } catch (...) {
    vm.throwNew("java/lang/NumberFormatException", s);
  }
}

// -------------------------------------------------------------
// java/lang/Runtime
// -------------------------------------------------------------
static void Runtime_getRuntime(VM& vm, Value*, Value* ret) {
  static Object* rt = nullptr;
  if (!rt) rt = vm.newObject(vm.mustClass("java/lang/Runtime"));
  ret[0].o = rt;
}

static void Runtime_gc(VM& vm, Value*, Value*) {
  vm.gc();
}

// -------------------------------------------------------------
// java/lang/Thread
// -------------------------------------------------------------
static void Thread_init(VM& vm, Value* args, Value*) {
  ThreadObj* t = static_cast<ThreadObj*>(args[0].o);
  boot_log("[Native] java/lang/Thread.<init> (ThreadObj=%p, runnable=%p)\n", t, args[1].o);
  if (!t) vm.npe();
  t->runnable = args[1].o;
}

static void Thread_sleep(VM& vm, Value* args, Value*) {
  int64_t ms = args[0].l;
  // Desvia o limitador de frame interno do J2ME (bs.java dorme ~50-75ms para forçar ~14 FPS).
  // Isso transfere o controle integral da taxa de quadros (15, 30 ou 60 FPS) para o
  // Platform::framePacerWait() nativo de alta precisão em C++.
  if (ms > 0 && ms <= 80 && g_display && g_display->current) {
    vm.sleepMs(0);
    return;
  }
  vm.sleepMs(ms);
}

static void Thread_start(VM& vm, Value* args, Value*) {
  ThreadObj* t = static_cast<ThreadObj*>(args[0].o);
  boot_log("[Native] java/lang/Thread.start (ThreadObj=%p)\n", t);
  if (!t) vm.npe();
  vm.startThread(t);
}

static void Thread_yield(VM& vm, Value*, Value*) {
  vm.sleepMs(0);
}

// -------------------------------------------------------------
// java/lang/Throwable
// -------------------------------------------------------------
static void Throwable_printStackTrace(VM&, Value* args, Value*) {
  Object* ex = args[0].o;
  if (ex) {
    fprintf(stderr, "[Exception] %s\n", ex->cls->name.c_str());
  }
}

static void Throwable_toString(VM& vm, Value* args, Value* ret) {
  Object* ex = args[0].o;
  if (!ex) vm.npe();
  ret[0].o = vm.newStrUtf8(ex->cls->name);
}

// Throwable.<init>() / <init>(String): campo 0 = mensagem (ver VM::throwNew)
static void Throwable_init(VM& vm, Value* args, Value*) {
  Instance* e = static_cast<Instance*>(args[0].o);
  if (!e) vm.npe();
}
static void Throwable_init_msg(VM& vm, Value* args, Value*) {
  Instance* e = static_cast<Instance*>(args[0].o);
  if (!e) vm.npe();
  if (!e->f.empty()) e->f[0].o = args[1].o;
}
static void Throwable_getMessage(VM& vm, Value* args, Value* ret) {
  Instance* e = static_cast<Instance*>(args[0].o);
  if (!e) vm.npe();
  ret[0].o = e->f.empty() ? nullptr : e->f[0].o;
}

// -------------------------------------------------------------
// Object.wait / notify (monitores cooperativos sob GIL)
// -------------------------------------------------------------
static std::unordered_map<Object*, uint32_t> g_notifySeq;

static void Object_wait(VM& vm, Value* args, Value*) {
  Object* o = args[0].o;
  if (!o) vm.npe();
  int64_t ms = args[1].l;
  uint32_t seq = g_notifySeq[o];
  uint32_t savedOwner = o->monOwner, savedCount = o->monCount;
  o->monOwner = 0; o->monCount = 0;
  int64_t start = nowMs();
  while (g_notifySeq[o] == seq) {
    if (ms > 0 && nowMs() - start >= ms) break;
    vm.sleepMs(1);
  }
  // re-adquire o monitor com a profundidade original
  vm.monitorEnter(o);
  o->monCount = savedCount ? savedCount : 1;
  (void)savedOwner;
}
static void Object_notify(VM& vm, Value* args, Value*) {
  Object* o = args[0].o;
  if (!o) vm.npe();
  g_notifySeq[o]++;
}

// -------------------------------------------------------------
// String extras
// -------------------------------------------------------------
static void String_init_bytes_all(VM& vm, Value* args, Value*) {
  Str* s = static_cast<Str*>(args[0].o);
  Array* a = static_cast<Array*>(args[1].o);
  if (!s || !a) vm.npe();
  s->s = fromUtf8(std::string(reinterpret_cast<const char*>(a->data.data()), a->len));
}
static void String_concat(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  Str* t = static_cast<Str*>(args[1].o);
  if (!s || !t) vm.npe();
  ret[0].o = vm.newStr(s->s + t->s);
}
static void String_getBytes(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  std::string u = toUtf8(s->s);
  Array* a = vm.newArray('B', (int)u.size());
  if (!u.empty()) std::memcpy(a->data.data(), u.data(), u.size());
  ret[0].o = a;
}
static void String_hashCode(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  int32_t h = 0;
  for (char16_t c : s->s) h = (int32_t)((uint32_t)h * 31u + (uint32_t)c);
  ret[0].i = h;
}
static void String_lastIndexOf_ch(VM& vm, Value* args, Value* ret) {
  Str* s = static_cast<Str*>(args[0].o);
  if (!s) vm.npe();
  auto pos = s->s.rfind((char16_t)args[1].i);
  ret[0].i = (pos == std::u16string::npos) ? -1 : (int)pos;
}
static void StringBuffer_append_long(VM& vm, Value* args, Value* ret) {
  SB* sb = static_cast<SB*>(args[0].o);
  if (!sb) vm.npe();
  sb->s.append(fromUtf8(std::to_string((long long)args[1].l)));
  ret[0].o = sb;
}

// -------------------------------------------------------------
// java/util/Hashtable
// -------------------------------------------------------------
static bool hashKeyEq(Object* a, Object* b) {
  if (a == b) return true;
  if (a && b && a->kind == K_STRING && b->kind == K_STRING)
    return static_cast<Str*>(a)->s == static_cast<Str*>(b)->s;
  return false;
}
static void Hashtable_init(VM&, Value*, Value*) {}
static void Hashtable_get(VM& vm, Value* args, Value* ret) {
  Hash* h = static_cast<Hash*>(args[0].o);
  if (!h || !args[1].o) vm.npe();
  ret[0].o = nullptr;
  for (auto& kv : h->e) if (hashKeyEq(kv.first, args[1].o)) { ret[0].o = kv.second; return; }
}
static void Hashtable_put(VM& vm, Value* args, Value* ret) {
  Hash* h = static_cast<Hash*>(args[0].o);
  if (!h || !args[1].o || !args[2].o) vm.npe();
  for (auto& kv : h->e) if (hashKeyEq(kv.first, args[1].o)) { ret[0].o = kv.second; kv.second = args[2].o; return; }
  h->e.emplace_back(args[1].o, args[2].o);
  ret[0].o = nullptr;
}
static void Hashtable_remove(VM& vm, Value* args, Value* ret) {
  Hash* h = static_cast<Hash*>(args[0].o);
  if (!h || !args[1].o) vm.npe();
  ret[0].o = nullptr;
  for (size_t i = 0; i < h->e.size(); i++) if (hashKeyEq(h->e[i].first, args[1].o)) {
    ret[0].o = h->e[i].second; h->e.erase(h->e.begin() + i); return;
  }
}
static void Hashtable_containsKey(VM& vm, Value* args, Value* ret) {
  Hash* h = static_cast<Hash*>(args[0].o);
  if (!h || !args[1].o) vm.npe();
  ret[0].i = 0;
  for (auto& kv : h->e) if (hashKeyEq(kv.first, args[1].o)) { ret[0].i = 1; return; }
}
static void Hashtable_size(VM& vm, Value* args, Value* ret) {
  Hash* h = static_cast<Hash*>(args[0].o);
  if (!h) vm.npe();
  ret[0].i = (int)h->e.size();
}

// Vector extras
static void Vector_firstElement(VM& vm, Value* args, Value* ret) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  if (v->v.empty()) vm.throwNew("java/lang/RuntimeException", "NoSuchElementException");
  ret[0].o = v->v.front();
}
static void Vector_removeElement(VM& vm, Value* args, Value* ret) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  ret[0].i = 0;
  for (size_t i = 0; i < v->v.size(); i++) if (v->v[i] == args[1].o) { v->v.erase(v->v.begin() + i); ret[0].i = 1; return; }
}

// Thread.<init>() e Thread.run() (subclasses de Thread sobrescrevem run)
static void Thread_init_noargs(VM& vm, Value* args, Value*) {
  if (!args[0].o) vm.npe();
}
static void Thread_run(VM& vm, Value* args, Value*) {
  ThreadObj* t = static_cast<ThreadObj*>(args[0].o);
  if (!t) vm.npe();
  if (t->runnable) { Value r[2]; vm.invokeVirtual(t->runnable, "run:()V", nullptr, 0, r); }
}

// -------------------------------------------------------------
// java/util/Random
// -------------------------------------------------------------
static void Random_init(VM& vm, Value* args, Value*) {
  Rand* r = static_cast<Rand*>(args[0].o);
  if (!r) vm.npe();
  r->seed = (nowMs() ^ 0x5DEECE66DLL) & ((1LL << 48) - 1);
}

static int randNext(Rand* r, int bits) {
  r->seed = (r->seed * 0x5DEECE66DLL + 0xBLL) & ((1LL << 48) - 1);
  return (int)(r->seed >> (48 - bits));
}

static void Random_nextInt_0(VM& vm, Value* args, Value* ret) {
  Rand* r = static_cast<Rand*>(args[0].o);
  if (!r) vm.npe();
  ret[0].i = randNext(r, 32);
}

static void Random_nextInt_1(VM& vm, Value* args, Value* ret) {
  Rand* r = static_cast<Rand*>(args[0].o);
  if (!r) vm.npe();
  int n = args[1].i;
  if (n <= 0) vm.throwNew("java/lang/IllegalArgumentException", "n must be positive");
  if ((n & -n) == n) {
    ret[0].i = (int)((n * (int64_t)randNext(r, 31)) >> 31);
    return;
  }
  int bits, val;
  do {
    bits = randNext(r, 31);
    val = bits % n;
  } while (bits - val + (n - 1) < 0);
  ret[0].i = val;
}

// -------------------------------------------------------------
// java/util/Vector
// -------------------------------------------------------------
static void Vector_init(VM&, Value*, Value*) {}

static void Vector_init_cap(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  int cap = args[1].i;
  if (cap < 0) vm.throwNew("java/lang/IllegalArgumentException");
  v->v.reserve(cap);
}

static void Vector_addElement(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  v->v.push_back(args[1].o);
}

static void Vector_elementAt(VM& vm, Value* args, Value* ret) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  int idx = args[1].i;
  if (idx < 0 || (size_t)idx >= v->v.size()) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException", std::to_string(idx));
  ret[0].o = v->v[idx];
}

static void Vector_elements(VM& vm, Value* args, Value* ret) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  ClassInfo* cenum = vm.mustClass("java/util/VectorEnumeration");
  Enum* e = vm.alloc<Enum>(cenum, K_ENUM);
  e->vec = v;
  e->idx = 0;
  ret[0].o = e;
}

static void Vector_removeAllElements(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  v->v.clear();
}

static void Vector_removeElementAt(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  int idx = args[1].i;
  if (idx < 0 || (size_t)idx >= v->v.size()) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException", std::to_string(idx));
  v->v.erase(v->v.begin() + idx);
}

static void Vector_setSize(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  int ns = args[1].i;
  if (ns < 0) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  v->v.resize(ns, nullptr);
}

static void Vector_size(VM& vm, Value* args, Value* ret) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  ret[0].i = (int)v->v.size();
}

static void Vector_trimToSize(VM& vm, Value* args, Value*) {
  Vec* v = static_cast<Vec*>(args[0].o);
  if (!v) vm.npe();
  v->v.shrink_to_fit();
}

// -------------------------------------------------------------
// java/util/VectorEnumeration
// -------------------------------------------------------------
static void VectorEnumeration_hasMoreElements(VM& vm, Value* args, Value* ret) {
  Enum* e = static_cast<Enum*>(args[0].o);
  if (!e || !e->vec) vm.npe();
  ret[0].i = (e->idx < (int)e->vec->v.size()) ? 1 : 0;
}

static void VectorEnumeration_nextElement(VM& vm, Value* args, Value* ret) {
  Enum* e = static_cast<Enum*>(args[0].o);
  if (!e || !e->vec) vm.npe();
  if (e->idx >= (int)e->vec->v.size()) vm.throwNew("java/util/NoSuchElementException");
  ret[0].o = e->vec->v[e->idx++];
}

// -------------------------------------------------------------
// java/io/ByteArrayInputStream
// -------------------------------------------------------------
static void ByteArrayInputStream_init(VM& vm, Value* args, Value*) {
  Bais* bais = static_cast<Bais*>(args[0].o);
  Array* arr = static_cast<Array*>(args[1].o);
  if (!bais || !arr) vm.npe();
  bais->data.assign(arr->data.begin(), arr->data.end());
  bais->pos = 0;
}

static void ByteArrayInputStream_read_buf(VM& vm, Value* args, Value* ret) {
  Bais* bais = static_cast<Bais*>(args[0].o);
  Array* buf = static_cast<Array*>(args[1].o);
  int off = args[2].i;
  int len = args[3].i;
  if (!bais || !buf) vm.npe();
  if (off < 0 || len < 0 || off + len > buf->len) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  if (bais->pos >= bais->data.size()) { ret[0].i = -1; return; }
  int avail = (int)(bais->data.size() - bais->pos);
  int toRead = std::min(len, avail);
  std::memcpy(buf->data.data() + off, bais->data.data() + bais->pos, toRead);
  bais->pos += toRead;
  ret[0].i = toRead;
}

static void ByteArrayInputStream_read_byte(VM& vm, Value* args, Value* ret) {
  Bais* bais = static_cast<Bais*>(args[0].o);
  if (!bais) vm.npe();
  if (bais->pos >= bais->data.size()) { ret[0].i = -1; return; }
  ret[0].i = bais->data[bais->pos++];
}

static void ByteArrayInputStream_close(VM&, Value*, Value*) {}

static void ByteArrayInputStream_available(VM& vm, Value* args, Value* ret) {
  Bais* bais = static_cast<Bais*>(args[0].o);
  if (!bais) vm.npe();
  ret[0].i = bais->pos >= bais->data.size() ? 0 : (int)(bais->data.size() - bais->pos);
}

// -------------------------------------------------------------
// Stream Writing Helpers
// -------------------------------------------------------------
static Baos* getUnderlyingBaos(VM& vm, Object* out) {
  if (!out) vm.npe();
  if (out->kind == K_BAOS) return static_cast<Baos*>(out);
  if (out->kind == K_DOS) return getUnderlyingBaos(vm, static_cast<Dos*>(out)->out);
  vm.fatal("getUnderlyingBaos: stream não suportado: " + out->cls->name);
  return nullptr;
}

static void streamWrite(VM& vm, Object* out, const uint8_t* bytes, size_t len) {
  Baos* b = getUnderlyingBaos(vm, out);
  if (len > 0 && bytes) {
    b->data.insert(b->data.end(), bytes, bytes + len);
  }
}

static void streamWriteByte(VM& vm, Object* out, uint8_t byte) {
  Baos* b = getUnderlyingBaos(vm, out);
  b->data.push_back(byte);
}

// -------------------------------------------------------------
// java/io/ByteArrayOutputStream
// -------------------------------------------------------------
static void ByteArrayOutputStream_init(VM&, Value*, Value*) {}

static void ByteArrayOutputStream_write_buf(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  Array* buf = static_cast<Array*>(args[1].o);
  int off = args[2].i;
  int len = args[3].i;
  if (!out || !buf) vm.npe();
  if (off < 0 || len < 0 || off + len > buf->len) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  streamWrite(vm, out, buf->data.data() + off, (size_t)len);
}

static void ByteArrayOutputStream_write_buf1(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  Array* buf = static_cast<Array*>(args[1].o);
  if (!out || !buf) vm.npe();
  streamWrite(vm, out, buf->data.data(), (size_t)buf->len);
}

static void ByteArrayOutputStream_write_b(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  if (!out) vm.npe();
  streamWriteByte(vm, out, (uint8_t)args[1].i);
}

static void ByteArrayOutputStream_toByteArray(VM& vm, Value* args, Value* ret) {
  Baos* baos = getUnderlyingBaos(vm, args[0].o);
  Array* arr = vm.newArray('B', (int)baos->data.size());
  if (!baos->data.empty()) std::memcpy(arr->data.data(), baos->data.data(), baos->data.size());
  ret[0].o = arr;
}

static void ByteArrayOutputStream_reset(VM& vm, Value* args, Value*) {
  Baos* baos = getUnderlyingBaos(vm, args[0].o);
  baos->data.clear();
}

static void ByteArrayOutputStream_size(VM& vm, Value* args, Value* ret) {
  Baos* baos = getUnderlyingBaos(vm, args[0].o);
  ret[0].i = (int)baos->data.size();
}

static void ByteArrayOutputStream_close(VM&, Value*, Value*) {}
static void ByteArrayOutputStream_flush(VM&, Value*, Value*) {}

// -------------------------------------------------------------
// java/io/DataInputStream
// -------------------------------------------------------------
static void DataInputStream_init(VM& vm, Value* args, Value*) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  if (!dis) vm.npe();
  dis->in = args[1].o;
}

static Bais* getUnderlyingBais(VM& vm, Object* in) {
  if (!in) vm.npe();
  if (in->kind == K_BAIS) return static_cast<Bais*>(in);
  if (in->kind == K_DIS) return getUnderlyingBais(vm, static_cast<Dis*>(in)->in);
  vm.fatal("DataInputStream wrap de stream não suportado: " + in->cls->name);
  return nullptr;
}

static void DataInputStream_readByte(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos >= b->data.size()) vm.throwNew("java/io/EOFException");
  ret[0].i = (int8_t)b->data[b->pos++];
}

static void DataInputStream_readShort(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos + 2 > b->data.size()) vm.throwNew("java/io/EOFException");
  int b1 = b->data[b->pos++];
  int b2 = b->data[b->pos++];
  ret[0].i = (int16_t)((b1 << 8) | b2);
}

static void DataInputStream_readInt(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos + 4 > b->data.size()) vm.throwNew("java/io/EOFException");
  uint32_t v = ((uint32_t)b->data[b->pos] << 24) |
               ((uint32_t)b->data[b->pos + 1] << 16) |
               ((uint32_t)b->data[b->pos + 2] << 8) |
               ((uint32_t)b->data[b->pos + 3]);
  b->pos += 4;
  ret[0].i = (int32_t)v;
}

static void DataInputStream_readFully(VM& vm, Value* args, Value*) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Array* buf = static_cast<Array*>(args[1].o);
  if (!buf) vm.npe();
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos + buf->len > b->data.size()) vm.throwNew("java/io/EOFException");
  std::memcpy(buf->data.data(), b->data.data() + b->pos, buf->len);
  b->pos += buf->len;
}

static void DataInputStream_read_buf1(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Array* buf = static_cast<Array*>(args[1].o);
  if (!buf) vm.npe();
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos >= b->data.size()) { ret[0].i = -1; return; }
  int avail = (int)(b->data.size() - b->pos);
  int toRead = std::min(buf->len, avail);
  std::memcpy(buf->data.data(), b->data.data() + b->pos, toRead);
  b->pos += toRead;
  ret[0].i = toRead;
}

static void DataInputStream_read_buf3(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Array* buf = static_cast<Array*>(args[1].o);
  int off = args[2].i;
  int len = args[3].i;
  if (!buf) vm.npe();
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (off < 0 || len < 0 || off + len > buf->len) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  if (b->pos >= b->data.size()) { ret[0].i = -1; return; }
  int avail = (int)(b->data.size() - b->pos);
  int toRead = std::min(len, avail);
  std::memcpy(buf->data.data() + off, b->data.data() + b->pos, toRead);
  b->pos += toRead;
  ret[0].i = toRead;
}

static void DataInputStream_readUTF(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (b->pos + 2 > b->data.size()) vm.throwNew("java/io/EOFException");
  uint16_t utflen = (b->data[b->pos] << 8) | b->data[b->pos + 1];
  b->pos += 2;
  if (b->pos + utflen > b->data.size()) vm.throwNew("java/io/EOFException");
  std::string s((const char*)b->data.data() + b->pos, utflen);
  b->pos += utflen;
  ret[0].o = vm.newStrUtf8(s);
}

static void DataInputStream_reset(VM& vm, Value* args, Value*) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  Bais* b = getUnderlyingBais(vm, dis->in);
  b->pos = 0;
}

static void DataInputStream_skip(VM& vm, Value* args, Value* ret) {
  Dis* dis = static_cast<Dis*>(args[0].o);
  int64_t n = args[1].l;
  Bais* b = getUnderlyingBais(vm, dis->in);
  if (n <= 0) { ret[0].l = 0; return; }
  size_t avail = (b->pos < b->data.size()) ? (b->data.size() - b->pos) : 0;
  size_t toSkip = (size_t)std::min<int64_t>(n, avail);
  b->pos += toSkip;
  ret[0].l = (int64_t)toSkip;
}

static void DataInputStream_close(VM&, Value*, Value*) {}

// -------------------------------------------------------------
// java/io/DataOutputStream
// -------------------------------------------------------------
static void DataOutputStream_init(VM& vm, Value* args, Value*) {
  Dos* dos = static_cast<Dos*>(args[0].o);
  if (!dos) vm.npe();
  dos->out = args[1].o;
}

static void DataOutputStream_writeByte(VM& vm, Value* args, Value*) {
  streamWriteByte(vm, args[0].o, (uint8_t)args[1].i);
}

static void DataOutputStream_writeShort(VM& vm, Value* args, Value*) {
  int v = args[1].i;
  uint8_t b[2] = { (uint8_t)(v >> 8), (uint8_t)v };
  streamWrite(vm, args[0].o, b, 2);
}

static void DataOutputStream_writeInt(VM& vm, Value* args, Value*) {
  uint32_t v = (uint32_t)args[1].i;
  uint8_t b[4] = { (uint8_t)(v >> 24), (uint8_t)(v >> 16), (uint8_t)(v >> 8), (uint8_t)v };
  streamWrite(vm, args[0].o, b, 4);
}

static void DataOutputStream_writeBoolean(VM& vm, Value* args, Value*) {
  streamWriteByte(vm, args[0].o, args[1].i ? 1 : 0);
}

static void DataOutputStream_writeChar(VM& vm, Value* args, Value*) {
  int v = args[1].i;
  uint8_t b[2] = { (uint8_t)(v >> 8), (uint8_t)v };
  streamWrite(vm, args[0].o, b, 2);
}

static void DataOutputStream_writeUTF(VM& vm, Value* args, Value*) {
  Object* strObj = args[1].o;
  if (!strObj) vm.npe();
  std::string s = toUtf8(static_cast<Str*>(strObj)->s);
  if (s.size() > 65535) vm.throwNew("java/io/UTFDataFormatException");
  uint16_t sz = (uint16_t)s.size();
  uint8_t hdr[2] = { (uint8_t)(sz >> 8), (uint8_t)sz };
  streamWrite(vm, args[0].o, hdr, 2);
  streamWrite(vm, args[0].o, (const uint8_t*)s.data(), sz);
}

static void DataOutputStream_close(VM&, Value*, Value*) {}
static void DataOutputStream_flush(VM&, Value*, Value*) {}

// -------------------------------------------------------------
// java/io/InputStream / OutputStream / PrintStream
// -------------------------------------------------------------
static void InputStream_read_b(VM& vm, Value* args, Value* ret) {
  ByteArrayInputStream_read_byte(vm, args, ret);
}

static void InputStream_read_buf1(VM& vm, Value* args, Value* ret) {
  Bais* bais = static_cast<Bais*>(args[0].o);
  Array* buf = static_cast<Array*>(args[1].o);
  Value subArgs[4];
  subArgs[0].o = bais;
  subArgs[1].o = buf;
  subArgs[2].i = 0;
  subArgs[3].i = buf ? buf->len : 0;
  ByteArrayInputStream_read_buf(vm, subArgs, ret);
}

static void InputStream_skip(VM& vm, Value* args, Value* ret) {
  Bais* b = static_cast<Bais*>(args[0].o);
  int64_t n = args[1].l;
  if (!b) vm.npe();
  if (n <= 0) { ret[0].l = 0; return; }
  size_t avail = (b->pos < b->data.size()) ? (b->data.size() - b->pos) : 0;
  size_t toSkip = (size_t)std::min<int64_t>(n, avail);
  b->pos += toSkip;
  ret[0].l = (int64_t)toSkip;
}

static void InputStream_close(VM&, Value*, Value*) {}

static void OutputStream_write_buf(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  Array* arr = static_cast<Array*>(args[1].o);
  if (!out || !arr) vm.npe();
  streamWrite(vm, out, arr->data.data(), (size_t)arr->len);
}

static void OutputStream_write_buf3(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  Array* buf = static_cast<Array*>(args[1].o);
  int off = args[2].i;
  int len = args[3].i;
  if (!out || !buf) vm.npe();
  if (off < 0 || len < 0 || off + len > buf->len) vm.throwNew("java/lang/ArrayIndexOutOfBoundsException");
  streamWrite(vm, out, buf->data.data() + off, (size_t)len);
}

static void OutputStream_write_b(VM& vm, Value* args, Value*) {
  Object* out = args[0].o;
  if (!out) vm.npe();
  streamWriteByte(vm, out, (uint8_t)args[1].i);
}

static void OutputStream_close(VM&, Value*, Value*) {}
static void OutputStream_flush(VM&, Value*, Value*) {}

static void PrintStream_println_obj(VM& vm, Value* args, Value*) {
  Object* o = args[1].o;
  if (!o) printf("null\n");
  else if (o->kind == K_STRING) printf("%s\n", getStrUtf8(o).c_str());
  else {
    Value vr[2];
    vm.invokeVirtual(o, "toString:()Ljava/lang/String;", nullptr, 0, vr);
    printf("%s\n", getStrUtf8(vr[0].o).c_str());
  }
}

static void PrintStream_println_str(VM&, Value* args, Value*) {
  printf("%s\n", getStrUtf8(args[1].o).c_str());
}

[[maybe_unused]] static void aj_draw_native(VM& vm, Value* args, Value*);
[[maybe_unused]] static void bl_a_native(VM& vm, Value* args, Value* ret);
[[maybe_unused]] static void bl_draw_native(VM& vm, Value* args, Value*);
[[maybe_unused]] static void bf_draw_native(VM& vm, Value* args, Value*);
[[maybe_unused]] static void bx_draw_native(VM& vm, Value* args, Value*);
static void l_init_native(VM& vm, Value* args, Value* ret);
static void l_a_native(VM& vm, Value* args, Value* ret);
static void l_draw_native(VM& vm, Value* args, Value* ret);
static void l_cursor_native(VM& vm, Value* args, Value* ret);

// -------------------------------------------------------------
// Registro de todos os métodos nativos
// -------------------------------------------------------------
void VM::registerNatives() {
  auto reg = [this](const std::string& key, NativeFn fn) {
    natives[key] = fn;
  };

  // java/lang/Object
  reg("java/lang/Object.<init>:()V", Object_init);
  reg("java/lang/Object.equals:(Ljava/lang/Object;)Z", Object_equals);
  reg("java/lang/Object.getClass:()Ljava/lang/Class;", Object_getClass);
  reg("java/lang/Object.toString:()Ljava/lang/String;", Object_toString);

  // java/lang/Class
  reg("java/lang/Class.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;", Class_getResourceAsStream);
  reg("java/lang/Class.getName:()Ljava/lang/String;", Class_getName);

  // java/lang/String
  reg("java/lang/String.<init>:()V", String_init);
  reg("java/lang/String.<init>:([BII)V", String_init_bytes);
  reg("java/lang/String.<init>:([C)V", String_init_chars);
  reg("java/lang/String.<init>:([CII)V", String_init_chars_offset);
  reg("java/lang/String.<init>:(Ljava/lang/String;)V", String_init_str);
  reg("java/lang/String.charAt:(I)C", String_charAt);
  reg("java/lang/String.compareTo:(Ljava/lang/String;)I", String_compareTo);
  reg("java/lang/String.endsWith:(Ljava/lang/String;)Z", String_endsWith);
  reg("java/lang/String.equals:(Ljava/lang/Object;)Z", String_equals);
  reg("java/lang/String.indexOf:(I)I", String_indexOf_ch);
  reg("java/lang/String.indexOf:(Ljava/lang/String;)I", String_indexOf_str);
  reg("java/lang/String.length:()I", String_length);
  reg("java/lang/String.replace:(CC)Ljava/lang/String;", String_replace);
  reg("java/lang/String.startsWith:(Ljava/lang/String;)Z", String_startsWith);
  reg("java/lang/String.substring:(I)Ljava/lang/String;", String_substring_1);
  reg("java/lang/String.substring:(II)Ljava/lang/String;", String_substring_2);
  reg("java/lang/String.toCharArray:()[C", String_toCharArray);
  reg("java/lang/String.toLowerCase:()Ljava/lang/String;", String_toLowerCase);
  reg("java/lang/String.toUpperCase:()Ljava/lang/String;", String_toUpperCase);
  reg("java/lang/String.trim:()Ljava/lang/String;", String_trim);
  reg("java/lang/String.valueOf:([C)Ljava/lang/String;", String_valueOf_chars);
  reg("java/lang/String.valueOf:(I)Ljava/lang/String;", String_valueOf_int);

  // java/lang/StringBuffer
  reg("java/lang/StringBuffer.<init>:()V", StringBuffer_init);
  reg("java/lang/StringBuffer.<init>:(Ljava/lang/String;)V", StringBuffer_init_str);
  reg("java/lang/StringBuffer.append:([C)Ljava/lang/StringBuffer;", StringBuffer_append_chars);
  reg("java/lang/StringBuffer.append:(C)Ljava/lang/StringBuffer;", StringBuffer_append_char);
  reg("java/lang/StringBuffer.append:(I)Ljava/lang/StringBuffer;", StringBuffer_append_int);
  reg("java/lang/StringBuffer.append:(Ljava/lang/Object;)Ljava/lang/StringBuffer;", StringBuffer_append_obj);
  reg("java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;", StringBuffer_append_str);
  reg("java/lang/StringBuffer.charAt:(I)C", StringBuffer_charAt);
  reg("java/lang/StringBuffer.delete:(II)Ljava/lang/StringBuffer;", StringBuffer_delete);
  reg("java/lang/StringBuffer.getChars:(II[CI)V", StringBuffer_getChars);
  reg("java/lang/StringBuffer.length:()I", StringBuffer_length);
  reg("java/lang/StringBuffer.setCharAt:(IC)V", StringBuffer_setCharAt);
  reg("java/lang/StringBuffer.toString:()Ljava/lang/String;", StringBuffer_toString);

  // java/lang/System
  reg("java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V", System_arraycopy);
  reg("java/lang/System.currentTimeMillis:()J", System_currentTimeMillis);
  reg("java/lang/System.gc:()V", System_gc);
  reg("java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;", System_getProperty);

  // java/lang/Math
  reg("java/lang/Math.abs:(I)I", Math_abs);
  reg("java/lang/Math.min:(II)I", Math_min);

  // java/lang/Integer
  reg("java/lang/Integer.parseInt:(Ljava/lang/String;)I", Integer_parseInt_1);
  reg("java/lang/Integer.parseInt:(Ljava/lang/String;I)I", Integer_parseInt_2);

  // java/lang/Runtime
  reg("java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;", Runtime_getRuntime);
  reg("java/lang/Runtime.gc:()V", Runtime_gc);

  // java/lang/Thread
  reg("java/lang/Thread.<init>:(Ljava/lang/Runnable;)V", Thread_init);
  reg("java/lang/Thread.sleep:(J)V", Thread_sleep);
  reg("java/lang/Thread.start:()V", Thread_start);
  reg("java/lang/Thread.yield:()V", Thread_yield);

  // java/lang/Throwable
  reg("java/lang/Throwable.printStackTrace:()V", Throwable_printStackTrace);
  reg("java/lang/Throwable.toString:()Ljava/lang/String;", Throwable_toString);
  reg("java/lang/Throwable.<init>:()V", Throwable_init);
  reg("java/lang/Throwable.<init>:(Ljava/lang/String;)V", Throwable_init_msg);
  reg("java/lang/Throwable.getMessage:()Ljava/lang/String;", Throwable_getMessage);
  reg("java/lang/Object.wait:(J)V", Object_wait);
  reg("java/lang/Object.notify:()V", Object_notify);
  reg("java/lang/Object.notifyAll:()V", Object_notify);
  reg("java/lang/String.<init>:([B)V", String_init_bytes_all);
  reg("java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;", String_concat);
  reg("java/lang/String.getBytes:()[B", String_getBytes);
  reg("java/lang/String.hashCode:()I", String_hashCode);
  reg("java/lang/String.lastIndexOf:(I)I", String_lastIndexOf_ch);
  reg("java/lang/StringBuffer.append:(J)Ljava/lang/StringBuffer;", StringBuffer_append_long);
  reg("java/util/Hashtable.<init>:()V", Hashtable_init);
  reg("java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;", Hashtable_get);
  reg("java/util/Hashtable.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", Hashtable_put);
  reg("java/util/Hashtable.remove:(Ljava/lang/Object;)Ljava/lang/Object;", Hashtable_remove);
  reg("java/util/Hashtable.containsKey:(Ljava/lang/Object;)Z", Hashtable_containsKey);
  reg("java/util/Hashtable.size:()I", Hashtable_size);
  reg("java/util/Vector.firstElement:()Ljava/lang/Object;", Vector_firstElement);
  reg("java/util/Vector.removeElement:(Ljava/lang/Object;)Z", Vector_removeElement);
  reg("java/lang/Thread.<init>:()V", Thread_init_noargs);
  reg("java/lang/Thread.run:()V", Thread_run);

  // java/util/Random
  reg("java/util/Random.<init>:()V", Random_init);
  reg("java/util/Random.nextInt:()I", Random_nextInt_0);
  reg("java/util/Random.nextInt:(I)I", Random_nextInt_1);

  // java/util/Vector
  reg("java/util/Vector.<init>:()V", Vector_init);
  reg("java/util/Vector.<init>:(I)V", Vector_init_cap);
  reg("java/util/Vector.addElement:(Ljava/lang/Object;)V", Vector_addElement);
  reg("java/util/Vector.elementAt:(I)Ljava/lang/Object;", Vector_elementAt);
  reg("java/util/Vector.elements:()Ljava/util/Enumeration;", Vector_elements);
  reg("java/util/Vector.removeAllElements:()V", Vector_removeAllElements);
  reg("java/util/Vector.removeElementAt:(I)V", Vector_removeElementAt);
  reg("java/util/Vector.setSize:(I)V", Vector_setSize);
  reg("java/util/Vector.size:()I", Vector_size);
  reg("java/util/Vector.trimToSize:()V", Vector_trimToSize);

  // java/util/VectorEnumeration
  reg("java/util/VectorEnumeration.hasMoreElements:()Z", VectorEnumeration_hasMoreElements);
  reg("java/util/VectorEnumeration.nextElement:()Ljava/lang/Object;", VectorEnumeration_nextElement);

  // java/io/ByteArrayInputStream
  reg("java/io/ByteArrayInputStream.<init>:([B)V", ByteArrayInputStream_init);
  reg("java/io/ByteArrayInputStream.read:([BII)I", ByteArrayInputStream_read_buf);
  reg("java/io/ByteArrayInputStream.read:()I", ByteArrayInputStream_read_byte);
  reg("java/io/ByteArrayInputStream.close:()V", ByteArrayInputStream_close);
  reg("java/io/ByteArrayInputStream.available:()I", ByteArrayInputStream_available);

  // java/io/ByteArrayOutputStream
  reg("java/io/ByteArrayOutputStream.<init>:()V", ByteArrayOutputStream_init);
  reg("java/io/ByteArrayOutputStream.write:([BII)V", ByteArrayOutputStream_write_buf);
  reg("java/io/ByteArrayOutputStream.write:([B)V", ByteArrayOutputStream_write_buf1);
  reg("java/io/ByteArrayOutputStream.write:(I)V", ByteArrayOutputStream_write_b);
  reg("java/io/ByteArrayOutputStream.toByteArray:()[B", ByteArrayOutputStream_toByteArray);
  reg("java/io/ByteArrayOutputStream.reset:()V", ByteArrayOutputStream_reset);
  reg("java/io/ByteArrayOutputStream.size:()I", ByteArrayOutputStream_size);
  reg("java/io/ByteArrayOutputStream.close:()V", ByteArrayOutputStream_close);
  reg("java/io/ByteArrayOutputStream.flush:()V", ByteArrayOutputStream_flush);

  // java/io/DataInputStream
  reg("java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V", DataInputStream_init);
  reg("java/io/DataInputStream.readByte:()B", DataInputStream_readByte);
  reg("java/io/DataInputStream.readShort:()S", DataInputStream_readShort);
  reg("java/io/DataInputStream.readInt:()I", DataInputStream_readInt);
  reg("java/io/DataInputStream.readFully:([B)V", DataInputStream_readFully);
  reg("java/io/DataInputStream.read:([B)I", DataInputStream_read_buf1);
  reg("java/io/DataInputStream.read:([BII)I", DataInputStream_read_buf3);
  reg("java/io/DataInputStream.readUTF:()Ljava/lang/String;", DataInputStream_readUTF);
  reg("java/io/DataInputStream.reset:()V", DataInputStream_reset);
  reg("java/io/DataInputStream.skip:(J)J", DataInputStream_skip);
  reg("java/io/DataInputStream.close:()V", DataInputStream_close);

  // java/io/DataOutputStream
  reg("java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V", DataOutputStream_init);
  reg("java/io/DataOutputStream.writeByte:(I)V", DataOutputStream_writeByte);
  reg("java/io/DataOutputStream.writeShort:(I)V", DataOutputStream_writeShort);
  reg("java/io/DataOutputStream.writeInt:(I)V", DataOutputStream_writeInt);
  reg("java/io/DataOutputStream.writeBoolean:(Z)V", DataOutputStream_writeBoolean);
  reg("java/io/DataOutputStream.writeChar:(I)V", DataOutputStream_writeChar);
  reg("java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V", DataOutputStream_writeUTF);
  reg("java/io/DataOutputStream.write:([B)V", OutputStream_write_buf);
  reg("java/io/DataOutputStream.write:([BII)V", OutputStream_write_buf3);
  reg("java/io/DataOutputStream.write:(I)V", OutputStream_write_b);
  reg("java/io/DataOutputStream.close:()V", DataOutputStream_close);
  reg("java/io/DataOutputStream.flush:()V", DataOutputStream_flush);

  // java/io/InputStream
  reg("java/io/InputStream.read:()I", InputStream_read_b);
  reg("java/io/InputStream.read:([B)I", InputStream_read_buf1);
  reg("java/io/InputStream.skip:(J)J", InputStream_skip);
  reg("java/io/InputStream.close:()V", InputStream_close);

  // java/io/OutputStream
  reg("java/io/OutputStream.write:([B)V", OutputStream_write_buf);
  reg("java/io/OutputStream.write:([BII)V", OutputStream_write_buf3);
  reg("java/io/OutputStream.write:(I)V", OutputStream_write_b);
  reg("java/io/OutputStream.close:()V", OutputStream_close);
  reg("java/io/OutputStream.flush:()V", OutputStream_flush);

  // java/io/PrintStream
  reg("java/io/PrintStream.println:(Ljava/lang/Object;)V", PrintStream_println_obj);
  reg("java/io/PrintStream.println:(Ljava/lang/String;)V", PrintStream_println_str);

  // HL2: Menu de Configurações personalizadas (l.class) com FPS, Proporção de Tela e Cloud Save
  reg("l.<init>:(Lg;Z)V", l_init_native);
  reg("l.a:(II)Z", l_a_native);
  reg("l.a:(II)V", l_draw_native);
  reg("l.b:(II)V", l_cursor_native);
}

// -------------------------------------------------------------
// aj: Cenário / Objetos decorativos do mapa (Wind of Soltia)
// -------------------------------------------------------------
[[maybe_unused]] static void aj_draw_native(VM& vm, Value* args, Value*) {
  Object* selfObj = args[0].o;
  if (!selfObj || selfObj->kind != K_INST || !selfObj->cls || selfObj->cls->name != "aj") return;
  Instance* inst = static_cast<Instance*>(selfObj);

  Object* gObj = args[1].o;
  if (!gObj || gObj->kind != K_GRAPHICS) return;
  GraphicsObj* g = static_cast<GraphicsObj*>(gObj);

  int n2 = args[2].i;
  int n3 = args[3].i;

  static int s_idx_img = -1;
  static int s_idx_cS = -1;
  static int s_idx_cB = -1;
  static int s_idx_dS = -1;
  static int s_idx_dB = -1;

  if (s_idx_img == -1 && selfObj->cls) {
    FieldInfo* f = vm.findField(selfObj->cls, "a:Ljavax/microedition/lcdui/Image;");
    if (f) s_idx_img = f->index;
    f = vm.findField(selfObj->cls, "c:S");
    if (f) s_idx_cS = f->index;
    f = vm.findField(selfObj->cls, "c:B");
    if (f) s_idx_cB = f->index;
    f = vm.findField(selfObj->cls, "d:S");
    if (f) s_idx_dS = f->index;
    f = vm.findField(selfObj->cls, "d:B");
    if (f) s_idx_dB = f->index;
  }

  int16_t cS = (s_idx_cS >= 0 && s_idx_cS < (int)inst->f.size()) ? (int16_t)inst->f[s_idx_cS].i : 0;
  int8_t  cB = (s_idx_cB >= 0 && s_idx_cB < (int)inst->f.size()) ? (int8_t)inst->f[s_idx_cB].i : 0;
  int16_t dS = (s_idx_dS >= 0 && s_idx_dS < (int)inst->f.size()) ? (int16_t)inst->f[s_idx_dS].i : 0;
  int8_t  dB = (s_idx_dB >= 0 && s_idx_dB < (int)inst->f.size()) ? (int8_t)inst->f[s_idx_dB].i : 0;

  Object* imgObj = (s_idx_img >= 0 && s_idx_img < (int)inst->f.size()) ? inst->f[s_idx_img].o : nullptr;
  if (!imgObj || imgObj->kind != K_IMAGE) return;
  ImageObj* img = static_cast<ImageObj*>(imgObj);

  int n4 = n2 + cS + cB;
  int n5 = n3 + dS + dB;

  // Culling dinâmico baseado na largura e altura reais da tela atual (evita corte em widescreen)
  int minX = -(img->width >> 1);
  int maxX = g_screenWidth + (img->width >> 1);
  int minY = 0;
  int maxY = g_screenHeight + img->height;

  if (n4 < minX || n4 > maxX || n5 < minY || n5 > maxY) {
    return;
  }

  g->drawImage(img, n4, n5, 33);
}

// -------------------------------------------------------------
// bl: Tela 'Sobre' / Créditos (Wind of Soltia)
// -------------------------------------------------------------
[[maybe_unused]] static void bl_a_native(VM& vm, Value* args, Value* ret) {
  Object* self = args[0].o;
  int n2 = args[1].i; // GameAction ou arg1
  int n3 = args[2].i; // KeyCode ou arg2

  // Qualquer variante da tecla '5' (53), Enter (13), Fire (8 / -5) ou Action (1) dispara a checagem OTA
  if (n3 == 53 || n2 == 53 || n3 == 8 || n2 == 8 || n3 == -5 || n2 == -5 || n3 == 13 || n2 == 13 || n3 == 1 || n2 == 1) {
    Platform::checkForUpdates();
    ret[0].i = 1;
    return;
  }

  // 1. Invoca this.b(n2, n3)
  Value subArgs[2];
  subArgs[0].i = n2;
  subArgs[1].i = n3;
  Value subRet[2];
  vm.invokeVirtual(self, "b:(II)Z", subArgs, 2, subRet);
  if (subRet[0].i != 0) {
    ret[0].i = 1;
    return;
  }

  // 2. Invoca this.c(n2, n3)
  vm.invokeVirtual(self, "c:(II)Z", subArgs, 2, subRet);
  if (subRet[0].i != 0) {
    ret[0].i = 1;
    return;
  }

  // 3. Se tecla RSK (bh.var_int_a), fecha a tela de Sobre
  ClassInfo* bhClass = vm.findClass("bh");
  int rskKey = -7;
  if (bhClass) {
    FieldInfo* fRsk = vm.findField(bhClass, "a:I");
    if (fRsk && fRsk->isStatic && fRsk->index >= 0 && fRsk->index < (int)bhClass->statics.size()) {
      rskKey = bhClass->statics[fRsk->index].i;
    }
  }

  if (n3 == rskKey) {
    ClassInfo* cbClass = vm.mustClass("cb");
    FieldInfo* fCbA = vm.findField(cbClass, "a:Lcb;");
    if (fCbA && !fCbA->isStatic && self && self->kind == K_INST) {
      Instance* inst = static_cast<Instance*>(self);
      if (fCbA->index >= 0 && fCbA->index < (int)inst->f.size()) {
        Object* parentCb = inst->f[fCbA->index].o;
        if (parentCb && parentCb->cls) {
          Value pRet[2];
          vm.invokeVirtual(parentCb, "a:()V", nullptr, 0, pRet);
        }
      }
    }

    if (bhClass) {
      FieldInfo* fbA = vm.findField(bhClass, "a:Lb;");
      FieldInfo* fbB = vm.findField(bhClass, "b:Lb;");
      FieldInfo* fbC = vm.findField(bhClass, "c:Lb;");
      auto setFlag = [&](FieldInfo* fi) {
        if (fi && fi->isStatic && fi->index >= 0 && fi->index < (int)bhClass->statics.size()) {
          Object* bObj = bhClass->statics[fi->index].o;
          if (bObj && bObj->kind == K_INST && bObj->cls) {
            FieldInfo* fBoolB = vm.findField(bObj->cls, "b:Z");
            if (fBoolB && fBoolB->index >= 0 && fBoolB->index < (int)static_cast<Instance*>(bObj)->f.size()) {
              static_cast<Instance*>(bObj)->f[fBoolB->index].i = 1;
            }
          }
        }
      };
      setFlag(fbA); setFlag(fbB); setFlag(fbC);
    }
  }

  ret[0].i = 1;
}

// -------------------------------------------------------------
// bl: Renderização da Tela 'Sobre' / Créditos (Wind of Soltia)
// -------------------------------------------------------------
[[maybe_unused]] static void bl_draw_native(VM& vm, Value* args, Value*) {
  Object* selfObj = args[0].o;
  if (!selfObj || selfObj->kind != K_INST) return;
  Instance* inst = static_cast<Instance*>(selfObj);

  Object* gObj = args[1].o;
  if (!gObj || gObj->kind != K_GRAPHICS) return;
  GraphicsObj* g = static_cast<GraphicsObj*>(gObj);

  // Calcula coordenadas perfeitamente centradas na largura e altura ativas (240x320 ou 568x320)
  const int scrollW = 201;
  int n2 = (g_screenWidth - scrollW) / 2;
  int n3 = (g_screenHeight - 244) / 2;
  if (n3 < 6) n3 = 6;
  int centerX = n2 + (scrollW / 2);

  // 1. Fundo roxo medieval de Soltia preenchendo a tela inteira (0x3F1F3F)
  g->setColor(0x3F1F3F);
  g->fillRect(0, 0, g_screenWidth, g_screenHeight);

  // 2. Aba superior com placa 'SOBRE' (bf.c)
  ClassInfo* bfClass = vm.findClass("bf");
  Method* mBfC = bfClass ? vm.findMethod(bfClass, "c:(Ljavax/microedition/lcdui/Graphics;II)V") : nullptr;
  if (mBfC) {
    Value cArgs[3]; cArgs[0].o = gObj; cArgs[1].i = n2; cArgs[2].i = n3; Value cRet[2];
    vm.invoke(mBfC, cArgs, cRet);
  }

  // 3. Título 'SOBRE' (string id 9) desenhado no centro exato do pergaminho
  ClassInfo* bhClass = vm.findClass("bh");
  Method* mBhA = bhClass ? vm.findMethod(bhClass, "a:(Ljavax/microedition/lcdui/Graphics;III)V") : nullptr;
  if (mBhA) {
    Value tArgs[4]; tArgs[0].o = gObj; tArgs[1].i = 9; tArgs[2].i = centerX; tArgs[3].i = n3 + 5; Value tRet[2];
    vm.invoke(mBhA, tArgs, tRet);
  }

  // 4. Pergaminho principal (bf.b com 4 repetições para abrigar todas as 10 linhas confortavelmente)
  Method* mBfB = bfClass ? vm.findMethod(bfClass, "b:(Ljavax/microedition/lcdui/Graphics;III)V") : nullptr;
  if (mBfB) {
    Value bArgs[4]; bArgs[0].o = gObj; bArgs[1].i = n2; bArgs[2].i = n3 + 20; bArgs[3].i = 4; Value bRet[2];
    vm.invoke(mBfB, bArgs, bRet);
  }

  int textN2 = n2 + 12;
  int textN3 = n3 + 42;

  // 5. Setas de rolagem de página se houver mais de 1 página
  FieldInfo* fByteA = vm.findField(inst->cls, "a:B");
  FieldInfo* fByteB = vm.findField(inst->cls, "b:B");
  int pageCount = (fByteA && fByteA->index >= 0 && fByteA->index < (int)inst->f.size()) ? inst->f[fByteA->index].i : 1;
  int curPage   = (fByteB && fByteB->index >= 0 && fByteB->index < (int)inst->f.size()) ? inst->f[fByteB->index].i : 0;

  ClassInfo* ceClass = vm.findClass("ce");
  if (pageCount > 1 && ceClass) {
    if (curPage > 0) {
      FieldInfo* fImgL = vm.findField(ceClass, "l:Ljavax/microedition/lcdui/Image;");
      if (fImgL && fImgL->isStatic && fImgL->index >= 0 && fImgL->index < (int)ceClass->statics.size()) {
        ImageObj* imgL = static_cast<ImageObj*>(ceClass->statics[fImgL->index].o);
        if (imgL) g->drawImage(imgL, textN2 + 62 + 13, textN3 - 6, 20);
      }
    }
    if (curPage < pageCount - 1) {
      FieldInfo* fImgO = vm.findField(ceClass, "o:Ljavax/microedition/lcdui/Image;");
      if (fImgO && fImgO->isStatic && fImgO->index >= 0 && fImgO->index < (int)ceClass->statics.size()) {
        ImageObj* imgO = static_cast<ImageObj*>(ceClass->statics[fImgO->index].o);
        if (imgO) g->drawImage(imgO, textN2 + 62 + 13, textN3 + 114 + 26 + 40, 20);
      }
    }
  }

  // 6. Indicador de página [1/1] no canto superior direito do pergaminho (r.d)
  ClassInfo* rClass = vm.findClass("r");
  Method* mRD = rClass ? vm.findMethod(rClass, "d:(Ljavax/microedition/lcdui/Graphics;IIII)V") : nullptr;
  if (mRD) {
    Value dArgs[5];
    dArgs[0].o = gObj;
    dArgs[1].i = n2 + scrollW - 25;
    dArgs[2].i = textN3 - 8;
    dArgs[3].i = curPage + 1;
    dArgs[4].i = pageCount;
    Value dRet[2];
    vm.invoke(mRD, dArgs, dRet);
  }

  // 7. Texto dos créditos perfeitamente centralizado no pergaminho (bh.b)
  FieldInfo* fCharArrA = vm.findField(inst->cls, "a:[C");
  FieldInfo* fShortArrA = vm.findField(inst->cls, "a:[S");
  Array* charArr = (fCharArrA && fCharArrA->index >= 0 && fCharArrA->index < (int)inst->f.size()) ? static_cast<Array*>(inst->f[fCharArrA->index].o) : nullptr;
  Array* shortArr = (fShortArrA && fShortArrA->index >= 0 && fShortArrA->index < (int)inst->f.size()) ? static_cast<Array*>(inst->f[fShortArrA->index].o) : nullptr;

  if (charArr && shortArr && curPage >= 0 && curPage < shortArr->len) {
    int s3 = shortArr->as<int16_t>()[curPage];
    int s2 = (curPage == pageCount - 1) ? charArr->len : shortArr->as<int16_t>()[curPage + 1];
    if (charArr->len > 0 && charArr->as<uint16_t>()[0] == '!' && s3 == 0) s3 = 1;

    g->setColor(0);
    Method* mBhB = bhClass ? vm.findMethod(bhClass, "b:(Ljavax/microedition/lcdui/Graphics;IIII[CIII)V") : nullptr;
    if (mBhB) {
      Value bTextArgs[9];
      bTextArgs[0].o = gObj;
      bTextArgs[1].i = centerX;
      bTextArgs[2].i = textN3 + 22;
      bTextArgs[3].i = 176;
      bTextArgs[4].i = 1;
      bTextArgs[5].o = charArr;
      bTextArgs[6].i = s3;
      bTextArgs[7].i = 0;
      bTextArgs[8].i = s2 - s3;
      Value bTextRet[2];
      vm.invoke(mBhB, bTextArgs, bTextRet);
    }
  }

  // 8. Softkeys no rodapé: [5 / A] ATUALIZAR (esquerda) e VOLTAR (direita)
  Method* mBhSoftkey = bhClass ? vm.findMethod(bhClass, "a:(Ljavax/microedition/lcdui/Graphics;[C[C)V") : nullptr;
  if (mBhSoftkey) {
    FieldInfo* fCharArrE = vm.findField(bhClass, "e:[C");
    Object* eObj = (fCharArrE && fCharArrE->isStatic && fCharArrE->index >= 0 && fCharArrE->index < (int)bhClass->statics.size()) ? bhClass->statics[fCharArrE->index].o : nullptr;

    std::string lskText = "[5 / A] ATUALIZAR";
    Array* lskArr = vm.newArray('C', (int)lskText.size());
    for (size_t i = 0; i < lskText.size(); ++i) {
      lskArr->as<uint16_t>()[i] = (uint16_t)(uint8_t)lskText[i];
    }

    Value sArgs[3]; sArgs[0].o = gObj; sArgs[1].o = lskArr; sArgs[2].o = eObj; Value sRet[2];
    vm.invoke(mBhSoftkey, sArgs, sRet);
  }
}

// -------------------------------------------------------------
// bf: Renderização do Menu Principal (Wind of Soltia)
// Corrige o cálculo da posição X do cometa de seleção (faixa vermelha)
// que em Java 2007 sofria com erro de precedência de operadores (+ antes de >>)
// e os textos das opções em True Widescreen 16:9
// -------------------------------------------------------------
[[maybe_unused]] static void bf_draw_native(VM& vm, Value* args, Value*) {
  Object* selfObj = args[0].o;
  if (!selfObj || selfObj->kind != K_INST) return;
  Instance* inst = static_cast<Instance*>(selfObj);

  Object* gObj = args[1].o;
  if (!gObj || gObj->kind != K_GRAPHICS) return;
  GraphicsObj* g = static_cast<GraphicsObj*>(gObj);

  int n2 = args[2].i;
  int n3 = args[3].i;

  // 1. Fundo roxo medieval de Soltia preenchendo a tela inteira (0x3F1F3F)
  g->setColor(0x3F1F3F);
  g->fillRect(0, 0, g_screenWidth, g_screenHeight);

  // 2. Pergaminho principal (bf.b com 4 blocos verticais)
  n3 += 13;
  ClassInfo* bfClass = vm.findClass("bf");
  Method* mBfB = bfClass ? vm.findMethod(bfClass, "b:(Ljavax/microedition/lcdui/Graphics;III)V") : nullptr;
  if (mBfB) {
    Value bArgs[4];
    bArgs[0].o = gObj;
    bArgs[1].i = n2;
    bArgs[2].i = n3 - 12;
    bArgs[3].i = 4;
    Value bRet[2];
    vm.invoke(mBfB, bArgs, bRet);
  }

  n3 += 35;
  if (g_screenHeight <= 160) {
    n3 -= 10;
  }

  // 3. Lê o estado da animação da faixa vermelha (campo private byte c de bf)
  FieldInfo* fByteC = vm.findField(inst->cls, "c:B");
  int animStep = (fByteC && fByteC->index >= 0 && fByteC->index < (int)inst->f.size()) ? inst->f[fByteC->index].i : 2;

  int cometIndex = 18;
  if (animStep == 0) {
    cometIndex = 14;
  } else if (animStep == 1) {
    cometIndex = 16;
  }

  // 4. Obtém a imagem do cometa vermelho de ce.k[cometIndex]
  ClassInfo* ceClass = vm.findClass("ce");
  ImageObj* cometImg = nullptr;
  if (ceClass) {
    FieldInfo* fImgK = vm.findField(ceClass, "k:[Ljavax/microedition/lcdui/Image;");
    if (fImgK && fImgK->isStatic && fImgK->index >= 0 && fImgK->index < (int)ceClass->statics.size()) {
      Array* arrK = static_cast<Array*>(ceClass->statics[fImgK->index].o);
      if (arrK && cometIndex >= 0 && cometIndex < arrK->len) {
        cometImg = static_cast<ImageObj*>(arrK->as<Object*>()[cometIndex]);
      }
    }
  }

  // Lê a opção selecionada atual (campo public byte b de cb)
  FieldInfo* fByteB = vm.findField(inst->cls, "b:B");
  int selectedOption = (fByteB && fByteB->index >= 0 && fByteB->index < (int)inst->f.size()) ? inst->f[fByteB->index].i : 0;

  // Desenha o cometa de seleção perfeitamente centralizado no pergaminho
  const int scrollW = 201;
  if (cometImg) {
    int cometW = cometImg->width > 0 ? cometImg->width : 134;
    // Posição com parênteses corretos: n2 + ((scrollW - cometW) / 2) + 15
    int cometX = n2 + ((scrollW - cometW) / 2) + 15;
    int cometY = n3 + 12 + selectedOption * 16;
    g->drawImage(cometImg, cometX, cometY, 20);
  }

  // 5. Desenha o texto de cada opção do menu (INICIAR, CARREGAR, OPCOES, INFO, SOBRE, SAIR)
  FieldInfo* fByteA = vm.findField(inst->cls, "a:B");
  int optionCount = (fByteA && fByteA->index >= 0 && fByteA->index < (int)inst->f.size()) ? inst->f[fByteA->index].i : 6;

  ClassInfo* bhClass = vm.findClass("bh");
  Method* mBhA = bhClass ? vm.findMethod(bhClass, "a:(Ljavax/microedition/lcdui/Graphics;III)V") : nullptr;

  int centerX = n2 + (scrollW / 2);
  for (int i = 0; i < optionCount; ++i) {
    int lineY = n3 + 14 + i * 16;
    int textId = i * 2;
    if (selectedOption != i || animStep < 2) {
      textId += 1;
    }
    if (mBhA) {
      Value tArgs[4];
      tArgs[0].o = gObj;
      tArgs[1].i = textId;
      tArgs[2].i = centerX;
      tArgs[3].i = lineY;
      Value tRet[2];
      vm.invoke(mBhA, tArgs, tRet);
    }
  }

  // 6. Desenha as softkeys no rodapé (bh.a(Graphics, char[], char[]))
  Method* mBhSoftkey = bhClass ? vm.findMethod(bhClass, "a:(Ljavax/microedition/lcdui/Graphics;[C[C)V") : nullptr;
  if (mBhSoftkey) {
    FieldInfo* fCharArrD = vm.findField(bhClass, "d:[C");
    FieldInfo* fCharArrC = vm.findField(bhClass, "c:[C");
    Object* dObj = (fCharArrD && fCharArrD->isStatic && fCharArrD->index >= 0 && fCharArrD->index < (int)bhClass->statics.size()) ? bhClass->statics[fCharArrD->index].o : nullptr;
    Object* cObj = (fCharArrC && fCharArrC->isStatic && fCharArrC->index >= 0 && fCharArrC->index < (int)bhClass->statics.size()) ? bhClass->statics[fCharArrC->index].o : nullptr;
    Value sArgs[3];
    sArgs[0].o = gObj;
    sArgs[1].o = dObj;
    sArgs[2].o = cObj;
    Value sRet[2];
    vm.invoke(mBhSoftkey, sArgs, sRet);
  }
}

// -------------------------------------------------------------
// bx: Renderização de Submenu do Menu INFO (Wind of Soltia)
// Corrige o alinhamento do título ("NOCOES BASICAS", etc.) na placa superior
// que sofria com precedência de operadores (+ antes de >>) em Widescreen
// -------------------------------------------------------------
[[maybe_unused]] static void bx_draw_native(VM& vm, Value* args, Value*) {
  Object* selfObj = args[0].o;
  if (!selfObj || selfObj->kind != K_INST) return;
  Instance* inst = static_cast<Instance*>(selfObj);

  Object* gObj = args[1].o;
  if (!gObj || gObj->kind != K_GRAPHICS) return;
  GraphicsObj* g = static_cast<GraphicsObj*>(gObj);

  int n2 = args[2].i;
  int n3 = args[3].i;

  const int scrollW = 201;
  int origN2 = n2;
  int origN3 = n3;
  int centerX = origN2 + (scrollW / 2);

  // Lê campos da instância de bx
  FieldInfo* fBoolC = vm.findField(inst->cls, "c:Z");
  bool isModal = (fBoolC && fBoolC->index >= 0 && fBoolC->index < (int)inst->f.size()) ? (inst->f[fBoolC->index].i != 0) : false;

  FieldInfo* fCharArrB = vm.findField(inst->cls, "b:[C");
  Array* titleArr = (fCharArrB && fCharArrB->index >= 0 && fCharArrB->index < (int)inst->f.size()) ? static_cast<Array*>(inst->f[fCharArrB->index].o) : nullptr;

  ClassInfo* bfClass = vm.findClass("bf");
  ClassInfo* bhClass = vm.findClass("bh");
  ClassInfo* ceClass = vm.findClass("ce");

  if (isModal) {
    ClassInfo* cbClass = vm.findClass("cb");
    Method* mCbB = cbClass ? vm.findMethod(cbClass, "b:(Ljavax/microedition/lcdui/Graphics;IIII)V") : nullptr;
    if (mCbB) {
      Value cbArgs[5];
      cbArgs[0].o = gObj;
      cbArgs[1].i = n2 + 6;
      cbArgs[2].i = n3 + 25;
      cbArgs[3].i = 189;
      cbArgs[4].i = 213;
      Value cbRet[2];
      vm.invoke(mCbB, cbArgs, cbRet);
    }
    n2 += 8;
    n3 += 25;
    g->setColor(0xFFFFFF);
    Method* mBhSoftkey = bhClass ? vm.findMethod(bhClass, "a:(Ljavax/microedition/lcdui/Graphics;[C[C)V") : nullptr;
    if (mBhSoftkey) {
      FieldInfo* fM = vm.findField(bhClass, "m:[C");
      FieldInfo* fE = vm.findField(bhClass, "e:[C");
      Object* mObj = (fM && fM->isStatic && fM->index >= 0 && fM->index < (int)bhClass->statics.size()) ? bhClass->statics[fM->index].o : nullptr;
      Object* eObj = (fE && fE->isStatic && fE->index >= 0 && fE->index < (int)bhClass->statics.size()) ? bhClass->statics[fE->index].o : nullptr;
      Value sArgs[3]; sArgs[0].o = gObj; sArgs[1].o = mObj; sArgs[2].o = eObj; Value sRet[2];
      vm.invoke(mBhSoftkey, sArgs, sRet);
    }
  } else {
    // Fundo tela cheia
    g->setColor(0x3F1F3F);
    g->fillRect(0, 0, g_screenWidth, g_screenHeight);

    // Aba superior de cabeçalho (bf.c)
    Method* mBfC = bfClass ? vm.findMethod(bfClass, "c:(Ljavax/microedition/lcdui/Graphics;II)V") : nullptr;
    if (mBfC) {
      Value cArgs[3]; cArgs[0].o = gObj; cArgs[1].i = origN2; cArgs[2].i = origN3; Value cRet[2];
      vm.invoke(mBfC, cArgs, cRet);
    }

    // Título do submenu ("NOCOES BASICAS") perfeitamente centralizado em centerX!
    Method* mBhA_bold = bhClass ? vm.findMethod(bhClass, "a:(Z)V") : nullptr;
    if (mBhA_bold) {
      Value bArgs[1]; bArgs[0].i = 1; Value bRet[2];
      vm.invoke(mBhA_bold, bArgs, bRet);
    }
    g->setColor(0);
    Method* mBhVoidA = bhClass ? vm.findMethod(bhClass, "a:(Ljavax/microedition/lcdui/Graphics;II[CI)V") : nullptr;
    if (mBhVoidA && titleArr) {
      Value vArgs[5];
      vArgs[0].o = gObj;
      vArgs[1].i = centerX;  // Correção do deslocamento: centerX em vez de origN2 + 201 >> 1!
      vArgs[2].i = origN3 + 5 + 4;
      vArgs[3].o = titleArr;
      vArgs[4].i = 1;        // Graphics.HCENTER
      Value vRet[2];
      vm.invoke(mBhVoidA, vArgs, vRet);
    }
    if (mBhA_bold) {
      Value bArgs[1]; bArgs[0].i = 0; Value bRet[2];
      vm.invoke(mBhA_bold, bArgs, bRet);
    }

    // Pergaminho principal (3 blocos)
    Method* mBfB = bfClass ? vm.findMethod(bfClass, "b:(Ljavax/microedition/lcdui/Graphics;III)V") : nullptr;
    if (mBfB) {
      Value bArgs[4]; bArgs[0].o = gObj; bArgs[1].i = origN2; bArgs[2].i = origN3 + 24; bArgs[3].i = 3; Value bRet[2];
      vm.invoke(mBfB, bArgs, bRet);
    }

    n2 += 10;
    n3 += 43;
    g->setColor(0x5F3F3F);
    Method* mBhSoftkey = bhClass ? vm.findMethod(bhClass, "a:(Ljavax/microedition/lcdui/Graphics;[C[C)V") : nullptr;
    if (mBhSoftkey) {
      FieldInfo* fE = vm.findField(bhClass, "e:[C");
      Object* eObj = (fE && fE->isStatic && fE->index >= 0 && fE->index < (int)bhClass->statics.size()) ? bhClass->statics[fE->index].o : nullptr;
      Value sArgs[3]; sArgs[0].o = gObj; sArgs[1].o = nullptr; sArgs[2].o = eObj; Value sRet[2];
      vm.invoke(mBhSoftkey, sArgs, sRet);
    }
  }

  // Indicador de página [1/3] no canto superior direito do pergaminho (r.d)
  FieldInfo* fByteA = vm.findField(inst->cls, "a:B");
  FieldInfo* fByteB = vm.findField(inst->cls, "b:B");
  int pageCount = (fByteA && fByteA->index >= 0 && fByteA->index < (int)inst->f.size()) ? inst->f[fByteA->index].i : 1;
  int curPage   = (fByteB && fByteB->index >= 0 && fByteB->index < (int)inst->f.size()) ? inst->f[fByteB->index].i : 0;

  ClassInfo* rClass = vm.findClass("r");
  Method* mRD = rClass ? vm.findMethod(rClass, "d:(Ljavax/microedition/lcdui/Graphics;IIII)V") : nullptr;
  if (mRD) {
    Value dArgs[5];
    dArgs[0].o = gObj;
    dArgs[1].i = n2 + 201 - 25;
    dArgs[2].i = n3 - 8;
    dArgs[3].i = curPage + 1;
    dArgs[4].i = pageCount;
    Value dRet[2];
    vm.invoke(mRD, dArgs, dRet);
  }

  // Setas de navegação de página
  if (pageCount > 1 && ceClass) {
    if (curPage > 0) {
      FieldInfo* fImgL = vm.findField(ceClass, "l:Ljavax/microedition/lcdui/Image;");
      if (fImgL && fImgL->isStatic && fImgL->index >= 0 && fImgL->index < (int)ceClass->statics.size()) {
        ImageObj* imgL = static_cast<ImageObj*>(ceClass->statics[fImgL->index].o);
        if (imgL) g->drawImage(imgL, n2 + 62 + 13, n3 - 6, 20);
      }
    }
    if (curPage < pageCount - 1) {
      FieldInfo* fImgO = vm.findField(ceClass, "o:Ljavax/microedition/lcdui/Image;");
      if (fImgO && fImgO->isStatic && fImgO->index >= 0 && fImgO->index < (int)ceClass->statics.size()) {
        ImageObj* imgO = static_cast<ImageObj*>(ceClass->statics[fImgO->index].o);
        if (imgO) g->drawImage(imgO, n2 + 62 + 13, n3 + 114 + 26 + 40, 20);
      }
    }
  }

  // Conteúdo do texto do parágrafo
  FieldInfo* fCharArrA = vm.findField(inst->cls, "a:[C");
  FieldInfo* fShortArrA = vm.findField(inst->cls, "a:[S");
  Array* charArr = (fCharArrA && fCharArrA->index >= 0 && fCharArrA->index < (int)inst->f.size()) ? static_cast<Array*>(inst->f[fCharArrA->index].o) : nullptr;
  Array* shortArr = (fShortArrA && fShortArrA->index >= 0 && fShortArrA->index < (int)inst->f.size()) ? static_cast<Array*>(inst->f[fShortArrA->index].o) : nullptr;

  if (charArr && shortArr && curPage >= 0 && curPage < shortArr->len) {
    int s3 = shortArr->as<int16_t>()[curPage];
    int s2 = (curPage == pageCount - 1) ? charArr->len : shortArr->as<int16_t>()[curPage + 1];
    if (charArr->len > 0 && charArr->as<uint16_t>()[0] == '!' && s3 == 0) s3 = 1;

    g->setColor(isModal ? 0xFFFFFF : 0);
    Method* mBhTextA = bhClass ? vm.findMethod(bhClass, "a:(Ljavax/microedition/lcdui/Graphics;IIII[CIII)V") : nullptr;
    if (mBhTextA) {
      Value aTextArgs[9];
      aTextArgs[0].o = gObj;
      aTextArgs[1].i = n2;
      aTextArgs[2].i = n3;
      aTextArgs[3].i = 176;
      aTextArgs[4].i = 1;
      aTextArgs[5].o = charArr;
      aTextArgs[6].i = s3;
      aTextArgs[7].i = 0;
      aTextArgs[8].i = s2 - s3;
      Value aTextRet[2];
      vm.invoke(mBhTextA, aTextArgs, aTextRet);
    }
  }
}

// -------------------------------------------------------------
// l: Menu de Opções / Configurações (Heroes Lore 2: Knight of Frozen Sea)
// Suporte nativo a 8 opções: 0..4 originais + 5: FPS, 6: Tela (Aspect Ratio), 7: Nuvem (Google Drive)
// -------------------------------------------------------------
static void l_init_native(VM& vm, Value* args, Value*) {
  Object* self = args[0].o;
  if (!self || self->kind != K_INST) return;
  Instance* inst = static_cast<Instance*>(self);
  Object* gParent = args[1].o;
  bool isPause = (args[2].i != 0);

  ClassInfo* gClass = vm.findClass("g");
  Method* mGInit = gClass ? vm.findMethod(gClass, "<init>:(Lg;B)V") : nullptr;
  if (mGInit) {
    Value gArgs[3]; gArgs[0].o = self; gArgs[1].o = gParent; gArgs[2].i = 8; Value gRet[2]; // 8 itens!
    vm.invoke(mGInit, gArgs, gRet);
  }

  FieldInfo* fA = vm.findField(inst->cls, "a:Z");
  if (fA && fA->index >= 0 && fA->index < (int)inst->f.size()) {
    inst->f[fA->index].i = isPause ? 1 : 0;
  }
  FieldInfo* fF = gClass ? vm.findField(gClass, "f:Z") : nullptr;
  if (fF && fF->index >= 0 && fF->index < (int)inst->f.size()) {
    inst->f[fF->index].i = 1;
  }
  FieldInfo* fI = gClass ? vm.findField(gClass, "i:B") : nullptr;
  if (fI && fI->index >= 0 && fI->index < (int)inst->f.size()) {
    inst->f[fI->index].i = 8;
  }
}

static void l_cursor_native(VM& vm, Value* args, Value*) {
  Object* selfObj = args[0].o;
  if (!selfObj || selfObj->kind != K_INST) return;
  Instance* inst = static_cast<Instance*>(selfObj);

  ClassInfo* bwClass = vm.findClass("bw");
  FieldInfo* fI = bwClass ? vm.findField(bwClass, "i:I") : nullptr;
  FieldInfo* fJ = bwClass ? vm.findField(bwClass, "j:I") : nullptr;
  FieldInfo* fGraphicsA = bwClass ? vm.findField(bwClass, "a:Ljavax/microedition/lcdui/Graphics;") : nullptr;

  int bw_i = (fI && fI->isStatic && fI->index >= 0) ? bwClass->statics[fI->index].i : (g_screenWidth / 2);
  int bw_j = (fJ && fJ->isStatic && fJ->index >= 0) ? bwClass->statics[fJ->index].i : (g_screenHeight / 2);
  Object* gObj = (fGraphicsA && fGraphicsA->isStatic && fGraphicsA->index >= 0) ? bwClass->statics[fGraphicsA->index].o : nullptr;
  if (!gObj) return;

  ClassInfo* gClass = vm.findClass("g");
  FieldInfo* fH = gClass ? vm.findField(gClass, "h:B") : nullptr;
  int curH = (fH && fH->index >= 0 && fH->index < (int)inst->f.size()) ? inst->f[fH->index].i : 0;

  int startY = bw_j - 63;
  int cursorY = startY + 18 * curH + 4;

  Method* mGb = vm.findMethod(inst->cls, "b:(Ljavax/microedition/lcdui/Graphics;IIIIZ)V");
  if (mGb) {
    Value bArgs[7];
    bArgs[0].o = selfObj;
    bArgs[1].o = gObj;
    bArgs[2].i = bw_i + 25;
    bArgs[3].i = cursorY;
    bArgs[4].i = 46;
    bArgs[5].i = 14134162;
    bArgs[6].i = 0;
    Value bRet[2];
    vm.invoke(mGb, bArgs, bRet);
  }
}

static void l_a_native(VM& vm, Value* args, Value* ret) {
  Object* self = args[0].o;
  if (!self || self->kind != K_INST) { ret[0].i = 0; return; }
  Instance* inst = static_cast<Instance*>(self);
  int n2 = args[1].i; // GameAction
  int n3 = args[2].i; // KeyCode

  ClassInfo* gClass = vm.findClass("g");
  FieldInfo* fI = gClass ? vm.findField(gClass, "i:B") : nullptr;
  FieldInfo* fH = gClass ? vm.findField(gClass, "h:B") : nullptr;
  if (fI && fI->index >= 0 && fI->index < (int)inst->f.size()) {
    inst->f[fI->index].i = 8;
  }
  int curH = (fH && fH->index >= 0 && fH->index < (int)inst->f.size()) ? inst->f[fH->index].i : 0;

  FieldInfo* fA = vm.findField(inst->cls, "a:Z");
  (void)fA;

  // 1. Invoca this.b(n2, n3) para submenus se houver
  Value subArgs[2]; subArgs[0].i = n2; subArgs[1].i = n3; Value subRet[2];
  vm.invokeVirtual(self, "b:(II)Z", subArgs, 2, subRet);
  if (subRet[0].i != 0) {
    ret[0].i = 1;
    return;
  }

  auto closeOptionsMenu = [&]() {
    ClassInfo* cjClass = vm.findClass("cj");
    if (cjClass) {
      FieldInfo* fCjBoolD = vm.findField(cjClass, "d:Z");
      bool helpVal = (fCjBoolD && fCjBoolD->isStatic && fCjBoolD->index >= 0) ? (cjClass->statics[fCjBoolD->index].i != 0) : false;
      if (helpVal) {
        ClassInfo* uClass = vm.findClass("u");
        if (uClass) {
          FieldInfo* fUb = vm.findField(uClass, "b:I");
          FieldInfo* fUc = vm.findField(uClass, "c:I");
          FieldInfo* fUd = vm.findField(uClass, "d:I");
          FieldInfo* fUe = vm.findField(uClass, "e:I");
          if (fUb && fUc && fUd && fUe && fUb->isStatic && fUc->isStatic && fUd->isStatic && fUe->isStatic) {
            uClass->statics[fUd->index].i = uClass->statics[fUb->index].i;
            uClass->statics[fUe->index].i = uClass->statics[fUc->index].i;
          }
        }
      }
      FieldInfo* fCjA = vm.findField(cjClass, "a:Lcj;");
      Object* cjInst = (fCjA && fCjA->isStatic && fCjA->index >= 0) ? cjClass->statics[fCjA->index].o : nullptr;
      if (cjInst) {
        Method* mCjJ = vm.findMethod(cjClass, "j:()V");
        if (mCjJ) { Value jRet[2]; vm.invokeVirtual(cjInst, "j:()V", nullptr, 0, jRet); }
      }
    }

    FieldInfo* fGParent = vm.findField(gClass, "a:Lg;");
    Object* parentObj = (fGParent && fGParent->index >= 0 && fGParent->index < (int)inst->f.size()) ? inst->f[fGParent->index].o : nullptr;
    if (parentObj && parentObj->cls) {
      // 1. Limpa o submenu do pai (g.b = null)
      FieldInfo* fSubmenu = vm.findField(gClass, "b:Lg;");
      if (fSubmenu && fSubmenu->index >= 0 && fSubmenu->index < (int)static_cast<Instance*>(parentObj)->f.size()) {
        static_cast<Instance*>(parentObj)->f[fSubmenu->index].o = nullptr;
      }
      // 2. Cursor do pai em Opções (2)
      FieldInfo* fParentH = vm.findField(parentObj->cls, "h:B");
      if (fParentH && fParentH->index >= 0 && fParentH->index < (int)static_cast<Instance*>(parentObj)->f.size()) {
        static_cast<Instance*>(parentObj)->f[fParentH->index].i = 2;
      }
      // 3. Força repaint do pai
      FieldInfo* fParentE = vm.findField(gClass, "e:Z");
      if (fParentE && fParentE->index >= 0 && fParentE->index < (int)static_cast<Instance*>(parentObj)->f.size()) {
        static_cast<Instance*>(parentObj)->f[fParentE->index].i = 1;
      }
      FieldInfo* fParentD = vm.findField(gClass, "d:Z");
      if (fParentD && fParentD->index >= 0 && fParentD->index < (int)static_cast<Instance*>(parentObj)->f.size()) {
        static_cast<Instance*>(parentObj)->f[fParentD->index].i = 1;
      }
      // 4. Invoca parent.b(2) com descritor b:(I)V
      Method* mParentB = vm.findMethod(parentObj->cls, "b:(I)V");
      if (mParentB) {
        Value bArgs[2]; bArgs[0].o = parentObj; bArgs[1].i = 2; Value bRet[2];
        vm.invoke(mParentB, bArgs, bRet);
      }
    }
  };

  // 2. Se tecla RSK / Cancelar / Voltar (-7, -8, Esc=27, ou 8 interceptado pelo Canvas do HL2)
  // Obs.: n2 = gameAction (UP=1, LEFT=2, RIGHT=5, DOWN=6, FIRE=8) e n3 = keyCode.
  // O Canvas do HL2 converte -7 em keyCode 8. O keyCode 53 ('5') gera gameAction FIRE(8),
  // portanto Back deve ser identificado SOMENTE pelo keyCode (n3), nunca por n2 == 8.
  if (n3 == -7 || n3 == 8 || n3 == -8 || n3 == 27 || n2 == -7 || n2 == -8) {
    closeOptionsMenu();
    ret[0].i = 1;
    return;
  }

  // 3. Se tecla de confirmação ('5' / 53 / Enter / 13 / 32 / Fire)
  if (n3 == 53 || n3 == -5 || n3 == 13 || n3 == 32) {
    if (curH < 5) {
      closeOptionsMenu();
      ret[0].i = 1;
      return;
    } else if (curH == 5) {
      Platform::toggleFps();
      ret[0].i = 1;
      return;
    } else if (curH == 6) {
      Platform::nextAspect(&vm);
      ret[0].i = 1;
      return;
    } else if (curH == 7) {
      Platform::openCloudSave(&vm);
      ret[0].i = 1;
      return;
    }
  }

  // 4. Se tecla Esquerda ou Direita
  bool isLeft = (n3 == 52 || n2 == 2 || n3 == -3 || n2 == -3);
  bool isRight = (n3 == 54 || n2 == 5 || n3 == -4 || n2 == -4);

  if (isLeft || isRight) {
    ClassInfo* cjClass = vm.findClass("cj");
    ClassInfo* akClass = vm.findClass("ak");

    switch (curH) {
      case 0: { // Volume de Som
        FieldInfo* fVol = cjClass ? vm.findField(cjClass, "b:B") : nullptr;
        FieldInfo* fMaxVol = akClass ? vm.findField(akClass, "a:I") : nullptr;
        int maxV = (fMaxVol && fMaxVol->isStatic && fMaxVol->index >= 0) ? akClass->statics[fMaxVol->index].i : 5;
        if (fVol && fVol->isStatic && fVol->index >= 0 && maxV > 0) {
          int curV = cjClass->statics[fVol->index].i;
          if (isLeft) curV = (curV + maxV - 1) % maxV;
          else curV = (curV + 1) % maxV;
          cjClass->statics[fVol->index].i = curV;

          Method* mAkA = akClass ? vm.findMethod(akClass, "a:(I)V") : nullptr;
          if (mAkA) { Value vArgs[1]; vArgs[0].i = curV; Value vRet[2]; vm.invoke(mAkA, vArgs, vRet); }

          if (curV == 0) {
            Method* mAkB = akClass ? vm.findMethod(akClass, "b:()V") : nullptr;
            if (mAkB) { Value bRet[2]; vm.invoke(mAkB, nullptr, bRet); }
          } else {
            Method* mLa = vm.findMethod(inst->cls, "a:()V");
            if (mLa) { Value aRet[2]; vm.invokeVirtual(self, "a:()V", nullptr, 0, aRet); }
          }
        }
        break;
      }
      case 1: { // BGM
        FieldInfo* fBgm = cjClass ? vm.findField(cjClass, "b:Z") : nullptr;
        if (fBgm && fBgm->isStatic && fBgm->index >= 0) {
          bool curBgm = (cjClass->statics[fBgm->index].i != 0);
          curBgm = !curBgm;
          cjClass->statics[fBgm->index].i = curBgm ? 1 : 0;
          if (!curBgm) {
            Method* mAkB = akClass ? vm.findMethod(akClass, "b:()V") : nullptr;
            if (mAkB) { Value bRet[2]; vm.invoke(mAkB, nullptr, bRet); }
          }
        }
        break;
      }
      case 2: { // Vibração
        FieldInfo* fVib = cjClass ? vm.findField(cjClass, "c:Z") : nullptr;
        if (fVib && fVib->isStatic && fVib->index >= 0) {
          bool curVib = (cjClass->statics[fVib->index].i != 0);
          curVib = !curVib;
          cjClass->statics[fVib->index].i = curVib ? 1 : 0;
          if (curVib) {
            Method* mAkVib = akClass ? vm.findMethod(akClass, "a:(B)V") : nullptr;
            if (mAkVib) { Value vArgs[1]; vArgs[0].i = 2; Value vRet[2]; vm.invoke(mAkVib, vArgs, vRet); }
          }
        }
        break;
      }
      case 3: { // Iluminação
        FieldInfo* fBright = cjClass ? vm.findField(cjClass, "a:B") : nullptr;
        if (fBright && fBright->isStatic && fBright->index >= 0) {
          int curB = cjClass->statics[fBright->index].i;
          if (isLeft) curB = (curB + 3) % 4;
          else curB = (curB + 1) % 4;
          cjClass->statics[fBright->index].i = curB;

          FieldInfo* fCjA = cjClass ? vm.findField(cjClass, "a:Lcj;") : nullptr;
          Object* cjInst = (fCjA && fCjA->isStatic && fCjA->index >= 0) ? cjClass->statics[fCjA->index].o : nullptr;
          if (cjInst) {
            Method* mCjA = vm.findMethod(cjClass, "a:(B)V");
            if (mCjA) { Value bArgs[2]; bArgs[0].o = cjInst; bArgs[1].i = curB; Value bRet[2]; vm.invoke(mCjA, bArgs, bRet); }
          }
        }
        break;
      }
      case 4: { // Guia de Teclas / Ajuda
        FieldInfo* fHelp = cjClass ? vm.findField(cjClass, "d:Z") : nullptr;
        if (fHelp && fHelp->isStatic && fHelp->index >= 0) {
          bool curH = (cjClass->statics[fHelp->index].i != 0);
          cjClass->statics[fHelp->index].i = (!curH) ? 1 : 0;
        }
        break;
      }
      case 5: { // FPS
        Platform::toggleFps();
        break;
      }
      case 6: { // Proporção de Tela
        if (isLeft) Platform::prevAspect(&vm);
        else Platform::nextAspect(&vm);
        break;
      }
      case 7: { // Cloud Save
        Platform::openCloudSave(&vm);
        break;
      }
    }
  }

  // 5. Invoca this.c(n2, n3) herdado de g para navegação vertical (sobe/desce)
  Value navArgs[2]; navArgs[0].i = n2; navArgs[1].i = n3; Value navRet[2];
  vm.invokeVirtual(self, "c:(II)Z", navArgs, 2, navRet);
  ret[0].i = navRet[0].i;
}

static void l_draw_native(VM& vm, Value* args, Value*) {
  Object* selfObj = args[0].o;
  if (!selfObj || selfObj->kind != K_INST) return;
  Instance* inst = static_cast<Instance*>(selfObj);

  ClassInfo* gClass = vm.findClass("g");
  FieldInfo* fI = gClass ? vm.findField(gClass, "i:B") : nullptr;
  FieldInfo* fH = gClass ? vm.findField(gClass, "h:B") : nullptr;
  if (fI && fI->index >= 0 && fI->index < (int)inst->f.size()) {
    inst->f[fI->index].i = 8; // Expande para 8 itens!
  }
  int curH = (fH && fH->index >= 0 && fH->index < (int)inst->f.size()) ? inst->f[fH->index].i : 0;

  FieldInfo* fA = vm.findField(inst->cls, "a:Z");
  bool isPauseMenu = (fA && fA->index >= 0 && fA->index < (int)inst->f.size()) ? (inst->f[fA->index].i != 0) : false;

  ClassInfo* bwClass = vm.findClass("bw");
  FieldInfo* fGraphicsA = bwClass ? vm.findField(bwClass, "a:Ljavax/microedition/lcdui/Graphics;") : nullptr;
  FieldInfo* fBwI = bwClass ? vm.findField(bwClass, "i:I") : nullptr;
  FieldInfo* fBwJ = bwClass ? vm.findField(bwClass, "j:I") : nullptr;
  Object* gObj = (fGraphicsA && fGraphicsA->isStatic && fGraphicsA->index >= 0) ? bwClass->statics[fGraphicsA->index].o : nullptr;
  if (!gObj || gObj->kind != K_GRAPHICS) return;
  GraphicsObj* graphics = static_cast<GraphicsObj*>(gObj);

  int bw_i = (fBwI && fBwI->isStatic && fBwI->index >= 0) ? bwClass->statics[fBwI->index].i : (g_screenWidth / 2);
  int bw_j = (fBwJ && fBwJ->isStatic && fBwJ->index >= 0) ? bwClass->statics[fBwJ->index].i : (g_screenHeight / 2);

  ClassInfo* asClass = vm.findClass("as");
  FieldInfo* fAsA = asClass ? vm.findField(asClass, "a:Le;") : nullptr;
  Object* eObj = (fAsA && fAsA->isStatic && fAsA->index >= 0) ? asClass->statics[fAsA->index].o : nullptr;
  ClassInfo* eClass = vm.findClass("e");
  Method* mEa = eClass ? vm.findMethod(eClass, "a:(I)[B") : nullptr;

  auto getGameString = [&](int id) -> Object* {
    if (!eObj || !mEa) return nullptr;
    Value vArgs[2]; vArgs[0].o = eObj; vArgs[1].i = id; Value vRet[2];
    vm.invoke(mEa, vArgs, vRet);
    return vRet[0].o;
  };

  ClassInfo* bkClass = vm.findClass("bk");
  Method* mBkA = bkClass ? vm.findMethod(bkClass, "a:(Ljavax/microedition/lcdui/Graphics;II[BI)V") : nullptr;
  Method* mBkA_flags = bkClass ? vm.findMethod(bkClass, "a:(Ljavax/microedition/lcdui/Graphics;II[BII)V") : nullptr;

  auto makeByteArray = [&](const std::string& str) -> Object* {
    Array* arr = vm.newArray('B', (int)str.size());
    memcpy(arr->data.data(), str.data(), str.size());
    return arr;
  };

  // 1. Desenha o fundo da tela / janela modal
  if (isPauseMenu) {
    // Popup in-game (190 x 170)
    int boxX = bw_i - 95;
    int boxY = bw_j - 82;
    int boxW = 190;
    int boxH = 170;

    graphics->setClip(boxX, boxY, boxW, boxH);
    graphics->setColor(6970180);
    graphics->fillRect(boxX, boxY, boxW, boxH);
    graphics->setColor(0);
    graphics->fillRect(boxX, boxY, boxW, 11); // Cabeçalho
    graphics->fillRect(boxX + 20, boxY + 14, 150, boxH - 18); // Fundo das opções

    // Rebites decorativos dos 4 cantos
    FieldInfo* fAsT = asClass ? vm.findField(asClass, "t:Ljavax/microedition/lcdui/Image;") : nullptr;
    Object* imgT = (fAsT && fAsT->isStatic && fAsT->index >= 0) ? asClass->statics[fAsT->index].o : nullptr;
    if (imgT && imgT->kind == K_IMAGE) {
      ImageObj* rivet = static_cast<ImageObj*>(imgT);
      graphics->drawImage(rivet, boxX + 2, boxY + 2, 20);
      graphics->drawImage(rivet, boxX + boxW - 9, boxY + 2, 20);
      graphics->drawImage(rivet, boxX + 2, boxY + boxH - 9, 20);
      graphics->drawImage(rivet, boxX + boxW - 9, boxY + boxH - 9, 20);
    }

    // Título "CONFIGURAÇÕES" no cabeçalho
    graphics->setColor(0xFFFFFF);
    Object* titleBytes = getGameString(2);
    if (titleBytes && mBkA_flags) {
      Value tArgs[6]; tArgs[0].o = gObj; tArgs[1].i = bw_i; tArgs[2].i = boxY + 1; tArgs[3].o = titleBytes; tArgs[4].i = 0; tArgs[5].i = 1; Value tRet[2];
      vm.invoke(mBkA_flags, tArgs, tRet);
    }
  } else {
    // Menu de Título (moldura de tela cheia)
    Method* mGa = vm.findMethod(inst->cls, "a:(Ljavax/microedition/lcdui/Graphics;)V");
    if (mGa) {
      Value aArgs[2]; aArgs[0].o = selfObj; aArgs[1].o = gObj; Value aRet[2];
      vm.invoke(mGa, aArgs, aRet);
    }
    graphics->setColor(14467940);
    Object* titleBytes = getGameString(2);
    if (titleBytes && mBkA) {
      Value tArgs[5]; tArgs[0].o = gObj; tArgs[1].i = bw_i - 20; tArgs[2].i = bw_j - 80; tArgs[3].o = titleBytes; tArgs[4].i = 0; Value tRet[2];
      vm.invoke(mBkA, tArgs, tRet);
    }
  }

  // 2. Desenha as 8 linhas de opções
  int startY = bw_j - 63;
  graphics->setColor(14134162);

  // Rótulos dos itens originais 0..4
  for (int i = 0; i < 5; ++i) {
    Object* lbl = getGameString(26 + i);
    if (lbl && mBkA) {
      Value lArgs[5]; lArgs[0].o = gObj; lArgs[1].i = bw_i - 67; lArgs[2].i = startY + 18 * i; lArgs[3].o = lbl; lArgs[4].i = 0; Value lRet[2];
      vm.invoke(mBkA, lArgs, lRet);
    }
  }

  // Lê campos de som / exibição de cj
  ClassInfo* cjClass = vm.findClass("cj");
  FieldInfo* fCjByteB = cjClass ? vm.findField(cjClass, "b:B") : nullptr;
  FieldInfo* fCjBoolB = cjClass ? vm.findField(cjClass, "b:Z") : nullptr;
  FieldInfo* fCjBoolC = cjClass ? vm.findField(cjClass, "c:Z") : nullptr;
  FieldInfo* fCjByteA = cjClass ? vm.findField(cjClass, "a:B") : nullptr;
  FieldInfo* fCjBoolD = cjClass ? vm.findField(cjClass, "d:Z") : nullptr;

  int volVal = (fCjByteB && fCjByteB->isStatic && fCjByteB->index >= 0) ? cjClass->statics[fCjByteB->index].i : 0;
  bool bgmVal = (fCjBoolB && fCjBoolB->isStatic && fCjBoolB->index >= 0) ? (cjClass->statics[fCjBoolB->index].i != 0) : true;
  bool vibVal = (fCjBoolC && fCjBoolC->index >= 0) ? (cjClass->statics[fCjBoolC->index].i != 0) : true;
  int brightVal = (fCjByteA && fCjByteA->isStatic && fCjByteA->index >= 0) ? cjClass->statics[fCjByteA->index].i : 0;
  bool helpVal = (fCjBoolD && fCjBoolD->isStatic && fCjBoolD->index >= 0) ? (cjClass->statics[fCjBoolD->index].i != 0) : false;

  // Valor 0: Barra de volume
  Method* mLe = vm.findMethod(inst->cls, "e:(Ljavax/microedition/lcdui/Graphics;III)V");
  if (mLe) {
    Value eArgs[5]; eArgs[0].o = selfObj; eArgs[1].o = gObj; eArgs[2].i = bw_i + 30; eArgs[3].i = startY; eArgs[4].i = volVal; Value eRet[2];
    vm.invoke(mLe, eArgs, eRet);
  }

  // Valor 1: BGM
  Method* mLbToggle = vm.findMethod(inst->cls, "b:(Ljavax/microedition/lcdui/Graphics;IIZ)V");
  graphics->setColor(curH == 1 ? 0xFFFFFF : 0x7F7F7F);
  if (mLbToggle) {
    Value bArgs[5]; bArgs[0].o = selfObj; bArgs[1].o = gObj; bArgs[2].i = bw_i + 49; bArgs[3].i = startY + 18; bArgs[4].i = bgmVal ? 1 : 0; Value bRet[2];
    vm.invoke(mLbToggle, bArgs, bRet);
  }

  // Valor 2: Vibração
  graphics->setColor(curH == 2 ? 0xFFFFFF : 0x7F7F7F);
  if (mLbToggle) {
    Value bArgs[5]; bArgs[0].o = selfObj; bArgs[1].o = gObj; bArgs[2].i = bw_i + 49; bArgs[3].i = startY + 36; bArgs[4].i = vibVal ? 1 : 0; Value bRet[2];
    vm.invoke(mLbToggle, bArgs, bRet);
  }

  // Valor 3: Iluminação
  graphics->setColor(curH == 3 ? 0xFFFFFF : 0x7F7F7F);
  Object* brightStr = getGameString(32 + brightVal);
  if (brightStr && mBkA_flags) {
    Value brArgs[6]; brArgs[0].o = gObj; brArgs[1].i = bw_i + 49; brArgs[2].i = startY + 54; brArgs[3].o = brightStr; brArgs[4].i = 0; brArgs[5].i = 1; Value brRet[2];
    vm.invoke(mBkA_flags, brArgs, brRet);
  }

  // Valor 4: Guia de Teclas / Ajuda
  graphics->setColor(curH == 4 ? 0xFFFFFF : 0x7F7F7F);
  if (mLbToggle) {
    Value bArgs[5]; bArgs[0].o = selfObj; bArgs[1].o = gObj; bArgs[2].i = bw_i + 49; bArgs[3].i = startY + 72; bArgs[4].i = helpVal ? 1 : 0; Value bRet[2];
    vm.invoke(mLbToggle, bArgs, bRet);
  }

  // --- NOVAS OPÇÕES RECOMPILAÇÃO (Itens 5, 6, 7) ---

  // Item 5: Taxa de Quadros (FPS)
  graphics->setColor(14134162);
  Object* lblFps = makeByteArray("FPS");
  if (lblFps && mBkA) {
    Value lArgs[5]; lArgs[0].o = gObj; lArgs[1].i = bw_i - 67; lArgs[2].i = startY + 90; lArgs[3].o = lblFps; lArgs[4].i = 0; Value lRet[2];
    vm.invoke(mBkA, lArgs, lRet);
  }
  graphics->setColor(curH == 5 ? 0xFFFFFF : 0x7F7F7F);
  std::string txtFps = (Platform::getTargetFps() == 15) ? "15" : "30";
  Object* valFps = makeByteArray(txtFps);
  if (valFps && mBkA_flags) {
    Value vArgs[6]; vArgs[0].o = gObj; vArgs[1].i = bw_i + 49; vArgs[2].i = startY + 90; vArgs[3].o = valFps; vArgs[4].i = 0; vArgs[5].i = 1; Value vRet[2];
    vm.invoke(mBkA_flags, vArgs, vRet);
  }

  // Item 6: Proporção de Tela (Aspect Ratio)
  graphics->setColor(14134162);
  Object* lblTela = makeByteArray("Tela");
  if (lblTela && mBkA) {
    Value lArgs[5]; lArgs[0].o = gObj; lArgs[1].i = bw_i - 67; lArgs[2].i = startY + 108; lArgs[3].o = lblTela; lArgs[4].i = 0; Value lRet[2];
    vm.invoke(mBkA, lArgs, lRet);
  }
  graphics->setColor(curH == 6 ? 0xFFFFFF : 0x7F7F7F);
  int curAspect = Platform::getAspectMode();
  std::string txtAspect = (curAspect == 0) ? "Auto" : ((curAspect == 1) ? "3:4" : "16:9");
  Object* valTela = makeByteArray(txtAspect);
  if (valTela && mBkA_flags) {
    Value vArgs[6]; vArgs[0].o = gObj; vArgs[1].i = bw_i + 49; vArgs[2].i = startY + 108; vArgs[3].o = valTela; vArgs[4].i = 0; vArgs[5].i = 1; Value vRet[2];
    vm.invoke(mBkA_flags, vArgs, vRet);
  }

  // Item 7: Cloud Save (Google Drive)
  graphics->setColor(14134162);
  Object* lblCloud = makeByteArray("Nuvem");
  if (lblCloud && mBkA) {
    Value lArgs[5]; lArgs[0].o = gObj; lArgs[1].i = bw_i - 67; lArgs[2].i = startY + 126; lArgs[3].o = lblCloud; lArgs[4].i = 0; Value lRet[2];
    vm.invoke(mBkA, lArgs, lRet);
  }
  graphics->setColor(curH == 7 ? 0xFFFFFF : 0x7F7F7F);
  std::string txtCloud = "Google";
  Object* valCloud = makeByteArray(txtCloud);
  if (valCloud && mBkA_flags) {
    Value vArgs[6]; vArgs[0].o = gObj; vArgs[1].i = bw_i + 49; vArgs[2].i = startY + 126; vArgs[3].o = valCloud; vArgs[4].i = 0; vArgs[5].i = 1; Value vRet[2];
    vm.invoke(mBkA_flags, vArgs, vRet);
  }
}


}  // namespace hl
