package nayoung.memoListDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class SL_DB {
	public static Connection conn;
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe", "team1", "1234");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 파일이 존재하지 않습니다.");
			
		}
		
		String connectionString = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
//			+ "?useUnicode=true"
//			+ "&characterEncoding=utf8"
//			+ "&useSSL=false"
//			+ "&serverTimezone=Asia/Seoul";
		
		String userId = "team1";
		String password = "1234";
		
		//Connection conn = null;
		try {
			conn= DriverManager.getConnection(connectionString, userId, password);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연결중 오류 발생");
		}
		return conn;
	}
}
