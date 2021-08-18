package com.laurie.dao.Impl;

import com.laurie.dao.GroupDao;
import com.laurie.pojo.Group;
import com.laurie.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            ps.executeUpdate();
            ps = conn.prepareStatement(sql2);
            ps.setString(1,name);
            ps.setInt(2,memberid);
            ps.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }

    }

    @Override
    public void joinGroup(String groupName, Integer userId) {
        Connection conn = JdbcUtil.getConnection();
        String sql1 = "insert into groupmember(groupname,memberid) values(?,?)";
        String sql2 = "update groupinfo set groupsize=groupsize+1 where groupname=?";
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, groupName);
            ps.setInt(2, userId);
            ps.executeUpdate();
            ps = conn.prepareStatement(sql2);
            ps.setString(1, groupName);
            ps.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
        String sql = "select * from groupinfo where groupname=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if (rs.next()){
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

    @Override
    public List<Group> selectGroupAll() {
        List<Group> list = new ArrayList<Group>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from groupinfo";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String groupName = rs.getString("groupname");
                int groupSize = rs.getInt("groupsize");
                String groupInfo = rs.getString("groupinfo");
                Group li = new Group (groupName, groupSize, groupInfo);
                list.add(li);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            JdbcUtil.release(conn, rs, ps);
        }
        return list;
    }

    @Override
    public List<String> selectGroupByMemberId(int memberId) {
        List<String> list = new ArrayList<String>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from groupmember where memberid=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,memberId);
            rs = ps.executeQuery();
            while (rs.next()){
                String groupName = rs.getString("groupname");
                list.add(groupName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            JdbcUtil.release(conn, rs, ps);
        }
        return list;
    }

    @Override
    public void exitGroup(String groupName, int memberId) {
        Connection conn = JdbcUtil.getConnection();
        String sql1 = "delete from groupmember where memberid=? and groupname=?";
        String sql2 = "update groupinfo set groupsize=groupsize-1 where groupname=?";
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setInt(1, memberId);
            ps.setString(2, groupName);
            ps.executeUpdate();
            ps = conn.prepareStatement(sql2);
            ps.setString(1, groupName);
            ps.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }
    }

}
