package chapter02.lesson01.factory;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/**
		 * UserDao가 어떻게 만들어지는지, 어떻게 초기화되어 있는지
		 * 관계없이 팩토리로부터 UserDao를 방아서 활용.
		 */
		UserDao userDao = new DaoFactory().getUserDao();
		User user = userDao.get(1);
		
		System.out.println(user);
	}

}
