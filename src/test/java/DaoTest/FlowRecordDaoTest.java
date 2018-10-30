package DaoTest;

import dao.FlowRecordDao;
import dao.daoImp.FlowRecordDaoImp;
import org.junit.Test;
import po.FlowRecord;
import po.Order;
import utils.Flowtype;
import utils.Operate;
import utils.State;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class FlowRecordDaoTest {
	/**
	 * 测试 insert()方法
	 */
	@Test
	public void testInsert(){
		FlowRecordDao flowRecordTest = new FlowRecordDaoImp();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date parse1 = format.parse("2018-10-29");
			java.util.Date parse2 = format.parse("2018-09-21");
			java.util.Date parse3 = format.parse("2018-09-11");
			java.util.Date parse4 = format.parse("2018-08-24");
			java.util.Date parse5 = format.parse("2018-07-22");


			flowRecordTest.insert(new FlowRecord(1,300, 16,new Date(parse3.getTime()), Flowtype.本地));

			flowRecordTest.insert(new FlowRecord(1,600, 16,new Date(parse3.getTime()), Flowtype.全国));

			flowRecordTest.insert(new FlowRecord(1,500, 16,new Date(parse2.getTime()), Flowtype.本地));

			flowRecordTest.insert(new FlowRecord(1,100, 16,new Date(parse2.getTime()), Flowtype.全国));

			flowRecordTest.insert(new FlowRecord(1,200, 16,new Date(parse1.getTime()), Flowtype.本地));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 测试 query()方法/*
	 */
	@Test
	public void testQuery(){
		FlowRecordDao flowRecordTest = new FlowRecordDaoImp();

		for (FlowRecord flowRecord : flowRecordTest.queryAll(1)){
			System.out.print(flowRecord.getUid());
			System.out.print(flowRecord.getAmount());
			System.out.print(flowRecord.getPrice());
			System.out.println(flowRecord.getEnd_time());
		}

	}

	@Test
	public void testQuerybyMonth(){
		FlowRecordDao flowRecordTest = new FlowRecordDaoImp();

		LocalDate today = LocalDate.now();

		for (FlowRecord flowRecord : flowRecordTest.querybyMonth(1,today,Flowtype.全国)){
			System.out.print(flowRecord.getUid()+" "+flowRecord.getAmount()+" "+flowRecord.getPrice()+" "+flowRecord.getEnd_time());
		}

		for (FlowRecord flowRecord : flowRecordTest.querybyMonth(1,today,Flowtype.本地)){
			System.out.print(flowRecord.getUid()+" "+flowRecord.getAmount()+" "+flowRecord.getPrice()+" "+flowRecord.getEnd_time());
		}


	}
}
