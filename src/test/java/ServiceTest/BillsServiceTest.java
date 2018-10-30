package ServiceTest;

import org.junit.Test;
import service.BillsService;
import service.OrderService;
import service.serviceImp.BillsServiceImp;
import service.serviceImp.OrderServiceImp;

public class BillsServiceTest {

	/**
	 * 测试 getBillsByLastMonth()方法/*
	 */
	@Test
	public void testGetBillsByLastMonth() {

		BillsService billsService  = new BillsServiceImp();
		billsService.getBillsByLastMonth(1);
	}
	
}
