/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Display
 *  javax.microedition.midlet.MIDlet
 */
package rpg;

import com.skt.m.BackLight;
import com.skt.m.Device;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class RPGHero2
extends MIDlet {
    public static RPGHero2 var_rpg_RPGHero2_a;
    private Display var_javax_microedition_lcdui_Display_a;

    public RPGHero2() {
        var_rpg_RPGHero2_a = this;
        this.var_javax_microedition_lcdui_Display_a = Display.getDisplay((MIDlet)this);
        cj.a(this.var_javax_microedition_lcdui_Display_a);
    }

    public void startApp() {
        if (cj.var_boolean_a) {
            this.resumeApp();
            return;
        }
        cj.var_cj_a.b();
        Device.setBacklightEnabled(false);
        BackLight.on(0);
        Device.setKeyToneEnabled(false);
    }

    public void destroyApp(boolean bl2) {
        this.notifyDestroyed();
    }

    public void pauseApp() {
        if (cj.var_cj_a != null) {
            cj.var_cj_a.c();
        }
    }

    public void resumeApp() {
        Device.setBacklightEnabled(false);
        BackLight.on(0);
        Device.setKeyToneEnabled(false);
        ak.b();
        if (cj.var_cj_a != null) {
            cj.var_cj_a.d();
        }
    }
}

