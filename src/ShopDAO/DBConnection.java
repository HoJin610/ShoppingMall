package ShopDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection DBConnect() {
        // DB에 접속정보를 저장하기 위한 Connection타입의 객체 con 선언
        Connection con = null;

        // 자동 import 단축키 : [Ctrl] + [Shift] + [O]

        // DB에 접속할 계정정보
        String user = "ICIA";		// 본인이 DB에서 사용하던 계정
        String password = "1111";	// DB에서 사용한 비밀번호

        // 접속할 DB의 주소 정보
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        try {
            // ojdbc8.jar 파일을 현재 프로젝트에 적용
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 오라클 데이터베이스에 접속하는 계정정보 등록
            con = DriverManager.getConnection(url, user, password);

            System.out.println("DB접속 성공!");
        } catch(ClassNotFoundException ce) {
            // ojdbc8.jar 파일이 존재하지 않을 경우(오라클 드라이버를 찾지 못할 경우)
            ce.printStackTrace();	// 오류가 발생한 경로를 찾아준다.

            System.out.println("DB접속 실패 : 드라이버 로딩 실패!");
        } catch(SQLException se) {
            // 오라클 접속 계정정보가 틀렸을 경우(url, user, password 하나라도 틀리면)
            se.printStackTrace();

            System.out.println("DB접속 실패 : DB접속 정보 오류!");
        }

        return con;
    }

}
