package com.dadalang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookietest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("key: " + cookie.getName() + ", value:" + cookie.getValue());
        }

        Cookie cookie = new Cookie("key1","value1");
        Cookie cookie2 = new Cookie("key2", "value2");
        response.addCookie(cookie);
        response.addCookie(cookie2);
    }
}
