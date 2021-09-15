package geonhwe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import geonhwe.member.*;

public class DBClass {
	public static Connection conn;
	
	public DBClass() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.221.253.215:1521:xe", "team1", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public int insert(MemberDTO dto) {
		String sql = "insert into team_project(id,pwd,name) values(?,?,?)";
		int result = 0;
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public MemberDTO loginChk(String inputId) {

		String sql = "select * from team_project where id=?";
		MemberDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inputId);

			ResultSet rs = ps.executeQuery();
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
