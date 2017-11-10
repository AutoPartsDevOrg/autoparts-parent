package com.jxd.autoparts.common.constant;

public enum VisitMethodEnum {

    DEFAULT_ACCESS("0","默认访问","不受方法访问权限限制"),

    METHOD_MODIFY_PASSWORD("modify_password","密码修改",""),
    ;

    private String code;
    private String name;
    private String desc;


    VisitMethodEnum(String code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static VisitMethodEnum getVisitMethod(String code) {
        for (VisitMethodEnum e : values()) {
            if (e.getCode().equals(code))
                return e;
        }
        return null;
    }
}
