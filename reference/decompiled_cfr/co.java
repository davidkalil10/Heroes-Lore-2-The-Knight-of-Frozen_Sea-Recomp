/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class co
extends g {
    public final byte var_byte_a = (byte)10;
    public final byte b = (byte)100;
    public byte[] i;
    public byte[] j;
    public b var_b_a = null;
    public boolean var_boolean_a;

    public co(g g2) {
        super(g2, (byte)7, (byte)3, (byte)3);
        this.l = 0;
        this.f = true;
        this.var_boolean_a = false;
        this.var_b_a = u.var_b_a;
        this.i = new byte[7];
        this.j = new byte[7];
        for (int n2 = 0; n2 < 7; n2 = (int)((byte)(n2 + 1))) {
            this.j[n2] = -1;
        }
        this.i = u.var_ci_a.byte_arr_b();
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            if (this.var_boolean_a) {
                this.a((byte)2, 2, ck.var_e_a.a(53, 54));
            } else {
                this.var_g_a.b(3);
            }
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            return this.boolean_a();
        }
        if (this.boolean_d(n2, n3)) {
            return true;
        }
        return this.e(n2, n3);
    }

    public boolean boolean_a() {
        cp cp2 = this.var_b_a.cp_a((int)this.h);
        if (this.j[this.h] != 100 && (cp2 != null || this.j[this.h] > -1)) {
            this.a((byte)8, ck.var_e_a.a(29, 49, 31));
        } else {
            this.a((byte)8, new byte[][]{ck.var_e_a.a(29)});
        }
        return true;
    }

    public void a(byte by2, byte by3) {
        this.b((int)by3);
        p p2 = null;
        if (by2 == 2) {
            if (by3 == 0) {
                ((g)this).b = new bx((g)this, ck.var_e_a.a(56));
                for (byte by4 = 0; by4 < 7; by4 = (byte)(by4 + 1)) {
                    this.b(by4);
                }
                b b2 = u.var_b_a;
                b2.boolean_b();
            } else {
                this.void_a();
            }
            this.var_g_a.b(3);
        }
        if (by2 == 10) {
            if (by3 > -1) {
                boolean bl2 = false;
                p p3 = (p)u.var_ci_a.var_java_util_Vector_a.elementAt(by3);
                if (p3.a > this.var_b_a.var_byte_a) {
                    ((g)this).b = new bx((g)this, ck.var_e_a.a(69));
                } else if (p3 instanceof am && ((am)p3).o > 0) {
                    switch (u.var_byte_a) {
                        case 1: {
                            bl2 = true;
                            break;
                        }
                        case 0: {
                            if (this.var_b_a.byte_b((byte)13) > 0) {
                                bl2 = true;
                                break;
                            }
                            ((g)this).b = new bx((g)this, ck.var_e_a.a(59));
                            break;
                        }
                        case 2: {
                            if (bl2) break;
                            ((g)this).b = new bx((g)this, ck.var_e_a.a(59));
                        }
                    }
                } else {
                    bl2 = true;
                }
                if (bl2) {
                    this.b(this.h, by3);
                }
            }
        } else if (by2 == 8) {
            if (by3 == 2) {
                p2 = this.j[this.h] > -1 ? (p)u.var_ci_a.cp_a((int)this.j[this.h]) : (p)this.var_b_a.cp_a((int)this.h);
                ((g)this).b = new aq((g)this, p2);
            } else if (by3 == 1) {
                this.void_a(this.h);
            } else if (by3 == 0) {
                byte by5 = -1;
                int n2 = -1;
                switch (this.h) {
                    case 0: {
                        by5 = 8;
                        break;
                    }
                    case 1: {
                        by5 = 5;
                        break;
                    }
                    case 2: {
                        by5 = 11;
                        n2 = 12;
                        break;
                    }
                    case 3: {
                        switch (u.var_byte_a) {
                            case 0: {
                                by5 = 0;
                                n2 = 1;
                                break;
                            }
                            case 1: {
                                by5 = 2;
                                n2 = 4;
                                break;
                            }
                            case 2: {
                                by5 = 2;
                                n2 = 3;
                            }
                        }
                        break;
                    }
                    case 4: {
                        by5 = 6;
                        break;
                    }
                    case 5: {
                        switch (u.var_byte_a) {
                            case 0: {
                                ((g)this).b = new bx((g)this, ck.var_e_a.a(41));
                                return;
                            }
                            case 1: {
                                by5 = 10;
                                break;
                            }
                            case 2: {
                                by5 = 3;
                            }
                        }
                        break;
                    }
                    case 6: {
                        by5 = 9;
                    }
                }
                byte[] byArray = u.var_ci_a.byte_arr_b(by5, (byte)n2);
                if (byArray != null) {
                    ((g)this).b = new h(this, 10, ck.var_e_a.a(58), byArray, true);
                } else {
                    ((g)this).b = new bx((g)this, ck.var_e_a.a(42));
                    return;
                }
            }
        }
    }

    public final void void_a(byte by2) {
        b b2 = u.var_b_a;
        b2.boolean_d(by2);
        this.j[by2] = 100;
        this.var_boolean_a = true;
        b2.n();
    }

    public final void b(byte by2, byte by3) {
        b b2 = u.var_b_a;
        b2.boolean_d(by2);
        p p2 = (p)u.var_ci_a.cp_a((int)by3);
        b2.a(by2, p2);
        this.j[by2] = by3;
        this.var_boolean_a = true;
        b2.n();
    }

    public final void void_a() {
        for (byte by2 = 0; by2 < 7; by2 = (byte)((byte)(by2 + 1))) {
            if (this.j[by2] <= -1) continue;
            this.b(by2, this.i[by2]);
        }
    }

    public final void b(byte by2) {
        byte by3 = this.j[by2];
        if (by3 < 0) {
            return;
        }
        b b2 = u.var_b_a;
        if (by3 == 100) {
            if (by2 == 3) {
                as.var_as_a.b(6);
                as.var_as_a.a(true);
                if (u.var_byte_a == 2 && b2.am_a() != null) {
                    as.var_as_a.a((byte)51);
                }
                return;
            }
            if (by2 == 5) {
                as.var_as_a.b(7);
                if (u.var_byte_a == 2) {
                    as.var_as_a.a(false);
                }
                return;
            }
        }
        if (by2 == 2) {
            return;
        }
        if (by3 == 100 || this.i[by2] != this.j[by2]) {
            switch (by2) {
                case 0: {
                    as.var_as_a.a(2);
                    break;
                }
                case 1: {
                    as.var_as_a.a(0);
                    break;
                }
                case 3: {
                    cf cf2;
                    as.var_as_a.a(6);
                    as.var_as_a.a(5);
                    if (u.var_byte_a != 2 || (cf2 = (cf)b2.am_a()) != null && cf2.i >= 1) break;
                    as.var_as_a.a(false);
                    break;
                }
                case 4: {
                    as.var_as_a.a(1);
                    break;
                }
                case 5: {
                    as.var_as_a.a(7);
                    break;
                }
                case 6: {
                    as.var_as_a.a(3);
                }
            }
        }
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, false, true);
        graphics.setColor(0);
        graphics.fillRect(n2 + -35, n3 + 117 - 24, 217, 24);
        int n4 = n2 + 40;
        int n5 = n3 + 35;
        int n6 = 0;
        int n7 = 0;
        for (byte by2 = 0; by2 < 6; by2 = (byte)(by2 + 1)) {
            n7 = by2 / 3;
            this.b(graphics, by2, n4 + n6 * 14, n5 + n7 * 14 + ((n6 = by2 % 3) == 1 ? -7 : 0));
        }
        this.b(graphics, (byte)6, n2 + 54, n3 + 56);
        n5 = n3 + 83;
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_h, n2 + 5, n5, 20);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_i, n2 + 44, n5, 20);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_f, n2 + 82, n5, 20);
        f.a(graphics, this.var_b_a.var_int_g, n2 + 38, n5, 8, 0);
        f.a(graphics, this.var_b_a.var_int_i, n2 + 76, n5, 8, 0);
        f.a(graphics, this.var_b_a.var_int_a, n2 + 113, n5, 8, 0);
        cp cp2 = this.cp_a(this.h);
        this.a(graphics, n2 + -12, n3 + 117 - 22, cp2, false, false, false);
    }

    public void b(Graphics graphics, byte by2, int n2, int n3) {
        if (this.i[by2] < 0 && this.j[by2] < 0 || this.j[by2] == 100) {
            this.e(graphics, n2, n3, by2);
        } else {
            cp cp2 = this.cp_a(by2);
            bd.a(n2, n3, cp2.g);
        }
    }

    public cp cp_a(byte by2) {
        cp cp2 = null;
        if (this.j[by2] > -1) {
            cp2 = u.var_ci_a.cp_a((int)this.j[by2]);
        } else if (this.i[by2] > -1) {
            cp2 = u.var_ci_a.cp_a((int)this.i[by2]);
        }
        return cp2;
    }

    public void void_b(int n2, int n3) {
        int n4 = this.h / 3;
        int n5 = this.h % 3;
        int n6 = n2 + 40 + n5 * 14;
        int n7 = n3 + 35 + n4 * 14 + (n5 == 1 ? -7 : 0);
        if (n4 == 2) {
            n6 = n2 + 54;
            n7 = n3 + 56;
        }
        this.a(n6, n7, 11, 11);
    }

    private void e(Graphics graphics, int n2, int n3, int n4) {
        graphics.setClip(n2, n3, 12, 12);
        graphics.drawImage(as.r, n2, n3 - n4 * 12, 20);
        graphics.setClip(0, 0, bw.g, bw.h);
    }

    public void d(byte by2) {
        if (by2 == 4) {
            this.h = (byte)(this.h + ((g)this).j);
            if (this.h > 8) {
                this.h = 1;
            }
            if (this.h > 6) {
                this.h = (byte)6;
            }
        } else {
            this.h = this.h == 6 ? (byte)4 : (byte)(this.h - ((g)this).j);
            if (this.h == -2) {
                this.h = (byte)6;
            } else if (this.h < 0) {
                this.h = 1;
            }
        }
    }

    public void c(byte by2) {
        this.h = by2 == 4 ? (this.h == 6 ? (byte)(this.h - 1) : (this.h % 3 == 2 ? (byte)(this.h - 2) : (byte)(this.h + 1))) : (this.h == 6 ? (byte)3 : (this.h % 3 == 0 ? (byte)(this.h + 2) : (byte)(this.h - 1)));
    }
}

