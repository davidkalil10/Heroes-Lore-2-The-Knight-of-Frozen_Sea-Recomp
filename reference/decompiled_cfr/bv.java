/*
 * Decompiled with CFR 0.152.
 */
public class bv
extends g {
    public e var_e_a;
    public static int var_int_a;
    public static int b;
    public static bv var_bv_a;

    public static final bv bv_a() {
        if (var_bv_a == null) {
            var_bv_a = new bv();
            var_int_a = bw.g - 120 >> 1;
            b = bw.h - 117 >> 1;
        }
        return var_bv_a;
    }

    public bv() {
        super(null, (byte)2);
    }

    public void void_a() {
        try {
            this.var_e_a = new e("/t/rf");
            bd.var_bd_a.b();
            ((g)this).b = new ba((g)this, 4, 2, this.var_e_a.a(0, 1, 2));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void b() {
        var_bv_a = null;
        this.var_e_a = null;
        u.h(3);
        cj.var_cj_a.f();
        bd.var_boolean_a = true;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8) {
            this.b();
            return true;
        }
        return this.e(n2, n3);
    }

    public void a(byte by2, byte by3) {
        super.a(by2, by3);
        if (by2 == 4) {
            if (by3 == -1) {
                this.b();
            } else {
                ((g)this).b = by3 == 0 ? new bi(this) : new x(this);
            }
        } else {
            this.b();
        }
    }

    public void c() {
        this.void_c(var_int_a, b);
    }

    public void void_a(int n2, int n3) {
    }
}

