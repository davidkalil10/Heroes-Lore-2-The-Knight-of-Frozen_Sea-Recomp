/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public class bc
extends bl {
    public byte var_byte_a;
    public ao var_ao_a;

    public bc(byte by2, short s2, short s3) {
        super(s2, s3, (byte)8, (byte)8);
        this.var_ao_a = ah.var_ao_arr_a[by2];
        this.var_byte_a = 0;
    }

    public void b(int n2, int n3) {
        if (ah.var_boolean_b) {
            return;
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        int n4 = n2 + this.var_short_c + this.var_ao_a.b[this.var_byte_a];
        int n5 = n3 + this.var_short_d + this.var_ao_a.c[this.var_byte_a];
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_b[this.var_ao_a.var_byte_arr_a[this.var_byte_a]], n4, n5, 33);
        this.var_byte_a = (byte)(this.var_byte_a + 1);
        if (this.var_byte_a >= this.var_ao_a.var_byte_a) {
            this.var_byte_a = 0;
        }
    }
}

