/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import java.util.Vector;

public abstract class bb
extends bl {
    public Vector var_java_util_Vector_a;
    public Vector b;
    public byte var_byte_s;
    public byte var_byte_t;
    public byte var_byte_u;
    public byte var_byte_v;
    public boolean var_boolean_s = false;
    public boolean var_boolean_t = false;
    public boolean var_boolean_u = false;
    public boolean var_boolean_v = false;
    public static Random var_java_util_Random_a;

    public bb(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, by2, by3);
        this.g();
    }

    public void g() {
        if (this.var_java_util_Vector_a == null) {
            this.s();
        }
        if (this.b == null) {
            this.b = new Vector(3);
        }
        this.var_byte_s = 1;
        this.var_byte_u = this.var_byte_t;
        this.var_byte_v = (byte)-1;
    }

    public void s() {
        this.var_java_util_Vector_a = new Vector(3);
    }

    public void void_f(byte by2) {
        this.var_byte_s = by2;
        this.var_byte_v = (byte)-1;
    }

    public void void_g(byte by2) {
        this.var_byte_t = this.var_byte_u = by2;
    }

    public final boolean boolean_d() {
        if (this.var_byte_s == 2 || this.var_byte_s == 5) {
            if (!this.boolean_e()) {
                this.f(8);
                return true;
            }
            this.j();
        }
        return false;
    }

    public abstract void j();

    public boolean boolean_e() {
        if (this.var_boolean_c || this.var_boolean_d) {
            return false;
        }
        if (!u.var_ah_a.a(this, this.var_byte_t)) {
            this.void_f((byte)1);
            return true;
        }
        return false;
    }

    public void t() {
        ah ah2 = u.var_ah_a;
        for (byte by2 = 0; by2 < this.j; by2 = (byte)(by2 + 1)) {
            ah2.var_bl_arr_arr_a[this.i][this.h + by2] = this;
            if (this.var_boolean_d) {
                ah2.var_bl_arr_arr_a[this.i + 1][this.h + by2] = this;
                continue;
            }
            if (!this.var_boolean_c) continue;
            ah2.var_bl_arr_arr_a[this.i][this.h + 1 + by2] = this;
        }
    }

    public void u() {
        ah ah2 = u.var_ah_a;
        for (byte by2 = 0; by2 < this.j; by2 = (byte)(by2 + 1)) {
            ah2.var_bl_arr_arr_a[this.i][this.h + by2] = null;
            if (this.var_boolean_d) {
                ah2.var_bl_arr_arr_a[this.i + 1][this.h + by2] = null;
                continue;
            }
            if (!this.var_boolean_c) continue;
            ah2.var_bl_arr_arr_a[this.i][this.h + 1 + by2] = null;
        }
    }

    public void f(int n2) {
        this.u();
        this.var_short_c = (short)(this.var_short_c + ax.var_byte_arr_a[this.var_byte_t] * n2);
        this.var_short_d = (short)(this.var_short_d + ax.var_byte_arr_b[this.var_byte_t] * n2);
        this.void_c();
        this.t();
    }

    public void void_h(byte by2) {
        if (this.var_byte_v == by2) {
            this.var_byte_v = 0;
        }
    }

    public bl a(byte by2, bl bl2) {
        ah ah2 = u.var_ah_a;
        bl bl3 = null;
        for (int i2 = 0; i2 < this.j; ++i2) {
            int n2 = this.h + ax.var_byte_arr_a[by2] + i2;
            int n3 = this.i + ax.var_byte_arr_b[by2];
            if (n3 < 0 || n2 < 0 || n3 >= ah.var_byte_e || n2 >= ah.var_byte_d) break;
            bl3 = ah2.var_bl_arr_arr_a[n3][n2];
            if (bl3 == this) continue;
            if (bl2 == null && bl3 != null) {
                return bl3;
            }
            if (bl2 == null || bl3 != bl2) continue;
            return bl3;
        }
        return null;
    }

    public void a(bl bl2, byte by2) {
        byte by3;
        byte by4;
        byte by5;
        int n2;
        byte by6 = bl2.h;
        byte by7 = bl2.i;
        ah ah2 = u.var_ah_a;
        int n3 = 100;
        for (n2 = 0; n2 < this.j; n2 = (int)((byte)(n2 + 1))) {
            if (Math.abs(n3) <= Math.abs(by6 - (this.h + n2))) continue;
            n3 = by6 - (this.h + n2);
        }
        n2 = by7 - this.i;
        int n4 = Math.abs(n3);
        int n5 = Math.abs(n2);
        int n6 = var_java_util_Random_a.nextInt();
        if (n4 + n5 <= by2 && n4 * n5 == 0 || bl2 == this.a(this.var_byte_u, bl2)) {
            byte by8 = n2 != 0 ? (n2 < 0 ? (byte)1 : 2) : (n3 < 0 ? (byte)3 : 4);
            this.void_g(by8);
            return;
        }
        byte by9 = 0;
        if (n5 == n4) {
            by5 = n3 > 0 ? (byte)4 : 3;
            by4 = n2 > 0 ? (byte)2 : 1;
            boolean bl3 = ah2.a(this, by5);
            boolean bl4 = ah2.a(this, by4);
            by9 = bl3 && bl4 ? (var_java_util_Random_a.nextInt() > 0 ? by5 : by4) : (bl3 ? by5 : by4);
        } else {
            by9 = n5 > n4 ? (n2 > 0 ? (byte)2 : 1) : (n3 > 0 ? (byte)4 : 3);
        }
        if ((n4 <= by2 || n5 <= by2) && n4 != n5) {
            if (n4 <= by2 && n5 < n4) {
                if (n2 > 0 && ah2.a(this, (byte)2)) {
                    by9 = 2;
                } else if (n2 < 0 && ah2.a(this, (byte)1)) {
                    by9 = 1;
                }
            } else if (n5 <= by2 && n5 > n4) {
                if (n3 > 0 && ah2.a(this, (byte)4)) {
                    by9 = 4;
                } else if (n3 < 0 && ah2.a(this, (byte)3)) {
                    by9 = 3;
                }
            }
        }
        by5 = 0;
        if (ah2.a(this, by9)) {
            by3 = by9;
            by5 = 1;
        } else {
            by4 = 1;
            if (by9 == 1 && n3 > 0 || by9 == 2 && n3 < 0 || by9 == 3 && n2 < 0 || by9 == 4 && n2 > 0) {
                by4 = 0;
            }
            if ((by3 = (byte)this.a(bl2, by9, by4 != 0)) != 0) {
                by5 = 1;
            } else {
                by3 = this.a(bl2, by9, by4 == 0);
                if (by3 != 0) {
                    by5 = 1;
                } else if (by4 != 0 && ah2.a(this, ax.f[by9])) {
                    by3 = ax.f[by9];
                    by5 = 1;
                } else if (by4 == 0 && ah2.a(this, ax.e[by9])) {
                    by3 = ax.e[by9];
                    by5 = 1;
                }
            }
        }
        if (by5 == 0) {
            by3 = (byte)((n6 & 0xFF) % 4 + 1);
        }
        this.void_f((byte)2);
        this.void_g(by3);
    }

    private final byte a(bl bl2, byte by2, boolean bl3) {
        byte[] byArray;
        byte[] byArray2;
        ah ah2 = u.var_ah_a;
        if (!bl3) {
            byArray2 = ax.e;
            byArray = ax.c;
        } else {
            byArray2 = ax.f;
            byArray = ax.d;
        }
        byte by3 = by2 == 1 || by2 == 2 ? this.j : (byte)1;
        for (int i2 = -by3 + 1; i2 < by3; ++i2) {
            if (!ah2.a(this, this.h + i2 + ax.var_byte_arr_a[byArray2[by2]], this.i + ax.var_byte_arr_b[byArray2[by2]]) || !ah2.a(this, this.h + i2 + ax.var_byte_arr_a[byArray[by2]], this.i + ax.var_byte_arr_b[byArray[by2]]) && bl2 != ah2.var_bl_arr_arr_a[this.i + ax.var_byte_arr_b[byArray[by2]]][this.h + i2 + ax.var_byte_arr_a[byArray[by2]]]) continue;
            return byArray2[by2];
        }
        return 0;
    }

    public void b(bt bt2) {
        this.var_java_util_Vector_a.addElement(bt2);
    }

    public boolean boolean_g(byte by2) {
        bt bt2 = null;
        for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
            bt2 = (bt)this.b.elementAt(i2);
            if (bt2.c != by2) continue;
            return false;
        }
        return true;
    }

    public void void_a(byte by2, byte by3, byte by4) {
        if (this.boolean_g(by2)) {
            bh bh2 = new bh(by2, by3, by4);
            this.b.addElement(bh2);
        }
    }

    public void void_a(byte by2, int n2) {
        if (this.boolean_g(by2)) {
            aj aj2 = new aj(by2, n2);
            this.b.addElement(aj2);
        }
    }

    public void void_a(byte by2, byte by3, int n2) {
        if (this.boolean_g(by2)) {
            al al2 = new al(by2, by3, n2);
            this.b.addElement(al2);
        }
    }

    public void void_b(byte by2, byte by3, int n2) {
        if (this.boolean_g(by2)) {
            i i2 = new i(by2, by3, n2);
            this.b.addElement(i2);
        }
    }

    public final void e(int n2, int n3) {
        for (int i2 = this.var_java_util_Vector_a.size() - 1; i2 >= 0; --i2) {
            bt bt2 = (bt)this.var_java_util_Vector_a.elementAt(i2);
            bt2.b(n2, n3);
            if (!bt2.var_boolean_a) continue;
            this.var_java_util_Vector_a.removeElementAt(i2);
        }
    }

    public final void f(int n2, int n3) {
        for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
            bt bt2 = (bt)this.b.elementAt(i2);
            bt2.b(n2, n3);
        }
    }

    public void v() {
        for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
            bt bt2 = (bt)this.b.elementAt(i2);
            if (bt2.var_boolean_a) {
                this.boolean_a(bt2);
                this.b.removeElementAt(i2);
                continue;
            }
            this.void_a(bt2);
        }
    }

    public void void_a(bt bt2) {
    }

    public boolean boolean_a(bt bt2) {
        return true;
    }

    static {
        var_java_util_Random_a = new Random();
    }
}

