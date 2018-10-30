package po;

import utils.Operate;
import utils.State;

import java.sql.Date;

public class Order {
	int uid;
	int pid;
	Operate operate;
	Date end_time;
	State state;

	public Order(int uid, int pid, Operate operate, Date end_time, State state) {
		this.uid = uid;
		this.pid = pid;
		this.operate = operate;
		this.end_time = end_time;
		this.state = state;
	}

	public Order(int uid, int pid, Operate operate, Date end_time) {
		this.uid = uid;
		this.pid = pid;
		this.operate = operate;
		this.end_time = end_time;
		if (operate.equals(Operate.退订))
			this.state=State.失效;
		else {

			this.state = State.待生效;
		}
	}

	public Order(int uid, int pid, Operate operate) {
		this.uid = uid;
		this.pid = pid;
		this.operate = operate;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void print(){
		System.out.println(Integer.toString(this.uid)+"     "+Integer.toString(this.pid)+"    "+
			this.operate.toString()+"   "+this.end_time);
	}
}
