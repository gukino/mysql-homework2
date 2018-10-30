package ServiceTest;

import org.junit.Test;
import service.OrderService;
import service.serviceImp.OrderServiceImp;

public class OrderServiceTest {
	/**
	 * 测试 queryAll()方法/*
	 */
	@Test
	public void testQueryAll1() {
		OrderService orderService = new OrderServiceImp();
		orderService.queryHistory(1);
	}

	@Test
	public void testQueryAll3() {
		OrderService orderService = new OrderServiceImp();
		orderService.queryHistory(3);
	}

	/**
	 * 测试 queryCurrent()方法/*
	 */
	@Test
	public void testQueryCurrent1() {

		OrderService orderService = new OrderServiceImp();
		orderService.queryCurrentPackage(1);
	}
	@Test
	public void testQueryCurrent2() {

		OrderService orderService = new OrderServiceImp();
		orderService.queryCurrentPackage(3);
	}
}
