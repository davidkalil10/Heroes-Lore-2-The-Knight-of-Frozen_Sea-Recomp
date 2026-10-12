/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class m
extends g {
    public static byte var_byte_a;
    public static byte var_byte_b;
    public static byte c;
    public boolean var_boolean_a = true;
    public boolean var_boolean_b = true;
    public byte d = 0;
    public b var_b_a = u.var_b_a;
    public int scroll;

    public m(g g2) {
        super(g2, var_byte_a, var_byte_b, c);
        this.var_b_a.q();
        this.void_a();
        this.f = true;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.b(1);
            return true;
        }
        if (this.var_boolean_a) {
            if (n2 == 2 || n2 == 5 || n3 == 52 || n3 == 54) {
                this.var_boolean_b = !this.var_boolean_b;
                this.void_a();
            } else if (n2 == 1 || n2 == 8 || n3 == 53) {
                this.h = 0;
                this.var_boolean_a = false;
            }
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            byte by2 = this.byte_a();
            return this.a(by2, this.var_b_a.byte_b(by2), this.var_b_a.byte_a((int)by2));
        }
        if (this.f(n2, n3)) {
            return true;
        }
        return this.g(n2, n3);
    }

    public boolean a(byte by2, byte by3, byte by4) {
        if (by2 < 0 || by3 < 0) {
            return true;
        }
        if (this.var_boolean_b) {
            if (by2 < this.d) {
                if (ck.var_boolean_a && by3 < by4 && by2 <= this.var_b_a.var_byte_c) {
                    this.a((byte)3, new byte[][]{ck.var_e_a.a(32)});
                }
            } else if (ck.var_boolean_a && by3 < by4) {
                this.a((byte)3, ck.var_e_a.a(32, 33));
            } else {
                ((g)this).b = new av(this, by2, false);
            }
        } else if (by3 < 1) {
            if (ck.var_boolean_a) {
                this.a((byte)3, ck.var_e_a.a(32, 33));
            } else {
                ((g)this).b = new av(this, by2, false);
            }
        } else if (ck.var_boolean_a && by3 < by4) {
            this.a((byte)3, ck.var_e_a.a(32, 33, 34, 35, 36, 37));
        } else {
            this.a((byte)3, ck.var_e_a.a(33, 34, 35, 36, 37));
        }
        return true;
    }

    public void a(byte by2) {
        this.var_b_a.var_short_b = (short)(this.var_b_a.var_short_b - 1);
        ck.var_ck_a.void_b();
        this.var_b_a.boolean_f(by2);
    }

    public void a(byte by2, byte by3) {
        boolean bl2;
        this.b((int)by3);
        byte by4 = this.byte_a();
        boolean bl3 = bl2 = this.var_b_a.byte_b(by4) < this.var_b_a.byte_a((int)by4);
        if (this.var_boolean_b && by2 == 3) {
            if (by3 == 0) {
                this.a(by4);
            } else {
                ((g)this).b = new av(this, by4, false);
            }
        } else if (by2 == 3 && by3 == 0) {
            if (ck.var_boolean_a && bl2) {
                this.a(by4);
            } else {
                ((g)this).b = new av(this, by4, false);
            }
        } else if (by2 == 3 && by3 == 1 && ck.var_boolean_a && bl2) {
            ((g)this).b = new av(this, by4, false);
        } else if (by3 > 0) {
            u.var_u_a.a(by3 - (ck.var_boolean_a && bl2 ? 2 : 1), this.h + 1, false);
        }
    }

    public boolean f(int n2, int n3) {
        if (n3 == 52 || n2 == 2 || n3 == 54 || n2 == 5) {
            if (this.h >= this.d) {
                this.h = (byte)(this.h - this.d);
                if (this.h >= this.d) {
                    this.h = (byte)(this.h + this.d);
                }
            } else {
                this.h = (byte)(this.h + this.d);
                if (this.h >= this.i) {
                    this.h = (byte)(this.h - this.d);
                }
            }
        }
        return false;
    }

    public boolean g(int n2, int n3) {
        if (n3 == 50 || n2 == 1) {
            this.b((byte)1);
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.b((byte)2);
            return true;
        }
        return false;
    }

    public void b(byte by2) {
        byte by3 = this.d;
        if (!this.var_boolean_b) {
            by3 = 4;
        }
        if (by2 == 2) {
            this.h = (byte)(this.h + 1);
            if (this.h >= this.i || this.h == by3) {
                this.var_boolean_a = true;
            }
        } else {
            this.h = (byte)(this.h - 1);
            if (this.h < 0) {
                this.h = (byte)(by3 - 1);
            } else if (this.h == by3 - 1) {
                this.h = (byte)(this.i - 1);
            }
        }
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, true, true);
        int n4 = n2 + -15;
        int n5 = n3 + 12;
        if (var_byte_b == 4) {
            n5 += 10;
        }
        int n6 = 0;
        if (this.var_boolean_b) {
            int n7;
            this.a(graphics, n4, n5, (int)this.d, 73);
            this.a(graphics, n4 + 73 + 4, n5, var_byte_a - this.d, 73);
            graphics.setColor(0xFFFFFF);
            bk.a(graphics, n4 + 3, n5 + 2, ck.var_e_a.a(25), 0);
            graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_h[1], n4 + 67, n5 + 14, 20);
            for (n7 = 1; n7 < this.d; n7 = (byte)(n7 + 1)) {
                this.a(graphics, n4, n5 + n7 * 19, n7 + 1, u.var_b_a.byte_b((byte)n7), (byte)(n7 + 1), true);
            }
            n7 = var_byte_a - this.d;
            n6 = u.var_byte_a == 1 ? 10 : 11;
            for (int i2 = 0; i2 < n7; ++i2) {
                this.a(graphics, n4 + 77, n5 + i2 * 19, i2 + (u.var_byte_a == 2 ? 6 : 7), u.var_b_a.byte_b((byte)(n6 + i2)), u.var_b_a.byte_a(n6 + i2), false);
            }
        } else {
            int n8;
            int n9 = u.var_byte_a == 0 ? 3 : 2;
            this.a(graphics, n4, n5, 4, 14);
            this.a(graphics, n4 + 73 + 4, n5, n9, 14);
            this.a(graphics, n4 + 14 + 1, n5, 4, 58);
            this.a(graphics, n4 + 73 + 4 + 14 + 1, n5, n9, 58);
            n6 = b.var_byte_arr_i[u.var_byte_a];
            for (n8 = 0; n8 < 4; ++n8) {
                this.a(graphics, n4, n5 + n8 * 19, n8, u.var_b_a.byte_b((byte)(n6 + n8)), u.var_b_a.byte_a(n6 + n8), false);
            }
            n6 += 4;
            for (n8 = 0; n8 < n9; ++n8) {
                this.a(graphics, n4 + 77, n5 + n8 * 19, 4 + n8, u.var_b_a.byte_b((byte)(n6 + n8)), u.var_b_a.byte_a(n6 + n8), false);
            }
        }
        graphics.setClip(0, 0, bw.g, bw.h);
        this.b(graphics, n2 + 8, n3 + 112, 62, this.var_boolean_a ? 0xFFFFFF : 0x7F7F7F, false);
        bk.a(graphics, n2 + 40, n3 + 108, ck.var_e_a.a(23 + (this.var_boolean_b ? 0 : 1)), 0, 1);
        if (ck.var_ck_a.boolean_a()) {
            this.d(graphics, n2 + 82, n3 + 108, this.var_b_a.var_short_b, true);
        }
    }

    private void a(Graphics graphics, int n2, int n3, int n4, byte n5, byte by2, boolean bl2) {
        int n6;
        if (n5 < 0) {
            graphics.drawImage(as.var_as_a.s, n2 + 37 + (this.var_boolean_b ? 0 : 7), n3 + 2, 17);
            return;
        }
        graphics.setColor(n5 > 0 ? 0xFFFFFF : 0x7F7F7F);
        if (bl2) {
            graphics.setClip(n2, n3, 73, 14);
            bk.a(graphics, n2 + 3, n3 + 2, ck.var_e_a.a(26), 0);
            bk.a(graphics, n2 + 37, n3 + 2, ("" + n4).getBytes(), 0);
            bk.a(graphics, n2 + 49, n3 + 2, ck.var_e_a.a(27), 0);
            graphics.setClip(0, 0, bw.g, bw.h);
        } else {
            int n7;
            int n8;
            int n9;
            graphics.setClip(n2 + (this.var_boolean_b ? 0 : 15), n3, this.var_boolean_b ? 73 : 58, 14);
            int n10 = n2 + 3 + (this.var_boolean_b ? 0 : 15);
            byte[] byArray = ck.var_ck_a.c.a(n4 * 2);
            int n11 = bk.a(byArray);
            int n12 = n11 > (this.var_boolean_b ? 70 : 55) ? ((n9 = this.scroll % (n8 = (n7 = n11 - (this.var_boolean_b ? 67 : 52)) * 2 + 80)) < 40 ? 0 : (n9 < n7 + 40 ? n9 - 40 : (n9 < n7 + 80 ? n7 : n7 - (n9 - (n7 + 80))))) : 0;
            bk.a(graphics, n10 - n12, n3 + 2, byArray, 0, 4);
            graphics.setClip(0, 0, bw.g, bw.h);
        }
        for (n6 = 0; n6 < n5; ++n6) {
            graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_h[1], n2 + 67 - 6 * n6, n3 + 14, 20);
        }
        for (n6 = n5; n6 < by2; ++n6) {
            graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_h[0], n2 + 67 - 6 * n6, n3 + 14, 20);
        }
        if (!this.var_boolean_b) {
            bd.var_bd_a.b((byte)n4, n2 + 1, n3 + 1);
            this.c(graphics, n2 + 5, n3 + 9, n4 + 1, false);
        }
    }

    public void void_b(int n2, int n3) {
        if (this.var_boolean_a) {
            this.b(bw.var_javax_microedition_lcdui_Graphics_a, n2 + 8, n3 + 112, 62, this.l == 0 ? 0x7F7F7F : 0xFFFFFF, false);
        } else {
            int n4 = this.h;
            int n5 = 0;
            if (this.var_boolean_b) {
                if (this.h >= this.d) {
                    n5 = 1;
                    n4 -= this.d;
                }
            } else if (this.h >= 4) {
                n5 = 1;
                n4 = this.h - 4;
            }
            int n6 = n2 + -15 + n5 * 77 + (this.var_boolean_b ? 0 : 15);
            int n7 = n3 + 12 + n4 * 19;
            if (var_byte_b == 4) {
                n7 += 10;
            }
            this.a(n6, n7, 72 + (this.var_boolean_b ? 0 : -15), 13);
        }
    }

    private void void_a() {
        if (this.var_boolean_b) {
            var_byte_a = (byte)8;
            var_byte_b = (byte)5;
            if (u.var_byte_a == 0) {
                var_byte_b = (byte)4;
            } else if (u.var_byte_a == 2) {
                var_byte_a = (byte)9;
            }
            this.d = b.var_byte_arr_i[u.var_byte_a];
        } else {
            var_byte_a = (byte)(u.var_byte_a == 0 ? 7 : 6);
            var_byte_b = (byte)4;
            this.d = (byte)4;
        }
        this.i = var_byte_a;
        this.k = var_byte_b;
    }

    public byte byte_a() {
        byte by2 = this.h;
        if (this.var_boolean_b) {
            if (this.h >= b.var_byte_arr_i[u.var_byte_a]) {
                by2 = (byte)(by2 + b.var_byte_arr_j[u.var_byte_a]);
            }
        } else {
            by2 = (byte)(by2 + b.var_byte_arr_i[u.var_byte_a]);
        }
        return by2;
    }

    static {
        var_byte_a = (byte)9;
        var_byte_b = (byte)5;
        c = (byte)2;
    }

    public void void_c(int n2, int n3) {
        if (((g)this).b == null) {
            ++this.scroll;
            this.e = true;
        }
        super.void_c(n2, n3);
    }
}

