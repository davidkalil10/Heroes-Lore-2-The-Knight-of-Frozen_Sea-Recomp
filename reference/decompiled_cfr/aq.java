/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 */
import javax.microedition.lcdui.Graphics;

public final class aq
extends g {
    public cp a = null;

    public aq(g g2, cp cp2) {
        super(g2, (byte)0);
        this.a = cp2;
    }

    public boolean boolean_a(int n2, int n3) {
        if (this.boolean_b(n2, n3)) {
            return true;
        }
        if (n3 == 8 || n2 == 8 || n3 == 53) {
            this.var_g_a.b(0);
        }
        return true;
    }

    public void void_a(int n2, int n3) {
        Graphics graphics = bw.var_javax_microedition_lcdui_Graphics_a;
        g.void_a(graphics, n2, n3);
        this.a(graphics, n2 + -7, n3 + 18, this.a, true, false, false);
        bd.a(n2 + -27, n3 + 16, this.a.g == 23 ? (byte)29 : this.a.g);
    }
}

