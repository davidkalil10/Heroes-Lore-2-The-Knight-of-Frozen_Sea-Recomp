/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class bd
extends bw
implements Runnable,
ax {
    private static final int[] var_int_arr_a;
    public static bd var_bd_a;
    public static int var_int_a;
    public static int var_int_b;
    public static int var_int_c;
    public static int var_int_d;
    public static boolean var_boolean_a;
    public static boolean var_boolean_b;
    public static boolean var_boolean_c;
    public boolean var_boolean_d;
    public boolean var_boolean_e;
    private boolean g;
    private byte var_byte_b;
    public int var_int_e;
    private ag var_ag_a;
    private Image var_javax_microedition_lcdui_Image_a;
    private Image var_javax_microedition_lcdui_Image_b;
    private int n;
    private boolean h;
    public e var_e_a;
    public int f;
    private by var_by_a;
    private int o;
    private int p;
    private boolean i;
    public static boolean q;
    public static int r;

    public static bd bd_a() {
        if (var_bd_a == null) {
            var_bd_a = new bd();
        }
        return var_bd_a;
    }

    public bd() {
        var_int_a = bw.g;
        var_int_b = bw.h - 26;
        var_int_c = var_int_a - 16 >> 1;
        var_int_d = var_int_b >> 1;
        this.var_int_e = 0;
    }

    public void run() {
        if (u.var_int_a == 1) {
            this.a(this.var_byte_a);
        }
    }

    public void void_a() {
        if (u.var_int_a == 2) {
            ak.a();
        }
        q = true;
        var_boolean_a = true;
        this.g = true;
        bw.l = 3;
    }

    public void keyPressed(int n2) {
        if (n2 == -7) {
            n2 = 8;
        }
        this.origKeyPressed0(n2);
    }

    public void keyReleased(int n2) {
        if (u.var_int_a != 3) {
            return;
        }
        if (((bw)this).f) {
            this.m = n2;
            return;
        }
        if (u.var_b_a.var_byte_s == 2) {
            u.void_b();
        }
    }

    private void a(int n2, int n3) {
        switch (n2) {
            case 1: {
                u.b((byte)1);
                return;
            }
            case 6: {
                u.b((byte)2);
                return;
            }
            case 2: {
                u.b((byte)3);
                return;
            }
            case 5: {
                u.b((byte)4);
                return;
            }
            case 8: {
                this.i();
                return;
            }
        }
        switch (n3) {
            case 50: {
                u.b((byte)1);
                return;
            }
            case 56: {
                u.b((byte)2);
                return;
            }
            case 52: {
                u.b((byte)3);
                return;
            }
            case 54: {
                u.b((byte)4);
                return;
            }
            case 53: {
                this.i();
                return;
            }
            case 49: {
                this.a(0);
                return;
            }
            case 51: {
                this.a(1);
                return;
            }
            case 55: {
                this.a(2);
                return;
            }
            case 57: {
                this.a(3);
                return;
            }
            case 48: {
                if (u.var_b_a.var_byte_s == 7 || u.var_b_a.var_byte_s == 6) {
                    return;
                }
                u.var_b_a.r();
                var_boolean_a = true;
                return;
            }
            case 35: {
                if (u.var_b_a.var_byte_s == 7 || u.var_b_a.var_byte_s == 6) {
                    return;
                }
                u.var_ci_a.void_b();
                var_boolean_c = true;
                return;
            }
            case 42: {
                if (u.var_b_a.var_byte_s == 1 && u.var_ah_a.var_byte_c < 7) {
                    u.a((byte)3, (byte)11, (byte)3);
                }
                return;
            }
            case 8: {
                if (u.var_b_a.var_byte_s == 1) {
                    u.void_a((byte)6);
                }
                return;
            }
        }
    }

    private void i() {
        if (u.var_b_a.var_byte_s == 7 || u.var_b_a.var_byte_s == 6) {
            return;
        }
        if (u.boolean_a()) {
            return;
        }
        if (ae.var_ae_a.boolean_a()) {
            return;
        }
        u.c((byte)0);
    }

    private void a(int n2) {
        boolean bl2;
        byte by2 = u.var_byte_arr_j[n2];
        if (by2 < 0) {
            return;
        }
        if (u.var_int_arr_a[n2] > 0) {
            return;
        }
        boolean bl3 = bl2 = by2 / 10 > 0;
        if (bl2) {
            u.var_b_a.void_c((byte)(by2 % 10));
        } else {
            u.c(by2);
        }
    }

    public void paint(Graphics graphics) {
        if (q) {
            graphics.setColor(0);
            graphics.fillRect(0, 0, bw.g, bw.h);
            if (++r / 400 % 2 == 0) {
                graphics.setColor(0xFFFFFF);
                bk.a(graphics, bw.i, bw.j, as.var_e_a.a(39), 0, 1);
            }
            return;
        }
        bw.var_javax_microedition_lcdui_Graphics_a = graphics;
        u.var_u_a.g();
        switch (u.var_int_a) {
            case 1: {
                this.a(bw.var_javax_microedition_lcdui_Graphics_a, bw.j, true);
                break;
            }
            case 3: {
                if (cj.d) {
                    u.f();
                    u.void_c();
                } else {
                    u.void_c();
                    u.f();
                }
                if (cj.d) {
                    u.a(true, true);
                }
                u.var_ah_a.e();
                this.d();
                break;
            }
            case 4: {
                ae.var_ae_a.void_b();
                ae.var_ae_a.void_c();
                ae.var_ae_a.a(bw.var_javax_microedition_lcdui_Graphics_a);
                break;
            }
            case 5: {
                this.a(ck.ck_a());
                ck.ck_a().c();
                break;
            }
            case 6: {
                this.a(cq.cq_a());
                cq.cq_a().b();
                break;
            }
            case 7: {
                this.a(o.o_a());
                o.o_a().b();
                break;
            }
            case 8: {
                this.a(bv.bv_a());
                bv.bv_a().c();
                break;
            }
            case 9: {
                this.a(cm.cm_a());
                cm.cm_a().c();
                break;
            }
            case 2: {
                if (this.g) {
                    bg.var_bg_a.h();
                    this.g = false;
                }
                bg.var_bg_a.b();
                break;
            }
            case 10: {
                this.j();
                break;
            }
            case 11: {
                this.a((g)null);
                u.var_ah_a.h();
                break;
            }
            case 12: {
                this.k();
                break;
            }
            case 13: {
                this.l();
                break;
            }
            case 14: {
                this.o();
            }
        }
        cj.var_cj_a.void_a();
    }

    public static void a(byte by2, byte by3, byte by4, int n2, int n3) {
        bd.a(as.var_byte_arr_j, as.var_int_arr_a[by2], (byte)8, (byte)0, as.var_java_lang_Object_arr_a, true, by3, by4, n2, n3);
    }

    public static void void_a(byte by2, byte by3, byte by4, byte by5, int n2, int n3) {
        bd.a((byte[])as.var_java_lang_Object_arr_arr_b[by2][by3], 0, (byte)6, by2, as.var_java_lang_Object_arr_c, true, by4, by5, n2, n3);
    }

    public static byte byte_a(byte by2, byte by3, byte by4, byte by5, int n2, int n3) {
        return bd.a((byte[])as.var_java_lang_Object_arr_arr_a[by2][by3], 0, (byte)4, by2, as.var_java_lang_Object_arr_b, true, by4, by5, n2, n3);
    }

    public static boolean a(boolean bl2, byte by2, int n2, int n3) {
        if (by2 < 0) {
            return true;
        }
        byte[] byArray = as.var_byte_arr_l;
        int n4 = 0;
        if (!bl2) {
            int n5 = byArray[n4++];
            byte by3 = 0;
            for (int i2 = 0; i2 < n5; ++i2) {
                for (int i3 = 0; i3 < 4; ++i3) {
                    by3 = byArray[n4++];
                    n4 += 4 * by3;
                }
            }
        }
        if (by2 >= byArray[n4]) {
            return false;
        }
        bd.a(as.var_byte_arr_l, n4, (byte)33, (byte)0, as.var_javax_microedition_lcdui_Image_arr_f, false, by2, (byte)1, n2, n3);
        return true;
    }

    public static void a(byte by2, int n2, int n3) {
        bd.a(as.var_byte_arr_k, 0, (byte)4, (byte)0, as.var_javax_microedition_lcdui_Image_arr_e, false, by2, (byte)1, n2, n3);
    }

    public static byte a(int n2, byte n3, int n4, int n5, int n6) {
        if (n2 < 0) {
            return 0;
        }
        byte[] byArray = as.var_byte_arr_arr_c[n2];
        int n7 = 0;
        int n8 = 0;
        byte by2 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            n8 = byArray[n7++];
            for (int i3 = 0; i3 < n8; ++i3) {
                by2 = byArray[n7++];
                n7 += by2 * 4;
                n7 += 3;
            }
        }
        return bd.a(byArray, n7, (byte)33, (byte)0, as.var_javax_microedition_lcdui_Image_arr_f, false, (byte)n4, (byte)1, n5, n6);
    }

    public static byte a(byte[] byArray, int n2, byte by2, byte by3, Object[] objectArray, boolean bl2, byte n3, byte by4, int n4, int n5) {
        int n6;
        if (byArray == null) {
            return 0;
        }
        int n7 = n2;
        if (n3 >= byArray[n7]) {
            return byArray[n7];
        }
        ++n7;
        int n8 = 0;
        for (n6 = 0; n6 < n3; ++n6) {
            for (int i2 = 0; i2 < 4; ++i2) {
                n8 = byArray[n7++];
                n7 += n8 * 4;
            }
        }
        for (n6 = 0; n6 < by4 - 1; ++n6) {
            n8 = byArray[n7++];
            n7 += n8 * 4;
        }
        n8 = byArray[n7++];
        n6 = 0;
        Image[] imageArray = null;
        for (int i3 = 0; i3 < n8; ++i3) {
            n6 = byArray[n7] & 0x7F;
            n6 += byArray[n7] >> 7 == 0 ? (byte)0 : by2;
            n6 += by3 * by2 * 2;
            if (bl2) {
                imageArray = (Image[])objectArray[n6];
                n6 = byArray[n7 + 1];
            } else {
                imageArray = (Image[])objectArray;
                n6 += byArray[n7 + 1];
            }
            if (n6 != -1 && imageArray != null && imageArray[n6] != null) {
                bw.var_javax_microedition_lcdui_Graphics_a.drawImage(imageArray[n6], n4 + byArray[n7 + 2], n5 + byArray[n7 + 3], 20);
            }
            n7 += 4;
            imageArray = null;
        }
        return byArray[n2];
    }

    public final void a(byte by2, boolean bl2) {
        this.a(bl2);
        this.var_byte_a = by2;
        u.var_int_a = 1;
        new Thread(var_bd_a).start();
        cj.var_cj_a.g();
    }

    public final void b() {
        this.g = true;
        var_boolean_a = true;
    }

    private void a(g g2) {
        if (this.g) {
            u.var_ah_a.e();
            this.d();
            if (g2 != null) {
                g2.h();
            }
            this.g = false;
        }
    }

    public final void b(byte by2, int n2, int n3) {
        bw.var_javax_microedition_lcdui_Graphics_a.setClip(n2, n3, 12, 12);
        bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.var_as_a.u, n2 - 12 * by2, n3, 20);
        this.c();
    }

    public final void c(byte by2, int n2, int n3) {
        bw.var_javax_microedition_lcdui_Graphics_a.setClip(n2, n3, 12, 12);
        bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.var_as_a.var_javax_microedition_lcdui_Image_arr_i[by2], n2, n3, 20);
        this.c();
    }

    public final void c() {
        bw.var_javax_microedition_lcdui_Graphics_a.setClip(0, 0, var_int_a, var_int_b);
    }

    public static final void a(int n2, int n3, byte n4) {
        bw.var_javax_microedition_lcdui_Graphics_a.setClip(n2, n3, 12, 12);
        int n5 = n4 < 8 ? n4 : n4 - 1;
        bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.q, n2, n3 - n5 * 12, 20);
        bw.var_javax_microedition_lcdui_Graphics_a.setClip(0, 0, bw.g, bw.h);
    }

    public void d() {
        int n2;
        int n3;
        int n4 = bw.g - 120 >> 1;
        int n5 = bw.h - 26;
        b b2 = u.var_b_a;
        if (b2.var_short_a > 0 || b2.var_short_b > 0) {
            this.var_byte_b = (byte)(this.var_byte_b + 1);
            if (this.var_byte_b < 5) {
                bw.var_javax_microedition_lcdui_Graphics_a.setClip(0, 0, bw.g, bw.h);
                n3 = 0;
                if (b2.var_short_a > 0) {
                    bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.var_javax_microedition_lcdui_Image_arr_g[0], n4 + 2, n5 - 2, 36);
                    n3 = 1;
                }
                if (b2.var_short_b > 0) {
                    bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.var_javax_microedition_lcdui_Image_arr_g[1], n4 + 2 + 12 * n3, n5 - 2, 36);
                }
            }
            if (this.var_byte_b >= 8) {
                this.var_byte_b = 0;
            }
        }
        if (this.var_int_e > 0 && this.var_ag_a != null && this.var_ag_a.var_byte_s != 7) {
            n3 = bw.g - this.var_javax_microedition_lcdui_Image_a.getWidth();
            n2 = 0;
            bw.var_javax_microedition_lcdui_Graphics_a.drawImage(this.var_javax_microedition_lcdui_Image_a, n3, n2, 20);
            bw.var_javax_microedition_lcdui_Graphics_a.setColor(0xFF3F2F);
            bw.var_javax_microedition_lcdui_Graphics_a.fillRect(n3 + 27 + 2, n2 + 18 + 2, 28 * (this.var_ag_a.var_short_b - 1) / this.var_ag_a.var_short_a - 1, 2);
            --this.var_int_e;
        } else {
            this.e();
        }
        if (this.h) {
            this.h = false;
        } else if (this.n > 0) {
            n3 = bw.i;
            n2 = n5 - 16;
            bw.var_javax_microedition_lcdui_Graphics_a.setClip(0, 0, bw.g, bw.h);
            bw.var_javax_microedition_lcdui_Graphics_a.drawImage(this.var_javax_microedition_lcdui_Image_b, n3, n2, 17);
            --this.n;
        } else {
            this.var_javax_microedition_lcdui_Image_b = null;
        }
        if (var_boolean_a) {
            this.b(n4, n5);
        }
        if (var_boolean_a || this.var_boolean_d) {
            n3 = b2.var_int_a * 41 / b2.var_int_d;
            bw.var_javax_microedition_lcdui_Graphics_a.setClip(n4 + 17, n5 + 2, n3, 3);
            bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.var_as_a.var_javax_microedition_lcdui_Image_arr_n[0], n4, n5, 20);
            this.a(n3, n4 + 17, n5 + 2);
            this.var_boolean_d = false;
        }
        if (var_boolean_a || this.var_boolean_e) {
            n3 = b2.var_int_b * 41 / b2.var_int_e;
            bw.var_javax_microedition_lcdui_Graphics_a.setClip(n4 + 62, n5 + 2, n3, 3);
            bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.var_as_a.var_javax_microedition_lcdui_Image_arr_n[4], n4 + 60, n5, 20);
            this.a(n3, n4 + 62, n5 + 2);
            this.var_boolean_e = false;
        }
        if (var_boolean_a || var_boolean_c) {
            if (u.var_ci_a.var_byte_a < 0) {
                u.var_ci_a.void_b();
            }
            if (u.var_ci_a.var_byte_a > -1) {
                cp cp2 = u.var_ci_a.cp_a();
                if (cp2 != null) {
                    bd.a(n4 + 96, n5 + 9, cp2.g);
                    if (cp2.c > 1) {
                        f.a(bw.var_javax_microedition_lcdui_Graphics_a, cp2.c, n4 + 108, n5 + 14, 8, 0);
                    }
                }
            } else {
                bw.var_javax_microedition_lcdui_Graphics_a.setClip(n4 + 97, n5 + 9, 12, 12);
                bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
                bw.var_javax_microedition_lcdui_Graphics_a.fillRect(n4 + 97, n5 + 9, 12, 12);
            }
            var_boolean_c = false;
        }
        if (var_boolean_a || var_boolean_b) {
            int n6 = b2.var_int_c * 116 / b2.var_int_f;
            if (n6 < 1) {
                n6 = 1;
            }
            int n7 = n5 + 26 - 2;
            bw.var_javax_microedition_lcdui_Graphics_a.setClip(n4 + 1, n5 + 26 - 2, 120, 2);
            bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
            bw.var_javax_microedition_lcdui_Graphics_a.fillRect(n4 + 1, n7, 118, 2);
            bw.var_javax_microedition_lcdui_Graphics_a.setColor(7258047);
            bw.var_javax_microedition_lcdui_Graphics_a.fillRect(n4 + 2, n5 + 26 - 1, n6, 1);
            var_boolean_b = false;
        }
        for (byte by2 = 0; by2 < 4; by2 = (byte)(by2 + 1)) {
            this.d(by2, n4 + 8 + 22 * by2, n5 + 9);
        }
        this.c();
        var_boolean_a = false;
    }

    public final void a(ag ag2, boolean bl2) {
        this.var_int_e = 24;
        if (bl2 && this.var_ag_a != null) {
            return;
        }
        if (this.var_ag_a == ag2) {
            return;
        }
        this.var_ag_a = ag2;
        bd bd2 = this;
        this.var_javax_microedition_lcdui_Image_a = Image.createImage((int)Math.min(Math.max(bd.hlzTextWidth(this.var_ag_a.var_ay_a.var_byte_arr_a) + 16, 66), bw.g - 20), (int)28);
        Graphics graphics = this.var_javax_microedition_lcdui_Image_a.getGraphics();
        int n2 = this.var_javax_microedition_lcdui_Image_a.getWidth();
        int n3 = this.var_javax_microedition_lcdui_Image_a.getHeight();
        graphics.setColor(0);
        graphics.fillRect(0, 0, n2, n3);
        graphics.setColor(0xFFFFFF);
        byte[] byArray = this.var_ag_a.var_ay_a.var_byte_arr_a;
        int n4 = bd.hlzTextWidth(byArray);
        bk.a(graphics, (n2 - n4) / 2 + 1, 5, byArray, 0, 4);
        graphics.setColor(var_int_arr_a[this.var_ag_a.var_ay_a.var_byte_f]);
        graphics.fillRect(59, 19, 3, 4);
        graphics.setColor(14467940);
        graphics.drawRect(1, 1, n2 - 3, n3 - 3);
        graphics.drawRect(27, 18, 29, 5);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_d, 4, 17, 20);
        f.a(graphics, this.var_ag_a.m, 25, 17, 8, 0);
    }

    public final void a(byte[] byArray, int n2, int n3) {
        if (this.n > 0) {
            this.h = true;
        }
        this.n = n2;
        int n4 = bd.hlzTextWidth(byArray);
        int n5 = Math.min(n4 + 16, bw.g - 20);
        int n6 = (n5 - n4) / 2 + 1;
        this.var_javax_microedition_lcdui_Image_b = Image.createImage((int)n5, (int)16);
        g.a(this.var_javax_microedition_lcdui_Image_b.getGraphics(), 0, n3, n5, 16, byArray, n6, 0, 0, 0xFFFFFF);
    }

    public void e() {
        this.var_ag_a = null;
        this.var_javax_microedition_lcdui_Image_a = null;
    }

    private void d(byte by2, int n2, int n3) {
        byte by3 = u.var_byte_arr_j[by2];
        if (by3 < 0) {
            return;
        }
        boolean bl2 = by3 / 10 > 0;
        int n4 = -1;
        short s2 = 1;
        by3 = bl2 ? (byte)(by3 % 10) : (byte)(by3 - 1);
        n4 = u.var_int_arr_a[by2];
        if (n4 < 0 && !var_boolean_a) {
            return;
        }
        if (bl2) {
            this.c(u.var_b_a.var_cg_a.j[by3], n2, n3);
            s2 = u.var_b_a.var_cg_a.var_short_arr_a[by3];
        } else {
            this.b(by3, n2, n3);
            s2 = u.var_b_a.short_a((int)by3);
        }
        if (n4 > 0) {
            bw.var_javax_microedition_lcdui_Graphics_a.setClip(n2 - 5, n3 + 2, 5, 7);
            bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
            bw.var_javax_microedition_lcdui_Graphics_a.fillRect(n2 - 5, n3 + 2, 5, 7);
            bw.var_javax_microedition_lcdui_Graphics_a.setClip(n2, n3, 12, 12 * n4 / s2);
            bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.z, n2, n3, 20);
        } else {
            f.a(bw.var_javax_microedition_lcdui_Graphics_a, 1 + (by2 >> 1) * 2 + by2 * 2, n2 - 5, n3 + 2, 4, 0);
        }
        this.c();
    }

    private void a(int n2, int n3, int n4) {
        if (n2 >= 41) {
            return;
        }
        int n5 = n3 + n2;
        int n6 = 41 - n2;
        if (n6 > 41) {
            n6 = 41;
        }
        bw.var_javax_microedition_lcdui_Graphics_a.setClip(n5, n4, n6, 3);
        bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
        bw.var_javax_microedition_lcdui_Graphics_a.fillRect(n5, n4, n6, 3);
        this.c();
    }

    private void b(int n2, int n3) {
        Image[] imageArray = as.var_as_a.var_javax_microedition_lcdui_Image_arr_n;
        bw.var_javax_microedition_lcdui_Graphics_a.setClip(0, 0, bw.g, bw.h);
        bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
        bw.var_javax_microedition_lcdui_Graphics_a.fillRect(0, n3, bw.g, 26);
        bw.var_javax_microedition_lcdui_Graphics_a.drawImage(imageArray[0], n2, n3, 20);
        bw.var_javax_microedition_lcdui_Graphics_a.drawImage(imageArray[4], n2 + 60, n3, 20);
        bw.var_javax_microedition_lcdui_Graphics_a.drawImage(imageArray[1], n2, n3 + 7, 20);
        bw.var_javax_microedition_lcdui_Graphics_a.drawImage(imageArray[1], 119, n3 + 7, 20);
        for (int i2 = 0; i2 < 4; ++i2) {
            bw.var_javax_microedition_lcdui_Graphics_a.drawImage(imageArray[2], n2 + 1 + 22 * i2, n3 + 7, 20);
        }
        bw.var_javax_microedition_lcdui_Graphics_a.drawImage(imageArray[3], n2 + 89, n3 + 7, 20);
        if (bw.g > 120) {
            bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.p, n2, n3, 24);
            bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.p, n2 + 120, n3, 20);
        }
    }

    private void a(byte by2) {
        switch (by2) {
            case 3: {
                as.var_as_a.n();
                u.var_u_a.a((int)u.var_byte_e, (int)u.var_byte_f, u.var_byte_g);
                u.var_ah_a.f();
                u.void_a((byte)2);
                break;
            }
            case 1: {
                as.var_as_a.p();
                ak.c();
                ak.b((byte)1);
                ak.i = (byte[])ak.var_java_lang_Object_arr_a[1];
                ak.a();
                u.var_u_a.e();
                break;
            }
            case 2: {
                bg.void_a();
                as.var_as_a.q();
                ak.c((byte)1);
                as.var_as_a.a();
                as.var_as_a.f();
                u.b(u.h, u.var_byte_e, u.var_byte_f, u.var_byte_g);
            }
        }
        this.var_byte_a = (byte)-1;
    }

    private void j() {
        bw.var_javax_microedition_lcdui_Graphics_a.setClip(0, 0, bw.g, bw.h);
        bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
        if (this.f < 5) {
            int n2 = bw.h / 5;
            int n3 = n2 / 5;
            for (int i2 = 0; i2 < 5; ++i2) {
                bw.var_javax_microedition_lcdui_Graphics_a.fillRect(0, n2 * i2, bw.g, n3 * this.f);
            }
        } else if (this.f < 43) {
            bw.var_javax_microedition_lcdui_Graphics_a.fillRect(0, 0, bw.g, bw.h);
            byte[] byArray = as.var_e_a.a(37);
            int n4 = bk.a(byArray);
            bw.var_javax_microedition_lcdui_Graphics_a.setColor(0x5F3F3F);
            bk.a(bw.var_javax_microedition_lcdui_Graphics_a, bw.i - n4 / 2 + 1, bw.j - 20 + 1, 200, 1, byArray, 0, 0, (this.f - 5) * 2);
            bw.var_javax_microedition_lcdui_Graphics_a.setColor(0xFF3F3F);
            bk.a(bw.var_javax_microedition_lcdui_Graphics_a, bw.i - n4 / 2, bw.j - 20, 200, 1, byArray, 0, 0, (this.f - 5) * 2);
            u.var_b_a.a(bw.i, bw.j + 20);
        } else {
            as.var_as_a.i();
            as.var_as_a.m();
            ak.c((byte)16);
            var_bd_a.a((byte)1, false);
        }
        ++this.f;
    }

    private void k() {
        byte by2 = 0;
        bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
        bw.var_javax_microedition_lcdui_Graphics_a.fillRect(0, 0, bw.g, bw.h);
        this.var_by_a.a(bw.var_javax_microedition_lcdui_Graphics_a, (byte)(this.var_int_e >= 0 ? 1 : 0), (byte)1, bw.i, 27 + (bw.h > 270 ? 29 : 0));
        this.var_int_e = this.var_int_e > -96 ? --this.var_int_e : 11;
        if (this.p != 100 && this.i || this.o == -1) {
            this.i = false;
            if (ae.boolean_c()) {
                ++this.o;
            }
        }
        if (this.o >= this.var_e_a.a() && this.p != 100) {
            this.f = -6;
            this.p = 100;
        }
        switch (ae.var_byte_arr_i[0]) {
            case 39: {
                by2 = -2;
                break;
            }
            case 124: {
                by2 = 1;
            }
        }
        ae.a(bw.var_javax_microedition_lcdui_Graphics_a, by2);
        if (this.p == 100) {
            if (this.f < 1) {
                int n2 = bw.h / 10;
                bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
                for (int i2 = 0; i2 < 7 + this.f; ++i2) {
                    bw.var_javax_microedition_lcdui_Graphics_a.fillRect(0, 0, bw.g, n2 * i2);
                    bw.var_javax_microedition_lcdui_Graphics_a.fillRect(0, bw.h - n2 * i2, bw.g, n2 * i2);
                }
                ++this.f;
            }
            if (this.f > 0) {
                this.var_e_a = null;
                as.var_javax_microedition_lcdui_Image_arr_c = null;
                this.m();
                u.a((byte)3, (byte)13, (byte)1);
            }
            return;
        }
    }

    public final void f() {
        this.var_int_e = 11;
        this.f = 0;
        this.o = -1;
        this.p = -1;
        this.var_e_a = new e("/t/ed");
        this.var_by_a = new by("/img/endspr", "/img/end");
    }

    private void l() {
        bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
        bw.var_javax_microedition_lcdui_Graphics_a.fillRect(0, 0, bw.g, bw.h);
        if (this.o >= 8) {
            this.n();
            return;
        }
        int n2 = this.o * 10;
        if (this.f < 3) {
            bw.var_javax_microedition_lcdui_Graphics_a.setColor(50 + 50 * this.f, 50 + 50 * this.f, 50 + 50 * this.f);
        } else if (this.f < 15) {
            bw.var_javax_microedition_lcdui_Graphics_a.setColor(0xFFFFFF);
        } else if (this.f < 18) {
            bw.var_javax_microedition_lcdui_Graphics_a.setColor(255 - 50 * (this.f - 15), 255 - 50 * (this.f - 15), 255 - 50 * (this.f - 15));
        } else {
            bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
        }
        int n3 = bw.j - 60;
        for (int i2 = 0; i2 < 10; ++i2) {
            byte[] byArray = this.var_e_a.a(n2 + i2);
            if (byArray == null) continue;
            bk.a(bw.var_javax_microedition_lcdui_Graphics_a, bw.i, n3 + 13 * i2, byArray, 0, 1);
        }
        if (this.f < 20) {
            ++this.f;
        } else if (this.o < 8) {
            ++this.o;
            this.f = 0;
        }
    }

    private void m() {
        this.var_e_a = new e("/t/stf");
        this.f = 0;
        this.o = 0;
    }

    private void n() {
        this.var_by_a = null;
        this.var_e_a = null;
        ae.var_javax_microedition_lcdui_Image_a = null;
        ae.var_byte_arr_i = null;
        ak.d();
        ak.c((byte)17);
        u.a((byte)3, (byte)14, (byte)1);
    }

    private void o() {
        bw.var_javax_microedition_lcdui_Graphics_a.setColor(0);
        bw.var_javax_microedition_lcdui_Graphics_a.fillRect(0, 0, bw.g, bw.h);
        bw.var_javax_microedition_lcdui_Graphics_a.setColor(0xFFFFFF);
        bk.a(bw.var_javax_microedition_lcdui_Graphics_a, bw.i, bw.j - 20, as.var_e_a.a(u.var_byte_i > 0 ? 57 : 56), 0, 1);
        bk.a(bw.var_javax_microedition_lcdui_Graphics_a, bw.i, bw.j + 10, as.var_e_a.a(41), 0, 1);
    }

    static {
        var_int_arr_a = new int[]{0, 0x3F7FFF, 0xFF0000, 65280, 0xFFFFFF, 0xBFBFBF};
        var_bd_a = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void origKeyPressed0(int n2) {
        int n3;
        if (q) {
            q = false;
            return;
        }
        if (cj.var_cj_a == null) return;
        if (cj.var_boolean_a) {
            return;
        }
        ((bw)this).f = true;
        try {
            n3 = this.getGameAction(n2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            n3 = 0;
        }
        switch (u.var_int_a) {
            case 3: {
                this.a(n3, n2);
                return;
            }
            case 2: {
                bg.var_bg_a.boolean_a(n3, n2);
                return;
            }
            case 5: {
                ck.ck_a().boolean_a(n3, n2);
                return;
            }
            case 6: {
                cq.cq_a().boolean_a(n3, n2);
                return;
            }
            case 7: {
                o.o_a().boolean_a(n3, n2);
                return;
            }
            case 8: {
                bv.bv_a().boolean_a(n3, n2);
                return;
            }
            case 9: {
                cm.cm_a().boolean_a(n3, n2);
            }
            case 4: {
                ae.a(n3, n2);
                return;
            }
            case 11: {
                u.a((byte)3, (byte)3, (byte)1);
                var_boolean_a = true;
                return;
            }
            case 12: {
                this.i = true;
                return;
            }
            case 14: {
                if (n3 != 8) {
                    if (n2 != 53) return;
                }
                u.a((byte)9, (byte)2);
                return;
            }
        }
    }

    public static int hlzTextWidth(byte[] byArray) {
        int n2 = 0;
        int n3 = 0;
        while (n3 < byArray.length) {
            byte by2 = byArray[n3];
            if ((by2 & 0x80) != 0) {
                n2 += 9;
                n3 += 2;
                continue;
            }
            int n4 = by2 - 32;
            if (n4 >= 0 && n4 < bk.g.length) {
                n2 += bk.g[n4] & 0xFF;
                ++n3;
                continue;
            }
            n2 += 6;
            ++n3;
        }
        return n2;
    }
}

