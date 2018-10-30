package ServiceTest;

import org.junit.Test;
import po.Package;
import service.OrderService;
import service.PackageService;
import service.serviceImp.OrderServiceImp;
import service.serviceImp.PackageServiceImp;

public class PackageServiceTest {
	/**
	 * 测试 queryCurrent()方法/*
	 */
	@Test
	public void testQueryCurrent() {

		PackageService packageService = new PackageServiceImp();
		packageService.queryCurrentPackage(1);
	}
}
