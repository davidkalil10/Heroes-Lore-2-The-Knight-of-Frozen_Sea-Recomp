/*
 * Decompiled with CFR 0.152.
 */
public class ac
extends b {
    public static final short[] a = new short[]{35, 200, 70, 180, 80, 80};

    public ac(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, by2, by3);
        this.void_a();
    }

    public void void_a() {
        super.void_a();
        this.var_short_e = (short)11;
        this.var_short_f = (short)9;
        this.var_short_g = (short)13;
        this.var_short_h = (short)10;
        this.var_short_i = (short)10;
    }

    public byte byte_a(int n2) {
        if (n2 <= 4) {
            return (byte)(n2 + 1);
        }
        if (n2 >= 11) {
            return 3;
        }
        return 5;
    }

    public boolean boolean_a(byte by2, byte by3) {
        cf cf2 = by3 == 3 ? (cf)this.am_a() : this.cf_a();
        if (cf2 == null) {
            return false;
        }
        int n2 = this.int_a(cf2);
        byte by4 = cf2.n;
        byte by5 = by3 == 3 ? (byte)0 : cf2.i;
        return this.a(by2, this.var_byte_t, n2, by4, by5);
    }

    public boolean boolean_a(byte by2, byte by3, int n2) {
        int n3;
        ag ag2 = this.ag_a();
        if (ag2 != null && this.a(ag2, by2, n3 = this.int_a() + this.int_a((cf)this.am_a()), this.var_byte_l, (byte)0)) {
            this.a(ag2, by3, n2);
            return true;
        }
        return false;
    }

    public boolean boolean_a() {
        byte by2 = this.var_byte_arr_o[this.var_byte_d];
        byte by3 = u.var_b_a.var_byte_t;
        switch (by2) {
            case 0: {
                if (this.var_byte_v == 1) {
                    return this.boolean_a(by2, (byte)4);
                }
                if (this.var_byte_v != 3) break;
                return this.boolean_a(by2, (byte)3);
            }
            case 1: {
                if (this.var_byte_v == 1 || this.var_byte_v == 3) {
                    return this.boolean_a(by2, (byte)4);
                }
                if (this.var_byte_v != 2 && this.var_byte_v != 4) break;
                return this.boolean_a(by2, (byte)3);
            }
            case 2: 
            case 3: {
                if (this.var_byte_v != 2) break;
                return this.boolean_a(by2, (byte)4);
            }
            case 4: {
                if (this.var_byte_v > 4) {
                    u.var_ah_a.void_a(4, (int)this.var_byte_v);
                    u.var_ah_a.void_b(4, (int)this.var_byte_v);
                }
                if (this.var_byte_v == 2 || this.var_byte_v == 5) {
                    return this.boolean_a(by2, (byte)4);
                }
                if (this.var_byte_v != 4) break;
                this.var_boolean_b = true;
                break;
            }
            case 5: {
                if (this.var_byte_v == 0) {
                    this.var_int_o = 1;
                    break;
                }
                if (this.var_byte_v <= 1) break;
                if (by3 < 3) {
                    u.var_ah_a.void_a(5, (int)this.var_byte_v);
                } else {
                    u.var_ah_a.void_b(5, (int)this.var_byte_v);
                }
                if (this.var_byte_v != 2) break;
                int n2 = 18 + this.var_byte_arr_p[14] * 3;
                if (this.boolean_a(by2, (byte)25, n2)) {
                    ak.a((byte)0);
                    break;
                }
                return false;
            }
            case 6: {
                if (this.var_byte_v == 1) {
                    ak.a((byte)2);
                    break;
                }
                if (this.var_byte_v != 7) break;
                this.var_boolean_o = true;
                this.n();
                this.void_a((byte)36, 110);
                break;
            }
            case 7: {
                if (this.var_byte_v <= 3) break;
                u.var_ah_a.void_a(5, (int)this.var_byte_v);
                if (this.var_byte_v != 4) break;
                int n3 = 20 + this.var_byte_arr_p[7] * 3;
                if (this.boolean_a(by2, (byte)25, n3 += this.var_byte_arr_p[14] > 0 ? this.var_byte_arr_p[14] * 3 : 0)) {
                    ak.a((byte)0);
                    break;
                }
                return false;
            }
            case 8: {
                if (this.var_byte_v != 4) break;
                if (this.boolean_a(by2, (byte)26, 80 + this.var_byte_arr_p[8] * 10)) {
                    ak.a((byte)0);
                    break;
                }
                return false;
            }
            case 9: {
                if (this.var_byte_v > 0) {
                    if (by3 < 3) {
                        u.var_ah_a.void_b(5, (int)this.var_byte_v);
                    } else {
                        u.var_ah_a.void_a(5, (int)this.var_byte_v);
                    }
                }
                if (this.var_byte_v == 1) {
                    ak.a((byte)9);
                    break;
                }
                if (this.var_byte_v == 3 || this.var_byte_v == 5) {
                    this.boolean_e(by2);
                    break;
                }
                if (this.var_byte_v != 2 && this.var_byte_v != 4 && this.var_byte_v != 6) break;
                this.boolean_a(by2, (byte)3);
                break;
            }
            case 10: {
                if (this.var_byte_v == 1 || this.var_byte_v == 3 || this.var_byte_v == 6) {
                    if (by3 < 3) {
                        u.var_ah_a.void_a(5, (int)this.var_byte_v);
                    } else {
                        u.var_ah_a.void_b(5, (int)this.var_byte_v);
                    }
                }
                if (this.var_byte_v == 1) {
                    ak.a((byte)9);
                    break;
                }
                if (this.var_byte_v == 3) {
                    return this.boolean_e(by2);
                }
                if (this.var_byte_v != 6) break;
                return this.boolean_a(by2, (byte)3);
            }
        }
        return true;
    }

    public byte byte_a(byte by2) {
        return by2;
    }

    public void void_b() {
        this.var_int_d = (this.var_short_f + this.var_short_arr_b[1] + this.var_byte_a) * 12;
        if (this.var_boolean_o) {
            this.var_short_arr_b[2] = (short)(this.var_short_arr_b[2] + (this.var_short_g + this.var_short_arr_b[2]) / (7 - this.var_byte_arr_p[6]));
        }
        cf cf2 = this.cf_a();
        cf cf3 = (cf)this.am_a();
        int n2 = 2;
        if (cf2 == null || cf3 == null) {
            n2 = 1;
        }
        this.var_short_arr_d[b.var_byte_n] = cf3 != null ? cf3.d() : (short)0;
        short s2 = this.var_short_arr_d[b.var_byte_o] = cf3 != null ? cf3.c() : (short)0;
        if (cf3 != null) {
            this.var_int_g += this.var_short_arr_d[b.var_byte_n] + this.var_short_arr_d[b.var_byte_o] >> 1;
        }
        this.var_int_g /= n2;
        this.var_int_h = this.var_short_e + this.var_short_arr_b[0] >> 1;
        this.var_int_h += this.var_short_g + this.var_short_arr_b[2] >> 1;
        this.var_int_i += this.var_short_e + this.var_short_arr_b[0] >> 2;
        this.var_int_i += this.var_short_g + this.var_short_arr_b[2] >> 2;
        this.var_int_l = 10 + (this.var_short_g + this.var_short_arr_b[2] >> 2);
        this.var_int_l += this.var_byte_arr_p[13] > 0 ? this.var_byte_arr_p[13] * 3 / 2 : 0;
        if (cf3 != null) {
            this.var_byte_k = (byte)(this.var_byte_k + cf3.j);
            this.var_byte_k = (byte)(this.var_byte_k / n2);
        }
        this.var_short_arr_d[b.var_byte_n] = cf3 != null ? cf3.d() : (short)0;
        this.var_short_arr_d[b.var_byte_o] = cf3 != null ? cf3.c() : (short)0;
        this.var_int_j += cf3 != null ? this.var_short_arr_d[b.var_byte_n] >> 2 : 0;
        this.var_byte_p = (byte)(this.var_byte_arr_p[8] * 3);
        this.var_int_m += this.var_byte_arr_p[11] > 0 ? this.var_byte_arr_p[11] << 1 : 0;
    }

    public int int_a(int n2) {
        switch (n2) {
            case 5: {
                return this.var_short_arr_c[b.var_byte_n] + this.var_short_arr_d[b.var_byte_n];
            }
            case 6: 
            case 8: {
                return this.var_int_e >> 3;
            }
            case 7: {
                return this.var_int_e / 10;
            }
            case 9: 
            case 10: {
                return (this.var_short_arr_c[b.var_byte_n] + this.var_short_arr_d[b.var_byte_n]) * 3 / 2;
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
            case 5: {
                n3 += n2 / (8 - this.var_byte_arr_p[by2]);
                break;
            }
            case 9: {
                n3 = n2 * (this.var_byte_arr_p[by2] + 6) / 3;
                break;
            }
            case 10: {
                n3 = n2 * (this.var_byte_arr_p[by2] + 6) / 3;
            }
        }
        return n3;
    }

    public boolean boolean_a(byte by2) {
        cf cf2 = this.cf_a();
        am am2 = this.am_a();
        switch (by2) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 7: 
            case 8: {
                if (cf2 != null || am2 != null) break;
                return false;
            }
            case 9: {
                if (cf2 == null || am2 == null) {
                    return false;
                }
                return cf2.g == 3 && am2.g == 3;
            }
            case 10: {
                if (cf2 != null && am2 != null) break;
                return false;
            }
        }
        return true;
    }

    public boolean boolean_b() {
        this.var_boolean_a = this.cf_a() == null && this.am_a() == null;
        return this.var_boolean_a;
    }
}

