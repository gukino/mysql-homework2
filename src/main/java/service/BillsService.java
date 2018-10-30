package service;

import utils.Flowtype;

public interface BillsService {
	void getBillsByLastMonth(int uid);
	void addCall(int uid,int amount);
	void addFlow(int uid,int amount, Flowtype flowtype);
	void addMessage(int uid,int amount);

}
