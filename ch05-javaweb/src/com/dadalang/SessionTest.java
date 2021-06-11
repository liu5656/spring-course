package com.dadalang;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessiontest")
public class SessionTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("requestKey1", "requestValue1");

        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(10);
        session.setAttribute("sessionKey1", "sessionvalue1");

        ServletContext context = req.getServletContext();

        context.setAttribute("contextKey1", "contentValue1");

        req.getRequestDispatcher("sessiontest2").forward(req, resp);

    }
}
