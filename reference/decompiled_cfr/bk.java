/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import java.io.ByteArrayInputStream;
import javax.microedition.lcdui.Graphics;

public class bk {
    public static boolean var_boolean_a;
    public static boolean var_boolean_b;
    private static byte[] var_byte_arr_a;
    private static final byte[] var_byte_arr_b;
    private static final int[] var_int_arr_a;
    private static byte[] var_byte_arr_c;
    private static byte[] d;
    private static byte[][] var_byte_arr_arr_a;
    private static byte[][] var_byte_arr_arr_b;
    private static byte[][] var_byte_arr_arr_c;
    private static byte[] e;
    static byte[] f;
    static byte[] g;
    static byte[] h;

    public static void a(Graphics graphics, int n2, int n3, byte[] byArray, int n4) {
        bk.a(graphics, n2, n3, 1000, n4, byArray, 0, 0, byArray.length);
    }

    public static void a(Graphics graphics, int n2, int n3, int n4, int n5, byte[] byArray) {
        bk.a(graphics, n2, n3, n4, n5, byArray, 0, 0, byArray.length);
    }

    public static void a(Graphics graphics, int n2, int n3, byte[] byArray, int n4, int n5) {
        int n6 = bk.a(byArray);
        switch (n5) {
            case 4: {
                n6 = 0;
                break;
            }
            case 1: {
                n6 /= 2;
            }
        }
        bk.a(graphics, n2 - n6, n3, 1000, n4, byArray, 0, 0, byArray.length);
    }

    public static void a(Graphics graphics, String string, int n2, int n3, int n4) {
        bk.a(graphics, n2, n3, string.getBytes(), 0, n4);
    }

    public static void a(Graphics graphics, int n2, int n3, int n4, int n5, byte[] byArray, int n6, int n7, int n8) {
        int n9;
        int n10;
        int n11;
        if (!var_boolean_a) {
            return;
        }
        int n12 = n6;
        int n13 = n2;
        int n14 = n3;
        byte[] byArray2 = new byte[32];
        int n15 = 0;
        for (n11 = 0; n11 < n6; ++n11) {
            int n16 = n11;
            n10 = bk.j(byArray[n16], byArray, n16);
            if (n10 == -1 || !var_boolean_b) continue;
            graphics.setColor(n10);
        }
        while (n12 < n6 + n7) {
            if ((byArray[n12] & 0x80) != 0) {
                if (n15 + 8 > n4) {
                    n15 = 0;
                    n13 = n2;
                    n14 += 14;
                    continue;
                }
                n12 += 2;
                n15 += 9;
                continue;
            }
            int n17 = n12++;
            n9 = bk.j(byArray[n17], byArray, n17);
            if (n9 != -1 && var_boolean_b) {
                graphics.setColor(n9);
                continue;
            }
            if (n15 == 0 && byArray[n12] == 32) {
                ++n12;
                continue;
            }
            if (bk.l(byArray, n12, n6)) {
                n9 = bk.k(byArray, n12, n4);
                if (n15 > 0 && n15 + n9 > n4) {
                    n15 = 0;
                    n13 = n2;
                    n14 += 14;
                    continue;
                }
            }
            if (n15 + g[byArray[n12] - 32] > n4 || byArray[n12] == 59) {
                n15 = 0;
                n13 = n2;
                n14 += 14;
                if (byArray[n12] != 59) continue;
                ++n12;
                continue;
            }
            n15 = g[byArray[n12] - 32] + n15;
            ++n12;
        }
        n13 += n15;
        while (n12 < byArray.length && n12 < n6 + n8) {
            int n18;
            int n19;
            int n20;
            byte by2;
            int n21;
            int n22;
            int n23;
            byte by3;
            int n24;
            int n25;
            int n26;
            int n27;
            n9 = n13;
            int n28 = n14;
            if ((byArray[n12] & 0x80) != 0) {
                if (n15 + 8 > n4) {
                    n15 = 0;
                    n13 = n2;
                    n14 += 14;
                    continue;
                }
                n27 = (byte)(byArray[n12++] & 0xFF) - -80;
                n26 = (byte)(byArray[n12++] & 0xFF) - -95;
                n25 = n27 * 188 + n26 * 2;
                n24 = (var_byte_arr_a[n25] & 0xFF) << 8 | var_byte_arr_a[n25 + 1] & 0xFF;
                by3 = 0;
                n23 = var_byte_arr_arr_a[0][(n24 & 0x7C00) >> 10];
                n22 = var_byte_arr_arr_a[1][(n24 & 0x3E0) >> 5];
                n21 = var_byte_arr_arr_a[2][n24 & 0x1F];
                if (n21 != 0) {
                    by3 = 1;
                }
                by2 = e[n22];
                n20 = var_byte_arr_arr_c[by3][n23];
                n19 = var_byte_arr_arr_b[by3][n22];
                System.arraycopy(var_byte_arr_c, 0 + n19 * 20 * 10 + n23 * 10, byArray2, 0, 10);
                if (n22 != 0) {
                    n18 = 1600 + n20 * 22 * 10 + n22 * 10;
                    for (n11 = 0; n11 < 10; ++n11) {
                        int n29 = n11;
                        byArray2[n29] = (byte)(byArray2[n29] | var_byte_arr_c[n18 + n11]);
                    }
                }
                if (n21 != 0) {
                    n18 = 2480 + by2 * 28 * 10 + n21 * 10;
                    for (n11 = 0; n11 < 10; ++n11) {
                        int n30 = n11;
                        byArray2[n30] = (byte)(byArray2[n30] | var_byte_arr_c[n18 + n11]);
                    }
                }
                for (int i2 = 0; i2 < 10; ++i2) {
                    for (n11 = 0; n11 < 8; ++n11) {
                        n10 = byArray2[i2] << n11 & 0x80;
                        if (n10 != 0) {
                            graphics.drawLine(n9, n28, n9, n28);
                        }
                        ++n9;
                    }
                    n9 = n13;
                    ++n28;
                }
                n13 += 9;
                n15 += 9;
                continue;
            }
            int n31 = n12++;
            n24 = bk.j(byArray[n31], byArray, n31);
            if (n24 != -1 && var_boolean_b) {
                graphics.setColor(n24);
                continue;
            }
            if (n15 == 0 && byArray[n12] == 32) {
                ++n12;
                continue;
            }
            if (bk.l(byArray, n12, n6)) {
                n24 = bk.k(byArray, n12, n4);
                if (n15 > 0 && n15 + n24 > n4) {
                    n15 = 0;
                    n13 = n2;
                    n14 += 14;
                    continue;
                }
            }
            if (n15 + g[byArray[n12] - 32] > n4 || byArray[n12] == 59) {
                n15 = 0;
                n13 = n2;
                n14 += 14;
                if (byArray[n12] != 59) continue;
                ++n12;
                continue;
            }
            n20 = byArray[n12++] - 32;
            n27 = n20 * 24;
            by3 = h[n20];
            n18 = g[n20] - 1;
            n25 = n27;
            for (n26 = 0; n26 < 12; ++n26) {
                n23 = f[n25] & 0xFF;
                n22 = f[n25 + 1] & 0xFF;
                n21 = n23 << 8 | n22;
                for (n19 = 0; n19 < n18; ++n19) {
                    if ((n21 >>> 15 - (by3 + n19) & 1) != 0) {
                        graphics.drawLine(n9, n28 - 2, n9, n28 - 2);
                    }
                    ++n9;
                }
                n9 = n13;
                ++n28;
                n25 += 2;
            }
            by2 = g[n20];
            n13 += by2;
            n15 += by2;
        }
    }

