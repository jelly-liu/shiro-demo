package com.jelly.shiroMySQLDemo.shiro;

import com.jelly.shiroMySQLDemo.model.TPermission;
import com.jelly.shiroMySQLDemo.model.TRole;
import com.jelly.shiroMySQLDemo.model.TUser;
import com.jelly.shiroMySQLDemo.service.ShiroService;
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

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jelly-liu on 2016/10/15.
 */
public class MyAuthorizingRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(MyAuthorizingRealm.class);

    @Resource
    ShiroService shiroService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String userId = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();

        //load roles and permissions
        List<TRole> roleList = shiroService.getRoleOfUser(userId);
        List<TPermission> permissionList = shiroService.getPermissionsOfUser(userId);

        if(roleList != null && roleList.size() > 0){
            for(TRole role : roleList){
                simpleAuthorInfo.addRole(StringUtils.trim(role.getRoName()));
            }
        }
        if(permissionList != null && permissionList.size() > 0){
            for(TPermission permission : permissionList){
                simpleAuthorInfo.addStringPermission(StringUtils.trim(permission.getPeName()));
            }
        }

        return simpleAuthorInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

        //only do check out user is exit or not, do not need do password matching
        TUser user = shiroService.getUserByUsername(token.getUsername());
        if(user == null){
            return null;
        }

        //pick out stored password and salt to AuthenticationInfo
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getId(),//at here, set an unique principal
                user.getPassword(),
                new SimpleByteSource(user.getSalt()),
                this.getName());
        return authenticationInfo;
    }

    public static void main(String[] args) {
        SimpleHash simpleHash = new SimpleHash("MD5", "123", "abc", 1);
        System.out.println(simpleHash.toString());
        System.out.println((System.currentTimeMillis() + "").length());
    }
}
