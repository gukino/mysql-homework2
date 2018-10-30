package service.serviceImp;

import dao.OrderDao;
import dao.PackageDao;
import dao.daoImp.OrderDaoImp;
import dao.daoImp.PackageDaoImp;
import po.Order;
import po.Package;
import service.OrderService;
import utils.Operate;
import utils.State;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class OrderServiceImp implements OrderService{



	public void addPackage(int uid,int pid){
		OrderDao orederDao = new OrderDaoImp();
		LocalDate today = LocalDate.now();
		orederDao.insert(new Order(uid,pid, Operate.订购, Date.valueOf(today), State.待生效));
		System.out.println("订购操作将于下月生效");
	}

	public void deletePackage(int uid,int pid){
		OrderDao orederDao = new OrderDaoImp();
		LocalDate today = LocalDate.now();
		orederDao.insert(new Order(uid,pid, Operate.退订, Date.valueOf(today), State.失效));
		System.out.println("退订操作将于下月生效");
	}

	public ArrayList<Package> getCurrentPackage(int uid){
		OrderDao orderDao = new OrderDaoImp();
		ArrayList<Order> orderArrayList = orderDao.queryCurrent(uid);
		ArrayList<Package> packageArrayList = new ArrayList<>();

		PackageDao packageDao = new PackageDaoImp();

		for (Order order : orderArrayList){
			packageArrayList.add(packageDao.query(order.getPid()));
		}
		return packageArrayList;
	}

	public void queryCurrentPackage(int uid){
		OrderDao orderDao = new OrderDaoImp();
		ArrayList<Order> orderArrayList = orderDao.queryCurrent(uid);

		System.out.println("查询用户"+uid+"当前套餐");
		PackageDao packageDao = new PackageDaoImp();
		System.out.println("套餐 全国流量 本地流量 电话时长 短信条数 价格：");
		for (Order order : orderArrayList){
			packageDao.query(order.getPid()).print();
		}
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

		System.out.println("用户  套餐  操作     日期");
		for (Order order : orderArrayList){
			order.print();
		}
	}
}
