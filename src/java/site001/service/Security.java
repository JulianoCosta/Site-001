package site001.service;

import java.security.*;
import java.math.*;

public class Security {

    public static String generateMd5(String s) throws NoSuchAlgorithmException {
        String resultado = null;
        if (s != null && !s.isEmpty()) {
            String salt = "Site001";
            s += salt;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            resultado = new BigInteger(1, m.digest()).toString(16);
        }
        return resultado;
    }
}
