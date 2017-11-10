package com.jxd.autoparts.consumer.Controller;

import com.jxd.autoparts.api.interfaces.IMerAccoutService;
import com.jxd.autoparts.api.pojo.MerAccountPj;
import com.jxd.autoparts.common.constant.SysResultEnum;
import com.jxd.autoparts.common.constant.VisitMethodEnum;
import com.jxd.autoparts.common.entity.MerAccountEntity;
import com.jxd.autoparts.common.utils.RespBodyUtils;
import com.jxd.autoparts.consumer.helper.annotation.Sercurity;
import com.jxd.autoparts.consumer.reponse.BaseResponse;
import com.jxd.autoparts.consumer.request.BaseRequest;
import com.jxd.autoparts.consumer.request.LoginRequest;
import com.jxd.autoparts.consumer.request.ModifyPwdRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/meraccount")
public class MerAccoutContr {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private static final String MD5KEY = "009987";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IMerAccoutService merAccoutService;


    @Sercurity(sign ={"username","password"}, method = VisitMethodEnum.DEFAULT_ACCESS)
    @RequestMapping(value="/login", headers="Content-Type=application/json", produces="application/json", method= RequestMethod.POST)
    public BaseResponse login(@RequestBody LoginRequest requestObj, HttpServletRequest request)
            throws Exception {

        BaseResponse resp = new BaseResponse();
        resp.setSerialNumber(requestObj.getSerialNumber());
        try {
            MerAccountPj accountPj = merAccoutService.login(requestObj.getUsername(),requestObj.getPassword());
            if(accountPj!=null && accountPj.getStatus()==1){
                resp.setResult(SysResultEnum.SUCCESS.getCode());
                resp.setMessage("登陆成功");
                resp.setBody(RespBodyUtils.createRespMap().put("token",accountPj.getUtoken()));
            }else{
                resp.setResult(SysResultEnum.FAILED.getCode());
                resp.setMessage("登陆失败,用户不存在或不可用");
            }
        } catch (Exception e) {
            LOGGER.error("================>>>>登陆(login)接口异常！{}", e);
            resp.setResult(SysResultEnum.EXCEPTION.getCode());
            resp.setMessage("登陆发生异常");
        }
        return resp;
    }

    @Sercurity(sign ={"token"}, method = VisitMethodEnum.DEFAULT_ACCESS)
    @RequestMapping(value="/loginout", headers="Content-Type=application/json", produces="application/json")
    public BaseResponse loginout(@RequestBody BaseRequest requestObj, HttpServletRequest request)
            throws Exception {

        BaseResponse resp = new BaseResponse();
        resp.setSerialNumber(requestObj.getSerialNumber());
        try {
            if(merAccoutService.loginout(requestObj.getToken())){
                resp.setResult(SysResultEnum.SUCCESS.getCode());
                resp.setMessage("登出成功");
            }else{
                resp.setResult(SysResultEnum.FAILED.getCode());
                resp.setMessage("登出失败");
            }
        } catch (Exception e) {
            LOGGER.error("================>>>>登出(loginout)接口异常！{}", e);
            resp.setResult(SysResultEnum.EXCEPTION.getCode());
            resp.setMessage("登出发生异常");
        }
        return resp;
    }

    @Sercurity(sign ={"oldPwd","newPwd","token"}, method = VisitMethodEnum.DEFAULT_ACCESS)
    @RequestMapping(value="/modifyPwd", headers="Content-Type=application/json", produces="application/json", method= RequestMethod.POST)
    public BaseResponse modifyPwd(@RequestBody ModifyPwdRequest requestObj, HttpServletRequest request)
            throws Exception {

        BaseResponse resp = new BaseResponse();
        resp.setSerialNumber(requestObj.getSerialNumber());

        if(StringUtils.isEmpty(requestObj.getNewPwd()) || StringUtils.isEmpty(requestObj.getOldPwd()) ){
            resp.setResult(SysResultEnum.FAILED.getCode());
            resp.setMessage("新旧密码输入不能为空！");
            return resp;
        }

        if(requestObj.getNewPwd().equals(requestObj.getOldPwd())){
            resp.setResult(SysResultEnum.FAILED.getCode());
            resp.setMessage("新旧密码不能相同！");
            return resp;
        }
        try {
            if(!merAccoutService.oldPwdIsRight(requestObj.getToken(),requestObj.getOldPwd())){
                resp.setResult(SysResultEnum.FAILED.getCode());
                resp.setMessage("旧密码输入错误！");
                return resp;
            }
            if(merAccoutService.modifyPwd(requestObj.getToken(),requestObj.getNewPwd())){
                resp.setResult(SysResultEnum.SUCCESS.getCode());
                resp.setMessage("密码修改成功");
            }else{
                resp.setResult(SysResultEnum.FAILED.getCode());
                resp.setMessage("密码修改失败");
            }
        } catch (Exception e) {
            LOGGER.error("================>>>>修改密码(modifyPwd)接口异常！{}", e);
            resp.setResult(SysResultEnum.EXCEPTION.getCode());
            resp.setMessage("密码修改发生异常");
        }
        return resp;
    }
}
