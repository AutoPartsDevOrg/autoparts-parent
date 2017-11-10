package com.jxd.autoparts.consumer.request;

import java.io.Serializable;

public class BaseRequest implements Serializable{
	protected String serialNumber;//流水号
	protected String token;		  //登陆token
	protected String sign;		  //签名

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "BaseRequest{" +
				"serialNumber='" + serialNumber + '\'' +
				", token='" + token + '\'' +
				", sign='" + sign + '\'' +
				'}';
	}
}
