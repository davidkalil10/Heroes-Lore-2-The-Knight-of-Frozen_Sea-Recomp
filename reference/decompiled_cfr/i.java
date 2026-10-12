/*
 * Decompiled with CFR 0.152.
 */
public class i
extends bt {
    public byte a;
    public byte b;

    public i(byte by2, byte by3, int n2) {
        super(by2);
        this.a = by3;
        this.var_int_a = (byte)n2;
        this.b = 0;
    }

    public i(byte by2, byte by3, int n2, byte by4) {
        this(by2, by3, n2);
        this.b = by4;
    }

    public void a(int n2, int n3) {
        this.var_short_a = bd.a((int)this.a, this.b, ((bt)this).b % this.var_short_a, n2, n3);
    }
}

