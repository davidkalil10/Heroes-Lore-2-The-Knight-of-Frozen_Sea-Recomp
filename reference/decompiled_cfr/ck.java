/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class ck
extends g {
    public static int var_int_a;
    public static int var_int_b;
    public static e var_e_a;
    public static e var_e_b;
    public e c;
    public static ck var_ck_a;
    public static boolean var_boolean_a;
    public static byte var_byte_a;

    public static final ck ck_a() {
        if (var_ck_a == null) {
            var_ck_a = new ck();
            var_int_a = bw.g - 120 >> 1;
            var_int_b = bw.h - 117 >> 1;
        }
        return var_ck_a;
    }

    public void void_a() {
        if (var_e_a == null) {
            var_e_a = new e("/t/gm");
        }
        if (this.c == null) {
            this.c = new e("/t/sk" + u.var_byte_a);
        }
        if (var_e_b == null) {
            var_e_b = new e("/t/bsk");
        }
        this.void_b();
        cj.var_cj_a.h();
    }

    public void void_b() {
        var_boolean_a = u.var_b_a.var_short_b > 0;
    }

    public boolean boolean_a() {
        return var_boolean_a;
    }

    public void void_a(boolean bl2) {
        this.h = 0;
        var_e_a = null;
        this.c = null;
        var_e_b = null;
        if (((g)this).b != null) {
            ((g)this).b = null;
        }
        var_ck_a = null;
        System.gc();
        cj.var_cj_a.f();
        bd.var_boolean_a = true;
    }

    public ck() {
        super(null, (byte)8);
    }

    public final void c() {
        this.void_c(var_int_a, var_int_b);
    }

    public void void_a(int n2, int n3) {
        int n4;
        if (((g)this).b != null) {
            return;
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        graphics.setClip(n2, n3, 120, 117);
        graphics.setColor(6970180);
        graphics.fillRect(n2, n3, 120, 117);
        graphics.setColor(10193521);
        graphics.drawLine(n2 + 1, n3, n2 + 1, n3 + 117);
        graphics.drawLine(n2 + 120 - 2, n3, n2 + 120 - 2, n3 + 117);
        graphics.setColor(4009755);
        graphics.fillRect(n2, n3 + 8, 120, 2);
        graphics.fillRect(n2, n3 + 117 - 8 - 2, 120, 2);
        graphics.drawLine(n2, n3, n2, n3 + 117);
        graphics.drawLine(n2 + 120 - 1, n3, n2 + 120 - 1, n3 + 117);
        graphics.setColor(0);
        graphics.fillRect(n2, n3, 120, 8);
        graphics.fillRect(n2, n3 + 117 - 8, 120, 8);
        g.a(graphics, (byte)2, n2 + 4, n3 + 13);
        g.a(graphics, (byte)2, n2 + 120 - 4 - 7, n3 + 13);
        g.a(graphics, (byte)2, n2 + 4, n3 + 117 - 7 - 13);
        g.a(graphics, (byte)2, n2 + 120 - 4 - 7, n3 + 117 - 7 - 13);
        graphics.setClip(n2, n3, 120, 117);
        int n5 = bw.i - 40;
        int n6 = bw.j - 48;
        for (n4 = 0; n4 < 8; ++n4) {
            graphics.fillRect(n5, n6, 80, 11);
            n6 += 12;
        }
        graphics.setColor(0x7F7F7F);
        n6 = bw.j - 48;
        for (n4 = 0; n4 < 8; ++n4) {
            if (n4 != this.h) {
                bk.a(graphics, bw.i, n6, var_e_a.a(5 + n4), 0, 1);
            }
            n6 += 12;
        }
        graphics.setColor(0xFFFFFF);
        n6 = bw.j - 48 + 12 * this.h;
        bk.a(graphics, bw.i, n6, var_e_a.a(13 + this.h), 0, 1);
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            u.a((byte)7, (byte)0);
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            return this.boolean_b();
        }
        return this.boolean_c(n2, n3);
    }

    public boolean boolean_b() {
        var_byte_a = this.h;
        switch (this.h) {
            case 0: {
                ((g)this).b = new bp(this);
                break;
            }
            case 1: {
                ((g)this).b = new bf(this, u.var_ci_a, true);
                break;
            }
            case 2: {
                ((g)this).b = new co(this);
                break;
            }
            case 3: {
                ((g)this).b = new m(this);
                break;
            }
            case 4: {
                ((g)this).b = new bm(this, u.var_b_a.var_cg_a, true);
                break;
            }
            case 5: {
                ((g)this).b = new y(this);
                break;
            }
            case 6: {
                ((g)this).b = new at((g)this, false);
                break;
            }
            case 7: {
                ((g)this).b = new ad(this);
                break;
            }
            default: {
                return false;
            }
        }
        bd.var_bd_a.b();
        return true;
    }
}

