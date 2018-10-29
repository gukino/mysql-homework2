package DaoTest;

import dao.UserDao;
import dao.daoImp.UserDaoImp;
import po.User;
import utils.Sex;


public class UserDaoTest {
	UserDao userTest = new UserDaoImp();
	User user = new User("test", Sex.男,10);
	userTest.insert(user);
	

}
