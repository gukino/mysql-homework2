package DaoTest;

import dao.OrderDao;
import dao.daoImp.OrderDaoImp;
import org.junit.Test;
import po.Order;
import utils.Operate;

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
		Order order = new Order(1,1, Operate.订购,date );

		orderTest.insert(order);
	}


	/**
	 * 测试 query()方法/*
	 */
	@Test
	public void testQuery(){
		OrderDao orderTest = new OrderDaoImp();

		for (Order order : orderTest.query(1)){
			System.out.print(order.getUid()+order.getPid());
			System.out.print(order.getOperate());
			System.out.println(order.getEnd_time());
		}
	}


}
