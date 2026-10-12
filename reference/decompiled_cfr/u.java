/*
 * Decompiled with CFR 0.152.
 */
import com.xce.io.XFile;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class u
implements ax {
    public static final byte[] var_byte_arr_i;
    private static final byte[] var_byte_arr_l;
    public static final String[] var_java_lang_String_arr_a;
    public static final String[] var_java_lang_String_arr_b;
    private static final byte[] m;
    private static final byte[] n;
    private static final byte[] o;
    private static final boolean[] var_boolean_arr_a;
    private static byte[] p;
    private static byte[] q;
    public static byte var_byte_a;
    public static Object[] var_java_lang_Object_arr_a;
    public static byte var_byte_b;
    public static byte var_byte_c;
    public static byte var_byte_d;
    public static byte var_byte_e;
    public static byte var_byte_f;
    public static byte var_byte_g;
    public static int var_int_a;
    public static ah var_ah_a;
    public static int var_int_b;
    public static int var_int_c;
    public static int var_int_d;
    public static int var_int_e;
    public static byte h;
    public static b var_b_a;
    public static Vector var_java_util_Vector_a;
    public static ci var_ci_a;
    public static ci var_ci_b;
    public static ci var_ci_c;
    public static byte[] var_byte_arr_j;
    public static int[] var_int_arr_a;
    public static Vector var_java_util_Vector_b;
    private static byte[] r;
    private static byte var_byte_k;
    private static byte var_byte_l;
    public static int var_int_f;
    public static int var_int_g;
    public static byte[] var_byte_arr_k;
    public static byte var_byte_i;
    public static byte var_byte_j;
    public static u var_u_a;

    public static final synchronized void a(byte by2, byte by3, byte by4, byte by5) {
        var_byte_e = by3;
        var_byte_f = by4;
        var_byte_g = by5;
        var_byte_d = by2;
    }

    public static final synchronized void a(byte by2, byte by3, byte by4) {
        u.a(by2, by3, by4, (byte)0);
    }

    public static final synchronized void a(byte by2, byte by3) {
        u.a(by2, by3, (byte)0, (byte)0);
    }

    public static final synchronized void void_a(byte by2) {
        u.a(by2, (byte)0, (byte)0, (byte)0);
    }

    public static final void void_a() {
        u.a((byte)0, (byte)0, (byte)0, (byte)0);
    }

    public static final void b(byte by2) {
        if (u.var_b_a.var_byte_s == 1) {
            u.d((byte)2, by2);
            u.b((byte)0, (byte)0);
        } else if (u.var_b_a.var_byte_s == 2) {
            u.b((byte)2, by2);
        }
    }

    public static final void void_b() {
        u.b((byte)1, u.var_b_a.var_byte_t);
    }

    public static final void c(byte by2) {
        if (!ah.var_boolean_a) {
            return;
        }
        if (!var_b_a.boolean_c(by2)) {
            return;
        }
        if (u.var_b_a.var_boolean_n) {
            var_b_a.boolean_b((byte)35);
        }
        if (u.var_b_a.var_byte_s == 2) {
            u.b((byte)3, u.var_b_a.var_byte_t);
        } else if (u.var_b_a.var_byte_s == 1) {
            u.d((byte)3, var_b_a.byte_b());
        }
    }

    private static final void d(byte by2, byte by3) {
        var_b_a.void_f(by2);
        var_b_a.void_g(by3);
    }

    public static final void b(byte by2, byte by3) {
        var_byte_k = by2;
        var_byte_l = by3;
    }

    public final void a(int n2, int n3, int n4) {
        var_b_a.a((short)(n2 * 16), (short)(n3 * 16));
        if (n4 > -1) {
            var_b_a.void_g((byte)n4);
        }
        var_b_a.void_c();
        var_b_a.t();
    }

    public static final void void_c() {
        if (var_byte_k != 0 && !u.var_b_a.var_boolean_c && !u.var_b_a.var_boolean_d) {
            u.d(var_byte_k, var_byte_l);
            u.b((byte)0, (byte)0);
        }
        u.d();
        var_ah_a.void_a();
    }

    public static final void d() {
        var_b_a.h();
        var_ah_a.b(var_b_a);
        cg cg2 = u.var_b_a.var_cg_a;
        if (cg2 != null) {
            cg2.b();
            var_ah_a.b(cg2);
        }
    }

    public final void void_a(int n2) {
        u.a((byte)9, (byte)n2);
    }

    public final void e() {
        bg.bg_a();
        u.a((byte)3, (byte)2, (byte)3);
    }

    public static final void b(byte by2, byte by3, byte by4, byte by5) {
        h = by2;
        u.a((byte)1, by3, by4, by5);
    }

    private void m() {
        var_ah_a.void_a(var_b_a);
        var_b_a.g();
        u.f();
        var_int_d = var_int_b;
        var_int_e = var_int_c;
        bd.var_bd_a.e();
        u.void_a();
        h = (byte)-1;
        u.a((byte)3, (byte)3, (byte)1);
        bd.var_boolean_a = true;
    }

    public static final void f() {
        var_int_b = bd.var_int_c - u.var_b_a.var_short_c;
        var_int_c = bd.var_int_d - u.var_b_a.var_short_d;
    }

    public static final void a(boolean bl2, boolean bl3) {
        if (bl3) {
            byte by2 = u.var_b_a.var_byte_t;
            if (bl2) {
                var_int_c -= 15 * ax.var_byte_arr_b[by2];
                var_int_b -= 15 * ax.var_byte_arr_a[by2];
            }
            if (!var_boolean_arr_a[by2] && var_int_e != var_int_c) {
                var_int_e += (var_int_c - var_int_e + 1) / 2 - 1;
            }
            if (var_boolean_arr_a[by2] && var_int_d != var_int_b) {
                var_int_d += (var_int_b - var_int_d + 1) / 2 - 1;
            }
        } else {
            var_int_d += (var_int_b - var_int_d + 1) / 2 - 1;
            var_int_e += (var_int_c - var_int_e + 1) / 2 - 1;
        }
    }

    private void n() {
        var_int_a = var_byte_e;
        if (var_byte_f == 0) {
            cj.var_cj_a.a((int)var_byte_g);
        } else if (var_byte_f == 1) {
            cj.var_cj_a.f();
        } else if (var_byte_f == 2) {
            cj.var_cj_a.g();
        } else if (var_byte_f == 3) {
            cj.var_cj_a.h();
        }
    }

    private void o() {
        var_b_a = b.a(var_byte_a, (short)0, (short)0);
        var_b_a.g();
        var_b_a.n();
        u.var_b_a.var_int_a = u.var_b_a.var_int_d;
        u.var_b_a.var_int_b = u.var_b_a.var_int_e;
    }

    private void p() {
        var_ci_a = new ci(28);
        var_ci_b = new ci(28);
        var_ci_c = new ci(15);
    }

    private void q() {
        var_int_f = n.h ? 999999999 : 0;
        var_ci_a.d();
    }

    private void r() {
        try {
            this.a(true);
        }
        catch (Exception exception) {
            this.s();
            this.b(0);
            this.w();
            this.t();
            this.x();
        }
    }

    public final void g() {
        if (var_byte_d == 0) {
            return;
        }
        byte by2 = var_byte_d;
        var_byte_d = 0;
        switch (by2) {
            case 1: {
                bd.var_bd_a.a((byte)3, true);
                break;
            }
            case 2: {
                this.m();
                break;
            }
            case 3: {
                this.n();
                break;
            }
            case 9: {
                if (var_byte_e == 2) {
                    this.y();
                }
                this.s();
                this.b(0);
                this.w();
                this.t();
                if (var_byte_e == 0) {
                    this.x();
                } else if (var_byte_e == 1) {
                    this.r();
                }
                bd.var_bd_a.a((byte)2, false);
                break;
            }
            case 6: {
                var_int_a = 5;
                ck.ck_a().void_a();
                break;
            }
            case 7: {
                var_int_a = 3;
                if (var_byte_e == 1) {
                    ck.ck_a().void_a(false);
                    as.var_as_a.i();
                    as.var_as_a.m();
                    bd.var_bd_a.a((byte)1, false);
                } else {
                    ck.ck_a().void_a(true);
                }
                if (var_byte_e != 2) break;
                bw.k = 0;
                bw.l = 3;
                u.b(r[0], r[1], r[2], (byte)2);
                break;
            }
            case 4: {
                switch (var_byte_e) {
                    case 0: {
                        u.h(7);
                        o.o_a().void_a();
                        break;
                    }
                    case 1: {
                        u.h(8);
                        bv.bv_a().void_a();
                        break;
                    }
                    case 2: {
                        u.h(6);
                        cq.cq_a().void_a();
                        break;
                    }
                    case 3: {
                        u.h(9);
                        cm.cm_a().void_a();
                    }
                }
                break;
            }
            case 8: {
                if (cj.var_boolean_b) {
                    ak.b((byte)16);
                    ak.a((byte)16, false);
                }
                bd.var_bd_a.f = 0;
                u.h(10);
                break;
            }
            case 10: {
                as.var_as_a.j();
                u.h(12);
            }
        }
    }

    public final boolean boolean_a(int n2) {
        byte by2 = p[n2 / 8];
        return (by2 >> n2 % 8 & 1) == 1;
    }

    public final void b(int n2) {
        byte by2 = p[n2 / 8];
        u.p[n2 / 8] = (byte)(by2 | 1 << n2 % 8);
    }

    public final void c(int n2) {
        byte by2 = p[n2 / 8];
        u.p[n2 / 8] = (byte)(by2 & ~(1 << n2 % 8));
    }

    public static final byte byte_a(int n2) {
        byte by2 = q[n2 / 4];
        return (byte)(by2 >> (n2 % 4 << 1) & 3);
    }

    public static final void d(int n2) {
        byte by2 = q[n2 / 4];
        u.q[n2 / 4] = (byte)(by2 | 1 << (n2 % 4 << 1));
    }

    public final void e(int n2) {
        byte by2 = q[n2 / 4];
        byte by3 = u.byte_a(n2);
        u.q[n2 / 4] = (byte)(by2 & ~(by3 << (n2 % 4 << 1)));
        by2 = q[n2 / 4];
        u.q[n2 / 4] = (byte)(by2 | 2 << (n2 % 4 << 1));
    }

    public final void f(int n2) {
        byte by2 = q[n2 / 4];
        byte by3 = u.byte_a(n2);
        u.q[n2 / 4] = (byte)(by2 & ~(by3 << (n2 % 4 << 1)));
        by2 = q[n2 / 4];
        u.q[n2 / 4] = (byte)(by2 | 3 << (n2 % 4 << 1));
    }

    private void s() {
        for (int i2 = 0; i2 < 32; ++i2) {
            u.p[i2] = 0;
        }
    }

    private void t() {
        for (int i2 = 0; i2 < 32; ++i2) {
            u.q[i2] = 0;
        }
    }

    public final void c(byte by2, byte by3) {
        u.r[0] = u.var_ah_a.var_byte_b;
        u.r[1] = by2;
        u.r[2] = by3;
    }

    private void u() {
        u.r[0] = 0;
        u.r[1] = 7;
        u.r[2] = 22;
    }

    public void a(int n2, int n3, boolean bl2) {
        byte by2 = (byte)(bl2 ? n3 + 10 : n3);
        for (int i2 = 0; i2 < var_byte_arr_j.length; ++i2) {
            if (var_byte_arr_j[i2] != by2) continue;
            u.var_byte_arr_j[i2] = -1;
            break;
        }
        u.var_byte_arr_j[n2] = by2;
        u.a(n3, bl2);
    }

    private final void v() {
        for (int i2 = 0; i2 < var_byte_arr_j.length; ++i2) {
            u.var_byte_arr_j[i2] = -1;
        }
    }

    public final void h() {
        for (int i2 = 0; i2 < var_byte_arr_j.length; ++i2) {
            if (var_byte_arr_j[i2] < 10) continue;
            u.var_byte_arr_j[i2] = -1;
        }
    }

    public static final void i() {
        for (int n2 = 0; n2 < 4; n2 = (int)((byte)(n2 + 1))) {
            if (var_int_arr_a[n2] < 0) continue;
            int n3 = n2;
            var_int_arr_a[n3] = var_int_arr_a[n3] - 1;
        }
    }

    public static void a(int n2, boolean bl2) {
        int n3 = bl2 ? n2 + 10 : n2;
        for (int i2 = 0; i2 < var_byte_arr_j.length; ++i2) {
            if (var_byte_arr_j[i2] != n3) continue;
            u.var_int_arr_a[i2] = bl2 ? u.var_b_a.var_cg_a.var_short_arr_a[n3 - 10] : var_b_a.short_a(n3 - 1);
            break;
        }
    }

    public static final boolean boolean_a() {
        byte[] byArray = var_ah_a.byte_arr_a(((bl)u.var_b_a).h, ((bl)u.var_b_a).i);
        if (byArray != null) {
            if (byArray[2] == -1) {
                int n2 = byArray[3] * 100 + byArray[4];
                u.g(n2);
                byte[] byArray2 = String.valueOf(n2).getBytes();
                bd.var_bd_a.a(f.a(byArray2, "G".getBytes()), 16, 0);
            } else if (byArray[2] == 34) {
                var_ci_c.a(cp.a(byArray[2], byArray[3], true, true), byArray[4]);
                bd.var_bd_a.a(as.var_e_c.a(byArray[2]), 16, 0);
            } else if (ci.boolean_a(byArray[2])) {
                var_ci_b.a(cp.a(byArray[2], byArray[3], true, true), byArray[4]);
                bd.var_bd_a.a(as.var_e_c.a(byArray[2]), 16, 0);
            } else {
                cp cp2 = cp.a(byArray[2], byArray[3], true, true);
                var_ci_a.a(cp2, byArray[4]);
                bd.var_bd_a.a(as.var_e_c.a(byArray[2]), 16, 0);
                if (byArray[2] == 24 || byArray[2] == 25 || byArray[2] == 26) {
                    bd.var_boolean_a = true;
                }
            }
            return true;
        }
        if (var_ah_a.boolean_a(((bl)u.var_b_a).h, ((bl)u.var_b_a).i)) {
            bd.var_bd_a.a(as.var_e_c.a(7), 16, 0);
        }
        return false;
    }

    public static final void g(int n2) {
        if ((var_int_f += n2) < 0) {
            var_int_f = 0;
        } else if (var_int_f > 999999999) {
            var_int_f = 999999999;
        }
    }

    private void w() {
        var_java_util_Vector_b = new Vector(1);
    }

    public static final void d(byte by2) {
        int n2 = u.int_a(by2);
        if (n2 < 0) {
            byte[] byArray = new byte[]{by2, 1};
            var_java_util_Vector_b.addElement(byArray);
        } else {
            byte[] byArray = (byte[])var_java_util_Vector_b.elementAt(n2);
            if (byArray[1] < 99) {
                byArray[1] = (byte)(byArray[1] + 1);
            }
        }
    }

    public static final void j() {
        byte[] byArray = new byte[2];
        for (int i2 = 0; i2 < var_java_util_Vector_b.size(); ++i2) {
            byArray = (byte[])var_java_util_Vector_b.elementAt(i2);
            if (u.byte_a((int)byArray[0]) == 1) continue;
            var_java_util_Vector_b.removeElementAt(i2);
        }
    }

    public static final int int_a(byte by2) {
        for (int i2 = 0; i2 < var_java_util_Vector_b.size(); ++i2) {
            byte[] byArray = (byte[])var_java_util_Vector_b.elementAt(i2);
            if (byArray == null || byArray[0] != by2) continue;
            return i2;
        }
        return -1;
    }

    public static final void e(byte by2) {
        if (by2 < 1) {
            return;
        }
        if (u.byte_a((int)by2) == 1) {
            u.d(by2);
        }
    }

    public static final boolean a(byte by2, int n2) {
        byte[] byArray;
        int n3 = u.int_a(by2);
        return n3 > -1 && (byArray = (byte[])var_java_util_Vector_b.elementAt(n3))[1] >= n2;
    }

    public static final void h(int n2) {
        var_int_a = n2;
    }

    public static boolean boolean_a(byte by2) {
        return var_java_lang_Object_arr_a[by2] != null;
    }

    public final void k() {
        var_byte_b = 0;
        var_java_lang_Object_arr_a = new Object[3];
        for (byte by2 = 0; by2 < 3; by2 = (byte)(by2 + 1)) {
            u.var_java_lang_Object_arr_a[by2] = this.byte_arr_a(by2);
            bw.k += 15;
            if (var_java_lang_Object_arr_a[by2] == null) continue;
            var_byte_b = (byte)(var_byte_b + 1);
        }
    }

    private byte[] byte_arr_a(byte by2) {
        byte[] byArray = new byte[5];
        byte[] byArray2 = new byte[2];
        int n2 = 0;
        try {
            XFile xFile = new XFile(var_java_lang_String_arr_a[by2], 1);
            byArray[n2++] = by2;
            xFile.read(byArray2, 0, byArray2.length);
            byte[] byArray3 = new byte[(byArray2[0] & 0xFF) << 8 | byArray2[1] & 0xFF];
            xFile.read(byArray3, 0, byArray3.length);
            byArray3 = cb.b(byArray3, m);
            byArray[n2++] = byArray3[4];
            xFile.read(byArray2, 0, byArray2.length);
            byArray3 = new byte[(byArray2[0] & 0xFF) << 8 | byArray2[1] & 0xFF];
            xFile.read(byArray3, 0, byArray3.length);
            byArray3 = cb.b(byArray3, n);
            byArray[n2++] = byArray3[0];
            xFile.read(byArray2, 0, byArray2.length);
            byArray3 = new byte[(byArray2[0] & 0xFF) << 8 | byArray2[1] & 0xFF];
            xFile.read(byArray3, 0, byArray3.length);
            byArray3 = cb.b(byArray3, o);
            this.a(byArray3);
            byte by3 = (byte)(var_byte_j + this.byte_a());
            byArray[n2++] = by3 > 100 ? 100 : (int)by3;
            byArray[n2++] = var_byte_i;
            xFile.close();
        }
        catch (IOException iOException) {
            return null;
        }
        return byArray;
    }

    private final void x() {
        var_byte_i = 0;
        var_byte_j = 0;
        var_int_g = -1;
        this.u();
        this.v();
        u.var_byte_arr_j[0] = 1;
        this.p();
        this.o();
        this.q();
        var_java_util_Vector_a = new Vector(0);
        var_java_util_Vector_a.addElement(new cg(false));
        var_b_a.void_a((byte)0);
        var_b_a.void_f();
        var_b_a.boolean_b();
        var_b_a.n();
        this.z();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final byte[] byte_arr_b() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((OutputStream)filterOutputStream).write(p);
            ((OutputStream)filterOutputStream).write(q);
            ((OutputStream)filterOutputStream).write(r);
            ((OutputStream)filterOutputStream).write(var_byte_arr_j);
            ((DataOutputStream)filterOutputStream).writeByte(var_byte_i);
            ((DataOutputStream)filterOutputStream).writeByte(var_byte_j);
            int n2 = var_java_util_Vector_b.size();
            ((DataOutputStream)filterOutputStream).writeByte(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                byte[] byArray = (byte[])var_java_util_Vector_b.elementAt(i2);
                if (byArray == null) continue;
                ((OutputStream)filterOutputStream).write(byArray);
            }
            byte[] byArray = byteArrayOutputStream.toByteArray();
            return byArray;
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    ((OutputStream)byteArrayOutputStream).close();
                }
            }
            catch (IOException iOException) {}
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = null;
        FilterInputStream filterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(byArray);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            ((DataInputStream)filterInputStream).read(p);
            ((DataInputStream)filterInputStream).read(q);
            ((DataInputStream)filterInputStream).read(r);
            ((DataInputStream)filterInputStream).read(var_byte_arr_j);
            var_byte_i = ((DataInputStream)filterInputStream).readByte();
            var_byte_j = ((DataInputStream)filterInputStream).readByte();
            int n2 = ((DataInputStream)filterInputStream).readByte();
            var_java_util_Vector_b = new Vector(1);
            for (int i2 = 0; i2 < n2; ++i2) {
                byte[] byArray2 = new byte[2];
                ((DataInputStream)filterInputStream).read(byArray2);
                if (byArray2 == null) continue;
                var_java_util_Vector_b.addElement(byArray2);
            }
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    ((InputStream)byteArrayInputStream).close();
                }
            }
            catch (IOException iOException) {}
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final byte[] byte_arr_c() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            int n2 = var_java_util_Vector_a.size();
            ((DataOutputStream)filterOutputStream).writeByte(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                cg cg2 = (cg)var_java_util_Vector_a.elementAt(i2);
                if (cg2 == null) {
                    ((DataOutputStream)filterOutputStream).writeByte(0);
                    continue;
                }
                byte[] byArray = cg2.byte_arr_a();
                ((DataOutputStream)filterOutputStream).writeByte(byArray.length);
                ((OutputStream)filterOutputStream).write(byArray);
            }
            byte[] byArray = byteArrayOutputStream.toByteArray();
            return byArray;
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    ((OutputStream)byteArrayOutputStream).close();
                }
            }
            catch (IOException iOException) {}
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void b(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = null;
        FilterInputStream filterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(byArray);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            int n2 = ((DataInputStream)filterInputStream).readByte();
            var_java_util_Vector_a = new Vector(1);
            for (int i2 = 0; i2 < n2; ++i2) {
                byte by2 = ((DataInputStream)filterInputStream).readByte();
                if (by2 == 0) continue;
                byte[] byArray2 = new byte[by2];
                ((DataInputStream)filterInputStream).read(byArray2);
                cg cg2 = new cg(false);
                cg2.a(byArray2);
                var_java_util_Vector_a.addElement(cg2);
            }
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    ((InputStream)byteArrayInputStream).close();
                }
            }
            catch (IOException iOException) {}
        }
    }

    public final void l() throws IOException {
        this.g(var_byte_c);
        u.f(var_byte_c);
    }

    public final void a(boolean bl2) throws IOException {
        this.v();
        this.a(var_byte_c, bl2);
        this.h(var_byte_c);
        var_b_a.o();
        var_b_a.boolean_b();
        var_b_a.n();
        var_b_a.void_a(u.var_b_a.var_byte_r);
        var_b_a.void_f();
        for (int i2 = 0; i2 < var_byte_arr_j.length; ++i2) {
            u.var_int_arr_a[i2] = -1;
        }
    }

    private final void g(byte by2) throws IOException {
        byte[] byArray = var_ah_a.byte_arr_a();
        byte[] byArray2 = var_b_a.byte_arr_b();
        byte[] byArray3 = this.byte_arr_b();
        byte[] byArray4 = var_ci_b.byte_arr_a();
        byte[] byArray5 = this.byte_arr_c();
        int n2 = 0;
        byArray = cb.a(byArray, m);
        byArray2 = cb.a(byArray2, n);
        byArray3 = cb.a(byArray3, o);
        byArray4 = cb.a(byArray4, m);
        byArray5 = cb.a(byArray5, n);
        byte[] byArray6 = new byte[byArray.length + byArray2.length + byArray3.length + byArray4.length + byArray5.length + 14];
        f.a((short)byArray.length, byArray6, n2);
        System.arraycopy(byArray, 0, byArray6, n2 += 2, byArray.length);
        f.a((short)byArray2.length, byArray6, n2 += byArray.length);
        System.arraycopy(byArray2, 0, byArray6, n2 += 2, byArray2.length);
        f.a((short)byArray3.length, byArray6, n2 += byArray2.length);
        System.arraycopy(byArray3, 0, byArray6, n2 += 2, byArray3.length);
        f.a((short)byArray4.length, byArray6, n2 += byArray3.length);
        System.arraycopy(byArray4, 0, byArray6, n2 += 2, byArray4.length);
        f.a((short)byArray5.length, byArray6, n2 += byArray4.length);
        System.arraycopy(byArray5, 0, byArray6, n2 += 2, byArray5.length);
        n2 += byArray5.length;
        XFile xFile = new XFile(var_java_lang_String_arr_a[by2], 2);
        xFile.write(byArray6, 0, byArray6.length);
        xFile.close();
    }

    private final void a(byte by2, boolean bl2) throws IOException {
        byte[] byArray = new byte[2];
        XFile xFile = new XFile(var_java_lang_String_arr_a[by2], 1);
        xFile.read(byArray, 0, byArray.length);
        byte[] byArray2 = new byte[(byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF];
        xFile.read(byArray2, 0, byArray2.length);
        byArray2 = cb.b(byArray2, m);
        if (bl2) {
            h = byArray2[0];
            var_byte_e = byArray2[1];
            var_byte_f = byArray2[2];
            var_byte_g = byArray2[3];
        }
        var_byte_a = byArray2[4];
        this.p();
        this.o();
        xFile.read(byArray, 0, byArray.length);
        byArray2 = new byte[(byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF];
        xFile.read(byArray2, 0, byArray2.length);
        byArray2 = cb.b(byArray2, n);
        var_b_a.a(byArray2);
        xFile.read(byArray, 0, byArray.length);
        byArray2 = new byte[(byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF];
        xFile.read(byArray2, 0, byArray2.length);
        byArray2 = cb.b(byArray2, o);
        if (bl2) {
            this.a(byArray2);
        }
        xFile.read(byArray, 0, byArray.length);
        byArray2 = new byte[(byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF];
        xFile.read(byArray2, 0, byArray2.length);
        byArray2 = cb.b(byArray2, m);
        if (bl2) {
            var_ci_b.a(byArray2);
        }
        xFile.read(byArray, 0, byArray.length);
        byArray2 = new byte[(byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF];
        xFile.read(byArray2, 0, byArray2.length);
        byArray2 = cb.b(byArray2, n);
        this.b(byArray2);
        xFile.close();
    }

    public static final void f(byte by2) throws IOException {
        byte[] byArray = u.byte_arr_a();
        byte[] byArray2 = var_ci_a.byte_arr_a();
        byte[] byArray3 = var_ci_c.byte_arr_a();
        int n2 = 0;
        byArray = cb.a(byArray, o);
        byArray2 = cb.a(byArray2, m);
        byArray3 = cb.a(byArray3, n);
        byte[] byArray4 = new byte[byArray.length + byArray2.length + byArray3.length + 6];
        f.a((short)byArray.length, byArray4, n2);
        System.arraycopy(byArray, 0, byArray4, n2 += 2, byArray.length);
        f.a((short)byArray2.length, byArray4, n2 += byArray.length);
        System.arraycopy(byArray2, 0, byArray4, n2 += 2, byArray2.length);
        f.a((short)byArray3.length, byArray4, n2 += byArray2.length);
        System.arraycopy(byArray3, 0, byArray4, n2 += 2, byArray3.length);
        n2 += byArray3.length;
        XFile xFile = new XFile(var_java_lang_String_arr_b[by2], 2);
        xFile.write(byArray4, 0, byArray4.length);
        xFile.close();
    }

    private final void h(byte by2) throws IOException {
        byte[] byArray = new byte[2];
        XFile xFile = new XFile(var_java_lang_String_arr_b[by2], 1);
        xFile.read(byArray, 0, byArray.length);
        byte[] byArray2 = new byte[(byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF];
        xFile.read(byArray2, 0, byArray2.length);
        byArray2 = cb.b(byArray2, o);
        this.c(byArray2);
        xFile.read(byArray, 0, byArray.length);
        byArray2 = new byte[(byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF];
        xFile.read(byArray2, 0, byArray2.length);
        byArray2 = cb.b(byArray2, m);
        var_ci_a.a(byArray2);
        var_ci_a.int_a();
        xFile.read(byArray, 0, byArray.length);
        byArray2 = new byte[(byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF];
        xFile.read(byArray2, 0, byArray2.length);
        byArray2 = cb.b(byArray2, n);
        var_ci_c.a(byArray2);
        xFile.close();
    }

    public static byte[] byte_arr_a() {
        int n2 = 13;
        byte[] byArray = new byte[n2];
        int n3 = 0;
        f.a(var_int_f ^ 0xD9A4F1B8, byArray, n3);
        f.a(var_int_g ^ 0xA1F084DE, byArray, n3 += 4);
        n3 += 4;
        byArray[n3++] = u.var_b_a.var_byte_b;
        f.a(var_int_f ^ 0xA1F084DE, byArray, n3);
        return byArray;
    }

    private void c(byte[] byArray) {
        int n2 = 0;
        var_int_f = f.int_a(byArray, n2) ^ 0xD9A4F1B8;
        var_int_g = f.int_a(byArray, n2 += 4) ^ 0xA1F084DE;
        n2 += 4;
        u.var_b_a.var_byte_b = byArray[n2++];
        int n3 = f.int_a(byArray, n2) ^ 0xA1F084DE;
        if (n3 != var_int_f) {
            var_int_f = 0;
        }
    }

    private final void y() {
        var_byte_j = (byte)(var_byte_j + this.byte_a());
        if (var_byte_i < 2) {
            var_byte_i = (byte)(var_byte_i + 1);
        }
        if (var_byte_j > 100) {
            var_byte_j = (byte)100;
        }
        var_ci_a.c();
        u.var_b_a.var_int_a = u.var_b_a.var_int_d;
        u.var_b_a.var_int_b = u.var_b_a.var_int_e;
        this.z();
        this.u();
        var_b_a.void_a(u.var_b_a.var_byte_r);
        var_b_a.void_f();
    }

    private final byte byte_a() {
        if (var_byte_i < 0) {
            return 0;
        }
        byte by2 = 0;
        for (int i2 = 0; i2 < 51; ++i2) {
            if (u.byte_a(i2) != 2) continue;
            by2 = (byte)(by2 + 1);
        }
        return (byte)(by2 * var_byte_arr_l[var_byte_i] / 51);
    }

    private void z() {
        h = n.i[0];
        var_byte_e = n.i[1];
        var_byte_f = n.i[2];
        var_byte_g = n.i[3];
    }

    static {
        var_byte_arr_i = new byte[]{1, 4, 7};
        var_byte_arr_l = new byte[]{50, 30, 20};
        var_java_lang_String_arr_a = new String[]{"/g1", "/g2", "/g3"};
        var_java_lang_String_arr_b = new String[]{"/n1", "/n2", "/n3"};
        m = new byte[]{5, 71, 24, 59, 43, 16};
        n = new byte[]{14, 26, 72, 10, 28, 98};
        o = new byte[]{67, 12, 35, 68, 91, 43};
        var_boolean_arr_a = new boolean[]{false, false, false, true, true};
        p = new byte[32];
        q = new byte[32];
        var_byte_a = 1;
        var_java_lang_Object_arr_a = null;
        var_byte_b = 0;
        var_byte_c = 0;
        var_byte_d = 0;
        var_int_a = 0;
        var_byte_arr_j = new byte[4];
        var_int_arr_a = new int[4];
        r = new byte[]{0, 7, 22};
        var_byte_k = 0;
        var_byte_l = 0;
        var_u_a = new u();
    }
}

