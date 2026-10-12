/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import com.skt.m.Device;
import javax.microedition.lcdui.Graphics;
import rpg.RPGHero2;

public class bg
extends g {
    public static int var_int_a;
    public static int b;
    public static bg var_bg_a;
    public boolean var_boolean_a = false;

    public static bg bg_a() {
        u.var_u_a.k();
        if (var_bg_a == null) {
            var_bg_a = new bg(u.var_byte_b > 0);
        }
        return var_bg_a;
    }

    public static void void_a() {
        if (var_bg_a != null) {
            var_bg_a = null;
        }
        u.var_java_lang_Object_arr_a = null;
        System.gc();
    }

    public bg(boolean bl2) {
        super(null, (byte)9);
        var_int_a = bw.i - 60;
        b = bw.j - 58;
        this.h = (byte)(bl2 ? 1 : 0);
        this.var_boolean_a = bl2;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (this.boolean_d(n2, n3)) {
            if (!this.var_boolean_a && this.h == 1) {
                this.h = n2 == 5 || n3 == 54 ? (byte)(this.h + 1) : (byte)(this.h - 1);
            }
            this.l = 0;
            return true;
        }
        if (n2 == 8 || n3 == 53) {
            switch (this.h) {
                case 0: {
                    ((g)this).b = new ca(this, 10);
                    break;
                }
                case 1: {
                    ((g)this).b = new ca(this, 1);
                    break;
                }
                case 2: {
                    ((g)this).b = new l((g)this, false);
                    break;
                }
                case 3: {
                    ((g)this).b = new ai((g)this, false);
                    break;
                }
                case 4: {
                    if (!this.var_boolean_a) {
                        ((g)this).b = new bx((g)this, as.var_e_a.a(50));
                        break;
                    }
                    ((g)this).b = new ca(this, 4);
                    break;
                }
                case 5: {
                    this.a((byte)2, 2, as.var_e_a.a(58, 59, 60, 61));
                    break;
                }
                case 6: {
                    this.a((byte)2, 2, as.var_e_a.a(52, 53, 54, 55));
                    break;
                }
                case 7: {
                    this.a((byte)2, 2, as.var_e_a.a(36, 53, 54, 55));
                    break;
                }
                case 8: {
                    RPGHero2.var_rpg_RPGHero2_a.destroyApp(true);
                }
            }
        }
        return false;
    }

    public void a(byte by2, byte by3) {
        this.b(by3);
        if (by2 == 2 && by3 == 0) {
            switch (this.h) {
                case 5: {
                    Device.invokeWapBrowser("http://skt.mforma.co.kr/skt/444/hero2/network_down.asp");
                    break;
                }
                case 6: {
                    Device.invokeWapBrowser("http://mplayonwap.nate.com/p.jsp?page_ID=0039117532&PID=0026802760");
                    break;
                }
                case 7: {
                    Device.invokeWapBrowser("http://www.sk01.co.kr/vm/main.asp?genre_kubun=0106&game_kubun=148&SU=0000000000&SM=0000000");
                }
            }
        }
    }

    public final void b() {
        this.void_c(var_int_a, b);
        if (this.l < 3 && ((g)this).b == null) {
            this.e = true;
            this.l = (byte)(this.l + 1);
        }
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        bd.var_bd_a.a(graphics);
        n3 = bw.j + (bw.j >> 1) - 12;
        this.a(graphics, bw.i, n3, true);
        if (this.l < 3) {
            graphics.setColor(50 + 50 * this.l, 50 + 50 * this.l, 50 + 50 * this.l);
        } else {
            graphics.setColor(0xFFFFFF);
        }
        bk.a(graphics, bw.i, n3 + 3, as.var_e_a.a(this.h), 0, 1);
    }

    static {
        var_bg_a = null;
    }
}

