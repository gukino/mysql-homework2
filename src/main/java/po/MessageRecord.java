package po;


import java.sql.Date;

public class MessageRecord {
	int uid;
	int amount;
	double price;
	Date end_time;

	public MessageRecord(int uid, int amount, double price, Date end_time) {
		this.uid = uid;
		this.amount = amount;
		this.price = price;
		this.end_time = end_time;
	}


	public MessageRecord() {
		this.amount = 0;
		this.price = 0;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
