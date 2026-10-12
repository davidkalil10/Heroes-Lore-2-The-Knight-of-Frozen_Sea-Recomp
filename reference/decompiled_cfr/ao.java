/*
 * Decompiled with CFR 0.152.
 */
public class ao {
    public byte var_byte_a;
    public byte[] var_byte_arr_a;
    public byte[] b;
    public byte[] c;

    public ao(byte by2, byte[] byArray) {
        this.var_byte_a = by2;
        this.var_byte_arr_a = new byte[this.var_byte_a];
        this.b = new byte[this.var_byte_a];
        this.c = new byte[this.var_byte_a];
        int n2 = 0;
        for (int i2 = 0; i2 < this.var_byte_a; ++i2) {
            this.var_byte_arr_a[i2] = u.var_ah_a.byte_a(byArray[n2++]);
            this.b[i2] = byArray[n2++];
            this.c[i2] = byArray[n2++];
        }
    }
}

