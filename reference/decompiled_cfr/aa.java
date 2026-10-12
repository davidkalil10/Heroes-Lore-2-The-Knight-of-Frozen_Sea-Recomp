/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class aa
extends r {
    public aa(g g2) {
        super(g2, (byte)2);
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (this.boolean_a(n3)) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.b(0);
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            int n4;
            int n5 = n4 = this.h == 0 ? u.var_int_f : r.var_int_c;
            ((g)this).b = n4 < 1 ? new bx((g)this, r.var_e_a.a(18)) : new cr(this, n4, this.h == 0);
            return true;
        }
        return this.boolean_c(n2, n3);
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        if (by2 == 80 && r.var_int_d != 0) {
            this.a((byte)20, 5);
        }
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        this.a(graphics, 60, 65, n2, n3, false);
        int n4 = 14;
        int n5 = 112;
        int n6 = bw.i - (n5 >> 1);
        graphics.setColor(0);
        graphics.fillRect(n6, bw.j - 37, n5, n4);
        graphics.fillRect(n6, bw.j + 38 - n4, n5, n4);
        int n7 = bw.i - 32;
        int n8 = bw.j - 37;
        int n9 = bw.i + 50;
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n7, n8 + 2, r.var_e_a.a(11), 0, 1);
        this.c(graphics, n9, n8 + 4, r.var_int_c);
        n8 = bw.j + 38 - n4;
        bk.a(graphics, n7, n8 + 2, r.var_e_a.a(12), 0, 1);
        this.c(graphics, n9, n8 + 4, u.var_int_f);
    }
}

