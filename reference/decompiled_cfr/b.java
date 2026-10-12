/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public abstract class b
extends bb {
    public static final byte[] var_byte_arr_i;
    public static final byte[] var_byte_arr_j;
    public static final byte[] var_byte_arr_k;
    public static final byte[] var_byte_arr_l;
    public static final byte[][] var_byte_arr_arr_b;
    public static final byte[] var_byte_arr_m;
    public static byte[] var_byte_arr_n;
    public byte var_byte_a;
    public byte var_byte_b;
    public short var_short_a;
    public short var_short_b;
    public int var_int_a;
    public int var_int_b;
    public int var_int_c;
    public int var_int_d;
    public int var_int_e;
    public int var_int_f;
    public short var_short_e;
    public short var_short_f;
    public short var_short_g;
    public short var_short_h;
    public short var_short_i;
    public short[] var_short_arr_b = new short[5];
    public int var_int_g;
    public int var_int_h;
    public int var_int_i;
    public byte var_byte_c;
    public byte[] var_byte_arr_o;
    public byte var_byte_d;
    public byte var_byte_e;
    public int var_int_j;
    public int var_int_k;
    public int var_int_l;
    public byte var_byte_k;
    public int var_int_m;
    public int var_int_n;
    public boolean var_boolean_a = false;
    public byte var_byte_l;
    public byte var_byte_m;
    public static byte var_byte_n;
    public static byte var_byte_o;
    public short[] var_short_arr_c = new short[2];
    public short[] var_short_arr_d = new short[2];
    public byte var_byte_p;
    private byte w = 0;
    public byte var_byte_q;
    public boolean var_boolean_b = false;
    public int var_int_o = 0;
    public boolean var_boolean_g = true;
    public boolean var_boolean_h = false;
    public boolean var_boolean_i = false;
    public boolean var_boolean_j = false;
    public boolean var_boolean_k = false;
    public boolean var_boolean_l = false;
    public int var_int_p = 0;
    public boolean var_boolean_m = false;
    public boolean var_boolean_n = false;
    public int var_int_q = 0;
    public boolean var_boolean_o = false;
    public boolean var_boolean_p = false;
    public boolean var_boolean_q = false;
    public p[] var_p_arr_a;
    public byte var_byte_r = 0;
    public cg var_cg_a = null;
    public byte[] var_byte_arr_p = null;
    private byte x;
    private byte y;
    private byte z = 0;
    private byte A;
    public boolean var_boolean_r;

    public abstract boolean boolean_a();

    public abstract byte byte_a(byte var1);

    public abstract void void_b();

    public abstract byte byte_a(int var1);

    public abstract int int_a(int var1);

    public abstract short short_a(int var1);

    public abstract int a(byte var1, int var2, ag var3);

    public abstract boolean boolean_a(byte var1);

    public abstract boolean boolean_b();

    public b(short s2, short s3, byte by2, byte by3) {
        super(s2, s3, by2, by3);
    }

    public void void_d() {
        int n2;
        int n3 = var_byte_arr_i[u.var_byte_a];
        for (n2 = 0; n2 < n3; ++n2) {
            if (this.var_byte_arr_p[n2] != -1) continue;
            if (this.var_byte_a < var_byte_arr_l[n2]) break;
            this.var_byte_arr_p[n2] = 0;
        }
        for (n2 = n3; n2 < 15; ++n2) {
            if (this.var_byte_arr_p[n2] != -1 || this.var_byte_a < var_byte_arr_arr_b[u.var_byte_a][n2 - n3]) continue;
            this.var_byte_arr_p[n2] = 0;
        }
        this.q();
    }

    public static b a(byte by2, short s2, short s3) {
        b b2 = null;
        switch (by2) {
            case 1: {
                b2 = new an(s2, s3, 8, 9);
                break;
            }
            case 2: {
                b2 = new ac(s2, s3, 8, 9);
                break;
            }
            case 0: {
                b2 = new ce(s2, s3, 8, 9);
            }
        }
        return b2;
    }

    public void void_a() {
        as.var_java_lang_Object_arr_a = new Object[16];
        this.var_boolean_g = true;
        this.var_byte_a = 1;
        this.var_byte_b = 0;
        if (n.f) {
            this.var_byte_a = (byte)99;
        }
        this.var_byte_arr_p = new byte[15];
        for (int i2 = 0; i2 < 15; ++i2) {
            this.var_byte_arr_p[i2] = (byte)(n.c ? 0 : -1);
        }
        this.var_byte_arr_p[0] = 1;
        this.var_byte_arr_p[b.var_byte_arr_i[u.var_byte_a]] = 1;
        this.var_byte_c = 1;
        this.q();
        this.var_short_b = 0;
        this.var_short_a = 0;
        this.var_int_c = 0;
        this.o();
        as.var_as_a.b();
        this.var_boolean_s = false;
        this.var_boolean_t = false;
        this.var_boolean_u = false;
        this.var_boolean_h = false;
        this.var_boolean_l = false;
        this.var_boolean_k = false;
        this.var_boolean_j = false;
        this.var_int_p = 0;
        this.var_boolean_n = false;
        this.var_boolean_m = false;
        this.var_int_q = 0;
        this.var_boolean_o = false;
        this.var_boolean_p = false;
        this.var_boolean_q = false;
        this.var_boolean_a = false;
        if (n.g) {
            this.var_short_a = (short)294;
            this.var_short_b = (short)49;
        }
    }

    public void void_a(byte by2) {
        for (int i2 = 0; i2 < u.var_java_util_Vector_a.size(); ++i2) {
            ((cg)u.var_java_util_Vector_a.elementAt((int)this.var_byte_r)).var_boolean_a = false;
        }
        this.var_byte_r = by2;
        this.var_cg_a = (cg)u.var_java_util_Vector_a.elementAt(this.var_byte_r);
        this.var_cg_a.var_boolean_a = true;
    }

    public void void_e() {
        this.var_byte_r = this.byte_a();
    }

    public byte byte_a() {
        for (byte by2 = 0; by2 < u.var_java_util_Vector_a.size(); by2 = (byte)(by2 + 1)) {
            if (!((cg)u.var_java_util_Vector_a.elementAt((int)by2)).var_boolean_a) continue;
            return by2;
        }
        return -1;
    }

    public void void_f() {
        this.var_cg_a = (cg)u.var_java_util_Vector_a.elementAt(this.var_byte_r);
        this.var_cg_a.b(true);
    }

    public final void g() {
        super.g();
        this.var_byte_arr_o = new byte[var_byte_arr_i[u.var_byte_a] + 1];
        this.k();
        if (this.var_cg_a != null) {
            this.var_cg_a.void_a();
        }
        this.var_boolean_r = false;
    }

    public void h() {
        this.var_byte_v = (byte)(this.var_byte_v + 1);
        if (this.var_byte_e > 0) {
            this.var_byte_e = (byte)(this.var_byte_e - 1);
        } else if (u.var_int_a == 3) {
            u.i();
            this.x();
        }
        this.v();
        this.w();
        this.m();
        byte by2 = this.var_byte_s;
        if (this.boolean_d()) {
            this.var_boolean_r = false;
        }
        this.i(by2);
    }

    public void void_a(bt bt2) {
        switch (bt2.c) {
            case 26: {
                if (bt2.b % 10 != 0) break;
                int n2 = this.var_int_d / 30;
                this.b(-n2);
                this.b(new bh(-4, -1, n2));
                this.b(new al(21));
                break;
            }
            case 4: {
                if (bt2.b % 30 == 1) {
                    this.b(this.var_short_f + this.var_short_arr_b[1]);
                }
                if (bt2.b % 10 != 1) break;
                this.void_a(this.var_short_h + this.var_short_arr_b[3]);
            }
        }
    }

    public boolean boolean_a(bt bt2) {
        switch (bt2.c) {
            case -6: {
                this.var_boolean_h = false;
                this.var_boolean_i = false;
                break;
            }
            case 30: {
                this.var_boolean_j = false;
                this.n();
                break;
            }
            case 31: {
                this.var_boolean_k = false;
                break;
            }
            case 34: {
                this.var_boolean_m = false;
                this.n();
                break;
            }
            case 35: {
                this.var_boolean_n = false;
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
            case 27: {
                this.var_boolean_v = false;
                this.n();
                break;
            }
            case 5: {
                this.var_boolean_p = false;
                break;
            }
            case 1: {
                this.var_boolean_q = false;
                this.n();
                break;
            }
            case 36: {
                this.var_boolean_o = false;
                this.n();
                break;
            }
            default: {
                return true;
            }
        }
        return false;
    }

    public boolean boolean_b(byte by2) {
        for (int i2 = ((bb)this).b.size() - 1; i2 >= 0; --i2) {
            bt bt2 = (bt)((bb)this).b.elementAt(i2);
            if (bt2.c != by2 || this.boolean_a(bt2)) continue;
            ((bb)this).b.removeElementAt(i2);
            return true;
        }
        return false;
    }

    public void i() {
        if (this.var_boolean_t) {
            this.boolean_b((byte)26);
        }
        if (this.var_boolean_u) {
            this.boolean_b((byte)25);
        }
        if (this.var_boolean_v) {
            this.boolean_b((byte)27);
        }
    }

    private void w() {
        switch (this.var_byte_s) {
            case 2: {
                if (this.w != 0 && !this.var_boolean_c && !this.var_boolean_d) {
                    this.void_g(this.w);
                    this.w = 0;
                }
                this.void_h((byte)4);
                break;
            }
            case 3: {
                if (this.var_byte_d < 0) {
                    this.var_byte_d = 0;
                }
                this.l();
                break;
            }
            case 6: {
                if (this.var_byte_v < 9) break;
                this.void_f((byte)7);
                u.void_a((byte)8);
                ak.d();
                break;
            }
            default: {
                this.w = 0;
                this.void_h((byte)4);
            }
        }
    }

    private void x() {
        if (u.var_int_a != 3) {
            return;
        }
        switch (this.var_byte_s) {
            case 1: {
                this.x = (byte)(this.x - 2);
                this.y = (byte)(this.y - 2);
                break;
            }
            case 2: {
                this.x = (byte)(this.x - 1);
                this.y = (byte)(this.y - 1);
            }
        }
        if (this.x <= 0) {
            this.b(this.var_short_f + this.var_short_arr_b[1]);
            this.x = (byte)100;
        }
        if (this.y <= 0) {
            this.void_a(this.var_short_h + this.var_short_arr_b[3]);
            this.y = (byte)26;
        }
    }

    private void i(byte by2) {
        if (u.var_int_a == 4) {
            return;
        }
        boolean bl2 = false;
        if (this.var_byte_s != 3 && !this.var_boolean_r) {
            bl2 = ae.var_ae_a.a(this);
            this.var_boolean_r = true;
        }
        if (!bl2 && by2 == 2 && this.var_byte_s == 1) {
            bl2 = ae.var_ae_a.boolean_b();
        }
        if (bl2) {
            this.void_f((byte)1);
            this.w = 0;
            this.var_byte_v = 0;
        }
    }

    public void b(int n2, int n3) {
        if (!this.var_boolean_g) {
            return;
        }
        int n4 = n2 + this.var_short_c + this.var_byte_f;
        int n5 = n3 + this.var_short_d + ((bl)this).g - 1;
        if (this.z == 1) {
            n4 += ax.var_byte_arr_a[this.A] * 3;
            n5 += ax.var_byte_arr_b[this.A] * 3;
            this.z = (byte)(this.z - 1);
        }
        if (this.var_boolean_b) {
            this.var_boolean_b = !this.var_boolean_b;
            bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.w, n4, n5 + 4, 33);
        } else {
            bw.var_javax_microedition_lcdui_Graphics_a.drawImage(as.v, n4, n5 + 6, 33);
        }
        switch (this.var_byte_s) {
            case 2: {
                this.c(n4, n5);
                break;
            }
            case 3: {
                byte by2 = -1;
                by2 = this.var_byte_arr_o[this.var_byte_d];
                if (by2 < 0) {
                    return;
                }
                by2 = (byte)(this.byte_a(by2) + 4);
                if (this.var_boolean_l) {
                    this.d(n2, n3);
                }
                this.a(by2, this.var_byte_t, n4, n5);
                break;
            }
            case 6: {
                this.a(var_byte_arr_m[u.var_byte_a], (byte)1, n4, n5);
                break;
            }
            case 7: {
                this.a(n4, n5);
                break;
            }
            default: {
                this.a(n4, n5, this.var_byte_t);
            }
        }
        this.f(n4, n5);
        this.e(n4, n5);
    }

    public void a(int n2, int n3) {
        bd.a(var_byte_arr_m[u.var_byte_a], (byte)9, (byte)1, n2, n3);
    }

    public void a(byte by2, byte by3, int n2, int n3) {
        bd.a(by2, this.var_byte_v, by3, n2, n3);
    }

    public void a(int n2, int n3, byte by2) {
        this.a(!ah.var_boolean_a || this.var_boolean_a ? (byte)1 : 0, by2, n2, n3);
    }

    public void a(int n2, int n3, int n4) {
        bd.a(!ah.var_boolean_a || this.var_boolean_a ? (byte)1 : 0, (byte)(n4 % 4), (byte)2, n2, n3);
    }

    public void c(int n2, int n3) {
        this.a(!ah.var_boolean_a || this.var_boolean_a ? (byte)3 : 2, this.var_byte_t, n2, n3);
    }

    public void void_a(byte by2, byte by3) {
        if (u.var_ah_a.a(this, by2)) {
            this.u();
            this.var_short_c = (short)(this.var_short_c + ax.var_byte_arr_a[by2] * by3);
            this.var_short_d = (short)(this.var_short_d + ax.var_byte_arr_b[by2] * by3);
            this.void_c();
            this.t();
            u.f();
            u.var_int_d = u.var_int_b;
            u.var_int_e = u.var_int_c;
        }
    }

    public void j() {
        byte by2 = this.var_byte_t;
        if (u.var_ah_a.var_byte_arr_arr_c[((bl)this).i + ax.var_byte_arr_b[by2]][((bl)this).h + ax.var_byte_arr_a[by2]] != -128) {
            return;
        }
        ah ah2 = u.var_ah_a;
        byte by3 = ax.e[by2];
        byte by4 = ax.f[by2];
        byte by5 = ax.c[by2];
        byte by6 = ax.d[by2];
        if (ah2.boolean_a(((bl)this).h + ax.var_byte_arr_a[by4], ((bl)this).i + ax.var_byte_arr_b[by4]) && ah2.boolean_a(((bl)this).h + ax.var_byte_arr_a[by6], ((bl)this).i + ax.var_byte_arr_b[by6])) {
            this.w = this.var_byte_t;
            this.void_f((byte)2);
            this.void_g(by4);
        } else if (ah2.boolean_a(((bl)this).h + ax.var_byte_arr_a[by3], ((bl)this).i + ax.var_byte_arr_b[by3]) && ah2.boolean_a(((bl)this).h + ax.var_byte_arr_a[by5], ((bl)this).i + ax.var_byte_arr_b[by5])) {
            this.w = this.var_byte_t;
            this.void_f((byte)2);
            this.void_g(by3);
        } else {
            return;
        }
        this.var_byte_v = 0;
        this.f(8);
    }

    public boolean boolean_c() {
        return this.var_byte_d < 0 || this.var_byte_arr_o[this.var_byte_d] < var_byte_arr_i[u.var_byte_a] + this.var_int_o;
    }

    public final boolean boolean_c(byte by2) {
        if (!n.d && !ah.var_boolean_a) {
            return false;
        }
        if (this.var_byte_d + 1 >= this.var_byte_c + this.var_int_o) {
            return false;
        }
        if (this.var_byte_e > 0) {
            return false;
        }
        if (this.var_byte_arr_o[this.var_byte_d + 1] == -1) {
            if (by2 > 0) {
                if (this.var_byte_d >= 0 && this.var_byte_arr_o[this.var_byte_d] == (byte)(by2 + var_byte_arr_i[u.var_byte_a] - 1)) {
                    return false;
                }
                this.var_byte_arr_o[this.var_byte_d + 1] = (byte)(by2 + var_byte_arr_i[u.var_byte_a] - 1);
                return true;
            }
            if (this.boolean_c()) {
                this.var_byte_arr_o[this.var_byte_d + 1] = (byte)(this.var_byte_d + 1 - this.var_int_o);
                return true;
            }
            return false;
        }
        return true;
    }

    public final void k() {
        for (int i2 = 0; i2 < this.var_byte_arr_o.length; ++i2) {
            this.var_byte_arr_o[i2] = -1;
        }
        this.var_byte_d = (byte)-1;
        this.var_int_o = 0;
    }

    private final void g(int n2) {
        this.var_byte_e = n2 < 2 && this.var_byte_arr_o[n2] <= 0 ? (byte)2 : (byte)4;
        this.k();
        this.void_f((byte)1);
        this.var_byte_v = 0;
    }

    public final void l() {
        if (this.var_byte_v == 0) {
            if (!this.boolean_a(this.var_byte_arr_o[this.var_byte_d])) {
                this.g((int)this.var_byte_d);
                this.b(new bh(-6, 3, 2));
                return;
            }
            if (!this.boolean_f()) {
                return;
            }
            this.void_g(this.byte_b());
        }
        if (this.var_byte_v == var_byte_arr_n[this.var_byte_arr_o[this.var_byte_d]]) {
            if (this.var_byte_d + 1 == this.var_byte_c + this.var_int_o || this.var_byte_arr_o[this.var_byte_d + 1] == -1) {
                this.g((int)this.var_byte_d);
                return;
            }
            this.var_byte_d = (byte)(this.var_byte_d + 1);
            this.var_byte_v = (byte)-1;
        }
        boolean bl2 = false;
        bl2 = this.boolean_a();
        if (!bl2) {
            ak.a((byte)1);
        }
    }

    private boolean boolean_f() {
        int n2;
        int n3 = this.var_int_j;
        byte by2 = var_byte_arr_i[u.var_byte_a];
        if (this.var_byte_arr_o[this.var_byte_d] > by2) {
            n2 = this.var_byte_arr_o[this.var_byte_d];
            n3 = this.int_a(n2);
        }
        if (this.var_int_b < n3 && (this.var_byte_d != 0 || this.var_byte_arr_o[this.var_byte_d] != 0)) {
            this.b(new bh(-6, 2, 2));
            this.g((int)this.var_byte_d);
            return false;
        }
        if (this.var_byte_arr_o[this.var_byte_d] >= by2) {
            n2 = this.var_byte_arr_o[this.var_byte_d] - by2;
            u.a(n2 + 1, false);
        }
        this.void_a(-n3);
        return true;
    }

    public final void void_a(int n2) {
        this.var_int_b += n2;
        if (this.var_int_b > this.var_int_e) {
            this.var_int_b = this.var_int_e;
        } else if (this.var_int_b < 0) {
            this.var_int_b = 0;
        }
        bd.var_bd_a.var_boolean_e = true;
    }

    public final void b(int n2) {
        this.var_int_a += n2;
        if (this.var_int_a > this.var_int_d) {
            this.var_int_a = this.var_int_d;
        } else if (this.var_int_a < 0) {
            this.var_int_a = 0;
        }
        bd.var_bd_a.var_boolean_d = true;
        if (!n.b && this.var_int_a == 0) {
            this.void_f((byte)6);
            this.var_byte_v = 0;
            return;
        }
    }

    public final void c(int n2) {
        this.var_int_c += n2;
        this.var_cg_a.a(n2);
        bd.var_boolean_b = true;
    }

    public final void m() {
        if (this.var_int_c >= this.var_int_f) {
            this.var_int_c -= this.var_int_f;
            if (this.var_byte_a < 99) {
                this.var_byte_a = (byte)(this.var_byte_a + 1);
                this.n();
                this.var_short_a = (short)(this.var_short_a + 3);
                if (this.var_byte_a % 2 == 1) {
                    this.var_short_b = (short)(this.var_short_b + 1);
                }
                this.void_d();
                this.d(100);
                this.e(100);
                this.b(new al(24));
            }
            if (this.var_int_c < 0) {
                this.var_int_c = 0;
            }
            bd.var_boolean_b = true;
        }
    }

    public final void d(int n2) {
        int n3 = this.var_int_d * n2 / 100;
        this.b(n3);
    }

    public final void e(int n2) {
        int n3 = this.var_int_e * n2 / 100;
        this.void_a(n3);
    }

    public final void n() {
        cf cf2;
        int n2;
        byte by2;
        int n3;
        p[] pArray = this.var_p_arr_a;
        for (n3 = 0; n3 < 5; ++n3) {
            this.var_short_arr_b[n3] = 0;
        }
        for (n3 = 0; n3 < 7; ++n3) {
            if (pArray[n3] == null) continue;
            for (by2 = 0; by2 < 5; ++by2) {
                byte by3 = by2;
                this.var_short_arr_b[by3] = (short)(this.var_short_arr_b[by3] + pArray[n3].i[by2]);
            }
        }
        n3 = 0;
        by2 = 0;
        if (pArray[1] != null) {
            n3 = 1;
            by2 = pArray[1].c;
            for (n2 = 0; n2 < var_byte_arr_k.length; ++n2) {
                if (by2 != 0 && pArray[var_byte_arr_k[n2]] != null && by2 == pArray[b.var_byte_arr_k[n2]].c) continue;
                n3 = 0;
                break;
            }
        }
        if (n3 != 0) {
            n2 = 0;
            while (n2 < 5) {
                int n4 = n2++;
                this.var_short_arr_b[n4] = (short)(this.var_short_arr_b[n4] + 2);
            }
        }
        this.var_short_arr_c[b.var_byte_n] = (cf2 = this.cf_a()) != null ? cf2.d() : (short)0;
        this.var_short_arr_c[b.var_byte_o] = cf2 != null ? cf2.c() : (short)0;
        this.var_int_g = cf2 != null ? this.var_short_arr_c[var_byte_n] + this.var_short_arr_c[var_byte_o] >> 1 : 0;
        this.var_byte_l = cf2 != null ? cf2.n : (byte)0;
        this.var_byte_m = cf2 != null ? cf2.i : (byte)0;
        this.var_int_j = cf2 != null ? this.var_short_arr_c[var_byte_n] / 5 : 0;
        this.var_byte_k = cf2 != null ? cf2.j : (byte)0;
        this.var_int_i = 0;
        this.var_int_i += pArray[1] != null ? this.am_c().int_a() : 0;
        this.var_int_i += pArray[4] != null ? this.am_b().int_a() : 0;
        this.var_int_i += pArray[0] != null ? this.am_d().int_a() : 0;
        this.var_int_i += pArray[6] != null ? this.am_e().int_a() : 0;
        this.var_int_i += pArray[2] != null ? (int)this.q_a().var_short_b : 0;
        this.var_int_n = 13;
        this.var_byte_p = 0;
        this.var_int_k = 10 - this.var_byte_a - (this.var_short_g + this.var_short_arr_b[2]) / 10 - (this.var_short_i + this.var_short_arr_b[4]) / 10;
        this.var_int_m = 10 + this.var_byte_a + (this.var_short_g + this.var_short_arr_b[2]) / 5;
        this.void_b();
        this.var_int_e = (this.var_short_h + this.var_short_arr_b[3] + this.var_byte_a) * 6;
        q q2 = this.q_a();
        if (q2 != null) {
            this.var_int_h += q2.var_short_a > 0 ? q2.var_short_a : (short)0;
            this.var_int_e += q2.var_int_b > 0 ? q2.var_int_b : 0;
            this.var_int_d += q2.var_int_a > 0 ? q2.var_int_a : 0;
        }
        this.var_int_g += this.var_int_h;
        this.var_int_f = 0;
        this.var_int_f = this.var_byte_a * this.var_byte_a * this.var_byte_a - this.var_byte_a * this.var_byte_a + 80 * this.var_byte_a;
        if (this.var_boolean_v) {
            this.var_int_e = this.var_int_e * 7 / 10;
            this.var_int_d = this.var_int_d * 7 / 10;
            this.var_int_i = this.var_int_i * 7 / 10;
            this.var_int_g = this.var_int_g * 7 / 10;
        }
        if (this.var_boolean_j) {
            this.var_int_g <<= 1;
            this.var_int_i = this.var_int_i * 3 / 5;
        }
        if (this.var_boolean_q) {
            this.var_int_i += this.var_cg_a.var_short_b * 2 / 3 + 5;
        }
        if (this.var_int_a > this.var_int_d) {
            this.var_int_a = this.var_int_d;
        }
        if (this.var_int_b > this.var_int_e) {
            this.var_int_b = this.var_int_e;
        }
        if (this.var_int_j < 1) {
            this.var_int_j = 1;
        }
        if (this.var_int_l > 90) {
            this.var_int_l = 90;
        } else if (this.var_int_l < 8) {
            this.var_int_l = 8;
        }
        if (this.var_int_j < 1) {
            this.var_int_j = 1;
        }
        bd.var_boolean_a = true;
    }

    public boolean a(ag ag2) {
        int n2 = this.var_int_m - ag2.m - ag2.var_ay_a.var_short_e / 10;
        if (n2 > 90) {
            n2 = 90;
        } else if (n2 < 8) {
            n2 = 8;
        }
        return Math.abs(bb.var_java_util_Random_a.nextInt() % 100) < n2;
    }

    public final cp cp_a(int n2) {
        return this.var_p_arr_a[n2];
    }

    public final cf cf_a() {
        return (cf)this.var_p_arr_a[3];
    }

    public final am am_a() {
        return (am)this.var_p_arr_a[5];
    }

    public final am am_b() {
        return (am)this.var_p_arr_a[4];
    }

    public final am am_c() {
        return (am)this.var_p_arr_a[1];
    }

    public final am am_d() {
        return (am)this.var_p_arr_a[0];
    }

    public final am am_e() {
        return (am)this.var_p_arr_a[6];
    }

    public final q q_a() {
        return (q)this.var_p_arr_a[2];
    }

    public void o() {
        ci ci2 = u.var_ci_a;
        this.var_p_arr_a = new p[7];
        cp cp2 = null;
        int n2 = 0;
        for (int n3 = 0; n3 < ci2.var_java_util_Vector_a.size(); n3 = (int)((byte)(n3 + 1))) {
            cp2 = (cp)ci2.var_java_util_Vector_a.elementAt(n3);
            if (!(cp2 instanceof p) || ((p)cp2).f <= -1) continue;
            this.var_p_arr_a[((p)cp2).f] = (p)cp2;
            if ((n2 = (int)((byte)(n2 + 1))) == 7) break;
        }
    }

    public void a(byte by2, p p2) {
        if (p2 != null) {
            this.var_p_arr_a[by2] = p2;
            p2.f = by2;
        }
    }

    public final boolean boolean_d(byte by2) {
        p p2 = (p)u.var_ci_a.cp_a(by2);
        if (p2 != null) {
            this.var_p_arr_a[by2] = null;
            p2.f = (byte)-1;
            return true;
        }
        return false;
    }

    public short short_a(cf cf2) {
        return (short)f.a(cf2.c(), (int)cf2.d());
    }

    public final int int_a() {
        return this.int_a(this.cf_a());
    }

    public final int int_a(cf cf2) {
        int n2;
        if (cf2 == null) {
            return 0;
        }
        int n3 = this.var_int_h + this.short_a(cf2);
        if (this.var_boolean_j) {
            n3 <<= 1;
        }
        if (this.boolean_c() && (n2 = this.var_byte_d - this.var_int_o) >= 0) {
            return n3 * (9 + this.var_byte_arr_p[n2]) / 10;
        }
        return n3;
    }

    public byte byte_b() {
        if (this.ag_a() == null) {
            if (this.ag_a(ax.f[this.var_byte_t]) != null) {
                return ax.f[this.var_byte_t];
            }
            if (this.ag_a(ax.e[this.var_byte_t]) != null) {
                return ax.e[this.var_byte_t];
            }
            if (this.ag_a(ax.g[this.var_byte_t]) != null) {
                return ax.g[this.var_byte_t];
            }
        }
        return this.var_byte_t;
    }

    public ag ag_a() {
        bl bl2 = this.a(this.var_byte_t, (bl)null);
        if (bl2 != null && bl2 instanceof ag) {
            return (ag)bl2;
        }
        return null;
    }

    public ag ag_a(byte by2) {
        bl bl2 = this.a(by2, (bl)null);
        if (bl2 != null && bl2 instanceof ag) {
            return (ag)bl2;
        }
        return null;
    }

    public boolean a(ag ag2, byte by2, int n2, byte by3, byte by4) {
        if (ag2 != null) {
            byte by5 = by2 < var_byte_arr_i[u.var_byte_a] ? (byte)21 : 22;
            return ag2.a(this, by2, n2, false, this.var_byte_t, by3, by4, by5);
        }
        return false;
    }

    public boolean a(byte by2, byte by3, int n2, byte by4, byte by5) {
        ag ag2 = this.ag_a(by3);
        return this.a(ag2, by2, n2, by4, by5);
    }

    public boolean boolean_e(byte by2) {
        int n2 = this.int_a();
        return this.a(by2, this.var_byte_t, n2, this.var_byte_l, this.var_byte_m);
    }

    public boolean boolean_b(byte by2, byte by3, int n2) {
        return this.a(by2, (byte)(by3 + 4), n2, this.var_byte_l, this.var_byte_m);
    }

    public boolean c(byte by2, byte by3, int n2) {
        ag ag2;
        ag ag3 = this.ag_a((byte)(by3 + 8));
        if (ag3 != null && (ag2 = this.ag_a(by3)) != ag3) {
            return this.a(ag3, by2, n2, this.var_byte_l, this.var_byte_m);
        }
        return false;
    }

    public boolean d(byte by2, byte by3, int n2) {
        ag ag2;
        ag ag3 = this.ag_a((byte)(by3 + 12));
        if (ag3 != null && (ag2 = this.ag_a((byte)(by3 + 8))) != ag3) {
            return this.a(ag3, by2, n2, this.var_byte_l, this.var_byte_m);
        }
        return false;
    }

    public boolean b(byte by2, byte by3) {
        boolean bl2 = false;
        boolean bl3 = false;
        byte by4 = 0;
        byte by5 = 0;
        switch (by3) {
            case 0: 
            case 3: {
                by4 = this.var_byte_t;
                by5 = ax.f[this.var_byte_t];
                break;
            }
            case 1: 
            case 4: {
                by4 = ax.g[this.var_byte_t];
                by5 = ax.e[this.var_byte_t];
                break;
            }
            default: {
                return false;
            }
        }
        int n2 = this.int_a();
        bl2 = this.e(by2, by4, n2);
        bl3 = this.e(by2, by5, n2);
        return bl2 | bl3;
    }

    public boolean e(byte by2, byte by3, int n2) {
        boolean bl2 = false;
        if (this.a(by2, by3, n2, this.var_byte_l, this.var_byte_m)) {
            bl2 = true;
        }
        if (this.boolean_b(by2, by3, n2 * 2 / 3)) {
            bl2 = true;
        }
        if (this.c(by2, by3, n2 >> 1)) {
            bl2 = true;
        }
        return bl2;
    }

    public void void_b(byte by2) {
        ah ah2 = u.var_ah_a;
        int n2 = bd.var_int_a / 16;
        int n3 = bd.var_int_a / 16;
        int n4 = ((bl)this).h - n2 / 2;
        int n5 = ((bl)this).i - n3 / 2;
        if (n4 < 0) {
            n4 = 0;
        } else if (n4 > ah.var_byte_d - n2) {
            n4 = ah.var_byte_d - n2;
        }
        if (n5 < 0) {
            n5 = 0;
        } else if (n5 > ah.var_byte_e - n3) {
            n5 = ah.var_byte_e - n3;
        }
        int n6 = this.int_a();
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                bl bl2 = ah2.var_bl_arr_arr_a[n5 + i3][n4 + i2];
                if (bl2 == null || !(bl2 instanceof ag)) continue;
                this.a((ag)bl2, by2, n6, this.var_byte_l, this.var_byte_m);
            }
        }
    }

    public void a(ag ag2, byte by2, int n2) {
        if (ag2.var_byte_s == 6 || ag2.var_byte_s == 7) {
            return;
        }
        if (by2 == 25) {
            ag2.a(n2);
        } else if (by2 == 26) {
            ag2.b(n2);
        }
    }

    public final void a(ag ag2, short s2, byte by2) {
        int n2;
        int n3;
        if (this.var_byte_s == 7 || this.var_byte_s == 6) {
            return;
        }
        if (this.var_boolean_k) {
            ag2.a(this, (byte)8, 0, false, this.var_byte_t, (byte)0, (byte)0, (byte)22);
        }
        if (this.var_boolean_n) {
            this.b(new bh(-3));
            return;
        }
        bd.var_bd_a.a(ag2, false);
        if (this.a(ag2)) {
            this.b(new bh(-1));
            return;
        }
        int n4 = s2 + f.a(0, s2 / 10) - f.a(0, s2 / 10) - this.var_int_i;
        if (u.var_byte_a == 1 && this.am_a() != null && f.a(1, 100) > 100 - this.var_int_q) {
            n4 -= this.am_a().int_a();
            this.b(new bh(-3));
        }
        if (n4 < 0) {
            n4 = 0;
        }
        if ((n3 = 20 + (n2 = ag2.m - this.var_byte_a)) < 8) {
            n3 = 8;
        } else if (n3 > 50) {
            n3 = 50;
        }
        if (f.a(0, 99) < n3) {
            n4 += n4 * 3 / 2;
        }
        if (this.var_boolean_p && n4 > 3) {
            n4 = 3;
        }
        if (this.var_boolean_i) {
            n4 >>= 1;
        }
        if (n4 < 3) {
            n4 = 3;
        }
        this.b(-n4);
        this.b(new bh(-4, -1, n4));
        this.b(new al(23));
        int n5 = 70 + n2 - this.var_int_n;
        if (ag2.var_ay_a.var_boolean_b && f.a(0, 99) < 30 && !this.var_boolean_t && f.a(0, 99) < n5) {
            this.var_boolean_t = true;
            this.void_a((byte)26, (byte)-1, 60);
        }
        if (ag2.var_ay_a.var_boolean_c && f.a(0, 99) < 30 && !this.var_boolean_v && f.a(0, 99) < n5) {
            this.var_boolean_v = true;
            this.void_a((byte)27, (byte)-1, 160);
            this.n();
        }
        this.z = 1;
        this.A = by2;
    }

    public cg cg_a() {
        return this.var_cg_a;
    }

    public final void void_c(byte by2) {
        if (!ah.var_boolean_a) {
            return;
        }
        if (this.var_cg_a == null || this.var_cg_a.var_byte_a != 0) {
            return;
        }
        this.var_cg_a.a(by2, this.var_byte_t, ((bl)this).h, ((bl)this).i);
    }

    public final void p() {
        u.var_ah_a.d(this.var_cg_a);
    }

    public final void void_d(byte by2) {
        if (by2 < 0) {
            return;
        }
        cp cp2 = u.var_ci_a.cp_a((int)by2);
        byte by3 = cp2.g;
        switch (by3) {
            case 24: {
                this.b(180);
                break;
            }
            case 25: {
                this.b(230);
                this.d(20);
                break;
            }
            case 26: {
                this.e(40);
                break;
            }
            case 27: {
                if (cp2.h == 0) {
                    this.boolean_b((byte)26);
                    break;
                }
                if (cp2.h != 1) break;
                this.boolean_b((byte)27);
                break;
            }
            default: {
                return;
            }
        }
        u.var_ci_a.a(by2, 1);
    }

    public void void_e(byte by2) {
        if (this.var_byte_arr_p[by2] < 0) {
            this.var_byte_arr_p[by2] = 0;
        }
        this.q();
    }

    public void q() {
        byte by2 = 0;
        for (int i2 = 0; i2 < var_byte_arr_i[u.var_byte_a] && this.var_byte_arr_p[i2] > 0; ++i2) {
            by2 = (byte)(by2 + 1);
        }
        this.var_byte_c = by2;
    }

    public boolean boolean_f(byte by2) {
        if (this.var_byte_arr_p[by2] < this.byte_a((int)by2)) {
            byte by3 = by2;
            this.var_byte_arr_p[by3] = (byte)(this.var_byte_arr_p[by3] + 1);
            this.q();
            return true;
        }
        return false;
    }

    public byte byte_b(byte by2) {
        if (by2 < this.var_byte_arr_p.length) {
            return this.var_byte_arr_p[by2];
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final byte[] byte_arr_a() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            int n2;
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeByte(u.var_byte_c);
            ((DataOutputStream)filterOutputStream).writeByte(u.var_byte_a);
            ((DataOutputStream)filterOutputStream).writeByte(this.var_byte_a);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_e);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_f);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_g);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_h);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_i);
            int n3 = 0;
            for (n2 = 0; n2 < 7; ++n2) {
                if (this.var_p_arr_a[n2] == null) continue;
                ++n3;
            }
            for (n2 = 0; n2 < 7; ++n2) {
                if (this.var_p_arr_a[n2] == null) {
                    ((DataOutputStream)filterOutputStream).writeByte(0);
                    continue;
                }
                byte[] byArray = this.var_p_arr_a[n2].byte_arr_a();
                ((DataOutputStream)filterOutputStream).writeByte(byArray.length);
                ((OutputStream)filterOutputStream).write(byArray);
            }
            ((DataOutputStream)filterOutputStream).writeShort(this.var_cg_a.var_short_a);
            ((DataOutputStream)filterOutputStream).writeByte(this.var_cg_a.var_short_b);
            ((OutputStream)filterOutputStream).write(this.var_byte_arr_p);
            byte[] byArray = new byte[13];
            byte by2 = 0;
            for (int i2 = 0; i2 < this.var_cg_a.j.length; ++i2) {
                by2 = this.var_cg_a.j[i2];
                if (by2 < 0) continue;
                byArray[by2] = this.var_cg_a.var_byte_arr_k[i2];
            }
            ((OutputStream)filterOutputStream).write(byArray);
            byte[] byArray2 = (byte[])u.var_java_lang_Object_arr_a[u.var_byte_c];
            ((DataOutputStream)filterOutputStream).writeByte(byArray2[3]);
            byte[] byArray3 = byteArrayOutputStream.toByteArray();
            return byArray3;
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    ((OutputStream)byteArrayOutputStream).close();
                }
            }
            catch (IOException iOException) {}
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final byte[] byte_arr_b() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)filterOutputStream).writeByte(this.var_byte_a);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_a);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_b);
            ((DataOutputStream)filterOutputStream).writeInt(this.var_int_a);
            ((DataOutputStream)filterOutputStream).writeInt(this.var_int_b);
            ((DataOutputStream)filterOutputStream).writeInt(this.var_int_c);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_e);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_f);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_g);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_h);
            ((DataOutputStream)filterOutputStream).writeShort(this.var_short_i);
            ((DataOutputStream)filterOutputStream).writeByte(this.var_byte_c);
            ((DataOutputStream)filterOutputStream).writeByte(this.var_byte_r);
            ((OutputStream)filterOutputStream).write(this.var_byte_arr_p);
            byte[] byArray = byteArrayOutputStream.toByteArray();
            return byArray;
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    ((OutputStream)byteArrayOutputStream).close();
                }
            }
            catch (IOException iOException) {}
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void a(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = null;
        FilterInputStream filterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(byArray);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            this.var_byte_a = ((DataInputStream)filterInputStream).readByte();
            this.var_short_a = ((DataInputStream)filterInputStream).readShort();
            this.var_short_b = ((DataInputStream)filterInputStream).readShort();
            this.var_int_a = ((DataInputStream)filterInputStream).readInt();
            this.var_int_b = ((DataInputStream)filterInputStream).readInt();
            this.var_int_c = ((DataInputStream)filterInputStream).readInt();
            this.var_short_e = ((DataInputStream)filterInputStream).readShort();
            this.var_short_f = ((DataInputStream)filterInputStream).readShort();
            this.var_short_g = ((DataInputStream)filterInputStream).readShort();
            this.var_short_h = ((DataInputStream)filterInputStream).readShort();
            this.var_short_i = ((DataInputStream)filterInputStream).readShort();
            this.var_byte_c = ((DataInputStream)filterInputStream).readByte();
            this.var_byte_r = ((DataInputStream)filterInputStream).readByte();
            ((DataInputStream)filterInputStream).read(this.var_byte_arr_p, 0, this.var_byte_arr_p.length);
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    ((InputStream)byteArrayInputStream).close();
                }
            }
            catch (IOException iOException) {}
        }
        this.n();
    }

    public void d(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        if (this.var_byte_v == 9) {
            return;
        }
        int n4 = n2 + this.var_short_c + this.var_byte_f;
        int n5 = n3 + this.var_short_d + ((bl)this).g;
        Image[] imageArray = null;
        imageArray = (Image[])as.var_java_lang_Object_arr_a[4];
        for (int i2 = 0; i2 < n5 + 3; ++i2) {
            graphics.setClip(n4 - 20, i2, 40, 1);
            graphics.drawImage(imageArray[31 + (this.var_byte_v + 1) % 2], n4, i2, 17);
        }
        graphics.setClip(0, 0, bd.var_int_a, bd.var_int_a);
    }

    public final void r() {
        if (u.var_ci_a.var_byte_a < 0 || this.var_byte_s == 7 || this.var_byte_s == 6) {
            return;
        }
        cp cp2 = u.var_ci_a.cp_a();
        if (cp2 != null) {
            this.void_d(u.var_ci_a.var_byte_a);
            if (cp2.c < 1) {
                u.var_ci_a.void_b();
            }
        }
        bd.var_boolean_c = true;
    }

    static {
        var_byte_arr_i = new byte[]{4, 3, 5};
        var_byte_arr_j = new byte[]{7, 7, 6};
        var_byte_arr_k = new byte[]{3, 4};
        var_byte_arr_l = new byte[]{1, 99, 18, 30, 35};
        var_byte_arr_arr_b = new byte[][]{{1, 8, 99, 18, 20, 25, 99, 5, 99, 40, 28}, {1, 8, 12, 99, 20, 99, 33, 1, 5, 28, 40, 99}, {1, 8, 12, 99, 25, 99, 5, 99, 40, 28}};
        var_byte_arr_m = new byte[]{17, 18, 16};
        var_byte_n = 0;
        var_byte_o = 1;
    }
}

