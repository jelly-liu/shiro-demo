package com.jelly.shiroMySQLDemo.action;

import com.jelly.shiroMySQLDemo.model.TResource;
import com.jelly.shiroMySQLDemo.model.TUser;
import com.jelly.shiroMySQLDemo.service.ShiroService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginLogoutAction {
    private final Logger log = LoggerFactory.getLogger(LoginLogoutAction.class);

    @Resource
    ShiroService shiroService;

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }

    @RequestMapping("/login")
    public ModelAndView admin(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        //TODO, here you can do logic of verification code

        Subject subject = SecurityUtils.getSubject();
        TUser user = shiroService.getUserByUsername(username);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getId(), password);

        String msg = null;
        try {
            if(StringUtils.isNotEmpty(rememberMe)){
                token.setRememberMe(true);
            }
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            log.error("IncorrectCredentialsException", e);
            msg = "username or password error!";
        } catch (ExcessiveAttemptsException e) {
            log.error("ExcessiveAttemptsException", e);
            msg = "try login to many times";
        } catch (LockedAccountException e) {
            log.error("LockedAccountException", e);
            msg = "LockedAccount";
        } catch (DisabledAccountException e) {
            log.error("DisabledAccountException", e);
            msg = "DisabledAccount";
        } catch (ExpiredCredentialsException e) {
            log.error("ExpiredCredentialsException", e);
            msg = "ExpiredCredentials";
        } catch (UnknownAccountException e) {
            log.error("UnknownAccountException", e);
            msg = "UnknownAccount";
        } catch (UnauthorizedException e) {
            log.error("UnauthorizedException", e);
            msg = "Unauthorized";
        } catch (Throwable e){
            msg = "Other Exception!";
        }
        token.clear();

        //fetch all resources of user
        List<TResource> resourceList = shiroService.getResourcesOfUser(user.getId());

        ModelAndView modelAndView = new ModelAndView();
        if(msg != null){
            request.setAttribute("msg", msg);
            modelAndView.setViewName("login");
        }else{
            request.setAttribute("resourceList", resourceList);
            modelAndView.addObject("resourceList", resourceList);
            modelAndView.setViewName("admin");
        }

        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView adminList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        request.setAttribute("msg", "user click logout");
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }
}
