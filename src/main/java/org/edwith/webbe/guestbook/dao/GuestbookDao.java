package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestbookDao {

    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();
        Guestbook guestbook = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM guestbook ORDER BY id DESC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String content = rs.getString("content");
                Date regDate = rs.getDate("regdate");

                guestbook = new Guestbook(id, name, content, regDate);
                list.add(guestbook);
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(rs != null){
                try{
                    rs.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(ps != null){
                try{
                    ps.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try{
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public void addGuestbook(Guestbook guestbook){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO guestbook VALUE (id, ?, ?, now())";
            ps = conn.prepareStatement(sql);

            ps.setString(1, guestbook.getName());
            ps.setString(2, guestbook.getContent());
            ps.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(rs != null){
                try{
                    rs.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(ps != null){
                try{
                    ps.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try{
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
