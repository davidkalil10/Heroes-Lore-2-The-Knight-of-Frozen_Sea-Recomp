/*
 * Decompiled with CFR 0.152.
 */
public class aj
extends bt {
    public static final byte[] i = new byte[]{14, 15, 16, 14, 15, 16, 15};
    public int b = 0;

    public aj(byte by2, int n2) {
        super(by2);
        this.b = by2 - 30;
        this.var_short_a = b.var_byte_arr_n[i[this.b] - 4 + (u.var_byte_a == 0 ? 1 : 0)];
        this.var_int_a = n2;
        if (this.var_int_a < 1) {
            this.var_int_a = 1;
        }
    }

    public void a(int n2, int n3) {
        bd.a(i[this.b], (byte)(((bt)this).b % this.var_short_a), (byte)1, n2, n3);
    }

    public void a() {
        ((bt)this).b = (short)(((bt)this).b + 1);
        if (((bt)this).b >= this.var_int_a) {
            this.var_boolean_a = true;
        }
    }
}

