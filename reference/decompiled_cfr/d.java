/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class d
extends g {
    public int var_int_a = 0;
    public byte[] i;
    public byte[] j;
    public byte var_byte_a;

    public d(g g2, byte by2, byte[] byArray, byte[] byArray2) {
        super(g2, (byte)28, (byte)6, (byte)1);
        ((g)this).i = (byte)byArray.length;
        this.l = 0;
        this.f = true;
        this.i = byArray;
        this.var_byte_a = by2;
        this.j = byArray2;
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
            this.var_g_a.a(this.var_byte_a, this.i[this.h]);
            return true;
        }
        return this.e(n2, n3);
    }

    public void d(byte by2) {
        if (by2 == 4) {
            this.h = (byte)(this.h + 1);
            if (this.h >= ((g)this).i) {
                this.h = 0;
            }
        } else {
            this.h = (byte)(this.h - 1);
            if (this.h < 0) {
                this.h = (byte)(((g)this).i - 1);
            }
        }
        this.var_int_a = this.h / 6 * 6;
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, false, false);
        graphics.setColor(0);
        graphics.drawLine(n2, n3 + 11, n2 + 120, n3 + 11);
        int n4 = n2 + -25;
        int n5 = n3 + 19;
        for (int i2 = 0; i2 < 6; ++i2) {
            graphics.fillRect(n4, n5 + 15 * i2, 14, 14);
        }
        graphics.fillRect(n4 + 14 + 1, n5, 156, 89);
        graphics.setColor(0x7F7F7F);
        bk.a(graphics, bw.i, n3 + 1, this.j, 0, 1);
        int n6 = n4 + 1;
        int n7 = 0;
        int n8 = 0;
        for (int i3 = 0; i3 < 6; ++i3) {
            n7 = n5 + 1 + i3 * 15;
            n8 = this.var_int_a + i3;
            cp cp2 = this.a(n8);
            if (cp2 == null) continue;
            bd.a(n6, n7, cp2.g);
            if (cp2.c <= 1) continue;
            f.a(graphics, cp2.c, n6 + 14 - 1, n7 + 14 - 7, 8, 0);
        }
        this.a(graphics, n4 + 14 + 1 + 3, n5 + 3, this.a(this.h), true, false, false);
        this.c(graphics, n2 + 112, n3 + 109, u.var_int_f);
        graphics.setClip(n2, n3, 120, 117);
        this.b(graphics, n2 + 112, n3 + 12, this.h + 1, this.i.length);
    }

    public cp a(int n2) {
        cp cp2 = this.i != null && n2 < this.i.length ? u.var_ci_a.cp_a((int)this.i[n2]) : null;
        return cp2;
    }

    public void void_b(int n2, int n3) {
        int n4 = (this.h - this.var_int_a) / 1;
        int n5 = n2 + -25;
        int n6 = n3 + 19 + n4 * 15;
        this.a(n5, n6, 13, 13);
    }
}

