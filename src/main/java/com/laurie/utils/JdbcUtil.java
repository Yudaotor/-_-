package com.laurie.utils;

import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * JDBC连接池
 * @author Laurie
 */
public class JdbcUtil {
    private static final Queue<Connection> POOL =new LinkedList<>();
    static {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
    private static final String URL = "jdbc:mysql://localhost:3306/demo1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "98994917";

    /**
     * 获取一个数据库连接池
     * @return 数据库连接
     */
    public static synchronized Connection getConnection(){
        if (POOL.size()==0){
            try {
                return DriverManager.getConnection(URL,USER,PASSWORD);
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return POOL.poll();
    }

    /**
     * 将用完的连接放回连接池
     * @param connection 要释放的连接
     */
    public static synchronized void release(Connection connection, ResultSet rs, PreparedStatement ps){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        POOL.add(connection);
    }
    public static synchronized void release(Connection connection, PreparedStatement ps){
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        POOL.add(connection);
    }
}
