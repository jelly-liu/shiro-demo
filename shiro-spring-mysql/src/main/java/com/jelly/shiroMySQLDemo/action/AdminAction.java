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
    public ModelAndView admin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return new ModelAndView("admin");
    }

    @RequestMapping("/adminList")
    public void adminList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>adminList</h1>");
    }

    @RequestMapping("/adminAdd")
    public void adminAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>adminAdd</h1>");
    }

    @RequestMapping("/adminDelete")
    public void adminDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>adminDelete</h1>");
    }

    @RequestMapping("/adminUpdate")
    public void adminSuper(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>adminUpdate</h1>");
    }
}
