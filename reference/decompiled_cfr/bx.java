/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class bx
extends g {
    public byte[] i = null;
    public int var_int_a;
    public int b;
    public int c;
    public boolean var_boolean_a;

    public bx(g g2, byte[] byArray) {
        super(g2, (byte)0);
        this.b = bk.a(byArray, 184);
        this.i = byArray;
        this.var_int_a = 12 + this.b * 10 + (this.b - 1) * 4;
        this.var_boolean_a = false;
    }

    public bx(g g2, byte[] byArray, boolean bl2) {
        super(g2, (byte)0);
        this.b = bk.a(byArray, 184);
        this.i = byArray;
        this.var_int_a = 12 + this.b * 10 + (this.b - 1) * 4;
        this.var_boolean_a = bl2;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (this.var_boolean_a) {
            return true;
        }
        if (n3 == 53 || n2 == 8 || n3 == 8) {
            this.var_g_a.b(0);
        }
        return true;
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        graphics.setClip(0, 0, bw.g, bw.h);
        int n4 = bw.g - 200 >> 1;
        int n5 = g.int_a(graphics, this.var_int_a, 0) + 6;
        graphics.setColor(0xFFFFFF);
        if (this.b == 1) {
            if (this.var_boolean_a) {
                ++this.c;
                if (this.c > 100) {
                    this.c = 0;
                }
                this.e = true;
                int n6 = this.i.length - this.c % 4;
                byte[] byArray = new byte[n6];
                int n7 = (this.i.length << 1) + (this.i.length >> 1);
                System.arraycopy(this.i, 0, byArray, 0, n6);
                bk.a(graphics, bw.i - n7 + 2, n5, byArray, 0);
            } else {
                bk.a(graphics, bw.i, n5, this.i, 0, 1);
            }
        } else {
            bk.a(graphics, n4 + 8, n5, 184, 1, this.i);
        }
    }
}

