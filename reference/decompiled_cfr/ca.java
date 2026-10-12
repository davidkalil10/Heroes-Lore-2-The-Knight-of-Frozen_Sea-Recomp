/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class ca
extends g {
    public byte a = 0;

    public ca(g g2, byte by2) {
        super(g2, (byte)3);
        this.a = by2;
        this.f = true;
        if (by2 != 10) {
            this.a();
        }
    }

    public void a() {
        for (int i2 = 0; i2 < 3 && !u.boolean_a(this.h); ++i2) {
            this.h = (byte)(this.h + 1);
        }
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.h = this.a == 1 || this.a == 4 ? this.a : (byte)0;
            this.var_g_a.b(this.var_g_a.h);
        } else if (n2 == 8 || n3 == 53) {
            if (this.a == 10) {
                if (u.var_java_lang_Object_arr_a[this.h] != null) {
                    this.a((byte)2, 2, as.var_e_a.a(43, 44, 45, 46));
                    this.b.h = 1;
                } else {
                    this.b();
                }
            } else {
                switch (this.a) {
                    case 4: {
                        u.var_byte_c = this.h;
                        this.a((byte)2, 2, as.var_e_a.a(47, 48, 49));
                        break;
                    }
                    default: {
                        if (this.a == 1) {
                            u.var_byte_c = this.h;
                        } else {
                            u.var_byte_a = this.h;
                        }
                        u.var_u_a.void_a(this.a == 1 ? 1 : 0);
                    }
                }
            }
            return true;
        }
        this.boolean_d(n2, n3);
        if (!(this.a != 1 && this.a != 4 || u.boolean_a(this.h))) {
            if (n2 == 5 || n3 == 54) {
                this.h = (byte)((this.h + 1) % 3);
                if (!u.boolean_a(this.h)) {
                    this.h = (byte)((this.h + 1) % 3);
                }
            } else if (n2 == 2 || n3 == 52) {
                this.h = (byte)((this.h + 2) % 3);
                if (!u.boolean_a(this.h)) {
                    this.h = (byte)((this.h + 2) % 3);
                }
            }
        }
        return true;
    }

    public void a(byte by2, byte by3) {
        this.b(by3);
        if (by2 == 2 && by3 == 0) {
            if (this.a == 4) {
                this.b = new cl(this);
            } else {
                this.b();
            }
        }
    }

    public void b() {
        u.var_byte_c = this.h;
        this.a = (byte)11;
        this.h = 0;
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        this.a(graphics);
        if (this.a == 11) {
            this.c(graphics);
        } else {
            this.b(graphics);
        }
    }

    public void b(Graphics graphics) {
        int n2 = bw.i;
        int n3 = bw.j - 45;
        graphics.setColor(14134162);
        if (this.a == 10) {
            bk.a(graphics, n2 - 49, n3, as.var_e_a.a(17), 0);
        } else {
            bk.a(graphics, n2, n3 + 5, as.var_e_a.a(this.a), 0, 1);
        }
        int n4 = n3 + 35;
        this.a(graphics, n2, n4, this.a == 10 || u.var_byte_b >= 2);
        int n5 = n2 - 16;
        graphics.setColor(14134162);
        bk.a(graphics, n5, n4 + 3, as.var_e_a.a(18), 0, 4);
        f.a(graphics, this.h + 1, n5 + 32, n4 + 6, 4, 0);
        int n6 = n3 + 40 + 28;
        this.a(graphics, n2, n6, this.h);
    }

    public void c(Graphics graphics) {
        int n2 = bw.i;
        int n3 = bw.j - 51;
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n2, n3, as.var_e_a.a(16), 0, 1);
        int n4 = n3 + 26;
        this.a(graphics, n2, n4, true);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n2, n4 + 2, as.var_e_f.a(1 + this.h), 0, 1);
        graphics.setColor(14134162);
        bk.a(graphics, n2, n3 + 89, as.var_e_f.a(0), 0, 1);
        this.e(graphics, 1, n2, n3 + 104);
    }

    public void e(Graphics graphics, int n2, int n3, int n4) {
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_d, n3, n4, 24);
        f.a(graphics, n2, n3 + 6, n4, 4, 0);
    }

    public void a(Graphics graphics, int n2, int n3, byte by2) {
        int n4;
        byte[] byArray = (byte[])u.var_java_lang_Object_arr_a[by2];
        int n5 = n4 = byArray != null ? byArray[1] : -1;
        if (n4 < 0) {
            byte[] byArray2 = as.var_e_a.a(19);
            this.a(graphics, n2 - bd.hlzTextWidth(byArray2) / 2, n3, 0xFFFFFF);
        } else {
            int n6 = byArray[4];
            if (n6 > 1) {
                n6 = 2;
            }
            graphics.setColor(ax.var_int_arr_b[n6]);
            bk.a(graphics, n2, n3 - 14, as.var_e_a.a(10 + n6), 0, 1);
            graphics.setColor(0xFFFFFF);
            byte[] byArray3 = as.var_e_f.a(n4 + 1);
            int n7 = bd.hlzTextWidth(byArray3);
            n4 = n2 - n7 / 2;
            bk.a(graphics, n4, n3, byArray3, 0);
            n7 = as.var_javax_microedition_lcdui_Image_d.getWidth() + n7;
            this.e(graphics, byArray[2], n4 + n7 + 3, n3 + 2);
            graphics.setColor(14467940);
            byte[] byArray4 = as.var_e_a.a(31);
            int n8 = bd.hlzTextWidth(byArray4);
            n6 = n2 - n8 / 2;
            bk.a(graphics, n6, n3 + 14, byArray4, 0);
            this.b(graphics, byArray[3], n6 + n8 + 3, n3 + 16);
        }
    }

    public void void_b(int n2, int n3) {
        if (this.a != 11) {
            return;
        }
        int n4 = bw.i;
        int n5 = bw.j;
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        graphics.setColor(0);
        graphics.fillRect(n4 - 30, n5, 45, 30);
        as.var_as_a.var_by_b.a(graphics, (byte)0, (byte)(this.h + 1), n4, n5 + 25);
    }
}

