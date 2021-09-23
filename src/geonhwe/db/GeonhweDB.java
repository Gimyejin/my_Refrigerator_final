package geonhwe.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class GeonhweDB {
	public static Connection conn;
	static {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe", "team1", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
