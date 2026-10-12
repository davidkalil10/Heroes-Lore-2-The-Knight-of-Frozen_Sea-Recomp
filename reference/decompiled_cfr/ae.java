/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class ae
implements ax {
    public static ae var_ae_a;
    private static byte var_byte_b;
    private static byte var_byte_c;
    private static int var_int_a;
    private boolean var_boolean_c = false;
    private static byte var_byte_d;
    private static int var_int_b;
    private static byte[][] var_byte_arr_arr_b;
    private static int var_int_c;
    private static int var_int_d;
    public static byte var_byte_a;
    public static boolean var_boolean_a;
    public static boolean var_boolean_b;
    private static boolean var_boolean_d;
    private static boolean var_boolean_e;
    private static boolean var_boolean_f;
    public static byte[] var_byte_arr_i;
    private static int var_int_e;
    private static int var_int_f;
    private static int var_int_g;
    private static int var_int_h;
    public static Image var_javax_microedition_lcdui_Image_a;
    private static byte var_byte_e;
    private static boolean var_boolean_g;
    private static byte var_byte_f;
    private static byte var_byte_g;
    private static byte var_byte_h;
    private static byte[] j;
    private static byte var_byte_i;
    private static String var_java_lang_String_a;
    private static String var_java_lang_String_b;
    private static boolean var_boolean_h;

    private void e() {
        var_byte_b = 0;
        var_byte_arr_arr_b = null;
        var_byte_e = 0;
        var_int_b = 0;
        var_int_a = 0;
        var_int_c = 0;
        var_boolean_b = false;
        var_boolean_a = false;
        this.var_boolean_c = false;
        ae.n();
        var_boolean_g = true;
        u.b((byte)0, (byte)0);
    }

    private final void f() {
        this.e();
        this.b(false);
        u.var_int_a = 4;
    }

    private void b(boolean bl2) {
        var_byte_arr_arr_b = (byte[][])ah.var_java_lang_Object_arr_b[var_byte_c];
        if (bl2) {
            var_int_b = var_int_c;
        }
        var_int_c = var_int_a;
    }

    private void c(boolean bl2) {
        var_byte_arr_arr_b = (byte[][])ah.var_java_lang_Object_arr_c[var_byte_d];
        if (bl2) {
            var_int_a = var_int_c;
        }
        var_int_c = var_int_b;
    }

    private final void g() {
        this.e();
        bd.var_boolean_a = true;
    }

    public final void a(Graphics graphics) {
        if (var_byte_b == 0) {
            return;
        }
        u.a(false, false);
        if (var_byte_b != 3 && var_boolean_a) {
            var_byte_a = (byte)(var_byte_a + 1);
            byte[] byArray = ("Processing" + "...".substring(0, var_byte_a % 4)).getBytes();
            int n2 = bd.hlzTextWidth("Processing...".getBytes()) + 16;
            int n3 = bw.i - n2 / 2;
            int n4 = bw.j - 10;
            graphics.setClip(0, 0, bw.g, bw.h);
            graphics.setColor(0);
            graphics.fillRect(n3, n4, n2, 20);
            graphics.setColor(14663551);
            graphics.drawRect(n3, n4, n2, 20);
            bk.a(graphics, n3 + 9, n4 + 6, byArray, 0);
            if (var_byte_a > 100) {
                var_byte_a = 0;
            }
            return;
        }
        if (var_byte_e == 0) {
            u.var_ah_a.e();
        } else {
            bd.var_bd_a.c();
            if (var_byte_e == 1) {
                graphics.setColor(0);
            } else if (var_byte_e == 2) {
                graphics.setColor(0xFFFFFF);
            }
            graphics.fillRect(0, 0, bd.var_int_a, bd.var_int_b);
        }
        if (this.var_boolean_c) {
            this.c(graphics);
        } else {
            bd.var_bd_a.d();
        }
        switch (var_byte_b) {
            case 2: {
                ae.a(graphics, var_byte_arr_arr_b[var_int_c][2]);
                break;
            }
            case 3: {
                ae.b(graphics);
                break;
            }
            case 4: {
                ae.b(graphics, (bw.g >> 1) - 60, (bw.h >> 1) - 25);
            }
        }
        int n5 = bw.g - 30;
        int n6 = bw.h - 7 - (bw.h > 250 ? 27 : 0);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_l, n5, n6, 20);
    }

    private static final void c(byte by2) {
        var_int_d = 0;
        var_byte_b = by2;
    }

    public final void void_a(byte by2) {
        this.a((byte)0, by2);
    }

    public final boolean a(b b2) {
        if (b2.var_boolean_c || b2.var_boolean_d) {
            return false;
        }
        byte by2 = u.var_ah_a.var_byte_arr_arr_c[((bl)b2).i][((bl)b2).h];
        if (by2 == 0) {
            return false;
        }
        return this.a((byte)0, by2);
    }

    public final boolean boolean_a() {
        b b2 = u.var_b_a;
        if (b2.var_boolean_c || b2.var_boolean_d) {
            return false;
        }
        byte by2 = u.var_ah_a.var_byte_arr_arr_c[((bl)b2).i][((bl)b2).h];
        if ((by2 = (byte)Math.abs(by2)) >= 1 && by2 <= 127 && this.a((byte)1, by2)) {
            return true;
        }
        by2 = u.var_ah_a.var_byte_arr_arr_c[((bl)b2).i + ax.var_byte_arr_b[b2.var_byte_t]][((bl)b2).h + ax.var_byte_arr_a[b2.var_byte_t]];
        return (by2 = (byte)Math.abs(by2)) >= 1 && by2 <= 127 && this.a((byte)2, by2);
    }

    public final boolean boolean_b() {
        b b2 = u.var_b_a;
        if (b2.var_boolean_c || b2.var_boolean_d) {
            return false;
        }
        byte by2 = 0;
        by2 = u.var_ah_a.var_byte_arr_arr_c[((bl)b2).i + ax.var_byte_arr_b[b2.var_byte_t]][((bl)b2).h + ax.var_byte_arr_a[b2.var_byte_t]];
        if ((by2 = (byte)Math.abs(by2)) < 1 || by2 > 127) {
            return false;
        }
        return this.a((byte)3, by2);
    }

    private final boolean a(byte by2, byte by3) {
        if (by3 < 1) {
            return false;
        }
        byte[][] byArray = (byte[][])ah.var_java_lang_Object_arr_a[by3 - 1];
        byte[] byArray2 = null;
        for (int i2 = 0; !(i2 >= byArray.length || (byArray2 = byArray[i2])[2] == by2 && ae.a(byArray2)); ++i2) {
            byArray2 = null;
        }
        if (byArray2 == null || var_byte_c < 0) {
            return false;
        }
        this.f();
        return true;
    }

    private static final boolean a(byte[] byArray) {
        int n2;
        int n3;
        b b2 = u.var_b_a;
        int n4 = 0;
        if (b2.var_byte_a < byArray[n4 + 1]) {
            return false;
        }
        byte by2 = byArray[n4];
        if (byArray[n4 + 1] > 0 && by2 != u.var_byte_a) {
            return false;
        }
        n4 += 2;
        ++n4;
        boolean bl2 = false;
        for (n3 = 0; n3 < 3; ++n3) {
            boolean bl3 = bl2 = byArray[n4] != 0;
            if (bl2 && !ae.b(byArray[n4], byArray[n4 + 1])) {
                return false;
            }
            n4 += 2;
        }
        for (n3 = 0; n3 < 3; ++n3) {
            boolean bl4 = bl2 = byArray[n4] != 0;
            if (bl2 && !ae.a((int)byArray[n4], byArray[n4 + 1])) {
                return false;
            }
            n4 += 2;
        }
        n3 = 0;
        for (n2 = 0; n2 < 2; ++n2) {
            n3 = byArray[n4];
            if (n3 > 0 && !u.var_ci_a.b(byArray[n4 + 2], byArray[n4 + 1], byArray[n4])) {
                return false;
            }
            n4 += 3;
        }
        for (n2 = 0; n2 < 2; ++n2) {
            n3 = byArray[n4];
            if (n3 > 0 && !u.a(byArray[n4 + 1], n3)) {
                return false;
            }
            n4 += 2;
        }
        n2 = f.int_b(byArray, ++n4);
        n4 += 4;
        if (u.var_int_f < n2) {
            return false;
        }
        var_byte_c = byArray[n4++];
        return true;
    }

    private static boolean a(int n2, byte by2) {
        boolean bl2 = u.var_u_a.boolean_a(n2 & 0xFF);
        if (by2 == 1) {
            return bl2;
        }
        return !bl2;
    }

    private static boolean b(byte by2, byte by3) {
        return u.byte_a((int)by2) == by3;
    }

    public static final boolean boolean_a(byte by2) {
        byte[][] byArray = (byte[][])ah.var_java_lang_Object_arr_a[by2 - 1];
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            if (!ae.a(byArray[i2])) continue;
            return true;
        }
        return false;
    }

    private static final void h() {
        if (var_byte_arr_arr_b[var_int_c + 1][0] != 58) {
            return;
        }
        bw.k = 0;
        bw.l = 3;
        byte[] byArray = var_byte_arr_arr_b[var_int_c];
        byte by2 = (byte)(byArray[2] + 1);
        byArray[2] = by2;
        u.b(var_byte_arr_arr_b[var_int_c][1], var_byte_arr_arr_b[var_int_c + 1][1], var_byte_arr_arr_b[var_int_c + 1][2], by2);
    }

    private static final void i() {
        u.var_b_a.u();
        u.var_u_a.a((int)((short)(var_byte_arr_arr_b[var_int_c][1] * 16)), (int)((short)(var_byte_arr_arr_b[var_int_c][2] * 16)), -1);
        ++var_int_c;
    }

    public static final void a(Graphics graphics, byte by2) {
        Graphics graphics2;
        int n2 = bw.g;
        int n3 = 37;
        int n4 = bw.i - (n2 >> 1);
        int n5 = bw.h - n3 - (bw.h > 250 ? 29 : 2);
        graphics.setClip(0, 0, bw.g, bw.h);
        if (var_javax_microedition_lcdui_Image_a == null) {
            var_javax_microedition_lcdui_Image_a = Image.createImage((int)n2, (int)n3);
            graphics2 = var_javax_microedition_lcdui_Image_a.getGraphics();
            ae.a(graphics2, n2, n3);
        } else {
            graphics2 = var_javax_microedition_lcdui_Image_a.getGraphics();
        }
        graphics2.setColor(0xFFFFFF);
        bk.a(graphics2, 12, 7, n2 - 20, 1, var_byte_arr_i, var_int_e, var_int_h, var_int_g);
        var_int_h = var_int_g;
        graphics.drawImage(var_javax_microedition_lcdui_Image_a, n4, n5, 20);
        if (by2 > 0) {
            graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_c[by2 - 1], n4 + n2, n5, 40);
        } else if (by2 < 0) {
            graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_c[-by2 - 1], n4, n5, 36);
        }
    }

    public static void a(Graphics graphics, int n2, int n3) {
        graphics.setColor(0);
        graphics.fillRect(3, 3, n2 - 6, n3 - 6);
        graphics.setColor(0x3F3F3F);
        graphics.drawRect(0, 0, n2 - 1, n3 - 1);
        graphics.drawRect(2, 2, n2 - 5, n3 - 5);
        graphics.setColor(10452799);
        graphics.drawRect(1, 1, n2 - 3, n3 - 3);
        graphics.setClip(2, 2, 7, 7);
        graphics.drawImage(as.var_as_a.var_javax_microedition_lcdui_Image_arr_n[0], 2, 2, 20);
        graphics.setClip(n2 - 9, 2, 7, 7);
        graphics.drawImage(as.var_as_a.var_javax_microedition_lcdui_Image_arr_n[4], n2 - 62, 2, 20);
        graphics.setClip(0, 0, n2, n3);
    }

    public static final void b(Graphics graphics) {
        g.int_a(graphics, 54 + var_int_f * 6, 6970180);
        graphics.setColor(0xFFFFFF);
        int n2 = bw.j - 15;
        if (var_int_f > 0) {
            bk.a(graphics, bw.i - 81, n2 - var_int_f * 7, 176, 1, var_byte_arr_i);
        } else {
            bk.a(graphics, bw.i + 5, n2, var_byte_arr_i, 1, 1);
        }
        ba.a(graphics, n2 + 20 + var_int_f * 3, var_boolean_d);
    }

    public static final void b(Graphics graphics, int n2, int n3) {
        g.int_a(graphics, 45, 0);
        bk.a(graphics, n2 + 17, n3 + 11, var_java_lang_String_a.getBytes(), 1);
        if (var_java_lang_String_b != null) {
            bk.a(graphics, n2 + 17, n3 + 27, var_java_lang_String_b.getBytes(), 1);
        }
    }

    public final void void_a() {
        if (var_int_g < var_int_f) {
            if (var_boolean_f || cj.var_byte_a > 2) {
                var_int_g = var_int_f;
            } else if ((var_int_g = bk.a(var_byte_arr_i, var_int_e, var_int_g)) > var_int_f) {
                var_int_g = var_int_f;
            }
        } else if (var_int_e + var_int_f >= var_byte_arr_i.length && var_boolean_f) {
            var_byte_arr_i = null;
            var_javax_microedition_lcdui_Image_a = null;
            ++var_int_c;
            bd.var_boolean_a = true;
            ae.c((byte)0);
        } else if (var_boolean_f) {
            var_javax_microedition_lcdui_Image_a = null;
            var_int_e += var_int_f;
            var_int_f = bk.a(var_byte_arr_i, var_int_e, bw.g - (bw.g > 176 ? 84 : 28), 2);
            var_int_g = 0;
            var_int_h = 0;
        }
        var_boolean_f = false;
    }

    private final void j() {
        if (var_boolean_e) {
            var_int_c = var_boolean_d ? ++var_int_c : (var_int_c += var_byte_arr_arr_b[var_int_c][2]);
            ae.c((byte)0);
        }
    }

    private void k() {
        if (var_int_d > 0) {
            if (--var_int_d == 0) {
                ++var_int_c;
            } else {
                return;
            }
        }
        while (var_int_c < var_byte_arr_arr_b.length && var_byte_b == 1) {
            if (var_byte_arr_arr_b[var_int_c][0] == 48) {
                var_int_d = var_byte_arr_arr_b[var_int_c][1];
                break;
            }
            this.m();
        }
    }

    public static final void a(int n2, int n3) {
        if (n3 == 35) {
            var_boolean_a = true;
        }
        switch (var_byte_b) {
            case 2: {
                if (n2 != 8 && n3 != 53) break;
                var_boolean_f = true;
                break;
            }
            case 3: {
                var_boolean_a = false;
                if (n2 == 2 || n2 == 5 || n3 == 52 || n3 == 54) {
                    var_boolean_d = !var_boolean_d;
                    break;
                }
                if (n2 != 8 && n3 != 53) break;
                var_boolean_e = true;
                break;
            }
            case 4: {
                var_boolean_a = false;
                if (n2 != 8 && n3 != 53) break;
                var_boolean_h = true;
            }
        }
    }

    public final void void_b() {
        if (var_byte_b != 3 && var_boolean_a) {
            var_boolean_f = true;
        }
        if (var_byte_b == 0) {
            byte by2 = var_byte_arr_arr_b[var_int_c][0];
            switch (by2) {
                case 19: {
                    this.var_boolean_c = true;
                    var_int_b = 0;
                    var_byte_d = var_byte_arr_arr_b[var_int_c][1];
                    ++var_int_c;
                    this.c(true);
                }
                case 3: 
                case 8: 
                case 9: 
                case 10: 
                case 18: 
                case 48: 
                case 51: 
                case 52: {
                    ae.c((byte)1);
                    break;
                }
                case 53: {
                    u.var_u_a.c(var_byte_arr_arr_b[var_int_c][1], var_byte_arr_arr_b[var_int_c][2]);
                    ++var_int_c;
                    break;
                }
                case 57: {
                    ae.h();
                    this.g();
                    return;
                }
                case 58: {
                    ae.i();
                    break;
                }
                case 28: {
                    u.a((byte)4, (byte)0);
                    this.g();
                    break;
                }
                case 29: {
                    u.a((byte)4, (byte)1);
                    this.g();
                    break;
                }
                case 31: {
                    u.a((byte)4, (byte)2);
                    this.g();
                    break;
                }
                case 30: {
                    u.a((byte)4, (byte)3);
                    this.g();
                    break;
                }
                case 45: {
                    if (this.var_boolean_c) {
                        this.var_boolean_c = false;
                        this.b(false);
                        break;
                    }
                    this.g();
                    u.h(3);
                    break;
                }
                default: {
                    this.m();
                }
            }
        }
        switch (var_byte_b) {
            case 1: {
                this.k();
                break;
            }
            case 2: {
                this.void_a();
                break;
            }
            case 3: {
                this.j();
                break;
            }
            case 5: {
                this.o();
                break;
            }
            case 4: {
                this.p();
            }
        }
        u.d();
        u.var_ah_a.b();
        if (ah.var_boolean_a) {
            u.var_ah_a.c();
        }
    }

    private void l() {
        if (var_boolean_a) {
            ++var_int_c;
        } else {
            var_byte_arr_i = (byte[])ah.var_java_lang_Object_arr_d[var_byte_arr_arr_b[var_int_c][1]];
            var_int_e = 0;
            var_int_f = bk.a(var_byte_arr_i, var_int_e, bw.g - 28, 2);
            var_int_g = 0;
            var_int_h = 0;
            ae.c((byte)2);
        }
    }

    private void m() {
        b b2 = u.var_b_a;
        switch (var_byte_arr_arr_b[var_int_c][0]) {
            case 0: {
                this.b(var_byte_arr_arr_b[var_int_c][1]);
                break;
            }
            case 5: {
                u.var_ah_a.b(var_byte_arr_arr_b[var_int_c][2], var_byte_arr_arr_b[var_int_c][1]);
                break;
            }
            case 6: {
                u.var_ah_a.b((byte)0, var_byte_arr_arr_b[var_int_c][1]);
                break;
            }
            case 7: {
                u.var_ah_a.c(var_byte_arr_arr_b[var_int_c][1], var_byte_arr_arr_b[var_int_c][2]);
                break;
            }
            case 10: {
                bj bj2 = u.var_ah_a.var_bj_arr_a[var_byte_arr_arr_b[var_int_c][1]];
                if (var_byte_arr_arr_b[var_int_c][2] == 0) {
                    bj2.var_boolean_a = true;
                    bj2.a(bj2.var_short_c, bj2.var_short_d);
                    break;
                }
                bj2.var_boolean_a = false;
                bj2.u();
                break;
            }
            case 13: {
                byte by2 = var_byte_arr_arr_b[var_int_c][1];
                byte by3 = var_byte_arr_arr_b[var_int_c][2];
                if (var_byte_arr_arr_b[var_int_c + 1][0] == 14) {
                    u.var_ah_a.a(by2, by3, var_byte_arr_arr_b[var_int_c + 1][1]);
                } else if (var_byte_arr_arr_b[var_int_c + 1][0] == 50) {
                    u.var_ah_a.b(by2, by3, var_byte_arr_arr_b[var_int_c + 1][1]);
                }
                ++var_int_c;
                break;
            }
            case 11: {
                u.var_ah_a.void_a(var_byte_arr_arr_b[var_int_c][1], var_byte_arr_arr_b[var_int_c][2]);
                break;
            }
            case 12: {
                u.var_ah_a.var_cc_arr_a[var_byte_arr_arr_b[var_int_c][1]].a(var_byte_arr_arr_b[var_int_c][2] == 0);
                break;
            }
            case 17: {
                var_boolean_b = true;
                byte by4 = var_byte_arr_arr_b[var_int_c][1];
                switch (var_byte_arr_arr_b[var_int_c][2]) {
                    case 0: {
                        u.d((int)by4);
                        break;
                    }
                    case 1: {
                        u.var_u_a.e(by4);
                        break;
                    }
                    case 2: {
                        u.var_u_a.f(by4);
                    }
                }
                break;
            }
            case 18: {
                var_boolean_b = true;
                int n2 = var_byte_arr_arr_b[var_int_c][1] & 0xFF;
                if (var_byte_arr_arr_b[var_int_c][2] == 1) {
                    u.var_u_a.c(n2);
                    break;
                }
                u.var_u_a.b(n2);
                break;
            }
            case 9: {
                this.a(var_byte_arr_arr_b[var_int_c][1], (byte)(var_byte_arr_arr_b[var_int_c][2] + 1), (byte)2);
                break;
            }
            case 8: {
                this.a(var_byte_arr_arr_b[var_int_c][1], (byte)(var_byte_arr_arr_b[var_int_c][2] + 1), (byte)0);
                break;
            }
            case 52: {
                this.a(var_byte_arr_arr_b[var_int_c][1], (byte)0, (byte)1);
                break;
            }
            case 1: {
                b2.u();
                b2.a((short)(var_byte_arr_arr_b[var_int_c][1] * 16), (short)(var_byte_arr_arr_b[var_int_c][2] * 16));
                b2.t();
                break;
            }
            case 2: {
                b2.void_g((byte)(var_byte_arr_arr_b[var_int_c][1] + 1));
                break;
            }
            case 3: {
                b2.void_g((byte)(var_byte_arr_arr_b[var_int_c][1] + 1));
                b2.void_f((byte)2);
                break;
            }
            case 4: {
                if (var_byte_arr_arr_b[var_int_c][1] == 0) {
                    b2.var_boolean_g = true;
                    break;
                }
                b2.var_boolean_g = false;
                break;
            }
            case 51: {
                b2.void_f((byte)1);
                break;
            }
            case 15: {
                if (var_boolean_b) {
                    var_boolean_a = false;
                }
                this.l();
                return;
            }
            case 16: {
                var_boolean_e = false;
                var_boolean_d = true;
                var_boolean_a = false;
                var_byte_arr_i = (byte[])ah.var_java_lang_Object_arr_d[var_byte_arr_arr_b[var_int_c][1]];
                var_int_f = var_byte_arr_i.length > 26 ? 1 : 0;
                ae.c((byte)3);
                return;
            }
            case 49: {
                ae.q();
                break;
            }
            case 23: {
                u.var_b_a.b(this.short_a());
                break;
            }
            case 24: {
                u.g(this.short_a());
                break;
            }
            case 25: {
                int n3 = this.short_a() * u.var_byte_arr_i[u.var_byte_i];
                u.var_b_a.c(n3);
                break;
            }
            case 34: {
                j = new byte[6];
                for (int n4 = 0; n4 < 6; n4 = (int)((byte)(n4 + 1))) {
                    ae.j[n4] = (byte)f.a(-5, 5);
                }
                ae.c((byte)5);
                return;
            }
            case 35: {
                var_byte_e = 1;
                break;
            }
            case 36: {
                var_byte_e = 0;
                break;
            }
            case 37: {
                var_byte_i = (byte)5;
                ae.c((byte)5);
                return;
            }
            case 46: {
                this.g();
                u.a((byte)10, (byte)12, (byte)1);
                break;
            }
            case 38: {
                var_boolean_g = var_byte_arr_arr_b[var_int_c][1] == 0;
                this.a(var_boolean_g);
                break;
            }
            case 40: {
                ae.n();
                this.b(var_byte_arr_arr_b[var_int_c][1], var_byte_arr_arr_b[var_int_c][2]);
                break;
            }
            case 26: {
                b2.void_e(var_byte_arr_arr_b[var_int_c][1]);
                break;
            }
            case 20: {
                byte by5 = var_byte_arr_arr_b[var_int_c][1];
                if (ak.var_java_lang_Object_arr_a[by5] == null) {
                    ak.b(by5);
                }
                if (by5 == 0) {
                    if (!cj.var_boolean_c) break;
                    ak.a((byte)0, false);
                    break;
                }
                ak.j = (byte[])ak.var_java_lang_Object_arr_a[by5];
                break;
            }
            case 21: {
                byte by6 = var_byte_arr_arr_b[var_int_c][1];
                if (!cj.var_boolean_c) break;
                ak.a(by6, false);
                break;
            }
            default: {
                if (this.var_boolean_c) {
                    this.var_boolean_c = false;
                    this.b(true);
                }
                ae.c((byte)0);
                return;
            }
        }
        ++var_int_c;
    }

    public short short_a() {
        short s2 = 0;
        s2 = (short)(var_byte_arr_arr_b[var_int_c][2] & 0xFF);
        s2 = (short)(s2 | (var_byte_arr_arr_b[var_int_c][1] & 0xFF) << 8);
        return s2;
    }

    public void b(int n2, int n3) {
        u.var_int_b = -(n2 * 16) + bw.i;
        u.var_int_c = -(n3 * 16) + bw.j;
    }

    public void a(boolean bl2) {
        var_boolean_g = bl2;
        this.void_c();
        u.var_int_d = u.var_int_b;
        u.var_int_e = u.var_int_c;
    }

    private void a(byte by2, byte by3, byte by4) {
        bj bj2 = u.var_ah_a.var_bj_arr_a[by2];
        bj2.u();
        if (by3 > 0) {
            bj2.void_g(by3);
        }
        if (by4 != 0) {
            bj2.c = by4;
        }
    }

    public void b(byte by2) {
        b b2 = u.var_b_a;
        b2.s();
        if (by2 > 0) {
            b2.b(new bh(-6, by2));
        }
    }

    private static void n() {
        var_boolean_g = false;
        var_byte_f = (byte)-1;
        var_byte_g = 0;
        var_byte_h = 0;
    }

    private static final void a(String string, String string2) {
        var_java_lang_String_a = string;
        var_java_lang_String_b = string2;
        var_boolean_h = false;
        ae.c((byte)4);
    }

    public void void_c() {
        if (var_boolean_g) {
            u.f();
        } else if (var_byte_f == -1 && var_byte_g != 0) {
            u.var_int_b -= var_byte_h * ax.var_byte_arr_a[var_byte_g];
            u.var_int_c -= var_byte_h * ax.var_byte_arr_b[var_byte_g];
        }
    }

    private final void o() {
        switch (var_byte_arr_arr_b[var_int_c][0]) {
            case 34: {
                if (j != null && j.length > 0) {
                    u.var_ah_a.var_int_b = j[0];
                    u.var_ah_a.var_int_c = j[1];
                    byte[] byArray = new byte[j.length - 2];
                    System.arraycopy(j, 2, byArray, 0, byArray.length);
                    j = byArray;
                    break;
                }
                ae.c((byte)0);
                ++var_int_c;
                break;
            }
            case 37: {
                if (var_byte_i > 0) {
                    var_byte_e = var_byte_i % 2 == 1 ? (byte)2 : (byte)0;
                    var_byte_i = (byte)(var_byte_i - 1);
                    break;
                }
                ae.c((byte)0);
                ++var_int_c;
                var_byte_e = 0;
            }
        }
    }

    private final void p() {
        if (var_boolean_h) {
            var_java_lang_String_a = null;
            var_java_lang_String_b = null;
            this.g();
            u.h(3);
        }
    }

    private static final void q() {
        ci ci2;
        byte by2 = var_byte_arr_arr_b[var_int_c][1];
        byte by3 = var_byte_arr_arr_b[var_int_c][2];
        if (var_byte_arr_arr_b[++var_int_c][0] != 22) {
            System.out.println("[ERROR:EventScript] No CMD_HANDLE_ITEM_NUM after CMD_HANDLE_ITEM.");
            return;
        }
        byte by4 = var_byte_arr_arr_b[var_int_c][1];
        ci ci3 = ci2 = ci.boolean_a(by2) ? u.var_ci_b : u.var_ci_a;
        if (by4 > 0) {
            cp cp2 = cp.a(by2, by3, true, true);
            if (ci2.a(cp2, by4) < 1) {
                var_boolean_a = false;
                ae.a("Item storage space", "is insufficient.");
            }
        } else if (by4 < 0) {
            by4 = -by4;
            if (ci2.int_a(by2, by3) >= by4) {
                ci2.void_a(by2, by3, by4);
            } else {
                var_boolean_a = false;
                ae.a("Items are insufficient.", null);
            }
        }
    }

    public void c(Graphics graphics) {
        int n2 = bd.var_int_b > 150 ? 32 : 16;
        int n3 = bd.var_int_b > 150 ? n2 : 26;
        graphics.setClip(0, 0, bw.g, bw.h);
        graphics.setColor(0);
        graphics.fillRect(0, 0, bw.g, n2);
        graphics.fillRect(0, bw.h - n3, bw.g, n3);
    }

    public static void d() {
        if (var_byte_arr_i == null) {
            var_int_c = 0;
        }
        if (var_int_c < bd.var_bd_a.var_e_a.a()) {
            var_byte_arr_i = bd.var_bd_a.var_e_a.a(var_int_c);
            ++var_int_c;
            var_int_f = var_byte_arr_i.length > 26 ? 1 : 0;
        }
    }

    public static boolean boolean_c() {
        var_javax_microedition_lcdui_Image_a = null;
        if (var_byte_arr_i == null || var_int_e + var_int_f >= var_byte_arr_i.length) {
            ae.d();
            var_int_e = 0;
            var_int_g = var_int_f = bk.a(var_byte_arr_i, var_int_e, bw.g - 28 - (bw.g > 200 ? 36 : 0), 2);
            var_int_h = 0;
            return true;
        }
        var_int_e += var_int_f;
        var_int_g = var_int_f = bk.a(var_byte_arr_i, var_int_e, bw.g - 28 - (bw.g > 200 ? 36 : 0), 2);
        var_int_h = 0;
        return false;
    }

    static {
        var_ae_a = new ae();
        var_byte_b = 0;
        var_byte_c = 0;
        var_int_a = 0;
        var_byte_d = 0;
        var_int_b = 0;
        var_int_c = 0;
        var_int_d = 0;
        var_byte_a = 0;
        var_boolean_a = false;
        var_boolean_b = false;
        var_boolean_d = true;
        var_boolean_e = false;
        var_boolean_f = false;
        var_byte_arr_i = null;
        var_int_e = 0;
        var_int_f = 0;
        var_int_g = 0;
        var_int_h = 0;
        var_javax_microedition_lcdui_Image_a = null;
        var_byte_e = 0;
        var_boolean_g = true;
        var_byte_f = (byte)-1;
        var_byte_g = 0;
        var_byte_h = 0;
    }
}

