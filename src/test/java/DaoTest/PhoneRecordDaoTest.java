package DaoTest;

import dao.PhoneRecordDao;
import dao.daoImp.PhoneRecordDaoImp;
import org.junit.Test;
import po.PhoneRecord;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;

public class PhoneRecordDaoTest {

	/**
	 * 测试 insert()方法
	 */
	@Test
	public void testInsert(){
		PhoneRecordDao phoneRecordTest = new PhoneRecordDaoImp();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date parsed = format.parse("2018-10-29");
			Date date =new Date(parsed.getTime());
			PhoneRecord phoneRecord = new PhoneRecord(1,10, 5,date);
			phoneRecordTest.insert(phoneRecord);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}


	/**
	 * 测试 query()方法/*
	 */
	@Test
	public void testQuery(){
		PhoneRecordDao phoneRecordTest = new PhoneRecordDaoImp();

		for (PhoneRecord phoneRecord : phoneRecordTest.queryAll(1)){
			System.out.print(phoneRecord.getUid());
			System.out.print(phoneRecord.getTime());
			System.out.print(phoneRecord.getPrice());
			System.out.println(phoneRecord.getEnd_time());
		}

	}

	@Test
	public void testQuerybyMonth(){
		PhoneRecordDao phoneRecordTest = new PhoneRecordDaoImp();

		LocalDate today = LocalDate.now();

			for (PhoneRecord phoneRecord : phoneRecordTest.querybyMonth(1,today)){
				System.out.print(phoneRecord.getUid());
				System.out.print(phoneRecord.getTime());
				System.out.print(phoneRecord.getPrice());
				System.out.println(phoneRecord.getEnd_time());
			}


	}
}
