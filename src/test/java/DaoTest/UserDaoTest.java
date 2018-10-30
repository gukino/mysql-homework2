package DaoTest;

import dao.UserDao;
import dao.daoImp.UserDaoImp;
import org.junit.Assert;
import org.junit.Test;
import po.User;
import utils.Sex;

import static utils.Sex.男;


public class UserDaoTest {

	@Test
	//测试 insert()方法
	public void testInsert(){
		UserDao userTest = new UserDaoImp();

		userTest.insert(new User("胡本霖", 男,100));
		userTest.insert(new User("胡明伟", 男,100));
		userTest.insert(new User("何天行", 男,100));
	}

	@Test
	//测试 query()方法
	public void testQuery(){
		UserDao userTest = new UserDaoImp();
		User testUser = userTest.query(1);
		User user = new User(1,"胡夲霖",男,1.00);
		Assert.assertTrue(user.equal(testUser));
	}



}
