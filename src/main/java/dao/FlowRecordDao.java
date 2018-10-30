package dao;

import po.FlowRecord;
import utils.Flowtype;

import java.time.LocalDate;
import java.util.ArrayList;

public interface FlowRecordDao {
	void insert(FlowRecord flowRecord);
	ArrayList<FlowRecord> queryAll(int uid);
	ArrayList<FlowRecord> querybyMonth(int uid, LocalDate date, Flowtype flowtype);
	FlowRecord getAmountByMonth(int uid, LocalDate date, Flowtype flowtype);

}
