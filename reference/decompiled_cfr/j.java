/*
 * Decompiled with CFR 0.152.
 */
public class j
extends Thread {
    public void run() {
        while (af.c()) {
            byte[] byArray = new byte[4];
            try {
                int n2;
                af.var_java_io_InputStream_a.read(byArray, 0, 4);
                int n3 = 0;
                for (n2 = 0; n2 < 4; ++n2) {
                    n3 = n3 << 8 | byArray[n2] & 0xFF;
                }
                byArray = new byte[n3 -= 4];
                for (n2 = 0; n3 > n2; n2 += af.var_java_io_InputStream_a.read(byArray, n2, n3 - n2)) {
                }
                af.void_a(byArray);
            }
            catch (Exception exception) {
                af.boolean_a();
            }
            try {
                Thread.sleep(50L);
            }
            catch (Exception exception) {}
        }
    }
}

