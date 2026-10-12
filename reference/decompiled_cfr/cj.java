/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 */
import com.xce.io.XFile;
import java.io.IOException;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

public class cj
implements Runnable {
    private static final byte[] var_byte_arr_a;
    public static cj var_cj_a;
    public static boolean var_boolean_a;
    public static byte var_byte_a;
    public static byte var_byte_b;
    public static boolean var_boolean_b;
    public static boolean var_boolean_c;
    public static boolean d;
    public byte var_byte_c = 0;
    public static boolean e;
    public long var_long_a = 0L;
    public boolean f = false;
    private Display var_javax_microedition_lcdui_Display_a;
    private bw var_bw_a;
    private int var_int_a;
    private int var_int_b;
    private long var_long_b;

    public static final void a(Display display) {
        var_cj_a = new cj(display);
    }

    private cj(Display display) {
        this.var_javax_microedition_lcdui_Display_a = display;
        this.var_int_a = var_byte_arr_a[var_byte_a];
        this.f();
    }

    public void run() {
        if (var_boolean_a) {
            return;
        }
        ak.a();
        this.var_long_b = System.currentTimeMillis();
        this.var_bw_a.h();
        this.var_bw_a.repaint(0, 0, bw.g, bw.h);
        this.var_javax_microedition_lcdui_Display_a.callSerially((Runnable)this);
    }

    public final void void_a() {
        long l2 = System.currentTimeMillis() - this.var_long_b;
        if (l2 < (long)this.var_int_b) {
            try {
                Thread.sleep((long)this.var_int_b - l2);
            }
            catch (InterruptedException interruptedException) {}
        } else {
            Thread.yield();
        }
    }

    public final void b() {
        this.g();
        ak.e();
        this.var_bw_a = cd.cd_a();
        this.var_javax_microedition_lcdui_Display_a.setCurrent((Displayable)this.var_bw_a);
        new Thread(var_cj_a).start();
    }

    public synchronized void c() {
        var_boolean_a = true;
        ak.b();
        if (this.var_bw_a != null) {
            this.var_bw_a.g();
        }
    }

    public synchronized void d() {
        if (var_boolean_a) {
            var_boolean_a = false;
            new Thread(var_cj_a).start();
        }
        if (this.var_bw_a != null) {
            this.var_bw_a.void_a();
        }
    }

    public final void e() {
        this.var_bw_a = bd.bd_a();
        u.var_u_a.e();
        this.var_javax_microedition_lcdui_Display_a.setCurrent((Displayable)this.var_bw_a);
        if (cd.var_cd_a != null) {
            cd.var_cd_a.var_javax_microedition_lcdui_Image_arr_a = null;
            cd.var_cd_a = null;
            System.gc();
        }
    }

    public final void a(int n2) {
        this.var_int_b = 1000 / n2;
    }

    public final void f() {
        this.a(this.var_int_a);
    }

    public final void g() {
        this.a(5);
    }

    public final void h() {
        this.a(20);
    }

    public final void a(byte by2) {
        var_byte_a = by2;
        this.var_int_a = var_byte_arr_a[by2];
    }

    public final void i() {
        this.a(20);
        try {
            this.k();
        }
        catch (Exception exception) {
            try {
                this.j();
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
    }

    public final void j() throws IOException {
        byte[] byArray = this.byte_arr_a();
        XFile xFile = new XFile("/cf", 2);
        xFile.write(byArray, 0, byArray.length);
        xFile.close();
    }

    private void k() throws IOException {
        byte[] byArray = new byte[10];
        XFile xFile = new XFile("/cf", 1);
        xFile.read(byArray, 0, byArray.length);
        xFile.close();
        this.a(byArray);
    }

    private byte[] byte_arr_a() {
        byte[] byArray = new byte[10];
        int n2 = 0;
        n2 |= (var_byte_b & 0xF) << 4;
        if (var_boolean_c) {
            n2 |= 8;
        }
        if (e) {
            n2 |= 4;
        }
        if (var_boolean_b) {
            n2 |= 2;
        }
        if (d) {
            n2 |= 1;
        }
        byArray[0] = (byte)n2;
        byArray[1] = (byte)((var_byte_a & 0xF) << 4 | this.var_byte_c);
        this.a(this.var_long_a, byArray, 2);
        return byArray;
    }

    private void a(byte[] byArray) {
        var_byte_b = (byte)((byArray[0] & 0xF0) >> 4);
        var_boolean_c = (byArray[0] & 8) != 0;
        e = (byArray[0] & 4) != 0;
        var_boolean_b = (byArray[0] & 2) != 0;
        d = (byArray[0] & 1) != 0;
        var_byte_a = (byte)((byArray[1] & 0xF0) >> 4);
        this.var_byte_c = (byte)(byArray[1] & 0xF);
        this.var_long_a = this.a(byArray, 2);
        ak.a((int)var_byte_b);
        this.a(var_byte_a);
    }

    private void a(long l2, byte[] byArray, int n2) {
        int n3 = (int)(l2 >> 32 & 0xFFFFFFFFFFFFFFFFL);
        f.a(n3, byArray, n2);
        n3 = (int)(l2 & 0xFFFFFFFFFFFFFFFFL);
        f.a(n3, byArray, n2 + 4);
    }

    private long a(byte[] byArray, int n2) {
        int n3 = f.int_a(byArray, n2);
        int n4 = f.int_a(byArray, n2 + 4);
        return n3 << 32 | n4;
    }

    static {
        var_byte_arr_a = new byte[]{6, 10, 14, 18};
        var_cj_a = null;
        var_byte_a = (byte)2;
        var_byte_b = (byte)5;
        var_boolean_b = true;
        var_boolean_c = true;
        d = true;
        e = true;
    }
}

