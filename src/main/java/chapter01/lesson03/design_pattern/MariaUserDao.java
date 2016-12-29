package chapter01.lesson03.design_pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaUserDao extends UserDao {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/develop", "root", "4447");
		
		return connection;
	}

}
