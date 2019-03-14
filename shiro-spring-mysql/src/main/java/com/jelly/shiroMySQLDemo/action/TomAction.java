package com.jelly.shiroMySQLDemo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TomAction {
    @RequestMapping("/tomList")
    public void tomList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>tomList</h1>");
    }

    @RequestMapping("/tomAdd")
    public void tomAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>tomAdd</h1>");
    }

    @RequestMapping("/tomDelete")
    public void tomDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>tomDelete</h1>");
    }

    @RequestMapping("/tomUpdate")
    public void tomUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>tomUpdate</h1>");
    }
}
