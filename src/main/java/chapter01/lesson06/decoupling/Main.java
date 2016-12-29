package chapter01.lesson06.decoupling;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionMaker connectionMaker = new NewConnectionMaker();
		
		UserDao userDao = new UserDao(connectionMaker);
		User user = userDao.get(1);
		
		System.out.println(user);
	}

}
