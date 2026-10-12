/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class k
extends g {
    public byte var_byte_a = 0;
    public byte var_byte_b = 0;
    public int var_int_a = 0;
    public byte var_byte_c = 0;
    public boolean var_boolean_a;
    public int var_int_b = 0;
    public int var_int_c = 0;
    public Vector var_java_util_Vector_a;

    public k(g g2, byte by2) {
        super(g2, (byte)6);
        this.f = true;
        this.var_boolean_a = false;
        this.var_byte_a = by2;
        this.var_int_c = 0;
        this.var_byte_c = 0;
        this.var_byte_b = this.var_byte_a == 2 ? (byte)1 : (byte)5;
        this.a();
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.a((byte)5, (byte)3);
        } else {
            if (n2 == 8 || n3 == 53) {
                this.a((byte)2, 2, new byte[][]{o.var_e_a.a(17)});
                return true;
            }
            if (n2 == 1 || n3 == 50) {
                this.h = (byte)((this.h + this.var_int_a - 1) % this.var_int_a);
            } else if (n2 == 6 || n3 == 56) {
                this.h = (byte)((this.h + 1) % this.var_int_a);
            } else if (n2 == 2 || n3 == 52) {
                this.var_byte_c = (byte)((this.var_byte_c + this.var_byte_b - 1) % this.var_byte_b);
                this.var_boolean_a = true;
            } else if (n2 == 5 || n3 == 54) {
                this.var_byte_c = (byte)((this.var_byte_c + 1) % this.var_byte_b);
                this.var_boolean_a = true;
            }
        }
        return true;
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        cp cp2 = this.a(this.h);
        if (by2 == 2 & by3 == 0) {
            this.var_int_b = cp2.d;
            if (this.var_int_b > u.var_int_f) {
                ((g)this).b = new bx((g)this, o.var_e_a.a(18));
            } else if (!u.var_ci_a.a(cp2.g, cp2.h, 1)) {
                ((g)this).b = new bx((g)this, as.var_e_c.a(7));
            } else if (this.var_byte_a == 2) {
                ((g)this).b = new bs(this, cp2.d, 99);
            } else {
                this.a(cp2.g, cp2.h, 1);
            }
        } else if (by2 == 50) {
            byte by4 = by3;
            this.var_int_b = cp2.d * by4;
            if (this.var_int_b > u.var_int_f) {
                ((g)this).b = new bx((g)this, o.var_e_a.a(18));
            } else if (!u.var_ci_a.a(cp2.g, cp2.h, (int)by4)) {
                ((g)this).b = new bx((g)this, as.var_e_c.a(7));
            } else {
                this.a(cp2.g, cp2.h, by4);
            }
        }
    }

    public void a(byte by2, byte by3, int n2) {
        if (ci.boolean_a(by2)) {
            u.var_ci_b.a(cp.a(by2, by3, true, false), (byte)n2);
        } else {
            u.var_ci_a.a(cp.a(by2, by3, true, false), (byte)n2);
        }
        u.var_int_f -= this.var_int_b;
        ((g)this).b = new bx((g)this, o.var_e_a.a(20));
    }

    public void a() {
        this.var_java_util_Vector_a = o.var_java_util_Vector_arr_a[this.var_byte_a * 5 + this.var_byte_c];
        this.var_int_a = this.var_java_util_Vector_a.size();
    }

    public void void_a(int n2, int n3) {
        int n4;
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        if (this.var_boolean_a) {
            this.a();
            this.h = 0;
            this.var_boolean_a = false;
        }
        int n5 = this.h / 6;
        g.a(graphics, n2, n3, false, false);
        this.c(graphics, n2 + 16, n3);
        int n6 = n2 + -26 + 14 + 1;
        int n7 = n3 + 20;
        graphics.setColor(0);
        graphics.fillRect(n6, n7, 155, 89);
        for (n4 = 0; n4 < 6; ++n4) {
            cp cp2 = this.a(n4 + n5 * 6);
            if (cp2 != null) {
                graphics.setColor(0);
                graphics.fillRect(n2 + -26, n3 + 20 + n4 * 15, 14, 14);
                if (n4 == this.h % 6) {
                    this.a(graphics, n6 + 2, n7 + 2, cp2, true, true, false);
                }
                bd.a(n2 + 1 + -26, n3 + 1 + 20 + n4 * 15, cp2.g);
            }
            cp2 = null;
        }
        n4 = n2 + 120 - 7;
        this.b(graphics, n4, n3 + 13, this.h + 1, this.var_int_a);
        this.c(graphics, n4, n3 + 117 - 7, u.var_int_f);
    }

    public void c(Graphics graphics, int n2, int n3) {
        graphics.setColor(6970180);
        graphics.fillRect(n2 - 19, n3, 126, 13);
        graphics.setColor(15128512);
        bk.a(graphics, n2 + 44, n3 + 2, o.var_e_a.a(6 + this.var_byte_a * 5 + this.var_byte_c), 1, 1);
        if (this.var_byte_a != 2) {
            this.b(graphics, n2 - 29, n3 + 6, 145, 0x7F7F7F, true);
        }
    }

    public cp a(int n2) {
        if (n2 < this.var_java_util_Vector_a.size()) {
            return (cp)this.var_java_util_Vector_a.elementAt(n2);
        }
        return null;
    }

    public void void_b(int n2, int n3) {
        int n4 = this.h % 6;
        this.a(n2 + -26, n3 + 20 + n4 * 15, 14, 14);
    }
}

