/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public class ba
extends g {
    private byte var_byte_a;
    private byte[][] b;
    private int var_int_a;

    public ba(g g2, byte by2, byte by3, byte[][] byArray) {
        super(g2, by3, (byte)1, (byte)1);
        this.var_byte_a = by2;
        this.b = byArray;
        switch (by2) {
            case 2: 
            case 10: 
            case 11: {
                this.var_int_a = 16 * (2 + this.b.length);
                break;
            }
            case 4: 
            case 5: {
                this.f = true;
            }
            default: {
                this.var_int_a = 6 + 16 * byArray.length;
            }
        }
        if (by2 == 10) {
            this.h = 1;
        }
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        switch (this.var_byte_a) {
            case 2: 
            case 10: 
            case 11: {
                if (!this.boolean_d(n2, n3)) break;
                return true;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                if (!this.boolean_c(n2, n3)) break;
                return true;
            }
            default: {
                return true;
            }
        }
        if (n3 == 53 || n2 == 8) {
            this.var_g_a.a(this.var_byte_a, this.h);
            return true;
        }
        if (n3 == 8) {
            switch (this.var_byte_a) {
                case 2: {
                    break;
                }
                default: {
                    this.var_g_a.a(this.var_byte_a, (byte)-1);
                }
            }
            return true;
        }
        return true;
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        graphics.setClip(0, 0, bw.g, bw.h);
        int n4 = 0;
        switch (this.var_byte_a) {
            case 2: 
            case 10: 
            case 11: {
                ba.a(graphics, this.b, this.var_int_a, this.h == 0);
                break;
            }
            case 4: 
            case 5: {
                ba.a(graphics, this.b, this.var_int_a);
                break;
            }
            case 3: 
            case 6: 
            case 7: 
            case 8: {
                n4 = ba.int_b(graphics, 140, this.var_int_a) + 6;
                graphics.setColor(0x7F7F7F);
                for (int i2 = 0; i2 < this.b.length; ++i2) {
                    if (this.h == i2) continue;
                    bk.a(graphics, bw.i, n4 + 16 * i2, this.b[i2], 1, 1);
                }
                graphics.setColor(0xFFFFFF);
                bk.a(graphics, bw.i, n4 + 16 * this.h, this.b[this.h], 1, 1);
            }
        }
    }

    public static int int_b(Graphics graphics, int n2, int n3) {
        int n4 = bw.g - n2 >> 1;
        int n5 = bw.h - n3 >> 1;
        graphics.setColor(0);
        graphics.fillRect(n4, n5, n2, n3);
        graphics.setColor(g.var_int_arr_a[0]);
        graphics.drawRect(n4, n5, n2, n3);
        return n5;
    }

    public static final void a(Graphics graphics, int n2, boolean bl2) {
        int n3 = bw.i;
        int n4 = n3 - 42 - 2;
        graphics.setColor(0);
        graphics.fillRect(n4, n2, 42, 15);
        graphics.fillRect(n3 + 2, n2, 42, 15);
        graphics.setColor(g.var_int_arr_a[0]);
        graphics.drawRect(n4 + (bl2 ? 0 : 45), n2, 42, 15);
        byte[] byArray = as.var_e_a.a(14);
        int n5 = bd.hlzTextWidth(byArray);
        int n6 = bw.i - 23 - n5 / 2;
        byte[] byArray2 = as.var_e_a.a(15);
        int n7 = bd.hlzTextWidth(byArray2);
        int n8 = bw.i + 23 - n7 / 2;
        graphics.setColor(!bl2 ? 0x7F7F7F : 0xFFFFFF);
        bk.a(graphics, n6, n2 + 3, byArray, 1);
        graphics.setColor(bl2 ? 0x7F7F7F : 0xFFFFFF);
        bk.a(graphics, n8, n2 + 3, byArray2, 1);
    }

    public static final void a(Graphics graphics, byte[][] byArray, int n2, boolean bl2) {
        int n3;
        int n4 = byArray.length;
        int n5 = bk.a(byArray[0]);
        int n6 = 0;
        for (n3 = 1; n3 < n4 - 0; ++n3) {
            n6 = bk.a(byArray[n3]);
            if (n6 <= n5) continue;
            n5 = n6;
        }
        n3 = bw.g - n5 >> 1;
        n3 += 0;
        int n7 = g.int_a(graphics, n2, 0) + 12;
        graphics.setColor(0xFFFFFF);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            bk.a(graphics, n3, n7, byArray[i2], 1);
            n7 += 16;
        }
        ba.a(graphics, ++n7, bl2);
    }

    public static final void a(Graphics graphics, byte[][] byArray, int n2) {
        int n3;
        int n4 = g.int_a(graphics, n2, 6970180);
        graphics.setColor(15128512);
        bk.a(graphics, bw.i, n4 + 7, byArray[0], 1, 1);
        int n5 = bw.i - 85;
        int n6 = n4 + 12 + 10;
        graphics.setColor(0);
        for (n3 = 0; n3 < byArray.length - 1; ++n3) {
            graphics.fillRect(n5, n6 + 15 * n3, 170, 14);
        }
        graphics.setColor(0xFFFFFF);
        for (n3 = 0; n3 < byArray.length - 1; ++n3) {
            bk.a(graphics, bw.i, n6 + 2 + 15 * n3, byArray[n3 + 1], 1, 1);
            n4 += 15;
        }
    }

    public void void_b(int n2, int n3) {
        int n4 = 0;
        int n5 = 0;
        if (this.var_byte_a == 4 || this.var_byte_a == 5) {
            n4 = bw.i - 85;
            n5 = (bw.h - this.var_int_a >> 1) + 12 + 10;
            this.a(n4, n5 + 15 * this.h, 169, 13);
        }
    }
}

