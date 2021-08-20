package com.laurie.dao.Impl;

import com.laurie.dao.TalkDao;
import com.laurie.pojo.Group;
import com.laurie.pojo.Talk1;
import com.laurie.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Laurie
 */
public class TalkDaoImpl implements TalkDao {
    @Override
    public void createTalk(String name, int tid1, int tid2, String content) {
        Connection conn = JdbcUtil.getConnection();
        String sql1 = "insert into talk1(topicname,talkerid1,talkerid2,talkcontent,talktime) values(?,?,?,?,now())";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql1);
            ps.setString(1, name);
            ps.setInt(2, tid1);
            ps.setInt(3, tid2);
            ps.setString(4, content);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert ps != null;
            JdbcUtil.release(conn, ps);
        }
    }

    @Override
    public List<Talk1> selectTalkByTopicName(String name) {
        List<Talk1> list = new ArrayList<Talk1>();
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from talk1 where topicname=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while (rs.next()){
                int talkId = rs.getInt("talkid");
                String topicName = rs.getString("topicname");
                int talker1 = rs.getInt("talkerid1");
                int talker2 = rs.getInt("talkerid2");
                String talkContent = rs.getString("talkcontent");
                Date time = rs.getDate("talktime");
                Talk1 ta = new Talk1 (talkId, topicName, talker1,talker2,talkContent,time);
                list.add(ta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            JdbcUtil.release(conn, rs, ps);
        }
        return list;
    }
}
