package dao;

import po.Order;

import java.util.ArrayList;

public interface OrderDao {

	void insert(Order order);
	ArrayList<Order> queryAll(int uid);
	ArrayList<Order> queryCurrent(int uid);

}
