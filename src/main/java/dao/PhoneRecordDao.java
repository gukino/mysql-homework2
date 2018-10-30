package dao;

import po.PhoneRecord;

import java.time.LocalDate;
import java.util.ArrayList;

public interface PhoneRecordDao {

	void insert(PhoneRecord phoneRecord);
	ArrayList<PhoneRecord> queryAll(int uid);
	ArrayList<PhoneRecord> querybyMonth(int uid, LocalDate date);
	PhoneRecord getAmountByMonth(int uid, LocalDate date);

}
