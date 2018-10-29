package dao;

import po.User;

public interface UserDao {


	public void insert(User user);
	public User query(int uid);
}
