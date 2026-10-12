/*
 * Decompiled with CFR 0.152.
 */
public abstract class ap
extends bl {
    public static byte var_byte_b;
    public static byte c;
    public byte d;
    public short var_short_a;
    public short var_short_b;
    public byte e;
    public boolean var_boolean_a;
    public boolean var_boolean_b;

    public abstract void a(int var1, int var2);

    public ap(byte by2, byte by3, byte by4, byte by5, boolean bl2) {
        super((short)(by4 << 4), (short)(by5 << 4), (byte)8, (byte)(8 + (bl2 ? var_byte_b : c)));
        this.var_boolean_b = bl2;
        this.d = by2;
        this.e = by3;
        this.var_short_b = (short)-1;
        this.var_boolean_a = false;
    }

    public void b(int n2, int n3) {
        this.b();
        if (this.var_boolean_a) {
            u.var_ah_a.c(this);
        } else {
            int n4 = n2 + this.var_short_c + this.var_byte_f;
            int n5 = n3 + this.var_short_d + this.g - (this.var_boolean_b ? var_byte_b : c);
            this.a(n4, n5);
        }
    }

    public void b() {
        this.var_short_b = (short)(this.var_short_b + 1);
        this.a();
    }

    public void a() {
        if (this.var_short_b >= this.var_short_a) {
            this.var_boolean_a = true;
        }
    }

    static {
        var_byte_b = (byte)2;
        c = (byte)-5;
    }
}

