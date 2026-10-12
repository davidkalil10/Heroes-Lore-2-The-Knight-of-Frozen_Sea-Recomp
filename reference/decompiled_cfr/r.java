/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.util.Vector;

public abstract class r
extends g
implements Runnable {
    public static byte var_byte_c;
    public static byte var_byte_d;
    public static int var_int_c;
    public static int var_int_d;
    public static byte e;
    public static byte f;
    public static cp var_cp_a;
    public static boolean var_boolean_b;
    public static Vector var_java_util_Vector_b;
    public static e var_e_a;
    public byte g;
    public static long var_long_a;
    public static r var_r_a;
    private Object var_java_lang_Object_a = new Object();
    public boolean var_boolean_c;

    public r(g g2, byte by2) {
        super(g2, by2);
        var_boolean_b = false;
    }

    public boolean boolean_a(int n2) {
        if (var_byte_c == 2 || var_byte_c == 1) {
            if (n2 == 8) {
                this.b(0);
                this.d();
            }
            return true;
        }
        return false;
    }

    public void d() {
        cj.var_byte_b = this.g;
        if (cj.var_boolean_b) {
            ak.a((byte)1, true);
        }
        af.boolean_a();
        this.e();
        this.var_g_a.b(0);
    }

    public void e() {
        ck.var_e_a = null;
        var_e_a = null;
        var_java_util_Vector_b = null;
        this.f();
    }

    public void b(byte by2) {
        var_byte_c = by2;
        switch (var_byte_c) {
            case 1: {
                var_r_a = this;
                ak.c();
                ak.b();
                this.a((byte)2, 0);
                new Thread(var_r_a).start();
                break;
            }
            case 3: {
                var_byte_d = (byte)-1;
                break;
            }
            case 10: {
                var_byte_d = (byte)-1;
                af.boolean_a();
                this.a((byte)2, 2, var_e_a.a(2, 3, 4));
                break;
            }
            case 11: {
                var_byte_d = (byte)-1;
                af.boolean_a();
                ((g)this).b = new bx((g)this, var_e_a.a(22));
            }
        }
    }

    public final void a(byte by2, int n2) {
        if (var_byte_d != -1 || var_byte_c == 2 || var_byte_c == 11) {
            return;
        }
        var_byte_c = (byte)2;
        var_byte_d = by2;
        ((g)this).b = new bx(this, var_e_a.a(n2), true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        this.var_boolean_c = true;
        try {
            while (this.var_boolean_c) {
                Object object = this.var_java_lang_Object_a;
                synchronized (object) {
                    this.boolean_b();
                    while (var_byte_d == -1) {
                        if (!af.c() || var_byte_c == 11 || var_byte_c == 10) {
                            this.var_boolean_c = false;
                            throw new Exception();
                        }
                        try {
                            Thread.sleep(500L);
                        }
                        catch (Exception exception) {}
                    }
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.b((byte)10);
        this.var_boolean_c = false;
    }

    public final boolean boolean_b() throws Exception {
        byte by2 = var_byte_d;
        var_byte_d = (byte)-1;
        byte[] byArray = null;
        byte[] byArray2 = null;
        switch (by2) {
            case 2: {
                ++u.var_int_g;
                u.f(u.var_byte_c);
                af.a("211.239.150.70", "30000", n.var_boolean_a);
                while (af.boolean_b()) {
                    this.wait(200L);
                }
                if (!af.c()) {
                    this.b((byte)11);
                    return false;
                }
                new j().start();
                new c().start();
                ((g)this).b = new bx(this, var_e_a.a(1), true);
                byArray = new byte[41];
                byArray[0] = 1;
                System.arraycopy(u.var_byte_arr_k, 0, byArray, 1, u.var_byte_arr_k.length);
                System.arraycopy(("S_V.1.0.2" + u.var_byte_c).getBytes(), 0, byArray, 17, ("S_V.1.0.2" + u.var_byte_c).getBytes().length);
                f.a(u.var_int_g, byArray, 37);
                byArray2 = af.a((byte)2, byArray);
                break;
            }
            case 6: {
                b b2 = u.var_b_a;
                byArray = b2.byte_arr_a();
                byArray2 = af.a((byte)6, byArray);
                af.boolean_a(byArray2);
                byArray2 = af.a((byte)5);
                break;
            }
            case 17: {
                byArray2 = af.a((byte)17);
                break;
            }
            case 20: {
                byArray = new byte[4];
                f.a(var_int_d, byArray, 0);
                byArray2 = af.a((byte)20, byArray);
                af.boolean_a(byArray2);
                u.g(-var_int_d);
                u.f(u.var_byte_c);
                return true;
            }
            case 10: {
                byArray2 = af.a((byte)10, (byte)0);
                break;
            }
            case 19: {
                cp cp2 = e > 0 ? u.var_ci_a.cp_a((int)e) : u.var_ci_c.cp_a(-e - 1);
                var_cp_a = cp.a(cp2.byte_arr_a());
                r.var_cp_a.c = e >= 0 ? f : cp2.c;
                byte[] byArray3 = var_cp_a.byte_arr_a();
                byArray = new byte[1 + byArray3.length];
                byArray[0] = (byte)byArray3.length;
                System.arraycopy(byArray3, 0, byArray, 1, byArray3.length);
                if (e >= 0) {
                    u.var_ci_a.a(e, (int)f);
                } else {
                    u.var_ci_c.void_b((byte)(-e - 1));
                }
                var_boolean_b = true;
                u.f(u.var_byte_c);
                byArray2 = af.a((byte)19, byArray);
                break;
            }
            case 11: {
                byArray2 = af.a((byte)11, r.var_cp_a.f);
                break;
            }
            default: {
                return false;
            }
        }
        af.boolean_a(byArray2);
        return true;
    }

    public boolean boolean_a(byte[] byArray) throws IOException {
        if (byArray == null || var_byte_c == 10 || var_byte_c == 11) {
            return false;
        }
        int n2 = 0;
        int n3 = -1;
        int n4 = 9;
        switch (byArray[n2++]) {
            case 1: {
                c.void_a();
                return false;
            }
            case 2: {
                byte by2 = byArray[n2++];
                switch (by2) {
                    case 0: {
                        break;
                    }
                    case 1: 
                    case 2: {
                        byte by3 = byArray[n2++];
                        byte[] byArray2 = new byte[by3];
                        System.arraycopy(byArray, n2, byArray2, 0, by3);
                        n2 += by3;
                        u.var_b_a.var_byte_b = byArray[n2++];
                        u.f(u.var_byte_c);
                        n2 += 12;
                    }
                }
                this.b((byte)3);
                this.a((byte)6, 6);
                break;
            }
            case 5: {
                byte by4 = byArray[n2++];
                int n5 = f.int_a(byArray, n2);
                byte[] byArray3 = new byte[n5];
                System.arraycopy(byArray, n2 += 4, byArray3, 0, n5);
                n2 += n5;
                ((g)this).b = new az(this, byArray3, by4 == 7);
                this.b((byte)3);
                break;
            }
            case 17: {
                var_int_c = f.int_a(byArray, n2);
                this.b((byte)3);
                ((g)this).b = new aa(this);
                break;
            }
            case 20: {
                n3 = byArray[n2++];
                var_int_c = f.int_a(byArray, n2);
                if (n3 != 0) {
                    u.var_int_f += var_int_d;
                    u.f(u.var_byte_c);
                    n4 = 17;
                }
                this.f();
                this.void_a(n4);
                break;
            }
            case 10: {
                this.a(byArray, n2);
                this.b((byte)3);
                ((g)this).b = new a(this);
                break;
            }
            case 19: {
                boolean bl2;
                n3 = byArray[n2++];
                boolean bl3 = bl2 = e < 0;
                if (n3 != 0) {
                    if (e > 0) {
                        u.var_ci_a.a(var_cp_a, f);
                    } else {
                        u.var_ci_c.a(var_cp_a, f);
                    }
                    u.f(u.var_byte_c);
                    int n6 = n4 = n3 == 1 ? 20 : 17;
                }
                if (!bl2) {
                    this.a(byArray, n2);
                }
                this.f();
                this.void_a(n4);
                break;
            }
            case 11: {
                n3 = byArray[n2++];
                if (n3 == 0) {
                    if (f > 0) {
                        cp cp2 = (cp)var_java_util_Vector_b.elementAt(e);
                        u.var_ci_a.a(cp.a(cp2.byte_arr_a()), f);
                        u.f(u.var_byte_c);
                    }
                } else {
                    n4 = 17;
                }
                this.a(byArray, n2);
                this.f();
                this.void_a(n4);
            }
        }
        return true;
    }

    public void f() {
        var_int_d = 0;
        e = 0;
        f = 0;
        var_cp_a = null;
    }

    public void void_a(int n2) {
        ((g)this).b.b = new bx(((g)this).b, var_e_a.a(n2));
        this.b((byte)3);
    }

    public void void_c(int n2, int n3) {
        if (!af.c()) {
            if (var_byte_c == 3) {
                this.b((byte)10);
            }
        } else if (var_byte_c != 10 && var_byte_c != 11) {
            if (System.currentTimeMillis() - var_long_a > 300000L) {
                af.boolean_a();
                this.b((byte)10);
            } else if (af.d()) {
                byte[] byArray = af.byte_arr_b();
                try {
                    this.boolean_a(byArray);
                }
                catch (IOException iOException) {
                    af.boolean_a();
                    this.b((byte)10);
                }
            }
        }
        super.void_c(n2, n3);
    }

    public final void a(byte[] byArray, int n2) {
        byte[] byArray2 = new byte[byArray.length - n2];
        System.arraycopy(byArray, n2, byArray2, 0, byArray2.length);
        this.void_a(byArray2);
        var_boolean_b = true;
    }

    public void void_a(byte[] byArray) {
        int n2 = 1;
        int n3 = byArray[n2++];
        var_java_util_Vector_b = null;
        if (n3 > 0) {
            var_java_util_Vector_b = new Vector(n3);
            byte by2 = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                if ((by2 = byArray[n2++]) <= 0) continue;
                byte[] byArray2 = new byte[by2];
                System.arraycopy(byArray, n2, byArray2, 0, by2);
                n2 += by2;
                cp cp2 = cp.a(byArray2);
                if (cp2 == null) continue;
                var_java_util_Vector_b.addElement(cp2);
            }
        }
    }

    static {
        var_int_c = 0;
    }
}

