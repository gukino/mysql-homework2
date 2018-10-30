package service.serviceImp;

import dao.OrderDao;
import dao.PackageDao;
import dao.daoImp.OrderDaoImp;
import dao.daoImp.PackageDaoImp;
import po.Order;
import service.PackageService;

import java.util.ArrayList;

public class PackageServiceImp implements PackageService{

	public void queryCurrentPackage(int uid){
		OrderDao orderDao = new OrderDaoImp();
		ArrayList<Order> orderArrayList = orderDao.queryCurrent(uid);

		System.out.println("查询用户当前套餐");
		PackageDao packageDao = new PackageDaoImp();
		System.out.println("套餐 流量 电话时长 短信条数 价格：");
		for (Order order : orderArrayList){
			packageDao.query(order.getPid()).print();
		}
	}

	public void addPackage(){

	}

}
