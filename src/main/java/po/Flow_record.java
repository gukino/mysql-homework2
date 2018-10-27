package po;

import utils.Flowtype;
import java.util.Date;

public class Flow_record {
	int uid;
	int amount;
	double price;
	java.sql.Date end_time;
	Flowtype type;

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

	public java.sql.Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(java.sql.Date end_time) {
		this.end_time = end_time;
	}

	public Flowtype getType() {
		return type;
	}

	public void setType(Flowtype type) {
		this.type = type;
	}
}
