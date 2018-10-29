package po;


import java.sql.Date;

public class PhoneRecord {
	int uid;
	int time;
	double price;
	Date end_time;

	public PhoneRecord(int uid, int time, double price, Date end_time) {
		this.uid = uid;
		this.time = time;
		this.price = price;
		this.end_time = end_time;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(java.sql.Date end_time) {
		this.end_time = end_time;
	}
}
