/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Image;

public class bq {
    private static final String[] var_java_lang_String_arr_a;
    private static final byte[] var_byte_arr_a;
    private static final byte[] var_byte_arr_b;
    private String var_java_lang_String_a;
    private boolean var_boolean_a;
    private boolean var_boolean_b;
    private int var_int_a;
    private int[] var_int_arr_a;
    private byte[] var_byte_arr_c;
    private Object[] var_java_lang_Object_arr_a;
    private char[] var_char_arr_a;
    private int var_int_b;
    private int var_int_c;
    private boolean var_boolean_c = false;
    private static final int[] var_int_arr_b;
    private int d = -1;
    private int e = 1;

    public bq(String string) {
        this.a(string);
    }

    public void a(String string) {
        this.var_int_arr_a = null;
        this.var_byte_arr_c = null;
        this.var_java_lang_Object_arr_a = null;
        this.var_char_arr_a = null;
        this.var_java_lang_String_a = string;
        this.var_byte_arr_c = as.a(this.var_java_lang_String_a.concat(".mph"));
        this.d();
    }

    public void a(boolean bl2) {
        this.var_boolean_c = bl2;
    }

    public void void_a() {
        for (int i2 = 0; i2 < this.var_int_a; ++i2) {
            this.var_java_lang_Object_arr_a[i2] = null;
        }
    }

