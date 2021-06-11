package com.dadalang;

import com.mysql.cj.protocol.Resultset;
import java.sql.*;

public class MySQLDemo {
    static final String JDBC_DRIVE ="com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db1";
    static final String USER = "root";
    static final String PASS = "12345678";
    // mysql 连接测试。。。。。。。。。。。
    public static void main(String[] args) {
        Connection cont = null;
        Statement stmt = null;
        try {
            // 注册驱动
            Class.forName(JDBC_DRIVE);
            // 连接数据库。。。
            cont = DriverManager.getConnection(DB_URL, USER, PASS);
            // 实例化statement对。。。。
            stmt = cont.createStatement();
            String sql = "select userId, userName, userPhone from account";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("userId") + " name: " + rs.getString("userName") + " phone" + rs.getString("userPhone"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (cont != null) cont.close();
                if (stmt != null) stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
