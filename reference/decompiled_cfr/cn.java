/*
 * Decompiled with CFR 0.152.
 */
public class cn
extends w {
    public cn(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, by2, by3, (byte)1);
        this.var_int_c = this.var_short_a * 3 / 5;
        switch (by2) {
            case 90: {
                this.i = new byte[2];
                this.i[0] = 2;
                this.i[1] = 5;
                this.var_int_c = 0;
                this.d = (byte)2;
                break;
            }
            case 89: {
                this.i = new byte[7];
                this.i[0] = 2;
                this.i[1] = 4;
                this.i[2] = 6;
                this.i[3] = 5;
                this.i[4] = 8;
                this.i[5] = 8;
                this.i[6] = 8;
                this.d = (byte)3;
                break;
            }
            case 91: 
            case 92: {
                this.i = new byte[8];
                this.i[0] = 2;
                this.i[1] = 4;
                this.i[2] = 6;
                this.i[3] = 7;
                this.i[4] = 5;
                this.i[5] = 8;
                this.i[6] = 8;
                this.i[7] = 8;
                this.d = (byte)4;
            }
        }
        this.void_a(this.i[this.var_byte_c]);
    }

    public boolean boolean_a() {
        switch (this.var_byte_a) {
            case 2: 
            case 4: {
                if (this.var_int_a * this.var_int_b != 0 || this.var_int_a > 1 || this.var_int_b > 1) break;
                return true;
            }
            case 5: {
                if (this.var_int_a + this.var_int_b >= 3) break;
                return true;
            }
            case 6: 
            case 7: {
                if (this.var_int_a <= 1 && (this.var_byte_t == 1 || this.var_byte_t == 2)) {
                    return true;
                }
                if (this.var_int_b > 1 || this.var_byte_t != 3 && this.var_byte_t != 4) break;
                return true;
            }
            case 8: {
                if (this.g) {
                    this.var_byte_c = (byte)(this.var_int_a <= 1 ? 1 : 2);
                    this.void_a(this.i[this.var_byte_c]);
                    return false;
                }
                return true;
            }
        }
        this.g = false;
        return false;
    }

    public void void_d() {
        if (this.o < 1 && this.boolean_a()) {
            return;
        }
        this.a((bl)u.var_b_a, (byte)7);
        this.void_f((byte)2);
        this.var_byte_v = 0;
    }

    public void void_b() {
        short s2 = this.var_ay_a.var_short_b;
        switch (this.var_byte_a) {
            case 2: {
                if ((this.var_byte_v == 1 || this.var_byte_v == 3 || this.var_byte_v == 5) && this.var_int_a * this.var_int_b == 0 && this.var_int_a <= 1 && this.var_int_b <= 1) break;
                return;
            }
            case 4: {
                if ((this.var_byte_v == 1 || this.var_byte_v == 3 || this.var_byte_v == 5 || this.var_byte_v == 7) && this.var_int_a * this.var_int_b == 0 && this.var_int_a <= 1 && this.var_int_b <= 1) break;
                return;
            }
            case 5: {
                if (this.var_byte_v == 4 && this.var_int_a + this.var_int_b < 3) {
                    u.var_b_a.void_a(this.var_byte_t, (byte)16);
                    break;
                }
                return;
            }
            case 6: {
                if (this.var_byte_v == 1) {
                    this.a((byte)2, ax.c[this.var_byte_t], this.var_byte_t, 5);
                } else if (this.var_byte_v == 3) {
                    this.a((byte)2, (byte)0, this.var_byte_t, 5);
                } else if (this.var_byte_v == 5) {
                    this.a((byte)2, ax.d[this.var_byte_t], this.var_byte_t, 5);
                }
                return;
            }
            case 7: {
                if (this.var_byte_v == 3) {
                    this.void_a((byte)2, (byte)5);
                    this.a((byte)2, this.var_byte_t, ax.c[this.var_byte_t], 5);
                    this.a((byte)2, this.var_byte_t, ax.d[this.var_byte_t], 5);
                }
                return;
            }
            case 8: {
                if (this.var_byte_v > 0) {
                    int n2 = this.var_short_a / 100;
                    if (n2 <= 0) {
                        n2 = 2;
                    }
                    this.var_short_b = (short)(this.var_short_b + n2);
                    if (this.var_short_b > this.var_short_a) {
                        this.var_short_b = this.var_short_a;
                    }
                }
                return;
            }
            default: {
                return;
            }
        }
        u.var_b_a.a((ag)this, s2, this.var_byte_t);
    }
}

