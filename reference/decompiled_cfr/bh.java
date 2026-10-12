/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public class bh
extends bt {
    private int b;

    public bh(byte by2, byte by3) {
        super(by2, by3);
        if (this.c == -6) {
            this.var_short_a = (short)2;
            this.var_int_a = -1;
            this.b = by3;
        } else {
            this.var_short_a = (short)4;
            this.b = 0;
        }
    }

    public bh(byte by2) {
        this(by2, -1);
    }

    public bh(byte by2, byte by3, int n2) {
        this(by2, by3);
        if (this.c == -6) {
            this.var_int_a = n2;
        } else {
            this.b = n2;
        }
    }

    public void a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        switch (this.c) {
            case -1: {
                graphics.drawImage(as.var_as_a.var_javax_microedition_lcdui_Image_arr_j[((bt)this).b < 2 ? 1 : 0], n2, n3 - 35 - ((bt)this).b * 3, 17);
                break;
            }
            case -2: {
                graphics.drawImage(as.var_as_a.var_javax_microedition_lcdui_Image_arr_k[((bt)this).b < 2 ? 1 : 0], n2, n3 - 35 - this.d - ((bt)this).b * 3, 17);
                break;
            }
            case -4: {
                f.a(graphics, this.b, n2, n3 - 35 - ((bt)this).b * 4, 1, ((bt)this).b < 2 ? 4 : 2);
                break;
            }
            case -5: {
                f.a(graphics, this.b, n2, n3 - 35 - this.d - ((bt)this).b * 4, 1, ((bt)this).b < 2 ? 3 : 1);
                break;
            }
            case -3: {
                graphics.drawImage(as.var_as_a.var_javax_microedition_lcdui_Image_arr_l[((bt)this).b < 2 ? 0 : 1], n2, n3 - 35 - ((bt)this).b * 3, 17);
                break;
            }
            case -6: {
                if (this.b < 8 || this.b == 10) {
                    graphics.drawImage(as.var_as_a.var_javax_microedition_lcdui_Image_arr_d[0], n2, n3 - 36, 3);
                }
                graphics.drawImage(as.var_as_a.var_javax_microedition_lcdui_Image_arr_d[this.b], n2, n3 - 37 + ((bt)this).b % 2, 3);
            }
        }
    }
}

