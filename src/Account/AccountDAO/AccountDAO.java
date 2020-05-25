package Account.AccountDAO;

import Account.AccountVO.AccountVO;
import JDBCUtil.ConnectionFactory;
import JDBCUtil.JDBCClose;
import User.UserVO.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    public List<AccountVO> selectAllAccountDAO(UserVO userVO) { // 추후에 selectAccountDAO 로 간단히 구현할수 있을지도?

        Connection conn = null;
        PreparedStatement pstmt = null;
        List<AccountVO> accoutList = new ArrayList<>();

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();
            sql.append("select a.id, a.nickname, a.account_number, a.bank, a.owner, a.balance ");
            sql.append(" from t_account a ");
            sql.append(" join t_user u ");
            sql.append(" on a.id = u.id ");
            sql.append(" where a.id = ? ");
            sql.append(" order by nickname  ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, userVO.getId());


            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String nickname = rs.getString(2);
                int accountNumber = rs.getInt(3);
                String bank = rs.getString(4);
                String accountUser = rs.getString(5);
                long balance = rs.getLong(6);

                AccountVO accountVO = new AccountVO(id, nickname, accountNumber, bank, accountUser, balance);

                accoutList.add(accountVO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

        return accoutList;
    }

    public AccountVO selectAccountDAO(UserVO userVO, String tempNickname) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        AccountVO accountVO = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();
            sql.append("select * ");
            sql.append(" from t_account a ");
            sql.append(" join t_user u ");
            sql.append(" on a.id = u.id ");
            sql.append(" where a.id = ? ");
            sql.append("   and a.nickname = ? ");
            sql.append(" order by bank ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, userVO.getId());
            pstmt.setString(2, tempNickname);


            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String nickname = rs.getString(2);
                int accountNumber = rs.getInt(3);
                String bank = rs.getString(4);
                String accountUser = rs.getString(5);
                long balance = rs.getLong(6);

                accountVO = new AccountVO(id, nickname, accountNumber, bank, accountUser, balance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

        return accountVO;
    }

    //selectAccountDAO를 계좌번호로도 조회할수 있도록 오버로딩
    public AccountVO selectAccountDAO(UserVO userVO, int tempAccountNumber) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        AccountVO accountVO = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();
            sql.append("select * ");
            sql.append(" from t_account a ");
            sql.append(" join t_user u ");
            sql.append(" on a.id = u.id ");
            sql.append(" where a.id = ? ");
            sql.append("   and a.account_number = ? ");
            sql.append(" order by bank ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, userVO.getId());
            pstmt.setInt(2, tempAccountNumber);


            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String nickname = rs.getString(2);
                int accountNumber = rs.getInt(3);
                String bank = rs.getString(4);
                String accountUser = rs.getString(5);
                long balance = rs.getLong(6);

                accountVO = new AccountVO(id, nickname, accountNumber, bank, accountUser, balance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

        return accountVO;
    }

    public AccountVO selectAccountDAO(int tempAccountNumber) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        AccountVO accountVO = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();
            sql.append("select * ");
            sql.append(" from t_account a ");
            sql.append(" where a.account_number = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setInt(1, tempAccountNumber);


            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String nickname = rs.getString(2);
                int accountNumber = rs.getInt(3);
                String bank = rs.getString(4);
                String accountUser = rs.getString(5);
                long balance = rs.getLong(6);

                accountVO = new AccountVO(id, nickname, accountNumber, bank, accountUser, balance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }
        return accountVO;
    }

    public AccountVO selectAccountDAO(String tempId) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        AccountVO accountVO = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();
            sql.append("select * ");
            sql.append(" from t_account a ");
            sql.append(" where a.id = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, tempId);


            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String nickname = rs.getString(2);
                int accountNumber = rs.getInt(3);
                String bank = rs.getString(4);
                String accountUser = rs.getString(5);
                long balance = rs.getLong(6);

                accountVO = new AccountVO(id, nickname, accountNumber, bank, accountUser, balance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

        return accountVO;
    }

    public void deleteAccountDAO(UserVO userVO, String tempNickname) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        AccountVO accountVO = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("delete from t_account ");
            sql.append(" where id = ? ");
            sql.append(" and nickname = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, userVO.getId());
            pstmt.setString(2, tempNickname);

            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

    }

    public void reviseAccountDAO(UserVO userVO, String newNickname, String tempNickname) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        AccountVO accountVO = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("update t_account ");
            sql.append(" set nickname = ? ");
            sql.append(" where id = ? and nickname = ? ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, newNickname);
            pstmt.setString(2, userVO.getId());
            pstmt.setString(3, tempNickname);

            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

    }

    public void registerAccountDAO(UserVO userVO, AccountVO accountVO) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("insert into t_account ");
            sql.append(" values (?, ?, ?, ? ,? ,?) ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, userVO.getId());
            pstmt.setString(2, accountVO.getNickname());
            pstmt.setInt(3, accountVO.getAccountNumber());
            pstmt.setString(4, accountVO.getBank());
            pstmt.setString(5, accountVO.getAccountOwner());
            pstmt.setLong(6, accountVO.getBalance());

            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

    }

    // 별칭 혹은 계좌번호로 입금
    public void depositDAO(UserVO userVO, long originalBalance, long depositAmount, String tempNickname, int tempAccountNumber) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("update t_account ");
            sql.append(" set balance = ?+? ");
            sql.append(" where id = ? ");
            sql.append("   and (nickname = ? or account_number = ?) ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());


            pstmt.setLong(1, originalBalance);
            pstmt.setLong(2, depositAmount);
            pstmt.setString(3, userVO.getId());
            pstmt.setString(4, tempNickname);
            pstmt.setInt(5, tempAccountNumber);

            // 작성한 sql문 실행하기
            ResultSet rs = pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 접속종료
            JDBCClose.close(conn, pstmt);
        }

    }

    // 별칭 혹은 계좌번호로 출금
    public void withdrawDAO(UserVO userVO, long originalBalance, long withdrawAmount, String tempNickname, int tempAccountNumber) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            // 드라이버 받고 connect해서 connection 변수 하나 생성
            conn = new ConnectionFactory().getConnection();

            // sql문 작성
            StringBuilder sql = new StringBuilder();

            sql.append("update t_account ");
            sql.append(" set balance = ?-? ");
            sql.append(" where id = ? ");
            sql.append("   and (nickname = ? or account_number = ?) ");

            // sql문 ?에 값넣기
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setLong(1, originalBalance);
            pstmt.setLong(2, withdrawAmount);
            pstmt.setString(3, userVO.getId());
            pstmt.setString(4, tempNickname);
            pstmt.setInt(5, tempAccountNumber);

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
