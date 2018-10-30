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

		packageTest.insert(new Package(0,100, 20, 20, 10));
		packageTest.insert(new Package(0,200, 20, 20, 12));
		packageTest.insert(new Package(100,200, 50, 20, 14));
		packageTest.insert(new Package(300,300, 50, 30, 17));
		packageTest.insert(new Package(500,500, 50, 30, 20));
		packageTest.insert(new Package(500,1000, 60, 50, 23));
		packageTest.insert(new Package(1000,1000, 60, 50, 25));
		packageTest.insert(new Package(2000,2000, 120, 50, 30));
		packageTest.insert(new Package(5000,5000, 120, 50, 40));
		packageTest.insert(new Package(10000,10000, 300, 100, 50));
	}


	/**
	 * 测试 query()方法/*
	 */
	@Test
	public void testQuery(){
		PackageDao packageTest = new PackageDaoImp();
		Package packages = packageTest.query(1);

	}
}
