package com.jelly.shiroMySQLDemo.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jelly-liu on 2016/10/15.
 */
public class MyAuthorizingRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(MyAuthorizingRealm.class);

    private Set<String> userNameSet = new HashSet();
    private Map<String, String> userPasswordMap = new HashMap();
    private Map<String, String> userRolesMap = new HashMap();
    private Map<String, String> userPermissionMap = new HashMap();

    {
        userNameSet.add("adminSuper");
        userNameSet.add("adminList");
        userNameSet.add("adminAdd");
        userNameSet.add("adminDelete");

        //password is 123, salt is abc
        userPasswordMap.put("adminSuper", "e99a18c428cb38d5f260853678922e03");
        userPasswordMap.put("adminList", "e99a18c428cb38d5f260853678922e03");
        userPasswordMap.put("adminAdd", "e99a18c428cb38d5f260853678922e03");
        userPasswordMap.put("adminDelete", "e99a18c428cb38d5f260853678922e03");

        userRolesMap.put("adminSuper", "roleSuper, roleList, roleAdd, roleDelete");
        userRolesMap.put("adminList", "roleList");
        userRolesMap.put("adminAdd", "roleAdd");
        userRolesMap.put("adminDelete", "roleDelete");

//        userPermissionMap.put("adminSuper", "*");
        userPermissionMap.put("adminSuper", "admin:list, admin:add, admin:delete");
        userPermissionMap.put("adminList", "admin:list");
        userPermissionMap.put("adminAdd", "admin:add");
        userPermissionMap.put("adminDelete", "admin:delete");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.fromRealm(this.getName()).iterator().next();
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();

        boolean hasAuthorization = false;
        String role = userRolesMap.get(username);
        String permission = userPermissionMap.get(username);

        if(StringUtils.isNotEmpty(role)){
            hasAuthorization = true;
            String[] roleAry = StringUtils.split(role, ",");
            for(String roleStr : roleAry){
                simpleAuthorInfo.addRole(StringUtils.trim(roleStr));
            }
        }
        if(StringUtils.isNotEmpty(permission)){
            hasAuthorization = true;
            String[] permissionAry = StringUtils.split(permission, ",");
            for(String permissionStr : permissionAry){
                simpleAuthorInfo.addStringPermission(StringUtils.trim(permissionStr));
            }
        }

        if(hasAuthorization){
            return simpleAuthorInfo;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        if(userNameSet.contains(token.getUsername())){
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    token.getUsername(),
                    userPasswordMap.get(token.getUsername()),
                    new SimpleByteSource("abc"),
                    this.getName());
            token.setRememberMe(true);
            return authenticationInfo;
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleHash simpleHash = new SimpleHash("MD5", "123", "abc", 1);
        System.out.println(simpleHash.toString());
        System.out.println((System.currentTimeMillis() + "").length());
    }
}
