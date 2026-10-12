/*
 * Decompiled with CFR 0.152.
 */
public class q
extends p {
    public short var_short_a;
    public short var_short_b;
    public int var_int_a;
    public int var_int_b;

    public q(byte by2, byte by3) {
        super(by2, by3);
    }

    public int a(byte[] byArray, int n2, boolean bl2, boolean bl3) {
        n2 = super.a(byArray, n2, bl2, bl3);
        if (bl3) {
            byte[] byArray2 = new byte[4];
            System.arraycopy(byArray, n2, byArray2, 0, 4);
            n2 += 4;
            int[] nArray = new int[4];
            for (int i2 = 0; i2 < 4; ++i2) {
                nArray[i2] = f.int_b(byArray, n2);
                n2 += 4;
            }
            this.var_short_a = (byte)f.a(byArray2[0], (int)byArray2[1]);
            this.var_short_b = (byte)f.a(byArray2[2], (int)byArray2[3]);
            this.var_int_a = f.a(nArray[0], nArray[1]);
            this.var_int_b = f.a(nArray[2], nArray[3]);
        } else {
            n2 += 20;
        }
        if (bl2) {
            this.e = this.byte_a();
        }
        return n2;
    }

    public byte[] byte_arr_a() {
        byte[] byArray = super.byte_arr_a();
        byte[] byArray2 = new byte[12];
        int n2 = 0;
        f.a(this.var_short_a, byArray2, n2);
        f.a(this.var_short_b, byArray2, n2 += 2);
        f.a(this.var_int_a, byArray2, n2 += 2);
        f.a(this.var_int_b, byArray2, n2 += 4);
        return this.a(byArray, byArray2);
    }

    public int a(byte[] byArray, int n2) throws Exception {
        n2 = super.a(byArray, n2);
        this.var_short_a = f.short_b(byArray, n2);
        this.var_short_b = f.short_b(byArray, n2 += 2);
        this.var_int_a = f.int_a(byArray, n2 += 2);
        this.var_int_b = f.int_a(byArray, n2 += 4);
        return n2 += 4;
    }

    public byte byte_a() {
        byte by2 = super.byte_a();
        int n2 = (by2 + (this.var_short_a << 1) + (this.var_short_b << 2) + this.var_int_a + this.var_int_b) % 100;
        return (byte)n2;
    }
}

