/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class h
extends g {
    public byte[] i;
    public byte[] j;
    public byte var_byte_a;
    public ci var_ci_a;

    public h(g g2, byte by2, byte[] byArray, byte[] byArray2, boolean bl2) {
        super(g2, (byte)28, (byte)4, (byte)7);
        this.l = 0;
        this.f = true;
        this.i = byArray2;
        this.var_byte_a = by2;
        this.j = byArray;
        this.var_ci_a = bl2 ? u.var_ci_a : u.var_ci_b;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.a(this.var_byte_a, (byte)-1);
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            cp cp2 = this.a(this.h);
            if (cp2 == null) {
                return true;
            }
            if (cp2 instanceof p && ((p)cp2).f > -1) {
                this.b = new bx((g)this, ck.var_e_a.a(68));
            } else {
                this.var_g_a.a(this.var_byte_a, this.i == null ? this.h : this.i[this.h]);
            }
            return true;
        }
        if (this.boolean_d(n2, n3)) {
            return true;
        }
        return this.e(n2, n3);
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, false, false);
        graphics.setColor(0);
        graphics.fillRect(n2 - 35, n3 + 117 - 24, 217, 24);
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int i3 = 0; i3 < 7; ++i3) {
                graphics.setColor(0);
                n4 = n2 + 7 + i3 * 15;
                n5 = n3 + 23 + i2 * 15;
                graphics.fillRect(n4, n5, 14, 14);
                n6 = i2 * 7 + i3;
                cp cp2 = this.a(n6);
                if (cp2 == null) continue;
                bd.a(n4 + 1, n5 + 1, cp2.g == 23 ? (byte)29 : (byte)cp2.g);
                if (cp2.c > 1) {
                    f.a(graphics, cp2.c, n4 + 14 - 1, n5 + 14 - 7, 8, 0);
                }
                if (!(cp2 instanceof p) || ((p)cp2).f <= -1) continue;
                graphics.setColor(0xFF0000);
                graphics.drawRect(n4 - 1, n5 - 1, 15, 15);
            }
        }
        graphics.setColor(0x7F7F7F);
        bk.a(graphics, bw.i, n3 + 1, this.j, 0, 1);
        this.a(graphics, n2 - 12, n3 + 117 - 22, this.a(this.h), false, false, false);
    }

    public cp a(int n2) {
        cp cp2 = this.i != null ? (n2 < this.i.length ? this.var_ci_a.cp_a((int)this.i[n2]) : null) : this.var_ci_a.cp_a(n2);
        return cp2;
    }

    public void void_b(int n2, int n3) {
        int n4 = this.h / 7;
        int n5 = this.h % 7;
        int n6 = n2 + 7 + n5 * 15;
        int n7 = n3 + 23 + n4 * 15;
        this.a(n6, n7, 13, 13);
    }
}

