/*
 * Decompiled with CFR 0.152.
 */
public class ar
extends ap {
    public static final byte[] i = new byte[]{9, 6, 9, 13, 3, 16, 6, 14, 7};
    public static final byte[] j = new byte[]{40, 40, 9, 13, 3, 16, 6, 14, 7};
    public static final byte[] var_byte_arr_k;
    public byte var_byte_a = 0;
    public byte var_byte_k = 0;
    public int var_int_a = 0;
    public byte l = 0;

    public ar(byte by2, byte by3, int n2, byte by4, byte by5, byte by6, int n3) {
        super(by2, by6, by4, by5, true);
        this.var_byte_a = by3;
        this.var_byte_k = 0;
        this.var_int_a = n2;
        this.var_short_a = j[by2];
        this.l = ax.h[u.var_b_a.var_cg_a.j[this.var_byte_a]];
        if (n3 < 0) {
            this.var_short_b = (short)(this.var_short_b - (short)f.a(0, 4));
        } else {
            this.var_short_a = (short)(this.var_short_a * n3);
        }
    }

    public ar(byte by2, byte by3, byte by4, int n2, byte by5, byte by6, byte by7) {
        this(by2, by3, n2, by5, by6, by7, -1);
        this.var_byte_k = by4;
    }

    public void a() {
        if (this.var_short_b < 0) {
            return;
        }
        if (this.var_short_b % i[this.d] == var_byte_arr_k[this.d]) {
            switch (this.d) {
                case 4: 
                case 6: 
                case 8: {
                    for (int i2 = 0; i2 <= 4; ++i2) {
                        this.a(this.h + ax.var_byte_arr_a[i2], ((bl)this).i + ax.var_byte_arr_b[i2], this.l);
                    }
                    break;
                }
                default: {
                    this.a((int)this.h, (int)((bl)this).i, this.l);
                }
            }
            ak.a((byte)3);
        }
        if (this.d == 2) {
            u.var_ah_a.void_a(5, (int)this.var_short_b);
        } else if (this.d == 3) {
            this.a((byte)4);
        } else if (this.d == 5) {
            this.a((byte)6);
        } else if (this.d == 7) {
            this.a((byte)8);
        }
        if (this.var_short_b >= this.var_short_a) {
            this.var_boolean_a = true;
            if (this.d == 3 || this.d == 5 || this.d == 7) {
                ah.g();
            }
        }
    }

    public void a(int n2, int n3, byte by2) {
        if (!u.var_ah_a.boolean_c(n2, n3)) {
            return;
        }
        bl bl2 = u.var_ah_a.var_bl_arr_arr_a[n3][n2];
        if (bl2 != null && bl2 instanceof ag) {
            ((ag)bl2).a(this.var_int_a, this.e, by2);
        }
    }

    public void a(int n2, int n3) {
        if (this.var_short_b < 0) {
            return;
        }
        bd.a((int)this.var_byte_a, this.var_byte_k, this.var_short_b % i[this.d], n2, n3);
    }

    public void a(byte by2) {
        int n2 = this.var_short_b % this.var_short_a;
        switch (n2) {
            case 5: {
                this.a(by2, -2, 0);
                this.a(by2, 1, -1);
                this.a(by2, 4, -4);
                ak.a((byte)3);
                break;
            }
            case 6: {
                this.a(by2, -4, -1);
                this.a(by2, 2, 2);
                this.a(by2, 3, 0);
                break;
            }
            case 7: {
                this.a(by2, -3, 2);
                this.a(by2, -1, -2);
                break;
            }
            case 8: {
                this.a(by2, 0, 1);
                this.a(by2, 2, -3);
                this.a(by2, 4, 2);
                break;
            }
            case 9: {
                this.a(by2, -3, -3);
                this.a(by2, -2, 4);
                this.a(by2, 1, 4);
                break;
            }
            case 10: {
                this.a(by2, -4, 1);
                this.a(by2, -1, 3);
                this.a(by2, 0, -4);
                break;
            }
            case 12: {
                ah.g();
            }
        }
        if (n2 > 4 && n2 < 12) {
            u.var_ah_a.void_b(by2 == 7 ? 5 : 2, n2);
        }
        this.d();
    }

    public void d() {
        int n2 = this.var_short_b % this.var_short_a;
        switch (this.d) {
            case 3: {
                ah.a(n2 < 12 ? 0 : 1);
                break;
            }
            case 5: {
                ah.a(n2 == 5 ? 1 : 0);
                break;
            }
            case 7: {
                if (n2 == 13) {
                    ah.a(1);
                    break;
                }
                if (n2 <= 1) break;
                ah.a(0);
            }
        }
    }

    public void a(byte by2, int n2, int n3) {
        this.a(by2, n2, n3, (byte)1);
    }

    public void a(byte by2, int n2, int n3, byte by3) {
        int n4 = this.h + n2;
        int n5 = ((bl)this).i + n3;
        if (n4 < 0 || n5 < 0) {
            return;
        }
        u.var_ah_a.d(new ar(by2, this.var_byte_a, by3, this.var_int_a, (byte)n4, (byte)n5, this.e));
    }

    static {
        var_byte_arr_k = new byte[]{1, 2, 3, 1, 2, 1, 1, 1, 1};
    }
}