    public static final int a(byte[] byArray, int n2, int n3, int n4) {
        int n5 = n2;
        int n6 = 0;
        int n7 = 0;
        int n8 = -1;
        while (n6 < n4 && n2 < byArray.length) {
            byte by2 = byArray[n2];
            if (by2 == 32 && n7 == 0) {
                ++n2;
                continue;
            }
            if ((by2 & 0x80) != 0) {
                if (n7 + 8 <= n3) {
                    n7 += 9;
                    n2 += 2;
                    continue;
                }
                if (n8 != -1) {
                    n2 = n8;
                }
                ++n6;
                n7 = 0;
                n8 = -1;
                continue;
            }
            if (bk.boolean_a(byArray[n2])) {
                if (by2 == 59) {
                    ++n6;
                    n7 = 0;
                    n8 = -1;
                }
                ++n2;
                continue;
            }
            if (n7 + 5 <= n3) {
                if (by2 == 32) {
                    n8 = n2 + 1;
                }
                n7 = g[by2 - 32] + n7;
                ++n2;
                continue;
            }
            if (n8 != -1) {
                n2 = n8;
            }
            ++n6;
            n7 = 0;
            n8 = -1;
        }
        return n2 - n5;
    }

    public static final int a(byte[] byArray, int n2, int n3) {
        int n4 = n2 + n3;
        boolean bl2 = false;
        while (n4 < byArray.length) {
            if (byArray[n4] == 32 || bk.boolean_a(byArray[n4])) {
                ++n4;
                continue;
            }
            if ((byArray[n4] & 0x80) != 0) {
                if (bl2) {
                    return n4 + 2 - n2;
                }
                bl2 = true;
                n4 += 2;
                continue;
            }
            if (bl2) {
                return n4 + 1 - n2;
            }
            bl2 = true;
            ++n4;
        }
        return byArray.length - n2;
    }

