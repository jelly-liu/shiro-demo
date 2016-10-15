package com.jelly.shiroMySQLDemo.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jelly-liu on 2016/10/15.
 */
public class MyRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(MyRealm.class);

    private Set<String> userNameSet = new HashSet();
    private Map<String, String> userPasswordMap = new HashMap();
    private Map<String, String> userRolesMap = new HashMap();
    private Map<String, String> userPermissionMap = new HashMap();

    {
        userNameSet.add("adminSuper");
        userNameSet.add("adminList");
        userNameSet.add("adminAdd");
        userNameSet.add("adminDelete");

        userPasswordMap.put("adminSuper", "123");
        userPasswordMap.put("adminList", "123");
        userPasswordMap.put("adminAdd", "123");
        userPasswordMap.put("adminDelete", "123");

        userRolesMap.put("adminSuper", "roleSuper");
        userRolesMap.put("adminList", "roleList");
        userRolesMap.put("adminAdd", "roleAdd");
        userRolesMap.put("adminDelete", "roleDelete");

        userPermissionMap.put("adminSuper", "*");
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
            simpleAuthorInfo.addRole(role);
        }
        if(StringUtils.isNotEmpty(permission)){
            hasAuthorization = true;
            simpleAuthorInfo.addStringPermission(permission);
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
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(token.getUsername(), userPasswordMap.get(token.getUsername()), this.getName());
            return authenticationInfo;
        }
        return null;
    }
}
