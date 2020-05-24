package JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public Connection getConnection () {


        Connection conn = null;
        try {
            // 1단계 : JDBC 드라이버 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2단계 : DriverManager를 이용한 DB 접속, Connection 객체 얻기
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String pwd = "tiger";

            conn = DriverManager.getConnection(url,user,pwd);

        } catch(Exception e) {
            e.printStackTrace();
        }


        return conn;

    }

}

