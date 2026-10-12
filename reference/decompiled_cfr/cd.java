/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class cd
extends bw
implements Runnable,
ax {
    public static cd var_cd_a;
    private byte b = 0;
    public Image[] var_javax_microedition_lcdui_Image_arr_a;
    public int var_int_a;

    public static cd cd_a() {
        if (var_cd_a == null) {
            var_cd_a = new cd();
        }
        return var_cd_a;
    }

    public cd() {
        bk.a();
        as.var_e_a = new e("/t/com");
        cj.var_cj_a.i();
        if (!cj.e) {
            as.var_e_b = new e("/t/try");
        }
        af.void_a();
        ak.b((byte)1);
        this.var_int_a = 0;
        this.a((byte)2);
    }

    public void void_a() {
        if (this.b == 1) {
            ak.a();
        }
        bw.l = 3;
    }

    public void run() {
        if (this.b == 3) {
            switch (this.var_byte_a) {
                case 1: {
                    as.var_as_a.e();
                    as.var_as_a.p();
                    cj.var_cj_a.e();
                }
            }
            this.var_byte_a = 0;
        }
    }

    public void keyPressed(int n2) {
        if (n2 == -7) {
            n2 = 8;
        }
        this.origKeyPressed0(n2);
    }

    public void paint(Graphics graphics) {
        bw.var_javax_microedition_lcdui_Graphics_a = graphics;
        switch (this.b) {
            case 2: {
                this.b(bw.var_javax_microedition_lcdui_Graphics_a);
                break;
            }
            case 1: {
                this.c(bw.var_javax_microedition_lcdui_Graphics_a);
                break;
            }
            case 3: {
                this.a(bw.var_javax_microedition_lcdui_Graphics_a, bw.j, true);
            }
        }
        cj.var_cj_a.void_a();
    }

    private final void a(byte by2) {
        switch (by2) {
            case 2: {
                this.a("/img/logo");
                as.var_as_a.p();
                cj.var_cj_a.a(20);
                break;
            }
            case 1: {
                ak.i = (byte[])ak.var_java_lang_Object_arr_a[1];
                ak.a();
                break;
            }
            case 3: {
                cj.var_cj_a.g();
            }
        }
        this.b = by2;
    }

    public final void a(String string) {
        this.b();
        bq bq2 = new bq(string);
        this.var_javax_microedition_lcdui_Image_arr_a = bq2.javax_microedition_lcdui_Image_arr_a();
    }

    public final void b() {
        if (this.var_javax_microedition_lcdui_Image_arr_a != null) {
            this.var_javax_microedition_lcdui_Image_arr_a = null;
        }
    }

    private void b(Graphics graphics) {
        graphics.setColor(0);
        graphics.fillRect(0, 0, bw.g, bw.h);
        ++this.var_int_a;
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_arr_a[5], bw.i, bw.j - 20, 3);
        graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_o[0], bw.i, bw.j + 30, 3);
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_arr_a[0], bw.i, bw.h - 22, 17);
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_arr_a[1], bw.i - 43, bw.h - 12 + f.a(0, 1), 20);
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_arr_a[1], bw.i - 43 + 12, bw.h - 12 + f.a(0, 1), 20);
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_arr_a[2], bw.i - 43 + 24, bw.h - 12 + f.a(0, 1), 20);
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_arr_a[2], bw.i - 43 + 36, bw.h - 12 + f.a(0, 1), 20);
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_arr_a[2], bw.i - 43 + 48, bw.h - 12 + f.a(0, 1), 20);
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_arr_a[3], bw.i - 43 + 60, bw.h - 8, 20);
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_arr_a[4], bw.i - 43 + 60 + 7, bw.h - 12, 20);
        if (this.var_int_a > 100) {
            this.a((byte)1);
        }
    }

    private void c(Graphics graphics) {
        this.a(graphics);
        if (this.var_int_a % 10 < 8) {
            bk.a(graphics, bw.i, bw.j + (bw.j >> 1) - 14 + 3, "PRESS ANY KEY".getBytes(), 0, 1);
        }
        ++this.var_int_a;
        if (this.var_int_a > 124) {
            this.var_int_a = 3;
        }
    }

    private void c() {
        this.a(false);
        this.var_byte_a = 1;
        this.a((byte)3);
        new Thread(this).start();
    }

    private void origKeyPressed0(int n2) {
        if (cj.var_cj_a == null || cj.var_boolean_a) {
            return;
        }
        switch (this.b) {
            case 2: {
                if (this.var_int_a <= 30) break;
                this.a((byte)1);
                break;
            }
            case 1: {
                this.c();
            }
        }
    }
}

