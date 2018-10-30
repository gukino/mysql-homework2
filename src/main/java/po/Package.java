package po;

public class Package {
	int pid;
	int globalFlow;
	int localFlow;
	int call;
	int message;
	double price;

	public Package() {
		this.globalFlow = 0;
		this.localFlow = 0;
		this.call = 0;
		this.message = 0;
		this.price = 0;
	}


	public Package(int pid, int globalFlow, int localFlow, int call, int message, double price) {
		this.pid = pid;
		this.globalFlow = globalFlow;
		this.localFlow = localFlow;
		this.call = call;
		this.message = message;
		this.price = price;
	}

	public Package(int globalFlow, int localFlow, int call, int message, double price) {
		this.globalFlow = globalFlow;
		this.localFlow = localFlow;
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

	public int getGlobalFlow() {
		return globalFlow;
	}

	public void setGlobalFlow(int globalFlow) {
		this.globalFlow = globalFlow;
	}

	public int getLocalFlow() {
		return localFlow;
	}

	public void setLocalFlow(int localFlow) {
		this.localFlow = localFlow;
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
		return this.call==pack.getCall() && this.globalFlow==pack.getGlobalFlow() && this.price==pack.getPrice()
			&& this.pid==pack.getPid() && this.message==pack.getMessage() && this.localFlow==pack.getLocalFlow();
	}

	public void print(){
		System.out.println(this.pid+"  "+this.globalFlow+"  "+this.localFlow+" " +this.call+" "+this.message+" "+this.price);
	}
}
