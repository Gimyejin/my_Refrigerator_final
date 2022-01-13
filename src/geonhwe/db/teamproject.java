package geonhwe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import geonhwe.member.*;
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
		return result; 
	}
	public MemberDTO loginChk(String inputId) {

		String sql = "select * from team_project where id=?";
		MemberDTO dto = null; 
		try {
			PreparedStatement ps = geonhwe.db.GeonhweDB.conn.prepareStatement(sql);
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
