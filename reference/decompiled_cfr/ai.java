/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class ai
extends g {
    public boolean var_boolean_a;
    public byte var_byte_a;
    private byte[] i;
    private byte[] j;
    private short[] var_short_arr_a;
    public int var_int_a;
    public boolean b;

    public ai(g g2, boolean bl2) {
        super(g2, (byte)8);
        this.var_boolean_a = bl2;
        this.h = 0;
        this.var_byte_a = 0;
        this.var_int_a = this.var_boolean_a || bw.g < 176 ? 180 : (this.var_boolean_a || bw.g < 240 ? 152 : 180);
        this.a(this.var_byte_a);
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8 || n3 == 53 || n2 == 8) {
            this.var_g_a.h = (byte)(this.var_boolean_a ? 1 : 3);
            this.var_g_a.b(this.var_g_a.h);
            return true;
        }
        if (n2 == 2 || n3 == 52) {
            this.var_byte_a = (byte)((this.var_byte_a + 8 - 1) % 8);
            this.b = true;
            return true;
        }
        if (n2 == 5 || n3 == 54) {
            this.var_byte_a = (byte)((this.var_byte_a + 1) % 8);
            this.b = true;
            return true;
        }
        return this.boolean_c(n2, n3);
    }

    public void a(byte by2) {
        this.b = false;
        this.i = as.var_e_h.a(by2);
        this.j = as.var_e_h.a(by2 + 8);
        short[] sArray = new short[20];
        int n2 = 0;
        for (int i2 = 0; i2 < this.j.length; i2 += bk.a(this.j, i2, this.var_int_a, 5)) {
            sArray[n2++] = (short)i2;
        }
        this.var_short_arr_a = new short[n2];
        System.arraycopy(sArray, 0, this.var_short_arr_a, 0, this.var_short_arr_a.length);
        ((g)this).i = (byte)this.var_short_arr_a.length;
        this.h = 0;
    }

    public void void_a(int n2, int n3) {
        short s2;
        if (this.b) {
            this.a(this.var_byte_a);
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        int n4 = 0;
        if (this.var_boolean_a) {
            g.a(graphics, n2, n3, false, true);
            graphics.setColor(0);
            graphics.fillRect(n2 - 36, n3 + 13, 192, 15);
            graphics.fillRect(n2 - 36, n3 + 30, 192, 82);
            n4 = bw.j - 43;
        } else {
            this.a(graphics);
            n4 = bw.j - 36;
            graphics.setColor(14467940);
            bk.a(graphics, bw.i, bw.j - 60, as.var_e_a.a(3), 0, 1);
        }
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, bw.i, n4, this.i, 0, 1);
        this.b(graphics, bw.i - 90, n4 + 4, 180, 14467940, false);
        graphics.setColor(0x7F7F7F);
        if (((g)this).i > 1) {
            this.d(graphics, bw.i - 2, n4 + 17, 74);
        }
        short s3 = this.var_short_arr_a[this.h];
        short s4 = s2 = this.h == ((g)this).i - 1 ? (short)this.j.length : this.var_short_arr_a[this.h + 1];
        if (this.j[0] == 33) {
            if (s3 == 0) {
                s3 = 1;
            }
            bk.var_boolean_b = false;
        }
        bk.a(graphics, bw.g - this.var_int_a >> 1, n4 + 23, this.var_int_a, 1, this.j, s3, 0, s2 - s3);
        bk.var_boolean_b = true;
        this.b(graphics, bw.i + (this.var_int_a >> 1), n4 + 15, this.h + 1, ((g)this).i);
    }
}

