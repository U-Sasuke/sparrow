package priv.yq.sparrow.util;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class EncryptUtil {

    private static final String ENCRYPT_TYPE = "SHA-256";
    private static final String SALT_TYPE = "SHA1PRNG";

    public static void main(String[] args) throws Exception{
        String s=getSalt();
        System.out.println(s);
        System.out.println(getEncryptPassword("ddadwa",s));
        //6024a2505283d040e34ad1a5caad09bcd038069e48f7bdecff913a42aa498f20
    }

    public static String getEncryptPassword(String password, String salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance(ENCRYPT_TYPE);
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }


    public static String getSalt() throws Exception {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

}
