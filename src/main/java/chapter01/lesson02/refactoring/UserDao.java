package chapter01.lesson02.refactoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO user (name,email) VALUES (?,?)");
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.executeUpdate();
		
		statement.close();
		connection.close();
	}

	public User get(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		PreparedStatement statement = connection.prepareStatement("SELECT id,name,email FROM user WHERE id=?");
		statement.setInt(1, id);
		
		ResultSet rs = statement.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		
		rs.close();
		statement.close();
		connection.close();

		return user;
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/develop", "root", "4447");
		
		return connection;
	}
}
