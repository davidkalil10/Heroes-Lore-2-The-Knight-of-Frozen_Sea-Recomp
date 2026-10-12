/*
 * Decompiled with CFR 0.152.
 */
public class ab
extends ap {
    public static final byte[] i = new byte[]{4, 4, 9, 7, 8, 9, 17, 18, 8, 14};
    public static final byte[] j = new byte[]{5, 6, 3, 6, 9, 9, 13, 22, 3, 7};
    public static final byte[] var_byte_arr_k;
    public ag var_ag_a;
    private byte var_byte_k;
    public byte var_byte_a = 0;

    public ab(ag ag2, byte by2, byte by3, byte by4, byte by5, byte by6, boolean bl2) {
        super(by5, by2, (byte)(by3 + ax.var_byte_arr_a[by2]), (byte)(by4 + ax.var_byte_arr_b[by2]), bl2);
        this.var_ag_a = ag2;
        this.var_byte_k = by6;
        this.var_short_a = j[this.d];
        this.var_byte_a = this.var_ag_a.var_ay_a.var_byte_c;
        if (this.d >= 8) {
            this.var_byte_a = 0;
        }
    }

    public void a() {
        if (this.var_short_b == var_byte_arr_k[this.d] + (this.e == 1 ? -1 : 0)) {
            bl bl2 = u.var_ah_a.var_bl_arr_arr_a[((bl)this).i][this.h];
            if (bl2 != null && bl2 instanceof b) {
                ((b)bl2).a(this.var_ag_a, this.var_ag_a.var_short_e, this.e);
            }
            byte by2 = (byte)(this.h + ax.var_byte_arr_a[this.e]);
            byte by3 = (byte)(((bl)this).i + ax.var_byte_arr_b[this.e]);
            if (this.var_byte_k > 0 && by2 >= 0 && by2 < ah.var_byte_d && by3 >= 0 && by3 < ah.var_byte_e) {
                if (u.var_ah_a.boolean_b((int)by2, (int)by3)) {
                    this.var_byte_k = 0;
                } else {
                    this.var_byte_k = (byte)(this.var_byte_k - 1);
                    u.var_ah_a.d(new ab(this.var_ag_a, this.e, this.h, ((bl)this).i, this.d, this.var_byte_k, true));
                }
            }
        }
        if (this.var_short_b == j[this.d]) {
            this.var_boolean_a = true;
        }
    }

    public void a(int n2, int n3) {
        bd.void_a(this.var_byte_a, i[this.d], (byte)(this.var_short_b % j[this.d]), (byte)1, n2, n3);
    }

    static {
        var_byte_arr_k = new byte[]{1, 1, 1, 1, -1, 3, -1, -1, -1, 3};
    }
}

