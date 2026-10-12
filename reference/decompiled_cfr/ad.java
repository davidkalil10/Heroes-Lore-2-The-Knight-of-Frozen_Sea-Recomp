/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class ad
extends g {
    private byte a = 0;

    public ad(g g2) {
        super(g2, (byte)4);
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (this.a != 0) {
            return true;
        }
        if (n3 == 8) {
            if (this.b != null) {
                this.b(this.h);
            } else {
                this.var_g_a.h = (byte)7;
                this.var_g_a.b(0);
            }
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            return this.a();
        }
        return this.boolean_c(n2, n3);
    }

    public boolean a() {
        switch (this.h) {
            case 0: {
                if (u.var_ah_a.var_byte_b >= ah.var_byte_a) {
                    this.b = new bx((g)this, ck.var_e_a.a(70));
                    break;
                }
                this.a((byte)2, 2, new byte[][]{ck.var_e_a.a(21)});
                break;
            }
            case 1: {
                this.b = new ai((g)this, true);
                break;
            }
            case 2: {
                this.b = new l((g)this, true);
                break;
            }
            case 3: {
                u.a((byte)7, (byte)1);
                ak.d();
                break;
            }
            default: {
                return false;
            }
        }
        this.e = true;
        return true;
    }

    public void a(byte by2, byte by3) {
        this.b(by3);
        if (by2 == 2 && by3 == 0 && this.h == 0) {
            this.a = (byte)2;
            this.b = new bx((g)this, ck.var_e_a.a(39));
        }
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        this.a(graphics, 12, 0, n2, n3, true);
        if (this.a == 2) {
            this.a = 1;
            this.g();
        } else if (this.a == 1) {
            this.a = 0;
            try {
                u.var_u_a.l();
                this.b(this.h);
                this.b = new bx((g)this, ck.var_e_a.a(40));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }
}

