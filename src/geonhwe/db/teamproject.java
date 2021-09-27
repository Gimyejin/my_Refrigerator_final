package geonhwe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import geonhwe.member.*;
//여기는 로그인관련 SQL문을 적는 클래스입니다. 로그인관련은 여기서 다 사용한다.
public class teamproject {
	
	public int insert(MemberDTO dto) {
		String sql = "insert into team_project(id,pwd,name) values(?,?,?)";
		int result = 0;
		try {

			
			PreparedStatement ps = geonhwe.db.GeonhweDB.conn.prepareStatement(sql);

			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; // conn에 DB연결되어있음 conn.pro~ 에 sql문을 넣는다. executeupdate 성공하면 1 실패하면 0 dto값을 ps가 오라클에서 insert문을 기억하고있다. 
	}
	public MemberDTO loginChk(String inputId) {

		String sql = "select * from team_project where id=?";
		MemberDTO dto = null; //dto의 데이터형 = MemberDTO
		try {
			PreparedStatement ps = geonhwe.db.GeonhweDB.conn.prepareStatement(sql);
			ps.setString(1, inputId); 
//문자열이면 setString 정수형이면 setInt
			ResultSet rs = ps.executeQuery(); //select에서만 resultset rs = executeQuery사용
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId( rs.getString("id"));
				dto.setPwd( rs.getString("pwd"));
				dto.setName( rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto; 
	}
}
