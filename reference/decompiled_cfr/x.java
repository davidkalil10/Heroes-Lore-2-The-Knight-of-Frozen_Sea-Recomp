/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class x
extends g {
    public e var_e_a = null;
    public s var_s_a;
    public cp var_cp_a;
    public int var_int_a;
    public byte var_byte_a;
    public byte[] i;
    public byte b;

    public x(g g2) {
        super(g2, (byte)2);
        this.f = true;
        this.b = (byte)2;
        this.var_e_a = bv.bv_a().var_e_a;
        this.void_a();
    }

    public void void_a() {
        this.b();
        byte[] byArray = u.var_ci_b.byte_arr_b((byte)23, (byte)-1);
        if (byArray == null) {
            ((g)this).b = new bx((g)this, this.var_e_a.a(17));
            this.b = (byte)5;
        } else {
            ((g)this).b = new h(this, 1, this.var_e_a.a(15), byArray, false);
        }
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.b == 5) {
            this.var_g_a.a((byte)0, (byte)0);
            return true;
        }
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (this.b == 3) {
            return true;
        }
        if (this.b == 4) {
            if (n2 == 8 || n3 == 8 || n3 == 53) {
                this.var_g_a.a((byte)0, (byte)0);
            }
            return true;
        }
        if (n3 == 8) {
            this.void_a();
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            if (this.h == 0) {
                if (!this.boolean_a()) {
                    ((g)this).b = new bx((g)this, this.var_e_a.a(18));
                } else if (this.var_int_a > u.var_int_f) {
                    ((g)this).b = new bx((g)this, this.var_e_a.a(12));
                } else {
                    this.b = (byte)3;
                }
            } else if (this.h == 1) {
                this.var_g_a.a((byte)0, (byte)0);
            }
            return true;
        }
        return this.boolean_d(n2, n3);
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        if (by2 == 1) {
            if (by3 > -1) {
                this.var_s_a = (s)u.var_ci_b.cp_a((int)by3);
            }
            if (this.var_s_a == null) {
                this.var_g_a.a((byte)0, (byte)0);
            } else {
                this.c();
            }
        }
    }

    public void b() {
        this.i = new byte[3];
        this.var_byte_a = 0;
        this.var_int_a = 0;
        this.var_s_a = null;
    }

    public void c() {
        byte by2 = 0;
        int n2 = 0;
        for (int i2 = 0; i2 < 3; ++i2) {
            if (this.var_s_a.i[i2] > -1) {
                if (ci.boolean_a(this.var_s_a.i[i2])) {
                    n2 = u.var_ci_b.byte_b(this.var_s_a.i[i2], this.var_s_a.l[i2]);
                    if (n2 > -1) {
                        n2 = (byte)(n2 + 50);
                    }
                } else {
                    n2 = u.var_ci_a.byte_b(this.var_s_a.i[i2], this.var_s_a.l[i2]);
                }
                by2 = (byte)(by2 + 1);
            } else {
                n2 = -1;
            }
            this.i[i2] = n2;
        }
        this.var_byte_a = by2;
        this.var_int_a = 1000;
    }

    public boolean boolean_a() {
        for (int i2 = 0; i2 < this.var_byte_a; ++i2) {
            if (this.i[i2] != -1) continue;
            return false;
        }
        return true;
    }

    public void d() {
        u.var_int_f -= this.var_int_a;
        for (int i2 = 0; i2 < this.var_byte_a; ++i2) {
            if (ci.boolean_a(this.var_s_a.i[i2])) {
                u.var_ci_b.void_a(this.var_s_a.i[i2], this.var_s_a.l[i2], (byte)1);
                continue;
            }
            u.var_ci_a.void_a(this.var_s_a.i[i2], this.var_s_a.l[i2], (byte)1);
        }
        this.var_cp_a = cp.a(this.var_s_a.a, this.var_s_a.b, true, true);
        if (ci.boolean_a(this.var_s_a.a)) {
            u.var_ci_b.a(this.var_cp_a, (byte)1);
        } else {
            u.var_ci_a.a(this.var_cp_a, (byte)1);
        }
        u.var_ci_b.void_a(this.var_s_a.g, this.var_s_a.h, (byte)1);
    }

    public void void_a(int n2, int n3) {
        if (this.var_s_a == null) {
            return;
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, false, false);
        graphics.setColor(0);
        graphics.fillRect(n2 + -36, n3, 192, 14);
        switch (this.b) {
            case 3: {
                this.d();
                this.b = (byte)4;
            }
            case 4: {
                this.c(graphics, n2, n3);
                break;
            }
            case 2: {
                this.d(graphics, n2, n3);
            }
        }
    }

    public void c(Graphics graphics, int n2, int n3) {
        graphics.fillRect(n2 + -27, n3 + 17, 14, 14);
        graphics.fillRect(n2 + -10, n3 + 17, 156, 88);
        graphics.fillRect(n2 + -36, n3 + 117 - 9, 192, 9);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, bw.i, n3 + 117 - 9, as.var_e_a.a(21), 1, 1);
        graphics.setColor(0x7F7F7F);
        bk.a(graphics, bw.i, n3 + 2, this.var_e_a.a(19), 1, 1);
        bd.a(n2 + -27, n3 + 18, this.var_cp_a.g);
        this.a(graphics, n2 + -7, n3 + 20, this.var_cp_a, true, false, false);
    }

    public void d(Graphics graphics, int n2, int n3) {
        graphics.setColor(0);
        graphics.fillRect(n2 + -28, n3 + 19, 14, 14);
        graphics.fillRect(n2 + -10, n3 + 19, 156, 74);
        graphics.setColor(0x7F7F7F);
        bk.a(graphics, bw.i, n3 + 2, this.var_e_a.a(2), 1, 1);
        bd.a(n2 + -27, n3 + 20, (byte)29);
        bk.a(graphics, n2 + 5, n3 + 39, 130, 1, this.var_s_a.k, 0, 0, this.var_s_a.k.length);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n2 + -7, n3 + 23, this.var_s_a.j, 0);
        graphics.setColor(15128512);
        bk.a(graphics, n2 + 145, n3 + 81, ("Cost " + this.var_int_a).getBytes(), 1, 8);
        this.a(graphics, this.var_e_a.a(16), n2 + 12, n3 + 97, this.h != 0 ? 0x7F7F7F : 0xFFFFFF);
        this.a(graphics, this.var_e_a.a(4), n2 + 62, n3 + 97, this.h != 1 ? 0x7F7F7F : 0xFFFFFF);
        for (int i2 = 0; i2 < this.var_byte_a; ++i2) {
            this.e(graphics, n2 + -7, n3 + 40 + i2 * 14, i2);
        }
    }

    public void e(Graphics graphics, int n2, int n3, int n4) {
        int n5;
        byte[] byArray = this.var_s_a.k;
        if (n4 == 0) {
            n5 = 0;
        } else {
            int n6 = 0;
            n5 = byArray.length;
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                if (byArray[i2] != 59 || ++n6 != n4) continue;
                n5 = i2 + 1;
                break;
            }
        }
        int n7 = 0;
        int n8 = bk.a(byArray, 0, 130, 0);
        while (n8 < n5) {
            n8 = bk.a(byArray, 0, 130, ++n7);
        }
        n3 = n3 - n4 * 14 + n7 * 14;
        graphics.setClip(n2, n3, 7, 7);
        graphics.drawImage(as.t, n2 - (this.i[n4] > -1 ? 7 : 0), n3, 20);
    }

    public void void_b(int n2, int n3) {
        if (this.b == 2) {
            this.a(n2 + 12 + this.h * 50, n3 + 97, 46, 16);
        }
    }
}

