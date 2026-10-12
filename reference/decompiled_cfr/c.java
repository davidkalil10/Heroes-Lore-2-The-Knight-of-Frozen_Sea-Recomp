/*
 * Decompiled with CFR 0.152.
 */
public class c
extends Thread {
    private static c var_c_a;
    private long var_long_a;
    private static final byte[] var_byte_arr_a;

    public c() {
        var_c_a = this;
        c.void_a();
    }

    public void run() {
        while (af.c()) {
            if (this.boolean_a()) {
                af.boolean_a(var_byte_arr_a);
            }
            try {
                Thread.sleep(2000L);
            }
            catch (Exception exception) {}
        }
    }

    public static final void void_a() {
        if (var_c_a != null) {
            c.var_c_a.var_long_a = System.currentTimeMillis();
        }
    }

    private final boolean boolean_a() {
        return System.currentTimeMillis() - this.var_long_a > 12000L;
    }

    static {
        var_c_a = null;
        var_byte_arr_a = af.a((byte)1, null);
    }
}

