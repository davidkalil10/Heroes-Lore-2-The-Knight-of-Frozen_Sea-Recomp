/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class f
implements ax {
    public static Random a = new Random();

    public static final int a(int n2, int n3) {
        int n4 = n3 - n2 + 1;
        if (n4 < 2) {
            return n2;
        }
        int n5 = Math.abs(a.nextInt()) % n4;
        return n2 + n5;
    }

    public static final byte[] a(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
        return byArray3;
    }

    public static final int int_a(byte[] byArray, int n2) {
        return (byArray[n2] & 0xFF) << 24 | (byArray[n2 + 1] & 0xFF) << 16 | (byArray[n2 + 2] & 0xFF) << 8 | byArray[n2 + 3] & 0xFF;
    }

    public static final int int_b(byte[] byArray, int n2) {
        return (byArray[n2 + 3] & 0xFF) << 24 | (byArray[n2 + 2] & 0xFF) << 16 | (byArray[n2 + 1] & 0xFF) << 8 | byArray[n2] & 0xFF;
    }

    public static final short short_a(byte[] byArray, int n2) {
        return (short)((byArray[n2 + 1] & 0xFF) << 8 | byArray[n2] & 0xFF);
    }

    public static final short short_b(byte[] byArray, int n2) {
        return (short)((byArray[n2] & 0xFF) << 8 | byArray[n2 + 1] & 0xFF);
    }

    public static final void a(int n2, byte[] byArray, int n3) {
        byte[] byArray2 = new byte[]{0, 0, 0, 0};
        int n4 = n2 & 0xFFFFFFFF;
        byArray2[0] = (byte)(n4 >> 24 & 0xFF);
        byArray2[1] = (byte)(n4 >> 16 & 0xFF);
        byArray2[2] = (byte)(n4 >> 8 & 0xFF);
        byArray2[3] = (byte)(n4 & 0xFF);
        System.arraycopy(byArray2, 0, byArray, n3, 4);
    }

    public static final void a(short s2, byte[] byArray, int n2) {
        byArray[n2] = (byte)(s2 >> 8 & 0xFF);
        byArray[n2 + 1] = (byte)(s2 & 0xFF);
    }

    public static final void a(Graphics graphics, int n2, int n3, int n4, int n5, int n6) {
        byte[] byArray = new byte[9];
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        Image image = null;
        boolean bl2 = false;
        if (n6 == 0) {
            image = as.var_javax_microedition_lcdui_Image_a;
        } else {
            image = as.var_javax_microedition_lcdui_Image_arr_m[n6 - 1];
            bl2 = true;
        }
        n7 = image.getWidth() / 10;
        n8 = n7 - 1;
        n9 = image.getHeight();
        int n10 = 0;
        do {
            byte by2 = (byte)(n2 % 10);
            int n11 = n10;
            n10 = (byte)(n10 + 1);
            byArray[n11] = by2;
        } while ((n2 /= 10) != 0);
        int n12 = n3;
        if (n5 == 1) {
            n12 -= n10 * n8 / 2;
        } else if (n5 == 8) {
            n12 -= n10 * n8;
        }
        for (int i2 = 0; i2 < n10; ++i2) {
            if (bl2) {
                bd.var_bd_a.c();
                graphics.clipRect(n12 + i2 * n8, n4, n7, n9);
            } else {
                graphics.setClip(n12 + i2 * n8, n4, n7, n9);
            }
            graphics.drawImage(image, n12 + i2 * n8 - byArray[n10 - i2 - 1] * n7, n4, 20);
        }
        bd.var_bd_a.c();
    }
}

