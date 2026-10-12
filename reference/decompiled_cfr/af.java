/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.io.Connector
 *  javax.microedition.io.StreamConnection
 */
import com.xce.jam.XBrowser;
import com.xce.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

public class af
extends Thread {
    private static byte[] var_byte_arr_a;
    private static byte[] var_byte_arr_b;
    private static String var_java_lang_String_a;
    private static String var_java_lang_String_b;
    private static String var_java_lang_String_c;
    private static String d;
    public static byte var_byte_a;
    private static String e;
    private static String f;
    private static StreamConnection var_javax_microedition_io_StreamConnection_a;
    public static InputStream var_java_io_InputStream_a;
    public static OutputStream var_java_io_OutputStream_a;
    private static boolean var_boolean_a;
    private static boolean var_boolean_b;
    private static byte[] var_byte_arr_c;
    private static Vector var_java_util_Vector_a;
    private static long var_long_a;
    private static long var_long_b;

    public static byte a(String string, String string2, boolean bl2) {
        byte by2 = 49;
        switch (var_byte_a) {
            case -1: {
                n.a("Flat-rate auth connection attempt ");
                by2 = af.a("210.222.18.8", "3365", bl2, true);
                break;
            }
            case 2: {
                n.a("Connect 6800");
                by2 = af.a(string, string2, bl2, true);
                break;
            }
            case 0: 
            case 1: {
                n.a("Connect 6200");
                by2 = af.a(string, string2, bl2, false);
            }
        }
        return by2;
    }

    public static byte a(String string, String string2, boolean bl2, boolean bl3) {
        var_boolean_b = true;
        byte[] byArray = null;
        t t2 = null;
        if (var_boolean_a) {
            var_boolean_b = false;
            return 49;
        }
        e = string;
        f = string2;
        var_byte_arr_c = af.byte_arr_a();
        if (!System.getProperty("m.SK_VM").equals("10") && (System.getProperty("m.TYPE").equals("1") || System.getProperty("m.TYPE").equals("2"))) {
            XBrowser.setNetworkMode(2);
            Socket.setPPPPreserveTime(1000);
        }
        try {
            int n2;
            String string3 = bl2 ? new String(bl3 ? var_java_lang_String_b : d) : new String(bl3 ? var_java_lang_String_a : var_java_lang_String_c);
            var_javax_microedition_io_StreamConnection_a = (StreamConnection)Connector.open((String)string3);
            var_java_io_InputStream_a = var_javax_microedition_io_StreamConnection_a.openInputStream();
            var_java_io_OutputStream_a = var_javax_microedition_io_StreamConnection_a.openOutputStream();
            byte[] byArray2 = af.a(string.getBytes(), Integer.parseInt(string2), bl3 ? (byte)54 : 48, (byte)55, bl3);
            var_java_io_OutputStream_a.write(byArray2, 0, byArray2.length);
            var_java_io_OutputStream_a.flush();
            byArray = new byte[43];
            for (int i2 = 0; i2 < 43 && (n2 = var_java_io_InputStream_a.read(byArray, i2, 43 - i2)) != -1; i2 += n2) {
            }
            t2 = af.t_a(byArray);
        }
        catch (Exception exception) {
            return 49;
        }
        if (t2 == null) {
            var_boolean_b = false;
            return 49;
        }
        if (t2.var_byte_a == 48) {
            var_boolean_a = true;
        }
        var_boolean_b = false;
        return t2.var_byte_a;
    }

    public static byte[] byte_arr_a() {
        String string = System.getProperty("m.CARRIER").toUpperCase();
        String string2 = null;
        string2 = System.getProperty("m.VENDER").toUpperCase().equals("LG") && System.getProperty("m.MODEL").equals("56") ? ((string2 = System.getProperty("MIN")).charAt(0) == '0' ? string2.substring(3) : string2.substring(2)) : System.getProperty("m.MIN");
        string2 = string.equals("SKT") ? "011" + string2 : (string.equals("STI") ? "017" + string2 : (string.equals("KTF") ? "016" + string2 : (string.equals("HSP") ? "018" + string2 : (string.equals("LGT") ? "019" + string2 : (string.equals("010") ? "010" + string2 : string + string2)))));
        return string2.getBytes();
    }

    public static boolean boolean_a(byte[] byArray) {
        var_boolean_b = true;
        if (!var_boolean_a) {
            var_boolean_b = false;
            return false;
        }
        int n2 = byArray.length + 4;
        byte[] byArray2 = new byte[n2];
        f.a(byArray2.length, byArray2, 0);
        System.arraycopy(byArray, 0, byArray2, 4, n2 - 4);
        try {
            var_java_io_OutputStream_a.write(byArray2, 0, n2);
            var_java_io_OutputStream_a.flush();
        }
        catch (Exception exception) {
            af.boolean_a();
            return true;
        }
        c.void_a();
        var_boolean_b = false;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean boolean_a() {
        var_boolean_b = true;
        try {
            if (var_java_io_InputStream_a != null) {
                var_java_io_InputStream_a.close();
            }
        }
        catch (Exception exception) {
            System.out.println("close() in " + exception);
        }
        finally {
            try {
                if (var_java_io_OutputStream_a != null) {
                    var_java_io_OutputStream_a.close();
                }
            }
            catch (Exception exception) {
                System.out.println("close() out " + exception);
            }
            finally {
                try {
                    if (var_javax_microedition_io_StreamConnection_a != null) {
                        var_javax_microedition_io_StreamConnection_a.close();
                    }
                }
                catch (Exception exception) {
                    System.out.println("close() connection " + exception);
                }
                finally {
                    var_boolean_a = false;
                }
            }
        }
        var_boolean_b = false;
        return true;
    }

    public static boolean boolean_b() {
        return var_boolean_b;
    }

    public static boolean c() {
        return var_boolean_a;
    }

    private static byte[] a(byte[] byArray, int n2, byte by2, byte by3, boolean bl2) {
        int n3;
        int n4 = (int)(var_long_a / 100000L);
        int n5 = (int)(var_long_a % 100000L);
        n.a("connectPID =" + var_long_a);
        byte[] byArray2 = new byte[83];
        for (n3 = 0; n3 < 83; ++n3) {
            byArray2[n3] = 0;
        }
        byArray2[0] = 73;
        byArray2[1] = 74;
        byArray2[2] = 78;
        byArray2[3] = 0;
        byArray2[4] = (byte)(n4 & 0xFF);
        byArray2[5] = (byte)((n4 & 0xFF00) >> 8);
        byArray2[6] = (byte)((n4 & 0xFF0000) >> 16);
        byArray2[7] = (byte)((n4 & 0xFF000000) >>> 24);
        byArray2[8] = (byte)(n5 & 0xFF);
        byArray2[9] = (byte)((n5 & 0xFF00) >> 8);
        byArray2[10] = (byte)((n5 & 0xFF0000) >> 16);
        byArray2[11] = (byte)((n5 & 0xFF000000) >>> 24);
        System.arraycopy(var_byte_arr_c, 0, byArray2, 12, Math.min(var_byte_arr_c.length, 11));
        System.arraycopy(byArray, 0, byArray2, 23, Math.min(byArray.length, 15));
        byArray2[39] = (byte)((n2 & 0xFF00) >> 8);
        byArray2[38] = (byte)(n2 & 0xFF);
        byArray2[40] = by2;
        byArray2[41] = by3;
        if (bl2) {
            System.arraycopy(var_byte_arr_a, 0, byArray2, 42, Math.min(var_byte_arr_a.length, 20));
            System.arraycopy(var_byte_arr_b, 0, byArray2, 62, Math.min(var_byte_arr_b.length, 20));
        }
        n3 = 0;
        for (int i2 = 4; i2 < 82; ++i2) {
            n3 = (byte)(n3 + byArray2[i2]);
        }
        byArray2[82] = n3;
        return byArray2;
    }

    private static t t_a(byte[] byArray) {
        if (byArray.length != 43) {
            return null;
        }
        t t2 = new t();
        t2.var_byte_a = byArray[4];
        t2.var_java_lang_String_a = new String(byArray, 5, 30);
        t2.var_java_lang_String_a = af.a(t2.var_java_lang_String_a);
        t2.var_java_lang_String_b = new String(byArray, 35, 6);
        t2.var_java_lang_String_b = af.a(t2.var_java_lang_String_b);
        t2.var_byte_b = byArray[41];
        byte by2 = 0;
        for (int i2 = 4; i2 < 42; ++i2) {
            by2 = (byte)(by2 + byArray[i2]);
        }
        if (by2 != byArray[42]) {
            return null;
        }
        return t2;
    }

    private static String a(String string) {
        int n2 = string.length() - 1;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (string.charAt(i2) != '\u0000') continue;
            n2 = i2;
        }
        if (n2 != string.length() - 1) {
            return new String(string.getBytes(), 0, n2);
        }
        return string;
    }

    public static void a(long l2) {
        var_long_b = l2;
    }

    public static void b(long l2) {
        var_long_a = l2;
    }

    public static void void_a() {
        af.b(26802760L);
        af.a(9000404006L);
    }

    public static synchronized boolean d() {
        return var_java_util_Vector_a.size() != 0;
    }

    public static final byte[] a(byte by2) {
        byte[] byArray = new byte[]{by2};
        return byArray;
    }

    public static final byte[] a(byte by2, byte[] byArray) {
        if (byArray == null) {
            return af.a(by2);
        }
        byte[] byArray2 = new byte[1 + byArray.length];
        byArray2[0] = by2;
        System.arraycopy(byArray, 0, byArray2, 1, byArray.length);
        return byArray2;
    }

    public static final byte[] a(byte by2, byte by3) {
        byte[] byArray = new byte[]{by2, by3};
        return byArray;
    }

    public static final byte[] a(byte by2, int n2) {
        byte[] byArray = new byte[5];
        byArray[0] = by2;
        f.a(n2, byArray, 1);
        return byArray;
    }

    public static synchronized void void_a(byte[] byArray) {
        if (byArray != null) {
            var_java_util_Vector_a.addElement(byArray);
            c.void_a();
        }
    }

    public static synchronized byte[] byte_arr_b() {
        if (var_java_util_Vector_a.size() > 0) {
            byte[] byArray = (byte[])var_java_util_Vector_a.firstElement();
            var_java_util_Vector_a.removeElementAt(0);
            return byArray;
        }
        return null;
    }

    static {
        var_byte_arr_a = new byte[]{77, 70, 79, 82, 77, 65};
        var_byte_arr_b = new byte[]{103, 107, 102, 110, 48, 49, 48};
        var_java_lang_String_a = "socket://203.236.40.182:6800";
        var_java_lang_String_b = "socket://203.236.40.205:6800";
        var_java_lang_String_c = "socket://203.236.40.219:6200";
        d = "socket://203.236.40.205:6200";
        var_byte_a = 0;
        var_java_util_Vector_a = new Vector();
    }
}

