/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
import com.xce.io.XFile;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Image;

public class as
implements ax {
    public static as var_as_a;
    private static final byte[] var_byte_arr_m;
    public static Image[] var_javax_microedition_lcdui_Image_arr_a;
    public static Image[] var_javax_microedition_lcdui_Image_arr_b;
    public static byte[] var_byte_arr_i;
    public static Image[] var_javax_microedition_lcdui_Image_arr_c;
    public static e var_e_a;
    public static e var_e_b;
    public static e var_e_c;
    public static Object[] var_java_lang_Object_arr_a;
    public static byte[] var_byte_arr_j;
    public static int[] var_int_arr_a;
    public static byte[][] var_byte_arr_arr_b;
    public static boolean var_boolean_a;
    public static e var_e_d;
    public static e var_e_e;
    public static by var_by_a;
    public Image[] var_javax_microedition_lcdui_Image_arr_d;
    public static Image[] var_javax_microedition_lcdui_Image_arr_e;
    public static Image[] var_javax_microedition_lcdui_Image_arr_f;
    public static byte[] var_byte_arr_k;
    public static byte[][] var_byte_arr_arr_c;
    public static byte[] var_byte_arr_l;
    public static Object[] var_java_lang_Object_arr_b;
    public static Object[][] var_java_lang_Object_arr_arr_a;
    private static final String[] var_java_lang_String_arr_a;
    public static Object[][] var_java_lang_Object_arr_arr_b;
    public static byte[][] var_byte_arr_arr_d;
    public static Object[] var_java_lang_Object_arr_c;
    public static e var_e_f;
    public static e var_e_g;
    public static Image var_javax_microedition_lcdui_Image_a;
    public static Image var_javax_microedition_lcdui_Image_b;
    public static Image[] var_javax_microedition_lcdui_Image_arr_g;
    public static Image var_javax_microedition_lcdui_Image_c;
    public static Image var_javax_microedition_lcdui_Image_d;
    public static Image var_javax_microedition_lcdui_Image_e;
    public static Image var_javax_microedition_lcdui_Image_f;
    public static Image var_javax_microedition_lcdui_Image_g;
    public static Image var_javax_microedition_lcdui_Image_h;
    public static Image var_javax_microedition_lcdui_Image_i;
    public static Image var_javax_microedition_lcdui_Image_j;
    public static Image var_javax_microedition_lcdui_Image_k;
    public static Image var_javax_microedition_lcdui_Image_l;
    public static Image var_javax_microedition_lcdui_Image_m;
    public static Image var_javax_microedition_lcdui_Image_n;
    public static Image var_javax_microedition_lcdui_Image_o;
    public static Image p;
    public static e var_e_h;
    public static Image q;
    public static Image r;
    public static Image[] var_javax_microedition_lcdui_Image_arr_h;
    public Image s;
    public static Image t;
    public Image u;
    public Image[] var_javax_microedition_lcdui_Image_arr_i;
    public Image[] var_javax_microedition_lcdui_Image_arr_j;
    public Image[] var_javax_microedition_lcdui_Image_arr_k;
    public Image[] var_javax_microedition_lcdui_Image_arr_l;
    public static Image v;
    public static Image w;
    public static Image[] var_javax_microedition_lcdui_Image_arr_m;
    public static Image x;
    public static Image y;
    public static Image z;
    public Image[] var_javax_microedition_lcdui_Image_arr_n;
    public static Image[] var_javax_microedition_lcdui_Image_arr_o;
    public by var_by_b = null;

    public final void a() {
        int n2;
        int n3;
        int n4;
        byte[] byArray = as.a("/hero/hero" + u.var_byte_a);
        int n5 = 0;
        int n6 = byArray[n5++];
        n5 += n6;
        byte by2 = 0;
        byte by3 = 0;
        var_byte_arr_arr_b = new byte[n6][];
        for (n4 = 0; n4 < n6; ++n4) {
            by2 = byArray[n5++];
            by3 = byArray[n5++];
            byte[] byArray2 = new byte[by2];
            System.arraycopy(byArray, n5, byArray2, 0, by2);
            n5 += by2 + by3;
            as.var_byte_arr_arr_b[n4] = byArray2;
            this.a(n4);
        }
        n4 = byArray[n5++];
        int n7 = 0;
        byte by4 = 0;
        int n8 = n5;
        var_int_arr_a = new int[n4];
        b.var_byte_arr_n = new byte[n4 - (u.var_byte_a == 0 ? 3 : 4)];
        for (n3 = 0; n3 < n4; ++n3) {
            as.var_int_arr_a[n3] = n5 - n8;
            n7 = byArray[n5++];
            if (n3 > 3) {
                b.var_byte_arr_n[n3 - 4] = n7;
            }
            for (n2 = 0; n2 < n7; ++n2) {
                for (int i2 = 0; i2 < 4; ++i2) {
                    by4 = byArray[n5++];
                    n5 += 4 * by4;
                }
            }
        }
        n3 = n5 - n8;
        var_byte_arr_j = new byte[n3];
        System.arraycopy(byArray, n8, var_byte_arr_j, 0, n3);
        if (u.var_byte_a == 0) {
            for (n2 = 0; n2 < 4; ++n2) {
                b.var_byte_arr_n[13 - n2] = b.var_byte_arr_n[12 - n2];
            }
            b.var_byte_arr_n[9] = b.var_byte_arr_n[4];
        }
    }

    public final void a(int n2) {
        int n3;
        bq bq2 = null;
        b b2 = u.var_b_a;
        Image[] imageArray = null;
        byte by2 = 0;
        int n4 = 0;
        short s2 = -1;
        switch (n2) {
            case 0: {
                if (b2.am_c() != null) {
                    n4 = b2.am_c().l;
                    s2 = b2.am_c().a;
                } else {
                    n4 = 100;
                }
                bq2 = new bq("/hero/" + n2 + "/" + (n4 < 10 ? "0" : "") + n4);
                break;
            }
            case 1: {
                if (b2.am_b() != null) {
                    n4 = b2.am_b().l;
                    s2 = b2.am_b().a;
                } else {
                    n4 = (byte)(100 + u.var_byte_a);
                }
                bq2 = new bq("/hero/" + n2 + "/" + (n4 < 10 ? "0" : "") + n4);
                break;
            }
            case 2: {
                if (b2.am_d() != null) {
                    n4 = b2.am_d().l;
                    s2 = b2.am_d().a;
                } else {
                    n4 = 100;
                }
                bq2 = new bq("/hero/" + n2 + "/" + (n4 < 10 ? "0" : "") + n4);
                break;
            }
            case 3: {
                if (b2.am_e() != null) {
                    n4 = b2.am_e().l;
                    s2 = b2.am_e().a;
                } else {
                    n4 = (byte)(100 + u.var_byte_a);
                }
                bq2 = new bq("/hero/" + n2 + "/" + (n4 < 10 ? "0" : "") + n4);
                break;
            }
            case 4: {
                bq2 = new bq("/hero/" + n2 + "/" + u.var_byte_a);
                break;
            }
            case 5: {
                if (b2.cf_a() != null) {
                    n3 = b2.cf_a().i;
                    if (n3 < 1) {
                        this.a(true);
                        return;
                    }
                    bq2 = new bq("/hero/" + n2 + "/eh");
                    this.a(bq2, (byte)n3);
                    break;
                }
                return;
            }
            case 6: {
                if (b2.cf_a() == null) {
                    return;
                }
                by2 = b2.cf_a().g;
                n4 = b2.cf_a().l;
                s2 = b2.cf_a().a;
                this.a(by2);
                bq2 = new bq("/hero/" + n2 + "/" + by2 + (n4 < 10 ? "0" : "") + n4);
                break;
            }
            case 7: {
                if (b2.am_a() == null) {
                    if (u.var_byte_a == 2) {
                        this.a(false);
                    }
                    return;
                }
                by2 = b2.am_a().g;
                n4 = b2.am_a().l;
                s2 = b2.am_a().a;
                bq2 = new bq("/hero/" + n2 + "/" + by2 + (n4 < 10 ? "0" : "") + n4);
                if (by2 != 3) break;
                this.b(((cf)b2.am_a()).i);
                break;
            }
            default: {
                return;
            }
        }
        if (s2 > -1) {
            this.a(bq2, s2, "/hero/h.p");
        }
        as.var_java_lang_Object_arr_a[n2] = bq2.javax_microedition_lcdui_Image_arr_a();
        bq2.a(true);
        n3 = bq2.int_a();
        as.var_java_lang_Object_arr_a[n2 + 8] = imageArray = new Image[n3];
        byte[] byArray = var_byte_arr_arr_b[n2];
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            imageArray[byArray[i2]] = bq2.javax_microedition_lcdui_Image_b(byArray[i2]);
        }
    }

    public void b(int n2) {
        as.var_java_lang_Object_arr_a[n2] = null;
        as.var_java_lang_Object_arr_a[n2 + 8] = null;
    }

    public void a(boolean bl2) {
        Image[] imageArray = (Image[])var_java_lang_Object_arr_a[5];
        if (imageArray == null) {
            return;
        }
        for (int n2 = 0; n2 < 5; n2 = (int)((byte)(n2 + 1))) {
            imageArray[n2 + (bl2 ? 0 : 5)] = null;
        }
    }

    private void b(byte by2) {
        if (by2 < 1) {
            this.a(false);
            return;
        }
        bq bq2 = null;
        bq2 = new bq("/hero/5/eh");
        this.a(bq2, by2);
        Image[] imageArray = bq2.javax_microedition_lcdui_Image_arr_a();
        if (var_java_lang_Object_arr_a[5] == null) {
            as.var_java_lang_Object_arr_a[5] = new Image[imageArray.length];
        }
        Image[] imageArray2 = (Image[])var_java_lang_Object_arr_a[5];
        for (int i2 = 5; i2 < 10; ++i2) {
            imageArray2[i2] = imageArray[i2];
        }
        bq2 = null;
        System.gc();
    }

    private void a(bq bq2, int n2, int n3, int n4, int n5, int n6, int n7) {
        bq2.void_a(n2, n5);
        bq2.void_a(n3, n6);
        bq2.void_a(n4, n7);
    }

    private final void a(bq bq2, byte by2) {
        switch (by2) {
            case 1: {
                this.a(bq2, 0xFFFFFF, 0xBFDFFF, 0x7FBFFF);
                break;
            }
            case 2: {
                this.a(bq2, 0xFF1FBF, 0xDF1FFF, 0x9F1FFF);
                break;
            }
            case 3: {
                this.a(bq2, 0, 0, 0x3F3F3F);
                break;
            }
            case 4: {
                this.a(bq2, 2055999, 0x3F9F3F, 0x3FFF3F);
                break;
            }
            case 5: {
                this.a(bq2, 10428223, 0xFF0000, 0xFF5F3F);
                break;
            }
            case 6: {
                this.a(bq2, 255, 0x1F5FFF, 0x1F9FFF);
            }
        }
    }

    public void a(bq bq2, int n2, int n3, int n4) {
        this.a(bq2, 0xFFFFFF, 0xBFDFFF, 0x7FBFFF, n2, n3, n4);
    }

    public void b() {
        var_javax_microedition_lcdui_Image_arr_e = new Image[8];
        var_javax_microedition_lcdui_Image_arr_f = new Image[66];
    }

    public final void void_a(byte[] byArray, int n2) {
        int n3;
        byte by2 = byArray[n2 + 1];
        var_byte_arr_l = this.a("/b/bg.s", by2);
        by2 = byArray[n2];
        byte[] byArray2 = as.a("/b/bb.s", (int)by2);
        n2 += 2;
        int n4 = 0;
        byte by3 = byArray2[n4++];
        n4 += by3;
        byte by4 = 0;
        byte by5 = 0;
        byte by6 = 0;
        for (n3 = 0; n3 < 4; n3 = (int)((byte)(n3 + 1))) {
            by4 = byArray2[n4++];
            by5 = byArray2[n4++];
            by6 = byArray[n2++];
            if (by4 > 0 || by5 > 0) {
                this.a((byte)n3, by6, by4 > 0);
            }
            n4 += by4;
            n4 += by5;
        }
        ++n2;
        n3 = byArray2[n4++];
        int n5 = 0;
        int n6 = n4;
        int n7 = 0;
        byte by7 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            n5 = byArray2[n4++];
            for (int i3 = 0; i3 < n5; ++i3) {
                for (int i4 = 0; i4 < 4; ++i4) {
                    by7 = byArray2[n4++];
                    n4 += 4 * by7;
                }
            }
        }
        n7 = n4 - n6;
        var_byte_arr_k = new byte[n7];
        System.arraycopy(byArray2, n6, var_byte_arr_k, 0, n7);
    }

    public byte[] a(String string, byte by2) {
        byte[] byArray = as.a(string, (int)by2);
        int n2 = 0;
        byte by3 = byArray[n2++];
        n2 += by3;
        n2 = this.int_a(byArray, n2);
        int n3 = byArray[n2++];
        byte[] byArray2 = null;
        int n4 = 0;
        int n5 = n2;
        int n6 = 0;
        byte by4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            n4 = byArray[n2++];
            for (int i3 = 0; i3 < n4; ++i3) {
                for (int i4 = 0; i4 < 4; ++i4) {
                    by4 = byArray[n2++];
                    n2 += 4 * by4;
                }
            }
        }
        n6 = n2 - n5;
        byArray2 = new byte[n6];
        System.arraycopy(byArray, n5, byArray2, 0, n6);
        return byArray2;
    }

    public final void a(byte by2, byte by3, boolean bl2) {
        if (by2 < -1) {
            return;
        }
        bq bq2 = new bq("/b/" + var_java_lang_String_arr_a[by2]);
        bq2.a(true);
        as.var_javax_microedition_lcdui_Image_arr_e[by2] = bq2.javax_microedition_lcdui_Image_a(by3);
        if (bl2) {
            as.var_javax_microedition_lcdui_Image_arr_e[by2 + 4] = bq2.javax_microedition_lcdui_Image_b(by3);
        }
    }

    public final int int_a(byte[] byArray, int n2) {
        int n3;
        int n4 = byArray[n2++];
        byte by2 = byArray[n2++];
        if (n4 == 0 && by2 == 0) {
            return n2;
        }
        bq bq2 = new bq("/b/" + var_java_lang_String_arr_a[4]);
        bq2.a(true);
        int n5 = bq2.int_a();
        byte by3 = 0;
        for (n3 = 0; n3 < n4; ++n3) {
            if (var_javax_microedition_lcdui_Image_arr_f[(by3 = byArray[n2++]) + n5] != null) continue;
            as.var_javax_microedition_lcdui_Image_arr_f[by3 + n5] = bq2.javax_microedition_lcdui_Image_b(by3);
        }
        for (n3 = 0; n3 < by2; ++n3) {
            if (var_javax_microedition_lcdui_Image_arr_f[by3 = byArray[n2++]] != null) continue;
            as.var_javax_microedition_lcdui_Image_arr_f[by3] = bq2.javax_microedition_lcdui_Image_a(by3);
        }
        return n2;
    }

    public final void c() {
        var_java_lang_Object_arr_arr_a = null;
        var_java_lang_Object_arr_b = null;
    }

    public void c(int n2) {
        var_java_lang_Object_arr_arr_a = new Object[n2][];
        var_java_lang_Object_arr_b = new Object[n2 * 4 * 2];
    }

    public final void a(byte[] byArray, byte by2, byte by3) {
        int n2;
        int n3 = 0;
        int n4 = by2 * 9;
        byte by4 = byArray[n4++];
        byte[] byArray2 = as.a("/npc/n.s", (int)by4);
        int n5 = byArray2[n3++];
        n3 += n5;
        byte by5 = 0;
        byte by6 = 0;
        for (n2 = 0; n2 < n5; ++n2) {
            by5 = byArray2[n3++];
            if ((by6 = byArray2[n3++]) <= 0 && by5 <= 0) continue;
            byte[] byArray3 = new byte[by5];
            System.arraycopy(byArray2, n3, byArray3, 0, by5);
            n3 += by5;
            n3 += by6;
            this.a(by3, n2, byArray[n4 + n2], byArray3, byArray[n4 + 4 + n2]);
        }
        n2 = byArray2[n3++];
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        byte by7 = 0;
        as.var_java_lang_Object_arr_arr_a[by3] = new Object[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            n7 = n3;
            n6 = byArray2[n3++];
            for (int i3 = 0; i3 < n6; ++i3) {
                for (int i4 = 0; i4 < 4; ++i4) {
                    by7 = byArray2[n3++];
                    n3 += 4 * by7;
                }
            }
            n8 = n3 - n7;
            byte[] byArray4 = null;
            byArray4 = new byte[n8];
            as.var_java_lang_Object_arr_arr_a[by3][i2] = byArray4;
            System.arraycopy(byArray2, n7, byArray4, 0, n8);
        }
    }

    private void a(byte by2, int n2, int n3, byte[] byArray, byte by3) {
        if (n3 < 0) {
            return;
        }
        int n4 = 8 * by2;
        bq bq2 = null;
        String string = null;
        boolean bl2 = false;
        int n5 = 0;
        int n6 = 0;
        switch (n2) {
            case 0: {
                if (n3 > 4 && n3 < 32) {
                    n6 = (n3 - 5) / 4;
                    n5 = (n3 - 5) % 4;
                    bl2 = true;
                    break;
                }
                if (n3 < 36 || n3 >= 40) break;
                n6 = 8;
                n5 = n3 - 36;
                bl2 = true;
                break;
            }
            case 1: {
                if (n3 < 8 || n3 > 19) break;
                n6 = (n3 - 8) / 4;
                n5 = (n3 - 8) % 4;
                bl2 = true;
                break;
            }
            case 3: {
                if (n3 < 8 || n3 > 26) break;
                n6 = (n3 - 8) / 4;
                n5 = (n3 - 8) % 4;
                bl2 = true;
            }
        }
        string = bl2 ? new String(var_java_lang_String_arr_a[n2] + n6) : new String((n3 < 10 ? "0" : "") + n3);
        bq2 = new bq("/npc/" + var_java_lang_String_arr_a[n2] + "/" + string);
        if (by3 > -1) {
            this.a(bq2, (short)by3, "/npc/n.p");
        }
        Image[] imageArray = null;
        if (bl2) {
            bq2.a(true);
            as.var_java_lang_Object_arr_b[n4 + n2] = imageArray = new Image[1];
            imageArray[0] = bq2.javax_microedition_lcdui_Image_a(n5);
        } else {
            as.var_java_lang_Object_arr_b[n4 + n2] = bq2.javax_microedition_lcdui_Image_arr_a();
        }
        if (byArray.length > 0) {
            bq2.a(true);
            Image[] imageArray2 = null;
            if (bl2) {
                as.var_java_lang_Object_arr_b[n4 + n2 + 4] = imageArray2 = new Image[1];
                imageArray2[0] = bq2.javax_microedition_lcdui_Image_b(n5);
            } else {
                int n7 = bq2.int_a();
                imageArray2 = new Image[n7];
                as.var_java_lang_Object_arr_b[n4 + n2 + 4] = imageArray2;
                for (int i2 = 0; i2 < byArray.length; ++i2) {
                    imageArray2[byArray[i2]] = bq2.javax_microedition_lcdui_Image_b(byArray[i2]);
                }
            }
        }
    }

    public final void d() {
        var_java_lang_Object_arr_arr_b = null;
        var_byte_arr_arr_d = null;
        var_java_lang_Object_arr_c = null;
        ay.var_ay_arr_a = null;
    }

    public static void d(int n2) {
        var_java_lang_Object_arr_arr_b = new Object[n2][24];
        var_byte_arr_arr_d = new byte[n2][];
        var_java_lang_Object_arr_c = new Object[n2 * 6 * 2];
        ay.var_ay_arr_a = new ay[n2];
    }

    public final void a(byte[] byArray, int n2, byte by2, byte by3, byte by4, byte by5) {
        int n3;
        byte[] byArray2 = as.a("/enm/spr/" + (by3 < 10 ? "0" : "") + by3);
        int n4 = 0;
        int n5 = byArray2[n4++];
        n4 += n5;
        byte by6 = 0;
        byte by7 = 0;
        byte by8 = -1;
        for (n3 = 0; n3 < n5; ++n3) {
            by6 = byArray2[n4++];
            by7 = byArray2[n4++];
            byte[] byArray3 = new byte[by6];
            System.arraycopy(byArray2, n4, byArray3, 0, by6);
            n4 += by6;
            n4 += by7;
            by8 = n3 < 4 ? byArray[n2 + n3] : (n3 == 4 && by5 >= 90 && by5 <= 94 ? (byte)((byte)(by5 + 54 - 90)) : (byte)-1);
            this.a(by2, by4, n3, (int)byArray[n2 + 4 + n3], byArray3, by8);
        }
        n3 = byArray2[n4++];
        int n6 = 0;
        byte by9 = 0;
        int n7 = 0;
        as.var_byte_arr_arr_d[by4] = new byte[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            int n8;
            as.var_byte_arr_arr_d[by4][i2] = n6 = byArray2[n4++];
            n7 = n4;
            by9 = 0;
            for (n8 = 0; n8 < n6; ++n8) {
                for (int i3 = 0; i3 < 4; ++i3) {
                    by9 = byArray2[n4++];
                    n4 += 4 * by9;
                }
            }
            n8 = n4 - n7;
            byte[] byArray4 = null;
            byArray4 = new byte[1 + n8];
            as.var_java_lang_Object_arr_arr_b[by4][i2] = byArray4;
            byArray4[0] = n6;
            System.arraycopy(byArray2, n7, byArray4, 1, n8);
        }
    }

    private void a(byte by2, byte by3, int n2, int n3, byte[] byArray, byte by4) {
        if (n3 < 0) {
            return;
        }
        int n4 = 12 * by3;
        Image[] imageArray = null;
        bq bq2 = null;
        bq2 = new bq("/enm/" + var_java_lang_String_arr_a[n2] + "/" + (by2 < 10 ? "0" : "") + by2 + "_" + n3);
        if (by4 > -1) {
            this.a(bq2, (short)by4, "/enm/e.p");
        }
        as.var_java_lang_Object_arr_c[n4 + n2] = bq2.javax_microedition_lcdui_Image_arr_a();
        bq2.a(true);
        int n5 = bq2.int_a();
        as.var_java_lang_Object_arr_c[n4 + n2 + 6] = imageArray = new Image[n5];
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            imageArray[byArray[i2]] = bq2.javax_microedition_lcdui_Image_b(byArray[i2]);
        }
    }

    private void a(bq bq2, short s2, String string) {
        byte[] byArray = as.a(string, s2);
        int n2 = 0;
        int n3 = byArray[n2++];
        int n4 = 0;
        int n5 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            n4 = f.int_b(byArray, n2);
            n5 = f.int_b(byArray, n2 += 4);
            n2 += 4;
            bq2.void_a(n4, n5);
        }
        byArray = null;
        System.gc();
    }

    public void e() {
        var_e_f = new e("/t/hero");
        var_e_c = new e("/t/itmtp");
        var_e_g = new e("/t/itmatt");
        bw.k += 5;
        bq bq2 = null;
        bq2 = new bq("/img/glb");
        bq2.a(true);
        var_javax_microedition_lcdui_Image_c = bq2.javax_microedition_lcdui_Image_a(0);
        var_javax_microedition_lcdui_Image_d = bq2.javax_microedition_lcdui_Image_a(1);
        var_javax_microedition_lcdui_Image_e = bq2.javax_microedition_lcdui_Image_a(2);
        var_javax_microedition_lcdui_Image_f = bq2.javax_microedition_lcdui_Image_a(3);
        var_javax_microedition_lcdui_Image_g = bq2.javax_microedition_lcdui_Image_a(4);
        bw.k += 10;
        var_javax_microedition_lcdui_Image_h = bq2.javax_microedition_lcdui_Image_a(5);
        var_javax_microedition_lcdui_Image_i = bq2.javax_microedition_lcdui_Image_a(6);
        var_javax_microedition_lcdui_Image_j = bq2.javax_microedition_lcdui_Image_a(7);
        var_javax_microedition_lcdui_Image_b = bq2.javax_microedition_lcdui_Image_a(8);
        var_javax_microedition_lcdui_Image_k = bq2.javax_microedition_lcdui_Image_a(9);
        var_javax_microedition_lcdui_Image_a = bq2.javax_microedition_lcdui_Image_a(10);
        bw.k += 10;
        var_javax_microedition_lcdui_Image_arr_g = new Image[2];
        for (int i2 = 0; i2 < 2; ++i2) {
            as.var_javax_microedition_lcdui_Image_arr_g[i2] = bq2.javax_microedition_lcdui_Image_a(11 + i2);
        }
        var_javax_microedition_lcdui_Image_l = bq2.javax_microedition_lcdui_Image_a(13);
        var_javax_microedition_lcdui_Image_n = bq2.javax_microedition_lcdui_Image_a(14);
        var_javax_microedition_lcdui_Image_o = bq2.javax_microedition_lcdui_Image_a(15);
        bw.k += 10;
        var_javax_microedition_lcdui_Image_m = bq2.javax_microedition_lcdui_Image_a(16);
        q = bq2.javax_microedition_lcdui_Image_a(17);
        var_e_h = new e("/t/help");
        bw.k += 5;
        ak.a(2, 42);
        bw.k += 5;
    }

    public void f() {
        byte by2;
        if (var_boolean_a) {
            return;
        }
        var_boolean_a = true;
        this.k();
        var_by_a = new by("/hero/target", "/img/efftar");
        this.r();
        bq bq2 = null;
        bq2 = new bq("/img/emoti");
        this.var_javax_microedition_lcdui_Image_arr_d = bq2.javax_microedition_lcdui_Image_arr_a();
        var_e_e = new e("/t/q");
        var_e_d = new e("/t/bsk");
        for (by2 = 5; by2 <= 8; by2 = (byte)(by2 + 1)) {
            ak.b(by2);
        }
        ak.b((byte)16);
        for (by2 = 0; by2 <= 3; by2 = (byte)(by2 + 1)) {
            ak.a((int)by2, 40 + by2);
        }
        this.g();
        if (u.var_b_a.cf_a() != null) {
            this.a(u.var_b_a.cf_a().g);
        } else {
            this.a((byte)3);
        }
    }

    public final void a(byte by2) {
        int n2 = 51;
        switch (by2) {
            case 0: 
            case 2: {
                n2 = 52;
                break;
            }
            case 1: 
            case 4: {
                n2 = 53;
            }
        }
        ak.a(4, n2);
    }

    public final void g() {
        switch (u.var_byte_a) {
            case 0: {
                ak.a(5, 45);
                break;
            }
            case 1: {
                for (int i2 = 0; i2 < 2; ++i2) {
                    ak.a(6 + i2, 46 + i2);
                }
                ak.a(8, 53);
                break;
            }
            case 2: {
                ak.a(9, 49);
            }
        }
    }

    public final void h() {
        switch (u.var_byte_a) {
            case 0: {
                ak.b(5);
                break;
            }
            case 1: {
                for (int i2 = 0; i2 < 3; ++i2) {
                    ak.b(6 + i2);
                }
                break;
            }
            case 2: {
                ak.b(9);
            }
        }
    }

    public final void i() {
        byte by2;
        var_boolean_a = false;
        this.l();
        var_by_a = null;
        this.var_javax_microedition_lcdui_Image_arr_d = null;
        var_javax_microedition_lcdui_Image_arr_m = null;
        this.var_javax_microedition_lcdui_Image_arr_j = null;
        this.var_javax_microedition_lcdui_Image_arr_k = null;
        v = null;
        w = null;
        x = null;
        y = null;
        z = null;
        this.var_javax_microedition_lcdui_Image_arr_l = null;
        this.var_javax_microedition_lcdui_Image_arr_i = null;
        var_e_e = null;
        var_e_d = null;
        for (by2 = 5; by2 <= 8; by2 = (byte)((byte)(by2 + 1))) {
            ak.c(by2);
        }
        for (by2 = 12; by2 <= 15; by2 = (byte)(by2 + 1)) {
            ak.c(by2);
        }
        for (by2 = 0; by2 <= 4; by2 = (byte)(by2 + 1)) {
            ak.b((int)by2);
        }
        ak.b(4);
        this.h();
    }

    public void j() {
        this.i();
        ak.d();
        ak.b((byte)17);
        ak.i = (byte[])ak.var_java_lang_Object_arr_a[17];
        bq bq2 = new bq("/img/face");
        bq2.a(true);
        var_javax_microedition_lcdui_Image_arr_c = new Image[2];
        as.var_javax_microedition_lcdui_Image_arr_c[0] = bq2.javax_microedition_lcdui_Image_a(0);
        as.var_javax_microedition_lcdui_Image_arr_c[1] = bq2.javax_microedition_lcdui_Image_a(3);
        bq2 = null;
        bd.var_bd_a.f();
    }

    public final void k() {
        var_javax_microedition_lcdui_Image_arr_h = new Image[2];
        bq bq2 = null;
        bq2 = new bq("/img/gmico");
        bq2.a(true);
        this.u = bq2.javax_microedition_lcdui_Image_a(u.var_byte_a);
        r = bq2.javax_microedition_lcdui_Image_a(3);
        as.var_javax_microedition_lcdui_Image_arr_h[0] = bq2.javax_microedition_lcdui_Image_a(4);
        as.var_javax_microedition_lcdui_Image_arr_h[1] = bq2.javax_microedition_lcdui_Image_a(5);
        this.s = bq2.javax_microedition_lcdui_Image_a(6);
        t = bq2.javax_microedition_lcdui_Image_a(7);
    }

    public final void l() {
        r = null;
        var_javax_microedition_lcdui_Image_arr_h = null;
        this.s = null;
        t = null;
        this.u = null;
    }

    private final void r() {
        int n2;
        bq bq2 = new bq("/img/bico");
        this.var_javax_microedition_lcdui_Image_arr_i = bq2.javax_microedition_lcdui_Image_arr_a();
        bq2 = new bq("/img/etc");
        bq2.a(true);
        var_javax_microedition_lcdui_Image_arr_m = new Image[4];
        for (n2 = 0; n2 < 4; ++n2) {
            as.var_javax_microedition_lcdui_Image_arr_m[n2] = bq2.javax_microedition_lcdui_Image_a(n2);
        }
        this.var_javax_microedition_lcdui_Image_arr_k = new Image[2];
        this.var_javax_microedition_lcdui_Image_arr_j = new Image[2];
        for (n2 = 0; n2 < 2; ++n2) {
            this.var_javax_microedition_lcdui_Image_arr_k[n2] = bq2.javax_microedition_lcdui_Image_a(n2 * 2 + 4);
            this.var_javax_microedition_lcdui_Image_arr_j[n2] = bq2.javax_microedition_lcdui_Image_a(n2 * 2 + 5);
        }
        y = bq2.javax_microedition_lcdui_Image_a(8);
        z = bq2.javax_microedition_lcdui_Image_a(9);
        x = bq2.javax_microedition_lcdui_Image_a(10);
        this.var_javax_microedition_lcdui_Image_arr_l = new Image[2];
        for (n2 = 0; n2 < 2; ++n2) {
            this.var_javax_microedition_lcdui_Image_arr_l[n2] = bq2.javax_microedition_lcdui_Image_a(11 + n2);
        }
        this.var_javax_microedition_lcdui_Image_arr_n = new Image[5];
        for (n2 = 0; n2 < 5; ++n2) {
            this.var_javax_microedition_lcdui_Image_arr_n[n2] = bq2.javax_microedition_lcdui_Image_a(n2 + 13);
        }
        if (bw.g > 120 && bw.g <= 200) {
            p = bq2.javax_microedition_lcdui_Image_a(18);
        }
    }

    public void void_a(byte by2, byte by3) {
        bq bq2 = new bq("/img/snow");
        bq2.a(true);
        boolean bl2 = false;
        if (by2 == 4 || by3 == 64 || by3 == 72 || by3 == 76 || by3 == 110) {
            bl2 = true;
        }
        v = bq2.javax_microedition_lcdui_Image_a(0 + (bl2 ? 2 : 0));
        w = bq2.javax_microedition_lcdui_Image_a(1 + (bl2 ? 2 : 0));
    }

    public final void m() {
        this.var_javax_microedition_lcdui_Image_arr_n = null;
    }

    public void n() {
        ah ah2;
        Object object;
        ak.d();
        b b2 = u.var_b_a;
        b2.var_boolean_g = true;
        b2.var_boolean_r = false;
        ah ah3 = u.var_ah_a;
        ah.g();
        if (ah3 != null) {
            ah3.c(b2);
            b2.var_byte_arr_arr_b = null;
            b2.var_byte_a = (byte)null;
            object = b2.var_cg_a;
            if (object != null) {
                ah3.c((bl)object);
                ((cg)object).var_short_arr_b = null;
                ((cg)object).var_short_a = (short)null;
            }
            ah.d();
            u.var_ah_a = null;
        }
        ++bw.k;
        this.o();
        object = as.a("/m/m/" + (u.h < 10 ? "0" : "") + u.h + ".m");
        ++bw.k;
        u.var_ah_a = ah2 = new ah(u.h);
        ah2.a((byte[])object);
        b2.p();
        this.void_a(ah2.var_byte_c, u.h);
    }

    public void o() {
        boolean bl2 = false;
        for (int i2 = 0; i2 < var_byte_arr_m.length; ++i2) {
            if (u.h != var_byte_arr_m[i2]) continue;
            bl2 = true;
            break;
        }
        o.var_java_util_Vector_arr_a = bl2 ? cp.java_util_Vector_arr_a() : null;
    }

    public final void b(boolean bl2) {
        if (bl2) {
            var_javax_microedition_lcdui_Image_arr_a = null;
        }
        var_javax_microedition_lcdui_Image_arr_b = null;
        this.c();
        this.d();
        var_javax_microedition_lcdui_Image_arr_c = null;
        ak.c((byte)0);
    }

    public final void p() {
        bq bq2 = new bq("/img/sui");
        bq2.a(true);
        if (var_javax_microedition_lcdui_Image_arr_o == null) {
            var_javax_microedition_lcdui_Image_arr_o = new Image[6];
            as.var_javax_microedition_lcdui_Image_arr_o[0] = bq2.javax_microedition_lcdui_Image_a(bw.g >= 240 ? 1 : 0);
            as.var_javax_microedition_lcdui_Image_arr_o[1] = bq2.javax_microedition_lcdui_Image_a(bw.g >= 240 ? 3 : 2);
            for (int i2 = 2; i2 < 6; ++i2) {
                as.var_javax_microedition_lcdui_Image_arr_o[i2] = bq2.javax_microedition_lcdui_Image_a(i2 + 2);
            }
        }
        bw.k += 10;
        p = bq2.javax_microedition_lcdui_Image_a(8);
        this.var_by_b = new by("/hero/select", "/img/job");
        bw.k += 10;
    }

    public final void q() {
        var_javax_microedition_lcdui_Image_arr_o = null;
        this.var_by_b = null;
    }

    public static final byte[] a(String string) {
        InputStream inputStream = null;
        byte[] byArray = null;
        try {
            inputStream = new Object().getClass().getResourceAsStream(string);
            if (inputStream == null) {
                int n2;
                String string2 = string.substring(0, string.lastIndexOf(47));
                while ((n2 = string2.indexOf(47)) != -1) {
                    string2 = string2.substring(0, n2).concat(string2.substring(n2 + 1));
                }
                if (XFile.exists(string2.concat(".jar"))) {
                    XFile xFile = new XFile(string2.concat(".jar"), string.substring(string.lastIndexOf(47)));
                    byArray = new byte[xFile.available()];
                    xFile.read(byArray, 0, byArray.length);
                    xFile.close();
                    xFile = null;
                    return byArray;
                }
                return null;
            }
            byArray = new byte[inputStream.available()];
            inputStream.read(byArray);
            inputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return byArray;
    }

    public static final byte[] byte_arr_a(byte by2, byte by3) {
        String string = String.valueOf(by2);
        if (by2 < 10) {
            string = "0".concat(string);
        }
        return as.a("/itm".concat("/").concat(string), (int)by3);
    }

    public static final byte[] a(String string, int n2) {
        InputStream inputStream = null;
        byte[] byArray = null;
        try {
            inputStream = new Object().getClass().getResourceAsStream(string);
            int n3 = inputStream.available();
            byte[] byArray2 = new byte[n3];
            inputStream.read(byArray2);
            inputStream.close();
            int n4 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                n3 = f.short_b(byArray2, n4);
                n4 += 2;
                n4 += n3;
            }
            n3 = f.short_b(byArray2, n4);
            byArray = new byte[n3];
            System.arraycopy(byArray2, n4 += 2, byArray, 0, n3);
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return byArray;
    }

    static {
        var_as_a = new as();
        var_byte_arr_m = new byte[]{1, 34, 66, 69, 73, 77};
        var_boolean_a = false;
        var_by_a = null;
        var_java_lang_Object_arr_b = null;
        var_java_lang_Object_arr_arr_a = null;
        var_java_lang_String_arr_a = new String[]{"1head", "2body", "3arm", "4leg", "5effect", "6weapon"};
        var_java_lang_Object_arr_arr_b = null;
        var_byte_arr_arr_d = null;
        var_java_lang_Object_arr_c = null;
        var_javax_microedition_lcdui_Image_arr_o = null;
    }
}

