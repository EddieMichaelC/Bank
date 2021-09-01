import javax.swing.JOptionPane;

public class BankAccount {
	
	private Customer cust;
	private double balance;
	
	public BankAccount(Customer c, double b) {
		cust=c;
		balance=b;
	}
	
	public Customer getCust() {
		return cust;
	}
	
	
	public void deposit(double a) {
		balance+=a;
	}
	
	public void withdraw(double a) {
		if(isValid(a)) {
			balance-=a;
		} else {
			JOptionPane.showMessageDialog(null,"Not Enough Money");
		}
	}
	
	public boolean isValid(double b){
		return b<=balance;
	}
	
	public String toString() {
		return cust.toString()+"\nBalance: "+balance;
	}
	
	public String getDeletedInfo() {
		return cust.toString();
	}

}
