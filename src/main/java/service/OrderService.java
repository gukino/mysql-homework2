package service;

import dao.OrderDao;
import dao.PackageDao;
import dao.daoImp.OrderDaoImp;
import dao.daoImp.PackageDaoImp;
import po.Order;
import utils.Operate;
import utils.State;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class OrderService {
	ArrayList<Package> getCurrent(int uid){
		OrderDao orderDao = new OrderDaoImp();
		ArrayList<Order> orderArrayList = orderDao.queryAll(uid);
		orderArrayList.sort(new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getEnd_time().compareTo(o2.getEnd_time());
			}
		});
		for (Order order : orderArrayList){
			System.out.println(Integer.toString(order.getPid())+Integer.toString(order.getUid())+order.getOperate()+order.getEnd_time());
		}
		return null;
	}

	void addPackage(){

	}

	void deletePackage(int uid,int pid){
		OrderDao orederDao = new OrderDaoImp();
		LocalDate today = LocalDate.now();
		orederDao.insert(new Order(uid,pid, Operate.退订, Date.valueOf(today), State.失效));
	}

	public void queryHistory(int uid){
		OrderDao orderDao = new OrderDaoImp();
		ArrayList<Order> orderArrayList = orderDao.queryAll(uid);
		orderArrayList.sort(new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return o1.getEnd_time().compareTo(o2.getEnd_time());
			}
		});
		for (Order order : orderArrayList){
			order.print();
		}
	}
}