    private void d() {
        int n2;
        int n3 = bq.int_a(this.var_byte_arr_c, 0);
        this.var_boolean_a = (n3 >> 27) % 2 == 1;
        this.var_boolean_b = (n3 >> 26) % 2 == 1;
        int n4 = this.int_a();
        this.var_int_a = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            if (this.var_int_a >= bq.char_a(this.var_byte_arr_c, 8 + 8 * n2) + '\u0001') continue;
            this.var_int_a = bq.char_a(this.var_byte_arr_c, 8 + 8 * n2) + '\u0001';
        }
        this.var_int_arr_a = new int[this.var_int_a];
        for (n2 = 0; n2 < n4; ++n2) {
            char c2 = bq.char_a(this.var_byte_arr_c, 8 + 8 * n2);
            this.var_int_arr_a[c2] = this.var_int_arr_a[c2] + 1;
        }
        this.var_java_lang_Object_arr_a = new Object[this.var_int_a];
        this.var_char_arr_a = new char[n4];
        for (n2 = 0; n2 < n4; ++n2) {
            this.var_char_arr_a[n2] = bq.char_a(this.var_byte_arr_c, 8 + 8 * n2 + 6);
        }
        this.var_int_b = bq.b(this.var_byte_arr_c, 12);
        this.var_int_c = bq.b(this.var_byte_arr_c, 13);
    }

    public int int_a() {
        return bq.int_a(this.var_byte_arr_c, 4);
    }

    public Image javax_microedition_lcdui_Image_a(int n2) {
        byte[] byArray = this.byte_arr_b(n2);
        return Image.createImage((byte[])byArray, (int)0, (int)byArray.length);
    }

    public Image[] javax_microedition_lcdui_Image_arr_a() {
        this.a(true);
        int n2 = this.int_a();
        Image[] imageArray = new Image[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            imageArray[i2] = this.javax_microedition_lcdui_Image_a(i2);
            if (n2 % 2 != 1) continue;
            ++bw.k;
        }
        return imageArray;
    }

    public Image javax_microedition_lcdui_Image_b(int n2) {
        if (!this.var_boolean_b) {
            return this.javax_microedition_lcdui_Image_a(n2);
        }
        byte[] byArray = this.byte_arr_b(n2);
        int n3 = bq.a(byArray, 16, 8, byArray.length);
        int n4 = bq.a(byArray, 0, 8, byArray.length);
        int n5 = bq.int_a(byArray, n4 + 8);
        int n6 = bq.int_a(byArray, n4 + 12);
        byte by2 = byArray[n4 + 16];
        this.a(byArray, n3, n5, n6, by2);
        return Image.createImage((byte[])byArray, (int)0, (int)byArray.length);
    }

    public void void_a(int n2, int n3) {
        if (!this.var_boolean_a) {
            return;
        }
        this.b(this.var_byte_arr_c, this.var_int_b, 4, n2, n3);
    }

    private byte[] byte_arr_a(int n2) {
        char c2 = bq.char_a(this.var_byte_arr_c, 8 + 8 * n2);
        if (this.var_boolean_c && this.var_java_lang_Object_arr_a[c2] == null) {
            this.void_a();
            this.var_java_lang_Object_arr_a[c2] = as.a(this.var_java_lang_String_a.concat("_").concat(String.valueOf((int)c2)).concat(".mpd"));
        }
        return (byte[])this.var_java_lang_Object_arr_a[c2];
    }

    private byte[] byte_arr_b(int n2) {
        if (this.var_boolean_a) {
            byte[] byArray = this.byte_arr_a(n2);
            int n3 = 0;
            int n4 = bq.int_a(this.var_byte_arr_c, 8 + n2 * 8 + 2);
            int n5 = this.int_a(n2);
            int n6 = 0;
            n6 += 8;
            n6 += this.var_byte_arr_c.length - (bq.int_a(this.var_byte_arr_c, 4) * 8 + 8);
            n6 += n5;
            byte[] byArray2 = new byte[n6 += 12];
            System.arraycopy(var_byte_arr_a, 0, byArray2, n3, 8);
            n3 += 8;
            int n7 = bq.a(byArray, 0, n4, n5);
            if (n7 == -1) {
                return null;
            }
            int n8 = bq.int_a(byArray, n7) + 12;
            System.arraycopy(byArray, n7, byArray2, n3, n8);
            n3 += n8;
            block3: for (int i2 = 0; i2 < 18; ++i2) {
                if (!this.boolean_a(n2, i2)) continue;
                switch (i2) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 9: 
                    case 10: {
                        n7 = bq.a(byArray, i2, n4, n5);
                        if (n7 == -1) continue block3;
                        n8 = bq.int_a(byArray, n7) + 12;
                        System.arraycopy(byArray, n7, byArray2, n3, n8);
                        n3 += n8;
                    }
                }
            }
            n7 = this.var_int_b;
            n8 = bq.int_a(this.var_byte_arr_c, n7) + 12;
            System.arraycopy(this.var_byte_arr_c, n7, byArray2, n3, n8);
            n3 += n8;
            n7 = this.var_int_c;
            if (n7 != -1) {
                n8 = bq.int_a(this.var_byte_arr_c, n7) + 12;
                System.arraycopy(this.var_byte_arr_c, n7, byArray2, n3, n8);
                n3 += n8;
            }
            if (this.boolean_a(n2, 14) && (n7 = bq.a(byArray, 14, n4, n5)) != -1) {
                n8 = bq.int_a(byArray, n7) + 12;
                System.arraycopy(byArray, n7, byArray2, n3, n8);
                n3 += n8;
            }
            if (this.boolean_a(n2, 15) && (n7 = bq.a(byArray, 15, n4, n5)) != -1) {
                n8 = bq.int_a(byArray, n7) + 12;
                System.arraycopy(byArray, n7, byArray2, n3, n8);
                n3 += n8;
            }
            n7 = bq.a(byArray, 16, n4, n5);
            n8 = bq.int_a(byArray, n7) + 12;
            System.arraycopy(byArray, n7, byArray2, n3, n8);
            System.arraycopy(var_byte_arr_b, 0, byArray2, n3 += n8, 12);
            n3 += 12;
            return byArray2;
        }
        byte[] byArray = this.byte_arr_a(n2);
        int n9 = 0;
        int n10 = bq.int_a(this.var_byte_arr_c, 8 + n2 * 8 + 2);
        int n11 = this.int_a(n2);
        int n12 = 0;
        n12 += 8;
        n12 += n11;
        byte[] byArray3 = new byte[n12 += 12];
        System.arraycopy(var_byte_arr_a, 0, byArray3, n9, 8);
        System.arraycopy(byArray, n10, byArray3, n9 += 8, n11);
        System.arraycopy(var_byte_arr_b, 0, byArray3, n9 += n11, 12);
        n9 += 12;
        return byArray3;
    }

    private int int_a(int n2) {
        byte[] byArray = this.byte_arr_a(n2);
        int n3 = 0;
        int n4 = 0;
        n3 = bq.int_a(this.var_byte_arr_c, 8 + n2 * 8 + 2);
        n4 = n2 == this.int_a() - 1 || bq.char_a(this.var_byte_arr_c, 8 + n2 * 8) != bq.char_a(this.var_byte_arr_c, 8 + (n2 + 1) * 8) ? byArray.length : bq.int_a(this.var_byte_arr_c, 8 + (n2 + 1) * 8 + 2);
        return n4 - n3;
    }

    private static int a(byte[] byArray, int n2, int n3, int n4) {
        String string = var_java_lang_String_arr_a[n2];
        int n5 = n4 == -1 ? byArray.length : n3 + n4;
        for (int i2 = n3; i2 < n5; i2 += bq.int_a(byArray, i2) + 12) {
            if (byArray[i2 + 4] != string.charAt(0) || byArray[i2 + 5] != string.charAt(1) || byArray[i2 + 6] != string.charAt(2) || byArray[i2 + 7] != string.charAt(3)) continue;
            return i2;
        }
        return -1;
    }

    private static int int_a(byte[] byArray, int n2) {
        if (byArray.length - 4 < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int n3 = 0;
        n3 += (byArray[n2] & 0xFF) * 0x1000000;
        n3 += (byArray[n2 + 1] & 0xFF) * 65536;
        n3 += (byArray[n2 + 2] & 0xFF) * 256;
        return n3 += byArray[n2 + 3] & 0xFF;
    }

    private static char char_a(byte[] byArray, int n2) {
        if (byArray.length - 2 < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        char c2 = '\u0000';
        c2 = (char)(c2 + (byArray[n2] & 0xFF) * 256);
        c2 = (char)(c2 + (byArray[n2 + 1] & 0xFF));
        return c2;
    }

    private boolean boolean_a(int n2, int n3) {
        char c2 = this.var_char_arr_a[n2];
        if (n3 < 1 || n3 > 16) {
            return false;
        }
        return (c2 >> n3 - 1 & 1) == 1;
    }

    private static int b(byte[] byArray, int n2) {
        String string = var_java_lang_String_arr_a[n2];
        int n3 = byArray.length;
        for (int i2 = 0; i2 < n3 - 3; ++i2) {
            if (byArray[i2] != string.charAt(0) || byArray[i2 + 1] != string.charAt(1) || byArray[i2 + 2] != string.charAt(2) || byArray[i2 + 3] != string.charAt(3)) continue;
            return i2 - 4;
        }
        return -1;
    }

    private void a(byte[] byArray, int n2, int n3, int n4, int n5) {
        int n6;
        int n7;
        int n8 = 8 / n5;
        int n9 = n4;
        int n10 = (n3 - 1) / n8 + 1;
        byte by2 = (byte)(255 >> 8 - n5);
        int n11 = n2 + 15;
        int n12 = (n10 + 1) * n9;
        int n13 = n3 / 2;
        int n14 = n11 + n12;
        int n15 = n14 + 4;
        int n16 = n2 + 4;
        for (n7 = 0; n7 < n9; ++n7) {
            if (byArray[n11 + (n10 + 1) * n7] == 0) continue;
            return;
        }
        for (int i2 = 0; i2 < n9; ++i2) {
            n7 = n11 + (n10 + 1) * i2 + 1;
            for (int i3 = 0; i3 < n13; ++i3) {
                n6 = n3 - 1 - i3;
                int n17 = n7 + i3 / n8;
                int n18 = n7 + n6 / n8;
                int n19 = i3 % n8;
                int n20 = n6 % n8;
                byte by3 = (byte)((n8 - n19 - 1) * n5);
                byte by4 = (byte)((n8 - n20 - 1) * n5);
                byte by5 = (byte)(byArray[n17] >> by3 & by2);
                byte by6 = (byte)(byArray[n18] >> by4 & by2);
                byArray[n17] = (byte)(byArray[n17] & ~(by2 << by3) | by6 << by3);
                byArray[n18] = (byte)(byArray[n18] & ~(by2 << by4) | by5 << by4);
            }
        }
        this.c();
        this.b(byArray, n11, n12);
        long l2 = this.long_a();
        System.arraycopy(bq.c((int)l2), 0, byArray, n14, 4);
        this.void_b();
        this.a(byArray, n16, n12 + 15);
        n6 = this.int_b();
        System.arraycopy(bq.c(n6), 0, byArray, n15, 4);
    }

    private void b(byte[] byArray, int n2, int n3, int n4, int n5) {
        int n6;
        int n7 = bq.int_a(byArray, n2);
        int n8 = n2 + 8;
        int n9 = n8 + n7;
        switch (n3) {
            case 1: {
                for (n6 = 0; n6 < n7 / 3; ++n6) {
                    byte by2;
                    int n10 = byArray[n8 + n6 * 3] & 0xFF;
                    int n11 = byArray[n8 + n6 * 3 + 1] & 0xFF;
                    int n12 = byArray[n8 + n6 * 3 + 2] & 0xFF;
                    byArray[n8 + n6 * 3] = by2 = (byte)((n10 + n11 + n12) / 3);
                    byArray[n8 + n6 * 3 + 1] = by2;
                    byArray[n8 + n6 * 3 + 2] = by2;
                }
                break;
            }
            case 4: {
                n6 = (byte)(n4 >> 16 & 0xFF);
                byte by3 = (byte)(n4 >> 8 & 0xFF);
                byte by4 = (byte)(n4 & 0xFF);
                byte by5 = (byte)(n5 >> 16 & 0xFF);
                byte by6 = (byte)(n5 >> 8 & 0xFF);
                byte by7 = (byte)(n5 & 0xFF);
                for (int i2 = 0; i2 < n7 / 3; ++i2) {
                    if (byArray[n8 + i2 * 3] != n6 || byArray[n8 + i2 * 3 + 1] != by3 || byArray[n8 + i2 * 3 + 2] != by4) continue;
                    byArray[n8 + i2 * 3] = by5;
                    byArray[n8 + i2 * 3 + 1] = by6;
                    byArray[n8 + i2 * 3 + 2] = by7;
                }
                break;
            }
        }
        this.void_b();
        this.a(byArray, n2 + 4, n7 + 4);
        n6 = this.int_b();
        System.arraycopy(bq.c(n6), 0, byArray, n9, 4);
    }

    private static byte[] c(int n2) {
        byte[] byArray = new byte[]{(byte)(n2 >> 24 & 0xFF), (byte)(n2 >> 16 & 0xFF), (byte)(n2 >> 8 & 0xFF), (byte)(n2 & 0xFF)};
        return byArray;
    }

    public void void_b() {
        this.d = -1;
    }

    public void a(byte[] byArray, int n2, int n3) {
        for (int i2 = n2; i2 < n3 + n2; ++i2) {
            this.d = this.d >>> 8 & 0xFFFFFF ^ var_int_arr_b[(this.d ^ byArray[i2]) & 0xFF];
        }
    }

    public int int_b() {
        return ~this.d;
    }

    public void b(byte[] byArray, int n2, int n3) {
        int n4 = this.e & 0xFFFF;
        int n5 = this.e >> 16 & 0xFFFF;
        while (n3 > 0) {
            int n6 = n3 < 5552 ? n3 : 5552;
            n3 -= n6;
            while (n6-- > 0) {
                n5 += (n4 += byArray[n2++] & 0xFF);
            }
            n4 %= 65521;
            n5 %= 65521;
        }
        this.e = n5 << 16 | n4;
    }

    public void c() {
        this.e = 1;
    }

    public long long_a() {
        return (long)this.e & 0xFFFFFFFFFFFFFFFFL;
    }

    static {
        var_java_lang_String_arr_a = new String[]{"IHDR", "cHRM", "gAMA", "iCCP", "sBIT", "sRGB", "tEXt", "zTXt", "iTXt", "pHYs", "sPLT", "tIME", "PLTE", "tRNS", "hIST", "bKGD", "IDAT", "IEND"};
        var_byte_arr_a = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        var_byte_arr_b = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
        var_int_arr_b = new int[256];
        for (int n2 = 0; n2 < 256; n2 = (int)((short)(n2 + 1))) {
            int n3 = n2;
            for (int n4 = 1; n4 < 9; n4 = (int)((byte)(n4 + 1))) {
                n3 = (n3 & 1) == 1 ? n3 >>> 1 ^ 0xEDB88320 : n3 >>> 1;
            }
            bq.var_int_arr_b[n2] = n3;
        }
    }
}

