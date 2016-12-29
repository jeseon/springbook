package chapter02.lesson01.factory;

public class DaoFactory {
	/**
	 * 팩토리의 메서드는 User 타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지를 결정한다.
	 * 
	 * @return UserDao
	 */
	public UserDao getUserDao() {
		ConnectionMaker connectionMaker = new NewConnectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		
		return userDao;
	}
}
