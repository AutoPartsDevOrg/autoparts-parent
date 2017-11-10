package com.jxd.autoparts.provider.impl;

import com.google.gson.Gson;
import com.jxd.autoparts.api.interfaces.IMerAccoutService;
import com.jxd.autoparts.api.pojo.*;
import com.jxd.autoparts.common.constant.RedisPrefixEnum;
import com.jxd.autoparts.common.entity.MerAccountEntity;
import com.jxd.autoparts.common.entity.SysFunctionEntity;
import com.jxd.autoparts.common.entity.SysMenusEntity;
import com.jxd.autoparts.common.entity.SysRoleEntity;
import com.jxd.autoparts.common.repository.MerAccountRepository;
import com.jxd.autoparts.common.repository.SysFunctionRepository;
import com.jxd.autoparts.common.repository.SysMenusRepository;
import com.jxd.autoparts.common.repository.SysRoleRepository;
import com.jxd.autoparts.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service("merAccoutService")
public class MerAccoutServiceImpl implements IMerAccoutService {

    @Autowired
    private MerAccountRepository merAccountRepository;
    @Autowired
    private SysFunctionRepository sysFunctionRepository;
    @Autowired
    private SysMenusRepository sysMenusRepository;
    @Autowired
    private SysRoleRepository sysRoleRepository;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    private static  final  String MD5KEY = "m0p1w2cc";

    @Transactional
    @Override
    public MerAccountPj findByUtoken(String utoken) {
        MerAccountEntity entity = merAccountRepository.findByUtoken(utoken);
        return entity==null? null : new MerAccountPj(entity);
    }

    @Transactional
    @Override
    public MerAccountPj findByUtoken(String utoken, Integer status) {
        MerAccountEntity entity = merAccountRepository.findByUtoken(utoken,status);
        return entity==null? null : new MerAccountPj(entity);
    }

    @Transactional
    @Override
    public Map<String, Object> getRMFByMeraccId(Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        MerAccountEntity account = merAccountRepository.findOne(id);
        if(account!=null){
            result.put("account",account);
            result.put("merchant",account.getMerchantInfoByMerchantId());

            List<SysRoleEntity> roles = sysRoleRepository.findRolesByMerAccId(id);
            if(roles!=null && roles.size()>0){
                result.put("roles",roles);
                List<Long> roleIds = new ArrayList<Long>();
                for(SysRoleEntity role : roles){
                    roleIds.add(role.getId());
                }
                List<SysMenusEntity> menus = sysMenusRepository.findMenusByRolesIDs(roleIds);
                List<SysFunctionEntity> functions = sysFunctionRepository.findFunctionsByRolesIDs(roleIds);
                result.put("menus",menus);
                result.put("functions",functions);
            }
        }
        return result;
    }

    @Transactional
    @Override
    public Map<String, Object> getRMFByUtoken(String utoken) {
        Map<String, Object> result = new HashMap<String, Object>();
        MerAccountEntity account = merAccountRepository.findByUtoken(utoken);
        if(account!=null){
            result.put("account",account);
            result.put("merchant",account.getMerchantInfoByMerchantId());

            List<SysRoleEntity> roles = sysRoleRepository.findRolesByUtoken(utoken);
            if(roles!=null && roles.size()>0){
                result.put("roles",roles);
                List<Long> roleIds = new ArrayList<Long>();
                for(SysRoleEntity role : roles){
                    roleIds.add(role.getId());
                }
                List<SysMenusEntity> menus = sysMenusRepository.findMenusByRolesIDs(roleIds);
                List<SysFunctionEntity> functions = sysFunctionRepository.findFunctionsByRolesIDs(roleIds);
                result.put("menus",menus);
                result.put("functions",functions);
            }
        }
        return result;
    }

    @Transactional
    @Override
    public MerAccRoleMenuFunPj getRMFPjByMeraccId(Long id) {
        MerAccRoleMenuFunPj result = new MerAccRoleMenuFunPj();
        MerAccountEntity account = merAccountRepository.findOne(id);

        if(account!=null){
            result.setAccount(new MerAccountPj(account));
            result.setMerchant(new MerchantInfoPj(account.getMerchantInfoByMerchantId()));

            List<SysRoleEntity> roles = sysRoleRepository.findRolesByMerAccId(id);
            if(roles!=null && roles.size()>0){
                List<Long> roleIds = new ArrayList<Long>();
                for(SysRoleEntity role : roles){
                    roleIds.add(role.getId());
                    result.getRoles().add(new SysRolePj(role));
                }
                List<SysMenusEntity> menus = sysMenusRepository.findMenusByRolesIDs(roleIds);
                if(menus!=null && menus.size()>0){
                    for(SysMenusEntity menu : menus){
                        result.getMeuns().add(new SysMenusPj(menu));
                    }
                }
                List<SysFunctionEntity> functions = sysFunctionRepository.findFunctionsByRolesIDs(roleIds);
                if(functions!=null && functions.size()>0){
                    for(SysFunctionEntity fun : functions){
                        result.getFunctions().add(new SysFunctionPj(fun));
                    }
                }
            }
        }
        return result;
    }

