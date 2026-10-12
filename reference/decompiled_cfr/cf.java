/*
 * Decompiled with CFR 0.152.
 */
public class cf
extends am {
    public byte i;
    public byte j;
    private short c;

    public cf(byte by2, byte by3) {
        super(by2, by3);
    }

    public int a(byte[] byArray, int n2, boolean bl2, boolean bl3) {
        n2 = super.a(byArray, n2, bl2, bl3);
        if (bl2) {
            this.c = (short)f.int_b(byArray, n2);
            n2 += 4;
            this.j = byArray[n2++];
            if (bl3) {
                this.i = byArray[n2++] == 1 ? (byte)f.a(1, 6) : (byte)0;
            }
            this.e = this.byte_a();
        } else {
            n2 += 6;
        }
        return n2;
    }

    public int a(byte[] byArray, int n2) throws Exception {
        n2 = super.a(byArray, n2);
        this.c = f.short_b(byArray, n2);
        n2 += 2;
        this.j = byArray[n2++];
        this.i = byArray[n2++];
        return n2;
    }

    public byte[] byte_arr_a() {
        byte[] byArray = super.byte_arr_a();
        int n2 = 4;
        int n3 = 0;
        byte[] byArray2 = new byte[n2];
        f.a(this.c, byArray2, n3);
        n3 += 2;
        byArray2[n3++] = this.j;
        byArray2[n3++] = this.i;
        return this.a(byArray, byArray2);
    }

    public final short short_a() {
        return (short)(this.c + (this.d * 3 >> 1));
    }

    public final short b() {
        return (short)(this.b + (this.d * 3 >> 1));
    }

    public final short c() {
        int n2 = this.short_a();
        if (u.var_b_a.var_byte_b >= this.k) {
            return (short)n2;
        }
        n2 *= 10 - this.k + u.var_b_a.var_byte_b;
        return (short)(n2 /= 10);
    }

    public final short d() {
        int n2 = this.b();
        if (u.var_b_a.var_byte_b >= this.k) {
            return (short)n2;
        }
        n2 *= 10 - this.k + u.var_b_a.var_byte_b;
        return (short)(n2 /= 10);
    }

    public byte byte_a() {
        byte by2 = super.byte_a();
        int n2 = (by2 + (this.b - this.c << 1) + this.c + (this.i << 1)) % 100;
        return (byte)n2;
    }
}

