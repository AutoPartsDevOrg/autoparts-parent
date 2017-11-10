package com.jxd.autoparts.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    public static Gson create(){
        return new GsonBuilder().disableHtmlEscaping().create();
    }

    public static String toJson(Object obj){
        return create().toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> classOfT){
        return create().fromJson(json,classOfT);
    }

}
