package com.dadalang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirecttest")
public class RedirectTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 重定向，客户端行为，两次请求，request域中数据不共享,地址栏发生变化，绝对地址可以写到http://
//        resp.sendRedirect("index.jsp");
        resp.sendRedirect("r2");
    }
}
