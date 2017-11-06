package com.jxd.autoparts.common.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;

public class DdPwdMgUtil {

    public final static String PRIVATEKEY = "privateKey";
    public final static String PUBLICKEY = "publicKey";

    public final static String DEFAULT_PRIVATEKEY = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAr+a5xAfbg/IpJLczWkXU3CuOeQZ4K1AHaQ0MrLAFAOXyTWViZE8ix42Q6fefsVd1co9CbsTCHchnFzgTwubGWwIDAQABAkBRshE5MIUNhR0Cxmt9U82G7FvhbdXGGAc5DSyDz8SjI2Lk2TutY0VLZfg0s2wm35pWtsrtcbxJrdVPjjKYkbKxAiEA7DBMkR+vP92JhHPwZ+v13RbKf25Q1cKh78IvjhqROYcCIQC+p96pnZVRJ2KjDfWVCpoe37y9t8wIyeHlJTLCMK7xjQIhAOuB7Zb3hQOlny3XfWviOLJPu3L9SNUc0eQEOO71RsGZAiEAkbri+adYMPX38UaERu4ZrCu8qw9ISBd4MZzjVYe80SkCIEfRbb4B4FfselgA8sWid1TC3Yq5tOJiqhvGfoARbx4L";
    public final static String DEFAULT_PUBLICKEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAK/mucQH24PyKSS3M1pF1NwrjnkGeCtQB2kNDKywBQDl8k1lYmRPIseNkOn3n7FXdXKPQm7Ewh3IZxc4E8LmxlsCAwEAAQ==";

    public static Map<String,String> createPrvAndPubKey() throws NoSuchProviderException, NoSuchAlgorithmException {
        String [] keyPair = ConfigTools.genKeyPair(512);
        Map<String,String> m = new HashMap<String,String>();
        m.put(PRIVATEKEY,keyPair[0]);
        m.put(PUBLICKEY,keyPair[1]);
        return m;
    }

    public static String encryptPwd(String password,String privateKey) throws Exception {
        return ConfigTools.encrypt(privateKey, password);
    }

    public static String decryptPwd(String password,String publicKey) throws Exception {
        return ConfigTools.decrypt(publicKey, password);
    }


    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException {
        Map<String,String> m = createPrvAndPubKey();
        System.out.println(m.get(PRIVATEKEY));
        System.out.println(m.get(PUBLICKEY));

        String pwd = "MRyJs0q8l!@#";
        try {
            String ep = encryptPwd(pwd,DEFAULT_PRIVATEKEY);
            System.out.println(ep);
            System.out.println(decryptPwd(ep,DEFAULT_PUBLICKEY));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
