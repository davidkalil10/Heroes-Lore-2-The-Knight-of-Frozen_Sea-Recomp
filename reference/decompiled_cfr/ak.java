/*
 * Decompiled with CFR 0.152.
 */
import com.skt.m.AudioSystem;
import com.skt.m.UnsupportedFormatException;

public class ak
implements ax {
    public static int var_int_a;
    public static byte[] i;
    public static byte[] j;
    public static long var_long_a;
    private static Object var_java_lang_Object_a;
    public static Object[] var_java_lang_Object_arr_a;
    public static Object[] b;
    private static bz var_bz_a;

    public static final void a() {
        if (!cj.var_boolean_b) {
            return;
        }
        if (j == null && i == null) {
            return;
        }
        if (j != null && j == var_java_lang_Object_a) {
            return;
        }
        if (j == null && i != null && i == var_java_lang_Object_a) {
            return;
        }
        if (var_long_a != 0L && var_long_a > System.currentTimeMillis()) {
            return;
        }
        if (j != null) {
            ak.a(j, true);
            var_long_a = 0L;
        } else if (i != null) {
            ak.a(i, true);
            var_long_a = 0L;
        }
    }

    public static final void b() {
        var_bz_a.b();
        var_java_lang_Object_a = null;
    }

    public static final void c() {
        if (var_java_lang_Object_a == null) {
            return;
        }
        if (i == var_java_lang_Object_a || j == var_java_lang_Object_a) {
            ak.b();
        }
    }

    public static final void d() {
        ak.c();
        i = null;
        j = null;
    }

    public static final void a(byte by2, boolean bl2) {
        ak.a((byte[])var_java_lang_Object_arr_a[by2], bl2);
        var_long_a = System.currentTimeMillis() + 3000L;
        if (!bl2) {
            var_long_a += 10000L;
        }
    }

    public static final void a(byte by2) {
        if (by2 == 2 && b[2] == null) {
            ak.a(2, 42);
        }
        if (cj.var_boolean_c) {
            ak.a((byte[])b[by2], false);
            var_long_a = System.currentTimeMillis() + 3000L;
        }
    }

    public static final void a(byte[] byArray, boolean bl2) {
        if (byArray == null) {
            return;
        }
        ak.b();
        if (cj.var_byte_b > 0) {
            var_java_lang_Object_a = byArray;
            var_bz_a.a(byArray);
            var_bz_a.a(bl2);
            var_bz_a.void_a();
        }
    }

    public static final void a(int n2) {
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 > var_int_a) {
            n2 = var_int_a;
        }
        try {
            AudioSystem.setVolume("mmf", n2 * bz.int_a() / var_int_a);
        }
        catch (UnsupportedFormatException unsupportedFormatException) {
            // empty catch block
        }
    }

    public static void e() {
        try {
            var_int_a = bz.int_a();
        }
        catch (Exception exception) {
            var_int_a = 10;
        }
        if (var_int_a > 10 || var_int_a <= 1) {
            var_int_a = 10;
        }
        cj.var_byte_b = (byte)((var_int_a + 1) / 2);
        var_bz_a = new bz();
    }

    public static final void b(byte by2) {
        if (var_java_lang_Object_arr_a[by2] != null) {
            return;
        }
        byte[] byArray = as.a("/snd/" + (by2 < 10 ? "0" : "") + by2);
        ak.var_java_lang_Object_arr_a[by2] = byArray;
    }

    public static final void c(byte by2) {
        if (var_java_lang_Object_arr_a[by2] != null) {
            ak.var_java_lang_Object_arr_a[by2] = null;
        }
    }

    public static final void a(int n2, int n3) {
        byte[] byArray = as.a("/snd/" + n3);
        try {
            ak.b[n2] = byArray;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final void b(int n2) {
        if (b[n2] != null) {
            ak.b[n2] = null;
        }
    }

    static {
        var_int_a = 10;
        var_java_lang_Object_arr_a = new Object[18];
        b = new Object[10];
    }
}

