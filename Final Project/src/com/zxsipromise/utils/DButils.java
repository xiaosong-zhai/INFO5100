package com.zxsipromise.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DButils {
    public static int jdbc_update(String sql, Object... objects){
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            for (int j = 0; j < objects.length; j++) {
                ps.setObject(j + 1, objects[j]);
            }
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,null,ps,conn);
        }
        return i;
    }

    public static <T> List<T> jdbc_select(String sql, Class<T> classes, Object... objects){
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col_count = rsmd.getColumnCount();
            list = new ArrayList<T>();
            while (rs.next()){
                T t = classes.newInstance();
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 0; i < col_count; i++) {
                    String colName = rsmd.getColumnLabel(i + 1);
                    Object colValue = rs.getObject(colName);
                    map.put(colName, colValue);
                }
                BeanUtils.populate(t, map);
                list.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return list;
    }
}
