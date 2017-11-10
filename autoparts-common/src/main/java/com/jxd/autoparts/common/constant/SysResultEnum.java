package com.jxd.autoparts.common.constant;

public enum SysResultEnum {

    SUCCESS(1000,"成功"),
    PARAMER_ERROR(2000,"参数错误总称！"),
    TOKEN_IS_NULL(2001,"输入的token不能为空"),
    TOKEN_NOT_EQUALS(2002,"输入token与DB不符"),
    MERACCOUNT_NOT_EXISTENCE(2003,"账号不存在或token已失效"),
    MERACCOUNT_NOT_LOGIN(2004,"用户未登陆"),
    SIGN_VAILD_NOTEQUALS(2005,"签名验证失败"),
    SIGN_VAILD_EXCEPTION(2006,"签名验证异常"),
    FIELD_DECRYPT_EXCEPTION(2007,"字段解密失败"),
    TOKEN_VAILD_EXCEPTION(2008,"登陆token验证异常"),
    GETPERMISSION_BY_TOKEN_FAILED(2009,"根据token获取权限集合失败"),
    GETPERMISSION_BY_TOKEN_EXCEPTION(2010,"根据token获取权限集合异常"),
    PERMISSION_NO_MATCH(2011,"权限无法匹配成功"),

    FAILED(4000,"失败"),
    EXCEPTION(-1,"异常"),
    ;

    private Integer code;
    private String message;


    SysResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static SysResultEnum getVisitMethod(Integer code) {
        for (SysResultEnum e : values()) {
            if (e.getCode()==code)
                return e;
        }
        return null;
    }
}
