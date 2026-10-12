/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;

public class cp
implements ax {
    public byte g;
    public byte h;
    public int c;
    public int d;
    public int e = 0;
    public int f;
    public byte[] j;
    public byte[] k;

    public cp(int n2, int n3) {
        this.g = (byte)n2;
        this.h = (byte)n3;
        this.c = 1;
    }

    public static final cp a(byte by2, byte by3, boolean bl2, boolean bl3) {
        cp cp2 = null;
        switch (by2) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                cp2 = new cf(by2, by3);
                break;
            }
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: {
                cp2 = new am(by2, by3);
                break;
            }
            case 11: 
            case 12: {
                cp2 = new q(by2, by3);
                break;
            }
            case 23: {
                cp2 = new s(by2, by3);
                break;
            }
            case 21: {
                cp2 = new ch(by2, by3);
                break;
            }
            case 34: {
                cp2 = new v(by2, by3);
                break;
            }
            default: {
                cp2 = new cp(by2, by3);
            }
        }
        if (bl2) {
            super.void_a();
        }
        cp2.a(bl2, bl3);
        return cp2;
    }

    public static final Vector[] java_util_Vector_arr_a() {
        Vector[] vectorArray = new Vector[11];
        for (int i2 = 0; i2 < 11; ++i2) {
            vectorArray[i2] = new Vector();
        }
        ++bw.k;
        byte[] byArray = as.a("/itm/forshop");
        int n2 = 0;
        while (n2 < byArray.length) {
            byte by2 = byArray[n2++];
            cp cp2 = cp.a(byArray[n2], byArray[n2 + 1], true, false);
            n2 += by2;
            switch (cp2.g) {
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: {
                    vectorArray[cp2.g].addElement(cp2);
                    break;
                }
                case 8: 
                case 9: 
                case 10: {
                    vectorArray[cp2.g - 1].addElement(cp2);
                    break;
                }
                case 11: {
                    vectorArray[11].addElement(cp2);
                    break;
                }
                case 12: {
                    vectorArray[12].addElement(cp2);
                    break;
                }
                default: {
                    vectorArray[10].addElement(cp2);
                }
            }
            ++bw.k;
        }
        for (int i3 = 0; i3 < 11; ++i3) {
            vectorArray[i3].trimToSize();
        }
        return vectorArray;
    }

    public void a(boolean bl2, boolean bl3) {
        byte[] byArray = as.byte_arr_a(this.g, this.h);
        int n2 = 0;
        this.a(byArray, n2, bl2, bl3);
    }

    public int a(byte[] byArray, int n2, boolean bl2, boolean bl3) {
        byte by2;
        if (bl2) {
            this.d = f.int_b(byArray, n2);
        }
        n2 += 4;
        byte by3 = byArray[n2++];
        if (bl2) {
            this.j = new byte[by3];
            System.arraycopy(byArray, n2, this.j, 0, by3);
        }
        n2 += by3;
        if ((by2 = byArray[n2++]) == 0) {
            return n2;
        }
        this.k = new byte[by2];
        System.arraycopy(byArray, n2, this.k, 0, by2);
        return n2 += by2;
    }

    public byte[] byte_arr_a() {
        int n2 = this.j.length;
        int n3 = 11 + n2 + 4 + 4;
        byte[] byArray = new byte[n3];
        int n4 = 0;
        byArray[n4++] = this.g;
        byArray[n4++] = this.h;
        f.a(this.c, byArray, n4);
        f.a(this.f, byArray, n4 += 4);
        n4 += 4;
        byArray[n4++] = (byte)n2;
        System.arraycopy(this.j, 0, byArray, n4, n2);
        f.a(this.d, byArray, n4 += n2);
        f.a(this.e, byArray, n4 += 4);
        return byArray;
    }

    public static final synchronized cp a(byte[] byArray) {
        int n2 = 0;
        byte by2 = byArray[n2++];
        byte by3 = byArray[n2++];
        cp cp2 = cp.a(by2, by3, false, false);
        try {
            cp2.a(byArray, n2);
            if (cp2 instanceof p && ((p)cp2).e != cp.a(cp2)) {
                return null;
            }
        }
        catch (Exception exception) {
            cp2 = null;
            exception.printStackTrace();
        }
        return cp2;
    }

    public int a(byte[] byArray, int n2) throws Exception {
        byte by2;
        this.c = f.int_a(byArray, n2);
        this.f = f.int_a(byArray, n2 += 4);
        n2 += 4;
        if ((by2 = byArray[n2++]) > 0) {
            this.j = new byte[by2];
            System.arraycopy(byArray, n2, this.j, 0, by2);
            n2 += by2;
        } else {
            this.j = null;
        }
        this.d = f.int_a(byArray, n2);
        this.e = f.int_a(byArray, n2 += 4);
        return n2 += 4;
    }

    public final void a(byte by2) {
        this.c += by2;
    }

    public final void a(int n2) {
        this.c -= n2;
    }

    private void void_a() {
        this.f = f.a(1000, 2000000000);
    }

    public final byte[] a(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
        return byArray3;
    }

    public static byte a(cp cp2) {
        byte by2 = 0;
        switch (cp2.g) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                by2 = ((cf)cp2).byte_a();
                break;
            }
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: {
                by2 = ((am)cp2).byte_a();
                break;
            }
            case 11: 
            case 12: {
                by2 = ((q)cp2).byte_a();
            }
        }
        return by2;
    }
}

