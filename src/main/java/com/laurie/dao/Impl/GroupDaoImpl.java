package com.laurie.dao.Impl;

import com.laurie.dao.GroupDao;
import com.laurie.pojo.Group;
import com.laurie.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Laurie
 */
public class GroupDaoImpl implements GroupDao {

    @Override
    public void createGroup(String name, String info, int memberid) {
        Connection conn = JdbcUtil.getConnection();
        String sql1 = "insert into groupinfo(groupname,groupinfo,groupsize) values(?,?,1)";
        String sql2 = "insert into groupmember(groupname,memberid) values(?,?)";
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, name);
            ps.setString(2, info);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            ps = conn.prepareStatement(sql2);
            ps.setString(1,name);
            ps.setInt(2,memberid);
            int rs2 = ps.executeUpdate();
            System.out.println(rs2);
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }

    }

    @Override
    public void joinGroup(Integer groupId, Integer userId) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "insert into groupmember(groupid,memberid) values(?,?)";
        PreparedStatement ps = null;
        int rs = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,groupId);
            ps.setInt(2,userId);
            rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }
    }

    @Override
    public Group getGroupByName(String name) {
        Group group = new Group();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from groupinfo where groupname=" + "''" + name + "'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                group.setGroupId(rs.getInt("groupid"));
                group.setGroupName(rs.getString("groupname"));
                group.setGroupSize(rs.getInt("groupsize"));
                group.setGroupInfo(rs.getString("groupinfo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            JdbcUtil.release(conn, rs, ps);
        }
        return group;
    }
}
