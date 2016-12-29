package chapter01.lesson04.connection_class;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao userDao = new UserDao();
		User user = userDao.get(1);
		
		System.out.println(user);
	}

}
