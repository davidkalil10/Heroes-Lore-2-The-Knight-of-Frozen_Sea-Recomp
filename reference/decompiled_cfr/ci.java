/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class ci
implements ax {
    private static final byte[] i = new byte[]{7, 8, 9, 12, 15, 16, 23, 24, 29};
    private static final byte[] j = new byte[]{24, 25, 26};
    public Vector var_java_util_Vector_a = new Vector(1);
    private byte b;
    public byte var_byte_a;
    private byte c;

    public ci(byte by2) {
        this.b = by2;
    }

    public void void_a() {
        this.var_byte_a = (byte)-1;
        this.c = (byte)-1;
        this.void_b();
    }

    public final void void_b() {
        for (int i2 = 0; i2 < 3; ++i2) {
            this.c = (byte)(this.c + 1);
            if (this.c >= j.length) {
                this.c = 0;
            }
            this.var_byte_a = this.byte_a(j[this.c], (byte)0);
            if (this.var_byte_a <= -1) continue;
            return;
        }
        this.var_byte_a = (byte)-1;
    }

    public final cp cp_a() {
        this.var_byte_a = this.byte_a(j[this.c], (byte)0);
        if (this.var_byte_a < 0) {
            return null;
        }
        return (cp)this.var_java_util_Vector_a.elementAt(this.var_byte_a);
    }

    public final cp cp_a(int n2) {
        if (n2 >= this.var_java_util_Vector_a.size() || n2 < 0) {
            return null;
        }
        return (cp)this.var_java_util_Vector_a.elementAt(n2);
    }

    public boolean boolean_a(cp cp2, int n2) {
        if (this.var_java_util_Vector_a.size() > this.b) {
            return false;
        }
        cp2.c = n2;
        this.var_java_util_Vector_a.addElement(cp2);
        return true;
    }

    private final byte byte_a(int n2) {
        for (byte by2 = (byte)n2; by2 < this.var_java_util_Vector_a.size(); by2 = (byte)(by2 + 1)) {
            if (this.var_java_util_Vector_a.elementAt(by2) != null) continue;
            return by2;
        }
        if (this.var_java_util_Vector_a.size() + 1 <= this.b) {
            return (byte)(this.var_java_util_Vector_a.size() + 1);
        }
        return -1;
    }

    public final boolean boolean_a(byte by2, byte by3, byte by4) {
        cp cp2 = (cp)this.var_java_util_Vector_a.elementAt(by4);
        return cp2 != null && cp2.g == by2 && cp2.h == by3;
    }

    public final boolean a(byte by2, byte by3, int n2) {
        byte by4 = this.byte_a(0);
        if (by4 != -1) {
            return true;
        }
        if (!this.d(by2)) {
            return false;
        }
        for (byte by5 = 0; by5 < this.var_java_util_Vector_a.size(); by5 = (byte)(by5 + 1)) {
            if (!this.boolean_a(by2, by3, by5) || ((cp)this.var_java_util_Vector_a.elementAt((int)by5)).c + n2 > 99) continue;
            return true;
        }
        return false;
    }

    public final int a(cp cp2, byte n2) {
        if (!this.a(cp2.g, cp2.h, n2)) {
            return 0;
        }
        int n3 = 0;
        if (!this.d(cp2.g)) {
            this.boolean_a(cp2, 1);
            n3 = 1;
            for (n2 = (byte)(n2 - 1); n2 > 0 && this.byte_a(0) != -1; n2 = (byte)(n2 - 1)) {
                this.boolean_a(cp.a(cp2.g, cp2.h, true, false), 1);
                ++n3;
            }
            return n3;
        }
        byte[] byArray = this.byte_arr_a(cp2.g, cp2.h);
        int n4 = 0;
        int n5 = n2;
        if (byArray != null) {
            cp cp3 = null;
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                cp3 = (cp)this.var_java_util_Vector_a.elementAt(byArray[i2]);
                n4 = cp3.c;
                cp3.c = (n5 += n4) > 99 ? 99 : (int)((byte)n5);
                if ((n5 -= cp3.c) >= 1) continue;
                return n2;
            }
            if (this.boolean_a(cp2, n5)) {
                return n2;
            }
            return n2 - n5;
        }
        if (this.boolean_a(cp2, n5)) {
            return n2;
        }
        return 0;
    }

    public final void void_a(byte by2, byte by3, byte n2) {
        byte by4 = this.byte_a(by2, by3);
        cp cp2 = null;
        while (n2 > 0 && by4 > -1) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(by4);
            int n3 = cp2.c < n2 ? cp2.c : n2;
            this.a(by4, n3);
            if ((n2 = (int)((byte)(n2 - n3))) <= 0) continue;
            by4 = this.byte_a(by2, by3);
        }
        this.e();
    }

    public final void a(byte by2, int n2) {
        cp cp2 = this.cp_a((int)by2);
        this.void_a(cp2, n2);
        if (cp2.c < 1) {
            this.void_b(by2);
        }
    }

    public final void void_a(cp cp2, int n2) {
        cp2.a(n2);
    }

    public final void void_a(byte by2) {
        if (by2 > 0) {
            this.var_java_util_Vector_a.removeElementAt(by2);
        }
    }

    public final void void_b(byte by2) {
        this.var_java_util_Vector_a.removeElementAt(by2);
    }

    public void c() {
        cp cp2 = null;
        for (int i2 = 0; i2 < this.var_java_util_Vector_a.size(); ++i2) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(i2);
            if (cp2.g != 33) continue;
            this.var_java_util_Vector_a.removeElementAt(i2);
        }
    }

    public final byte[] byte_arr_a(byte by2, byte by3) {
        byte[] byArray = new byte[this.b];
        int n2 = 0;
        cp cp2 = null;
        for (int n3 = 0; n3 < this.var_java_util_Vector_a.size(); n3 = (int)((byte)(n3 + 1))) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(n3);
            if (cp2 == null || cp2.g != by2 || cp2.h != by3) continue;
            byArray[n2++] = n3;
        }
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, 0, byArray2, 0, n2);
        if (n2 == 0) {
            return null;
        }
        return byArray2;
    }

    public final byte[] byte_arr_b(byte by2, byte by3) {
        int n2 = 0;
        cp cp2 = null;
        byte[] byArray = new byte[this.var_java_util_Vector_a.size()];
        for (int n3 = 0; n3 < this.var_java_util_Vector_a.size(); n3 = (int)((byte)(n3 + 1))) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(n3);
            if (cp2 == null || cp2.g != by2 && cp2.g != by3) continue;
            byArray[n2] = n3;
            ++n2;
        }
        if (n2 == 0) {
            return null;
        }
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, 0, byArray2, 0, n2);
        return byArray2;
    }

    private final boolean d(byte by2) {
        return by2 != 29 && by2 >= 13;
    }

    public static final boolean boolean_a(byte by2) {
        return by2 == 23 || by2 == 30 || by2 == 31 || by2 == 32;
    }

    public final boolean boolean_b(byte by2) {
        return by2 == 24 || by2 == 25 || by2 == 26 || by2 == 27;
    }

    public final boolean boolean_a(byte by2, byte by3) {
        if (by2 == 33) {
            for (int i2 = 0; i2 < i.length; ++i2) {
                if (by3 != i[i2]) continue;
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean c(byte by2) {
        return by2 == 18 || by2 == 20 || by2 <= 12;
    }

    public boolean b(byte by2, byte by3, byte by4) {
        cp cp2 = null;
        byte by5 = 0;
        for (int i2 = 0; i2 < this.var_java_util_Vector_a.size(); ++i2) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(i2);
            if (cp2 == null || cp2.g != by2 || cp2.h != by3 || (by5 += cp2.c) < by4) continue;
            return true;
        }
        return false;
    }

    public final int int_a(byte by2, byte by3) {
        cp cp2 = null;
        int n2 = 0;
        for (int i2 = 0; i2 < this.var_java_util_Vector_a.size(); ++i2) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(i2);
            if (cp2 == null || cp2.g != by2 || cp2.h != by3) continue;
            n2 += cp2.c;
        }
        return n2;
    }

    public final byte byte_a(byte by2, byte by3) {
        cp cp2 = null;
        for (byte by4 = 0; by4 < this.var_java_util_Vector_a.size(); by4 = (byte)((byte)(by4 + 1))) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(by4);
            if (cp2 == null || cp2.g != by2 || cp2.h != by3) continue;
            return by4;
        }
        return -1;
    }

    public final byte byte_b(byte by2, byte by3) {
        cp cp2 = null;
        for (byte by4 = 0; by4 < this.var_java_util_Vector_a.size(); by4 = (byte)((byte)(by4 + 1))) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(by4);
            if (cp2 == null || cp2.g != by2 || cp2.h != by3 || cp2 instanceof p && ((p)cp2).f > -1) continue;
            return by4;
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final byte[] byte_arr_a() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            filterOutputStream = new DataOutputStream(byteArrayOutputStream);
            cp cp2 = null;
            ((DataOutputStream)filterOutputStream).writeByte(this.var_java_util_Vector_a.size());
            for (int i2 = 0; i2 < this.var_java_util_Vector_a.size(); ++i2) {
                cp2 = (cp)this.var_java_util_Vector_a.elementAt(i2);
                if (cp2 == null) {
                    ((DataOutputStream)filterOutputStream).writeByte(0);
                    continue;
                }
                byte[] byArray = cp2.byte_arr_a();
                ((DataOutputStream)filterOutputStream).writeByte(byArray.length);
                ((OutputStream)filterOutputStream).write(byArray);
            }
            byte[] byArray = byteArrayOutputStream.toByteArray();
            return byArray;
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    ((OutputStream)byteArrayOutputStream).close();
                }
            }
            catch (IOException iOException) {}
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void a(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = null;
        FilterInputStream filterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(byArray);
            filterInputStream = new DataInputStream(byteArrayInputStream);
            int n2 = ((DataInputStream)filterInputStream).readByte();
            for (int i2 = 0; i2 < n2; ++i2) {
                byte by2 = ((DataInputStream)filterInputStream).readByte();
                if (by2 == 0) continue;
                byte[] byArray2 = new byte[by2];
                ((DataInputStream)filterInputStream).read(byArray2);
                this.var_java_util_Vector_a.addElement(cp.a(byArray2));
            }
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    ((InputStream)byteArrayInputStream).close();
                }
            }
            catch (IOException iOException) {}
        }
        this.void_a();
    }

    public void d() {
        this.a(cp.a((byte)29, (byte)0, true, true), (byte)1);
        b b2 = u.var_b_a;
        p p2 = null;
        switch (u.var_byte_a) {
            case 0: {
                p2 = (p)cp.a((byte)1, (byte)0, true, false);
                break;
            }
            case 1: {
                p2 = (p)cp.a((byte)2, (byte)0, true, false);
                break;
            }
            default: {
                p2 = (p)cp.a((byte)3, (byte)0, true, false);
            }
        }
        u.var_ci_a.a((cp)p2, (byte)1);
        b2.a((byte)3, p2);
    }

    public final cp cp_a(byte by2) {
        cp cp2 = null;
        for (int n2 = 0; n2 < this.var_java_util_Vector_a.size(); n2 = (int)((byte)(n2 + 1))) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(n2);
            if (!(cp2 instanceof p) || ((p)cp2).f != by2) continue;
            return cp2;
        }
        return null;
    }

    public final byte[] byte_arr_b() {
        byte[] byArray = new byte[7];
        for (int n2 = 0; n2 < 7; n2 = (int)((byte)(n2 + 1))) {
            byArray[n2] = -1;
        }
        cp cp2 = null;
        for (int n3 = 0; n3 < this.var_java_util_Vector_a.size(); n3 = (int)((byte)(n3 + 1))) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(n3);
            if (!(cp2 instanceof p) || ((p)cp2).f <= -1) continue;
            byArray[((p)cp2).f] = n3;
        }
        return byArray;
    }

    public final boolean a(cp cp2) {
        return cp2 instanceof p && ((p)cp2).f > -1;
    }

    public final void e() {
        for (int n2 = 0; n2 < this.var_java_util_Vector_a.size() - 1; n2 = (int)((byte)(n2 + 1))) {
            cp cp2 = (cp)this.var_java_util_Vector_a.elementAt(n2);
            if (cp2 == null || !this.d(cp2.g) || cp2.c >= 99) continue;
            for (byte by2 = (byte)(n2 + 1); by2 < this.var_java_util_Vector_a.size(); by2 = (byte)(by2 + 1)) {
                cp cp3 = (cp)this.var_java_util_Vector_a.elementAt(by2);
                if (cp3 == null || cp3.g != cp2.g || cp3.h != cp2.h) continue;
                int n3 = cp2.c;
                int n4 = cp3.c;
                if (n3 + n4 <= 99) {
                    cp2.a((byte)n4);
                    this.void_b(by2);
                    continue;
                }
                byte by3 = (byte)(99 - n3);
                cp2.a(by3);
                cp3.a((int)by3);
            }
        }
        this.int_a();
    }

    public int int_a() {
        cp cp2 = null;
        int n2 = 0;
        for (int i2 = this.var_java_util_Vector_a.size() - 1; i2 >= 0; --i2) {
            cp2 = (cp)this.var_java_util_Vector_a.elementAt(i2);
            if (cp2 == null) {
                this.var_java_util_Vector_a.removeElementAt(i2);
                continue;
            }
            ++n2;
        }
        return n2;
    }
}

