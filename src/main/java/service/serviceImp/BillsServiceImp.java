package service.serviceImp;

import dao.FlowRecordDao;
import dao.MessageRecordDao;
import dao.PhoneRecordDao;
import dao.daoImp.FlowRecordDaoImp;
import dao.daoImp.MessageRecordDaoImp;
import dao.daoImp.PhoneRecordDaoImp;
import po.FlowRecord;
import po.MessageRecord;
import po.PhoneRecord;
import po.Package;
import service.BillsService;
import service.OrderService;
import utils.Flowtype;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class BillsServiceImp implements BillsService {

	static double callPrice=0.5;
	static double messagePrice=0.1;
	static double localFlowPrice=0.5;
	static double globalFlowPrice=1;


	Package calPackage(ArrayList<Package> arrayList){
		Package pack = new Package();
		for (Package p : arrayList){
			pack.setCall(pack.getCall()+p.getCall());
			pack.setMessage(pack.getMessage()+p.getMessage());
			pack.setLocalFlow(pack.getLocalFlow()+p.getLocalFlow());
			pack.setGlobalFlow(pack.getGlobalFlow()+p.getGlobalFlow());
		}
		return pack;
	}

	@Override
	public void getBillsByLastMonth(int uid) {
		int callAmount=0;
		int messageAmount=0;
		int localFlowAmount=0;
		int globalFlowAmount=0;
		int packagePrice=0;

		double price=0;
		PhoneRecordDao phoneRecordDao = new PhoneRecordDaoImp();
		FlowRecordDao flowRecordDao = new FlowRecordDaoImp();
		MessageRecordDao messageRecordDao = new MessageRecordDaoImp();

		LocalDate today = LocalDate.now();
//		today = today.minusMonths(1);
		PhoneRecord phoneRecord = phoneRecordDao.getAmountByMonth(uid,today);
		callAmount+=phoneRecord.getTime();
		price+=phoneRecord.getPrice();

		FlowRecord flowRecord = flowRecordDao.getAmountByMonth(uid,today,Flowtype.本地);
		localFlowAmount+=flowRecord.getAmount();
		price+=flowRecord.getPrice();

		flowRecord = flowRecordDao.getAmountByMonth(uid,today,Flowtype.全国);
		globalFlowAmount+=flowRecord.getAmount();
		price+=flowRecord.getPrice();

		MessageRecord messageRecord = messageRecordDao.getAmountByMonth(uid,today);
		messageAmount+=messageRecord.getAmount();
		price+=messageRecord.getPrice();

		OrderService orderService= new OrderServiceImp();

		for (Package p : orderService.getCurrentPackage(uid)){
			packagePrice+=p.getPrice();
		}
		price+=packagePrice;

		int month = today.minusMonths(1).getMonthValue();
		System.out.println(month+1+"月的账单详情：");
		System.out.println("用户 全国流量/mb 本地流量/mb 电话时长/min 短信条数 套餐费 总额");
		System.out.println("  "+uid+"      "+globalFlowAmount+"       "+localFlowAmount+"         "+callAmount+"        "+messageAmount+"      "+packagePrice+"      "+price);
	}

	double cal(int amount,int currentAmount,int packageAmount,double price){
		if (packageAmount>currentAmount){
			if (amount<(packageAmount-currentAmount))
				return 0;
			else
				return (amount-(packageAmount-currentAmount))*price;
		}else{
			return amount*price;
		}
	}

	double calCallFee(int amount, int currentAmount,int packageAmount){
		return  cal(amount,currentAmount,packageAmount,callPrice);
	}

	double calFlowFee(int amount, int currentAmount,Package apackage,Flowtype flowtype){

		if (flowtype.equals(Flowtype.本地)) {
			return cal(amount,currentAmount,apackage.getLocalFlow(),localFlowPrice);

		}else{
			return cal(amount,currentAmount,apackage.getGlobalFlow(),globalFlowPrice);
		}
	}

	double calMessageFee(int amount, int currentAmount,int packageAmount){
		return cal(amount,currentAmount,packageAmount,messagePrice);

	}

	@Override
	public void addCall(int uid, int amount) {
		OrderService orderService = new OrderServiceImp();
		PhoneRecordDao phoneRecordDao = new PhoneRecordDaoImp();

		Package apackage = calPackage(orderService.getCurrentPackage(uid));
		LocalDate today = LocalDate.now();
		PhoneRecord phoneRecord = phoneRecordDao.getAmountByMonth(uid,today);

		double price = calCallFee(amount,phoneRecord.getTime(),apackage.getCall());

		PhoneRecord addRecord = new PhoneRecord(uid,amount,price,Date.valueOf(today));
		phoneRecordDao.insert(addRecord);
		System.out.println("添加用户"+uid+"通话记录，通话时间："+amount+"，资费："+price);
	}

	@Override
	public void addFlow(int uid, int amount, Flowtype flowtype) {
		OrderService orderService = new OrderServiceImp();
		FlowRecordDao flowRecordDao = new FlowRecordDaoImp();

		Package apackage = calPackage(orderService.getCurrentPackage(uid));
		LocalDate today = LocalDate.now();
		FlowRecord flowRecord = flowRecordDao.getAmountByMonth(uid,today,flowtype);

		double price = calFlowFee(amount,flowRecord.getAmount(),apackage,flowtype);

		FlowRecord addRecord = new FlowRecord(uid,amount,price,Date.valueOf(today),flowtype);
		flowRecordDao.insert(addRecord);
		System.out.println("添加用户"+uid+flowtype.toString()+"流量记录，流量大小："+amount+"，资费："+price);
	}

	@Override
	public void addMessage(int uid, int amount) {
		OrderService orderService = new OrderServiceImp();
		MessageRecordDao messageRecordDao = new MessageRecordDaoImp();

		Package apackage = calPackage(orderService.getCurrentPackage(uid));
		LocalDate today = LocalDate.now();
		MessageRecord messageRecord = messageRecordDao.getAmountByMonth(uid,today);

		double price = calMessageFee(amount,messageRecord.getAmount(),apackage.getMessage());

		MessageRecord addRecord = new MessageRecord(uid,amount,price,Date.valueOf(today));
		messageRecordDao.insert(addRecord);
		System.out.println("添加用户"+uid+"短信记录，短信数量："+amount+"，资费："+price);
	}

}
