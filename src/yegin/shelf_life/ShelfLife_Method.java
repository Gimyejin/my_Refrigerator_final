package yegin.shelf_life;

import java.sql.PreparedStatement;
import geonhwe.Login.LoginServiceImpl;
import geonhwe.db.GeonhweDB;
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
}
