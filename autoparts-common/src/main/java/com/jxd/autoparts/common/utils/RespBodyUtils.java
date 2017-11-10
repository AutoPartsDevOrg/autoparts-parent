package com.jxd.autoparts.common.utils;

import java.util.HashMap;
import java.util.Map;

public class RespBodyUtils {

    public static RespMap createRespMap(){
        return new RespBodyUtils().new RespMap();
    }


    public class RespMap extends HashMap {

        public RespMap(){

        }

        public RespMap put(String key,Object value){
            super.put(key,value);
            return this;
        }

        public Object get(String key){
            return super.get(key);
        }
    }

}
