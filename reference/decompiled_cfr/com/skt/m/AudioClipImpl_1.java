/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.media.Player
 *  javax.microedition.media.PlayerListener
 */
package com.skt.m;

import com.skt.m.AudioClipImpl;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;

class AudioClipImpl_1
implements PlayerListener {
    final AudioClipImpl this$0;

    AudioClipImpl_1(AudioClipImpl audioClipImpl) {
        this.this$0 = audioClipImpl;
    }

    public void playerUpdate(Player player, String string, Object object) {
        if ("endOfMedia".equals(string)) {
            AudioClipImpl.access$000(this.this$0);
        }
    }
}

