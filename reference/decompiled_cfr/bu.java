/*
 * Decompiled with CFR 0.152.
 */
public class bu
extends bt {
    public static final byte[] i = new byte[]{16};
    public static final byte[] j = new byte[]{9};
    public byte a = 0;

    public bu(byte by2, byte by3) {
        super(by2);
        this.a = by3;
        this.var_short_a = j[by2 - 40];
        this.var_int_a = 1;
    }

    public void a(int n2, int n3) {
        bd.void_a(this.a, i[this.c - 40], (byte)(this.b % this.var_short_a), (byte)1, n2, n3);
    }
}

