/*
 * Decompiled with CFR 0.152.
 */
public class am
extends p {
    public byte k;
    public byte l;
    public short a;
    public byte m;
    public byte n;
    public byte o;
    public short b;

    public am(byte by2, byte by3) {
        super(by2, by3);
    }

    public int a(byte[] byArray, int n2, boolean bl2, boolean bl3) {
        n2 = super.a(byArray, n2, bl2, bl3);
        return this.a(byArray, n2, true);
    }

    private int a(byte[] byArray, int n2, boolean bl2) {
        this.k = byArray[n2++];
        this.l = byArray[n2++];
        this.a = bl2 ? (short)f.int_b(byArray, n2) : f.short_b(byArray, n2);
        n2 += bl2 ? 4 : 2;
        this.d = bl2 ? (byte)0 : byArray[n2++];
        this.m = byArray[n2++];
        this.n = byArray[n2++];
        if (bl2) {
            this.o = byArray[n2++];
        }
        this.b = bl2 ? (short)f.int_b(byArray, n2) : f.short_b(byArray, n2);
        n2 += bl2 ? 4 : 2;
        if (bl2) {
            this.e = this.byte_a();
        }
        return n2;
    }

    public int a(byte[] byArray, int n2) throws Exception {
        n2 = super.a(byArray, n2);
        n2 = this.a(byArray, n2, false);
        return n2;
    }

    public byte[] byte_arr_a() {
        byte[] byArray = super.byte_arr_a();
        byte[] byArray2 = new byte[9];
        int n2 = 0;
        byArray2[n2++] = this.k;
        byArray2[n2++] = this.l;
        f.a(this.a, byArray2, n2);
        n2 += 2;
        byArray2[n2++] = this.d;
        byArray2[n2++] = this.m;
        byArray2[n2++] = this.n;
        f.a(this.b, byArray2, n2);
        return this.a(byArray, byArray2);
    }

    public final int int_a() {
        return this.b + (this.d * 3 >> 1);
    }

    public byte byte_a() {
        byte by2 = super.byte_a();
        int n2 = (by2 + (this.n << 3) + this.b) % 100;
        return (byte)n2;
    }
}

