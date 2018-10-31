package service;

import service.serviceImp.BillsServiceImp;
import service.serviceImp.OrderServiceImp;
import utils.Flowtype;

public class Main {
	public static void main(String args[]) {
		BillsService billsService = new BillsServiceImp();
		OrderService orderService = new OrderServiceImp();
		long startTime;
		long endTime;

//		//添加通话记录
		startTime=System.currentTimeMillis();   //获取开始时间
		billsService.addCall(1,20);
		endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		System.out.println();

//		//添加流量使用记录
		startTime=System.currentTimeMillis();   //获取开始时间
		billsService.addFlow(1,300, Flowtype.全国);
		endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		System.out.println();

//		//添加短信记录
		startTime=System.currentTimeMillis();   //获取开始时间
		billsService.addMessage(1,20);
		endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		System.out.println();
//
		//获得这个月的账单
		startTime=System.currentTimeMillis();   //获取开始时间
		billsService.getBillsByLastMonth(1);
		endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		System.out.println();

//
		//查询现在当月生效的套餐
		startTime=System.currentTimeMillis();   //获取开始时间
		orderService.queryCurrentPackage(1);
		endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		System.out.println();
//
//		//查询套餐订购，退订的历史记录
		startTime=System.currentTimeMillis();   //获取开始时间
		orderService.queryHistory(1);
		endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		System.out.println();
//
//		//订购套餐
		startTime=System.currentTimeMillis();   //获取开始时间
		orderService.addPackage(1,5);
		endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		System.out.println();
//
		//退订套餐
		startTime=System.currentTimeMillis();   //获取开始时间
		orderService.deletePackage(1,5);
		endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//
	}
}
