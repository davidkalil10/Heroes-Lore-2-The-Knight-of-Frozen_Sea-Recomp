/*
 * Decompiled with CFR 0.152.
 */
public abstract class bl
implements ax {
    public short var_short_c;
    public short var_short_d;
    public byte var_byte_f;
    public byte g;
    public byte h;
    public byte i;
    public boolean var_boolean_c;
    public boolean var_boolean_d;
    public byte j = 1;
    public boolean e = true;
    public bl a;
    public bl b;
    public boolean var_boolean_f = false;

    public abstract void b(int var1, int var2);

    public bl(short s2, short s3, byte by2, byte by3) {
        this.a(s2, s3);
        this.void_c();
        this.var_byte_f = by2;
        this.g = by3;
        this.e = true;
    }

    public void a(boolean bl2) {
        this.e = bl2;
    }

    public void a(short s2, short s3) {
        this.var_short_c = s2;
        this.var_short_d = s3;
    }

    public void void_c() {
        this.h = (byte)(this.var_short_c >> 4);
        this.i = (byte)(this.var_short_d >> 4);
        this.var_boolean_c = (this.var_short_c & 0xF) != 0;
        this.var_boolean_d = (this.var_short_d & 0xF) != 0;
    }

    public bl bl_a(byte by2, byte by3) {
        return this.bl_a((byte)0, by2, by3);
    }

    public bl bl_a(byte by2, byte by3, byte by4) {
        ah ah2 = u.var_ah_a;
        int n2 = this.h + ax.var_byte_arr_a[by2];
        int n3 = this.i + ax.var_byte_arr_b[by2];
        switch (by3) {
            case 1: {
                if (n3 - by4 < 0) {
                    return null;
                }
                return ah2.var_bl_arr_arr_a[n3 - by4][n2];
            }
            case 2: {
                if (n3 + by4 >= ah.var_byte_e) {
                    return null;
                }
                return ah2.var_bl_arr_arr_a[n3 + by4][n2];
            }
            case 3: {
                if (n2 - by4 < 0) {
                    return null;
                }
                return ah2.var_bl_arr_arr_a[n3][n2 - by4];
            }
            case 4: {
                if (n2 + by4 >= ah.var_byte_d) {
                    return null;
                }
                return ah2.var_bl_arr_arr_a[n3][n2 + by4];
            }
        }
        return null;
    }
}

