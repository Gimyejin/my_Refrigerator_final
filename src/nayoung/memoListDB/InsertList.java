package nayoung.memoListDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class InsertList {
	public static void main(String[] args) {
		SL_DB db = new SL_DB();
		
		Connection conn = db.getConnection();
		if(conn == null) {
			System.out.println("DB연결 오류 발생");
			return;
		}
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO SHOPPINGLIST (LIST, SL_DATE) VALUES( ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  "테스트용 일정");
			pstmt.setDate(2, Date.valueOf( LocalDate.now() ));
			int cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				System.out.println("데이터 삽입 실패");
				return;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터 삽입 실패");
			return;
		}finally {
			if(pstmt != null) try { pstmt.close(); } catch (Exception e) {}
			if(conn != null) try { conn.close(); } catch (Exception e) {}
		}
	}
}
