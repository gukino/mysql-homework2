package DaoTest;

import dao.OrderDao;
import dao.daoImp.OrderDaoImp;
import org.junit.Test;
import po.Order;
import utils.Operate;
import utils.State;

import java.sql.Date;
import java.util.Calendar;

public class OrderDaoTest {

	/**
	 * 测试 insert()方法
	 */
	@Test
	public void testInsert(){
		OrderDao orderTest = new OrderDaoImp();
		Date date = new Date(System.currentTimeMillis());

		//System.out.println(date);
		Order order = new Order(1,2, Operate.订购,date , State.生效);

		orderTest.insert(order);
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
