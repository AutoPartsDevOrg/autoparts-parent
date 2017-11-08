package com.jxd.autoparts.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * MD5加密工具
 * 
 * @author Administrator
 */
public final class MD5Util {

	/**
	 * md5加密
	 * @param md5Map
	 * @param md5ReqMap
	 * @return
	 * @throws
	 */
	public static String getMD5Info(String[] md5Map,String[] md5ReqMap,String md5Key){
		MD5 md5 = new MD5();
        Map<String, String> map = new LinkedHashMap<String,String>();
        for (int i = 0; i < md5ReqMap.length; i++) {
            map.put(md5ReqMap[i], md5Map[i]);
        }
        StringBuffer b = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()){
            b.append(entry.getKey());
            b.append('=');
            if (entry.getValue() != null){
                b.append(entry.getValue());
            }
            b.append("&");
        }
        String strBeforeMd5 = b.toString() + md5.getMD5ofStr(md5Key);
        try {
			strBeforeMd5 = new String(strBeforeMd5.toString().getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return md5.getMD5ofStr(strBeforeMd5);
	}
}
