package com.jxd.autoparts.api.pojo;

import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class BasePj implements Serializable {

    public BasePj(){

    }

    public void copy(Object dest,Object orig){
        try {
            if(orig!=null){
                BeanUtils.copyProperties( dest,  orig);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
