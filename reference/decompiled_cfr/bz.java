/*
 * Decompiled with CFR 0.152.
 */
import com.skt.m.AudioClip;
import com.skt.m.AudioSystem;

public class bz
implements Runnable {
    private static int var_int_a;
    private Thread var_java_lang_Thread_a;
    private boolean var_boolean_a;
    private Object var_java_lang_Object_a;
    private boolean var_boolean_b;
    private AudioClip var_com_skt_m_AudioClip_a;
    private int var_int_b;
    private boolean c;

    public static final int int_a() {
        try {
            if (var_int_a == -1) {
                var_int_a = AudioSystem.getMaxVolume("mmf");
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return var_int_a;
    }

    public bz() {
        try {
            this.var_com_skt_m_AudioClip_a = AudioSystem.getAudioClip("mmf");
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.var_java_lang_Object_a = new Object();
        this.var_java_lang_Thread_a = new Thread(this);
        this.var_boolean_a = true;
        this.var_boolean_b = false;
        this.var_int_b = -1;
        this.var_java_lang_Thread_a.start();
    }

    public void a(byte[] byArray) {
        try {
            this.b();
            this.var_com_skt_m_AudioClip_a.open(byArray, 0, byArray.length);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void a(boolean bl2) {
        this.c = bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        while (this.var_boolean_a) {
            try {
                Object object = this.var_java_lang_Object_a;
                synchronized (object) {
                    while (!this.var_boolean_b) {
                        this.var_java_lang_Object_a.wait(100000L);
                    }
                }
                if (this.c) {
                    this.var_com_skt_m_AudioClip_a.loop();
                } else {
                    this.var_com_skt_m_AudioClip_a.play();
                }
                this.var_boolean_b = false;
            }
            catch (Exception exception) {}
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void void_a() {
        this.var_boolean_b = true;
        Object object = this.var_java_lang_Object_a;
        synchronized (object) {
            this.var_java_lang_Object_a.notify();
        }
    }

    public void b() {
        try {
            this.var_boolean_b = false;
            this.var_com_skt_m_AudioClip_a.stop();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static {
        var_int_a = -1;
    }
}

