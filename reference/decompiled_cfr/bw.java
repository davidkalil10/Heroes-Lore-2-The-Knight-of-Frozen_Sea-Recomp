/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Graphics
 */
import com.xce.lcdui.XDisplay;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public abstract class bw
extends Canvas {
    public static int g;
    public static int h;
    public static int i;
    public static int j;
    public static int k;
    public static int l;
    public static Graphics var_javax_microedition_lcdui_Graphics_a;
    public boolean f;
    public int m;
    public byte var_byte_a;

    public bw() {
        this.setFullScreenMode(true);
        this.f = false;
        this.m = 0;
        this.var_byte_a = (byte)-1;
        g = XDisplay.width;
        h = XDisplay.height2;
        i = g >> 1;
        j = h >> 1;
    }

    public void g() {
    }

    public void void_a() {
    }

    public final void h() {
        this.f = false;
        if (this.m != 0) {
            this.keyReleased(this.m);
            this.m = 0;
        }
    }

    public final void a(Graphics graphics) {
        graphics.setColor(0);
        graphics.fillRect(0, 0, g, h);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_o[1], i, j + 3, 33);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, i, j + 2 + 3, "V.1.0.2".getBytes(), 0, 1);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_o[2], 5, 5, 20);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_o[0], i, h - 26, 17);
    }

    public final void a(Graphics graphics, int n2, boolean bl2) {
        if (l == 3) {
            if (bl2) {
                graphics.setClip(0, 0, g, h);
                graphics.setColor(0);
                graphics.fillRect(0, 0, g, h);
            }
            graphics.setColor(14663551);
            bk.a(graphics, i - 48, n2 - 12, as.var_e_a.a(38), 0);
            graphics.drawLine(i - 50, n2, i + 48, n2);
            graphics.fillRect(i - 51, n2 + 1, 2, 2);
            graphics.fillRect(i + 48, n2 + 1, 2, 2);
            graphics.setColor(10452799);
            graphics.drawLine(i - 50, n2 + 5, i + 48, n2 + 5);
            graphics.fillRect(i - 51, n2 + 3, 2, 2);
            graphics.fillRect(i + 48, n2 + 3, 2, 2);
        }
        if (l > 3) {
            graphics.setClip(0, 0, g, h);
            graphics.setColor(0);
            graphics.fillRect(i + 23, n2 - 12, 18, 10);
            graphics.setColor(14663551);
            bk.a(graphics, i + 23, n2 - 12, "...".substring(0, l % 4).getBytes(), 0);
            graphics.setColor(14655295);
            graphics.fillRect(i - 48, n2 + 2, 95 * (k < 100 ? k : 100) / 100, 1);
            graphics.setColor(0xFFFF7F);
            graphics.fillRect(i - 48, n2 + 3, 95 * (k < 100 ? k : 100) / 100, 1);
        } else if (l < 3) {
            graphics.setColor(0);
            int n3 = (h + 11) / 12;
            for (int i2 = 0; i2 < n3; ++i2) {
                graphics.fillRect(0, i2 * 12 + l * 4, g, 4);
            }
        }
        l = l < 100 ? ++l : 4;
    }

    public final void a(boolean bl2) {
        cj.var_cj_a.g();
        if (bl2) {
            if (l < 3) {
                l = 3;
            }
        } else {
            k = 0;
            l = 0;
        }
    }

    static {
        k = 0;
        l = 0;
    }
}

