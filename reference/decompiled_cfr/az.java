/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class az
extends g {
    private byte[] i;
    private short[] var_short_arr_a;
    public int var_int_a = 100;
    public boolean var_boolean_a;

    public az(g g2, byte[] byArray, boolean bl2) {
        super(g2, (byte)0);
        this.i = byArray;
        this.var_boolean_a = bl2;
        this.a();
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 53 || n2 == 8 || n3 == 8) {
            this.var_g_a.a((byte)12, (byte)(this.var_boolean_a ? 100 : 0));
            return true;
        }
        this.boolean_c(n2, n3);
        return true;
    }

    public void a() {
        short[] sArray = new short[20];
        int n2 = 0;
        for (int i2 = 0; i2 < this.i.length; i2 += bk.a(this.i, i2, this.var_int_a, 5)) {
            sArray[n2++] = (short)i2;
        }
        this.var_short_arr_a = new short[n2];
        System.arraycopy(sArray, 0, this.var_short_arr_a, 0, this.var_short_arr_a.length);
        ((g)this).i = (byte)this.var_short_arr_a.length;
        this.h = 0;
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        int n4 = 0;
        g.a(graphics, n2, n3, false, true);
        graphics.setColor(0);
        graphics.fillRect(n2 + 5, n3 + 13, 110, 15);
        graphics.fillRect(n2 + 5, n3 + 30, 110, 82);
        n4 = bw.j - 43;
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, bw.i, n4, r.var_e_a.a(23), 0, 1);
        graphics.setColor(0x7F7F7F);
        if (((g)this).i > 1) {
            this.d(graphics, bw.i - 2, n4 + 17, 74);
        }
        short s2 = this.var_short_arr_a[this.h];
        short s3 = this.h == ((g)this).i - 1 ? (short)this.i.length : this.var_short_arr_a[this.h + 1];
        bk.a(graphics, bw.g - this.var_int_a >> 1, n4 + 23, this.var_int_a, 1, this.i, s2, 0, s3 - s2);
        bk.var_boolean_b = true;
        this.b(graphics, bw.i + (this.var_int_a >> 1), n4 + 15, this.h + 1, ((g)this).i);
    }
}

