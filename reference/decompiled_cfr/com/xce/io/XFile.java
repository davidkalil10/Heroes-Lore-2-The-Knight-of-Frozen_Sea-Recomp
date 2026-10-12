/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordStore
 */
package com.xce.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import javax.microedition.rms.RecordStore;

public class XFile {
    private static final Hashtable store = new Hashtable();
    private String name;
    private byte[] data;
    private int pos;
    private ByteArrayOutputStream out;
    private int mode;

    public XFile(String string, int n2) throws IOException {
        this.name = XFile.normalize(string);
        this.mode = n2;
        this.pos = 0;
        if (n2 == 2) {
            this.out = new ByteArrayOutputStream();
            this.data = new byte[0];
        } else {
            byte[] byArray = (byte[])store.get(this.name);
            if (byArray == null) {
                byArray = XFile.loadRms(this.name);
            }
            if (byArray == null) {
                byArray = XFile.loadResource(this.name);
            }
            if (byArray == null) {
                throw new IOException();
            }
            this.data = byArray;
        }
    }

    public XFile(String string, String string2) throws IOException {
        this(XFile.join(string, string2), 1);
    }

    private static String join(String string, String string2) {
        if (string == null || string.length() == 0) {
            return string2;
        }
        if (string2 == null || string2.length() == 0) {
            return string;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        if (!string.endsWith("/")) {
            stringBuffer.append('/');
        }
        stringBuffer.append(string2);
        return stringBuffer.toString();
    }

    private static String normalize(String string) {
        if (string == null || string.length() == 0) {
            return "/";
        }
        String string2 = string.replace('\\', '/');
        while (string2.startsWith("//")) {
            string2 = string2.substring(1);
        }
        if (!string2.startsWith("/")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('/');
            stringBuffer.append(string2);
            string2 = stringBuffer.toString();
        }
        return string2;
    }

    private static String rmsName(String string) {
        int n2 = string.hashCode() & Integer.MAX_VALUE;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("XF");
        stringBuffer.append(n2);
        return stringBuffer.toString();
    }

    private static InputStream openResource(String string) {
        try {
            Object object = new Object();
            return object.getClass().getResourceAsStream(string);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static byte[] loadResource(String string) {
        InputStream inputStream = null;
        try {
            int n2;
            inputStream = XFile.openResource(string);
            if (inputStream == null && string.startsWith("/")) {
                inputStream = XFile.openResource(string.substring(1));
            }
            if (inputStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] byArray = new byte[512];
            while ((n2 = inputStream.read(byArray)) > 0) {
                byteArrayOutputStream.write(byArray, 0, n2);
            }
            try {
                inputStream.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            return byteArrayOutputStream.toByteArray();
        }
        catch (Throwable throwable) {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     */
    private static byte[] loadRms(String string) {
        RecordStore recordStore;
        block22: {
            block21: {
                recordStore = null;
                recordStore = RecordStore.openRecordStore((String)XFile.rmsName(string), (boolean)false);
                if (recordStore != null) break block21;
                byte[] byArray = null;
                try {
                    if (recordStore != null) {
                        recordStore.closeRecordStore();
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                return byArray;
            }
            if (recordStore.getNumRecords() > 0) break block22;
            byte[] byArray = null;
            try {
                if (recordStore != null) {
                    recordStore.closeRecordStore();
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            return byArray;
        }
        byte[] byArray = recordStore.getRecord(1);
        store.put(string, byArray);
        byte[] byArray2 = byArray;
        try {
            if (recordStore != null) {
                recordStore.closeRecordStore();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return byArray2;
        catch (Throwable throwable) {
            try {
                byte[] byArray3 = null;
                return byArray3;
            }
            catch (Throwable throwable2) {
                throw throwable2;
            }
            finally {
                try {
                    if (recordStore != null) {
                        recordStore.closeRecordStore();
                    }
                }
                catch (Throwable throwable3) {}
            }
        }
    }

    private static void saveRms(String string, byte[] byArray) throws IOException {
        RecordStore recordStore = null;
        try {
            recordStore = RecordStore.openRecordStore((String)XFile.rmsName(string), (boolean)true);
            if (recordStore.getNumRecords() <= 0) {
                recordStore.addRecord(byArray, 0, byArray.length);
            } else {
                recordStore.setRecord(1, byArray, 0, byArray.length);
            }
        }
        catch (Throwable throwable) {
            throw new IOException();
        }
        finally {
            try {
                if (recordStore != null) {
                    recordStore.closeRecordStore();
                }
            }
            catch (Throwable throwable) {}
        }
    }

    private static byte[] load(String string) {
        byte[] byArray = XFile.loadRms(string);
        if (byArray != null) {
            return byArray;
        }
        return XFile.loadResource(string);
    }

    public static boolean exists(String string) {
        String string2 = XFile.normalize(string);
        if (store.get(string2) != null) {
            return true;
        }
        byte[] byArray = XFile.loadRms(string2);
        if (byArray != null) {
            return true;
        }
        byArray = XFile.loadResource(string2);
        return byArray != null;
    }

    public int available() {
        if (this.data == null) {
            return 0;
        }
        int n2 = this.data.length - this.pos;
        if (n2 < 0) {
            return 0;
        }
        return n2;
    }

    public int read(byte[] byArray, int n2, int n3) throws IOException {
        if (byArray == null || n3 <= 0) {
            return 0;
        }
        if (this.data == null) {
            throw new IOException();
        }
        int n4 = this.data.length - this.pos;
        if (n4 < n3) {
            throw new IOException();
        }
        System.arraycopy(this.data, this.pos, byArray, n2, n3);
        this.pos += n3;
        return n3;
    }

    public int write(byte[] byArray, int n2, int n3) throws IOException {
        if (this.out == null) {
            this.out = new ByteArrayOutputStream();
        }
        if (byArray != null && n3 > 0) {
            this.out.write(byArray, n2, n3);
        }
        return n3;
    }

    public void close() throws IOException {
        if (this.mode == 2 && this.out != null) {
            byte[] byArray = this.out.toByteArray();
            store.put(this.name, byArray);
            XFile.saveRms(this.name, byArray);
        }
    }
}

