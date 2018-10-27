package po;


import java.util.Date;

public class Phone_record {
	int uid;
	int time;
	double price;
	java.sql.Date end_time;

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
