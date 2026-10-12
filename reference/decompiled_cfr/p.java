/*
 * Decompiled with CFR 0.152.
 */
public class p
extends cp {
    public byte a;
    public byte b;
    public byte c;
    public byte d;
    public byte e;
    public byte f;
    public byte[] i = new byte[]{0, 0, 0, 0, 0};

    public p(byte by2, byte by3) {
        super(by2, by3);
        this.f = (byte)-1;
    }

    public int a(byte[] byArray, int n2, boolean bl2, boolean bl3) {
        n2 = super.a(byArray, n2, bl2, bl3);
        if (bl2) {
            this.a = byArray[n2++];
            this.b = byArray[n2++];
            this.c = byArray[n2++];
            if (bl3) {
                int n3 = this.g == 11 || this.g == 12 ? byArray[n2++] : f.a(0, (int)byArray[n2++]);
                byte[] byArray2 = new byte[10];
                System.arraycopy(byArray, n2, byArray2, 0, 10);
                n2 += 10;
                int n4 = 0;
                if (this.g == 11 || this.g == 12) {
                    for (int i2 = 0; i2 < 5; ++i2) {
                        this.i[i2] = (byte)f.a(byArray2[i2 * 2], (int)byArray2[i2 * 2 + 1]);
                    }
                } else if (n3 > 0) {
                    for (int i3 = 0; i3 < n3; ++i3) {
                        int n5;
                        n4 = 0;
                        do {
                            n5 = f.a(0, 4);
                        } while (++n4 <= 10 && (this.i[n5] != 0 || byArray2[n5 * 2] == 0 && byArray2[n5 * 2 + 1] == 0));
                        this.i[n5] = (byte)f.a(byArray2[n5 * 2], (int)byArray2[n5 * 2 + 1]);
                    }
                }
            } else {
                n2 += 11;
            }
        } else {
            n2 += 14;
        }
        return n2;
    }

    public byte[] byte_arr_a() {
        byte[] byArray = super.byte_arr_a();
        byte[] byArray2 = new byte[10];
        int n2 = 0;
        byArray2[n2++] = this.a;
        byArray2[n2++] = this.b;
        byArray2[n2++] = this.c;
        byArray2[n2++] = this.e;
        byArray2[n2++] = this.f;
        System.arraycopy(this.i, 0, byArray2, n2, 5);
        return this.a(byArray, byArray2);
    }

    public int a(byte[] byArray, int n2) throws Exception {
        n2 = super.a(byArray, n2);
        this.a = byArray[n2++];
        this.b = byArray[n2++];
        this.c = byArray[n2++];
        this.e = byArray[n2++];
        this.f = byArray[n2++];
        this.i = new byte[5];
        System.arraycopy(byArray, n2, this.i, 0, 5);
        return n2 += 5;
    }

    public byte byte_a() {
        int n2 = ((this.i[0] << 1) + (this.i[1] << 2) + (this.i[2] << 2) + (this.i[3] << 1) + (this.i[4] << 1) + (this.d << 2) + this.a(((cp)this).f, 1000)) % 100;
        return (byte)n2;
    }

    private final int a(int n2, int n3) {
        return n2 / n3 % 10;
    }
}

