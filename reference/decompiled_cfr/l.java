/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class l
extends g {
    public boolean a;

    public l(g g2, boolean bl2) {
        super(g2, (byte)5);
        this.a = bl2;
        this.f = true;
    }

    public void a() {
        if (cj.var_boolean_b) {
            ak.a();
        } else {
            ak.a((byte[])ak.b[2], false);
            ak.var_long_a = System.currentTimeMillis() + 3000L;
        }
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 53 || n2 == 8 || n3 == 8) {
            if (cj.d) {
                u.var_int_d = u.var_int_b;
                u.var_int_e = u.var_int_c;
            }
            try {
                cj.var_cj_a.j();
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.var_g_a.h = (byte)(this.a ? 2 : 2);
            this.var_g_a.b(this.var_g_a.h);
            return true;
        }
        if (n3 == 52 || n2 == 2 || n3 == 54 || n2 == 5) {
            switch (this.h) {
                case 0: {
                    if (n3 == 52 || n2 == 2) {
                        cj.var_byte_b = (byte)((cj.var_byte_b + ak.var_int_a - 1) % ak.var_int_a);
                    } else if (n3 == 54 || n2 == 5) {
                        cj.var_byte_b = (byte)((cj.var_byte_b + 1) % ak.var_int_a);
                    }
                    ak.a((int)cj.var_byte_b);
                    if (cj.var_byte_b == 0) {
                        ak.b();
                        break;
                    }
                    this.a();
                    break;
                }
                case 1: {
                    boolean bl2 = cj.var_boolean_b = !cj.var_boolean_b;
                    if (cj.var_boolean_b) break;
                    ak.b();
                    break;
                }
                case 2: {
                    boolean bl3 = cj.var_boolean_c = !cj.var_boolean_c;
                    if (!cj.var_boolean_c) break;
                    ak.a((byte)2);
                    break;
                }
                case 3: {
                    if (n3 == 52 || n2 == 2) {
                        cj.var_byte_a = (byte)((cj.var_byte_a + 3) % 4);
                    } else if (n3 == 54 || n2 == 5) {
                        cj.var_byte_a = (byte)((cj.var_byte_a + 1) % 4);
                    }
                    cj.var_cj_a.a(cj.var_byte_a);
                    break;
                }
                case 4: {
                    cj.d = !cj.d;
                }
            }
        }
        return this.boolean_c(n2, n3);
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        if (this.a) {
            g.a(graphics, n2, n3, false, true);
            graphics.setColor(0);
            graphics.fillRect(n2 - 15, n3 + 15, 150, 97);
        } else {
            this.a(graphics);
            graphics.setColor(14467940);
            bk.a(graphics, bw.i - 20, bw.j - 60, as.var_e_a.a(2), 0);
        }
        int n4 = bw.j - 36;
        graphics.setColor(14134162);
        for (int i2 = 0; i2 < 5; ++i2) {
            bk.a(graphics, bw.i - 67, n4 + 18 * i2, as.var_e_a.a(26 + i2), 0);
        }
        this.e(graphics, bw.i + 30, n4, cj.var_byte_b);
        graphics.setColor(this.h == 1 ? 0xFFFFFF : 0x7F7F7F);
        this.b(graphics, bw.i + 49, n4 + 18, cj.var_boolean_b);
        graphics.setColor(this.h == 2 ? 0xFFFFFF : 0x7F7F7F);
        this.b(graphics, bw.i + 49, n4 + 36, cj.var_boolean_c);
        graphics.setColor(this.h == 3 ? 0xFFFFFF : 0x7F7F7F);
        bk.a(graphics, bw.i + 49, n4 - 0 + 54, as.var_e_a.a(32 + cj.var_byte_a), 0, 1);
        graphics.setColor(this.h == 4 ? 0xFFFFFF : 0x7F7F7F);
        this.b(graphics, bw.i + 49, n4 + 72, cj.d);
    }

    public void b(Graphics graphics, int n2, int n3, boolean bl2) {
        bk.a(graphics, n2, n3 - 0, as.var_e_a.a(bl2 ? 24 : 25), 0, 1);
    }

    public void e(Graphics graphics, int n2, int n3, int n4) {
        if (n4 == 0) {
            graphics.setColor(this.h == 0 ? 0xFFFFFF : 0x7F7F7F);
            bk.a(graphics, bw.i + 40, n3 - 1, as.var_e_a.a(25), 0);
            return;
        }
        graphics.setColor(0);
        graphics.fillRect(n2 + 1, n3 + 1, 35, 8);
        graphics.setColor(this.h == 0 ? 0xFFFFFF : 0x7F7F7F);
        graphics.drawRect(n2, n3, 36, 9);
        if (n4 == ak.var_int_a - 1) {
            graphics.fillRect(n2 + 2, n3 + 2, 33, 6);
        } else {
            graphics.fillRect(n2 + 2, n3 + 2, 32 * n4 / ak.var_int_a, 6);
        }
    }

    public void void_b(int n2, int n3) {
        this.b(bw.var_javax_microedition_lcdui_Graphics_a, bw.i + 25, bw.j + 4 + 18 * (this.h - 2), 46, 14134162, false);
    }
}

