package DaoTest;

import dao.FlowRecordDao;
import dao.daoImp.FlowRecordDaoImp;
import org.junit.Test;
import po.FlowRecord;
import utils.Flowtype;

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

		Date date =Date.valueOf(LocalDate.now());
		FlowRecord flowRecord = new FlowRecord(1,200, 16,date, Flowtype.本地);
		flowRecordTest.insert(flowRecord);
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
