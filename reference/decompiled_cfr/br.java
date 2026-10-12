/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class br
extends g {
    public int var_int_a = 85;
    public int b = (bw.h - this.var_int_a >> 1) + this.var_int_a - 22;
    public boolean var_boolean_a = false;

    public br(g g2) {
        super(g2, (byte)2);
        this.f = true;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (this.var_boolean_a) {
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            if (this.h == 0) {
                if (u.var_int_f < 10000) {
                    ((g)this).b = new bx((g)this, cm.var_e_a.a(15));
                } else {
                    this.var_boolean_a = true;
                    u.var_int_f -= 10000;
                    u.var_java_util_Vector_a.addElement(new cg(false));
                    this.var_g_a.b(0);
                }
            } else {
                this.var_g_a.b(0);
            }
        } else if (n3 == 8) {
            this.var_g_a.b(0);
        } else if (this.boolean_d(n2, n3)) {
            this.e = true;
        }
        return true;
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.int_a(graphics, this.var_int_a, 0);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, bw.i, this.b - 20, cm.var_e_a.a(8), 1, 1);
        int n4 = bw.i - 33;
        int n5 = this.b - 53;
        bd.a(n4, n5, (byte)23);
        bk.a(graphics, n4 + 20, n5, cm.var_e_a.a(13), 1);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_d, n4 + 44, n5 + 2, 20);
        f.a(graphics, 1, n4 + 64, n5 + 2, 8, 0);
        bk.a(graphics, n4 + 4, n5 + 18, cm.var_e_a.a(14), 1);
        this.c(graphics, n4 + 62, n5 + 20, 10000);
        this.a(graphics, as.var_e_a.a(14), bw.i - 48, this.b, this.h != 0 ? 0x7F7F7F : 0xFFFFFF);
        this.a(graphics, as.var_e_a.a(15), bw.i + 2, this.b, this.h != 1 ? 0x7F7F7F : 0xFFFFFF);
    }

    public void void_b(int n2, int n3) {
        this.a(bw.i - 48 + 50 * this.h, this.b, 46, 16);
    }
}

