/*
 * Decompiled with CFR 0.152.
 */
public class bo
extends w {
    public byte w = 1;
    public static bo var_bo_a;
    public static be var_be_a;
    public static be b;
    public int d = 0;
    public int e = 0;

    public bo(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, by2, by3, (byte)1);
        if (by2 == 96) {
            this.i = new byte[3];
            this.i[0] = 5;
            this.i[1] = 2;
            this.i[2] = 4;
            this.var_int_c = 0;
        } else {
            this.i = new byte[6];
            this.i[0] = 5;
            this.i[1] = 2;
            this.i[2] = 4;
            this.i[3] = 9;
            this.i[4] = 10;
            this.i[5] = 11;
            this.var_int_c = this.var_short_b >> 1;
        }
        ((w)this).d = (byte)this.i.length;
        this.var_byte_c = 1;
        this.void_a(this.i[this.var_byte_c]);
        this.var_boolean_a = true;
        this.y();
    }

    public void void_a() {
        if (this.var_ay_a.var_byte_b == 97) {
            if (this.w == 1) {
                this.var_byte_c = (byte)f.a(1, 3);
            } else if (this.var_short_b >= this.var_int_c) {
                if (this.var_byte_c >= 4) {
                    this.var_byte_c = (byte)2;
                }
            } else if (this.var_byte_c >= 5) {
                this.var_byte_c = (byte)2;
            } else if (this.var_byte_c == 3) {
                this.var_byte_c = (byte)(this.var_byte_c + 1);
            }
        }
        if (this.var_byte_c >= this.i.length) {
            this.var_byte_c = 0;
        }
    }

    public boolean boolean_a() {
        switch (this.var_byte_a) {
            case 2: 
            case 4: {
                if (this.var_int_a >= 3 || this.var_int_b >= 5) break;
                return true;
            }
            case 9: {
                if (this.var_int_a >= 2 || this.var_int_b >= 15) break;
                return true;
            }
            case 10: 
            case 11: {
                if (this.var_int_a >= 3 || this.var_int_b >= 15) break;
                return true;
            }
            case 5: {
                return this.boolean_b();
            }
        }
        return false;
    }

    public void void_d() {
        if (this.boolean_b()) {
            this.r();
            return;
        }
        if (this.o < 1 && this.boolean_a()) {
            return;
        }
        int n2 = ah.var_byte_d >> 1;
        if (((bl)this).h > n2 - 5 && ((bl)this).h < n2 + 5) {
            this.i();
        } else {
            this.var_byte_t = ((bl)this).h < n2 ? (byte)4 : (byte)3;
        }
        this.void_f((byte)2);
        this.var_byte_v = 0;
    }

    public boolean boolean_a(bl bl2) {
        if (this.boolean_a()) {
            this.r();
            return true;
        }
        if (this.var_ay_a.var_byte_b == 97) {
            this.void_a();
        }
        return false;
    }

    public void void_b() {
        byte by2 = this.var_byte_a;
        this.i();
        switch (by2) {
            case 2: {
                if (this.var_byte_v != 2) break;
                this.a(3, 3);
                break;
            }
            case 4: {
                if (this.var_byte_v != 2 && this.var_byte_v != 4 && this.var_byte_v != 7) break;
                this.a(3, 3);
                break;
            }
            case 9: {
                if (this.var_byte_v == 0) {
                    for (int n2 = 0; n2 < 10; n2 = (int)((byte)(n2 + 1))) {
                        this.b((byte)6, n2);
                    }
                } else if ((this.var_byte_v == 6 || this.var_byte_v == 8) && this.var_int_a < 2) {
                    u.var_b_a.void_a((byte)2, (byte)16);
                    this.void_e();
                }
                if (this.var_byte_v <= 5) break;
                u.var_ah_a.void_b(4, (int)this.var_byte_v);
                break;
            }
            case 10: {
                if (this.var_byte_v == 0) {
                    for (int n3 = 0; n3 < 8; n3 = (int)((byte)(n3 + 1))) {
                        this.b((byte)7, n3);
                    }
                    break;
                }
                if (this.var_byte_v <= 9) break;
                if (this.var_byte_v % 2 == 1 && this.var_int_a < 3) {
                    u.var_b_a.void_a((byte)2, (byte)16);
                    this.void_e();
                }
                u.var_ah_a.void_b(4, (int)this.var_byte_v);
                break;
            }
            case 11: {
                if (this.var_byte_v <= 2) break;
                if (this.var_byte_v % 2 == 1 && this.var_int_a < 3) {
                    if (this.var_int_a < 3) {
                        b b2 = u.var_b_a;
                        int n4 = ((bl)b2).h - ((bl)this).h;
                        b2.void_a(n4 >= 0 ? (byte)4 : 3, (byte)16);
                    }
                    this.void_e();
                }
                u.var_ah_a.void_b(4, (int)this.var_byte_v);
                break;
            }
            case 5: {
                if (this.var_byte_v != 7) break;
                this.x();
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
            case 3: {
                this.a(this.var_byte_a, this.w, n6, n7);
                break;
            }
            default: {
                this.a((byte)0, this.w, n6, n7);
            }
        }
        this.f(n4, n5);
        this.e(n4, n5);
        this.z();
    }

    public void b(byte by2, int n2) {
        byte by3 = (byte)(((bl)this).i + n2);
        if (by3 < 0 || by3 >= ah.var_byte_e) {
            return;
        }
        u.var_ah_a.d(new ab(this, 2, ((bl)this).h, by3, by2, 1, true));
    }

    public void void_e() {
        b b2 = u.var_b_a;
        b2.a((ag)this, this.var_short_e, this.var_byte_t);
    }

    public void i() {
        b b2 = u.var_b_a;
        int n2 = ((bl)b2).h - ((bl)this).h;
        this.var_byte_t = (byte)(n2 > 0 ? 4 : 3);
    }

    public void q() {
        this.i();
    }

    public boolean boolean_e() {
        return false;
    }

    public final void t() {
        ah ah2 = u.var_ah_a;
        int n2 = 0;
        int n3 = 0;
        for (int i2 = -1; i2 <= 1; ++i2) {
            for (int i3 = -2; i3 <= 2; ++i3) {
                n2 = ((bl)this).h + i2;
                n3 = ((bl)this).i + i3;
                if (n2 < 0 || n3 < 0 || n2 >= ah.var_byte_d || n3 >= ah.var_byte_e) continue;
                ah2.var_bl_arr_arr_a[n3][n2] = this;
                if (this.var_boolean_d) {
                    ah2.var_bl_arr_arr_a[n3 + 1][n2] = this;
                    continue;
                }
                if (!this.var_boolean_c) continue;
                ah2.var_bl_arr_arr_a[n3][n2 + 1] = this;
            }
        }
    }

    public final void u() {
        ah ah2 = u.var_ah_a;
        int n2 = 0;
        int n3 = 0;
        for (int i2 = -1; i2 <= 1; ++i2) {
            for (int i3 = -2; i3 <= 2; ++i3) {
                n2 = ((bl)this).h + i2;
                n3 = ((bl)this).i + i3;
                if (n2 < 0 || n3 < 0 || n2 >= ah.var_byte_d || n3 >= ah.var_byte_e) continue;
                ah2.var_bl_arr_arr_a[n3][n2] = null;
                if (this.var_boolean_d) {
                    ah2.var_bl_arr_arr_a[n3 + 1][n2] = null;
                    continue;
                }
                if (!this.var_boolean_c) continue;
                ah2.var_bl_arr_arr_a[n3][n2 + 1] = null;
            }
        }
    }

    public void a(int n2, int n3) {
        b b2 = u.var_b_a;
        ah ah2 = u.var_ah_a;
        if (n3 < 0) {
            n3 *= -1;
        }
        int n4 = 0;
        int n5 = 0;
        block0: for (int i2 = -1 - n2; i2 <= 1 + n2; ++i2) {
            for (int i3 = -3; i3 < 2 + n3; ++i3) {
                n4 = ((bl)this).h + i2;
                n5 = ((bl)this).i + i3;
                if (n4 < 0 || n5 < 0 || n4 >= ah.var_byte_d || n5 >= ah.var_byte_e || ah2.var_bl_arr_arr_a[n5][n4] != b2) continue;
                b2.void_a((byte)2, (byte)16);
                b2.a((ag)this, this.var_short_e, (byte)2);
                u.var_ah_a.void_b(4, (int)this.var_byte_v);
                continue block0;
            }
        }
    }

    public boolean boolean_b() {
        boolean bl2 = this.boolean_c();
        if (bl2 && this.w == 1 || !bl2 && this.w == 2) {
            if (this.var_byte_a != 5) {
                this.var_byte_c = 0;
                this.void_a(this.i[this.var_byte_c]);
            }
            return true;
        }
        if (this.var_byte_a == 5) {
            this.var_byte_c = (byte)(this.var_byte_c + 1);
            this.void_a(this.i[this.var_byte_c]);
        }
        return false;
    }

    public void x() {
        if (this.w == 1) {
            this.w = (byte)2;
            this.var_boolean_a = false;
        } else {
            this.w = 1;
            this.var_boolean_a = true;
        }
    }

    public boolean boolean_c() {
        return bo.b.var_byte_s == 7 && bo.var_be_a.var_byte_s == 7;
    }

    public void y() {
        this.d = 350;
        this.e = 350;
    }

    public void z() {
        if (bo.var_be_a.var_byte_s == 7) {
            --this.d;
            if (this.d < 0) {
                this.A();
                this.d = 350;
            }
        }
        if (bo.b.var_byte_s == 7) {
            --this.e;
            if (this.e < 0) {
                this.B();
                this.e = 350;
            }
        }
    }

    public void A() {
        this.c(this.var_ay_a.var_byte_b == 97 ? (byte)100 : 98, 7);
    }

    public void B() {
        this.c(this.var_ay_a.var_byte_b == 97 ? (byte)101 : 99, 11);
    }

    public void c(byte by2, int n2) {
        int n3 = 3;
        for (int i2 = 3; i2 < ah.var_byte_e; ++i2) {
            if (u.var_ah_a.boolean_b(n2, i2)) continue;
            n3 = i2;
            break;
        }
        u.var_ah_a.a(by2, n2, n3);
    }
}

