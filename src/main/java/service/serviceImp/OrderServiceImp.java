package service.serviceImp;

import dao.OrderDao;
import dao.daoImp.OrderDaoImp;
import po.Order;
import service.OrderService;
import utils.Operate;
import utils.State;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class OrderServiceImp implements OrderService{

	public void deletePackage(int uid,int pid){
		OrderDao orederDao = new OrderDaoImp();
		LocalDate today = LocalDate.now();
		orederDao.insert(new Order(uid,pid, Operate.退订, Date.valueOf(today), State.失效));
		System.out.println("退订操作将于下月生效");
	}


	public void queryHistory(int uid){
		OrderDao orderDao = new OrderDaoImp();
		ArrayList<Order> orderArrayList = orderDao.queryAll(uid);
		orderArrayList.sort(new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return -(o1.getEnd_time().compareTo(o2.getEnd_time()));
			}
		});
		System.out.println("查询用户历史操作");
		for (Order order : orderArrayList){
			order.print();
		}
	}
}
