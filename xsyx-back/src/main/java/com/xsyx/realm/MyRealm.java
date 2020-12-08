package com.xsyx.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        /*System.out.println("授权方法");
        //从参数中获取用户名
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();   //认证时，第一个参数传递的数据

        //根据用户名查询拥有的角色名(角色id)   userdao.xxxx()
        List<String> roles = userService.queryRoles(userInfo.getUserId());

        //根据用户名查询菜单code(菜单id)      userdao.xxxx()
        List<String> perms = userService.queryMenus(userInfo.getUserId());

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(perms);

        return authorizationInfo;*/
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        /*System.out.println("认证方法");
        //通过token获取用户名
        String username = (String) token.getPrincipal();

        UserInfo userInfo = userService.queryUserByName(username);
        if (userInfo == null) {
            throw new UnknownAccountException("当前帐号不存在！！！");
        }
        return new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), this.getName());*/
        return null;
    }

}
