package po;

public class Package {
	int pid;
	int flow;
	int call;
	int message;
	double price;

	public Package(int flow, int call, int message, double price) {
		this.flow = flow;
		this.call = call;
		this.message = message;
		this.price = price;
	}

	public Package(int pid, int flow, int call, int message, double price) {
		this.pid = pid;
		this.flow = flow;
		this.call = call;
		this.message = message;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public boolean equal(Package pack){
		return this.call==pack.getCall() && this.flow==pack.getFlow() && this.price==pack.getPrice()
			&& this.pid==pack.getPid() && this.message==pack.getMessage();
	}

	public void print(){
		System.out.println(this.pid+"  "+this.flow+" " +this.call+" "+this.message+" "+this.price);
	}
}
