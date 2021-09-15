package geonhwe.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import geonhwe.db.DBClass;
import geonhwe.member.*;

public class LoginDB {
	public MemberDTO loginChk(String inputId) {
		String sql = "select * from team_project where id=?";
		MemberDTO dto = null;
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setString(1, inputId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId( rs.getString("id") );
				dto.setPwd( rs.getString("pwd") );
				dto.setName(rs.getString("name") );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
