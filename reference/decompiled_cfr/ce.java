/*
 * Decompiled with CFR 0.152.
 */
public class ce
extends b {
    public static final short[] a = new short[]{80, 60, 120, 260, 260, 120, 160};

    public ce(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, by2, by3);
        this.void_a();
    }

    public void void_a() {
        super.void_a();
        this.var_short_e = (short)13;
        this.var_short_f = (short)12;
        this.var_short_g = (short)9;
        this.var_short_h = (short)11;
        this.var_short_i = (short)10;
    }

    public byte byte_a(int n2) {
        if (n2 < 4) {
            return (byte)(n2 + 1);
        }
        if (n2 == 13) {
            return 1;
        }
        if (n2 >= 11) {
            return 3;
        }
        return 5;
    }

    public byte byte_a(byte by2) {
        if (by2 == 9) {
            return 4;
        }
        if (by2 == 10) {
            return (byte)(by2 - 1);
        }
        return by2;
    }

    public boolean boolean_a() {
        byte by2 = this.var_byte_arr_o[this.var_byte_d];
        switch (by2) {
            case 0: 
            case 1: 
            case 2: {
                if (this.var_byte_v != 2) break;
                return this.boolean_h(by2);
            }
            case 3: {
                if (this.var_byte_v == 2) {
                    this.var_boolean_b = true;
                    break;
                }
                if (this.var_byte_v != 3) break;
                return this.boolean_h(by2);
            }
            case 4: 
            case 9: {
                u.var_ah_a.void_a(4, (int)this.var_byte_v);
                if (this.var_byte_v < 2 || this.var_byte_v > 5) break;
                if (this.b(by2, (byte)(this.var_byte_v - 2))) {
                    ak.a((byte)0);
                    break;
                }
                return false;
            }
            case 5: {
                if (this.var_byte_v == 1) {
                    ak.a((byte)5);
                } else if (this.var_byte_v == 2) {
                    boolean bl2 = false;
                    this.var_byte_q = 0;
                    if (this.boolean_e(by2)) {
                        bl2 = true;
                    }
                    if (this.boolean_f()) {
                        int n2 = this.int_a();
                        if (this.var_byte_q == 2 && this.d(by2, this.var_byte_t, n2)) {
                            bl2 = true;
                        }
                        this.f(16 * this.var_byte_q);
                    }
                    this.var_byte_q = 0;
                    return bl2;
                }
                if (this.var_byte_v <= 2) break;
                switch (this.var_byte_t) {
                    case 1: {
                        u.var_ah_a.void_c(0, 5);
                        break;
                    }
                    case 2: {
                        u.var_ah_a.void_c(0, -5);
                        break;
                    }
                    case 3: {
                        u.var_ah_a.void_c(5, 0);
                        break;
                    }
                    case 4: {
                        u.var_ah_a.void_c(-5, 0);
                    }
                }
                break;
            }
            case 6: {
                if (this.var_byte_v == 3) {
                    this.var_boolean_b = true;
                    break;
                }
                if (this.var_byte_v <= 3) break;
                u.var_ah_a.void_a(4, (int)this.var_byte_v);
                u.var_ah_a.void_b(4, (int)this.var_byte_v);
                if (this.var_byte_v == 4) {
                    if (this.boolean_a(by2, 0)) {
                        ak.a((byte)0);
                        break;
                    }
                    return false;
                }
                if (this.var_byte_v != 5) break;
                this.boolean_a(by2, 1);
                break;
            }
            case 7: {
                if (this.var_byte_v != 0) break;
                this.var_boolean_j = true;
                this.n();
                this.void_a((byte)30, 140);
                ak.a((byte)5);
                break;
            }
            case 8: {
                if (this.var_byte_v != 10) break;
                this.var_boolean_k = true;
                this.var_int_p = this.var_byte_arr_p[8] * 14 + 20;
                this.void_a((byte)31, 120);
                ak.a((byte)5);
                break;
            }
            case 10: {
                if (this.var_byte_v == 1) {
                    ak.a((byte)5);
                } else if (this.var_byte_v == 9) {
                    this.void_b(by2);
                }
                if (this.var_byte_v > 2 && this.var_byte_v < 10) {
                    this.var_boolean_l = true;
                    ah.a(0);
                    if (this.var_byte_v != 9) break;
                    ah.a(1);
                    this.var_boolean_l = false;
                    break;
                }
                ah.g();
            }
        }
        return true;
    }

    private boolean boolean_h(byte by2) {
        boolean bl2 = false;
        int n2 = this.int_a();
        if (this.boolean_e(by2)) {
            bl2 = true;
        }
        if (this.c(by2, this.var_byte_t, n2)) {
            bl2 = true;
        }
        return bl2;
    }

    private boolean boolean_a(byte by2, int n2) {
        int n3;
        byte by3 = 0;
        ag ag2 = null;
        switch (n2) {
            case 0: {
                by3 = this.var_byte_t;
                ag2 = this.ag_a();
                break;
            }
            case 1: {
                by3 = (byte)(this.var_byte_t + 8);
                ag2 = this.ag_a(by3);
            }
        }
        if (ag2 != null && this.a(ag2, by2, n3 = this.int_a(), this.var_byte_l, this.var_byte_m)) {
            ag2.var_boolean_s = true;
            ag2.void_a((byte)32, 200);
            return true;
        }
        return false;
    }

    public boolean boolean_f() {
        ah ah2 = u.var_ah_a;
        byte by2 = ax.var_byte_arr_a[this.var_byte_t];
        byte by3 = ax.var_byte_arr_b[this.var_byte_t];
        if (ah2.boolean_a(((bl)this).h + by2 + by2, ((bl)this).i + by3 + by3) && ah2.var_byte_arr_arr_c[((bl)this).i + by3][((bl)this).h + by2] >= 0) {
            this.var_byte_q = (byte)2;
            return true;
        }
        if (ah2.boolean_a(((bl)this).h + by2, ((bl)this).i + by3)) {
            this.var_byte_q = 1;
            return true;
        }
        return false;
    }

    public void void_b() {
        int n2 = this.var_short_e + this.var_short_arr_b[0];
        this.var_int_h = n2 + n2 * this.var_byte_arr_p[14] / 10;
        this.var_int_i += this.var_short_e + this.var_short_arr_b[0] >> 2;
        if (this.var_byte_arr_p[11] > 0) {
            this.var_int_k -= this.var_byte_arr_p[11] * 3;
        }
        this.var_int_l = 8 + (this.var_short_g + this.var_short_arr_b[2] >> 3);
        this.var_int_j -= this.var_byte_arr_p[12] > 0 ? this.var_byte_arr_p[12] * 7 : 0;
        this.var_int_d = (this.var_short_f + this.var_short_arr_b[1] + this.var_byte_a) * 12;
    }

    public int int_a(int n2) {
        switch (n2) {
            case 4: 
            case 5: {
                return this.var_short_arr_c[b.var_byte_n];
            }
            case 6: {
                return this.var_short_arr_c[b.var_byte_n] - this.var_byte_arr_p[6] * 5;
            }
            case 7: {
                return this.var_int_e / 6 - this.var_byte_arr_p[n2] * 5;
            }
            case 8: {
                return this.var_int_e / 6;
            }
            case 9: {
                return this.var_short_arr_c[b.var_byte_n] * 3 >> 1;
            }
            case 10: {
                return (this.var_int_e << 2) / 5;
            }
        }
        return 0;
    }

    public short short_a(int n2) {
        return a[n2];
    }

    public int a(byte by2, int n2, ag ag2) {
        int n3 = n2;
        switch (by2) {
            case 4: 
            case 6: {
                n3 += n2 / (8 - this.var_byte_arr_p[by2]);
                break;
            }
            case 5: {
                int n4 = this.var_byte_a / 3 + 3;
                this.b(-n4);
            }
            case 9: {
                n3 += n2 / (6 - this.var_byte_arr_p[by2]);
                break;
            }
            case 8: {
                n3 = this.var_byte_arr_p[by2] * 14 + 20;
                break;
            }
            case 10: {
                if (f.a(0, 100) >= 50 + this.var_byte_a - ag2.m + this.var_short_i + this.var_short_arr_b[4]) break;
                n3 = ag2 instanceof w ? n2 * (this.var_byte_arr_p[10] + 3) / 3 : (int)ag2.var_short_a;
            }
        }
        return n3;
    }

    public boolean boolean_a(byte by2) {
        cf cf2 = this.cf_a();
        if (cf2 == null) {
            return false;
        }
        switch (by2) {
            case 4: {
                if (cf2 != null && cf2.g == 1) break;
                return false;
            }
            case 6: {
                if (cf2 != null && cf2.g == 0) break;
                return false;
            }
        }
        return true;
    }

    public boolean boolean_b() {
        this.var_boolean_a = this.cf_a() == null;
        return this.var_boolean_a;
    }
}

