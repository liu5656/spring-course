package com.dadalang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // 请求转发，服务端行为，地址栏不发生变化，地址只能定位在站点名之下
        request.getRequestDispatcher("cookietest").forward(request, response);
//        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
