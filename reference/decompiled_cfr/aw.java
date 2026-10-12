/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class aw
extends g {
    public int var_int_a = 0;
    public int b = 0;
    public int c = 0;
    public Vector var_java_util_Vector_a;
    public byte var_byte_a;

    public aw(g g2) {
        super(g2, (byte)28);
        this.f = true;
        this.h = 0;
        this.var_java_util_Vector_a = u.var_ci_a.var_java_util_Vector_a;
        this.a();
        this.var_byte_a = 0;
    }

    public void a() {
        this.var_int_a = this.var_java_util_Vector_a.size() - 1;
        this.c = 0;
        if (this.h >= this.var_int_a) {
            this.h = (byte)(this.var_int_a - 1);
        }
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.var_byte_a == 2 && (n2 == 8 || n3 == 53)) {
            if (u.var_ci_a.var_java_util_Vector_a.size() > 1) {
                this.var_byte_a = 0;
            } else {
                this.var_g_a.a((byte)5, (byte)4);
                return true;
            }
        }
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (this.var_byte_a == 1) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.a((byte)5, (byte)4);
        } else {
            if (n2 == 8 || n3 == 53) {
                cp cp2 = u.var_ci_a.cp_a(this.h + 1);
                if (cp2.g == 33) {
                    ((g)this).b = new bx((g)this, o.var_e_a.a(24));
                } else if (cp2 instanceof p && ((p)cp2).f > -1) {
                    ((g)this).b = new bx((g)this, o.var_e_a.a(25));
                } else {
                    this.a((byte)2, 2, new byte[][]{o.var_e_a.a(22)});
                }
                return true;
            }
            if (n2 == 1 || n3 == 50) {
                this.h = (byte)((this.h + this.var_int_a - 1) % this.var_int_a);
            } else if (n2 == 6 || n3 == 56) {
                this.h = (byte)((this.h + 1) % this.var_int_a);
            }
        }
        return true;
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        cp cp2 = u.var_ci_a.cp_a(this.h + 1);
        this.b = cp2.d >> 2;
        if (by2 == 2 & by3 == 0) {
            this.c = 1;
            if (cp2.c > 1) {
                ((g)this).b = new bs(this, this.b, cp2.c);
            } else {
                this.var_byte_a = 1;
            }
        } else if (by2 == 50) {
            this.c = by3;
            this.var_byte_a = 1;
        }
    }

    public void b() {
        u.var_ci_a.a((byte)(this.h + 1), this.c);
        u.g(this.b * this.c);
        this.a();
        ((g)this).b = new bx((g)this, o.var_e_a.a(21));
        this.var_byte_a = (byte)2;
    }

    public void void_a(int n2, int n3) {
        int n4;
        if (this.var_byte_a == 1) {
            this.b();
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        int n5 = this.h / 6;
        g.a(graphics, n2, n3, false, false);
        graphics.setColor(0x7F7F7F);
        bk.a(graphics, bw.i, n3 + 2, o.var_e_a.a(2), 1, 1);
        int n6 = n2 + -26 + 14 + 1;
        int n7 = n3 + 20;
        graphics.setColor(0);
        graphics.fillRect(n6, n7, 155, 89);
        int n8 = 0;
        int n9 = 0;
        for (n4 = 0; n4 < 6; ++n4) {
            cp cp2 = this.a(n4 + n5 * 6);
            if (cp2 != null) {
                graphics.setColor(0);
                graphics.fillRect(n2 + -26, n3 + 20 + n4 * 15, 14, 14);
                if (n4 == this.h % 6) {
                    this.a(graphics, n6 + 2, n7 + 2, cp2, true, true, true);
                }
                n8 = n2 + 1 + -26;
                n9 = n3 + 1 + 20 + n4 * 15;
                bd.a(n8, n9, cp2.g);
                if (cp2 instanceof p && ((p)cp2).f > -1) {
                    graphics.setColor(0xFF0000);
                    graphics.drawRect(n2 + -26 - 1, n3 + 20 - 1 + n4 * 15, 15, 15);
                }
                if (cp2.c > 1) {
                    f.a(graphics, cp2.c, n8 + 14 - 2, n9 + 14 - 8, 8, 0);
                    graphics.setClip(n2 + -35, n3, 190, 117);
                }
            }
            cp2 = null;
        }
        n4 = n2 + 120 - 7;
        this.b(graphics, n4, n3 + 13, this.h + 1, this.var_int_a);
        this.c(graphics, n4, n3 + 117 - 7, u.var_int_f);
    }

    public void void_b(int n2, int n3) {
        int n4 = this.h % 6;
        this.a(n2 + -26, n3 + 20 + n4 * 15, 13, 13);
    }

    public cp a(int n2) {
        return u.var_ci_a.cp_a(n2 + 1);
    }
}

