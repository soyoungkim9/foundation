package member.dao;

import jdbc.JdbcUtil;
import member.model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
    public Member selectById(Connection conn, String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(
                    "SELECT * FROM member WHERE id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            Member member = null;
            if(rs.next()) {
                member = new Member(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("pwd"));
            }
            return member;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    public void insert(Connection conn, Member mem) throws SQLException {
        try (PreparedStatement pstmt =
                conn.prepareStatement("INSERT INTO member VALUES(?,?,?)")) {
            pstmt.setString(1, mem.getId());
            pstmt.setString(2, mem.getName());
            pstmt.setString(3, mem.getPwd());
            pstmt.executeUpdate();
        }
    }

    public void update(Connection conn, Member member) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(
                "UPDATE member SET name = ? , pwd = ? WHERE id = ?")){
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPwd());
            pstmt.setString(3, member.getId());
            pstmt.executeUpdate();
        }
    }
}
