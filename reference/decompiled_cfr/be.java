/*
 * Decompiled with CFR 0.152.
 */
public class be
extends w {
    public byte w;

    public be(short s2, short s3, byte by2, byte by3, byte by4) {
        super(s2, s3, by2, by3, (byte)1);
        this.w = by4;
        this.j = (byte)2;
        switch (by2) {
            case 98: 
            case 99: {
                this.var_int_c = 0;
                this.i = new byte[1];
                this.i[0] = 2;
                if (by2 == 98) {
                    bo.var_be_a = this;
                    break;
                }
                bo.b = this;
                break;
            }
            case 100: 
            case 101: {
                if (bo.var_bo_a != null) {
                    this.var_int_c = bo.var_bo_a.var_short_a >> 1;
                    if (bo.var_bo_a.var_short_b < this.var_int_c) {
                        this.var_byte_c = (byte)2;
                    }
                }
                this.w = (byte)3;
                this.d = (byte)2;
                this.i = new byte[6];
                this.i[0] = 2;
                this.i[1] = 12;
                this.i[2] = by2 == 101 ? 13 : 2;
                this.i[3] = 13;
                this.i[4] = 13;
                int n2 = this.i[5] = by2 == 101 ? 12 : 13;
                if (by2 == 100) {
                    bo.var_be_a = this;
                    break;
                }
                bo.b = this;
            }
        }
        this.void_a(this.i[this.var_byte_c]);
        this.var_byte_s = (byte)8;
        this.var_byte_v = 0;
        this.h = false;
    }

    public void void_a() {
        int n2 = 1000;
        if (bo.var_bo_a != null) {
            n2 = bo.var_bo_a.var_short_b;
        }
        if (n2 > this.var_int_c) {
            if (this.var_byte_c >= this.d) {
                this.var_byte_c = 0;
            }
        } else {
            if (this.var_byte_c >= this.i.length) {
                this.var_byte_c = 0;
            }
            if (this.g && this.i[this.var_byte_c] == 13) {
                this.var_byte_c = 0;
                this.g = false;
            }
        }
    }

    public void b(int n2, int n3) {
        int n4 = n2 + this.var_short_c + this.var_byte_f + (this.j - 1) * 8;
        int n5 = n3 + this.var_short_d + ((bl)this).g;
        this.var_boolean_b = true;
        int n6 = n4;
        int n7 = n5;
        if (this.q == 3 || this.q == 1) {
            n6 += ax.var_byte_arr_a[this.r] * 3;
            n7 += ax.var_byte_arr_b[this.r] * 3;
        }
        switch (this.var_byte_s) {
            case 8: {
                this.a((byte)7, this.w, n6, n7);
                if (this.var_byte_v < 8) break;
                this.void_f((byte)1);
                break;
            }
            case 3: {
                this.a(this.var_byte_a, this.w, n6, n7);
                break;
            }
            case 4: {
                this.a((byte)3, this.w, n6, n7);
                break;
            }
            case 6: {
                this.a((byte)6, this.w, n6, n7);
                this.var_byte_v = (byte)(this.var_byte_v + 1);
                break;
            }
            default: {
                this.a((byte)0, this.w, n6, n7);
            }
        }
        this.f(n4, n5);
        this.e(n4, n5);
    }

    public void m() {
        if (this.p < 1) {
            this.h = true;
            this.w();
        }
        this.p = (byte)(this.p - 1);
    }

    public void a(byte by2, byte by3, int n2, int n3) {
        bd.void_a((byte)0, by2, this.var_byte_v, by3, n2, n3);
    }

    public boolean boolean_a() {
        switch (this.var_byte_a) {
            case 2: {
                if (this.var_int_a > 3 || this.var_int_b > 1) break;
                return true;
            }
            case 12: 
            case 13: {
                return true;
            }
        }
        return false;
    }

    public void void_b() {
        byte by2 = this.var_byte_a;
        switch (by2) {
            case 2: {
                if (this.var_byte_v == 2) {
                    this.a((byte)8, (byte)6, (byte)0, 1);
                    this.a((byte)8, (byte)11, (byte)1, 1);
                    this.a((byte)8, (byte)8, (byte)8, 1);
                    u.var_ah_a.void_b(4, (int)this.var_byte_v);
                    if (!this.boolean_a()) break;
                    b b2 = u.var_b_a;
                    b2.a((ag)this, this.var_short_e, this.var_byte_t);
                    break;
                }
                if (this.var_byte_v != 3) break;
                this.a((byte)8, (byte)12, (byte)0, 1);
                this.a((byte)8, (byte)11, (byte)2, 1);
                this.a((byte)8, (byte)10, (byte)3, 1);
                u.var_ah_a.void_b(4, (int)this.var_byte_v);
                break;
            }
            case 12: {
                if (this.var_byte_v == 6) {
                    b b3 = u.var_b_a;
                    u.var_ah_a.d(new ab(this, 0, ((bl)b3).h, ((bl)b3).i, 9, 1, true));
                }
                u.var_ah_a.void_a(4, (int)this.var_byte_v);
                break;
            }
            case 13: {
                if (this.var_byte_v != 0) break;
                b b4 = u.var_b_a;
                b4.b(new bu(40, 0));
                if (bo.var_bo_a == null) break;
                int n2 = b4.var_int_a / 20;
                if (n2 < 1) {
                    n2 = 3;
                }
                b4.b(-n2);
                b4.b(new bh(-4, -1, n2));
                bo.var_bo_a.var_short_b = (short)(bo.var_bo_a.var_short_b + n2);
            }
        }
    }

    public boolean boolean_a(bl bl2) {
        if (this.boolean_a()) {
            this.r();
            return true;
        }
        return false;
    }

    public void void_d() {
        if (this.o > 0) {
            this.var_byte_t = 1;
        } else {
            b b2 = u.var_b_a;
            int n2 = ((bl)b2).i - ((bl)this).i;
            this.var_byte_t = (byte)(n2 > 0 ? 2 : 1);
        }
        this.void_f((byte)2);
        this.var_byte_v = 0;
    }
}

