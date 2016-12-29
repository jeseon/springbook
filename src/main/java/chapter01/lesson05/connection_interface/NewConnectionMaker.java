package chapter01.lesson05.connection_interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NewConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/develop", "root", "4447");
		
		return connection;
	}

}
