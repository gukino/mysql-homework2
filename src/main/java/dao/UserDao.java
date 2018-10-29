package dao;

import po.User;

public interface UserDao {


	public void insert(User user);
	public void update(User user);
	public void delete(User user);
}
