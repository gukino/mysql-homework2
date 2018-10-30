package ServiceTest;

import org.junit.Test;
import service.OrderService;

public class OrderServiceTest {
	/**
	 * 测试 query()方法/*
	 */
	@Test
	public void testQuery(){
		System.out.println("用户 套餐 操作 日期");
		new OrderService().queryHistory(1);
	}
}
