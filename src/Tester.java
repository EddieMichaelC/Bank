import javax.swing.JOptionPane;

public class Tester {
	
	public static void main(String args[]) {
		Database d = new Database();
		boolean done = false;
		String acc;
		
		while(!done) {
			int menu = GetData.getInt("Eddie's Bank of America \n\nWhat would you like to do today?\n\n1. Create New Account\n2. Update Existing Account \n3. Close an Account\n4. View Account Information\n5. Exit");
			if (menu == 2) {
				menu = 6;
			}
			switch(menu) {
			case(1): //Initializes a new account.
				Name n = new Name(GetData.getWord("Enter First Name."),GetData.getWord("Enter Last Name"));
				Address a = new Address(GetData.getWord("Enter Street"),GetData.getWord("Enter City"),GetData.getWord("Enter State"),GetData.getInt("Enter Zipcode"));
				String an = GetData.getWord("Enter Account Number");
				double b = GetData.getDouble("Enter Balance");
				d.add(new BankAccount(new Customer(n,a,an),b));
			break;
			case(6): //Updates account by depositing or withdrawing
				acc = GetData.getWord("Enter Account Number");
				if (d.accExists(acc)){
					int update = GetData.getInt("Would you like to: \n1. Deposit \n2. Withdraw");
					double amt;
					switch(update) {
					case(1):
						amt = GetData.getDouble("How much to deposit?");
						d.allowAccess(acc).deposit(amt);
					break;
					case(2):
						amt = GetData.getDouble("How much to withdraw?");
						d.allowAccess(acc).withdraw(amt);
					break;
					default: 
						JOptionPane.showMessageDialog(null, "Invalid input");
					break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Account Not Found");
				}
				
			break;
			case(3): //Closes an account
				acc = GetData.getWord("Enter Account Number");
				if (d.accExists(acc)) {
					d.remove(acc);
				} else {
					JOptionPane.showMessageDialog(null, "Account not found.");
				}
			break;
			case(4): //Views account(s) information
				int view = GetData.getInt("\nWhat would you like to do? \n\n1. View a single account \n2. View all active accounts \n3. View all closed accounts \n4. View all account addresses");
				switch(view) {
				case(1):
					acc = GetData.getWord("Enter Account Number");
					if(d.accExists(acc)) {
						d.displayAccount(acc);
					} else {
						JOptionPane.showMessageDialog(null, "Account not found.");
					}
				break;
				case(2):
					d.displayActiveAccounts();
				break;
				case(3):
					d.displayRemovedAccounts();
				break;
				case(4):
					d.displayAddresses();
				break;
				default: 
					JOptionPane.showMessageDialog(null, "Invalid input");
				break;
				}
			break;
			case(5): //exits the program
				done=true;
			break;	
			case(JOptionPane.CANCEL_OPTION):
				done = true;
			break;
			default: //if number entered is not 1-5
				JOptionPane.showMessageDialog(null, "Invalid Input");
			break;
			}
		}
		
		
	}
	

}
