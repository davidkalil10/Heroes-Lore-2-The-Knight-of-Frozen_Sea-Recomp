/*
 * Decompiled with CFR 0.152.
 */
public abstract class bt
implements ax {
    public byte c;
    public short var_short_a;
    public short b;
    public int var_int_a;
    public boolean var_boolean_a;
    public byte d;

    public bt(byte by2) {
        this.c = by2;
        this.var_short_a = 1;
        this.var_int_a = 1;
        this.d = 0;
        this.b = 0;
    }

    public bt(byte by2, byte by3) {
        this.c = by2;
        this.var_short_a = 1;
        this.var_int_a = 1;
        this.b = 0;
        this.a(by3);
    }

    public abstract void a(int var1, int var2);

    public void b(int n2, int n3) {
        this.a(n2, n3);
        this.a();
    }

    public void a() {
        this.b = (short)(this.b + 1);
        if (this.var_int_a != -1 && this.b >= this.var_short_a * this.var_int_a) {
            this.var_boolean_a = true;
        }
    }

    public void a(byte by2) {
        switch (by2) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.d = (byte)-6;
                break;
            }
            case 5: {
                this.d = (byte)-11;
                break;
            }
            case 7: {
                this.d = (byte)8;
                break;
            }
            case 10: {
                this.d = (byte)6;
                break;
            }
            default: {
                this.d = 0;
            }
        }
    }
}

