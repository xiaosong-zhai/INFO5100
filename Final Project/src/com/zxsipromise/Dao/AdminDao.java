package com.zxsipromise.Dao;

import com.zxsipromise.model.Book;
import com.zxsipromise.model.BookType;
import com.zxsipromise.utils.DButils;
import com.zxsipromise.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    public static BookType selectBookTypeName(String bookTypeName) {
        String sql = "SELECT * FROM t_booktype WHERE bookTypeName=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        BookType b = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, bookTypeName);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookTypeName2 = rs.getString("bookTypeName");
                String bookTypeDesc = rs.getString("booktypeDesc");
                b = new BookType(id, bookTypeName2, bookTypeDesc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, null, ps, conn);
        }
        return b;

    }


    public static int addBookType(String bookTypeName, String bookTypeDesc) {
        String sql = "INSERT INTO t_booktype(bookTypeName,bookTypeDesc) value(?,?)";
        return DButils.jdbc_update(sql,bookTypeName,bookTypeDesc);
    }

    public static List<BookType> listBookType(String bookTypeName) {
        String sql = "select * from t_booktype where bookTypeName like ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        BookType b = null;
        List<BookType> list = new ArrayList<BookType>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + bookTypeName + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookTypeName2 = rs.getString("bookTypeName");
                String booktypeDesc = rs.getString("booktypeDesc");
                b = new BookType(id, bookTypeName2, booktypeDesc);
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, null, ps, conn);
        }
        return list;
    }

    public static int updateBookType(String bookTypeName, String bookTypeDesc, int bid) {
        String sql = "update t_booktype set bookTypeName=?,bookTypeDesc=? where id=?";
        return DButils.jdbc_update(sql,bookTypeName,bookTypeDesc,bid);
    }

    public static int deleteBook(int bookTypeid) {
        String sql = "delete from t_book where bookTypeid=?";
        return DButils.jdbc_update(sql,bookTypeid);
    }

    public static int deleteBookType(int bookTypeid) {
        String sql = "delete from t_booktype where id=?";
        return DButils.jdbc_update(sql,bookTypeid);

    }


    public static int addBook(String bookName, String author, String sex, float price, String bookDesc, int bookTypeId) {
        String sql = "insert into t_book(bookName,author,sex,price,bookDesc,bookTypeId,isflag) value(?,?,?,?,?,?,?)";
        return DButils.jdbc_update(sql,bookName,author,sex,price,bookDesc,bookTypeId,0);
    }

    public static List<Book> listBook(String bookName) {
        String sql = "select * from t_book where bookName like ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        Book b = null;
        List<Book> list = new ArrayList<Book>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + bookName + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookName2 = rs.getString("bookName");
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                String bookDesc = rs.getString("bookDesc");
                b = new Book(id, bookName2, author,price,bookDesc);
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, null, ps, conn);
        }
        return list;
    }

    public static int updateBook(Book book) {
        String sql = "update t_book set bookName=?,author=?,price=?,bookDesc=? where id=?";
        return DButils.jdbc_update(sql,book.getBookDesc(),book.getAuthor(),book.getPrice(),book.getBookDesc(),book.getId());
    }

    public static int deleteBook2(int bookId){
        String sql = "delete from t_book where id=?";
        return DButils.jdbc_update(sql,bookId);
    }
}
