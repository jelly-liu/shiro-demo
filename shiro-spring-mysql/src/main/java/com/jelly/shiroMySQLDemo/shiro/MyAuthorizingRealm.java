package com.jelly.shiroMySQLDemo.shiro;

import com.jelly.shiroMySQLDemo.model.TPermission;
import com.jelly.shiroMySQLDemo.model.TRole;
import com.jelly.shiroMySQLDemo.service.ShiroService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jelly-liu on 2016/10/15.
 */
public class MyAuthorizingRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(MyAuthorizingRealm.class);

    @Resource
    ShiroService shiroService;

    /*private Set<String> userNameSet = new HashSet();
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
    }*/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userId = (String)principalCollection.fromRealm(this.getName()).iterator().next();
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();

        boolean hasAuthorization = false;

        List<TRole> roleList = shiroService.getRoleOfUser(userId);
        List<TPermission> permissionList = shiroService.getPermissionsOfUser(userId);

        if(roleList != null && roleList.size() > 0){
            hasAuthorization = true;
            for(TRole role : roleList){
                simpleAuthorInfo.addRole(StringUtils.trim(role.getRoName()));
            }
        }
        if(permissionList != null && permissionList.size() > 0){
            hasAuthorization = true;
            for(TPermission permission : permissionList){
                simpleAuthorInfo.addStringPermission(StringUtils.trim(permission.getPeName()));
            }
        }

        if(hasAuthorization){
            return simpleAuthorInfo;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        MyUsernamePasswordToken token = (MyUsernamePasswordToken)authenticationToken;
        if(token.getUser() == null){
            return null;
        }

        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                token.getUser().getId(),
                token.getUser().getPassword(),
                new SimpleByteSource(token.getUser().getSalt()),
                this.getName());
        return authenticationInfo;
    }

    public static void main(String[] args) {
        SimpleHash simpleHash = new SimpleHash("MD5", "123", "abc", 1);
        System.out.println(simpleHash.toString());
        System.out.println((System.currentTimeMillis() + "").length());
    }
}
