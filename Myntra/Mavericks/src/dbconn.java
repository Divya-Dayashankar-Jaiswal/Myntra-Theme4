import java.sql.*;
public class dbconn{
	//class to connect to the database prototype
	static Connection initializeDatabase() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");//mySQL driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prototype","root","scottlang");
		return con;
	}
}