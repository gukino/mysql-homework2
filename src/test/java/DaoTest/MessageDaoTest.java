package DaoTest;

import dao.MessageRecordDao;
import dao.daoImp.MessageRecordDaoImp;
import org.junit.Test;
import po.MessageRecord;
import utils.Flowtype;

import java.sql.Date;
import java.time.LocalDate;

public class MessageDaoTest {
	/**
	 * 测试 insert()方法
	 */
	@Test
	public void testInsert(){
		MessageRecordDao messageRecordTest = new MessageRecordDaoImp();

		Date date =Date.valueOf(LocalDate.now());
		MessageRecord messageRecord = new MessageRecord(1,20, 2,date);
		messageRecordTest.insert(messageRecord);
	}


	/**
	 * 测试 query()方法/*
	 */
	@Test
	public void testQuery(){
		MessageRecordDao messageRecordTest = new MessageRecordDaoImp();

		for (MessageRecord messageRecord : messageRecordTest.queryAll(1)){
			System.out.print(messageRecord.getUid());
			System.out.print(messageRecord.getAmount());
			System.out.print(messageRecord.getPrice());
			System.out.println(messageRecord.getEnd_time());
		}

	}

	@Test
	public void testQuerybyMonth(){
		MessageRecordDao messageRecordTest = new MessageRecordDaoImp();

		LocalDate today = LocalDate.now();

		for (MessageRecord messageRecord : messageRecordTest.querybyMonth(1,today)){
			System.out.print(messageRecord.getUid());
			System.out.print(messageRecord.getAmount());
			System.out.print(messageRecord.getPrice());
			System.out.println(messageRecord.getEnd_time());
		}


	}
}
