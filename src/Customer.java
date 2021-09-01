
public class Customer {
	
	private Name name;
	private Address add;
	private String accNo;
	
	public Customer(Name n, Address a, String acc){
		name= n;
		add=a;
		accNo=acc;
	}
	
	public String getAccNo() {
		return accNo;
	}
	
	public String getName() {
		return name.getFName()+" "+name.getLName();
	}
	
	public String getAddr() {
		return "Customer Initials: " + name.getInitials() + "\nAddress: " +add.getFullAddress() + "\nAccount Number: " + getAccNo();
	}

	public void changeAccNo(String s) {
		accNo=s;
	}
	
	public String toString() {
		return "Name: "+getName()+"\nAccount Number: "+accNo;
	}
}
