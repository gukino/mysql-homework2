package dao;

import po.Package;

import java.util.ArrayList;

public interface PackageDao {
	void insert(Package packages);
	Package query(int pid);

}
