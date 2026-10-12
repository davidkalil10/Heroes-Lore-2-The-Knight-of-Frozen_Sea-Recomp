/*
 * Decompiled with CFR 0.152.
 */
public class ag
extends bb {
    public static byte var_byte_e;
    public static byte k;
    private static final byte[] i;
    public byte l;
    public ay var_ay_a;
    private int var_int_a;
    private int var_int_b;
    public byte m;
    public short var_short_a;
    public short var_short_b;
    public short var_short_e;
    private byte var_byte_a;
    public byte n;
    public byte o;
    public byte p;
    public byte q = 0;
    public byte r = 0;
    public bl c;
    public boolean var_boolean_b = true;
    public boolean g = false;
    public boolean h = false;

    public ag(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, (byte)8, (byte)8);
        this.var_int_a = ((bl)this).h;
        this.var_int_b = ((bl)this).i;
        this.l = by3;
        this.var_ay_a = ay.var_ay_arr_a[by3];
        int n2 = this.var_ay_a.var_short_f > 0 ? f.a(0, 2) : 0;
        this.m = (byte)(this.var_ay_a.h + n2);
        this.var_short_a = (short)(this.var_ay_a.var_short_a + n2 * 20);
        this.var_short_e = (short)(this.var_ay_a.var_short_b + n2 * 3);
        this.n = this.var_ay_a.j;
        this.o = this.var_ay_a.k;
        this.j = (byte)(this.var_ay_a.var_byte_g == 1 ? 2 : 1);
        this.var_short_b = this.var_short_a;
        this.g = false;
        this.var_boolean_s = false;
        this.var_boolean_t = false;
        this.var_boolean_u = false;
        this.h = this.var_ay_a.var_boolean_a;
        this.a(s2, s3);
    }

    public void a(short s2, short s3) {
        this.u();
        super.a(s2, s3);
        this.void_c();
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
        switch (this.var_ay_a.var_byte_a) {
            case 1: 
            case 7: {
                bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.v, n6 + 8 - 3, n7 + 6, 33);
                bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.v, n6 - 3, n7 + 6, 33);
                break;
            }
            case 6: 
            case 9: 
            case 10: 
            case 16: {
                bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.w, n6, n7 + 4, 33);
                break;
            }
            default: {
                bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.v, n6, n7 + 6, 33);
            }
        }
        switch (this.var_byte_s) {
            case 2: {
                this.a((byte)1, this.var_byte_t, n6, n7);
                break;
            }
            case 3: {
                this.a((byte)2, this.var_byte_t, n6, n7);
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

    public void a(byte by2, byte by3, int n2, int n3) {
        bd.void_a(this.l, by2, this.var_byte_v, by3, n2, n3);
    }

    public void j() {
        this.n();
    }

    public void f() {
        this.var_byte_v = (byte)(this.var_byte_v + 1);
        this.v();
        if (!this.var_boolean_b) {
            b b2 = u.var_b_a;
            byte by2 = this.byte_a(b2);
            byte by3 = this.b(b2);
            if ((by2 > this.var_ay_a.i || by3 > this.var_ay_a.i) && this.c == null) {
                return;
            }
            if (by2 > 4 || by3 > 4) {
                this.c = null;
                return;
            }
        }
        if (this.q > 0) {
            this.q = (byte)(this.q - 1);
        }
        this.l();
        this.boolean_d();
        this.p();
    }

    public void void_a(bt bt2) {
        switch (bt2.c) {
            case 26: {
                if (bt2.b % 10 != 0) break;
                this.var_short_b = (short)(this.var_short_b - u.var_b_a.var_byte_p);
                this.b(new bh(-5, this.var_ay_a.var_byte_a, u.var_b_a.var_byte_p + this.m));
                this.b(new al(21));
                break;
            }
            case 3: {
                if (bt2.b != 2 && bt2.b != 5) break;
                cg cg2 = u.var_b_a.cg_a();
                int n2 = (cg2.var_short_b * 27 / 10 + 20 + u.var_b_a.var_short_i + u.var_b_a.var_short_arr_b[4]) * cg2.var_byte_arr_k[cg2.var_byte_b] * 2 / 3;
                this.a(n2, this.var_byte_t, ax.h[3]);
                ak.a((byte)3);
                break;
            }
            case 7: {
                if (bt2.b % 7 != 1) break;
                cg cg3 = u.var_b_a.cg_a();
                int n3 = (cg3.var_short_b + 30 + u.var_b_a.var_short_i + u.var_b_a.var_short_arr_b[4]) * cg3.var_byte_arr_k[cg3.var_byte_b] * 2 / 3;
                this.a(n3, this.var_byte_t, ax.h[7]);
            }
        }
    }

    public boolean boolean_a(bt bt2) {
        switch (bt2.c) {
            case 32: {
                this.var_boolean_s = false;
                break;
            }
            case 26: {
                this.var_boolean_t = false;
                break;
            }
            case 25: {
                this.var_boolean_u = false;
                break;
            }
            default: {
                return true;
            }
        }
        return false;
    }

    public void l() {
        boolean bl2;
        boolean bl3 = bl2 = !this.var_boolean_c && !this.var_boolean_d;
        if (this.var_byte_s == 6) {
            this.m();
            return;
        }
        if (this.var_boolean_u && bl2) {
            this.void_f((byte)4);
        }
        switch (this.var_byte_s) {
            case 2: {
                if (!bl2) break;
                this.o();
                break;
            }
            case 4: {
                if (this.var_byte_v < 2) break;
                this.b(false);
                break;
            }
            case 1: {
                this.n();
                break;
            }
            case 3: {
                this.h();
                break;
            }
        }
    }

    public void m() {
        if (this.p == 5) {
            this.b(new al(20));
        } else if (this.p == 3) {
            this.h = true;
        } else if (this.p < 1) {
            this.w();
        }
        this.p = (byte)(this.p - 1);
    }

    public void void_a(byte by2, byte by3) {
        u.var_ah_a.d(new ab(this, this.var_byte_t, ((bl)this).h, ((bl)this).i, by2, by3, true));
    }

    public void void_b() {
        int n2 = this.int_a((byte)3);
        if (this.var_ay_a.var_byte_d == var_byte_e && this.var_byte_v == i[this.var_ay_a.var_byte_e]) {
            u.var_b_a.a(this, this.var_short_e, this.var_byte_t);
        } else if (this.var_ay_a.var_byte_d == k && this.var_byte_v == n2 - 1) {
            if (this.var_ay_a.var_byte_a == 9) {
                this.void_a((byte)1, (byte)3);
            } else if (this.var_ay_a.var_byte_a == 0) {
                this.void_a((byte)0, (byte)3);
            }
        } else if (this.var_byte_v >= n2) {
            this.b(false);
            this.n();
        }
    }

    public void h() {
        if (this.var_byte_v >= this.int_a((byte)3)) {
            this.b(false);
            this.n();
        }
    }

    public void n() {
        b b2 = u.var_b_a;
        if (this.o == 0 && this.boolean_a(b2)) {
            return;
        }
        if (this.n == 0) {
            this.void_d();
        }
    }

    public boolean boolean_a(bl bl2) {
        if (this.var_ay_a.var_byte_d == k) {
            for (byte by2 = 1; by2 <= 3; by2 = (byte)(by2 + 1)) {
                if (this.bl_a(this.var_byte_t, by2) != bl2) continue;
                this.r();
                return true;
            }
        } else if (this.a(this.var_byte_t, bl2) == bl2) {
            this.r();
            return true;
        }
        return false;
    }

    public void void_d() {
        byte by2;
        b b2 = u.var_b_a;
        cg cg2 = b2.cg_a();
        byte by3 = by2 = this.var_ay_a.var_byte_d == k ? (byte)3 : 1;
        if (this.c == b2) {
            this.a((bl)b2, by2);
        } else {
            bl bl2 = this.a(b2, cg2);
            if (bl2 != null) {
                this.a(bl2, by2);
                this.c = bl2;
            } else {
                this.q();
            }
        }
    }

    public void o() {
        if (this.var_byte_a < this.var_ay_a.j * 2 && bb.var_java_util_Random_a.nextInt() > 0) {
            this.var_byte_a = (byte)(this.var_byte_a + (this.var_ay_a.j >> 1));
            this.n = 0;
        } else {
            this.b(false);
        }
        this.n();
    }

    public int int_a(byte by2) {
        if (by2 > 4) {
            return -1;
        }
        return as.var_byte_arr_arr_d[this.l][by2 - 1];
    }

    public void p() {
        switch (this.var_byte_s) {
            case 1: {
                if (this.o > 0) {
                    this.o = (byte)(this.o - 1);
                }
                if (this.n <= 0) break;
                this.n = (byte)(this.n - 1);
                break;
            }
            case 3: {
                this.void_b();
                return;
            }
            case 6: 
            case 7: 
            case 8: {
                return;
            }
        }
        if (this.var_byte_v >= this.int_a(this.var_byte_s) || this.var_byte_v < 0) {
            this.var_byte_v = 0;
        }
    }

    public void q() {
        this.void_g((byte)((bb.var_java_util_Random_a.nextInt() & 0xFF) % 4 + 1));
        if (bb.var_java_util_Random_a.nextInt() > 0 && !this.boolean_e()) {
            this.void_f((byte)2);
        } else {
            this.b(true);
        }
    }

    public final void b(boolean bl2) {
        this.n = (byte)(this.var_ay_a.j + this.var_byte_a);
        this.var_byte_a = 0;
        this.void_f((byte)1);
        this.var_byte_v = 0;
    }

    public byte byte_a(bl bl2) {
        int n2 = bl2.h - ((bl)this).h;
        return n2 > 0 ? (byte)n2 : (byte)(-n2);
    }

    public byte b(bl bl2) {
        int n2 = bl2.i - ((bl)this).i;
        return n2 > 0 ? (byte)n2 : (byte)(-n2);
    }

    public final bl a(b b2, cg cg2) {
        boolean bl2;
        byte by2 = this.var_ay_a.i;
        boolean bl3 = bl2 = this.byte_a(b2) <= by2 && this.b(b2) <= by2;
        if (bl2) {
            return b2;
        }
        return null;
    }

    public final void r() {
        this.var_byte_a = 0;
        this.o = (byte)(this.var_ay_a.k + 1);
        this.void_f((byte)3);
        this.var_byte_v = 0;
    }

    public boolean a(b b2, byte by2, int n2, boolean bl2, byte by3, byte by4, byte by5, byte by6) {
        int n3;
        if (this.var_byte_s == 7 || this.var_byte_s == 6) {
            return false;
        }
        bd.var_bd_a.a(this, false);
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
            n2 = n2 * b2.var_byte_k / 10;
        }
        if (n2 <= 0) {
            n2 = 3;
        }
        if (by5 > 0) {
            n3 = f.a(1, 100);
            int n5 = b2.var_short_i + b2.var_short_arr_b[4] >> 3;
            switch (by5) {
                case 1: {
                    if (n3 >= 6 + n5) break;
                    n2 = this.var_short_a;
                    b2.b(new bh(-6, 6, 2));
                    break;
                }
                case 2: {
                    if (n3 >= 10 + n5) break;
                    b2.void_a((n2 << 2) / 5);
                    break;
                }
                case 3: {
                    if (n3 >= 10 + n5) break;
                    int n6 = n2 * 3 / 5;
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
                    break;
                }
                case 6: {
                    if (n3 >= 16 + n5) break;
                    this.a(40);
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

    public void a(int n2, byte by2, byte by3) {
        if (this.var_byte_s == 7 || this.var_byte_s == 6) {
            return;
        }
        if (this.var_ay_a.var_byte_b >= 96 && f.a(1, 100) >= 75) {
            this.b(new bh(-2));
            return;
        }
        this.g = true;
        this.h = false;
        short s2 = this.var_ay_a.var_short_d;
        n2 = this.var_boolean_s ? (n2 -= s2 >> 1) : (n2 -= s2);
        if (n2 < 0) {
            n2 = 3;
        }
        n2 = n2 * ax.var_byte_arr_arr_a[by3][this.var_ay_a.var_byte_f] / 10;
        this.b(new al(21));
        this.a(n2, by2);
    }

    public void a(int n2) {
        this.var_boolean_u = true;
        this.void_a((byte)25, this.var_ay_a.var_byte_a, n2);
    }

    public void b(int n2) {
        this.var_boolean_t = true;
        this.void_a((byte)26, this.var_ay_a.var_byte_a, n2);
    }

    public final void a(int n2, byte by2) {
        this.q = (byte)4;
        this.r = by2;
        this.var_short_b = (short)(this.var_short_b - n2);
        if (this.var_short_b <= 0) {
            this.void_f((byte)6);
            this.var_byte_v = (byte)-1;
            this.p = (byte)6;
        }
        this.b(new bh(-5, this.var_ay_a.var_byte_a, n2));
    }

    public void w() {
        int n2;
        int n3;
        this.void_f((byte)7);
        if (this.var_ay_a.var_short_f != 0) {
            int n4;
            int n5;
            u.var_ah_a.a((int)this.l, this.var_ay_a.var_short_f + 100, this.var_int_a, this.var_int_b);
            n3 = f.a(1, Short.MAX_VALUE);
            n2 = -1;
            byte by2 = -1;
            short s2 = 0;
            short s3 = 0;
            for (n5 = n4 = u.var_byte_i > 0 ? 2 : 0; n5 < n4 + 3; ++n5) {
                s2 = n5 > 0 ? f.short_a(this.var_ay_a.var_byte_arr_b, (n5 - 1) * 5 + 3) : (short)0;
                s3 = f.short_a(this.var_ay_a.var_byte_arr_b, n5 * 5 + 3);
                if (s2 >= n3 || n3 >= s3) continue;
                n2 = this.var_ay_a.var_byte_arr_b[n5 * 5];
                if (n2 == 29) {
                    n2 = 23;
                }
                by2 = (byte)f.a(this.var_ay_a.var_byte_arr_b[n5 * 5 + 1], (int)this.var_ay_a.var_byte_arr_b[n5 * 5 + 2]);
                break;
            }
            if (n2 > -1 && n2 != 7) {
                u.var_ah_a.a(((bl)this).h, ((bl)this).i, (byte)n2, by2);
            }
            if (f.a(1, 100) <= 65) {
                u.var_ah_a.a(((bl)this).h, ((bl)this).i, (short)(this.m * 4 + 20));
            }
            if ((n5 = 20 - (u.var_b_a.var_byte_a - this.m)) < 8) {
                n5 = 8;
            } else if (n5 > 40) {
                n5 = 40;
            }
            if (f.a(1, 100) <= n5) {
                u.var_ah_a.a(((bl)this).h, ((bl)this).i, (byte)20, (byte)0);
            }
            if (f.a(1, 100) <= 10) {
                u.var_ah_a.a(((bl)this).h, ((bl)this).i, (byte)(f.a(1, 2) == 1 ? (this.m < 25 ? 24 : 25) : 26), (byte)0);
            }
            if (f.a(1, 100) >= 90) {
                int n6 = this.var_ay_a.var_byte_b / 3;
                if (n6 > 0) {
                    --n6;
                }
                if (n6 != 11 && n6 != 12) {
                    u.var_ah_a.a(((bl)this).h, ((bl)this).i, (byte)34, (byte)n6);
                }
            }
            if (u.var_byte_i > 1 && f.a(1, 100) >= 95) {
                u.var_ah_a.a(((bl)this).h, ((bl)this).i, (byte)25, (byte)0);
            }
        }
        if ((n3 = 20 - (u.var_b_a.var_byte_a - this.m)) < 0) {
            n3 = 0;
        } else if (n3 > 28) {
            n3 = 28;
        }
        n2 = this.m * 17 * n3 / 20;
        if (n2 > 0) {
            u.var_b_a.c(n2);
        }
        u.e((byte)this.var_ay_a.var_short_g);
        if (this.var_ay_a.l > 0) {
            ae.var_ae_a.void_a(this.var_ay_a.l);
        }
    }

    static {
        var_byte_e = 0;
        k = 1;
        i = new byte[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 1, 1, 2, 3, 3, 3, 3, 4, 3};
    }
}

