package priv.yq.sparrow.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class EncryptUtil {

    private static final String ENCRYPT_TYPE = "SHA-256";
    private static final String UTF_8 = "UTF-8";

    /***
     * 利用Apache的工具类实现SHA-256加密
     * @param password 原始密码
     * @param salt 盐
     * @return 密文密码
     */
    public static String encryptSHA256(String password, String salt) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(ENCRYPT_TYPE);
        byte[] hash = messageDigest.digest((password + salt).getBytes(UTF_8));
        return Hex.encodeHexString(hash);
    }

}
