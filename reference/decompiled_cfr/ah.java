/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class ah
implements ax {
    private static byte f = (byte)2;
    private static final int[] var_int_arr_a;
    public static byte var_byte_a;
    public byte var_byte_b;
    public byte var_byte_c = (byte)-1;
    public byte[] i;
    private Image var_javax_microedition_lcdui_Image_a;
    private byte g;
    public static byte var_byte_d;
    public static byte var_byte_e;
    public static short var_short_a;
    public static short var_short_b;
    public static boolean var_boolean_a;
    public static int var_int_a;
    public static boolean var_boolean_b;
    public int var_int_b;
    public int var_int_c;
    public byte[][] var_byte_arr_arr_b;
    public byte[][] var_byte_arr_arr_c;
    private bl var_bl_a;
    private bl var_bl_b;
    private int var_int_d;
    public bl[][] var_bl_arr_arr_a;
    public cc[] var_cc_arr_a;
    public cc[] var_cc_arr_b;
    public cc[] var_cc_arr_c;
    public bc[] var_bc_arr_a;
    public static ao[] var_ao_arr_a;
    public bj[] var_bj_arr_a;
    private Vector var_java_util_Vector_a;
    private int var_int_e;
    public static Object[] var_java_lang_Object_arr_a;
    public static Object[] var_java_lang_Object_arr_b;
    public static Object[] var_java_lang_Object_arr_c;
    public static Object[] var_java_lang_Object_arr_d;
    private Vector var_java_util_Vector_b;

    public ah(byte by2) {
        this.var_byte_b = by2;
        var_boolean_a = false;
        this.var_bl_a = null;
        this.var_bl_b = null;
        this.var_int_d = 0;
        this.var_int_e = 16;
        this.var_java_util_Vector_a = new Vector();
        this.var_java_util_Vector_b = new Vector();
        f = bw.g >= 240 ? (byte)3 : (byte)2;
    }

    public final void void_a() {
        if (var_boolean_a) {
            this.a(true, (byte)3);
        }
        for (int i2 = this.var_java_util_Vector_b.size() - 1; i2 >= 0; --i2) {
            byte[] byArray = (byte[])this.var_java_util_Vector_b.elementAt(i2);
            byArray[5] = (byte)(byArray[5] - 1);
            if (byArray[5] >= 0) continue;
            this.var_java_util_Vector_b.removeElementAt(i2);
        }
        bl bl2 = this.var_bl_a;
        while (bl2 != null) {
            if (bl2 instanceof cc) {
                bl2 = bl2.b;
                continue;
            }
            if (bl2 instanceof ag && !bl2.var_boolean_f) {
                ag ag2 = (ag)bl2;
                ag2.f();
                bl2 = bl2.b;
                this.b(ag2);
                if (ag2.var_byte_s != 7) continue;
                this.c(ag2);
                ag2 = null;
                continue;
            }
            if (bl2.var_boolean_f) {
                bl2.var_boolean_f = false;
                bl2 = bl2.b;
                continue;
            }
            bl2 = bl2.b;
        }
    }

    public final void b() {
        if (this.var_bj_arr_a == null) {
            return;
        }
        for (int i2 = 0; i2 < this.var_bj_arr_a.length; ++i2) {
            this.var_bj_arr_a[i2].a();
            this.b(this.var_bj_arr_a[i2]);
        }
    }

    public final void c() {
        bl bl2 = this.var_bl_a;
        while (bl2 != null) {
            if (bl2 instanceof ag && !bl2.var_boolean_f) {
                ag ag2 = (ag)bl2;
                ag2.var_byte_v = (byte)(ag2.var_byte_v + 1);
                ag2.p();
                bl2 = bl2.b;
                this.b(ag2);
                continue;
            }
            if (bl2.var_boolean_f) {
                bl2.var_boolean_f = false;
                bl2 = bl2.b;
                continue;
            }
            bl2 = bl2.b;
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void a(byte[] byArray) {
        byte by2;
        byte by3;
        int n2;
        int n3;
        int n4;
        int n5;
        Object object;
        int n6;
        byte by4;
        byte by5;
        int n32 = 0;
        boolean by6 = false;
        byte by7 = 0;
        byte by8 = this.var_byte_c;
        this.var_byte_c = byArray[n32++];
        if (u.h == 110) {
            this.var_byte_c = (byte)3;
        }
        as.var_as_a.b(this.var_byte_c != by8);
        ++bw.k;
        byte by9 = byArray[n32++];
        this.i = new byte[by9];
        System.arraycopy(byArray, n32, this.i, 0, by9);
        n32 += by9;
        ++bw.k;
        byte by10 = byArray[n32++];
        bq bq2 = null;
        if (by10 > 0) {
            void var8_21;
            as.var_javax_microedition_lcdui_Image_arr_c = new Image[by10];
            bq2 = new bq("/img/face");
            bq2.a(true);
            by5 = -1;
            boolean bl2 = false;
            while (var8_21 < by10) {
                by5 = byArray[n32++];
                as.var_javax_microedition_lcdui_Image_arr_c[var8_21] = bq2.javax_microedition_lcdui_Image_a(by5);
                ++bw.k;
                ++var8_21;
            }
        }
        byte by11 = byArray[n32++];
        as.var_javax_microedition_lcdui_Image_arr_b = new Image[by11];
        as.var_byte_arr_i = new byte[by11];
        bq2 = new bq("/m/obj");
        bq2.a(true);
        for (by5 = 0; by5 < by11; ++by5) {
            as.var_byte_arr_i[by5] = byArray[n32++];
            as.var_javax_microedition_lcdui_Image_arr_b[by5] = bq2.javax_microedition_lcdui_Image_a(as.var_byte_arr_i[by5]);
            ++bw.k;
        }
        var_byte_d = byArray[n32++];
        var_byte_e = byArray[n32++];
        this.var_bl_arr_arr_a = new bl[var_byte_e][var_byte_d];
        var_short_a = (short)(var_byte_d << 4);
        var_short_b = (short)(var_byte_e << 4);
        this.var_byte_arr_arr_b = new byte[var_byte_e][var_byte_d];
        for (by5 = 0; by5 < var_byte_e; ++by5) {
            System.arraycopy(byArray, n32, this.var_byte_arr_arr_b[by5], 0, var_byte_d);
            n32 += var_byte_d;
        }
        ++bw.k;
        this.var_byte_arr_arr_c = new byte[var_byte_e][var_byte_d];
        for (by5 = 0; by5 < var_byte_e; ++by5) {
            System.arraycopy(byArray, n32, this.var_byte_arr_arr_c[by5], 0, var_byte_d);
            n32 += var_byte_d;
        }
        ++bw.k;
        if ((by4 = byArray[n32++]) > 0) {
            var_ao_arr_a = new ao[by4];
            for (by5 = 0; by5 < by4; ++by5) {
                by7 = byArray[n32++];
                byte[] byArray2 = new byte[by7 * 3];
                System.arraycopy(byArray, n32, byArray2, 0, by7 * 3);
                ah.var_ao_arr_a[by5] = new ao(by7, byArray2);
                n32 += by7 * 3;
            }
            ++bw.k;
        }
        int n7 = byArray[n32++] & 0xFF;
        by5 = 0;
        boolean bl3 = false;
        short s2 = 0;
        if (n7 > 0) {
            this.var_cc_arr_a = new cc[n7];
            for (n6 = 0; n6 < n7; ++n6) {
                by5 = byArray[n32];
                short s3 = f.short_a(byArray, n32 + 1);
                s2 = f.short_a(byArray, n32 + 3);
                n32 += 5;
                object = new cc(this.byte_a(by5), s3, s2);
                this.f((bl)object);
                this.b((bl)object);
                this.var_cc_arr_a[n6] = object;
                object = null;
            }
            bw.k += 3;
        }
        if ((n5 = byArray[n32++] & 0xFF) > 0) {
            this.var_cc_arr_b = new cc[n5];
            for (n6 = 0; n6 < n5; ++n6) {
                by5 = byArray[n32];
                short s4 = f.short_a(byArray, n32 + 1);
                s2 = f.short_a(byArray, n32 + 3);
                n32 += 5;
                this.var_cc_arr_b[n6] = new cc(this.byte_a(by5), s4, s2);
                ++bw.k;
            }
        }
        if ((n4 = byArray[n32++] & 0xFF) > 0) {
            this.var_cc_arr_c = new cc[n4];
            for (n6 = 0; n6 < n4; ++n6) {
                by5 = byArray[n32];
                short s5 = f.short_a(byArray, n32 + 1);
                s2 = f.short_a(byArray, n32 + 3);
                n32 += 5;
                this.var_cc_arr_c[n6] = new cc(this.byte_a(by5), s5, s2);
            }
        }
        ++bw.k;
        if ((n3 = byArray[n32++] & 0xFF) > 0) {
            this.var_bc_arr_a = new bc[n3];
            for (n6 = 0; n6 < n3; ++n6) {
                by5 = byArray[n32];
                short s6 = f.short_a(byArray, n32 + 1);
                s2 = f.short_a(byArray, n32 + 3);
                n32 += 5;
                object = new bc(this.byte_a(by5), s6, s2);
                this.f((bl)object);
                this.b((bl)object);
                this.var_bc_arr_a[n6] = object;
                object = null;
            }
            ++bw.k;
        }
        byte by12 = byArray[n32++];
        byte[] byArray3 = new byte[by12];
        if (by12 > 0) {
            var_boolean_a = true;
            as.d(by12);
            object = null;
            n2 = 0;
            for (by3 = 0; by3 < by12; by3 = (byte)(by3 + 1)) {
                byArray3[by3] = n2 = byArray[n32++];
                object = as.a("/enm/enm", n2);
                ay.a((byte[])object, by3, (byte)n2);
                ++bw.k;
            }
        }
        int n8 = byArray[n32++];
        for (int i2 = 0; i2 < n8; ++i2) {
            for (n2 = 0; n2 < byArray3.length; n2 = (byte)(n2 + 1)) {
                if (byArray3[n2] >= 89) {
                    if (byArray3[n2] == byArray[n32]) {
                        this.a(byArray3[n2], (int)byArray[n32 + 1], (int)byArray[n32 + 2]);
                    }
                } else if (byArray3[n2] == byArray[n32]) {
                    this.a(n2, 0, (int)byArray[n32 + 1], (int)byArray[n32 + 2]);
                    break;
                }
                ++bw.k;
            }
            n32 += 3;
        }
        byte by13 = byArray[n32++];
        byte[] byArray4 = new byte[by13];
        if (by13 > 0) {
            byte[] byArray5 = as.a("/npc/npc");
            as.var_as_a.c(by13);
            for (by3 = 0; by3 < by13; by3 = (byte)(by3 + 1)) {
                byArray4[by3] = byArray[n32++];
                as.var_as_a.a(byArray5, byArray4[by3], by3);
                ++bw.k;
            }
        }
        if ((by2 = byArray[n32++]) > 0) {
            this.var_bj_arr_a = new bj[by2];
            byte by14 = 0;
            for (byte by15 = 0; by15 < by2; by15 = (byte)(by15 + 1)) {
                byte by16 = byArray[n32++];
                n2 = byArray[n32++];
                by3 = byArray[n32++];
                for (byte by17 = 0; by17 < byArray4.length; by17 = (byte)((byte)(by17 + 1))) {
                    if (by16 != byArray4[by17]) continue;
                    by14 = by17;
                    break;
                }
                bj bj2 = new bj((short)(n2 * 16), (short)(by3 * 16), by16, by14);
                this.f(bj2);
                this.b(bj2);
                bj2.t();
                this.var_bj_arr_a[by15] = bj2;
                bj2 = null;
                ++bw.k;
            }
        }
        this.a(byArray, n32);
        this.a(this.var_byte_c != by8);
        if (this.i != null && this.i.length > 0) {
            n2 = bk.a(this.i) + 1;
            this.var_javax_microedition_lcdui_Image_a = Image.createImage((int)n2, (int)16);
            Graphics graphics = this.var_javax_microedition_lcdui_Image_a.getGraphics();
            graphics.setColor(0);
            graphics.fillRect(0, 0, n2, 16);
            graphics.setColor(0x777777);
            bk.a(graphics, 1, 1, this.i, 1);
            graphics.setColor(0xFFFFFF);
            bk.a(graphics, 0, 0, this.i, 1);
            this.g = (byte)10;
        } else {
            this.g = 0;
        }
        ++bw.k;
        n2 = u.h;
        int n9 = 0;
        n9 = n2 == 74 ? -1 : (n2 == 72 || n2 == 110 ? 8 : (n2 == 76 ? 7 : (n2 == 67 ? 6 : (n2 == 64 ? 5 : (n2 == 15 ? 4 : (n2 >= 101 ? 15 : (n2 >= 98 ? 11 : (n2 >= 84 ? 14 : (n2 >= 79 ? 12 : (n2 >= 65 ? 3 : (n2 >= 29 ? 13 : (n2 >= 18 ? 10 : (n2 == 0 || n2 == 2 || n2 == 8 || n2 == 14 ? 2 : 9)))))))))))));
        ++bw.k;
        if (n9 >= 0) {
            ak.b((byte)n9);
            ak.i = (byte[])ak.var_java_lang_Object_arr_a[n9];
            ak.var_long_a = 0L;
        } else {
            ak.c();
            ak.i = null;
        }
        ++bw.k;
    }

    private final int a(byte[] byArray, int n2) {
        int n3;
        int n4;
        int n5;
        byte[][] byArray2;
        int n6;
        int n7;
        int n8;
        int n9 = byArray[n2++] & 0xFF;
        var_java_lang_Object_arr_a = new Object[n9];
        int n10 = 0;
        for (n8 = 0; n8 < n9; ++n8) {
            if ((n10 = byArray[n2++] & 0xFF) > 0) {
                byte[][] byArray3 = new byte[n10][31];
                for (n7 = 0; n7 < n10; ++n7) {
                    System.arraycopy(byArray, n2, byArray3[n7], 0, 31);
                    n2 += 31;
                }
                ah.var_java_lang_Object_arr_a[n8] = byArray3;
            }
            ++bw.k;
        }
        n8 = byArray[n2++] & 0xFF;
        var_java_lang_Object_arr_d = new Object[n8];
        int n11 = 0;
        for (n7 = 0; n7 < n8; ++n7) {
            n11 = byArray[n2++] & 0xFF;
            ah.var_java_lang_Object_arr_d[n7] = new byte[n11];
            System.arraycopy(byArray, n2, var_java_lang_Object_arr_d[n7], 0, n11);
            n2 += n11;
        }
        ++bw.k;
        n7 = byArray[n2++] & 0xFF;
        var_java_lang_Object_arr_b = new Object[n7];
        int n12 = 0;
        for (n6 = 0; n6 < n7; ++n6) {
            if ((n12 = byArray[n2++] & 0xFF) <= 0) continue;
            byArray2 = new byte[n12][3];
            for (n5 = 0; n5 < n12; ++n5) {
                System.arraycopy(byArray, n2, byArray2[n5], 0, 3);
                n2 += 3;
            }
            ah.var_java_lang_Object_arr_b[n6] = byArray2;
        }
        ++bw.k;
        n7 = byArray[n2++] & 0xFF;
        var_java_lang_Object_arr_c = new Object[n7];
        for (n6 = 0; n6 < n7; ++n6) {
            if ((n12 = byArray[n2++] & 0xFF) <= 0) continue;
            byArray2 = new byte[n12][3];
            for (n5 = 0; n5 < n12; ++n5) {
                System.arraycopy(byArray, n2, byArray2[n5], 0, 3);
                n2 += 3;
            }
            ah.var_java_lang_Object_arr_c[n6] = byArray2;
        }
        ++bw.k;
        n9 = byArray[n2++] & 0xFF;
        n6 = -1;
        int n13 = 0;
        n5 = 1;
        int n14 = -1;
        if (n9 > 0) {
            for (n4 = 0; n4 < n9; ++n4) {
                n5 = 1;
                n6 = byArray[n2++];
                for (n3 = 0; n3 < 3; ++n3) {
                    if ((n13 = byArray[n2++] & 0xFF) <= 0 || u.var_u_a.boolean_a(n13)) continue;
                    n5 = 0;
                }
                if (n5 == 0) continue;
                n14 = n6;
                n2 += (n9 - n4 - 1) * 4;
                break;
            }
        }
        ++bw.k;
        if (n14 > -1) {
            n7 = byArray[n2++] & 0xFF;
            n4 = 0;
            for (n3 = 0; n3 < n14; ++n3) {
                n4 = byArray[n2++];
                n2 += n4 * 4;
            }
            n4 = byArray[n2++];
            for (n3 = 0; n3 < n4; ++n3) {
                this.b(byArray[n2], byArray[n2 + 1], byArray[n2 + 2], byArray[n2 + 3]);
                n2 += 4;
            }
        }
        ++bw.k;
        return n2;
    }

    private void b(byte by2, byte by3, byte by4, byte by5) {
        switch (by2) {
            case 0: {
                cc cc2 = this.var_cc_arr_a[by3 & 0xFF];
                cc2.a((short)((by4 & 0xFF) << 4), (short)((by5 & 0xFF) << 4));
                break;
            }
            case 1: {
                this.void_a((byte)(by3 & 0xFF), (byte)(by4 & 0xFF));
                break;
            }
            case 2: {
                this.void_a(by3);
                break;
            }
            case 3: {
                bc bc2 = this.var_bc_arr_a[by3 & 0xFF];
                bc2.a((short)((by4 & 0xFF) << 4), (short)((by5 & 0xFF) << 4));
                break;
            }
            case 4: {
                bc bc3 = this.var_bc_arr_a[by3 & 0xFF];
                bc3.var_ao_a = var_ao_arr_a[by4 & 0xFF];
                break;
            }
            case 5: {
                bc bc4 = this.var_bc_arr_a[by3 & 0xFF];
                this.c(bc4);
                this.var_bc_arr_a[by3 & 0xFF] = null;
                break;
            }
            case 6: {
                this.a(by3, by4, by5);
                break;
            }
            case 8: {
                this.b(by3, by4, by5);
                break;
            }
            case 9: {
                bj bj2 = this.var_bj_arr_a[by3 & 0xFF];
                bj2.u();
                bj2.a((short)((by4 & 0xFF) << 4), (short)((by5 & 0xFF) << 4));
                bj2.void_c();
                bj2.t();
                u.var_ah_a.b(bj2);
                break;
            }
            case 10: {
                this.c(by3, by4);
                break;
            }
            case 11: {
                bj bj3 = this.var_bj_arr_a[by3 & 0xFF];
                bj3.var_boolean_a = false;
                bj3.u();
                break;
            }
            case 12: {
                ae.var_ae_a.b(by3);
                break;
            }
            case 13: {
                this.b(by4, by3);
                break;
            }
            case 15: {
                u.var_b_a.var_boolean_g = false;
            }
        }
    }

    public void void_a(byte by2, byte by3) {
        cc cc2 = this.var_cc_arr_a[by2];
        cc2.a(by3);
    }

    public void void_a(byte by2) {
        cc cc2 = this.var_cc_arr_a[by2];
        this.c(cc2);
        this.var_cc_arr_a[by2] = null;
    }

    public void a(byte by2, byte by3, byte by4) {
        this.var_byte_arr_arr_b[by3][by2] = (byte)(by4 + 1);
    }

    public void b(byte by2, byte by3, byte by4) {
        this.var_byte_arr_arr_c[by3][by2] = by4;
    }

    public void b(byte by2, byte by3) {
        bj bj2 = this.var_bj_arr_a[by3];
        bj2.s();
        if (by2 > 0) {
            bj2.b(new bh(-6, by2));
        }
    }

    public void c(byte by2, byte by3) {
        bj bj2 = this.var_bj_arr_a[by2 & 0xFF];
        bj2.b = by3;
    }

    private void a(boolean bl2) {
        if (bl2 || as.var_javax_microedition_lcdui_Image_arr_a == null) {
            bq bq2 = new bq("/m/t" + (this.var_byte_c < 10 ? "0" : "") + this.var_byte_c);
            as.var_javax_microedition_lcdui_Image_arr_a = bq2.javax_microedition_lcdui_Image_arr_a();
        }
    }

    public static void d() {
        var_java_lang_Object_arr_a = null;
        var_java_lang_Object_arr_b = null;
        var_java_lang_Object_arr_c = null;
        var_java_lang_Object_arr_d = null;
        System.gc();
    }

    public final void e() {
        int n2;
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        int n3 = cj.d ? u.var_int_d : u.var_int_b;
        int n4 = cj.d ? u.var_int_e : u.var_int_c;
        int n5 = bd.var_int_a;
        int n6 = bd.var_int_b;
        if (n3 > 0) {
            n3 = 0;
        }
        if (n4 > 0) {
            n4 = 0;
        }
        if (n3 < n5 - var_short_a) {
            n3 = n5 - var_short_a;
        }
        if (n4 < n6 - var_short_b) {
            n4 = n6 - var_short_b;
        }
        if (n3 > 0) {
            n3 = n5 - var_short_a >> 1;
            graphics.setColor(0);
            graphics.fillRect(0, 0, n5, n6);
        }
        if (n4 > 0) {
            n4 = n6 - var_short_b >> 1;
            graphics.setColor(0);
            graphics.fillRect(0, 0, n5, n6);
        }
        graphics.setClip(0, 0, n5, n6);
        graphics.setColor(0);
        graphics.fillRect(0, 0, n5, n6);
        graphics.setClip(0, 0, n5, n6);
        if (this.var_int_b != 0) {
            n3 += this.var_int_b;
            this.var_int_b = 0;
        }
        if (this.var_int_c != 0) {
            n4 += this.var_int_c;
            this.var_int_c = 0;
        }
        int n7 = -n3 / 16;
        int n8 = -n4 / 16;
        int n9 = (n5 - n3 - 1) / 16;
        int n10 = (n6 - n4 - 1) / 16;
        if (n7 < 0) {
            n7 = 0;
        }
        if (n8 < 0) {
            n8 = 0;
        }
        if (n9 >= var_byte_d) {
            n9 = var_byte_d - 1;
        }
        if (n10 >= var_byte_e) {
            n10 = var_byte_e - 1;
        }
        if (!var_boolean_b) {
            int n11;
            byte by2 = 0;
            n2 = as.var_javax_microedition_lcdui_Image_arr_a.length;
            for (n11 = n8; n11 <= n10; ++n11) {
                int n12 = n4 + n11 * 16;
                int n13 = n3 + n7 * 16;
                for (int i2 = n7; i2 <= n9; ++i2) {
                    by2 = (byte)(this.var_byte_arr_arr_b[n11][i2] & 0x7F);
                    if (by2 > 0 && by2 <= n2) {
                        by2 = (byte)(by2 - 1);
                        graphics.drawImage(as.var_javax_microedition_lcdui_Image_arr_a[by2], n13, n12, 20);
                    }
                    n13 += 16;
                }
            }
            graphics.setClip(0, 0, n5, n6);
            if (this.var_cc_arr_c != null) {
                for (n11 = 0; n11 < this.var_cc_arr_c.length; ++n11) {
                    this.var_cc_arr_c[n11].b(n3, n4);
                }
            }
        } else {
            this.a(graphics);
        }
        graphics.setClip(0, 0, n5, n6);
        this.a(graphics, n3, n4);
        bl bl2 = this.var_bl_a;
        while (bl2 != null) {
            bl2.b(n3, n4);
            bl2 = bl2.b;
        }
        if (this.var_cc_arr_b != null) {
            for (n2 = 0; n2 < this.var_cc_arr_b.length; ++n2) {
                this.var_cc_arr_b[n2].b(n3, n4);
            }
        }
        if (this.g > 0 && this.var_javax_microedition_lcdui_Image_a != null) {
            int n14 = n2 = bd.var_int_b > 150 ? n6 / 4 : 17;
            if (this.g > 8) {
                graphics.setClip(0, n2 + 4 * (this.g - 8), n5, 8 * (10 - this.g + 1));
            } else if (this.g < 3) {
                graphics.setClip(0, n2 + 4 * (3 - this.g), n5, 8 * this.g);
            } else {
                graphics.setClip(0, 0, bw.g, bw.h);
            }
            graphics.setColor(0);
            graphics.fillRect(0, n2, n5, 24);
            graphics.setColor(14663551);
            graphics.drawLine(0, n2, n5, n2);
            graphics.drawLine(0, n2 + 23, n5, n2 + 23);
            graphics.drawImage(this.var_javax_microedition_lcdui_Image_a, n5 >> 1, n2 + 15, 3);
            if (u.var_int_a != 5) {
                this.g = (byte)(this.g - 1);
            }
        }
        graphics.setClip(0, 0, bd.var_int_a, bd.var_int_a);
    }

    private final void e(bl bl2) {
        bl2.b = this.var_bl_a;
        bl2.a = null;
        if (this.var_bl_a != null) {
            this.var_bl_a.a = bl2;
        }
        this.var_bl_a = bl2;
        if (this.var_bl_b == null) {
            this.var_bl_b = this.var_bl_a;
        }
        ++this.var_int_d;
    }

    private final void f(bl bl2) {
        bl2.a = this.var_bl_b;
        bl2.b = null;
        if (this.var_bl_b != null) {
            this.var_bl_b.b = bl2;
        }
        this.var_bl_b = bl2;
        if (this.var_bl_a == null) {
            this.var_bl_a = this.var_bl_b;
        }
        ++this.var_int_d;
    }

    public final void void_a(bl bl2) {
        this.f(bl2);
        this.b(bl2);
    }

    private final boolean boolean_a(bl bl2) {
        bl bl3 = this.var_bl_a;
        while (bl3 != null && !bl3.equals(bl2)) {
            bl3 = bl3.b;
        }
        if (bl3 != null) {
            if (bl3.a != null) {
                bl3.a.b = bl3.b;
            } else {
                this.var_bl_a = bl3.b;
            }
            if (bl3.b != null) {
                bl3.b.a = bl3.a;
            } else {
                this.var_bl_b = bl3.a;
            }
            --this.var_int_d;
            bl3 = null;
            System.gc();
            return true;
        }
        return false;
    }

    public final void b(bl bl2) {
        if (bl2.a != null && bl2.g + bl2.var_short_d < bl2.a.g + bl2.a.var_short_d) {
            bl2.a.b = bl2.b;
            if (bl2.b == null) {
                this.var_bl_b = bl2.a;
            } else {
                bl2.b.a = bl2.a;
            }
            bl bl3 = bl2.a;
            while (bl3 != null && bl2.g + bl2.var_short_d < bl3.g + bl3.var_short_d) {
                bl3 = bl3.a;
            }
            if (bl3 == null) {
                this.e(bl2);
            } else {
                bl3.b.a = bl2;
                bl2.b = bl3.b;
                bl3.b = bl2;
                bl2.a = bl3;
            }
        } else if (bl2.b != null && bl2.g + bl2.var_short_d > bl2.b.g + bl2.b.var_short_d) {
            bl2.var_boolean_f = true;
            bl2.b.a = bl2.a;
            if (bl2.a == null) {
                this.var_bl_a = bl2.b;
            } else {
                bl2.a.b = bl2.b;
            }
            bl bl4 = bl2.b;
            while (bl4 != null && bl2.g + bl2.var_short_d > bl4.g + bl4.var_short_d) {
                bl4 = bl4.b;
            }
            if (bl4 == null) {
                this.f(bl2);
            } else {
                bl4.a.b = bl2;
                bl2.a = bl4.a;
                bl4.a = bl2;
                bl2.b = bl4;
            }
        }
    }

    public final boolean boolean_a(int n2, int n3) {
        if (n2 < 0 || n3 < 0 || n2 >= var_byte_d || n3 >= var_byte_e) {
            return false;
        }
        return this.var_byte_arr_arr_c[n3][n2] >= 0 && this.var_bl_arr_arr_a[n3][n2] == null;
    }

    public final boolean a(int n2, int n3, byte n4) {
        for (int i2 = 0; i2 < n4; ++i2) {
            if (this.boolean_a(n2 + i2, n3)) continue;
            return false;
        }
        return true;
    }

    public final boolean boolean_b(int n2, int n3) {
        return this.var_byte_arr_arr_c[n3][n2] < 0;
    }

    public final boolean a(bl bl2, int n2, int n3) {
        return this.var_bl_arr_arr_a[n3][n2] != null && this.var_bl_arr_arr_a[n3][n2] != bl2;
    }

    public boolean a(bb bb2, int n2, int n3) {
        for (int i2 = 0; i2 < bb2.j; ++i2) {
            if (n2 + i2 < 0 || n3 < 0 || n2 + i2 >= var_byte_d || n3 + i2 >= var_byte_e) {
                return false;
            }
            if (!this.boolean_b(n2 + i2, n3) && !this.a((bl)bb2, n2 + i2, n3)) continue;
            return false;
        }
        return true;
    }

    public final boolean a(bb bb2, byte by2) {
        return this.a(bb2, bb2.h + ax.var_byte_arr_a[by2], bb2.i + ax.var_byte_arr_b[by2]);
    }

    public final void f() {
        this.var_int_e = 0;
        this.a(false, (byte)3);
    }

    private final void a(boolean bl2, byte by2) {
        --this.var_int_e;
        if (this.var_int_e < 0) {
            this.var_int_e = 16;
            for (int i2 = this.var_java_util_Vector_a.size() - 1; i2 >= 0; --i2) {
                int[] nArray = (int[])this.var_java_util_Vector_a.elementAt(i2);
                nArray[0] = nArray[0] - 16;
                if (nArray[0] >= 0) continue;
                byte by3 = (byte)nArray[1];
                byte by4 = (byte)nArray[2];
                byte by5 = (byte)nArray[3];
                if (ay.var_ay_arr_a[by3].var_byte_g == 2 && by4 >= var_byte_d - 1) {
                    this.var_java_util_Vector_a.removeElementAt(i2);
                    this.a(nArray[1], 0, by4 - 1, (int)by5);
                    continue;
                }
                if (this.a(by4, by5, ay.var_ay_arr_a[by3].var_byte_a, by3, (byte)5, bl2, by2)) {
                    this.var_java_util_Vector_a.removeElementAt(i2);
                    continue;
                }
                nArray[0] = 0;
            }
        }
    }

    private final boolean a(byte by2, byte by3, byte by4, byte by5, byte by6, boolean bl2, byte by7) {
        byte by8;
        byte by9 = 1;
        if (ay.var_ay_arr_a[by5].var_byte_g == 1) {
            by9 = 2;
        }
        do {
            if (bl2) {
                by2 = (byte)(by2 + f.a(-by7, (int)by7));
                by3 = (byte)(by3 + f.a(-by7, (int)by7));
            }
            by6 = (byte)(by6 - 1);
            if (this.a((int)by2, (int)by3, by9)) break;
            by8 = by6;
            by6 = (byte)(by8 - 1);
        } while (by8 > 0);
        if (by6 > 0) {
            ag ag2 = new ag((short)(by2 << 4), (short)(by3 << 4), by4, by5);
            this.f(ag2);
            this.b(ag2);
            ag2.void_f((byte)1);
            ag2.void_g((byte)2);
            return true;
        }
        return false;
    }

    public final void a(int n2, int n3, int n4, int n5) {
        int[] nArray = new int[]{n3, n2, n4, n5};
        this.var_java_util_Vector_a.addElement(nArray);
    }

    public final void c(bl bl2) {
        if (bl2 instanceof bb) {
            ((bb)bl2).u();
        }
        this.boolean_a(bl2);
    }

    public final void d(bl bl2) {
        this.f(bl2);
        this.b(bl2);
    }

    public final void a(byte by2, byte by3, byte by4, byte by5) {
        byte[] byArray = new byte[]{by2, by3, by4, by5, 1, 120};
        this.var_java_util_Vector_b.addElement(byArray);
    }

    public final void a(byte by2, byte by3, short s2) {
        byte[] byArray = new byte[]{by2, by3, -1, (byte)(s2 / 100), (byte)(s2 % 100), 120};
        this.var_java_util_Vector_b.addElement(byArray);
    }

    private final void a(Graphics graphics, int n2, int n3) {
        for (int i2 = 0; i2 < this.var_java_util_Vector_b.size(); ++i2) {
            byte[] byArray = (byte[])this.var_java_util_Vector_b.elementAt(i2);
            if (byArray[5] <= 16 && byArray[5] % 3 == 0) continue;
            graphics.drawImage(byArray[2] == -1 ? as.y : as.x, n2 + (byArray[0] << 4) + 8, n3 + (byArray[1] << 4) + 8, 3);
        }
    }

    public void void_a(int n2, int n3) {
        this.var_int_b = n3 % 2 == 1 ? n2 : -n2;
    }

    public void void_b(int n2, int n3) {
        this.var_int_c = n3 % 2 == 1 ? n2 : -n2;
    }

    public void void_c(int n2, int n3) {
        this.var_int_b = n2;
        this.var_int_c = n3;
    }

    public byte byte_a(byte by2) {
        if (as.var_byte_arr_i == null) {
            return -1;
        }
        for (byte by3 = 0; by3 < as.var_byte_arr_i.length; by3 = (byte)(by3 + 1)) {
            if (as.var_byte_arr_i[by3] != by2) continue;
            return by3;
        }
        return -1;
    }

    public static void a(int n2) {
        var_int_a = n2;
        var_boolean_b = true;
    }

    public static void g() {
        var_boolean_b = false;
    }

    public void a(Graphics graphics) {
        if (var_int_a == 1) {
            graphics.setColor(0xFFFFFF);
        } else {
            graphics.setColor(0);
        }
        graphics.setClip(0, 0, bd.var_int_a, bd.var_int_b);
        graphics.fillRect(0, 0, bd.var_int_a, bd.var_int_b);
    }

    public boolean boolean_c(int n2, int n3) {
        return n2 >= 0 && n3 >= 0 && n2 < var_byte_d && n3 < var_byte_e;
    }

    public final byte[] byte_arr_a(byte by2, byte by3) {
        int n2;
        byte[] byArray = null;
        for (n2 = this.var_java_util_Vector_b.size() - 1; n2 >= 0; --n2) {
            byte[] byArray2 = (byte[])this.var_java_util_Vector_b.elementAt(n2);
            if (byArray2[0] != by2 || byArray2[1] != by3) continue;
            if (byArray2[2] == -1) {
                byArray = byArray2;
                break;
            }
            if (byArray2[2] == 34) {
                if (!u.var_ci_c.a(byArray2[2], byArray2[3], (int)byArray2[4])) continue;
                byArray = byArray2;
                break;
            }
            if (ci.boolean_a(byArray2[2])) {
                if (!u.var_ci_b.a(byArray2[2], byArray2[3], (int)byArray2[4])) continue;
                byArray = byArray2;
                break;
            }
            if (!u.var_ci_a.a(byArray2[2], byArray2[3], (int)byArray2[4])) continue;
            byArray = byArray2;
            break;
        }
        if (byArray != null) {
            this.var_java_util_Vector_b.removeElementAt(n2);
            return byArray;
        }
        return null;
    }

    public final boolean boolean_a(byte by2, byte by3) {
        for (int i2 = 0; i2 < this.var_java_util_Vector_b.size(); ++i2) {
            byte[] byArray = (byte[])this.var_java_util_Vector_b.elementAt(i2);
            if (byArray[0] != by2 || byArray[1] != by3) continue;
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final byte[] byte_arr_a() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        b b2 = u.var_b_a;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeByte(this.var_byte_b);
            ((DataOutputStream)filterOutputStream).writeByte(((bl)b2).h);
            ((DataOutputStream)filterOutputStream).writeByte(((bl)b2).i);
            ((DataOutputStream)filterOutputStream).writeByte(b2.var_byte_t);
            ((DataOutputStream)filterOutputStream).writeByte(u.var_byte_a);
            byte[] byArray = byteArrayOutputStream.toByteArray();
            return byArray;
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    ((OutputStream)byteArrayOutputStream).close();
                }
            }
            catch (IOException iOException) {}
        }
        return null;
    }

    public void a(byte by2, int n2, int n3) {
        w w2 = null;
        byte by3 = 2;
        switch (by2) {
            case 89: 
            case 90: 
            case 91: 
            case 92: {
                w2 = new cn((short)n2, (short)n3, by2, 0);
                break;
            }
            case 93: 
            case 94: 
            case 95: {
                w2 = new au((short)n2, (short)n3, by2, 0);
                break;
            }
            case 96: 
            case 97: {
                w2 = new bo((short)n2, (short)n3, by2, 0);
                bo.var_bo_a = (bo)w2;
                break;
            }
            case 98: 
            case 100: {
                by3 = 3;
                w2 = new be((short)n2, (short)n3, by2, 1, by3);
                this.d(w2);
                return;
            }
            case 99: 
            case 101: {
                by3 = 4;
                w2 = new be((short)n2, (short)n3, by2, 2, by3);
                this.d(w2);
                return;
            }
            default: {
                return;
            }
        }
        this.d(w2);
        w2.void_f((byte)1);
        w2.void_g(by3);
    }

    public final void h() {
        int n2;
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        int n3 = var_byte_d * f;
        int n4 = var_byte_e * f;
        int n5 = bw.i - (n3 >> 1);
        int n6 = bw.j - (n4 >> 1) + 6;
        int n7 = n5;
        int n8 = n6;
        graphics.setColor(0);
        graphics.drawRect(n7 - 1, n8 - 1, n3 + 1, n4 + 1);
        int n9 = 2;
        switch (this.var_byte_c) {
            case 0: 
            case 2: {
                n9 = 0;
                break;
            }
            case 1: 
            case 6: {
                n9 = 1;
            }
        }
        for (n2 = 0; n2 < var_byte_e; n2 = (byte)(n2 + 1)) {
            for (byte by2 = 0; by2 < var_byte_d; by2 = (byte)(by2 + 1)) {
                if (this.var_byte_arr_arr_c[n2][by2] < 0) {
                    graphics.setColor(var_int_arr_a[n9 * 2 + 1]);
                } else if (this.var_byte_arr_arr_c[n2][by2] >= 0) {
                    graphics.setColor(var_int_arr_a[n9 * 2]);
                }
                if (this.var_byte_arr_arr_c[n2][by2] != 0 && this.var_byte_arr_arr_c[n2][by2] != -128 && ae.boolean_a(this.var_byte_arr_arr_c[n2][by2] < 0 ? (byte)(-this.var_byte_arr_arr_c[n2][by2]) : this.var_byte_arr_arr_c[n2][by2])) {
                    graphics.setColor(3767807);
                }
                graphics.fillRect(n7, n8, (int)f, (int)f);
                n7 += f;
            }
            n8 += f;
            n7 = n5;
        }
        if (bw.l % 2 == 1) {
            b b2 = u.var_b_a;
            graphics.setColor(0xFF0000);
            graphics.fillRect(n5 + ((bl)b2).h * f, n6 + ((bl)b2).i * f, (int)f, (int)f);
        }
        if (++bw.l > 99) {
            bw.l = 0;
        }
        graphics.setColor(0);
        graphics.fillRect(0, 0, bw.g, 13);
        n2 = bw.g / 2 - bk.a(this.i) / 2;
        graphics.setColor(0x777777);
        bk.a(graphics, n2 + 1, 2, this.i, 1);
        graphics.setColor(0xFFFFFF);
        bk.a(graphics, n2, 1, this.i, 1);
    }

    static {
        var_int_arr_a = new int[]{0xBFBFBF, 0x3F3F3F, 12451641, 1588281, 0xBFBFDF, 0x5F5F3F};
        var_byte_a = (byte)101;
        var_boolean_a = false;
        var_int_a = 0;
        var_boolean_b = false;
    }
}

