/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class cl
extends r {
    public cl(g g2) {
        super(g2, (byte)3);
        this.a();
    }

    public void a() {
        if (r.var_e_a == null) {
            r.var_e_a = new e("/t/nt");
        }
        if (ck.var_e_a == null) {
            ck.var_e_a = new e("/t/gm");
        }
        u.var_byte_arr_k = af.byte_arr_a();
        this.g = cj.var_byte_b;
        cj.var_byte_b = 0;
        ak.b();
        try {
            u.var_u_a.a(false);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.void_b();
        r.var_byte_d = (byte)-1;
        cj.var_cj_a.h();
        this.b((byte)1);
    }

    public final void void_b() {
        r.var_long_a = System.currentTimeMillis();
    }

    public boolean boolean_a(int n2, int n3) {
        this.void_b();
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (r.var_byte_c == 11) {
            if (n3 == 53 || n2 == 8 || n3 == 8) {
                this.b(0);
                this.d();
            }
            return true;
        }
        if (this.boolean_a(n3)) {
            return true;
        }
        if (n3 == 8) {
            this.b(0);
            this.d();
            return true;
        }
        if (n3 == 53 || n2 == 8) {
            switch (this.h) {
                case 0: {
                    this.a((byte)17, 5);
                    break;
                }
                case 1: {
                    this.a((byte)10, 5);
                    break;
                }
                case 2: {
                    ((g)this).b = u.var_ci_c.int_a() < 1 ? new bx((g)this, r.var_e_a.a(10)) : new at((g)this, true);
                }
            }
        } else {
            this.boolean_c(n2, n3);
        }
        return true;
    }

    public void a(byte by2, byte by3) {
        this.b((int)by3);
        if (by2 == 2) {
            if (by3 == 0) {
                this.b((byte)1);
            } else {
                this.d();
            }
        } else if (by2 == 12) {
            if (by3 == 0) {
                this.b((byte)3);
            } else {
                this.d();
            }
        }
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        this.a(graphics);
        this.a(graphics, 60, 61, n2, n3, false);
    }
}

