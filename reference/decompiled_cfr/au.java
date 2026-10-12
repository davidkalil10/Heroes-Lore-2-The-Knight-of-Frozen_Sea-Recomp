/*
 * Decompiled with CFR 0.152.
 */
public class au
extends w {
    public au(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, by2, by3, (byte)1);
        this.var_int_c = this.var_short_a >> 1;
        switch (by2) {
            case 93: {
                this.i = new byte[2];
                this.i[0] = 2;
                this.i[1] = 4;
                this.d = 1;
                break;
            }
            case 94: {
                this.i = new byte[4];
                this.i[0] = 2;
                this.i[1] = 4;
                this.i[2] = 5;
                this.i[3] = 6;
                this.d = (byte)2;
                break;
            }
            case 95: {
                this.i = new byte[6];
                this.i[0] = 5;
                this.i[1] = 6;
                this.i[2] = 2;
                this.i[3] = 5;
                this.i[4] = 6;
                this.i[5] = 4;
                this.d = (byte)6;
                this.var_int_c = 0;
            }
        }
        this.void_a(this.i[this.var_byte_c]);
    }

    public final void void_a() {
        if (this.var_short_b > this.var_int_c && !this.h) {
            if (this.var_byte_c >= this.d) {
                this.var_byte_c = 0;
            }
        } else if (this.var_byte_c >= this.i.length) {
            this.var_byte_c = 0;
        }
    }

    public boolean boolean_a() {
        switch (this.var_byte_a) {
            case 2: {
                if (this.var_int_a * this.var_int_b == 0 && this.var_int_a < 5 && this.var_int_b < 5) {
                    return true;
                }
                if (this.var_ay_a.var_byte_b != 95) break;
                this.var_byte_c = (byte)5;
                this.void_a(this.i[this.var_byte_c]);
                return true;
            }
            case 4: 
            case 5: {
                if (this.var_int_a > 1 || this.var_int_b > 1) {
                    return true;
                }
                if (f.a(1, 10) >= 6) break;
                return true;
            }
            case 6: {
                return true;
            }
        }
        return false;
    }

    public void void_b() {
        switch (this.var_byte_a) {
            case 2: {
                if (this.var_byte_v == 1) {
                    for (byte by2 = 1; by2 <= 4; by2 = (byte)(by2 + 1)) {
                        this.a((byte)3, (byte)0, by2, 5);
                    }
                }
                return;
            }
            case 4: {
                if (this.var_byte_v % 2 == 0) {
                    b b2 = u.var_b_a;
                    this.a(((bl)b2).h, ((bl)b2).i, (byte)0, (byte)0);
                }
                return;
            }
            case 5: {
                if (this.var_byte_v >= 8) {
                    this.h = true;
                    this.var_boolean_a = true;
                    this.void_e();
                }
                return;
            }
            case 6: {
                this.h = false;
                this.var_boolean_a = false;
                return;
            }
        }
    }

    public void void_d() {
        if (this.var_byte_a == 6) {
            this.r();
            return;
        }
        if (this.o < 1 && this.boolean_a()) {
            return;
        }
        if (this.var_int_a <= 3 && this.var_int_b <= 3) {
            this.k();
        } else {
            this.a((bl)u.var_b_a, (byte)10);
        }
        this.void_f((byte)2);
        this.var_byte_v = 0;
    }

    public void void_e() {
        byte by2 = 0;
        byte by3 = 0;
        while (!u.var_ah_a.boolean_a((int)(by2 = (byte)(f.a(-3, 3) + ((bl)this).h)), (int)(by3 = (byte)(f.a(-3, 3) + ((bl)this).i)))) {
        }
        this.a((short)(by2 << 4), (short)(by3 << 4));
    }

    public void a(byte by2, byte by3, byte by4, byte by5) {
        if (by2 < 1 || by3 < 1 || by2 >= ah.var_byte_d - 1 || by3 >= ah.var_byte_e - 1) {
            return;
        }
        u.var_ah_a.d(new ab(this, by5, (byte)(by2 + ax.var_byte_arr_a[by4]), (byte)(by3 + ax.var_byte_arr_b[by4]), 4, 0, false));
        u.var_ah_a.d(new ab(this, by5, (byte)(by2 + ax.var_byte_arr_a[by4]), (byte)(by3 + ax.var_byte_arr_b[by4]), 5, 0, true));
    }
}

