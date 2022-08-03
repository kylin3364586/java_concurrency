package com.jike.pwd;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 *
 * 生成密钥对
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年05月05日 11:01:00
 */
public class RSAdemo {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        //加密算法
        String algorithm = "RSA";
        //密钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        //生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //公钥
        PublicKey aPublic = keyPair.getPublic();
        //私钥
        PrivateKey aPrivate = keyPair.getPrivate();
        byte[] publicEncoded = aPublic.getEncoded();
        byte[] privateEncoded = aPrivate.getEncoded();

        byte[] pu = Base64.getEncoder().encode(publicEncoded);
        byte[] pr = Base64.getEncoder().encode(privateEncoded);
        System.out.println(new String(pu));
        System.out.println(new String(pr));
    }
}
