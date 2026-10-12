/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;

public class o
extends g {
    public static e var_e_a;
    public static int var_int_a;
    public static int var_int_b;
    public static o var_o_a;
    public static Vector[] var_java_util_Vector_arr_a;
    public byte[][] var_byte_arr_arr_b;
    public int c;

    public static final o o_a() {
        if (var_o_a == null) {
            var_o_a = new o();
            var_int_a = bw.g - 120 >> 1;
            var_int_b = bw.h - 117 >> 1;
        }
        return var_o_a;
    }

    public o() {
        super(null, (byte)2);
    }

    public void void_a() {
        try {
            if (var_java_util_Vector_arr_a == null) {
                cp.java_util_Vector_arr_a();
            }
            var_e_a = new e("/t/shop");
            this.var_byte_arr_arr_b = var_e_a.a(0, 1, 2);
            this.f = true;
            this.c = 6 + 16 * this.var_byte_arr_arr_b.length;
            bd.var_bd_a.b();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void c() {
        var_o_a = null;
        var_e_a = null;
        u.h(3);
        cj.var_cj_a.f();
        bd.var_boolean_a = true;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.c();
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            if (this.h == 0) {
                this.a((byte)5, 3, var_e_a.a(3, 4, 5, 16));
            } else {
                ((g)this).b = u.var_ci_a.var_java_util_Vector_a.size() > 1 ? new aw(this) : new bx((g)this, var_e_a.a(23));
            }
        }
        return this.boolean_c(n2, n3);
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        if (by2 == 5) {
            switch (by3) {
                case 0: {
                    ((g)this).b = new k(this, 0);
                    break;
                }
                case 1: {
                    ((g)this).b = new k(this, 1);
                    break;
                }
                case 2: {
                    ((g)this).b = new k(this, 2);
                    break;
                }
                default: {
                    this.h = (byte)(by3 == 4 ? 1 : 0);
                }
            }
        }
    }

    public void void_a(int n2, int n3) {
        ba.a(bw.var_javax_microedition_lcdui_Graphics_a, this.var_byte_arr_arr_b, this.c);
    }

    public void b() {
        this.void_c(var_int_a, var_int_b);
    }

    public void void_b(int n2, int n3) {
        int n4 = 0;
        int n5 = 0;
        n4 = bw.i - 85;
        n5 = (bw.h - this.c >> 1) + 12 + 10;
        this.a(n4, n5 + 15 * this.h, 169, 13);
    }
}

