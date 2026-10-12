/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.media.Control
 *  javax.microedition.media.Manager
 *  javax.microedition.media.Player
 *  javax.microedition.media.PlayerListener
 *  javax.microedition.media.control.MIDIControl
 *  javax.microedition.media.control.VolumeControl
 *  javax.microedition.rms.RecordStore
 */
package com.skt.m;

import com.skt.m.AudioClip;
import com.skt.m.AudioClipImpl_1;
import com.skt.m.UnsupportedFormatException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.media.Control;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import javax.microedition.media.control.MIDIControl;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.rms.RecordStore;

public class AudioClipImpl
implements AudioClip {
    private static final String[] SMAF_TYPES = new String[]{"audio/x-smaf", "audio/mmf", "application/x-smaf", "audio/smaf"};
    private static final String[] WAV_TYPES = new String[]{"audio/x-wav", "audio/wav"};
    private static final String[] MP3_TYPES = new String[]{"audio/mpeg", "audio/mp3", "audio/x-mp3"};
    private static final String[] MIDI_TYPES = new String[]{"audio/midi", "audio/mid", "audio/x-midi", "audio/sp-midi"};
    private static final Vector activePlayers = new Vector();
    private static final String RS_NAME = "sktAudioVolume";
    private static int currentVolumePercent = 75;
    private static boolean volumeLoaded = false;
    private Player player;
    private final PlayerListener endListener = new AudioClipImpl_1(this);
    private byte[] openData;
    private long lastOpenTime;

    private static void ensureVolumeLoaded() {
        if (volumeLoaded) {
            return;
        }
        volumeLoaded = true;
        try {
            RecordStore recordStore = RecordStore.openRecordStore((String)RS_NAME, (boolean)true);
            try {
                int n2;
                byte[] byArray;
                if (recordStore.getNumRecords() > 0 && (byArray = recordStore.getRecord(1)) != null && byArray.length > 0 && (n2 = byArray[0] & 0xFF) >= 0 && n2 <= 100) {
                    currentVolumePercent = n2;
                }
            }
            finally {
                recordStore.closeRecordStore();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static void saveVolume(int n2) {
        try {
            RecordStore recordStore = RecordStore.openRecordStore((String)RS_NAME, (boolean)true);
            try {
                byte[] byArray = new byte[]{(byte)n2};
                if (recordStore.getNumRecords() > 0) {
                    recordStore.setRecord(1, byArray, 0, 1);
                } else {
                    recordStore.addRecord(byArray, 0, 1);
                }
            }
            finally {
                recordStore.closeRecordStore();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void open(byte[] byArray, int n2, int n3) throws UnsupportedFormatException {
        AudioClipImpl.ensureVolumeLoaded();
        byte[] byArray2 = byArray;
        if (n2 != 0 || n3 != byArray.length) {
            byArray2 = new byte[n3];
            System.arraycopy(byArray, n2, byArray2, 0, n3);
        }
        if (this.player != null && byArray2 == this.openData && System.currentTimeMillis() - this.lastOpenTime < 1500L) {
            try {
                this.player.stop();
                AudioClipImpl.silenceMidiNotes(this.player);
                this.player.setMediaTime(0L);
                AudioClipImpl.applyVolume(this.player, currentVolumePercent);
                this.lastOpenTime = System.currentTimeMillis();
                return;
            }
            catch (Exception exception) {}
        }
        this.close();
        String[] stringArray = AudioClipImpl.detectContentTypes(byArray2);
        Exception exception = null;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray2);
                Player player = Manager.createPlayer((InputStream)byteArrayInputStream, (String)stringArray[i2]);
                player.realize();
                player.prefetch();
                player.addPlayerListener(this.endListener);
                AudioClipImpl.applyVolume(player, currentVolumePercent);
                this.player = player;
                this.openData = byArray2;
                this.lastOpenTime = System.currentTimeMillis();
                activePlayers.addElement(this);
                return;
            }
            catch (Exception exception2) {
                exception = exception2;
                continue;
            }
        }
        throw new UnsupportedFormatException(exception != null ? exception.getMessage() : "audio format not supported");
    }

    private static String[] detectContentTypes(byte[] byArray) {
        if (AudioClipImpl.isWav(byArray)) {
            return WAV_TYPES;
        }
        if (AudioClipImpl.isMp3(byArray)) {
            return MP3_TYPES;
        }
        if (AudioClipImpl.isMidi(byArray)) {
            return MIDI_TYPES;
        }
        return SMAF_TYPES;
    }

    private static boolean isMidi(byte[] byArray) {
        return byArray.length >= 4 && byArray[0] == 77 && byArray[1] == 84 && byArray[2] == 104 && byArray[3] == 100;
    }

    private static boolean isWav(byte[] byArray) {
        return byArray.length >= 12 && byArray[0] == 82 && byArray[1] == 73 && byArray[2] == 70 && byArray[3] == 70 && byArray[8] == 87 && byArray[9] == 65 && byArray[10] == 86 && byArray[11] == 69;
    }

    private static boolean isMp3(byte[] byArray) {
        if (byArray.length >= 3 && byArray[0] == 73 && byArray[1] == 68 && byArray[2] == 51) {
            return true;
        }
        if (byArray.length >= 2) {
            int n2 = byArray[0] & 0xFF;
            int n3 = byArray[1] & 0xFF;
            if (n2 == 255 && (n3 & 0xE0) == 224) {
                return true;
            }
        }
        return false;
    }

    public void play() {
        this.startPlayback(1);
    }

    public void loop() {
        this.startPlayback(-1);
    }

    public void stop() {
        if (this.player != null) {
            try {
                this.player.stop();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private void startPlayback(int n2) {
        if (this.player == null) {
            return;
        }
        try {
            this.player.stop();
            this.player.setMediaTime(0L);
            this.player.setLoopCount(n2);
            this.player.start();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void close() {
        if (this.player != null) {
            try {
                this.player.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.player = null;
            this.openData = null;
            activePlayers.removeElement(this);
        }
    }

    static void setGlobalVolumePercent(int n2) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 > 100) {
            n2 = 100;
        }
        currentVolumePercent = n2;
        volumeLoaded = true;
        AudioClipImpl.saveVolume(n2);
        for (int i2 = 0; i2 < activePlayers.size(); ++i2) {
            AudioClipImpl audioClipImpl = (AudioClipImpl)activePlayers.elementAt(i2);
            if (audioClipImpl.player == null) continue;
            AudioClipImpl.applyVolume(audioClipImpl.player, n2);
        }
    }

    private static void applyVolume(Player player, int n2) {
        VolumeControl volumeControl = (VolumeControl)player.getControl("VolumeControl");
        if (volumeControl != null) {
            volumeControl.setLevel(n2);
        }
    }

    static void access$000(AudioClipImpl audioClipImpl) {
        audioClipImpl.close();
    }

    private static void silenceMidiNotes(Player player) {
        try {
            Control control = player.getControl("MIDIControl");
            if (control != null) {
                MIDIControl mIDIControl = (MIDIControl)control;
                for (int i2 = 0; i2 < 16; ++i2) {
                    mIDIControl.shortMidiEvent(176 + i2, 120, 0);
                }
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

