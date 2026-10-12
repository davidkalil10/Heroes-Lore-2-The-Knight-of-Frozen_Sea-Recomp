/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class at
extends r {
    private final byte var_byte_a = (byte)17;
    private final byte b = (byte)20;
    private final byte m = (byte)15;
    public ci var_ci_a = null;
    public boolean var_boolean_a;

    public at(g g2, boolean bl2) {
        super(g2, (byte)15);
        this.k = (byte)3;
        this.j = (byte)5;
        if (bl2) {
            ck.var_byte_a = (byte)6;
        }
        this.l = 0;
        ((g)this).f = true;
        this.var_ci_a = u.var_ci_c;
        this.var_boolean_a = bl2;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.var_g_a.b(5);
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            if (this.var_ci_a.cp_a((int)this.h) != null) {
                if (this.var_boolean_a) {
                    this.a((byte)3, 2, r.var_e_a.a(16, 15));
                } else {
                    this.a((byte)10, 2, new byte[][]{ck.var_e_a.a(47)});
                }
            }
            return true;
        }
        if (this.boolean_d(n2, n3)) {
            return true;
        }
        return this.e(n2, n3);
    }

    public void a(byte by2, byte by3) {
        this.b((int)by3);
        if (by2 == 10 && by3 == 0 || by2 == 3 && by3 == 0) {
            this.var_ci_a.void_b(this.h);
        } else if (this.var_boolean_a && by2 == 3 && by3 == 1) {
            r.e = (byte)(-this.h - 1);
            this.a((byte)19, 5);
        }
    }

    public void void_a(int n2, int n3) {
        cp cp2;
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, false, true);
        int n4 = 0;
        int n5 = 0;
        graphics.setColor(0);
        graphics.fillRect(n2 - 30, n3 + 68, 180, 44);
        for (int i2 = 0; i2 < 3; ++i2) {
            for (int i3 = 0; i3 < 5; ++i3) {
                cp2 = this.var_ci_a.cp_a(i2 * 5 + i3);
                n4 = n2 + 20 + i3 * 17;
                n5 = n3 + 15 + i2 * 17;
                graphics.fillRect(n4, n5, 14, 14);
                if (cp2 == null) continue;
                bd.a(n4 + 1, n5 + 1, cp2.g);
                if (cp2.c <= 1) continue;
                f.a(graphics, cp2.c, n4 + 14 - 1, n5 + 14 - 7, 8, 0);
                graphics.setClip(n2, n3, 120, 117);
            }
        }
        cp2 = this.var_ci_a.cp_a((int)this.h);
        if (cp2 != null) {
            graphics.setClip(0, 0, bw.g, bw.h);
            graphics.setColor(15128512);
            bk.a(graphics, n2 - 24, n3 + 68 + 3, cp2.j, 1);
            graphics.setColor(0xFFFFFF);
            bk.a(graphics, n2 - 24, n3 + 68 + 17, 174, 1, cp2.k);
            bd.var_bd_a.c();
        } else {
            this.a(graphics, n2 - 24, n3 + 68 + 3, 0x7F7F7F);
        }
    }

    public void void_b(int n2, int n3) {
        int n4 = this.h / 5;
        int n5 = this.h % 5;
        int n6 = n2 + 20 + n5 * 17 - 1;
        int n7 = n3 + 15 + n4 * 17 - 1;
        this.a(n6, n7, 15, 15);
    }
}

