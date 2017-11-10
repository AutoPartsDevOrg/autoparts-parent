package com.jxd.autoparts.consumer.helper.aop;

import com.jxd.autoparts.api.interfaces.IMerAccoutService;
import com.jxd.autoparts.api.pojo.MerAccRoleMenuFunPj;
import com.jxd.autoparts.api.pojo.MerAccountPj;
import com.jxd.autoparts.api.pojo.SysFunctionPj;
import com.jxd.autoparts.common.constant.RedisPrefixEnum;
import com.jxd.autoparts.common.constant.SysResultEnum;
import com.jxd.autoparts.common.constant.VisitMethodEnum;
import com.jxd.autoparts.common.utils.DesUtil;
import com.jxd.autoparts.common.utils.GsonUtils;
import com.jxd.autoparts.common.utils.MD5Util;
import com.jxd.autoparts.consumer.helper.annotation.Sercurity;
import com.jxd.autoparts.consumer.reponse.BaseResponse;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@Aspect
@Component
public class SercurityAop {

	private static final Logger LOG = LoggerFactory.getLogger(SercurityAop.class);

	private static final String MD5KEY = "123456";

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private IMerAccoutService merAccoutService;

	/**
	 * 
	 * @Title: beforeExec
	 * @Description: 前置通知，在所有标注@Sercurity的地方切入
	 * @param joinPoint
	 * @return void
	 * @throws IOException
	 */
	@Before("@annotation(com.jxd.autoparts.consumer.helper.annotation.Sercurity)")
	public void beforeExec(JoinPoint joinPoint) throws IOException {
	}

	/**
	 * 
	 * @Title: afterExec @Description: 后置通知，在所有标注@Sercurity的地方切入 @param
	 * joinPoint @return void @throws
	 */
	@After("@annotation(com.jxd.autoparts.consumer.helper.annotation.Sercurity)")
	public void afterExec(JoinPoint joinPoint) {
	}

	/**
	 * 在方法出现异常时会执行的代码 可以访问到异常对象，可以指定在出现特定异常时在执行通知代码
	 */
	@AfterThrowing(value = "@annotation(com.jxd.autoparts.consumer.helper.annotation.Sercurity)", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
	}

