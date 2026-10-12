/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public class cg
extends bl
implements ax {
    public short var_short_a;
    public byte[] i;
    public byte[] j;
    public byte[] var_byte_arr_k;
    public byte[] var_byte_arr_l;
    public short[] var_short_arr_a;
    public short[] var_short_arr_b;
    public byte[] m = new byte[4];
    public short var_short_b;
    public int var_int_a;
    public int var_int_b;
    public byte var_byte_a;
    public boolean var_boolean_a = false;
    public byte var_byte_b;
    public byte c;
    public byte d;
    public byte e;
    public byte var_byte_k;
    public byte var_byte_l;
    public boolean var_boolean_b = false;

    public cg(boolean bl2) {
        super((short)0, (short)0, (byte)8, (byte)8);
        for (int i2 = 0; i2 < this.m.length; ++i2) {
            this.m[i2] = 0;
        }
        this.j = new byte[4];
        this.var_byte_arr_k = new byte[4];
        this.var_byte_arr_l = new byte[4];
        this.var_short_arr_b = new short[4];
        this.var_short_b = 1;
        this.var_int_a = 1;
        this.e();
        this.void_a();
        this.b(bl2);
        this.l();
    }

    private void e() {
        this.var_boolean_b = false;
        this.d = 0;
        this.c = 0;
        this.var_byte_k = 0;
        this.e = 0;
    }

    public final void void_a() {
        this.var_byte_a = 0;
        this.var_byte_b = (byte)-1;
    }

    public final void a(byte by2, byte by3, byte by4, byte by5) {
        if (this.var_byte_arr_k[by2] < 1) {
            return;
        }
        b b2 = u.var_b_a;
        if (b2.var_int_b < this.var_short_arr_b[by2]) {
            b2.b(new bh(-6, 2, 2));
            return;
        }
        b2.var_int_b -= this.var_short_arr_b[by2];
        u.a((int)by2, true);
        bd.var_bd_a.var_boolean_e = true;
        this.h = by4;
        ((bl)this).i = by5;
        this.var_boolean_c = false;
        this.var_boolean_d = false;
        this.var_byte_l = by3;
        this.a((short)(this.h * 16), (short)(((bl)this).i * 16));
        this.e();
        this.var_byte_a = 1;
        this.var_byte_b = by2;
        this.var_byte_k = (byte)4;
    }

    public void b(int n2, int n3) {
        if (this.var_byte_a == 0) {
            return;
        }
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        int n4 = n2 + this.var_short_c + this.var_byte_f;
        int n5 = n3 + this.var_short_d + this.g;
        graphics.drawImage(this.var_boolean_b ? as.v : as.w, n4, n5 + 4, 33);
        if (this.var_boolean_b) {
            if (this.c < 0) {
                this.c = 0;
            }
            bd.a(this.c, n4, n5);
        }
        switch (this.var_byte_a) {
            case 1: {
                if (!bd.a(true, this.d, n4, n5)) {
                    this.e((byte)3);
                }
                if (this.d != 3) break;
                this.var_boolean_b = true;
                break;
            }
            case 2: {
                if (this.j[this.var_byte_b] == 7) {
                    if (this.d < 2) {
                        ah.a(this.d);
                    } else if (this.d == 2) {
                        ah.g();
                    }
                }
                if (this.d == 3) {
                    this.var_boolean_b = false;
                }
                if (bd.a(false, this.d, n4, n5)) break;
                this.var_byte_a = 0;
                this.e();
            }
        }
    }

    public final void b() {
        if (u.var_int_a != 3) {
            return;
        }
        if (this.var_byte_a == 0) {
            return;
        }
        if (this.var_boolean_b) {
            this.c = (byte)(this.c + 1);
            if (this.c >= as.var_byte_arr_k[0]) {
                this.c = (byte)-1;
            }
            if (this.var_byte_a != 2) {
                this.e = (byte)(this.e + 1);
                if (this.e > this.var_byte_k) {
                    this.e((byte)2);
                    this.f();
                }
            }
        }
        this.d = (byte)(this.d + 1);
    }

    private void f() {
        b b2 = u.var_b_a;
        switch (this.j[this.var_byte_b]) {
            case 0: {
                b2.b(150 + b2.var_int_d / (7 - this.var_byte_arr_k[this.var_byte_b]));
                ak.a((byte)2);
                break;
            }
            case 1: {
                if (b2.var_boolean_q) {
                    return;
                }
                b2.var_boolean_q = true;
                b2.n();
                b2.b(new i(1, this.var_byte_b, 1, 1));
                this.c((byte)1);
                ak.a((byte)2);
                return;
            }
            case 2: {
                b2.b(-(b2.var_int_d / 5));
                b2.void_a(b2.var_int_e * 3 / 5);
                ak.a((byte)2);
                break;
            }
            case 3: {
                this.g();
                return;
            }
            case 4: {
                ak.a((byte)2);
                break;
            }
            case 5: {
                b2.var_boolean_p = true;
                this.c((byte)5);
                ak.a((byte)2);
                return;
            }
            case 6: {
                b2.i();
                ak.a((byte)2);
                break;
            }
            case 7: {
                this.d((byte)0);
                return;
            }
            case 8: {
                this.d((byte)1);
                return;
            }
            case 9: {
                this.d((byte)2);
                return;
            }
            case 10: 
            case 11: 
            case 12: {
                int n2 = 3 + (this.j[this.var_byte_b] - 10) * 2;
                int n3 = (this.var_short_b * 5 / 2 + 20 + b2.var_short_i + b2.var_short_arr_b[4]) * (this.var_byte_arr_k[this.var_byte_b] + 2) / 3;
                this.a((byte)n2, n3, this.var_byte_l, 1);
                return;
            }
        }
        b2.b(new i(this.j[this.var_byte_b], this.var_byte_b, this.byte_b(this.var_byte_b)));
    }

    private void a(byte by2, byte by3, byte by4, int n2) {
        bl bl2 = this.bl_a(by3, by4, (byte)n2);
        if (bl2 != null && bl2 instanceof ag) {
            ((ag)bl2).void_b(by2, this.var_byte_b, this.byte_b(this.var_byte_b));
        }
    }

    private void c(byte by2) {
        u.var_b_a.void_b(by2, this.var_byte_b, this.byte_b(this.var_byte_b));
    }

    private void a(byte by2, int n2, byte by3, int n3) {
        int n4 = this.h + ax.var_byte_arr_a[by3];
        int n5 = ((bl)this).i + ax.var_byte_arr_b[by3];
        if (n4 < 0 || n5 < 0) {
            return;
        }
        u.var_ah_a.d(new ar(by2, this.var_byte_b, n2, (byte)n4, (byte)n5, this.var_byte_l, n3));
    }

    private void g() {
        for (byte by2 = 1; by2 <= 8; by2 = (byte)(by2 + 1)) {
            this.a((byte)3, (byte)0, by2, 1);
        }
    }

    private void d(byte by2) {
        byte by3;
        b b2 = u.var_b_a;
        int n2 = (this.var_short_b + 30 + b2.var_short_i + b2.var_short_arr_b[4]) * (this.var_byte_arr_k[this.var_byte_b] + 3) / 3;
        if (this.var_byte_arr_k[this.var_byte_b] >= 1) {
            for (by3 = 1; by3 <= 4; by3 = (byte)(by3 + 1)) {
                this.a(by2, n2, by3, -1);
            }
        }
        if (this.var_byte_arr_k[this.var_byte_b] >= 2) {
            for (by3 = 5; by3 <= 8; by3 = (byte)(by3 + 1)) {
                this.a(by2, n2, by3, -1);
            }
        }
        if (this.var_byte_arr_k[this.var_byte_b] >= 3) {
            for (by3 = 9; by3 <= 12; by3 = (byte)(by3 + 1)) {
                this.a(by2, n2, by3, -1);
            }
        }
    }

    private void e(byte by2) {
        this.var_byte_a = by2;
        if (this.var_byte_a == 3) {
            this.c = (byte)-1;
        } else {
            this.d = (byte)-1;
        }
    }

    public final byte byte_a(byte by2) {
        return (byte)(by2 < 10 ? 3 : 5);
    }

    public final int int_a() {
        if (this.var_short_a == 0) {
            return -1;
        }
        if (this.m[1] == 0) {
            return 0;
        }
        if (this.m[3] > 0) {
            return 2;
        }
        return 1;
    }

    public final void a(byte by2, int n2) {
        this.m[n2] = by2;
    }

    public final void b(boolean bl2) {
        this.var_short_a = this.short_a();
        this.a((int)this.var_short_a, bl2);
        if (bl2) {
            this.j();
            this.h();
            this.i();
        }
        this.l();
    }

    private short short_a() {
        int n2 = this.m[0];
        byte by2 = 0;
        for (int i2 = 1; i2 < 4; ++i2) {
            by2 = this.m[i2];
            n2 += by2 << i2 * 2;
        }
        return (short)n2;
    }

    public final void d() {
        int n2 = 0;
        for (int i2 = 0; i2 < this.var_byte_arr_k.length; ++i2) {
            if (this.var_byte_arr_k[i2] > 0) {
                n2 += this.var_byte_arr_k[i2];
            }
            this.var_byte_arr_k[i2] = 0;
        }
        u.var_b_a.var_short_b = (short)(u.var_b_a.var_short_b + n2);
    }

    public final void void_a(byte by2) {
        this.var_short_arr_a[by2] = (short)this.int_a(by2);
    }

    public final void void_b(byte by2) {
        this.var_short_arr_b[by2] = (short)this.int_b(by2);
    }

    private void h() {
        this.var_short_arr_a = new short[4];
        for (byte by2 = 0; by2 < 4; by2 = (byte)(by2 + 1)) {
            this.var_short_arr_a[by2] = this.j[by2] < 0 ? -1 : (short)this.int_a(by2);
        }
    }

    private void i() {
        for (byte by2 = 0; by2 < 4; by2 = (byte)(by2 + 1)) {
            this.var_short_arr_b[by2] = (short)this.int_b(by2);
        }
    }

    private int int_a(byte by2) {
        byte by3 = this.var_byte_arr_k[by2];
        byte by4 = this.j[by2];
        switch (by4) {
            case 0: {
                return 160 - by3 * 5;
            }
            case 1: {
                return 245;
            }
            case 2: {
                return 140 - by3 * 20;
            }
            case 3: {
                return 80;
            }
            case 4: {
                return 260;
            }
            case 5: {
                return 230;
            }
            case 6: {
                return 60;
            }
            case 7: 
            case 8: 
            case 9: {
                return (14 - by3) * 10;
            }
            case 10: 
            case 11: 
            case 12: {
                return (21 - by3) * 10;
            }
        }
        return 0;
    }

    private int int_b(byte by2) {
        byte by3 = this.var_byte_arr_k[by2];
        byte by4 = this.j[by2];
        switch (by4) {
            case 0: {
                return 80 - by3 * 10;
            }
            case 1: {
                return 40;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 70;
            }
            case 4: {
                return 160 - by3 * 15;
            }
            case 5: {
                return (14 - by3) * 10;
            }
            case 6: {
                return (7 - by3) * 10;
            }
            case 7: 
            case 8: 
            case 9: {
                return (14 - by3) * 10;
            }
            case 10: 
            case 11: 
            case 12: {
                return 180 - by3 * 6;
            }
        }
        return 0;
    }

    private byte byte_b(byte by2) {
        byte by3 = this.var_byte_arr_k[by2];
        byte by4 = this.j[by2];
        byte by5 = this.var_byte_arr_l[by2];
        int n2 = 0;
        switch (by4) {
            case 1: 
            case 4: {
                n2 = 10 * by3;
                break;
            }
            case 5: {
                n2 = 15 * by3 / 9;
            }
        }
        return (byte)(by5 + n2);
    }

    private void a(int n2, boolean bl2) {
        int n3;
        byte[] byArray = as.a("/b/b.bdf");
        int n4 = 0;
        int n5 = 13;
        for (n3 = 0; n3 < 35; ++n3) {
            if (n2 != f.short_b(byArray, n5 + n3 * 2)) continue;
            n4 = n3;
            break;
        }
        n5 += 70;
        n5 = f.short_b(byArray, n5 + n4 * 2);
        n3 = byArray[n5++];
        this.i = new byte[n3];
        System.arraycopy(byArray, n5, this.i, 0, n3);
        n5 += n3;
        if (bl2) {
            as.var_as_a.void_a(byArray, n5);
        }
        n5 += 7;
        for (int i2 = 0; i2 < 4; ++i2) {
            this.j[i2] = byArray[n5++];
            if (!bl2 || this.j[i2] < 0) continue;
            this.var_byte_arr_l[i2] = byArray[this.j[i2]];
            as.var_as_a.a("/b/bk.s", this.j[i2]);
        }
    }

    private void j() {
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < 4; ++n2) {
            if (this.j[n2] <= -1) continue;
            ++n3;
        }
        as.var_byte_arr_arr_c = new byte[n3][];
        for (n2 = 0; n2 < n3; ++n2) {
            if (this.j[n2] < 0) continue;
            as.var_byte_arr_arr_c[n2] = as.var_as_a.a("/b/bk.s", this.j[n2]);
        }
    }

    public final byte[] byte_arr_a() {
        int n2 = 15;
        byte[] byArray = new byte[n2];
        int n3 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            byArray[n3++] = this.m[i2];
            byArray[n3++] = this.var_byte_arr_k[i2];
        }
        f.a(this.var_int_a, byArray, n3);
        f.a(this.var_short_b, byArray, n3 += 4);
        n3 += 2;
        byArray[n3++] = (byte)(this.var_boolean_a ? 1 : 0);
        return byArray;
    }

    public final void a(byte[] byArray) {
        int n2 = 0;
        this.m = new byte[4];
        this.var_byte_arr_k = new byte[4];
        for (int i2 = 0; i2 < 4; ++i2) {
            this.m[i2] = byArray[n2++];
            this.var_byte_arr_k[i2] = byArray[n2++];
        }
        this.var_int_a = f.int_a(byArray, n2);
        this.var_short_b = f.short_b(byArray, n2 += 4);
        n2 += 2;
        this.var_boolean_a = byArray[n2++] == 1;
        this.b(false);
    }

    public final void a(int n2) {
        this.var_int_a += n2;
        while (this.var_int_a >= this.var_int_b) {
            this.var_int_a -= this.var_int_b;
            this.k();
        }
        if (this.var_int_a < 0) {
            this.var_int_a = 0;
        }
    }

    private void k() {
        if (this.var_short_b < 99) {
            this.var_short_b = (short)(this.var_short_b + 1);
            this.l();
        }
    }

    private void l() {
        this.var_int_b = this.var_short_b * this.var_short_b * (this.var_short_b - 1) + 80 * this.var_short_b;
    }
}

