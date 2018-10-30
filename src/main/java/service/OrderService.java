package service;

import po.Package;

import java.util.ArrayList;

public interface OrderService {
	ArrayList<Package> getCurrentPackage(int uid);
	void queryCurrentPackage(int uid);
	void addPackage(int uid,int pid);
	void queryHistory(int uid);
	void deletePackage(int uid,int pid);

}
