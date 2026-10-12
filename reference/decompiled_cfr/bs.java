/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class bs
extends g {
    public int var_int_a;
    public byte var_byte_a;

    public bs(g g2, int n2, int n3) {
        super(g2, (byte)1);
        this.h = 1;
        this.var_int_a = n2;
        this.var_byte_a = (byte)n3;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.b(0);
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            this.var_g_a.a((byte)50, this.h);
        } else if (n2 == 1 || n3 == 50) {
            if (this.h < this.var_byte_a) {
                this.h = (byte)(this.h + 10);
            }
            if (this.h > this.var_byte_a) {
                this.h = this.var_byte_a;
            }
        } else if (n2 == 6 || n3 == 56) {
            if (this.h > 10) {
                this.h = (byte)(this.h - 10);
            }
        } else if (n2 == 2 || n3 == 52) {
            if (this.h > 1) {
                this.h = (byte)(this.h - 1);
            }
        } else if ((n2 == 5 || n3 == 54) && this.h < this.var_byte_a) {
            this.h = (byte)(this.h + 1);
        }
        return true;
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        int n4 = g.int_a(graphics, 56, 6970180);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, bw.i, n4 + 11, as.var_e_a.a(51), 1, 1);
        int n5 = bw.i - 21;
        int n6 = n4 + 31;
        graphics.setColor(0);
        graphics.fillRect(n5, n6, 42, 15);
        this.b(graphics, n5 - 5, n6 + 7, 51, 15128512, false);
        this.d(graphics, bw.i, n6 - 5, 21);
        graphics.drawRect(n5, n6, 41, 14);
        bk.a(graphics, bw.i + 1, n6 + 1, ("" + this.h).getBytes(), 0, 1);
        if (this.var_int_a > 0) {
            this.c(graphics, bw.i + 55, n6 + 16, this.var_int_a * this.h);
        }
    }
}

