package com.dadalang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sessiontest2")
public class SessionTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("request value:" + (String) req.getAttribute("requestKey1"));

        System.out.println("session value: " + req.getSession().getAttribute("sessionKey1"));

        System.out.println("context value: " + getServletContext().getAttribute("contextKey1"));
    }
}