    public static final int a(byte[] byArray, int n2) {
        int n3 = 0;
        int n4 = bk.a(byArray, 0, n2, n3);
        while (n4 < byArray.length) {
            n4 = bk.a(byArray, 0, n2, ++n3);
        }
        return n3;
    }

    public static final int a(byte[] byArray) {
        int n2 = 0;
        int n3 = 0;
        while (n3 < byArray.length) {
            byte by2 = byArray[n3];
            if ((by2 & 0x80) != 0) {
                n2 += 9;
                n3 += 2;
                continue;
            }
            int n4 = by2 - 32;
            if (n4 >= 0 && n4 < g.length) {
                n2 += g[n4] & 0xFF;
                ++n3;
                continue;
            }
            n2 += 6;
            ++n3;
        }
        return n2;
    }

    private static final boolean boolean_a(byte by2) {
        if (by2 == 59) {
            return true;
        }
        for (int i2 = 0; i2 < var_byte_arr_b.length; ++i2) {
            if (by2 != var_byte_arr_b[i2]) continue;
            return true;
        }
        return false;
    }

    private static final int int_a(byte by2) {
        for (int i2 = 0; i2 < var_byte_arr_b.length; ++i2) {
            if (by2 != var_byte_arr_b[i2]) continue;
            return var_int_arr_a[i2];
        }
        return -1;
    }

    public static final void a() {
        var_byte_arr_a = as.a("/ftd/table");
        var_byte_arr_c = as.a("/ftd/kor");
        d = as.a("/ftd/eng5");
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(as.a("/ftd/etc"));
            byteArrayInputStream.read(var_byte_arr_arr_a[0]);
            byteArrayInputStream.read(var_byte_arr_arr_a[1]);
            byteArrayInputStream.read(var_byte_arr_arr_a[2]);
            byteArrayInputStream.read(var_byte_arr_arr_b[0]);
            byteArrayInputStream.read(var_byte_arr_arr_b[1]);
            byteArrayInputStream.read(var_byte_arr_arr_c[0]);
            byteArrayInputStream.read(var_byte_arr_arr_c[1]);
            byteArrayInputStream.read(e);
        }
        catch (Exception exception) {
            // empty catch block
        }
        f = as.a("/ftd/eng12");
        g = as.a("/ftd/eng12w");
        h = as.a("/ftd/eng12l");
        var_boolean_a = true;
    }

    static {
        var_boolean_a = false;
        var_boolean_b = true;
        var_byte_arr_b = new byte[]{64, 124, 36, 123, 125, 39};
        var_int_arr_a = new int[]{0xFFFFFF, 0xFFFF00, 1630207, 0xFF9F3F, 14597755, 65280};
        var_byte_arr_arr_a = new byte[3][31];
        var_byte_arr_arr_b = new byte[2][22];
        var_byte_arr_arr_c = new byte[2][20];
        e = new byte[22];
    }

    static int j(byte by2, byte[] byArray, int n2) {
        if (by2 == 39) {
            int n3 = n2 + 1 < byArray.length ? byArray[n2 + 1] : 0;
            if (!(n3 >= 97 && n3 <= 122 || n3 >= 65 && n3 <= 90)) {
                return bk.int_a((byte)39);
            }
            return -1;
        }
        if (by2 == 64) {
            if (n2 < 7) {
                return bk.int_a((byte)64);
            }
            if (byArray[n2 - 7] == 83 && byArray[n2 - 6] == 85 && byArray[n2 - 5] == 80 && byArray[n2 - 4] == 80 && byArray[n2 - 3] == 79 && byArray[n2 - 2] == 82 && byArray[n2 - 1] == 84) {
                return -1;
            }
            return bk.int_a((byte)64);
        }
        return bk.int_a(by2);
    }

    static int k(byte[] byArray, int n2, int n3) {
        byte by2;
        int n4 = 0;
        while (n2 < byArray.length && (by2 = byArray[n2]) != 32 && by2 != 59) {
            if ((by2 & 0x80) != 0) {
                n4 += 9;
                n2 += 2;
            } else {
                int n5 = bk.j(by2, byArray, n2);
                if (n5 != -1 && var_boolean_b) {
                    ++n2;
                } else {
                    n4 = g[by2 - 32] + n4;
                    ++n2;
                }
            }
            if (n4 <= n3) continue;
        }
        return n4;
    }

    static boolean l(byte[] byArray, int n2, int n3) {
        for (int i2 = n2 - 1; i2 >= n3; --i2) {
            byte by2 = byArray[i2];
            if (by2 == 32) {
                return true;
            }
            int n4 = bk.j(by2, byArray, i2);
            if (n4 != -1 && var_boolean_b) {
                continue;
            }
            return false;
        }
        return true;
    }
}

