/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class av
extends g {
    public boolean var_boolean_a;
    public byte var_byte_a;
    public byte[] i;
    public byte[] j;

    public av(g g2, byte by2, boolean bl2) {
        super(g2, (byte)0);
        this.var_boolean_a = bl2;
        this.var_byte_a = by2;
        if (bl2) {
            cg cg2 = u.var_b_a.var_cg_a;
            this.var_byte_a = cg2.j[by2];
            this.i = ck.var_e_b.a(cg2.j[by2] * 2);
            this.j = ck.var_e_b.a(cg2.j[by2] * 2 + 1);
        } else {
            this.var_byte_a = (byte)(this.var_byte_a - b.var_byte_arr_i[u.var_byte_a]);
            this.i = ck.var_ck_a.c.a(this.var_byte_a * 2);
            this.j = ck.var_ck_a.c.a(this.var_byte_a * 2 + 1);
        }
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8 || n2 == 8 || n3 == 53) {
            this.var_g_a.b(0);
        }
        return true;
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.void_a(graphics, n2, n3);
        if (this.var_boolean_a) {
            bd.var_bd_a.c(this.var_byte_a, n2 + -27, n3 + 16);
        } else {
            bd.var_bd_a.b(this.var_byte_a, n2 + -27, n3 + 16);
        }
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n2 + -7, n3 + 19, 145, 1, this.i);
        bk.a(graphics, n2 + -7, n3 + 52, 145, 1, this.j);
    }
}

