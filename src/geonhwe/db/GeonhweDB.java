package geonhwe.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class GeonhweDB {
	public static Connection conn;
	static {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
