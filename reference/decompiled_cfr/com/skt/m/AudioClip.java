/*
 * Decompiled with CFR 0.152.
 */
package com.skt.m;

import com.skt.m.UnsupportedFormatException;

public interface AudioClip {
    public void open(byte[] var1, int var2, int var3) throws UnsupportedFormatException;

    public void play();

    public void loop();

    public void stop();
}

