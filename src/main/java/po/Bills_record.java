package po;


import java.sql.Date;

public class Bills_record {
	int uid;
	int flow;
	int call;
	int message;
	double price;
	Date date;

	public Bills_record() {
		this.uid=0;
		this.flow=0;
		this.call=0;
		this.message=0;
		this.price=0;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	public int getCall() {
		return call;
	}

	public void setCall(int call) {
		this.call = call;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
