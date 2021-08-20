package com.laurie.dao.Impl;

import com.laurie.dao.UserDao;
import com.laurie.pojo.User;
import com.laurie.utils.JdbcUtil;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Laurie
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> selectAll() {
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from userinfo";
        List<User> list = new LinkedList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setCellphone(rs.getString("cellphone"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert rs != null;
            JdbcUtil.release(conn, rs, ps);
        }
        return list;
    }

    @Override
    public void register(String username, String password, String email, String cellphone) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "insert into userinfo(username,password,email,cellphone) values(?,?,?,?)";
        PreparedStatement ps = null;
        int rs = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,cellphone);
            rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }
    }

    @Override
    public boolean loginVerify(String username, String password) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from userinfo where username='" + username + "'and password='" + password + "'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            JdbcUtil.release(conn, rs, ps);
        }
        return false;
    }

    @Override
    public User getUserById(int id) {
        User user = new User();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from userinfo where id=" + id;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setCellphone(rs.getString("cellphone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            JdbcUtil.release(conn, rs, ps);
        }
        return user;
    }

    @Override
    public User getUserByNamePwd(String username, String password) {
        Connection conn = JdbcUtil.getConnection();
        User user = new User();
        String sql = "select * from userinfo where username='" + username + "'and password='" + password + "'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setCellphone(rs.getString("cellphone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            JdbcUtil.release(conn, rs, ps);
        }
        return user;
    }

    @Override
    public void modify(int id, String password) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "update userinfo set password=? where id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setInt(2,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }
    }

    @Override
    public User getUserByName(String username) {
        Connection conn = JdbcUtil.getConnection();
        User user = new User();
        String sql = "select * from userinfo where username=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setCellphone(rs.getString("cellphone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            JdbcUtil.release(conn, rs, ps);
        }
        return user;
    }

    @Override
    public void deleteUserById(int userId) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "delete from userinfo where id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }
    }

    @Override
    public void modifyUser(int userId, String userName, String password, String email, String cellphone) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "update userinfo set username=? , password=? , email=? , cellphone=? where id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,cellphone);
            ps.setInt(5,userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }
    }
}
