/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class bp
extends g {
    private byte[] i;
    private byte[] j;
    private byte[] k;
    public boolean var_boolean_a;
    public b var_b_a = u.var_b_a;

    public bp(g g2) {
        super(g2, (byte)5, (byte)2, (byte)3);
        this.var_b_a.n();
        this.i = as.var_e_f.a(0);
        byte by2 = u.var_b_a.var_byte_b;
        this.k = as.var_e_f.a(by2 >= 14 ? 28 : 4 + by2);
        int n2 = 1 + u.var_byte_a;
        this.j = as.var_e_f.a(n2);
        if (this.var_b_a.var_short_a > 0) {
            this.var_boolean_a = true;
        }
        this.f = true;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.h = 0;
            this.var_g_a.b(0);
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            if (this.var_boolean_a) {
                return this.a();
            }
            this.var_g_a.h = 0;
            this.var_g_a.b(0);
            return true;
        }
        if (!this.var_boolean_a) {
            return false;
        }
        if (this.boolean_d(n2, n3)) {
            return true;
        }
        return this.e(n2, n3);
    }

    private boolean a() {
        if (!this.var_boolean_a) {
            return false;
        }
        this.var_b_a.var_short_a = (short)(this.var_b_a.var_short_a - 1);
        if (this.var_b_a.var_short_a < 1) {
            this.var_boolean_a = false;
        }
        switch (this.h) {
            case 0: {
                this.var_b_a.var_short_e = (short)(this.var_b_a.var_short_e + 1);
                break;
            }
            case 1: {
                this.var_b_a.var_short_g = (short)(this.var_b_a.var_short_g + 1);
                break;
            }
            case 2: {
                this.var_b_a.var_short_f = (short)(this.var_b_a.var_short_f + 1);
                break;
            }
            case 3: {
                this.var_b_a.var_short_h = (short)(this.var_b_a.var_short_h + 1);
                break;
            }
            case 4: {
                this.var_b_a.var_short_i = (short)(this.var_b_a.var_short_i + 1);
                break;
            }
            default: {
                this.var_b_a.var_short_a = (short)(this.var_b_a.var_short_a + 1);
                return false;
            }
        }
        this.var_b_a.n();
        return true;
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, false, true);
        graphics.setColor(0);
        int n4 = n3 + 14;
        graphics.fillRect(n2 - 35 + 4, n4, 182, 16);
        graphics.fillRect(n2 - 35 + 4, n3 + 43, 182, 48);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n2 - 35 + 95 - (bk.a(this.i) + bk.a(this.k) + bk.a(this.j) + 12) / 2, n4 + 3, this.i, 1);
        bk.a(graphics, n2 - 35 + 95 - (bk.a(this.i) + bk.a(this.k) + bk.a(this.j) + 12) / 2 + bk.a(this.i) + 6, n4 + 3, this.k, 1, 4);
        graphics.setColor(14467940);
        bk.a(graphics, n2 - 35 + 95 - (bk.a(this.i) + bk.a(this.k) + bk.a(this.j) + 12) / 2 + bk.a(this.i) + 6 + bk.a(this.k) + 6, n4 + 3, this.j, 1, 4);
        int n5 = n2 + 10;
        n4 = n3 + 33;
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_d, n5, n4, 20);
        f.a(graphics, this.var_b_a.var_byte_a, n5 + 28, n4, 8, 0);
        n5 = n2 + 44;
        n4 = n3 + 31;
        graphics.setColor(3742777);
        graphics.fillRect(n5, n4, 66, 3);
        graphics.setColor(0xFFFFFF);
        int n6 = 64 * this.var_b_a.var_int_c / this.var_b_a.var_int_f;
        if (n6 < 0) {
            n6 = 1;
        } else if (n6 > 64) {
            n6 = 64;
        }
        graphics.drawLine(n5 + 1, n4 + 1, n5 + 1 + n6, n4 + 1);
        this.b(graphics, n2 + 110, n4 += 4, this.var_b_a.var_int_c, this.var_b_a.var_int_f);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_f, n5, n4 += 11, 20);
        this.b(graphics, n2 + 110, n4, this.var_b_a.var_int_a, this.var_b_a.var_int_d);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_g, n5, n4 += 8, 20);
        this.b(graphics, n2 + 110, n4, this.var_b_a.var_int_b, this.var_b_a.var_int_e);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_h, n5, n4 += 11, 20);
        f.a(graphics, this.var_b_a.var_int_g, n2 + 76, n4, 8, 0);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_i, n2 + 81, n4, 20);
        f.a(graphics, this.var_b_a.var_int_i, n2 + 113, n4, 8, 0);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_e, n5, n4 += 8, 20);
        this.b(graphics, this.var_b_a.var_int_l, n2 + 94, n4);
        n4 += 8;
        int n7 = this.var_b_a.var_int_m - this.var_b_a.var_byte_a - this.var_b_a.var_byte_a / 10;
        if (n7 > 90) {
            n7 = 90;
        } else if (n7 < 8) {
            n7 = 8;
        }
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_c, n5, n4, 20);
        this.b(graphics, n7, n2 + 94, n4);
        n5 = n2 + 6;
        this.c(graphics, n5, n4 += 11, 4, this.var_b_a.var_short_e + this.var_b_a.var_short_arr_b[0]);
        this.c(graphics, n5, n4 + 12, 2, this.var_b_a.var_short_h + this.var_b_a.var_short_arr_b[3]);
        this.c(graphics, n5 += 37, n4, 0, this.var_b_a.var_short_g + this.var_b_a.var_short_arr_b[2]);
        this.c(graphics, n5, n4 + 12, 3, this.var_b_a.var_short_i + this.var_b_a.var_short_arr_b[4]);
        this.c(graphics, n5 += 37, n4, 1, this.var_b_a.var_short_f + this.var_b_a.var_short_arr_b[1]);
        if (this.var_boolean_a) {
            this.d(graphics, n5, n4 + 13, this.var_b_a.var_short_a, false);
        }
    }

    private void c(Graphics graphics, int n2, int n3, int n4, int n5) {
        graphics.setClip(n2, n3, 18, 12);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_j, n2 - n4 * 18, n3, 20);
        f.a(graphics, n5, n2 + 32, n3 + 3, 8, 0);
    }

    public void void_b(int n2, int n3) {
        int n4;
        if (this.var_boolean_a) {
            int n5 = this.h / 3;
            n4 = this.h % 3;
            int n6 = n2 + 5 + n4 * 37;
            int n7 = n3 + 91 + n5 * 12;
            this.a(n6, n7, 34, 13);
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        graphics.setColor(0);
        graphics.fillRect(n2 + 4, n3 + 50, 40, 30);
        n4 = 23;
        if (ah.var_boolean_a) {
            n4 = u.var_byte_a == 0 ? (n4 += 10) : (n4 += 3);
        }
        u.var_b_a.a(n2 + n4, n3 + 78, (int)this.l);
    }
}

