package com.jelly.shiroMySQLDemo.service;

import com.jelly.shiroMySQLDemo.model.TPermission;
import com.jelly.shiroMySQLDemo.model.TResource;
import com.jelly.shiroMySQLDemo.model.TRole;
import com.jelly.shiroMySQLDemo.model.TUser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jelly-liu on 2016/10/16.
 */
@Service
public class ShiroService {
    private final String ShiroNameSpace = "Shiro.";

    @Resource
    SqlSessionTemplate sqlSessionTemplate;

    public TUser getUserById(String id){
        return sqlSessionTemplate.selectOne(TUser.SelectByPk, id);
    }

    public TUser getUserByUsername(String username){
        return sqlSessionTemplate.selectOne(TUser.Select, new TUser().setUsername(username));
    }

    public List<TRole> getRoleOfUser(String userId){
        return sqlSessionTemplate.selectList(ShiroNameSpace + "SelectRolesOfUser", userId);
    }

    public List<TPermission> getPermissionsOfUser(String userId){
        return sqlSessionTemplate.selectList(ShiroNameSpace + "SelectPermissionsOfUser", userId);
    }

    public List<TResource> getResourcesOfUser(String userId){
        return sqlSessionTemplate.selectList(ShiroNameSpace + "SelectResourcesOfUser", userId);
    }
}
