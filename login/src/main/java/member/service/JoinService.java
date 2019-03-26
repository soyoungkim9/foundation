package member.service;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

import java.sql.Connection;
import java.sql.SQLException;

public class JoinService {

    private MemberDao memberDao = new MemberDao();

    public void join(JoinRequest joinReq) {
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            conn.setAutoCommit(false);

            Member member = memberDao.selectById(conn, joinReq.getId());
            if(member != null) {
                JdbcUtil.rollback(conn);
                throw new DuplicateIdException();
            }

            memberDao.insert(conn,
                    new Member(
                            joinReq.getId(),
                            joinReq.getName(),
                            joinReq.getPwd()
                    )
            );
            conn.commit();
        } catch(SQLException e) {
            JdbcUtil.rollback(conn);
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn);
        }
    }
}
