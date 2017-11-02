/*
 * AES加密、解密工具
 *
 */
package com.jxd.autoparts.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

/**
 * <p>
 * 
 * 采用AES进行加密和解密
 * 
 * @author daiwei
 */
public class SecurityUtil {
	
	static Log logger = LogFactory.getLog(SecurityUtil.class);
	private static final String CHARSET = "UTF-8";


	private static String PASSWORD = "feixin_icmcc_password";//默认的密钥

	
	/** 设置密钥 **/
	public void setPassword(String password){
		PASSWORD = password;
	}
	
	
	/**
	 * 返回字节数组-加密
	 * @return 
	 */  
	private static byte[] encrypt(String content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			 SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
             secureRandom.setSeed(password.getBytes(CHARSET));
             kgen.init(128,secureRandom);
             SecretKey secretKey =  kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes(CHARSET);
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result;
		} catch (Exception e) {
			logger.error("对明文加密的时候发生异常:", e);
		}
		return null;
	}
	
	
	
	
	/**
	 * 返回字节数组-解密
	 * @return 
	 */ 
	private static byte[] decrypt(byte[] content, String password) {  
	        try {  
	                 KeyGenerator kgen = KeyGenerator.getInstance("AES"); 
	                 SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
	                 secureRandom.setSeed(password.getBytes(CHARSET));
	                 kgen.init(128,secureRandom);
	                 SecretKey secretKey =  kgen.generateKey();
	                 byte[] enCodeFormat = secretKey.getEncoded();  
	                 SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");              
	                 Cipher cipher = Cipher.getInstance("AES");// 创建密码器   
	                cipher.init(Cipher.DECRYPT_MODE, key);// 初始化   
	                byte[] result = cipher.doFinal(content);  
	                return result; // 加密   
	        } catch (Exception e) {  
	           logger.error("解析密文的时候发生异常:", e);
	        }
	        return null;  
	}
	
	/**
	 * 将二进制转换成16进制 
	 * @return 
	 */  
	public static String byte2HexStr(byte buf[]) {  
	        StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < buf.length; i++) {  
	                String hex = Integer.toHexString(buf[i] & 0xFF);  
	                if (hex.length() == 1) {  
	                        hex = '0' + hex;  
	                }  
	                sb.append(hex.toUpperCase());  
	        }  
	        return sb.toString();  
	} 
	
	
	/**
	 * 将16进制转换为二进制 
	 * @return 
	 */  
	public static byte[] hexStr2Byte(String hexStr) {  
	        if (hexStr.length() < 1)  
	                return null;  
	        byte[] result = new byte[hexStr.length()/2];  
	        for (int i = 0;i< hexStr.length()/2; i++) {  
	                int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
	                int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
	                result[i] = (byte) (high * 16 + low);  
	        }  
	        return result;  
	} 
	
	/**
	 * 通过明文获取密文
	 * 
	 * @param content 明文
	 * @return 密文
	 */
	public static String getCiphertext(String content, String password){
		if(content==null){
			return  "";
		}
		byte[] bytes = encrypt(content, password);
		if(bytes==null || bytes.length==0){
			return "";
		}
		return byte2HexStr(bytes);
	}
	
	/**
	 * 通过明文获取密文
	 * 
	 * @param content 明文
	 * @return 密文
	 */
	public static String getCiphertext(String content){
		return getCiphertext(content, PASSWORD);
	}
	
	/**
	 * 通过密文获取明文
	 * 
	 * @param content 密文
	 * @return 明文
	 */
	public static String parseCiphertext(String ciphertext, String password){
		if(ciphertext==null || ciphertext.trim().equals("")){
			return "";
		}
		byte[] bytes = decrypt(hexStr2Byte(ciphertext), password);
		try {
            return new String(bytes, CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 通过密文获取明文
	 * 
	 * @param content 密文
	 * @return 明文
	 */
	public static String parseCiphertext(String ciphertext){
		return parseCiphertext(ciphertext, PASSWORD);
	}

	
	public static void main(String[] args) {
		//System.out.println(parseCiphertext("BA070DA8271D20D07B1C38EB6271D0CF"));
		String ss = getCiphertext("jdbc:mysql://192.168.251.157:3306/rcs_icm?useUnicode=true&amp;characterEncoding=utf-8&amp;autoReconnect=true","feixin_icmcc_password");
		System.out.println(ss);
		//System.out.println(parseCiphertext("BA9DB33EF77060E4EDD6416CA61228A3","js_feixin_icmcc_7894722"));
		
		System.out.println(parseCiphertext("BA070DA8271D20D07B1C38EB6271D0CF"));
		//System.out.println(parseCiphertext("D51648309F7929875BDF13B490339B63"));
		//System.out.println(parseCiphertext("0EFDAAA32AC53EBDE85201BA9670B6BD0BDCE65A90447D06ED7D45AAF9FB5B9A699AE2A8A3B96F55BC2E5C4546C993DDC2AAE84AD66DAF3F5F3B682991DD74A2E64EF8234DEBFD51F6AA562F353AB23FFBAFD5A4B88BF22B5D825317442E9D59978F18EB036D9FE2F7D20218533B406F12AF95D5E741E727103CBDB346F94135647E9F11F1DD3C1497970529175F1C4F"));
		
	}
}
