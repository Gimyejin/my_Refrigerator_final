package yegin.shelf_life;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import geonhwe.db.GeonhweDB;
import geonhwe.itemdb.ItemDTO;

public class ShelfLife_Method {
	public int insert(ItemDTO ito) {
		String sql = "insert into item_db(item_date) values(?,?,?,?,?)";
		int result1 = 0;
		try {

			PreparedStatement ps1 = GeonhweDB.conn.prepareStatement(sql);

			ps1.setString(1, ito.getId());
			ps1.setString(2, ito.getItem_name());
			ps1.setString(3, ito.getItem_add_date());
			ps1.setInt(4, ito.getItem_count());
			ps1.setString(5, ito.getItem_date());

			result1 = ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result1;
	}
	public ItemDTO itemdto(String inputId) {

		String sql = "select * from item_db where id=?";
		ItemDTO ito = null;
		try {
			PreparedStatement ps1 = GeonhweDB.conn.prepareStatement(sql);
			ps1.setString(1, inputId);

			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) {
				ito = new ItemDTO();
				ito.setId( rs1.getString("id"));
				ito.setItem_name( rs1.getString("item_name"));
				ito.setItem_add_date( rs1.getString("item_add_date"));
				ito.setItem_count(1);
				ito.setItem_date("item_date");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ito;
	}
}
