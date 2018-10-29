package dao;

import po.Order;
import po.User;

public interface OrderDao {

	void insert(Order order);
	void update(Order order);
	void delete(Order order);

}
