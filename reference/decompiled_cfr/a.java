/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class a
extends r {
    public byte var_byte_a = 0;
    public int var_int_a = 0;
    public byte var_byte_b = 0;
    public int var_int_b = 0;
    public boolean var_boolean_a;
    public Vector var_java_util_Vector_a;

    public a(g g2) {
        super(g2, (byte)6);
        this.f();
        this.var_boolean_a = true;
        ((g)this).f = true;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (r.var_byte_c != 3 || this.var_boolean_a) {
            return true;
        }
        if (n3 == 8) {
            this.f();
            this.b(0);
            this.var_g_a.b(0);
            return true;
        }
        if (n2 == 2 || n3 == 52 || n2 == 5 || n3 == 54) {
            this.var_byte_b = (byte)((this.var_byte_b + 1) % 2);
            this.var_boolean_a = true;
            return true;
        }
        if (r.var_boolean_b || this.var_int_a < 1) {
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            this.void_a();
            if (this.var_byte_b == 0) {
                this.a((byte)3, 2, r.var_e_a.a(16, 14));
            } else if (u.var_ci_a.c(r.var_cp_a.g)) {
                this.a((byte)3, 2, r.var_e_a.a(16, 15));
            } else if (u.var_ci_a.boolean_a(r.var_cp_a.g, r.var_cp_a.h)) {
                this.a((byte)3, 1, new byte[][]{r.var_e_a.a(16)});
            }
        } else if (n2 == 1 || n3 == 50) {
            this.h = (byte)((this.h + this.var_int_a - 1) % this.var_int_a);
        } else if (n2 == 6 || n3 == 56) {
            this.h = (byte)((this.h + 1) % this.var_int_a);
        }
        return true;
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        if (by2 == 3) {
            if (by3 == 0) {
                this.a((byte)10, 2, new byte[][]{ck.var_e_a.a(47)});
            } else if (by3 == 1) {
                if (this.boolean_a()) {
                    if (!u.var_ci_a.a(r.var_cp_a.g, r.var_cp_a.h, r.var_cp_a.c)) {
                        ((g)this).b = new bx((g)this, r.var_e_a.a(20));
                    } else {
                        this.c();
                    }
                } else if (r.var_cp_a.c > 1) {
                    ((g)this).b = new bs(this, -1, r.var_cp_a.c);
                } else {
                    this.a((byte)r.var_cp_a.c);
                }
            }
        } else if (by2 == 10) {
            if (by3 == 0) {
                if (this.var_byte_b == 0) {
                    this.void_b();
                } else {
                    u.var_ci_a.void_a(r.e);
                    this.var_boolean_a = true;
                    try {
                        u.f(u.var_byte_c);
                    }
                    catch (Exception exception) {}
                }
            }
        } else if (by2 == 50 && by3 > 0) {
            this.a(by3);
        }
    }

    public void void_a() {
        r.e = (byte)(this.h + this.var_byte_b);
        r.var_cp_a = (cp)this.var_java_util_Vector_a.elementAt(r.e);
        r.f = (byte)r.var_cp_a.c;
    }

    public boolean boolean_a() {
        return this.var_byte_b == 0;
    }

    public void a(byte by2) {
        r.f = by2;
        this.a((byte)19, 5);
    }

    public void void_b() {
        r.f = (byte)(-r.var_cp_a.c);
        this.a((byte)11, 5);
    }

    public void c() {
        r.f = (byte)r.var_cp_a.c;
        this.a((byte)11, 5);
    }

    public void void_a(int n2, int n3) {
        int n4;
        int n5;
        if (this.var_boolean_a || r.var_boolean_b) {
            this.var_java_util_Vector_a = this.var_byte_b == 0 ? r.var_java_util_Vector_b : u.var_ci_a.var_java_util_Vector_a;
            this.var_int_a = this.var_java_util_Vector_a == null ? 0 : this.var_java_util_Vector_a.size() - this.var_byte_b;
            if (this.var_boolean_a) {
                this.h = 0;
            }
            if (r.var_boolean_b) {
                if (this.var_java_util_Vector_a == null) {
                    this.h = 0;
                } else if (this.h >= this.var_java_util_Vector_a.size() - this.var_byte_b) {
                    this.h = (byte)(this.h - 1);
                }
            }
            this.var_boolean_a = false;
            r.var_boolean_b = false;
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        int n6 = this.h / 6;
        g.a(graphics, n2, n3, false, false);
        graphics.setColor(6970180);
        graphics.fillRect(bw.i - 50 + this.var_byte_b * 50, n3, 50, 13);
        for (n5 = 0; n5 < 2; ++n5) {
            graphics.setColor(this.var_byte_b == n5 ? 0xFFFFFF : 0x7F7F7F);
            bk.a(graphics, bw.i - 25 + n5 * 50, n3 + 2, r.var_e_a.a(11 + n5), 1, 1);
        }
        this.b(graphics, n2 + 4, n3 + 6, 111, 0x7F7F7F, true);
        n5 = n2 + 4 + 14 + 1;
        int n7 = n3 + 20;
        graphics.setColor(0);
        graphics.fillRect(n5, n7, 96, 89);
        if (this.var_int_a < 1) {
            graphics.setColor(0x7F7F7F);
            bk.a(graphics, n5 + 2, n7 + 2, r.var_e_a.a(13), 0);
            return;
        }
        graphics.fillRect(n5, n7, 96, 89);
        int n8 = 0;
        int n9 = 0;
        for (n4 = 0; n4 < 6; ++n4) {
            cp cp2 = this.cp_a(n4 + n6 * 6);
            if (cp2 != null) {
                graphics.setColor(0);
                graphics.fillRect(n2 + 4, n3 + 20 + n4 * 15, 14, 14);
                if (n4 == this.h % 6) {
                    this.a(graphics, n5 + 2, n7 + 2, cp2, true, true, true);
                }
                n8 = n2 + 1 + 4;
                n9 = n3 + 1 + 20 + n4 * 15;
                bd.a(n8, n9, cp2.g);
                if (cp2.c > 1) {
                    f.a(graphics, cp2.c, n8 + 14 - 2, n9 + 14 - 8, 8, 0);
                    graphics.setClip(n2, n3, 120, 117);
                }
            }
            cp2 = null;
        }
        n4 = n2 + 120 - 7;
        this.b(graphics, n4, n3 + 13, this.h + 1, this.var_int_a);
    }

    public cp cp_a(int n2) {
        if (this.var_java_util_Vector_a == null || n2 + this.var_byte_b >= this.var_java_util_Vector_a.size()) {
            return null;
        }
        return (cp)this.var_java_util_Vector_a.elementAt(n2 + this.var_byte_b);
    }

    public void void_b(int n2, int n3) {
        if (this.var_int_a < 1) {
            return;
        }
        int n4 = this.h % 6;
        this.a(n2 + 4, n3 + 20 + n4 * 15, 13, 13);
    }
}

