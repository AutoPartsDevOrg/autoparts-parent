package com.jxd.autoparts.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.rrtx.card.db.table.mapper.PubMerPayConfigMapper;
import com.rrtx.card.db.table.model.PubMerPayConfig;
import com.rrtx.card.exception.BusinessCodeException;
import com.rrtx.fap.frame.exception.FAPBusinessException;
import com.rrtx.fap.frame.service.base.IFAPDataBaseService;
import com.rrtx.fap.frame.util.Service;


/**
 * MD5加密工具
 * 
 * @author Administrator
 */
public final class MD5Util {
	/**
	 * 加密字符串
	 * 
	 * @param source
	 *            字符串
	 * @return 加密后的字符串
	 */
	public final static String MD5(String source) {
		StringBuffer reStr = null;
		try {
			java.security.MessageDigest alga = java.security.MessageDigest.getInstance("MD5");
			byte[] bs = alga.digest(source.getBytes());
			reStr = new StringBuffer();
			for (int i = 0; i < bs.length; i++) {
				reStr.append(byteHEX(bs[i]));
			}
		} catch (Exception ex) {
		}
		return reStr == null ? null : reStr.toString();
	}

	/**
	 * 比较
	 * 
	 * @param a
	 *            String
	 * @param b
	 *            String
	 * @return boolean
	 */
	public static boolean compare(String a, String b) {
		boolean flag = false;
		if (a == b) {
			return true;
		}
		try {
			java.security.MessageDigest alga = java.security.MessageDigest.getInstance("MD5");
			flag = alga.isEqual(a.getBytes(), MD5(b).getBytes());
		} catch (Exception ex) {
		}
		return flag;
	}

	/**
	 * 进行md5字符中的比较
	 * 
	 * @param md5a
	 *            String
	 * @param md5b
	 *            String
	 * @return boolean
	 */
	public static boolean compareMD5(String md5a, String md5b) {
		boolean flag = false;
		if (md5a == md5b) {
			return true;
		}
		try {
			java.security.MessageDigest alga = java.security.MessageDigest.getInstance("MD5");
			flag = alga.isEqual(md5a.getBytes(), md5b.getBytes());
		} catch (Exception ex) {
		}

		return flag;
	}

	/*
	 * byteHEX()，用来把一个byte类型的数转换成十六进制的ASCII表示，
	 * 　因为java中的byte的toString无法实现这一点，我们又没有C语言中的
	 * sprintf(outbuf,"%02X",ib)
	 */
	public static String byteHEX(byte ib) {
		char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}
	
	/**
	 * md5加密
	 * @param md5Map
	 * @param md5ReqMap
	 * @return
	 * @throws FAPBusinessException 
	 */
	public static String getMD5Info(String[] md5Map,String[] md5ReqMap) throws FAPBusinessException{
		MD5 md5 = new MD5();
        Map<String, String> map = new TreeMap<String, String>();
        
        PubMerPayConfig config = Service.lookup(IFAPDataBaseService.class).selectByPrimaryKey(PubMerPayConfigMapper.class,"1");
        if(config==null){
        	throw new BusinessCodeException("系统参数错误");//MD5验签失败
        }
        String MD5key =config.getMd5Key();
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
        String strBeforeMd5 = b.toString() + md5.getMD5ofStr(MD5key);
		return md5.getMD5ofStr(strBeforeMd5);
	}
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
