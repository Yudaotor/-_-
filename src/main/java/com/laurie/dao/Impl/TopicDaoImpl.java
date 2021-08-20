package com.laurie.dao.Impl;

import com.laurie.dao.TopicDao;
import com.laurie.pojo.Topic;
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
public class TopicDaoImpl implements TopicDao {
    @Override
    public List<Topic> selectTopicByUserId(int userId) {
        List<Topic> list = new ArrayList<Topic>();
        Connection conn = JdbcUtil.getConnection();
        ResultSet rs = null;
        String sql = "select * from topicinfo where userid=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
            rs = ps.executeQuery();
            while (rs.next()){
                Topic topic = new Topic();
                topic.setTopicId(rs.getInt("topicid"));
                topic.setGroupName(rs.getString("groupname"));
                topic.setTopicName(rs.getString("topicname"));
                topic.setUserId(rs.getInt("userid"));
                topic.setUserName(rs.getString("username"));
                topic.setTopicContent(rs.getString("topiccontent"));
                list.add(topic);
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
    public List<Topic> selectTopicByGroupName(String groupName) {
        List<Topic> list = new ArrayList<Topic>();
        Connection conn = JdbcUtil.getConnection();
        ResultSet rs = null;
        String sql = "select * from topicinfo where groupName=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,groupName);
            rs = ps.executeQuery();
            while (rs.next()){
                Topic topic = new Topic();
                topic.setTopicId(rs.getInt("topicid"));
                topic.setGroupName(rs.getString("groupname"));
                topic.setTopicName(rs.getString("topicname"));
                topic.setUserId(rs.getInt("userid"));
                topic.setUserName(rs.getString("username"));
                topic.setTopicContent(rs.getString("topiccontent"));
                list.add(topic);
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
    public Topic selectTopicByTopicId(int topicId) {
        Topic topic = new Topic();
        Connection conn = JdbcUtil.getConnection();
        ResultSet rs = null;
        String sql = "select * from topicinfo where topicid=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,topicId);
            rs = ps.executeQuery();
            while (rs.next()){
                topic.setTopicId(rs.getInt("topicid"));
                topic.setGroupName(rs.getString("groupname"));
                topic.setTopicName(rs.getString("topicname"));
                topic.setUserName(rs.getString("username"));
                topic.setUserId(rs.getInt("userid"));
                topic.setTopicContent(rs.getString("topiccontent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            JdbcUtil.release(conn, rs, ps);
        }
        return topic;
    }

    @Override
    public void createTopic(int userId, String groupName, String userName, String topicName, String topicContent) {
        Connection conn = JdbcUtil.getConnection();
        String sql1 = "insert into topicinfo(groupName,userid,username,topicname,topiccontent) values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql1);
            ps.setString(1, groupName);
            ps.setInt(2, userId);
            ps.setString(3, userName);
            ps.setString(4, topicName);
            ps.setString(5, topicContent);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }
    }

    @Override
    public void deleteTopic(int topicId) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "delete FROM topicinfo where topicid=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, topicId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }
    }
}
