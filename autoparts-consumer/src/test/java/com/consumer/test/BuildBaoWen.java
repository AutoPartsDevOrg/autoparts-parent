package com.consumer.test;

import com.google.gson.Gson;
import com.jxd.autoparts.common.utils.DesUtil;
import com.jxd.autoparts.common.utils.GsonUtils;
import com.jxd.autoparts.common.utils.MD5Util;
import com.jxd.autoparts.common.utils.RespBodyUtils;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

public class BuildBaoWen {

    private static final String MD5KEY = "123456";

    @Test
    public void test1() throws Exception {

        String serialNumber = new Date().getTime()+"";
        String token = UUID.randomUUID().toString().replace("-","");
        token = DesUtil.encrypt(token);
        String sign = MD5Util.getMD5Info("token="+token,MD5KEY);

        RespBodyUtils.RespMap map = RespBodyUtils.createRespMap().put("serialNumber",serialNumber).put("token",token).put("sign",sign);

        String json = GsonUtils.toJson(map);
        System.out.println(json);
    }


    @Test
    public void test2() throws Exception {

        System.out.println(MD5Util.getMD5Info("aaa","m0p1w2cc"));

        String serialNumber = new Date().getTime()+"";
        String username = DesUtil.encrypt("aaa");
        String password = DesUtil.encrypt("ccc");
        System.out.println(username);
        String sign = MD5Util.getMD5Info("username="+username+"&password="+password,MD5KEY);

        RespBodyUtils.RespMap map = RespBodyUtils.createRespMap().put("serialNumber",serialNumber)
                .put("username",username).put("password",password).put("sign",sign);

        String json = GsonUtils.toJson(map);
        System.out.println(json);
    }

    @Test
    public void test3() throws Exception {

        String serialNumber = new Date().getTime()+"";
        String token = DesUtil.encrypt("28af0aa4586d4212b8ff34cb3b9ae50d");
        String oldpwd = DesUtil.encrypt("aaa");
        String newpwd = DesUtil.encrypt("ccc");
        String sign = MD5Util.getMD5Info("oldPwd="+oldpwd+"&newPwd="+newpwd+"&token="+token,MD5KEY);

        RespBodyUtils.RespMap map = RespBodyUtils.createRespMap().put("serialNumber",serialNumber)
                .put("oldPwd",oldpwd).put("newPwd",newpwd).put("token",token).put("sign",sign);

        String json = GsonUtils.toJson(map);
        System.out.println(json);
    }

}
