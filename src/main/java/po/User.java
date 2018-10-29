package po;

import utils.Sex;

public class User {
	int uid;
	String name;
	Sex sex;
	double amount;

	public User(int uid, String name, Sex sex, double amount) {
		this.uid = uid;
		this.name = name;
		this.sex = sex;
		this.amount = amount;
	}

	public User(String name, Sex sex, double amount) {

		this.name = name;
		this.sex = sex;
		this.amount = amount;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	public boolean equal(User user){
		if (this.amount==user.amount && this.name.equals(user.name) && this.sex==user.sex && this.uid==user.uid)
			return true;
		else
			return false;
	}
}
