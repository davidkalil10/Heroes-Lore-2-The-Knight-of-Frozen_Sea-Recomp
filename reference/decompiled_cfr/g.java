/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public abstract class g
implements ax {
    public static final int[] var_int_arr_a;
    private static final int[] c;
    public g var_g_a;
    public g b;
    public byte h;
    public byte i;
    public byte j;
    public byte k;
    public byte l;
    public boolean d;
    public boolean e;
    public boolean f;

    public abstract boolean boolean_a(int var1, int var2);

    public abstract void void_a(int var1, int var2);

    public g(g g2, byte by2, byte by3, byte by4) {
        this.var_g_a = g2;
        this.b = null;
        this.d = true;
        this.e = true;
        this.f = false;
        this.i = by2;
        this.k = by3;
        this.j = by4;
        this.h = 0;
    }

    public g(g g2, byte by2) {
        this(g2, by2, 1, 1);
    }

    public final void a(byte by2, byte[][] byArray) {
        this.b = new ba(this, by2, (byte)byArray.length, byArray);
    }

    public final void a(byte by2, int n2, byte[][] byArray) {
        this.b = new ba(this, by2, (byte)n2, byArray);
    }

    public void a(byte by2, byte by3) {
        this.b(by3);
    }

    public final boolean boolean_b(int n2, int n3) {
        if (this.b != null && this.b.boolean_a(n2, n3)) {
            return true;
        }
        this.e = true;
        return false;
    }

    public void void_c(int n2, int n3) {
        boolean bl2 = false;
        if (this.e) {
            this.e = false;
            this.void_a(n2, n3);
            bl2 = true;
        }
        if (this.b == null) {
            if (this.d) {
                if (!bl2) {
                    this.void_a(n2, n3);
                }
                this.d = false;
            }
            if (this.f) {
                this.void_b(n2, n3);
            }
        } else {
            this.b.void_c(n2, n3);
        }
        if (this.f) {
            this.l = (byte)(this.l + 1);
            if (this.l > 2) {
                this.l = 0;
            }
        }
    }

    public boolean boolean_c(int n2, int n3) {
        if (n3 == 50 || n2 == 1) {
            this.c((byte)3);
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.c((byte)4);
            return true;
        }
        return false;
    }

    public boolean boolean_d(int n2, int n3) {
        if (n3 == 52 || n2 == 2) {
            this.c((byte)3);
            return true;
        }
        if (n3 == 54 || n2 == 5) {
            this.c((byte)4);
            return true;
        }
        return false;
    }

    public void c(byte by2) {
        if (by2 == 4) {
            this.h = (byte)(this.h + 1);
            if (this.h >= this.i) {
                this.h = 0;
            }
        } else {
            this.h = (byte)(this.h - 1);
            if (this.h < 0) {
                this.h = (byte)(this.i - 1);
            }
        }
    }

    public boolean e(int n2, int n3) {
        if (n3 == 50 || n2 == 1) {
            this.d((byte)3);
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.d((byte)4);
            return true;
        }
        return false;
    }

    public void d(byte by2) {
        if (by2 == 4) {
            this.h = (byte)(this.h + this.j);
            if (this.h >= this.i) {
                this.h = (byte)(this.h - this.j * this.k);
                if (this.h < 0) {
                    this.h = 0;
                }
            }
        } else {
            this.h = (byte)(this.h - this.j);
            if (this.h < 0) {
                this.h = (byte)(this.j * this.k + this.h);
                if (this.h >= this.i) {
                    this.h = (byte)(this.i - 1);
                }
            }
        }
    }

    public void b(int n2) {
        this.b = null;
        if (bd.var_bd_a != null) {
            bd.var_bd_a.b();
        }
        this.g();
    }

    public void g() {
        this.e = true;
        if (this.var_g_a != null) {
            this.var_g_a.g();
        }
    }

    public void h() {
        this.e = true;
        if (this.b != null) {
            this.b.h();
        }
    }

    public static final void a(Graphics graphics, int n2, int n3, boolean bl2, boolean bl3) {
        graphics.setClip(n2 -= 35, n3, 190, 117);
        graphics.setColor(6970180);
        graphics.fillRect(n2, n3, 190, 117);
        graphics.setColor(0);
        graphics.fillRect(n2, n3, 190, 11 + (bl3 ? 0 : 2));
        if (bl2) {
            graphics.fillRect(n2, n3 + 117 - 9, 190, 9);
        }
        if (as.t != null && bw.g > 190) {
            g.cWide(graphics, n2, n3);
        }
        if (bl3) {
            byte by2 = ck.var_byte_a;
            graphics.setColor(0xFFFFFF);
            bk.a(graphics, bw.i, n3 + 1, ck.var_e_a.a(by2 + 5), 1, 1);
        }
    }

    private static final void c(Graphics graphics, int n2, int n3) {
        g.a(graphics, (byte)2, n2 - 9, n3 - 3);
        g.a(graphics, (byte)2, n2 - 9, n3 + 117 - 2);
        g.a(graphics, (byte)2, n2 + 120 + 2, n3 - 3);
        g.a(graphics, (byte)2, n2 + 120 + 2, n3 + 117 - 2);
        graphics.setClip(0, 0, bw.g, bw.h);
        graphics.setColor(0);
        graphics.fillRect(n2 - 10, n3, 10, 118);
        graphics.fillRect(n2 + 120, n3, 10, 118);
        graphics.drawLine(n2, n3 + 117, n2 + 120, n3 + 117);
        graphics.setColor(4009755);
        graphics.fillRect(n2 - 9, n3, 8, 117);
        graphics.fillRect(n2 + 120 + 1, n3, 8, 117);
        graphics.setColor(10193521);
        graphics.fillRect(n2 - 8, n3 + 1, 3, 116);
        graphics.fillRect(n2 + 120 + 3, n3 + 1, 3, 116);
        graphics.setColor(6970180);
        graphics.fillRect(n2 - 5, n3 + 1, 2, 116);
        graphics.fillRect(n2 + 120 + 6, n3 + 1, 2, 116);
        graphics.setClip(n2, n3, 120, 117);
    }

    public static final void void_a(Graphics graphics, int n2, int n3) {
        g.a(graphics, n2, n3, false, true);
        int n4 = n3 + 15;
        graphics.setColor(0);
        graphics.fillRect(n2 + 3, n4, 14, 14);
        graphics.fillRect(n2 + -10, n4, 156, 87);
        graphics.fillRect(n2 + -36, n4 + 91, 194, 11);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n2 + 54, n4 + 92, as.var_e_a.a(21), 1);
    }

    public void void_b(int n2, int n3) {
    }

    public void a(int n2, int n3, int n4, int n5) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        graphics.setColor(var_int_arr_a[this.l]);
        graphics.drawRect(n2, n3, n4, n5);
    }

    public final void a(Graphics graphics, int n2, int n3, int n4) {
        graphics.setColor(n4);
        bk.a(graphics, n2, n3, as.var_e_a.a(19), 1);
    }

    public final void a(Graphics graphics, int n2, int n3, cp cp2, boolean bl2, boolean bl3, boolean bl4) {
        int n4;
        graphics.setClip(n2, n3, 150, 117);
        int n5 = n2;
        int n6 = n3;
        int n7 = 0;
        if (cp2 == null) {
            this.a(graphics, n2, n3, 0x7F7F7F);
            return;
        }
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        p p2 = null;
        am am2 = null;
        int n8 = bl2 ? 12 : 11;
        int n9 = 45;
        if (bl3) {
            graphics.setColor(15128512);
            bk.a(graphics, n2, n3 + n8, as.var_e_c.a(58), 1);
            n4 = cp2.d;
            if (bl4) {
                n4 >>= 2;
            }
            bk.a(graphics, n2 + 32, n3 + n8, ("" + n4).getBytes(), 1);
        }
        if (cp2 instanceof p) {
            bl5 = true;
            p2 = (p)cp2;
            if (cp2 instanceof am) {
                bl6 = true;
                am2 = (am)cp2;
                if (cp2 instanceof cf) {
                    bl7 = true;
                }
            }
            graphics.setColor(c[p2.b]);
        } else {
            graphics.setColor(0xFFFFFF);
        }
        n4 = bl7 ? ((cf)am2).b() : (bl6 ? am2.int_a() : 0);
        short s2 = bl7 ? ((cf)am2).short_a() : (short)0;
        bk.a(graphics, n2, n3, cp2.j, 1);
        if (bl2) {
            if (bl5) {
                int n10;
                bk.a(graphics, n2 + 138 + 13, n6 += n8, as.var_e_c.a(35 + p2.b), 1, 8);
                if (p2.c >= 1 && p2.c <= 5) {
                    graphics.setColor(0xFF0000);
                    bk.a(graphics, n5 + 102 + 13, n6, as.var_e_c.a(p2.c + 58), 1, 8);
                }
                graphics.setColor(0xFFFFFF);
                bk.a(graphics, n2, n6 += n8, as.var_e_c.a(39), 0);
                bk.a(graphics, n2 + 25, n6, ("" + p2.a).getBytes(), 0);
                if (bl6) {
                    if (cp2 instanceof am) {
                        bk.a(graphics, n5 + 138 + 13, n6, as.var_e_f.a(4 + (am2.k > 17 ? 17 : (int)am2.k)), 1, 8);
                    }
                    graphics.setColor(0x7F7F7F);
                    bk.a(graphics, n2, n6 += n8, as.var_e_c.a(bl7 ? 42 : 43), 1);
                    bk.a(graphics, n2 + 30, n6, ("" + (bl7 ? s2 + "-" : "") + n4).getBytes(), 1);
                    if (!bl7) {
                        bk.a(graphics, n2 + 81, n6, as.var_e_c.a(56 + am2.o), 1);
                    }
                    this.a(graphics, n2, n6 += n8, am2);
                } else if (cp2 instanceof q) {
                    q q2 = (q)p2;
                    n6 += n8;
                    graphics.setColor(0xFFFFFF);
                    n10 = 0;
                    if (q2.var_short_a > 0) {
                        this.a(graphics, "Attack", (int)q2.var_short_a, n2, n6, false);
                        ++n10;
                    }
                    if (q2.var_short_b > 0) {
                        this.a(graphics, "Defense", (int)q2.var_short_b, n2 + n9 * n10, n6, false);
                    }
                    n6 += n8;
                    n10 = 0;
                    if (q2.var_int_a > 0) {
                        graphics.setColor(0xFF0000);
                        this.a(graphics, "HP", q2.var_int_a, n2, n6, true);
                        ++n10;
                    }
                    if (q2.var_int_b > 0) {
                        graphics.setColor(7258047);
                        this.a(graphics, "SP", q2.var_int_b, n2 + n9 * n10, n6, true);
                    }
                }
                n6 += n8;
                graphics.setColor(8701316);
                int n11 = 0;
                for (n10 = 0; n10 < 5; ++n10) {
                    if (p2.i[n10] <= 0) continue;
                    bk.a(graphics, n2 + n11 * 45, n6, as.var_e_c.a(45 + n10), 1);
                    bk.a(graphics, n2 + 18 + n11 * 45, n6, ("+" + p2.i[n10]).getBytes(), 1);
                    ++n11;
                }
                n6 += n8;
                if (bl7) {
                    this.a(graphics, n2, n6, (int)am2.n, true);
                    this.b(graphics, n5 + 65, n6, (int)((cf)am2).i, true);
                }
            } else if (cp2.k != null) {
                graphics.setClip(n2, n3, 150, 117);
                graphics.setColor(0x7F7F7F);
                bk.a(graphics, n2, n3 + 26, 140, 1, cp2.k, 0, 0, cp2.k.length);
            }
        } else if (bl6) {
            graphics.setColor(0xFFFFFF);
            bk.a(graphics, n5 + 140, n6 + n8, ((bl7 ? "ATK" : "DEF") + n4).getBytes(), 1, 8);
            n7 = 0;
            graphics.setColor(0x7F7F7F);
            if (this.a(graphics, n2, n6 += n8, am2)) {
                n7 = 1;
            }
            if (bl7) {
                this.a(graphics, n2 + 190 * n7, n6, (int)am2.n, false);
                this.b(graphics, n5 + 190 * n7 + 29, n6, (int)((cf)am2).i, false);
            }
        }
    }

    public boolean a(Graphics graphics, int n2, int n3, am am2) {
        if (am2.m < 1) {
            return false;
        }
        bk.a(graphics, n2, n3, as.var_e_c.a(44), 1);
        bk.a(graphics, n2 + 74, n3, ("" + am2.d + "/" + am2.m).getBytes(), 1);
        return true;
    }

    public void a(Graphics graphics, String string, int n2, int n3, int n4, boolean bl2) {
        bk.a(graphics, string, n3, n4 - (bl2 ? 2 : 0), 4);
        bk.a(graphics, "+" + n2, n3 + 42, n4 - (bl2 ? 2 : 0), 4);
    }

    public void a(Graphics graphics, int n2, int n3, int n4, boolean bl2) {
        if (n4 < 0) {
            return;
        }
        graphics.setColor(bl2 && n4 != 0 ? 0xFF0000 : 0x7F7F7F);
        bk.a(graphics, n2, n3, as.var_e_c.a(50 + n4), 1);
    }

    public void b(Graphics graphics, int n2, int n3, int n4, boolean bl2) {
        if (n4 < 1) {
            return;
        }
        graphics.setColor(bl2 ? 0xFF0000 : 0x7F7F7F);
        bk.a(graphics, n2, n3, as.var_e_g.a(n4 - 1), 1);
    }

    public void a(Graphics graphics, int n2, int n3, int n4, int n5) {
        graphics.setColor(0);
        for (int i2 = 0; i2 < n4; ++i2) {
            graphics.fillRect(n2, n3 + i2 * 19, n5, 14);
        }
    }

    public static int int_a(Graphics graphics, int n2, int n3) {
        int n4 = bw.h - n2 >> 1;
        int n5 = bw.g - 200 >> 1;
        graphics.setColor(0);
        graphics.fillRect(n5, n4, 200, n2);
        if (n3 == 6970180) {
            graphics.setColor(6970180);
            graphics.fillRect(n5, n4 + 2, 200, n2 - 3);
        } else {
            graphics.setColor(0xFFFFFF);
            graphics.drawRect(n5, n4, 200, n2);
        }
        graphics.setColor(var_int_arr_a[0]);
        graphics.drawRect(n5, n4, 200, n2);
        return n4;
    }

    public void c(Graphics graphics, int n2, int n3, int n4, boolean bl2) {
        int n5 = n4 + (bl2 ? 10 : 0);
        int n6 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            if (n5 != u.var_byte_arr_j[i2]) continue;
            n6 = i2 * 2 + 1 + i2 / 2 * 2;
            f.a(graphics, n6, n2, n3, 4, 0);
            return;
        }
    }

    public void a(Graphics graphics, byte[] byArray, int n2, int n3, int n4) {
        graphics.setColor(0);
        graphics.fillRect(n2, n3, 46, 16);
        graphics.setColor(n4);
        bk.a(graphics, n2 + 23 + 1, n3 + 3, byArray, 1, 1);
    }

    public void a(Graphics graphics) {
        graphics.setClip(0, 0, bw.g, bw.h);
        graphics.setColor(0);
        graphics.fillRect(0, 0, bw.g, bw.h);
        if (bw.h > 200) {
            int n2 = as.p.getHeight();
            for (int i2 = 0; i2 < bw.g; i2 += as.p.getWidth()) {
                graphics.drawImage(as.p, i2, 0, 20);
                graphics.drawImage(as.p, i2, bw.h, 36);
                graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_o[3], i2, n2, 20);
                graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_o[4], i2, bw.h - n2, 36);
            }
        }
    }

    public void a(Graphics graphics, int n2, int n3, boolean bl2) {
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_o[5], n2, n3, 17);
        if (bl2) {
            int n4 = (as.var_javax_microedition_lcdui_Image_arr_o[5].getWidth() >> 1) + 6;
            this.b(graphics, n2 - n4 - 1, n3 + 8, n4 << 1, 14467940, false);
        }
    }

    public final byte[] byte_arr_a(boolean bl2) {
        ci ci2 = u.var_ci_a;
        int n2 = 0;
        cp cp2 = null;
        byte[] byArray = new byte[ci2.var_java_util_Vector_a.size()];
        for (int n3 = 0; n3 < ci2.var_java_util_Vector_a.size(); n3 = (int)((byte)(n3 + 1))) {
            cp2 = (cp)ci2.var_java_util_Vector_a.elementAt(n3);
            if (cp2 == null || !(cp2 instanceof am)) continue;
            am am2 = (am)cp2;
            if (am2.f >= 0 || bl2 && (!bl2 || am2.m <= 0 || am2.d >= am2.m)) continue;
            byArray[n2] = n3;
            ++n2;
        }
        if (n2 == 0) {
            return null;
        }
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, 0, byArray2, 0, n2);
        return byArray2;
    }

    public void a(Graphics graphics, int n2, int n3, cg cg2) {
        g.a(graphics, cg2.m[0], n2, n3);
        g.a(graphics, cg2.m[1], n2 + 15, n3);
        g.a(graphics, cg2.m[2], n2 + 24, n3);
        g.a(graphics, cg2.m[3], n2 + 39, n3);
        graphics.setClip(0, 0, bw.g, bw.h);
        graphics.setColor(0);
        graphics.drawLine(n2 + 8, n3 + 3, n2 + 13, n3 + 3);
        graphics.drawLine(n2 + 32, n3 + 3, n2 + 37, n3 + 3);
    }

    public static void a(Graphics graphics, byte by2, int n2, int n3) {
        graphics.setClip(n2, n3, 7, 7);
        graphics.drawImage(as.t, n2 - by2 * 7, n3, 20);
    }

    public static final void a(Graphics graphics, int n2, int n3, int n4, int n5, byte[] byArray, int n6, int n7, int n8, int n9) {
        graphics.setColor(n8);
        graphics.fillRect(n2, 0, n4, n5);
        graphics.setColor(14467940);
        graphics.drawRect(n2 + 1, 1, n4 - 2, n5 - 2);
        if (byArray == null) {
            return;
        }
        graphics.setColor(n9);
        if (n7 == 1) {
            bk.a(graphics, n2 + n6 + (n4 - n6) / 2 - bk.a(byArray) / 2, n3 + 3, byArray, 1);
        } else {
            bk.a(graphics, n2 + n6, n3 + 3, byArray, 1);
        }
    }

    public void b(Graphics graphics, int n2, int n3, int n4) {
        f.a(graphics, n2, n3 + 8, n4, 8, 0);
        graphics.setClip(n3 + 10, n4, 7, 7);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_k, n3 + 10, n4, 20);
        graphics.setClip(0, 0, bw.g, bw.h);
    }

    public void a(Graphics graphics, int n2, int n3, int n4, int n5, boolean bl2) {
        int n6;
        g.a(graphics, n4, n5, true, false);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, bw.i, n5 + (bl2 ? 1 : 2), ck.var_e_a.a(n2), 0, 1);
        int n7 = 15;
        int n8 = bw.j - (n7 * this.i >> 1);
        graphics.setColor(0);
        for (n6 = 0; n6 < this.i; ++n6) {
            graphics.fillRect(bw.i - 32, n8 + n7 * n6, 64, n7 - 1);
        }
        graphics.setColor(0x7F7F7F);
        for (n6 = 0; n6 < this.i; ++n6) {
            if (n6 == this.h) continue;
            bk.a(graphics, bw.i, n8 + 2 + n7 * n6, ck.var_e_a.a(n3 + n6), 0, 1);
        }
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, bw.i, n8 + 2 + n7 * this.h, ck.var_e_a.a(n3 + this.h), 0, 1);
    }

    public final void d(Graphics graphics, int n2, int n3, int n4, boolean bl2) {
        graphics.setClip(0, 0, bw.g, bw.h);
        graphics.setColor(0);
        graphics.fillRect(n2 + 9, n3, 24, 9);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_g[bl2 ? 1 : 0], n2, n3, 20);
        f.a(graphics, n4, n2 + 22, n3 + 1, 1, 0);
    }

    public final void b(Graphics graphics, int n2, int n3, int n4, int n5) {
        f.a(graphics, n5, n2, n3, 8, 0);
        int n6 = this.a(n5);
        graphics.setClip(n2 - n6 - 7, n3, 7, 7);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_k, n2 - n6 - 7 - 7, n3, 20);
        f.a(graphics, n4, n2 - n6 - 9, n3, 8, 0);
    }

    public final void c(Graphics graphics, int n2, int n3, int n4) {
        int n5 = this.a(n4);
        graphics.setClip(0, 0, bw.g, bw.h);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_b, n2 - n5, n3, 24);
        f.a(graphics, n4, n2, n3, 8, 0);
    }

    public final void b(Graphics graphics, int n2, int n3, int n4, int n5, boolean bl2) {
        int n6 = bl2 ? 5 : 3;
        graphics.setColor(n5);
        for (int i2 = 0; i2 < n6; ++i2) {
            graphics.drawLine(n2 + i2, n3 - i2, n2 + i2, n3 + i2);
            graphics.drawLine(n2 + n4 - i2, n3 - i2, n2 + n4 - i2, n3 + i2);
        }
    }

    public final void void_b(Graphics graphics, int n2, int n3) {
        for (int i2 = 0; i2 < 3; ++i2) {
            graphics.drawLine(n2 - i2, n3 + i2, n2 + i2, n3 + i2);
        }
    }

    public final void d(Graphics graphics, int n2, int n3, int n4) {
        for (int i2 = 0; i2 < 3; ++i2) {
            graphics.drawLine(n2 - i2, n3 + i2, n2 + i2, n3 + i2);
            graphics.drawLine(n2 - 2 + i2, n3 + n4 + i2, n2 + 2 - i2, n3 + n4 + i2);
        }
    }

    private int a(int n2) {
        int n3 = 1;
        do {
            n3 += 4;
        } while ((n2 /= 10) != 0);
        return n3;
    }

    static {
        var_int_arr_a = new int[]{15128512, 12036759, 0xBFDFFF};
        c = new int[]{0xFFFFFF, 0xFFFF00, 65280, 0xFF00FF};
    }

    private static final void cWide(Graphics graphics, int n2, int n3) {
        g.a(graphics, (byte)2, n2 - 9, n3 - 3);
        g.a(graphics, (byte)2, n2 - 9, n3 + 117 - 2);
        g.a(graphics, (byte)2, n2 + 190 + 2, n3 - 3);
        g.a(graphics, (byte)2, n2 + 190 + 2, n3 + 117 - 2);
        graphics.setClip(0, 0, bw.g, bw.h);
        graphics.setColor(0);
        graphics.fillRect(n2 - 10, n3, 10, 118);
        graphics.fillRect(n2 + 190, n3, 10, 118);
        graphics.drawLine(n2, n3 + 117, n2 + 190, n3 + 117);
        graphics.setColor(4009755);
        graphics.fillRect(n2 - 9, n3, 8, 117);
        graphics.fillRect(n2 + 190 + 1, n3, 8, 117);
        graphics.setColor(10193521);
        graphics.fillRect(n2 - 8, n3 + 1, 3, 116);
        graphics.fillRect(n2 + 190 + 3, n3 + 1, 3, 116);
        graphics.setColor(6970180);
        graphics.fillRect(n2 - 5, n3 + 1, 2, 116);
        graphics.fillRect(n2 + 190 + 6, n3 + 1, 2, 116);
        graphics.setClip(n2, n3, 190, 117);
    }
}

