package chapter01.lesson01;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		User user = new User();
		user.setName("USER");
		user.setEmail("user@email.com");

		UserDao userDao = new UserDao();
		userDao.add(user);
		
		System.out.println(user.getName() + " Okay");
	}

}
