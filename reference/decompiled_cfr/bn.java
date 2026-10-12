/*
 * Decompiled with CFR 0.152.
 */
public class bn
extends ap {
    public b var_b_a;
    public byte var_byte_a;
    public int var_int_a;

    public bn(b b2, int n2) {
        super((byte)0, b2.var_byte_t, (byte)(((bl)b2).h + ax.var_byte_arr_a[b2.var_byte_t]), (byte)(((bl)b2).i + ax.var_byte_arr_b[b2.var_byte_t]), true);
        this.var_b_a = b2;
        this.var_byte_a = (byte)3;
        this.var_int_a = n2;
        this.var_short_a = (short)3;
    }

    public void a() {
        if (this.var_byte_a > 0) {
            bl bl2 = u.var_ah_a.var_bl_arr_arr_a[this.i][this.h];
            if (bl2 != null && bl2 instanceof ag) {
                ((ag)bl2).a(this.var_b_a, (byte)4, this.var_int_a, false, this.e, this.var_b_a.var_byte_l, this.var_b_a.var_byte_m, (byte)22);
            }
            byte by2 = (byte)(this.h + ax.var_byte_arr_a[this.e]);
            byte by3 = (byte)(this.i + ax.var_byte_arr_b[this.e]);
            if (by2 >= 0 && by2 < ah.var_byte_d && by3 >= 0 && by3 < ah.var_byte_e) {
                this.a((short)(by2 << 4), (short)((by3 << 4) + 1));
                this.void_c();
                this.var_byte_a = (byte)(this.var_byte_a - 1);
            }
        } else {
            this.var_boolean_a = true;
        }
    }

    public void a(int n2, int n3) {
        bd.a((byte)17, (byte)this.var_short_b, this.e, n2, n3);
    }
}

