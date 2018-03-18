package site001.service;
    
import java.security.*;
import java.math.*;

public class Security {
    
    public static String generateMd5(String s) throws NoSuchAlgorithmException{
       String salt="Site001";
       s+=salt;
       MessageDigest m=MessageDigest.getInstance("MD5");
       m.update(s.getBytes(),0,s.length());
       return new BigInteger(1,m.digest()).toString(16);
    }
}
