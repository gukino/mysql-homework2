package dao;

import po.Package;

import java.util.ArrayList;

public interface PackageDao {
	void insert(Package packages);
	ArrayList<Package> query(int pid);

}
