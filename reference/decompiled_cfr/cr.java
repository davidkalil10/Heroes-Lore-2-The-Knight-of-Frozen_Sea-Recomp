/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class cr
extends g {
    public int var_int_a = 0;
    public int b = 0;
    public byte var_byte_a;
    public boolean var_boolean_a;

    public cr(g g2, int n2, boolean bl2) {
        super(g2, (byte)0);
        this.b = n2;
        byte[] byArray = this.byte_arr_a(this.b);
        this.var_byte_a = (byte)byArray.length;
        this.var_boolean_a = bl2;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 52 || n2 == 2) {
            this.h = (byte)((this.h + 1) % this.var_byte_a);
        } else if (n3 == 54 || n2 == 5) {
            this.h = (byte)((this.h + this.var_byte_a - 1) % this.var_byte_a);
        } else if (n3 == 50 || n2 == 1) {
            this.void_a(this.h);
        } else if (n3 == 56 || n2 == 6) {
            this.c((int)this.h);
        } else if (n3 == 8) {
            this.var_g_a.b(0);
        } else if (n2 == 8 || n3 == 53) {
            r.var_int_d = this.var_boolean_a ? this.var_int_a : -this.var_int_a;
            this.var_g_a.a((byte)80, (byte)this.var_int_a);
        }
        return true;
    }

    public void void_a(int n2) {
        int n3;
        int n4 = 1;
        for (n3 = 0; n3 < n2; ++n3) {
            n4 *= 10;
        }
        n3 = this.var_int_a + n4;
        if (n3 <= this.b) {
            this.var_int_a = n3;
        }
    }

    public void c(int n2) {
        int n3;
        int n4 = 1;
        for (n3 = 0; n3 < n2; ++n3) {
            n4 *= 10;
        }
        n3 = this.var_int_a - n4;
        if (n3 >= 0) {
            this.var_int_a = n3;
        }
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        byte[] byArray = this.byte_arr_a(this.var_int_a);
        int n4 = ba.int_b(graphics, 120, 40);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, bw.i, n4 + 8, r.var_e_a.a(19), 0, 1);
        int n5 = bw.i + 30;
        int n6 = n4 + 22;
        this.void_b(graphics, n5 + 3 - this.h * 8, n4 + 33);
        graphics.setColor(0x7F7F7F);
        graphics.fillRect(n5 - this.h * 8, n6, 7, 10);
        for (int i2 = 0; i2 < this.var_byte_a; ++i2) {
            f.a(graphics, i2 < byArray.length ? byArray[i2] : (byte)0, n5 + 1 - i2 * 8, n6 + 2, 4, 0);
        }
    }

    private byte[] byte_arr_a(int n2) {
        int n3 = 1;
        int n4 = n2 / 10;
        while (n4 != 0) {
            n4 /= 10;
            n3 = (byte)(n3 + 1);
        }
        n4 = n2;
        byte[] byArray = new byte[n3];
        for (int n5 = 0; n5 < n3; n5 = (int)((byte)(n5 + 1))) {
            byArray[n5] = (byte)(n4 % 10);
            n4 /= 10;
        }
        return byArray;
    }
}

