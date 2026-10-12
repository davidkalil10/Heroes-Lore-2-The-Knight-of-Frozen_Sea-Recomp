/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public class cc
extends bl {
    public byte a;

    public cc(byte by2, short s2, short s3) {
        super(s2, s3, (byte)0, (byte)0);
        this.a = by2;
    }

    public void b(int n2, int n3) {
        if (ah.var_boolean_b || !this.e) {
            return;
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        int n4 = n2 + this.var_short_c + this.var_byte_f;
        int n5 = n3 + this.var_short_d + this.g;
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_b[this.a], n4, n5, 33);
    }

    public final void a(byte by2) {
        this.a = u.var_ah_a.byte_a(by2);
    }
}

