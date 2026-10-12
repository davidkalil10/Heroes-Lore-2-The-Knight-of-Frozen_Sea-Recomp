/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class y
extends g {
    private byte[] i = new byte[52];
    private boolean c;
    private byte[] j;
    private byte[] k;
    private int var_int_a;
    private byte[] l;
    public boolean var_boolean_a = true;
    public boolean b = false;

    public y(g g2) {
        super(g2, (byte)0);
        ((g)this).i = 0;
        this.h = 0;
        this.var_boolean_a = true;
        for (int n2 = 0; n2 < 52; n2 = (int)((byte)(n2 + 1))) {
            if (u.byte_a(n2) != 1) continue;
            this.i[((g)this).i] = n2;
            ((g)this).i = (byte)(((g)this).i + 1);
        }
        if (((g)this).i > 0) {
            this.a(this.h);
            this.f = true;
        }
        u.j();
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8 || n2 == 8 || n3 == 53) {
            this.var_g_a.h = (byte)5;
            this.var_g_a.b(5);
            return true;
        }
        if (n2 == 1 || n2 == 6 || n3 == 50 || n3 == 56) {
            this.var_boolean_a = !this.var_boolean_a;
        } else if (this.boolean_d(n2, n3) && ((g)this).i > 1 && !this.b) {
            this.b = true;
        }
        return false;
    }

    public void void_a(int n2, int n3) {
        if (this.b) {
            this.a(this.h);
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.a(graphics, n2, n3, false, true);
        graphics.setColor(0);
        int n4 = n3 + 14;
        graphics.fillRect(n2 - 30, n4, 180, 16);
        graphics.fillRect(n2 - 30, n3 + 33, 180, 80);
        bd.a(n2 - 19, n4 + 2, (byte)33);
        if (((g)this).i > 0) {
            this.b(graphics, n2 + 144, n4 + 5, this.h + 1, ((g)this).i);
            if (this.c) {
                graphics.drawImage(as.var_javax_microedition_lcdui_Image_m, n2 + 100, n4 + 5, 20);
            }
            this.c(graphics, n2 - 22, n3 + 41);
        } else {
            graphics.setColor(0xFFFFFF);
            bk.a(graphics, n2 - 22, n3 + 41, 164, 1, ck.var_e_a.a(43));
        }
    }

    public void c(Graphics graphics, int n2, int n3) {
        if (this.var_boolean_a) {
            graphics.setColor(0xFFFFFF);
            if (this.j != null) {
                bk.a(graphics, n2, n3, 164, 1, this.j);
            }
            graphics.setColor(0x7F7F7F);
            if (this.k != null) {
                bk.a(graphics, n2, n3 + 17, 164, 1, this.k);
            }
        } else {
            int n4 = n3;
            graphics.setColor(0x7F7F7F);
            if (this.var_int_a > 0) {
                bk.a(graphics, n2, n4, 164, 1, ck.var_e_a.a(76));
                f.a(graphics, this.var_int_a, n2 + 30, n4 + 2, 4, 0);
                n4 += 15;
            }
            if (this.l != null) {
                bk.a(graphics, n2, n4, 164, 1, this.l);
            }
        }
    }

    public void a(int n2) {
        int n3 = this.i[n2];
        if (--n3 < 0) {
            return;
        }
        int n4 = n3 * 5;
        this.c = false;
        byte[] byArray = as.var_e_e.a(n4);
        if (byArray.length > 0) {
            this.c = byArray[0] == 109;
        }
        this.j = as.var_e_e.a(n4 + 1);
        this.k = as.var_e_e.a(n4 + 2);
        byte[] byArray2 = as.var_e_e.a(n4 + 3);
        this.var_int_a = 0;
        if (byArray2.length > 0) {
            this.var_int_a = Integer.parseInt(new String(byArray2));
        }
        this.var_int_a *= u.var_byte_arr_i[u.var_byte_i];
        this.l = as.var_e_e.a(n4 + 4);
        this.b = false;
        this.var_boolean_a = true;
        int n5 = 0;
        switch (++n3) {
            case 5: {
                n5 = 15;
                break;
            }
            case 40: {
                n5 = 40;
                break;
            }
            case 44: 
            case 48: {
                n5 = 20;
                break;
            }
            default: {
                return;
            }
        }
        int n6 = 0;
        for (int i2 = 0; i2 < u.var_java_util_Vector_b.size(); ++i2) {
            byte[] byArray3 = (byte[])u.var_java_util_Vector_b.elementAt(i2);
            if (byArray3[0] != n3) continue;
            n6 = byArray3[1];
            if (n6 <= n5) break;
            n6 = n5;
            break;
        }
        String string = new String("(" + n6 + "/" + n5 + ")");
        this.j = f.a(this.j, string.getBytes());
    }

    public void void_b(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        if (((g)this).i > 1) {
            this.b(graphics, n2 - 27, n3 + 22, 26, g.var_int_arr_a[((g)this).l], false);
        } else {
            graphics.setColor(g.var_int_arr_a[((g)this).l]);
        }
        if (this.var_boolean_a) {
            this.d(graphics, n2 + 60, n3 + 103);
        } else {
            this.void_b(graphics, n2 + 60, n3 + 103);
        }
    }

    private void d(Graphics graphics, int n2, int n3) {
        for (int i2 = 0; i2 < 3; ++i2) {
            graphics.drawLine(n2 - 2 + i2, n3 + i2, n2 + 2 - i2, n3 + i2);
        }
    }
}

