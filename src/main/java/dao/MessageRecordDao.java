package dao;

import po.MessageRecord;

import java.time.LocalDate;
import java.util.ArrayList;

public interface MessageRecordDao {
	void insert(MessageRecord messageRecord);
	ArrayList<MessageRecord> queryAll(int uid);
	ArrayList<MessageRecord> querybyMonth(int uid, LocalDate date);
	MessageRecord getAmountByMonth(int uid, LocalDate date);

}
