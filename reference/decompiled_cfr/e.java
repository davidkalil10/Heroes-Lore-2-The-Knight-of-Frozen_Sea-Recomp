/*
 * Decompiled with CFR 0.152.
 */
public class e {
    private Object[] var_java_lang_Object_arr_a;
    public short var_short_a;

    public e(String string) {
        byte[] byArray = as.a(string.concat(".tdf"));
        int n2 = 0;
        this.var_short_a = (short)(byArray[n2++] & 0xFF);
        this.var_java_lang_Object_arr_a = new Object[this.var_short_a];
        for (int i2 = 0; i2 < this.var_short_a; ++i2) {
            int n3 = (byArray[n2++] & 0xFF) << 8;
            this.var_java_lang_Object_arr_a[i2] = new byte[n3 += byArray[n2++] & 0xFF];
            System.arraycopy(byArray, n2, this.var_java_lang_Object_arr_a[i2], 0, n3);
            n2 += n3;
        }
    }

    public byte[] a(int n2) {
        return (byte[])this.var_java_lang_Object_arr_a[n2];
    }

    public final byte[][] a(int n2, int n3) {
        return this.a(new int[]{n2, n3});
    }

    public final byte[][] a(int n2, int n3, int n4) {
        return this.a(new int[]{n2, n3, n4});
    }

    public final byte[][] a(int n2, int n3, int n4, int n5) {
        return this.a(new int[]{n2, n3, n4, n5});
    }

    public final byte[][] a(int n2, int n3, int n4, int n5, int n6) {
        return this.a(new int[]{n2, n3, n4, n5, n6});
    }

    public final byte[][] a(int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.a(new int[]{n2, n3, n4, n5, n6, n7});
    }

    public final byte[][] a(int[] nArray) {
        byte[][] byArrayArray = new byte[nArray.length][];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            byArrayArray[i2] = (byte[])(nArray[i2] < 0 ? null : this.a(nArray[i2]));
        }
        return byArrayArray;
    }

    public final short a() {
        return this.var_short_a;
    }
}

