/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class by
implements ax {
    public Image[] var_javax_microedition_lcdui_Image_arr_a;
    public byte[] i;
    public byte[] j;
    public int[] var_int_arr_a;
    public byte var_byte_a;

    public by(String string, String string2) {
        this.a(string2);
        this.b(string);
        this.var_byte_a = 0;
    }

    public final void a(String string) {
        bq bq2 = new bq(string);
        this.var_javax_microedition_lcdui_Image_arr_a = bq2.javax_microedition_lcdui_Image_arr_a();
        bq2 = null;
        System.gc();
    }

    public final void b(String string) {
        int n2;
        int n3;
        byte[] byArray = as.a(string);
        int n4 = 0;
        int n5 = byArray[n4++];
        n4 += n5;
        int n6 = 0;
        for (n3 = 0; n3 < n5; ++n3) {
            n6 = byArray[n4++] + byArray[n4++];
            n4 += n6;
        }
        n3 = byArray[n4++];
        this.var_int_arr_a = new int[n3];
        this.j = new byte[n3];
        byte by2 = 0;
        int n7 = n4;
        for (n2 = 0; n2 < n3; ++n2) {
            this.var_int_arr_a[n2] = n4 - n7;
            this.j[n2] = byArray[n4++];
            for (int i2 = 0; i2 < this.j[n2]; ++i2) {
                for (int i3 = 0; i3 < 4; ++i3) {
                    by2 = byArray[n4++];
                    n4 += 4 * by2;
                }
            }
        }
        n2 = n4 - n7;
        this.i = new byte[n2];
        System.arraycopy(byArray, n7, this.i, 0, n2);
    }

    public final void a(Graphics graphics, byte by2, byte by3, int n2, int n3) {
        int n4;
        int n5;
        int n6 = this.var_int_arr_a[by2];
        int n7 = 0;
        ++n6;
        if (this.var_byte_a >= this.j[by2]) {
            this.var_byte_a = 0;
        }
        for (n5 = 0; n5 < this.var_byte_a; ++n5) {
            for (n4 = 0; n4 < 4; ++n4) {
                n7 = this.i[n6++];
                n6 += n7 * 4;
            }
        }
        for (n5 = 0; n5 < by3 - 1; ++n5) {
            n7 = this.i[n6++];
            n6 += n7 * 4;
        }
        n5 = 0;
        n7 = this.i[n6++];
        for (n4 = 0; n4 < n7; ++n4) {
            n5 = this.i[n6 + 1];
            if (n5 > -1) {
                graphics.drawImage(this.var_javax_microedition_lcdui_Image_arr_a[n5], n2 + this.i[n6 + 2], n3 + this.i[n6 + 3], 20);
            }
            n6 += 4;
        }
        this.var_byte_a = (byte)(this.var_byte_a + 1);
    }
}