	/**
	 * 
	 * @Title: aroundExec
	 * @Description: 环绕通知，在所有标注@Sercurity的地方切入
	 * @param pjp
	 * @return void
	 * @throws Throwable
	 */
	@Around("@annotation(com.jxd.autoparts.consumer.helper.annotation.Sercurity)")
	public Object aroundExec(ProceedingJoinPoint pjp) throws Throwable {

		BaseResponse resp = new BaseResponse();

		MethodSignature ms = (MethodSignature) pjp.getSignature();
		String metPath = ms.getName();
		String[] names = ms.getMethod().getAnnotation(Sercurity.class).sign();
		String[] fields = ms.getMethod().getAnnotation(Sercurity.class).field();
		VisitMethodEnum method = ms.getMethod().getAnnotation(Sercurity.class).method();
		if (fields.length == 0)
			fields = names;
		Object[] args = pjp.getArgs();
		Object obj = null;
		HttpServletRequest request = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof HttpServletRequest) {
				request = (HttpServletRequest) args[i];
				continue;
			}
			if (args[i] instanceof HttpServletResponse)
				continue;
			obj = args[i];
		}
		Assert.notNull(obj, "请求" + ms.getMethod().getName()
				+ "方法缺少参数，参数形式：arg0=自定义请求对象，".concat("arg1=HttpServletRequest，arg2=HttpServletResponse"));
		this.parseRequest(request, obj);
		resp.setSerialNumber(getField(obj, "serialNumber"));


		// 验证签名
		if (!validateSign(resp, names, obj))
			return resp;
		// 验证参数加密,同时完成解密后赋值操作
		if (!decrypt(resp, fields, obj))
			return resp;
		if("login".equals(metPath)){
			return pjp.proceed();
		}
		// 登陆验证
		String token = getField(obj, "token");
		if(!validateToken(resp,token)){
			return resp;
		}
		if("loginout".equals(metPath)){
			return pjp.proceed();
		}
		// 权限匹配
		if(!validatePermission(resp, token, method.getCode())){
			return resp;
		}


		return pjp.proceed();
	}

	/**
	 * 判断token是否有效，及判断是否已经登陆
	 * @param resp
	 * @param token
	 * @return
	 */
	private boolean validateToken(BaseResponse resp,String token){
		if(StringUtils.isEmpty(token)){
			resp.setResult(SysResultEnum.TOKEN_IS_NULL.getCode());
			resp.setMessage(SysResultEnum.TOKEN_IS_NULL.getMessage());
			return false;
		}
		//从缓存中获取
		try{
			boolean is = stringRedisTemplate.hasKey(RedisPrefixEnum.USER_TOKEN_PIX.key(token));
			if(is){
				return true;
			}else{
				//从DB获取token值，进行验证
				MerAccountPj merac = merAccoutService.findByUtoken(token,1);
				if(merac==null){
					resp.setResult(SysResultEnum.MERACCOUNT_NOT_EXISTENCE.getCode());
					resp.setMessage(SysResultEnum.MERACCOUNT_NOT_EXISTENCE.getMessage());
					return false;
				}
				if(StringUtils.isEmpty(merac.getUtoken())){
					resp.setResult(SysResultEnum.MERACCOUNT_NOT_LOGIN.getCode());
					resp.setMessage(SysResultEnum.MERACCOUNT_NOT_LOGIN.getMessage());
					return false;
				}
				if(!merac.getUtoken().equals(token)){
					resp.setResult(SysResultEnum.TOKEN_NOT_EQUALS.getCode());
					resp.setMessage(SysResultEnum.TOKEN_NOT_EQUALS.getMessage());
					return false;
				}
				return true;
			}
		}catch (Exception e){
			LOG.error("验证登陆token异常，异常信息：{}", e);

			resp.setResult(SysResultEnum.TOKEN_VAILD_EXCEPTION.getCode());
			resp.setMessage(SysResultEnum.TOKEN_VAILD_EXCEPTION.getMessage());

			return false;
		}

	}


	/**
	 * 
	 * @Title: getPermission @Description: 查询权限信息 @param request @param
	 * obj @param resp @return boolean @throws
	 */
	private boolean validatePermission(BaseResponse resp, String token, String method) {
		try {
			MerAccRoleMenuFunPj pjObj = null;
			//从缓存中获取
			String pjJson =stringRedisTemplate.opsForValue().get(RedisPrefixEnum.USER_TOKEN_PIX.key(token));
			if(!StringUtils.isEmpty(pjJson)){
				 pjObj = GsonUtils.fromJson(pjJson,MerAccRoleMenuFunPj.class);
			}else{
				//从DB中获取
				pjObj = merAccoutService.getRMFPjByUtoken(token);
				//修改缓存
				stringRedisTemplate.opsForValue().set(RedisPrefixEnum.USER_TOKEN_PIX.key(token),GsonUtils.toJson(pjObj));
			}

			if(pjObj==null){
				resp.setResult(SysResultEnum.GETPERMISSION_BY_TOKEN_FAILED.getCode());
				resp.setMessage(SysResultEnum.GETPERMISSION_BY_TOKEN_FAILED.getMessage());
				return false;
			}

			// 判断是否不需要验证
			if(method.equals(VisitMethodEnum.DEFAULT_ACCESS.getCode())){
				return true;
			}
			// 判断请求方法（功能）是否在权限集合中
			if (pjObj.getFunctions()!=null && pjObj.getFunctions().size()>0) {
				for(SysFunctionPj fun : pjObj.getFunctions()){
					if(fun.getVal().equals(method)){
						return true;
					}
				}
			}
			// 经过上次比较不存在，返回失败
			resp.setResult(SysResultEnum.PERMISSION_NO_MATCH.getCode());
			resp.setMessage(SysResultEnum.PERMISSION_NO_MATCH.getMessage());
			return false;

		} catch (Exception e) {
			LOG.error("---------->根据token验证用户权限异常 ！<----------,错误详情：{}", e);
			resp.setResult(SysResultEnum.GETPERMISSION_BY_TOKEN_EXCEPTION.getCode());
			resp.setMessage(SysResultEnum.GETPERMISSION_BY_TOKEN_EXCEPTION.getMessage());
			return false;
		}
	}

	/**
	 * 
	 * @Title: validateSign @Description: 验证签名 @param responseObj @param
	 * password @param names @param obj @return boolean @throws
	 */
	private boolean validateSign(BaseResponse resp,  String[] names, Object obj) {
		StringBuilder sb = new StringBuilder();
		try {
			for (int i = 0; i < names.length; i++) {
				if (i != 0)
					sb.append('&');
				sb.append(names[i]).append('=').append(getField(obj, names[i]));
			}
			LOG.info(sb.toString());
			String sign = MD5Util.getMD5Info(sb.toString(),MD5KEY);
			if (sign.equals(getField(obj, "sign")))
				return true;

			resp.setResult(SysResultEnum.SIGN_VAILD_NOTEQUALS.getCode());
			resp.setMessage(SysResultEnum.SIGN_VAILD_NOTEQUALS.getMessage());

		} catch (Exception e) {
			LOG.error("数字签名验证错误，异常信息：{}", e);

			resp.setResult(SysResultEnum.SIGN_VAILD_EXCEPTION.getCode());
			resp.setMessage(SysResultEnum.SIGN_VAILD_EXCEPTION.getMessage());
		}
		return false;
	}

	/**
	 * 
	 * @Title: decrypt @Description: 解密请求参数 @param responseObj @param
	 * password @param names @param obj @return boolean @throws
	 */
	private boolean decrypt(BaseResponse resp, String[] names, Object obj) {
		String currFiled = "";
		try {
			DesUtil desUtil = new DesUtil();
			for (int i = 0; i < names.length; i++) {
				currFiled = names[i];
				setField(obj, desUtil.decrypt(getField(obj, names[i])), names[i]);
			}
		} catch (Exception e) {
			LOG.error("解密参数异常，错误参数：{},请求参数：{},e={}", currFiled, obj.toString(), e);
			resp.setResult(SysResultEnum.FIELD_DECRYPT_EXCEPTION.getCode());
			resp.setMessage(SysResultEnum.FIELD_DECRYPT_EXCEPTION.getMessage());
			return false;
		}
		return true;
	}

	private void setField(Object obj, String args, String FieldName) {
		try {
			Method[] pMethod = obj.getClass().getSuperclass().getDeclaredMethods();
			for (Method m : pMethod) {
				if (m.getName().equals("set" + getUpperCase(FieldName))) {
					m.invoke(obj, args);
					return;
				}
			}
			Method[] method = obj.getClass().getDeclaredMethods();
			for (Method m : method) {
				if (m.getName().equals("set" + getUpperCase(FieldName))) {
					m.invoke(obj, args);
					return;
				}
			}
		} catch (Exception e) {
			LOG.error("---------->获取{}属性的setter方法异常<----------{}", FieldName, e);
		}
		throw new RuntimeException("未找到" + FieldName + "属性的setter方法");
	}

	private String getField(Object obj, String FieldName) {
		try {
			Method[] pMethod = obj.getClass().getSuperclass().getDeclaredMethods();
			for (Method m : pMethod) {
				if (m.getName().equals("get" + getUpperCase(FieldName)))
					return m.invoke(obj).toString();
			}
			Method[] method = obj.getClass().getDeclaredMethods();
			for (Method m : method) {
				if (m.getName().equals("get" + getUpperCase(FieldName)))
					return m.invoke(obj).toString();
			}
		} catch (Exception e) {
			LOG.error("---------->获取{}属性的getter方法异常<----------{}", FieldName, e);
		}
		throw new RuntimeException("未找到" + FieldName + "属性的getter方法");
	}

	private String getUpperCase(String str) {
		return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
	}

	private void parseRequest(HttpServletRequest request, Object obj) {
		try {
			String reqStr = GsonUtils.toJson(obj);
			request.setAttribute("request", reqStr);
			LOG.info("===========>>>>请求报文：{}", reqStr);
		} catch (Exception e) {
			LOG.error("===========>>>>解析请求参数异常，请求参数{}", obj.toString());
		}
	}

}
