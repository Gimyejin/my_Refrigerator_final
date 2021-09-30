

package yegin.shelf_life;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import geonhwe.Login.LoginServiceImpl;
import geonhwe.db.GeonhweDB;
import geonhwe.member.MemberDTO;
import hayong.FoodDTO;

public class ShelfLife_Method {
	
	public int update(String shelfday, FoodDTO dto) {
		int result=0;
		try {
			String sql =
		"update item_db set item_date=? where id=? and item_name=? and item_date=?";
			PreparedStatement ps = GeonhweDB.conn.prepareStatement(sql);
			ps.setString(1, shelfday);
			ps.setString(2, LoginServiceImpl.staticid);
			ps.setString(3, dto.getFoodName());
			ps.setString(4, dto.getShelfLife());
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	public int updatePw(MemberDTO dto) {
		int result=0;
		try {
			String sql =
		"update team_project set pwd=? where id=?";
			PreparedStatement ps = GeonhweDB.conn.prepareStatement(sql);
			ps.setString(1, dto.getPwd());
			ps.setString(2, LoginServiceImpl.staticid);
			result = ps.executeUpdate();
		}catch (Exception e) {
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
	
	public int memberDel() {
		int result=0;
		String sql="delete from team_project where id=?";
		MemberDTO dto = null; 
		try {
			PreparedStatement ps = GeonhweDB.conn.prepareStatement(sql);
			ps.setString(1, LoginServiceImpl.staticid); 
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; 
	}
}

