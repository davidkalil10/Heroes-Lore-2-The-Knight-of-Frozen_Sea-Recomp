/*
 * Decompiled with CFR 0.152.
 */
public abstract class w
extends ag {
    public int var_int_a;
    public int var_int_b;
    public byte var_byte_a;
    public byte var_byte_b;
    public byte var_byte_c;
    public byte d;
    public int var_int_c;
    public byte[] i;
    public boolean var_boolean_a = false;

    public abstract boolean boolean_a();

    public w(short s2, short s3, byte by2, byte by3, byte by4) {
        super((short)(s2 << 4), (short)(s3 << 4), by2, by3);
        this.j = by4;
        this.var_byte_a = 0;
        this.var_byte_c = 0;
        this.var_int_c = 0;
        this.var_boolean_a = false;
        this.t();
    }

    public void b(int n2, int n3) {
        int n4 = n2 + this.var_short_c + this.var_byte_f + (this.j - 1) * 8;
        int n5 = n3 + this.var_short_d + ((bl)this).g;
        if (n4 < -16 || n5 < 0 || n4 > bd.var_int_a + 16 || n5 > bd.var_int_b + 32) {
            this.f(n4, n5);
            this.e(n4, n5);
            this.var_boolean_b = false;
            return;
        }
        this.var_boolean_b = true;
        if (this.h) {
            this.f(n4, n5);
            this.e(n4, n5);
            return;
        }
        int n6 = n4;
        int n7 = n5;
        if (this.q == 3 || this.q == 1) {
            n6 += ax.var_byte_arr_a[this.r] * 3;
            n7 += ax.var_byte_arr_b[this.r] * 3;
        }
        bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.v, n6, n7 + 6, 33);
        switch (this.var_byte_s) {
            case 2: {
                this.a((byte)1, this.var_byte_t, n6, n7);
                break;
            }
            case 3: {
                this.a(this.var_byte_a, this.var_byte_t, n6, n7);
                break;
            }
            case 4: 
            case 6: {
                this.a((byte)3, this.var_byte_t, n6, n7);
                break;
            }
            default: {
                this.a((byte)0, this.var_byte_t, n6, n7);
            }
        }
        this.f(n4, n5);
        this.e(n4, n5);
    }

    public void f() {
        this.var_byte_v = (byte)(this.var_byte_v + 1);
        this.var_int_a = this.byte_a(u.var_b_a);
        this.var_int_b = this.b(u.var_b_a);
        this.v();
        this.l();
        this.boolean_d();
        this.p();
    }

    public void h() {
        if (this.var_byte_v >= this.var_byte_b) {
            this.b(false);
            this.var_byte_c = (byte)(this.var_byte_c + 1);
            this.void_a();
            this.void_a(this.i[this.var_byte_c]);
            this.n();
            this.g = false;
        }
    }

    public void void_a() {
        if (this.var_short_b > this.var_int_c) {
            if (this.var_byte_c >= this.d) {
                this.var_byte_c = 0;
            }
        } else if (this.var_byte_c >= this.i.length) {
            this.var_byte_c = 0;
        }
    }

    public boolean boolean_a(bl bl2) {
        this.i();
        if (this.boolean_a()) {
            this.r();
            return true;
        }
        return false;
    }

    public void void_a(byte by2) {
        this.var_byte_a = by2;
        this.var_byte_b = as.var_byte_arr_arr_d[this.l][by2];
    }

    public void i() {
        b b2 = u.var_b_a;
        int n2 = ((bl)b2).h - ((bl)this).h;
        int n3 = ((bl)b2).i - ((bl)this).i;
        this.var_byte_t = n2 == 0 ? (byte)(n3 > 0 ? 2 : 1) : (n3 == 0 ? (byte)(n2 > 0 ? 4 : 3) : (n2 < n3 ? (byte)(n3 > 0 ? 2 : 1) : (byte)(n2 > 0 ? 4 : 3)));
    }

    public void k() {
        if (((bl)this).h < 2 || ((bl)this).i < 2 || ((bl)this).h >= ah.var_byte_d - 2 || ((bl)this).i >= ah.var_byte_e - 2) {
            this.q();
        } else {
            this.i();
            this.var_byte_t = this.var_byte_t == 1 || this.var_byte_t == 3 ? (byte)(this.var_byte_t + 1) : (byte)(this.var_byte_t - 1);
            if (!u.var_ah_a.a(this, this.var_byte_t)) {
                this.q();
            }
        }
    }

    public void a(byte by2, byte by3, byte by4, int n2) {
        byte by5 = (byte)(((bl)this).h + ax.var_byte_arr_a[by3]);
        byte by6 = (byte)(((bl)this).i + ax.var_byte_arr_b[by3]);
        if (by5 < 0 || by6 < 0 || by5 >= ah.var_byte_d || by6 >= ah.var_byte_e) {
            return;
        }
        u.var_ah_a.d(new ab(this, by4, by5, by6, by2, (byte)n2, true));
    }

    public boolean a(b b2, byte by2, int n2, boolean bl2, byte by3, byte by4, byte by5, byte by6) {
        int n3;
        if (this.var_byte_s == 7 || this.var_byte_s == 6) {
            return false;
        }
        bd.var_bd_a.a(this, false);
        if (this.var_boolean_a) {
            if (!this.h) {
                this.b(new bh(-2));
            }
            return false;
        }
        int n4 = b2.var_int_k + this.m + this.var_ay_a.var_short_e / 5;
        if (n4 > 90) {
            n4 = 90;
        } else if (n4 < 8) {
            n4 = 8;
        }
        if (f.a(0, 99) < n4) {
            this.b(new bh(-2));
            return false;
        }
        this.g = true;
        this.h = false;
        short s2 = this.var_ay_a.var_short_c;
        n2 = this.var_boolean_s ? (n2 -= s2 >> 1) : (n2 -= s2);
        if (n2 < 0) {
            n2 = 0;
        }
        if (n.e) {
            n2 = n.var_int_a;
        }
        n2 = n2 * ax.var_byte_arr_arr_a[by4][this.var_ay_a.var_byte_f] / 10;
        n2 = b2.a(by2, n2, this);
        boolean bl3 = false;
        if (!b2.var_boolean_h && f.a(0, 99) < b2.var_int_l) {
            n3 = 20 + this.m - b2.var_byte_a;
            if (n3 < 8) {
                n3 = 8;
            } else if (n3 > 50) {
                n3 = 50;
            }
            boolean bl4 = bl3 = f.a(0, 99) < n3;
        }
        if (bl3 || b2.var_boolean_h) {
            n2 *= b2.var_int_l / 10;
        }
        if (n2 < 0) {
            n2 = 3;
        }
        if (by5 > 0) {
            n3 = f.a(1, 100);
            int n5 = b2.var_short_i + b2.var_short_arr_b[4] >> 3;
            switch (by5) {
                case 2: {
                    if (n3 >= 10 + n5) break;
                    b2.void_a((n2 << 1) / 5);
                    break;
                }
                case 3: {
                    if (n3 >= 10 + n5) break;
                    int n6 = n2 >> 1;
                    b2.b(n6);
                    b2.b(new bh(-5, -1, n6));
                    break;
                }
                case 4: {
                    if (n3 >= 16 + n5) break;
                    b2.var_boolean_i = true;
                    b2.void_a((byte)-6, (byte)10, (byte)20);
                    break;
                }
                case 5: {
                    if (n3 >= 16 + n5) break;
                    b2.var_boolean_h = true;
                    b2.void_a((byte)-6, (byte)1, (byte)20);
                }
            }
        }
        this.a(n2, by3);
        if (bl3) {
            this.b(new al(22));
            if (cj.var_boolean_c) {
                ak.a((byte)0);
            }
            return true;
        }
        if (by6 == 33) {
            this.b(new aj(by6, 4));
        } else {
            this.b(new al(by6));
        }
        ak.a((byte)4);
        return true;
    }
}

