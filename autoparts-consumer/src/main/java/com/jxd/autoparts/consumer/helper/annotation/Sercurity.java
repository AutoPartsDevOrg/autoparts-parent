package com.jxd.autoparts.consumer.helper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jxd.autoparts.common.constant.VisitMethodEnum;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Sercurity {
	
	/**
	 * 
	 * @Title: sign
	 * @Description: 签名字段，sign中值顺序要和签名顺序保持一致
	 * @return String[]
	 * @throws
	 */
	String[] sign() default {};
	
	/**
	 * 
	 * @Title: field
	 * @Description: 加密的字段，如果不为这个属性赋值，默认加密sign中签名字段
	 * @return String[]
	 * @throws
	 */
	String[] field() default {};
	
	/**
	 * 
	 * @Title: method
	 * @Description: 方法对应的权限值，参考Result枚举类型的“配置访问权限代码”
	 * @return String
	 * @throws
	 */
	VisitMethodEnum method() default VisitMethodEnum.DEFAULT_ACCESS;
}