    @Transactional
    @Override
    public MerAccRoleMenuFunPj getRMFPjByUtoken(String utoken) {
        MerAccRoleMenuFunPj result = new MerAccRoleMenuFunPj();
        MerAccountEntity account = merAccountRepository.findByUtoken(utoken);

        if(account!=null){
            result.setAccount(new MerAccountPj(account));
            result.setMerchant(new MerchantInfoPj(account.getMerchantInfoByMerchantId()));

            List<SysRoleEntity> roles = sysRoleRepository.findRolesByUtoken(utoken);
            if(roles!=null && roles.size()>0){
                List<Long> roleIds = new ArrayList<Long>();
                for(SysRoleEntity role : roles){
                    roleIds.add(role.getId());
                    result.getRoles().add(new SysRolePj(role));
                }
                List<SysMenusEntity> menus = sysMenusRepository.findMenusByRolesIDs(roleIds);
                if(menus!=null && menus.size()>0){
                    for(SysMenusEntity menu : menus){
                        result.getMeuns().add(new SysMenusPj(menu));
                    }
                }
                List<SysFunctionEntity> functions = sysFunctionRepository.findFunctionsByRolesIDs(roleIds);
                if(functions!=null && functions.size()>0){
                    for(SysFunctionEntity fun : functions){
                        result.getFunctions().add(new SysFunctionPj(fun));
                    }
                }
            }
        }
        return result;
    }

    @Transactional
    @Override
    public MerAccountPj login(String username, String password) {
        MerAccountEntity account = merAccountRepository.findByUsernameAndPassword(username,MD5Util.getMD5Info(password,MD5KEY));
        if(account!=null && account.getStatus()==1){
            //登陆成功
            //1.生成新的utoken
            String newToken = UUID.randomUUID().toString().replace("-","");
            //2.清除缓存中的utoken值
            stringRedisTemplate.delete(RedisPrefixEnum.USER_TOKEN_PIX.key(account.getUtoken()));
            //3.更新数据库
            account.setUtoken(newToken);
            //查询权限
            MerAccRoleMenuFunPj marmf = getRMFPjByMeraccId(account.getId());
            if(marmf!=null){
                //保存权限到缓存使用新的key
                stringRedisTemplate.opsForValue().set(RedisPrefixEnum.USER_TOKEN_PIX.key(newToken),new Gson().toJson(marmf));
            }
        }
        return account==null? null : new MerAccountPj(account);
    }

    @Transactional
    @Override
    public boolean loginout(String utoken) {
        stringRedisTemplate.delete(RedisPrefixEnum.USER_TOKEN_PIX.key(utoken));
        int n = merAccountRepository.updateUToken(utoken,null);
        if(n>0){
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean loginout(Long id) {
        MerAccountEntity account = merAccountRepository.findOne(id);
        if(account!=null){
            stringRedisTemplate.delete(RedisPrefixEnum.USER_TOKEN_PIX.key(account.getUtoken()));
            account.setUtoken(null);
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    @Override
    public boolean modifyPwd(String utoken, String newPwd) {
        int n = merAccountRepository.updatePwd(utoken,MD5Util.getMD5Info(newPwd,MD5KEY));
        if(n>0){
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean modifyPwd(Long id, String newPwd) {
        int n = merAccountRepository.updatePwd(id,MD5Util.getMD5Info(newPwd,MD5KEY));
        if(n>0){
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean oldPwdIsRight(String utoken, String oldPwd) {
        MerAccountEntity account = merAccountRepository.findByUtoken(utoken);
        if(account!=null && account.getPassword().equals(MD5Util.getMD5Info(oldPwd,MD5KEY))){
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean oldPwdIsRight(Long id, String oldPwd) {
        MerAccountEntity account = merAccountRepository.findOne(id);
        if(account!=null && account.getPassword().equals(MD5Util.getMD5Info(oldPwd,MD5KEY))){
            return true;
        }
        return false;
    }
}
