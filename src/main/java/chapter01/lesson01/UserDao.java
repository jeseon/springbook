package chapter01.lesson01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public void add(User user) throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/develop", "root", "4447");
		
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user (name,email) VALUES (?,?)");
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getEmail());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}

	public User get(int id) throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/develop", "root", "4447");
		
		PreparedStatement pstmt = conn.prepareStatement("SELECT id,name,email FROM user WHERE id=?");
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		
		rs.close();
		pstmt.close();
		conn.close();

		return user;
	}
}
