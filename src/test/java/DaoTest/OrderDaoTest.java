package DaoTest;

import dao.OrderDao;
import dao.daoImp.OrderDaoImp;
import org.junit.Test;
import po.Order;
import po.PhoneRecord;
import utils.Operate;
import utils.State;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderDaoTest {

	/**
	 * 测试 insert()方法
	 */
	@Test
	public void testInsert(){
		OrderDao orderTest = new OrderDaoImp();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date parse1 = format.parse("2018-10-29");
			java.util.Date parse2 = format.parse("2018-09-21");
			java.util.Date parse3 = format.parse("2018-09-11");
			java.util.Date parse4 = format.parse("2018-08-24");
			java.util.Date parse5 = format.parse("2018-07-22");

			orderTest.insert(new Order(1,5, Operate.订购,new Date(parse5.getTime()),State.失效));

			orderTest.insert(new Order(1,5, Operate.退订,new Date(parse4.getTime()),State.失效));
			orderTest.insert(new Order(1,3, Operate.订购,new Date(parse4.getTime()),State.生效));
			orderTest.insert(new Order(1,2, Operate.订购,new Date(parse4.getTime()),State.生效));

			orderTest.insert(new Order(3,2, Operate.订购,new Date(parse3.getTime()),State.生效));

			orderTest.insert(new Order(1,1, Operate.订购,new Date(parse2.getTime()),State.生效));
			orderTest.insert(new Order(3,1, Operate.订购,new Date(parse2.getTime()),State.生效));

			orderTest.insert(new Order(1,4, Operate.订购,new Date(parse1.getTime()),State.待生效));
			orderTest.insert(new Order(3,1, Operate.退订,new Date(parse1.getTime()),State.失效));
		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

	/**
	 * 测试 退订insert()方法
	 */
	@Test
	public void testCancelInsert(){
		OrderDao orderTest = new OrderDaoImp();
		Date date = new Date(System.currentTimeMillis());

		//System.out.println(date);
		Order order = new Order(1,1, Operate.退订,date , State.失效);

		orderTest.insert(order);
	}


	/**
	 * 测试 query()方法/*
	 */
	@Test
	public void testQuery(){
		OrderDao orderTest = new OrderDaoImp();

		for (Order order : orderTest.queryAll(1)){
			System.out.print(order.getUid()+Integer.toString(order.getPid()));
			System.out.print(order.getOperate());
			System.out.println(order.getEnd_time()+order.getState().toString());
		}
	}
}
