package chapter01.lesson03.design_pattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDao {
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
	
	/* 추상 메서도로 변경. 메서드 구현은 서브클래스가 담당. - 팩토리 메서드 패턴 */
	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}
