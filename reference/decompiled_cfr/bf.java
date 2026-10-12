/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class bf
extends g {
    public ci var_ci_a = null;
    public boolean var_boolean_a;

    public bf(g g2, ci ci2, boolean bl2) {
        super(g2, (byte)28, (byte)4, (byte)7);
        this.l = 0;
        this.f = true;
        this.var_ci_a = ci2;
        this.var_boolean_a = bl2;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.b(1);
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            cp cp2 = this.var_ci_a.cp_a((int)this.h);
            if (cp2 == null) {
                return true;
            }
            if (cp2.g == 29) {
                this.b = new bf(this, u.var_ci_b, false);
            } else if (this.var_ci_a.boolean_b(cp2.g)) {
                this.a((byte)6, 3, ck.var_e_a.a(30, 31, 28));
            } else if (cp2.g == 28) {
                this.a((byte)7, 3, ck.var_e_a.a(30, 31, 28));
            } else if (!this.var_ci_a.boolean_a(cp2.g, cp2.h)) {
                this.a((byte)3, 1, new byte[][]{ck.var_e_a.a(31)});
            } else {
                this.a((byte)3, 2, ck.var_e_a.a(31, 28));
            }
            return true;
        }
        if (this.boolean_d(n2, n3)) {
            return true;
        }
        return this.e(n2, n3);
    }

    public void a(byte by2, byte by3) {
        this.b(by3);
        b b2 = u.var_b_a;
        if (by2 == 7 && by3 == 0) {
            if (u.var_ah_a.var_byte_b >= ah.var_byte_a) {
                this.b = new bx((g)this, ck.var_e_a.a(77));
            } else {
                this.a((byte)11, 2, new byte[][]{ck.var_e_a.a(48)});
            }
        } else if (by2 == 6 && by3 == 0) {
            b2.void_d(this.h);
        } else if (by2 == 6 && by3 == 2 || by2 == 3 && by3 == 1 || by2 == 7 && by3 == 2) {
            this.a((byte)10, 2, new byte[][]{ck.var_e_a.a(47)});
        } else if (by2 == 6 && by3 == 1 || by2 == 3 && by3 == 0 || by2 == 7 && by3 == 1) {
            this.b = new aq((g)this, this.var_ci_a.cp_a((int)this.h));
        } else if (by2 == 10 && by3 == 0) {
            if (this.var_ci_a.a(this.var_ci_a.cp_a((int)this.h))) {
                this.b = new bx((g)this, ck.var_e_a.a(55));
            } else {
                this.var_ci_a.void_b(this.h);
            }
        } else if (by2 == 11 && by3 == 0) {
            this.var_ci_a.a(this.h, 1);
            this.var_g_a.b(0);
            u.a((byte)7, (byte)2);
        }
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, false, true);
        graphics.setColor(0);
        graphics.fillRect(n2 + 5, n3 + 14, 110, 14);
        graphics.fillRect(n2 + -35, n3 + 117 - 24, 217, 24);
        int n4 = 0;
        int n5 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int i3 = 0; i3 < 7; ++i3) {
                n4 = n2 + 7 + i3 * 15;
                n5 = n3 + 31 + i2 * 15;
                graphics.setColor(0);
                graphics.fillRect(n4, n5, 14, 14);
                cp cp2 = this.var_ci_a.cp_a(i2 * 7 + i3);
                if (cp2 == null) continue;
                bd.a(n4 + 1, n5 + 1, cp2.g == 23 ? (byte)29 : (byte)cp2.g);
                if (cp2.c > 1) {
                    f.a(graphics, cp2.c, n4 + 14 - 1, n5 + 14 - 7, 8, 0);
                }
                if (!this.var_ci_a.a(cp2)) continue;
                graphics.setColor(0xFF0000);
                graphics.drawRect(n4 - 1, n5 - 1, 15, 15);
            }
        }
        this.a(graphics, n2 + -12, n3 + 117 - 22, this.var_ci_a.cp_a((int)this.h), false, false, false);
        graphics.setClip(n2, n3, 120, 117);
        graphics.setColor(0x7F7F7F);
        bk.a(graphics, n2 + 11, n3 + 16, this.var_boolean_a ? as.var_e_a.a(20) : ck.var_e_a.a(57), 0);
        if (this.var_boolean_a) {
            this.c(graphics, n2 + 111, n3 + 18, u.var_int_f);
        }
    }

    public void void_b(int n2, int n3) {
        int n4 = this.h / 7;
        int n5 = this.h % 7;
        int n6 = n2 + 7 + n5 * 15;
        int n7 = n3 + 31 + n4 * 15;
        this.a(n6, n7, 13, 13);
    }
}

