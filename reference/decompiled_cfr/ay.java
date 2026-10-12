/*
 * Decompiled with CFR 0.152.
 */
public class ay {
    public static ay[] var_ay_arr_a;
    public byte var_byte_a;
    public byte var_byte_b;
    public byte[] var_byte_arr_a;
    public byte var_byte_c;
    public byte var_byte_d;
    public byte var_byte_e;
    public byte var_byte_f;
    public byte var_byte_g;
    public byte h;
    public short var_short_a;
    public short var_short_b;
    public short var_short_c;
    public short var_short_d;
    public short var_short_e;
    public byte i;
    public byte j;
    public byte k;
    public short var_short_f;
    public boolean var_boolean_a;
    public boolean var_boolean_b;
    public boolean var_boolean_c;
    public byte[] var_byte_arr_b;
    public short var_short_g;
    public byte l;

    public static final void a(byte[] byArray, byte by2, byte by3) {
        int n2 = 4;
        ay ay2 = new ay();
        ay2.var_byte_b = by3;
        ay2.var_byte_c = by2;
        int n3 = byArray[n2++];
        ay2.var_byte_arr_a = new byte[n3];
        System.arraycopy(byArray, n2, ay2.var_byte_arr_a, 0, n3);
        n2 += n3;
        ay2.var_byte_a = byArray[n2++];
        ay2.var_byte_d = byArray[n2++];
        ay2.var_byte_e = byArray[n2++];
        ay2.var_byte_f = byArray[n2++];
        ay2.h = byArray[n2++];
        ay2.var_short_a = f.short_a(byArray, n2);
        ay2.var_short_b = f.short_a(byArray, n2 += 2);
        n2 += 2;
        ay2.var_short_e = byArray[n2++];
        ay2.i = byArray[n2++];
        ay2.var_short_g = f.short_a(byArray, n2);
        n2 += 2;
        ay2.j = byArray[n2++];
        ay2.k = byArray[n2++];
        ay2.var_short_f = f.short_a(byArray, n2);
        n2 += 2;
        ay2.var_short_c = byArray[n2++];
        ay2.var_short_d = f.short_a(byArray, n2);
        n2 += 2;
        ay2.var_boolean_a = byArray[n2++] == 1;
        ay2.var_boolean_b = byArray[n2++] == 1;
        ay2.var_boolean_c = byArray[n2++] == 1;
        as.var_as_a.a(byArray, n2, ay2.var_byte_a, ay2.var_byte_e, by2, by3);
        n2 += 10;
        byte by4 = byArray[n2++];
        if (by4 > 0) {
            n3 = 5 * by4;
            ay2.var_byte_arr_b = new byte[n3];
            System.arraycopy(byArray, n2, ay2.var_byte_arr_b, 0, n3);
            n2 += n3;
        }
        ay2.var_byte_g = byArray[n2++];
        ay2.l = byArray[n2++];
        ay2.a();
        ay.var_ay_arr_a[by2] = ay2;
    }

    public final void a() {
        if (u.var_byte_i < 1) {
            return;
        }
        int n2 = u.var_byte_i > 1 ? 2 : 1;
        byte by2 = this.h;
        this.h = (byte)(2 * this.h / 5 + n2 * 20 + 20);
        if (this.h > 99) {
            this.h = (byte)99;
        }
        int n3 = 0;
        n3 = (this.var_short_a - 10) * (2 + n2) * this.h;
        this.var_short_a = (short)(n3 / by2 >> 1);
        n3 = (this.var_short_e - 4) * this.h * (2 + n2);
        this.var_short_e = (short)(n3 / by2 >> 1);
        n3 = (this.var_short_b - 4) * this.h * (2 + n2);
        this.var_short_b = (short)(n3 / by2 >> 1);
        n3 = (this.var_short_c + 1) * this.h;
        this.var_short_c = (short)(n3 / by2);
        n3 = (this.var_short_d + 1) * this.h;
        this.var_short_d = (short)(n3 / by2);
    }
}

