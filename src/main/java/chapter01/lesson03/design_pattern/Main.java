package chapter01.lesson03.design_pattern;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao userDao = new MariaUserDao();
		User user = userDao.get(1);
		
		System.out.println(user);
	}

}
