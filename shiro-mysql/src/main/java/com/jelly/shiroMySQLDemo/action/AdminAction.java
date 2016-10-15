package com.jelly.shiroMySQLDemo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AdminAction {
    @RequestMapping("/admin")
    public ModelAndView admin(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("admin");
        return modelAndView;
    }

    @RequestMapping("/adminList")
    public void adminList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>AdminListPage</h1>");
    }

    @RequestMapping("/adminAdd")
    public void adminAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>AdminAddPage</h1>");
    }

    @RequestMapping("/adminDelete")
    public void adminDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>AdminDeletePage</h1>");
    }

    @RequestMapping("/adminSuper")
    public void adminSuper(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>AdminSuperPage</h1>");
    }
}
