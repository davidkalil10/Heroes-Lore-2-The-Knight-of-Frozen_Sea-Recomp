/*
 * Decompiled with CFR 0.152.
 */
package com.skt.m;

import com.skt.m.AudioClip;
import com.skt.m.AudioClipImpl;

public class AudioSystem {
    private static final int MAX_VOLUME = 7;
    private static final int[] PERCENT_TABLE = new int[]{0, 25, 50, 70, 85, 95, 100};

    public static AudioClip getAudioClip(String string) {
        return new AudioClipImpl();
    }

    public static int getMaxVolume(String string) {
        return 7;
    }

    public static void setVolume(String string, int n2) {
        int n3 = n2;
        if (n3 < 0) {
            n3 = 0;
        }
        if (n3 >= PERCENT_TABLE.length) {
            n3 = PERCENT_TABLE.length - 1;
        }
        AudioClipImpl.setGlobalVolumePercent(PERCENT_TABLE[n3]);
    }
}

