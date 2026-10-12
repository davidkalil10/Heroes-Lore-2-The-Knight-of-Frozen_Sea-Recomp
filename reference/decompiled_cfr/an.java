/*
 * Decompiled with CFR 0.152.
 */
public class an
extends b {
    public static final short[] a = new short[]{60, 50, 70, 90, 180, 180};

    public an(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, by2, by3);
        this.void_a();
    }

    public void void_a() {
        super.void_a();
        this.var_short_e = (short)10;
        this.var_short_f = (short)11;
        this.var_short_g = (short)8;
        this.var_short_h = (short)12;
        this.var_short_i = (short)12;
        this.var_boolean_n = false;
        this.var_byte_arr_p[10] = 1;
    }

    public byte byte_a(int n2) {
        if (n2 <= 2) {
            return (byte)(n2 + 1);
        }
        if (n2 == 10) {
            return 1;
        }
        if (n2 == 12) {
            return 3;
        }
        return 5;
    }

    public boolean boolean_a() {
        byte by2 = this.var_byte_arr_o[this.var_byte_d];
        switch (by2) {
            case 0: 
            case 1: 
            case 2: {
                if (this.var_byte_v != 2) break;
                return this.boolean_e(by2);
            }
            case 4: {
                if (this.var_byte_v != 5) break;
                int n2 = this.int_a();
                n2 += n2 / (8 - this.var_byte_arr_p[4]);
                u.var_ah_a.d(new bn(this, n2));
                ak.a((byte)7);
                return true;
            }
            case 5: {
                if (this.var_byte_v == 3) {
                    this.var_boolean_b = true;
                    break;
                }
                if (this.var_byte_v <= 3) break;
                u.var_ah_a.void_a(4, (int)this.var_byte_v);
                u.var_ah_a.void_b(4, (int)this.var_byte_v);
                if (this.var_byte_v != 4) break;
                return this.boolean_e(by2);
            }
            case 6: {
                if (this.var_byte_v <= 2) break;
                u.var_ah_a.void_a(4, (int)this.var_byte_v);
                u.var_ah_a.void_b(4, (int)this.var_byte_v);
                if (this.var_byte_v != 3) break;
                if (this.boolean_h(by2)) {
                    ak.a((byte)8);
                    return true;
                }
                return false;
            }
            case 7: {
                if (this.var_byte_v != 0) break;
                this.var_boolean_m = true;
                this.n();
                this.void_a((byte)34, 70 + this.var_byte_arr_p[7] * 10);
                ak.a((byte)6);
                break;
            }
            case 8: {
                if (this.var_byte_v != 0) break;
                this.var_boolean_n = true;
                if (!this.var_boolean_n) break;
                this.void_a((byte)35, 30 + (this.var_byte_arr_p[8] << 3));
                ak.a((byte)6);
                break;
            }
            case 3: {
                if (this.var_byte_v != 1) break;
                int n3 = this.var_int_d * this.var_byte_arr_p[3] / 15;
                this.b(n3 += this.var_byte_arr_p[14] > 0 ? this.var_byte_arr_p[14] * 10 : 0);
                ak.a((byte)6);
            }
        }
        return true;
    }

    public boolean boolean_h(byte by2) {
        int n2;
        ag ag2 = this.ag_a();
        if (ag2 != null && ag2.a(this, by2, n2 = this.int_a(), false, this.var_byte_t, this.var_byte_l, this.var_byte_m, (byte)33)) {
            ag2.a(20 + this.var_byte_arr_p[6] * 5);
            return true;
        }
        return false;
    }

    public byte byte_a(byte by2) {
        return by2;
    }

    public void a(int n2, int n3, byte by2) {
        if (this.var_boolean_n) {
            this.a((byte)12, this.var_byte_t, n2, n3);
        } else {
            super.a(n2, n3, this.var_byte_t);
        }
    }

    public void c(int n2, int n3) {
        if (this.var_boolean_n) {
            this.a((byte)13, this.var_byte_t, n2, n3);
        } else {
            super.c(n2, n3);
        }
    }

    public void void_b() {
        this.var_int_d = (this.var_short_f + this.var_short_arr_b[1] + this.var_byte_a) * 13 * (13 + this.var_byte_arr_p[13]) / 13;
        this.var_int_h = (this.var_short_e + this.var_short_arr_b[0]) * 7 / 10;
        this.var_int_l = 8 + (this.var_short_g + this.var_short_arr_b[2] >> 3);
        this.var_int_i += this.am_a() != null ? this.am_a().int_a() : 0;
        this.var_int_i += (this.var_short_e + this.var_short_arr_b[0]) / 3;
        this.var_int_q = this.var_short_i + this.var_short_arr_b[4] >> 2 - this.var_byte_a / 5 + 8 + this.var_byte_arr_p[11];
        if (this.var_int_q < 8) {
            this.var_int_q = 8;
        } else if (this.var_int_q > 90) {
            this.var_int_q = 90;
        }
        if (this.var_byte_arr_p[12] > 0) {
            this.var_int_n += this.var_byte_arr_p[12];
        }
        if (this.var_boolean_m) {
            this.var_int_d = this.var_int_d * (11 + (this.var_byte_arr_p[7] >> 1)) / 10;
            this.var_int_e = this.var_int_e * (11 + (this.var_byte_arr_p[7] >> 1)) / 10;
        }
    }

    public short short_a(int n2) {
        return a[n2];
    }

    public int int_a(int n2) {
        switch (n2) {
            case 3: {
                return this.var_int_e / 5;
            }
            case 4: 
            case 5: {
                return this.var_short_arr_c[b.var_byte_n];
            }
            case 6: {
                return this.var_int_e >> 3;
            }
            case 7: {
                return this.var_int_e / 6;
            }
            case 8: {
                return this.var_int_e / 10;
            }
        }
        return 0;
    }

    public int a(byte by2, int n2, ag ag2) {
        int n3 = n2;
        switch (by2) {
            case 4: {
                n3 = n2 * (this.var_byte_arr_p[by2] + 4) / 3;
                break;
            }
            case 5: {
                n3 = n2 * (this.var_byte_arr_p[by2] + 7) / 3;
            }
        }
        return n3;
    }

    public boolean boolean_a(byte by2) {
        cf cf2 = this.cf_a();
        switch (by2) {
            case 0: 
            case 1: 
            case 2: {
                if (cf2 != null) break;
                return false;
            }
            case 4: {
                if (cf2 != null && cf2.g == 2) break;
                return false;
            }
            case 5: {
                if (cf2 != null && cf2.g == 4) break;
                return false;
            }
            case 6: 
            case 8: {
                if (this.am_a() != null) break;
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

