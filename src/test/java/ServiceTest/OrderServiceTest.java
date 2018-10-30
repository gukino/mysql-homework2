package ServiceTest;

import org.junit.Test;
import service.OrderService;
import service.serviceImp.OrderServiceImp;

public class OrderServiceTest {
	/**
	 * 测试 queryAll()方法/*
	 */
	@Test
	public void testQueryAll() {
		System.out.println("用户 套餐 操作 日期");
		OrderService orderService = new OrderServiceImp();
		orderService.queryHistory(1);
	}


}
