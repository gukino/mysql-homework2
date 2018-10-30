package service;

import service.serviceImp.BillsServiceImp;
import service.serviceImp.OrderServiceImp;

public class Main {
	public static void main(String args[]) {
		BillsService billsService = new BillsServiceImp();
		OrderService orderService = new OrderServiceImp();

//		//获得上个月的账单
//		billsService.getBillsByLastMonth();
//		//添加通话记录
//		billsService.addCall();
//		//添加流量使用记录
//		billsService.addFlow();
//		//添加短信记录
//		billsService.addMessage();
//
//		//查询现在当月生效的套餐
//		orderService.queryCurrentPackage();
//		//查询套餐订购，退订的历史记录
//		orderService.queryHistory();
//		//订购套餐
//		orderService.addPackage();
//		//退订套餐
//		orderService.deletePackage();
	}
}
