package com.zxsipromise.Dao;

import com.zxsipromise.model.Book;
import com.zxsipromise.model.BookAndBookType;
import com.zxsipromise.model.BookAndBorrow;
import com.zxsipromise.model.User;
import com.zxsipromise.utils.DButils;
import com.zxsipromise.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
Encapsulate the method used by the user account
 */
public class UserDao {
    public static List<User> login(String name, String pwd, String userid){
        String sql ="select * from t_user where userName =? and password =? and userid =?";
        List<User> jdbc_select = DButils.jdbc_select(sql,User.class,name,pwd,userid);
        return jdbc_select;
    }
    public static int reg(String name, String pwd){
        String sql = "insert into t_user(userName,password,userid) value(?,?,?)";
        int jdbc_update = DButils.jdbc_update(sql, name, pwd, "0");
        return jdbc_update;
    }
    public static List<BookAndBorrow> listBook(int id){
        String sql = "select * from t_book, t_borrow where t_book.id = t_borrow.bookid and userid=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        List<BookAndBorrow> list = new ArrayList<BookAndBorrow>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                String bookName = rs.getString("bookName");
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                Date bdate = rs.getDate("btime");
                BookAndBorrow book = new BookAndBorrow(bookName,author,price,bdate);
                list.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(rs,null,ps,conn);
        }
        return list;
    }
    public static int updatePwd(String newpassword, String name){
        String sql = "update t_user set password =? where userName =?";
        int i =DButils.jdbc_update(sql,newpassword,name);
        return i;
    }

    public static List<BookAndBookType> listBook2() {
        String sql = "select * from t_book,t_booktype where t_book.bookTypeId=t_booktype.id";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        List<BookAndBookType> list = new ArrayList<BookAndBookType>();
        try {
            ps = conn.prepareStatement(sql);
            //ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                int bookID = rs.getInt("id");
                String bookName = rs.getString("bookName");
                String bookTypeName = rs.getString("bookTypeName");
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                String bookDesc = rs.getString("bookDesc");
                BookAndBookType book = new BookAndBookType(bookID,bookName,bookTypeName,author,price,bookDesc);
                list.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(rs,null,ps,conn);
        }
        return list;
    }

    public static Book SelectBook(int bookId){
        String sql = "select * from t_book where isFlag=1 and id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        Book book = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,bookId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookName = rs.getString("bookName");
                String author = rs.getString("author");
                book = new Book(id, bookName, author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, null, ps, conn);
        }
        return book;
    }

    public static User selectUname(String name) {
        String sql = "select * from t_user where userName=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        User user = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("userName");
                String password = rs.getString("password");
                user = new User(id, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, null, ps, conn);
        }
        return user;
    }

    public static int borrowBook(int bookid) {
        String sql = "update t_book set isFlag=1 where id =?";
        return DButils.jdbc_update(sql, bookid);
    }

    public static int insertBorrow(int id, int bookid) {
        String sql = "insert into t_borrow(userid,bookid,btime) value(?,?,?)";
        return DButils.jdbc_update(sql, id, bookid, new Date(System.currentTimeMillis()));
    }

    public static Book selectBookId(String bookName) {
        String sql = "select * from t_book where bookName=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        Book book = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, bookName);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookName2 = rs.getString("bookName");
                String author = rs.getString("author");
                book = new Book(id, bookName2, author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, null, ps, conn);
        }
        return book;
    }

    public static List<BookAndBookType> listBook3(String bookName) {
        String sql = "select * from t_book,t_booktype where t_book.bookTypeId=t_booktype.id and bookName like ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        List<BookAndBookType> list = new ArrayList<BookAndBookType>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + bookName + "%");
            rs = ps.executeQuery();
            while (rs.next()){
                int bookID = rs.getInt("id");
                String bookName2 = rs.getString("bookName");
                String bookTypeName = rs.getString("bookTypeName");
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                String bookDesc = rs.getString("bookDesc");
                BookAndBookType book = new BookAndBookType(bookID,bookName2,bookTypeName,author,price,bookDesc);
                list.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(rs,null,ps,conn);
        }
        return list;
    }

    public static int updateIsFlag(int bookid) {
        String sql = "update t_book set isflag=0 where id=?";
        return DButils.jdbc_update(sql, bookid);
    }

    public static int updateRtime(int userid, int bookid) {
        String sql = "update t_borrow set rtime=? where userid=? and bookid=?";
        return DButils.jdbc_update(sql, new Date(System.currentTimeMillis()), userid, bookid);
    }

}
