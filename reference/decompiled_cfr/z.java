/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class z
extends g {
    public cg var_cg_a;
    public byte var_byte_a = (byte)(this.i == 4 ? 2 : 1);
    public cp[] var_cp_arr_a = new cp[this.var_byte_a];
    public boolean var_boolean_a = false;

    public z(g g2, cg cg2) {
        super(g2, (byte)(cg2.int_a() == 0 ? 4 : 3));
        this.var_cg_a = cg2;
        this.f = true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean boolean_a(int n2, int n3) {
        block18: {
            block20: {
                block19: {
                    if (this.boolean_b(n2, n3)) {
                        if (!this.var_boolean_a) return true;
                        this.var_g_a.b(0);
                        return true;
                    }
                    if (this.var_boolean_a) {
                        return true;
                    }
                    if (n3 == 8) {
                        this.void_a();
                        return true;
                    }
                    if (n2 != 8 && n3 != 53) break block19;
                    if (this.h < this.var_byte_a) {
                        byte[] byArray = u.var_ci_a.byte_arr_b((byte)22, (byte)-1);
                        this.b = byArray == null ? new bx((g)this, cm.var_e_a.a(18)) : new h(this, 6, cm.var_e_a.a(19), byArray, true);
                        break block18;
                    } else if (this.h == this.var_byte_a + 1) {
                        this.void_a();
                        break block18;
                    } else {
                        if (this.boolean_a()) {
                            this.var_boolean_a = true;
                            this.b = new bx((g)this, cm.var_e_a.a(20));
                            return true;
                        }
                        this.b = new bx((g)this, cm.var_e_a.a(23));
                        return true;
                    }
                }
                if (n2 != 1 && n3 != 50) break block20;
                if (this.h > this.var_byte_a) {
                    this.h = (byte)(this.h - 2);
                    break block18;
                } else if (this.h > 0) {
                    this.h = (byte)(this.h - 1);
                }
                break block18;
            }
            if (n2 == 6 || n3 == 56) {
                if (this.h < this.var_byte_a) {
                    this.h = (byte)(this.h + 1);
                }
            } else if (n2 == 2 || n3 == 52 || n2 == 5 || n3 == 54) {
                if (this.h == this.var_byte_a) {
                    this.h = (byte)(this.h + 1);
                } else if (this.h > this.var_byte_a) {
                    this.h = (byte)(this.h - 1);
                }
            }
        }
        this.e = true;
        return true;
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        if (by2 == 6 && by3 > -1) {
            this.b(this.h);
            this.a(by3);
        }
    }

    private boolean boolean_a() {
        for (byte by2 = 0; by2 < this.var_byte_a; by2 = (byte)(by2 + 1)) {
            if (this.var_cp_arr_a[by2] != null) continue;
            return false;
        }
        return true;
    }

    private void a(byte by2) {
        cp cp2 = u.var_ci_a.cp_a((int)by2);
        this.var_cp_arr_a[this.h] = cp.a(cp2.g, cp2.h, true, true);
        u.var_ci_a.a(by2, 1);
    }

    private void b(byte by2) {
        if (this.var_cp_arr_a[by2] != null) {
            u.var_ci_a.a(cp.a(this.var_cp_arr_a[by2].g, this.var_cp_arr_a[by2].h, true, true), (byte)1);
            this.var_cp_arr_a[by2] = null;
        }
    }

    private void void_a() {
        for (byte by2 = 0; by2 < this.var_byte_a; by2 = (byte)(by2 + 1)) {
            this.b(by2);
        }
        this.var_g_a.b(0);
    }

    private void b() {
        int n2;
        int n3 = this.var_cg_a.int_a();
        boolean bl2 = true;
        for (n2 = 0; n2 < this.var_byte_a; ++n2) {
            if (n3 >= 1 || this.var_cp_arr_a[n2].h + 1 != 3) continue;
            bl2 = false;
            break;
        }
        if (bl2) {
            switch (n3) {
                case -1: {
                    this.var_cg_a.a((byte)(this.var_cp_arr_a[0].h + 1), 0);
                    break;
                }
                case 0: {
                    this.var_cg_a.a((byte)(this.var_cp_arr_a[0].h + 1), 1);
                    this.var_cg_a.a((byte)(this.var_cp_arr_a[1].h + 1), 2);
                    break;
                }
                case 1: {
                    this.var_cg_a.a((byte)(this.var_cp_arr_a[0].h + 1), 3);
                }
            }
            this.var_cg_a.b(this.var_cg_a.var_boolean_a);
            this.var_cg_a.d();
            if (this.var_cg_a.var_boolean_a) {
                u.var_u_a.h();
            }
        }
        for (n2 = 0; n2 < this.var_byte_a; ++n2) {
            this.var_cp_arr_a[n2] = null;
        }
        this.b = bl2 ? new bm(this, this.var_cg_a, false) : new bx((g)this, cm.var_e_a.a(22));
    }

    public void void_a(int n2, int n3) {
        int n4;
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        if (this.var_boolean_a) {
            this.b();
        }
        g.a(graphics, n2, n3, true, false);
        int n5 = bw.i - 90;
        int n6 = n3 + 54 + 7 * (2 - this.var_byte_a);
        for (n4 = 0; n4 < this.var_byte_a; ++n4) {
            graphics.setColor(0);
            graphics.fillRect(n5, n6 + n4 * 16, 180, 14);
            graphics.setColor(0x7F7F7F);
            if (this.var_cp_arr_a[n4] == null) {
                graphics.fillRect(n5 + 1, n6 + 1 + n4 * 16, 178, 12);
                graphics.setColor(0xFFFFFF);
                bk.a(graphics, n5 + 12, n6 + 2 + n4 * 16, cm.var_e_a.a(19), 1);
                continue;
            }
            bd.a(n5 + 2, n6 + 1 + n4 * 16, (byte)22);
            graphics.setColor(0xFFFFFF);
            bk.a(graphics, n5 + 30, n6 + 2 + n4 * 16, this.var_cp_arr_a[n4].j, 1);
        }
        graphics.setColor(0x7F7F7F);
        bk.a(graphics, bw.i, n3 + 2, cm.var_e_a.a(2), 1, 1);
        bd.a(n2 + 10, n3 + 19, (byte)23);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n2 + 30, n3 + 20, this.var_cg_a.i, 1);
        n4 = this.var_cg_a.int_a();
        if (n4 > -1) {
            graphics.setColor(14467940);
            bk.a(graphics, n2 + 94, n3 + 20, ck.var_e_a.a(50 + n4), 1);
        }
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_o, n2 + 10, n3 + 34, 20);
        this.a(graphics, n2 + 66, n3 + 34, this.var_cg_a);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_d, n2 + 10, n3 + 44, 20);
        f.a(graphics, this.var_cg_a.var_short_b, n2 + 40, n3 + 44, 8, 0);
        this.a(graphics, cm.var_e_a.a(16), bw.i - 48, n3 + 88, this.h != this.var_byte_a ? 0x7F7F7F : 0xFFFFFF);
        this.a(graphics, cm.var_e_a.a(17), bw.i + 2, n3 + 88, this.h != this.var_byte_a + 1 ? 0x7F7F7F : 0xFFFFFF);
    }

    public void void_b(int n2, int n3) {
        if (this.h >= this.var_byte_a) {
            this.a(bw.i - 48 + 50 * (this.h - this.var_byte_a), n3 + 88, 46, 16);
        } else {
            this.a(bw.i - 90, n3 + 54 + 7 * (2 - this.var_byte_a) + this.h * 16, 179, 13);
        }
    }
}

