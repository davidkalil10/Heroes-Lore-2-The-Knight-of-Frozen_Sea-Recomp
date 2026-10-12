/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public class bj
extends bb {
    public byte var_byte_a;
    public boolean var_boolean_a;
    public byte b;
    public byte c = 0;

    public bj(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, (byte)8, (byte)8);
        this.var_byte_a = by2;
        this.var_boolean_a = true;
        this.b = by3;
        this.c = 0;
        this.var_byte_t = (byte)2;
    }

    public void b(int n2, int n3) {
        if (!this.var_boolean_a) {
            return;
        }
        int n4 = n2 + this.var_short_c + this.var_byte_f;
        int n5 = n3 + this.var_short_d + this.g;
        if (n4 + 16 < 0 || n5 < 0 || n4 > bd.var_int_a + 16 || n5 > bd.var_int_b + 16) {
            return;
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        byte by2 = 0;
        graphics.drawImage(as.v, n4, n5 - 2, 17);
        if (this.var_byte_v < 0) {
            this.var_byte_v = 0;
        }
        switch (this.c) {
            case 2: {
                by2 = bd.byte_a(this.b, (byte)1, this.var_byte_v, this.var_byte_t, n4, n5);
                break;
            }
            default: {
                by2 = bd.byte_a(this.b, (byte)0, this.var_byte_v, this.var_byte_t, n4, n5);
            }
        }
        this.var_byte_v = (byte)(this.var_byte_v + 1);
        if (this.var_byte_v >= by2) {
            this.var_byte_v = 0;
        }
        this.j();
        this.e(n4, n5);
    }

    public final void j() {
        if (this.c == 1) {
            this.c = 0;
            this.void_c();
            this.t();
            u.var_ah_a.b(this);
        }
    }

    public void f(int n2) {
        this.u();
        this.var_short_c = (short)(this.var_short_c + n2 * ax.var_byte_arr_a[this.var_byte_t]);
        this.var_short_d = (short)(this.var_short_d + n2 * ax.var_byte_arr_b[this.var_byte_t]);
        this.void_c();
    }

    public boolean boolean_e() {
        return false;
    }

    public void a() {
        if (this.c == 2) {
            this.f(8);
        }
    }

    public void a(short s2, short s3) {
        this.u();
        super.a(s2, s3);
        this.void_c();
        if (this.c == 1) {
            this.t();
        }
    }
}

