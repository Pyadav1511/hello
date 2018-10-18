package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil
{public static Connection con=null;
private static String url="jdbc:oracle:thin:@localhost:1521:xe";
private static String username="System";
private static String password="system";

public static Connection getConnection() throws SQLException
{
	con=DriverManager.getConnection(url,username,password);
	return con;
}


}

