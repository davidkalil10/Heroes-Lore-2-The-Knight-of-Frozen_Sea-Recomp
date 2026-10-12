/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class bi
extends g {
    public e var_e_a = null;
    public am var_am_a;
    public cp var_cp_a;
    public byte var_byte_a;
    public int var_int_a;
    public boolean var_boolean_a;
    public ci var_ci_a;

    public bi(g g2) {
        super(g2, (byte)3);
        this.f = true;
        this.var_boolean_a = false;
        this.var_e_a = bv.bv_a().var_e_a;
        this.var_ci_a = u.var_ci_a;
        this.b = new bx((g)this, this.var_e_a.a(21));
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.var_boolean_a) {
            return true;
        }
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.a((byte)0, (byte)0);
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            if (this.h == 0) {
                byte[] byArray = this.byte_arr_a(false);
                this.b = byArray == null ? new bx((g)this, this.var_e_a.a(10)) : new d((g)this, 0, byArray, this.var_e_a.a(8));
            } else if (this.h == 1) {
                if (this.var_am_a == null) {
                    this.b = new bx((g)this, this.var_e_a.a(8));
                    this.h = 0;
                    return true;
                }
                byte[] byArray = this.byte_arr_a();
                this.b = byArray == null ? new bx((g)this, this.var_e_a.a(11)) : new h(this, 1, this.var_e_a.a(8), byArray, true);
            } else if (this.h == 2) {
                int n4 = 0;
                if (this.var_am_a == null) {
                    n4 = 8;
                    this.h = 0;
                } else if (this.var_cp_a == null) {
                    n4 = 9;
                    this.h = 1;
                } else if (this.var_int_a > u.var_int_f) {
                    n4 = 12;
                } else {
                    n4 = 13;
                    this.var_boolean_a = true;
                }
                this.b = new bx((g)this, this.var_e_a.a(n4));
            } else if (this.h == 3) {
                this.var_g_a.a((byte)0, (byte)0);
            }
            return true;
        }
        if (n2 == 1 || n3 == 50) {
            this.h = this.h > 1 ? (byte)1 : 0;
        } else if (n2 == 6 || n3 == 56) {
            if (this.h < 2) {
                this.h = (byte)(this.h + 1);
            }
        } else if (n2 == 2 || n3 == 52 || n2 == 5 || n3 == 54) {
            this.h = this.h == 2 ? (byte)3 : (byte)2;
        }
        return true;
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        if (by2 == 0 && by3 > -1) {
            this.var_byte_a = by3;
            this.var_am_a = (am)u.var_ci_a.cp_a((int)by3);
            this.void_a();
        } else if (by2 == 1 && by3 > -1) {
            this.var_cp_a = u.var_ci_a.cp_a((int)by3);
            this.b();
        }
    }

    public void void_a() {
        if (this.var_cp_a != null) {
            this.var_cp_a = null;
        }
        this.var_int_a = 0;
    }

    public void b() {
        if (this.var_cp_a == null) {
            return;
        }
        switch (this.var_cp_a.g) {
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                switch (this.var_cp_a.h) {
                    case 0: {
                        this.var_int_a = 1000;
                        break;
                    }
                    case 1: {
                        this.var_int_a = 5000;
                        break;
                    }
                    case 2: {
                        this.var_int_a = 10000;
                    }
                }
                break;
            }
            default: {
                this.var_int_a = 3000;
            }
        }
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        this.c();
        g.a(graphics, n2, n3, true, false);
        graphics.setColor(0);
        graphics.fillRect(n2 + -36, n3, 192, 14);
        for (int i2 = 0; i2 < 2; ++i2) {
            graphics.fillRect(n2 + -18, n3 + 31 + i2 * 29, 14, 14);
            graphics.fillRect(n2 + -1, n3 + 31 + i2 * 29, 140, 14);
        }
        graphics.setColor(0x7F7F7F);
        bk.a(graphics, bw.i, n3 + 2, this.var_e_a.a(1), 1, 1);
        if (this.var_am_a == null) {
            graphics.setColor(0x7F7F7F);
            graphics.fillRect(n2 + -18 + 1, n3 + 31 + 1, 12, 12);
            graphics.fillRect(n2 + -1 + 1, n3 + 31 + 1, 138, 12);
        } else {
            bd.a(n2 + -18 + 1, n3 + 31 + 1, this.var_am_a.g);
            graphics.setColor(0xFFFFFF);
            bk.a(graphics, n2 + -1 + 5, n3 + 31 + 2, this.var_am_a.j, 1);
        }
        if (this.var_cp_a == null) {
            graphics.setColor(0x7F7F7F);
            graphics.fillRect(n2 + -18 + 1, n3 + 31 + 1 + 29, 12, 12);
            graphics.fillRect(n2 + -1 + 1, n3 + 31 + 1 + 29, 138, 12);
        } else {
            bd.a(n2 + -18 + 1, n3 + 31 + 1 + 29, this.var_cp_a.g);
            graphics.setColor(0xFFFFFF);
            bk.a(graphics, n2 + -1 + 5, n3 + 31 + 2 + 29, this.var_cp_a.j, 1);
            graphics.setColor(15128512);
            bk.a(graphics, n2 + -1 + 8, n3 + 18 + 58, this.var_e_a.a(7), 1);
            bk.a(graphics, n2 + 120 - 14 - 4, n3 + 18 + 58, ("" + this.var_int_a).getBytes(), 1, 8);
        }
        graphics.setColor(15128512);
        bk.a(graphics, bw.i + -58, n3 + 19, this.var_e_a.a(5), 1);
        bk.a(graphics, bw.i + -35, n3 + 19 + 29, this.var_e_a.a(6), 1);
        graphics.setColor(0);
        graphics.fillRect(n2 + 13, n3 + 88, 46, 16);
        graphics.setColor(this.h != 2 ? 0x7F7F7F : 0xFFFFFF);
        bk.a(graphics, n2 + 13 + 23, n3 + 88 + 3, this.var_e_a.a(3), 1, 1);
        this.a(graphics, this.var_e_a.a(4), n2 + 62, n3 + 88, this.h != 3 ? 0x7F7F7F : 0xFFFFFF);
        this.c(graphics, n2 + 110, n3 + 110, u.var_int_f);
    }

    public void void_b(int n2, int n3) {
        int n4 = n2 + 13 - 1;
        int n5 = n3 + 31;
        if (this.h < 2) {
            this.a(n2 + -18, n3 + 31 + this.h * 29, 14, 14);
            this.a(n2 + -1, n3 + 31 + this.h * 29, 140, 14);
        } else {
            this.a(this.h == 3 ? n2 + 62 : n4, n5 += 56, 46, 16);
        }
    }

    public void c() {
        if (!this.var_boolean_a) {
            return;
        }
        switch (this.var_cp_a.g) {
            case 19: {
                ((cf)this.var_am_a).n = (byte)(this.var_cp_a.h + 1);
                break;
            }
            case 18: {
                ((cf)this.var_am_a).i = (byte)(this.var_cp_a.h + 1);
                break;
            }
            default: {
                int n2 = this.var_cp_a.h * 2 + this.var_cp_a.h / 2;
                int n3 = this.var_cp_a.h * 3 + 4;
                this.var_am_a.i[this.var_cp_a.g - 13] = (byte)f.a(n2, n3);
            }
        }
        this.var_am_a.e = cp.a(this.var_am_a);
        this.var_ci_a.void_a(this.var_cp_a.g, this.var_cp_a.h, (byte)1);
        u.var_int_f -= this.var_int_a;
        this.void_a();
        if (this.var_am_a != null) {
            this.var_am_a = null;
        }
        this.h = 0;
        try {
            u.var_u_a.l();
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.b = new bx((g)this, this.var_e_a.a(14));
        this.var_boolean_a = false;
    }

    public final byte[] byte_arr_a() {
        int n2;
        byte[] byArray = new byte[this.var_ci_a.var_java_util_Vector_a.size()];
        int n3 = 0;
        int n4 = 0;
        for (n2 = 0; n2 < 5; ++n2) {
            if (this.var_am_a.i[n2] <= 0) continue;
            ++n4;
        }
        n2 = 0;
        for (int i2 = 0; i2 < 5; ++i2) {
            if (n4 >= 2 && this.var_am_a.i[i2] <= 0) continue;
            for (byte by2 = 0; by2 < 3; by2 = (byte)(by2 + 1)) {
                n2 = this.var_ci_a.byte_a((byte)(13 + i2), by2);
                if (n2 <= -1) continue;
                byArray[n3++] = n2;
            }
        }
        if (this.var_am_a instanceof cf) {
            byte by3;
            cf cf2 = (cf)this.var_am_a;
            if (cf2.i < 1) {
                for (by3 = 0; by3 < 6; by3 = (byte)(by3 + 1)) {
                    n2 = this.var_ci_a.byte_a((byte)18, by3);
                    if (n2 <= -1) continue;
                    byArray[n3++] = n2;
                }
            }
            if (cf2.n < 1) {
                for (by3 = 0; by3 < 5; by3 = (byte)(by3 + 1)) {
                    n2 = this.var_ci_a.byte_a((byte)19, by3);
                    if (n2 <= -1) continue;
                    byArray[n3++] = n2;
                }
            }
        }
        if (n3 == 0) {
            return null;
        }
        byte[] byArray2 = new byte[n3];
        System.arraycopy(byArray, 0, byArray2, 0, n3);
        return byArray2;
    }
}

