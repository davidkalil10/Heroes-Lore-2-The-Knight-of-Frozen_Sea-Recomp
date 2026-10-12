/*
 * Decompiled with CFR 0.152.
 */
public class al
extends bt {
    public al(byte by2) {
        super(by2, (byte)-1);
        this.b();
    }

    public al(byte by2, byte by3, int n2) {
        super(by2, by3);
        this.b();
        this.var_int_a = (byte)(n2 / this.var_short_a);
    }

    public void b() {
        this.var_int_a = 1;
        this.var_short_a = as.var_by_a.j[this.c - 20];
        as.var_by_a.var_byte_a = 0;
    }

    public void a(int n2, int n3) {
        as.var_by_a.a(bw.var_javax_microedition_lcdui_Graphics_a, (byte)(this.c - 20), (byte)1, n2, n3 - this.d);
    }
}

