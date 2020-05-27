package Account.DAO;

import Account.VO.AccountVO;
import Account.VO.UserVO;
import JDBCUtil.ConnectionFactory;
import JDBCUtil.JDBCClose;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDAO {



    Scanner sc = new Scanner(System.in);

    public int loginAdminSysDAO(String id, String pwd) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        int isLogin = 0;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();
            sql.append("select id, pwd ");
            sql.append(" from t_admin ");
            sql.append(" where id = ? and pwd = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1,id); // 작은 따옴표 알아서 들어감
            pstmt.setString(2,pwd);

            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                isLogin++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

        return isLogin;
    }

    public List<UserVO> selectAllUserDAO() { // 추후에 selectAccountDAO 로 간단히 구현할수 있을지도?

        Connection conn = null;
        PreparedStatement pstmt = null;
        List<UserVO> userList = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();
            sql.append("select id, name");
            sql.append(" from t_user ");
            sql.append(" order by id ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();

            userList = new ArrayList<>();
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);

                UserVO userVO = new UserVO(id,name);

                userList.add(userVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

        return userList;
    }

    public String selectUserDO (String tempId) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        String name = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();
            sql.append("select name ");
            sql.append(" from t_user ");
            sql.append(" where id = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, tempId);


            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                name = rs.getString(1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

        return name;
    }


    public void deleteUserDAO(String tempId) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("delete from t_user ");
            sql.append(" where id = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, tempId);

            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

    }

    public void reviseAccountDAO(String tempId, String newName) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        AccountVO accountVO = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("update t_user ");
            sql.append(" set name = ? ");
            sql.append(" where id = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, newName);
            pstmt.setString(2, tempId);

            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

    }



}
