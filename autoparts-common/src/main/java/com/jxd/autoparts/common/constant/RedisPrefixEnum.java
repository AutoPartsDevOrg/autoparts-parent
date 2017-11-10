package com.jxd.autoparts.common.constant;

public enum RedisPrefixEnum {

    USER_TOKEN_PIX("utoken$","登陆后生成的token的前缀标识"),


    ;

    private static String pix;
    private static String describe;


    public String getPix() {
        return pix;
    }

    public String getDescribe() {
        return describe;
    }

    RedisPrefixEnum(String pix, String describe) {
        pix = pix;
        describe = describe;
    }

    public RedisPrefixEnum getVisitMethod(String pix) {
        for (RedisPrefixEnum e : values()) {
            if (e.getPix()==pix)
                return e;
        }
        return null;
    }

    public String key(String key){
        return pix+key;
    }
}
