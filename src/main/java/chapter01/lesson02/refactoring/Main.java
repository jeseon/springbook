package chapter01.lesson02.refactoring;

import java.sql.SQLException;

import chapter01.lesson02.refactoring.User;
import chapter01.lesson02.refactoring.UserDao;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao userDao = new UserDao();
		User user = userDao.get(1);
		
		System.out.println(user);
	}

}
