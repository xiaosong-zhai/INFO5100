package com.zxsipromise.utils;

import java.sql.*;

public class JDBCUtils {
    public static Connection getConnection(){
        Connection ct = null;
        Statement sm = null;
        ResultSet rs =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ct = DriverManager.getConnection("jdbc:mysql://ipromise.dynv6.net:3306/LibraryManagementSystem?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","zxs123123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ct;
    }

    public static void close(ResultSet rs, Statement stm, PreparedStatement ps, Connection conn){
            try {
                if (null != rs) {
                    rs.close();
                }
            }catch (Exception e) {
            }
        try {
            if (null != rs) {
                stm.close();
            }
        }catch (Exception e) {
        }
        try {
            if (null != rs) {
                ps.close();
            }
        }catch (Exception e) {
        }
        try {
            if (null != rs) {
                conn.close();
            }
        }catch (Exception e) {
        }
    }
}
