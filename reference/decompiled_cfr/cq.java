/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class cq
extends g {
    public static cq var_cq_a;
    public e var_e_a = null;
    public static int var_int_a;
    public static int var_int_b;
    public am var_am_a;
    public byte var_byte_a;
    public byte var_byte_b;
    public byte var_byte_c;
    public int var_int_c;
    public boolean var_boolean_a;

    public cq() {
        super(null, (byte)3);
        this.f = true;
        this.var_boolean_a = false;
    }

    public static cq cq_a() {
        if (var_cq_a == null) {
            var_cq_a = new cq();
            var_int_a = bw.i - 60;
            var_int_b = bw.j - 58;
        }
        return var_cq_a;
    }

    public void void_a() {
        this.var_e_a = new e("/t/bsm");
        bd.var_bd_a.b();
        ((g)this).b = new bx((g)this, this.var_e_a.a(0));
    }

    private void c() {
        var_cq_a = null;
        u.h(3);
        bd.var_boolean_a = true;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (this.var_boolean_a) {
            return true;
        }
        if (n3 == 8) {
            this.c();
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            if (this.h == 0) {
                byte[] byArray = this.byte_arr_a(true);
                ((g)this).b = byArray == null ? new bx((g)this, this.var_e_a.a(13)) : new d((g)this, 3, byArray, this.var_e_a.a(5));
            } else if (this.h == 1) {
                if (this.var_am_a == null) {
                    ((g)this).b = new bx((g)this, this.var_e_a.a(5));
                    this.h = 0;
                } else if (this.var_am_a.d >= this.var_am_a.m) {
                    ((g)this).b = new bx((g)this, this.var_e_a.a(14));
                } else if (this.var_byte_c > u.var_ci_a.int_a((byte)20, (byte)0)) {
                    ((g)this).b = new bx((g)this, this.var_e_a.a(10));
                } else if (this.var_int_c > u.var_int_f) {
                    ((g)this).b = new bx((g)this, this.var_e_a.a(11));
                } else {
                    this.var_boolean_a = true;
                    ((g)this).b = new bx((g)this, this.var_e_a.a(8));
                }
            } else if (this.h == 2) {
                this.c();
            }
            return true;
        }
        if (n2 == 1 || n3 == 50) {
            if (this.h > 0) {
                this.h = 0;
            }
        } else if (n2 == 6 || n3 == 56) {
            if (this.h == 0) {
                this.h = 1;
            }
        } else if (n2 == 2 || n3 == 52 || n2 == 5 || n3 == 54) {
            this.h = this.h == 1 ? (byte)2 : (byte)1;
        }
        return true;
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        if (by2 == 3) {
            this.var_byte_a = by3;
            this.var_am_a = (am)u.var_ci_a.cp_a((int)by3);
            this.e();
        }
    }

    public void b() {
        this.void_c(var_int_a, var_int_b);
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        this.d();
        g.a(graphics, n2, n3, true, false);
        graphics.setColor(0);
        graphics.fillRect(n2 + -36, n3, 192, 14);
        graphics.fillRect(n2 + -18, n3 + 31, 14, 14);
        graphics.fillRect(n2 + -1, n3 + 31, 140, 14);
        graphics.setColor(0x7F7F7F);
        bk.a(graphics, bw.i, n3 + 2, this.var_e_a.a(1), 1, 1);
        int n4 = n3 + 58;
        if (this.var_am_a == null) {
            graphics.setColor(0x7F7F7F);
            graphics.fillRect(n2 + -18 + 1, n3 + 31 + 1, 12, 12);
            graphics.fillRect(n2 + -1 + 1, n3 + 31 + 1, 138, 12);
        } else {
            am am2 = this.var_am_a;
            bd.a(n2 + -18 + 1, n3 + 31 + 1, am2.g);
            graphics.setColor(0xFFFFFF);
            bk.a(graphics, n2 + -1 + 5, n3 + 31 + 2, am2.j, 1);
            int n5 = n3 + 31 + 2 + 10 + 2;
            String string = new String("/" + am2.m);
            graphics.setColor(15128512);
            bk.a(graphics, n2 + -1 + 2, n5 + 1, ("" + this.var_byte_b + string).getBytes(), 0);
            if (this.var_byte_b < am2.m) {
                this.c(graphics, n2 + -1 + 2 + 37 - 4, n5 + 6);
                graphics.setColor(65280);
                bk.a(graphics, n2 + -1 + 2 + 85, n5 + 1, ("" + (this.var_byte_b + 1) + string).getBytes(), 0);
                bk.a(graphics, n2 + -1 + 2 + 85, n4 + 1, ("" + this.var_byte_c + " ").getBytes(), 0);
                bk.a(graphics, n2 + -1 + 2 + 85, n4 + 10 + 5, ("" + this.var_int_c).getBytes(), 0);
            }
        }
        graphics.setColor(15128512);
        bk.a(graphics, bw.i + -53, n3 + 18, this.var_e_a.a(2), 1);
        bd.a(n2 + -18 + 1, n4, (byte)20);
        bk.a(graphics, n2 + -1 + 2, n4 + 1, this.var_e_a.a(3), 1);
        bk.a(graphics, n2 + -1 + 2, n4 + 15, this.var_e_a.a(4), 1);
        this.a(graphics, this.var_e_a.a(6), n2 + 10, n3 + 88, this.h != 1 ? 0x7F7F7F : 0xFFFFFF);
        this.a(graphics, this.var_e_a.a(7), n2 + 62, n3 + 88, this.h != 2 ? 0x7F7F7F : 0xFFFFFF);
        this.c(graphics, n2 + 110, n3 + 110, u.var_int_f);
    }

    public void void_b(int n2, int n3) {
        int n4 = n2 + 10 - 1;
        int n5 = n3 + 31;
        if (this.h == 0) {
            this.a(n2 + -18, n3 + 31, 14, 14);
            this.a(n2 + -1, n3 + 31, 140, 14);
        } else {
            this.a(this.h == 2 ? n2 + 62 : n4, n5 += 56, 46, 16);
        }
    }

    private void d() {
        if (!this.var_boolean_a) {
            return;
        }
        boolean bl2 = false;
        byte by2 = this.var_byte_a;
        if (100 * (this.var_am_a.m - this.var_am_a.d) / this.var_am_a.m + 30 < f.a(1, 100)) {
            for (byte by3 = by2; by3 > 0; by3 = (byte)(by3 - 1)) {
                if (u.var_ci_a.cp_a((int)by3) != this.var_am_a) continue;
                u.var_ci_a.a(by3, 1);
                break;
            }
            this.var_am_a = null;
        } else {
            this.var_am_a.d = (byte)(this.var_am_a.d + 1);
            this.var_am_a.e = cp.a(this.var_am_a);
            bl2 = true;
        }
        u.var_int_f -= this.var_int_c;
        u.var_ci_a.void_a((byte)20, (byte)0, this.var_byte_c);
        if (bl2) {
            this.e();
        } else {
            try {
                u.var_u_a.l();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        ((g)this).b = new bx((g)this, this.var_e_a.a(bl2 ? 9 : 12));
        this.var_boolean_a = false;
    }

    private void e() {
        if (this.var_am_a != null) {
            this.var_byte_b = this.var_am_a.d;
            this.var_byte_c = (byte)(this.var_byte_b + 1);
            this.var_int_c = (this.var_byte_b + 1) * 100;
        }
    }

    private void c(Graphics graphics, int n2, int n3) {
        for (int i2 = 0; i2 < 3; ++i2) {
            graphics.drawLine(n2 - i2, n3 - i2, n2 - i2, n3 + i2);
        }
    }

    static {
        var_cq_a = null;
    }
}

