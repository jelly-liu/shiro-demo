package com.jelly.shiroMySQLDemo.filter;

import com.jelly.shiroMySQLDemo.model.TResource;
import com.jelly.shiroMySQLDemo.model.TUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

/**
 * Created by jelly on 2016-10-18.
 */

@WebFilter(filterName = "AutoSetUserInfoPerRequestFilter", urlPatterns = "/*")
public class AutoSetUserInfoPerRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){
            TUser user = (TUser) subject.getSession().getAttribute("user");
            List resources = (List)subject.getSession().getAttribute("resources");
            List roles = (List)subject.getSession().getAttribute("roles");
            List perms = (List)subject.getSession().getAttribute("perms");
            servletRequest.setAttribute("subject_user", user);
            servletRequest.setAttribute("subject_resources", resources);
            servletRequest.setAttribute("subject_roles", roles);
            servletRequest.setAttribute("subject_perms", perms);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
