package com.jike.pwd;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 对称加密
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年04月28日 14:16:00
 */
public class DesAesDemo {

    public static void main(String[] args)  throws Exception{
        //原文
        String str = "五一节放假";
        //密钥
        String key = "12345678";
        //算法
        String transformation = "DES";
        //加密类型
        String algorithm = "DES";

        String encryptDES = encryptDES(str, key, transformation, algorithm);
        System.out.println(encryptDES);

        String decryptDES = decryptDES(encryptDES, key, transformation, algorithm);
        System.out.println(decryptDES);

    }

    /**
     * @param str            原文
     * @param key            密钥
     * @param transformation 获取Cipher对象算法
     * @param algorithm      获取密钥的算法
     * @return 密文
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    private static String encryptDES(String str, String key, String transformation, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //获取加密对象
        Cipher cipher = Cipher.getInstance(transformation);
        //创建加密算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        //初始化机密模式和算法
        cipher.init(Cipher.ENCRYPT_MODE, sks);//加密
        //加密
        byte[] bytes = cipher.doFinal(str.getBytes());
        //转码
        byte[] encode = Base64.getEncoder().encode(bytes);
        return new String(encode);
    }

    /**
     * 解密
     * @param encryptDES
     * @param key
     * @param transformation
     * @param algorithm
     * @return
     */
    private static String decryptDES(String encryptDES, String key, String transformation, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //获取加密对象
        Cipher cipher = Cipher.getInstance(transformation);
        //创建加密算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        //初始化机密模式和算法
        cipher.init(Cipher.DECRYPT_MODE, sks);//解密
        //转码
        byte[] encode = Base64.getDecoder().decode(encryptDES);
        //加密
        byte[] bytes = cipher.doFinal(encode);
        return new String(bytes);
    }

}
