/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public class cm
extends g {
    public final byte var_byte_a = (byte)19;
    public final int var_int_a;
    public final int b;
    public static e var_e_a;
    public static cm var_cm_a;
    public static int c;
    public static int d;

    public static final cm cm_a() {
        if (var_cm_a == null) {
            var_cm_a = new cm();
            c = bw.g - 120 >> 1;
            d = bw.h - 117 >> 1;
        }
        return var_cm_a;
    }

    public void void_a() {
        var_e_a = new e("/t/bm");
        ck.var_e_a = new e("/t/gm");
        ck.var_e_b = new e("/t/bsk");
        ck.var_byte_a = (byte)4;
        bd.var_bd_a.b();
    }

    public void b() {
        var_cm_a = null;
        var_e_a = null;
        ck.var_e_a = null;
        ck.var_e_b = null;
        u.h(3);
        cj.var_cj_a.f();
        bd.var_boolean_a = true;
    }

    public cm() {
        super(null, (byte)4);
        this.var_int_a = 72;
        this.b = 17;
        this.f = true;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.b();
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            if (this.h < u.var_java_util_Vector_a.size()) {
                if (this.h == u.var_b_a.var_byte_r) {
                    this.a((byte)3, 2, var_e_a.a(1, 2));
                } else {
                    this.a((byte)3, 4, var_e_a.a(1, 2, 3, 4));
                }
            } else {
                ((g)this).b = new br(this);
            }
            return true;
        }
        if (this.boolean_c(n2, n3)) {
            bd.var_bd_a.b();
        }
        return true;
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        if (by2 == 3) {
            switch (by3) {
                case 0: {
                    ((g)this).b = new bm(this, (cg)u.var_java_util_Vector_a.elementAt(this.h), false);
                    break;
                }
                case 1: {
                    int n2 = ((cg)u.var_java_util_Vector_a.elementAt(this.h)).int_a();
                    if (n2 < 2) {
                        ((g)this).b = new z((g)this, (cg)u.var_java_util_Vector_a.elementAt(this.h));
                        break;
                    }
                    ((g)this).b = new bx((g)this, var_e_a.a(9));
                    break;
                }
                case 2: {
                    this.a((byte)2, 2, new byte[][]{var_e_a.a(6)});
                    break;
                }
                case 3: {
                    this.a((byte)10, 2, new byte[][]{ck.var_e_a.a(47)});
                }
            }
        } else if (by2 == 10 && by3 == 0) {
            u.var_java_util_Vector_a.removeElementAt(this.h);
            u.var_b_a.void_e();
        } else if (by2 == 2 && by3 == 0) {
            u.var_b_a.void_a(this.h);
            u.var_b_a.void_f();
            u.var_u_a.h();
            ((g)this).b = new bx((g)this, var_e_a.a(10));
        }
    }

    public void c() {
        this.void_c(c, d);
    }

    public void void_a(int n2, int n3) {
        int n4;
        int n5;
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, true, false);
        int n6 = n2 + 19;
        int n7 = n3 + 29;
        graphics.setColor(0);
        for (n5 = 0; n5 < 4; ++n5) {
            graphics.fillRect(n6, n7 + n5 * 17, 14, 14);
            graphics.fillRect(n6 + 17, n7 + n5 * 17, 72, 14);
        }
        graphics.setColor(0x7F7F7F);
        bk.a(graphics, bw.i, n3 + 2, var_e_a.a(0), 1, 1);
        n5 = n6 + 17 + 36;
        for (n4 = 0; n4 < u.var_java_util_Vector_a.size(); ++n4) {
            bd.a(n6 + 1, n7 + 1 + n4 * 17, (byte)23);
            bk.a(graphics, n5, n7 + 2 + n4 * 17, ((cg)u.var_java_util_Vector_a.elementAt((int)n4)).i, 1, 1);
        }
        for (n4 = u.var_java_util_Vector_a.size(); n4 < 4; ++n4) {
            bk.a(graphics, n5, n7 + 2 + n4 * 17, var_e_a.a(12), 1, 1);
        }
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n2 + -11, n7 + 2 + u.var_b_a.var_byte_r * 17, var_e_a.a(11), 1);
    }

    public void void_b(int n2, int n3) {
        this.a(n2 + 19, n3 + 29 + this.h * 17, 13, 13);
        this.a(n2 + 19 + 17, n3 + 29 + this.h * 17, 71, 13);
    }
}

