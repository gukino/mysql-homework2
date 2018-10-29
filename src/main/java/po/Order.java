package po;

import utils.Operate;

import java.sql.Date;

public class Order {
	int uid;
	int pid;
	Operate operate;
	Date end_time;

	public Order(int uid, int pid, Operate operate, Date end_time) {
		this.uid = uid;
		this.pid = pid;
		this.operate = operate;
		this.end_time = end_time;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Operate getOperate() {
		return operate;
	}

	public void setOperate(Operate operate) {
		this.operate = operate;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
}
