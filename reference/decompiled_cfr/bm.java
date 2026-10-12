/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class bm
extends g {
    private cg var_cg_a;
    public byte var_byte_a;
    public byte[] i;
    public int scroll;

    public bm(g g2, cg cg2, boolean bl2) {
        super(g2, (byte)4, (byte)2, (byte)2);
        this.var_cg_a = cg2;
        this.f = bl2;
        this.var_byte_a = 0;
        this.i = this.var_cg_a.var_short_a == 0 ? null : ck.var_e_a.a(50 + this.var_cg_a.int_a());
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
            if (this.var_cg_a.var_short_a == 0) {
                this.var_g_a.b(0);
                return true;
            }
            if (this.f) {
                byte by2 = this.var_cg_a.j[this.h];
                return this.a(by2, this.var_cg_a.var_byte_arr_k[this.h], this.var_cg_a.byte_a(by2));
            }
            this.var_g_a.b(0);
            return true;
        }
        if (this.boolean_d(n2, n3)) {
            return true;
        }
        return this.e(n2, n3);
    }

    public boolean a(byte by2, byte by3, byte by4) {
        if (by2 < 0 || by3 < 0) {
            return true;
        }
        if (ck.var_boolean_a && by3 < by4) {
            if (by3 < 1) {
                this.a((byte)3, ck.var_e_a.a(32, 33));
            } else {
                this.a((byte)3, ck.var_e_a.a(32, 33, 34, 35, 36, 37));
            }
        } else if (by3 < 1) {
            this.b = new av(this, this.h, true);
        } else {
            this.a((byte)3, ck.var_e_a.a(33, 34, 35, 36, 37));
        }
        return true;
    }

    public void a(byte by2, byte by3) {
        this.b(by3);
        b b2 = u.var_b_a;
        if (ck.var_boolean_a && this.var_cg_a.var_byte_arr_k[this.h] < this.var_cg_a.byte_a(this.var_cg_a.j[this.h])) {
            if (by3 == 0) {
                b2.var_short_b = (short)(b2.var_short_b - 1);
                ck.var_ck_a.void_b();
                byte by4 = this.h;
                this.var_cg_a.var_byte_arr_k[by4] = (byte)(this.var_cg_a.var_byte_arr_k[by4] + 1);
                this.var_cg_a.void_b(this.h);
                this.var_cg_a.void_a(this.h);
            } else if (by3 == 1) {
                this.b = new av(this, this.h, true);
            } else if (by3 > 1) {
                u.var_u_a.a(by3 - 2, (int)this.h, true);
            }
        } else if (this.var_cg_a.var_byte_arr_k[this.h] > 0) {
            if (by3 == 0) {
                this.b = new av(this, this.h, true);
            } else if (by3 > 0) {
                u.var_u_a.a(by3 - 1, (int)this.h, true);
            }
        }
    }

    public void void_a(int n2, int n3) {
        int n4;
        int n5;
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, false, true);
        graphics.setColor(0);
        int n6 = n3 + 12;
        graphics.fillRect(n2 + 4, n6, 112, 16);
        graphics.fillRect(n2 + 4, n6 += 25, 112, 31);
        n6 += 32;
        for (n5 = 0; n5 < 2; ++n5) {
            for (n4 = 0; n4 < 2; ++n4) {
                graphics.fillRect(n2 + -7 + 68 * n4, n6 + n5 * 19, 14, 14);
                graphics.fillRect(n2 + 8 + 68 * n4, n6 + n5 * 19, 50, 14);
            }
        }
        n5 = this.f ? 0 : -18;
        graphics.fillRect(n2 - 35, n3 + 106, 190, 11);
        n4 = n2 + 46;
        n6 = n3 + 15;
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n2 + 10, n6, this.var_cg_a.i, 1);
        if (this.i != null) {
            graphics.setColor(14467940);
            bk.a(graphics, n2 + 88, n6, this.i, 1);
        }
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_o, n2 + 8, n6 += 14, 20);
        this.a(graphics, n2 + 66, n6, this.var_cg_a);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_d, n4 + n5, n6 += 9, 20);
        f.a(graphics, this.var_cg_a.var_short_b, n4 + 30 + n5, n6, 8, 0);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_n, n4 + n5, n6 += 10, 20);
        graphics.setColor(3742777);
        graphics.fillRect(n4 + n5, n6 += 8, 66, 3);
        graphics.setColor(0xFFFFFF);
        int n7 = 63 * this.var_cg_a.var_int_a / this.var_cg_a.var_int_b;
        if (n7 < 0) {
            n7 = 1;
        } else if (n7 > 63) {
            n7 = 63;
        }
        graphics.drawLine(n4 + 1 + n5, n6 + 1, n4 + 1 + n5 + n7, n6 + 1);
        this.b(graphics, n2 + 110 + n5, n6 += 4, this.var_cg_a.var_int_a, this.var_cg_a.var_int_b);
        n4 = n2 + -6;
        n6 = n3 + 69;
        graphics.setClip(0, 0, bw.g, bw.h);
        for (int n8 = 0; n8 < 2; n8 = (int)((byte)(n8 + 1))) {
            for (int n9 = 0; n9 < 2; n9 = (int)((byte)(n9 + 1))) {
                this.e(graphics, n4 + 68 * n9, n6 + n8 * 19, n8 * 2 + n9);
            }
        }
        if (this.f && ck.var_ck_a.boolean_a()) {
            this.d(graphics, n2 + 82, n3 + 107, u.var_b_a.var_short_b, true);
        }
    }

    public void void_b(int n2, int n3) {
        this.void_d(n2, n3);
        if (this.var_cg_a.var_short_a == 0) {
            return;
        }
        int n4 = this.h / 2;
        int n5 = this.h % 2;
        int n6 = n2 + 7 + n5 * 68;
        int n7 = n3 + 69 + n4 * 19;
        this.a(n6, n7, 50, 13);
    }

    public void void_d(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        graphics.setClip(n2 + 4, n3 + 37, 42, 30);
        graphics.setColor(0);
        graphics.fillRect(n2 + 4, n3 + 37, 42, 30);
        bd.a(this.var_byte_a, n2 + 25, n3 + 87);
        this.var_byte_a = (byte)(this.var_byte_a + 1);
        if (this.var_byte_a >= as.var_byte_arr_k[0]) {
            this.var_byte_a = 0;
        }
        graphics.setClip(0, 0, bw.g, bw.h);
    }

    private void e(Graphics graphics, int n2, int n3, int n4) {
        int n5;
        byte by2 = this.var_cg_a.j[n4];
        if (by2 < 0) {
            graphics.setColor(0x7F7F7F);
            bk.a(graphics, n2 + 39, n3 + 1, as.var_e_a.a(23), 0, 1);
            return;
        }
        int n6 = this.var_cg_a.var_byte_arr_k[n4];
        byte by3 = this.var_cg_a.byte_a(by2);
        graphics.setColor(n6 > 0 ? 0xFFFFFF : 0x7F7F7F);
        byte[] byArray = ck.var_e_b.a(by2 * 2);
        int n7 = bk.a(byArray);
        if (n7 <= 50) {
            bk.a(graphics, n2 + 39, n3 + 2, byArray, 0, 1);
        } else {
            int n8 = n7 - 44;
            int n9 = n8 * 2 + 80;
            int n10 = this.scroll % n9;
            n10 = n10 < 40 ? 0 : (n10 < n8 + 40 ? n10 - 40 : (n10 < n8 + 80 ? n8 : n8 - (n10 - (n8 + 80))));
            graphics.setClip(n2 + 14, n3 + 1, 50, 13);
            bk.a(graphics, n2 + 17 - n10, n3 + 2, byArray, 0, 4);
            graphics.setClip(0, 0, bw.g, bw.h);
        }
        for (n5 = 0; n5 < n6; ++n5) {
            graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_h[1], n2 + 55 - 6 * n5, n3 + 14, 20);
        }
        for (n5 = n6; n5 < by3; ++n5) {
            graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_h[0], n2 + 55 - 6 * n5, n3 + 14, 20);
        }
        bd.var_bd_a.c(by2, n2, n3 + 1);
        this.c(graphics, n2 + 4, n3 + 9, n4, true);
    }

    public void void_c(int n2, int n3) {
        if (this.b == null) {
            ++this.scroll;
            this.e = true;
        }
        super.void_c(n2, n3);
    }
}

