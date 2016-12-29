package chapter01.lesson06.decoupling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;	
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection connection = connectionMaker.makeConnection();
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO user (name,email) VALUES (?,?)");
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.executeUpdate();
		
		statement.close();
		connection.close();
	}

	public User get(int id) throws ClassNotFoundException, SQLException {
		Connection connection = connectionMaker.makeConnection();
		
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
}
