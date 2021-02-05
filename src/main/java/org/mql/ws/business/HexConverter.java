package org.mql.ws.business;

public class HexConverter {
	public static String hex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
            // lower case
            // result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
