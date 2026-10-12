/*
 * Decompiled with CFR 0.152.
 */
public class s
extends cp {
    public byte a;
    public byte b;
    public byte[] i = new byte[3];
    public byte[] l = new byte[3];

    public s(int n2, int n3) {
        super(n2, n3);
    }

    public int a(byte[] byArray, int n2, boolean bl2, boolean bl3) {
        n2 = super.a(byArray, n2, bl2, bl3);
        this.a = byArray[n2++];
        this.b = byArray[n2++];
        for (int i2 = 0; i2 < 3; ++i2) {
            this.i[i2] = byArray[n2++];
            this.l[i2] = byArray[n2++];
        }
        return n2;
    }
}

