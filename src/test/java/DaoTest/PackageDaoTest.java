package DaoTest;

import dao.PackageDao;
import dao.daoImp.PackageDaoImp;
import org.junit.Assert;
import org.junit.Test;
import po.Package;

public class PackageDaoTest {
	/**
	 * 测试 insert()方法
	 */
	@Test
	public void testInsert(){
		PackageDao packageTest = new PackageDaoImp();

		Package packages = new Package(0, 50, 20, 8);

		packageTest.insert(packages);
	}


	/**
	 * 测试 query()方法/*
	 */
	@Test
	public void testQuery(){
		PackageDao packageTest = new PackageDaoImp();
		Package packages = packageTest.query(1);
		Package apackage = new Package(1,0,50,20,8);
		Assert.assertTrue(packages.equal(apackage));
	}
}
