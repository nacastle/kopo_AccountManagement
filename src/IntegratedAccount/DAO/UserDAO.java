package IntegratedAccount.DAO;

import JDBCUtil.ConnectionFactory;
import JDBCUtil.JDBCClose;
import IntegratedAccount.VO.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserDAO {

    // Todo list: db에 접근해서 로긴할 수 있는 메소드 구현

    Scanner sc = new Scanner(System.in);

    public UserVO loginSysDAO(String id, String pwd) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        UserVO userVO = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();
            sql.append("select id, name ");
            sql.append(" from t_user ");
            sql.append(" where id = ? and pwd = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1,id); // 작은 따옴표 알아서 들어감
            pstmt.setString(2,pwd);

            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    userVO = new UserVO(rs.getString(1),rs.getString(2));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

        return userVO;
    }

}
