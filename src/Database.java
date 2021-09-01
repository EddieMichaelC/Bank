import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.DateFormat;

public class Database {
	
	private ArrayList<BankAccount> activeAcc;
	private ArrayList<BankAccount> removedAcc;
	private String date;
	
	public Database() { //initializes the active accounts and deleted accounts
		activeAcc = new ArrayList<BankAccount>();
		removedAcc = new ArrayList<BankAccount>();	
	}
	
	public void add(BankAccount b) { //adds a bank account to the active account list
		activeAcc.add(b);
	}
	
	public void displayAccount(String accno){ //displays account data for entered account number, else err.
		int i = search(accno);
		if (i > activeAcc.size()){
			JOptionPane.showMessageDialog(null, "Account Does Not Exist!");
		} else {
			JOptionPane.showMessageDialog(null, activeAcc.get(i).toString());
		}
	}
	
	public void displayActiveAccounts() { //displays all active accounts
		if (activeAcc.size()==0) {
			JOptionPane.showMessageDialog(null, "No Accounts Found");
		} else {
			String g = getDate()+"\n\n";
			
			for (int i = 0; i < activeAcc.size(); i++) {
				g+= activeAcc.get(i).toString()+"\n\n";
			}
			
			JTextArea t = new JTextArea(g,25,20);
			JScrollPane pane = new JScrollPane(t);
			JOptionPane.showMessageDialog(null, pane, "All Active Accounts", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void displayRemovedAccounts() { //displays all inactive accounts
		if(removedAcc.size()==0){
			JOptionPane.showMessageDialog(null, "No Accounts Found.");
		} else {
			String g = getDate()+"\n\n";
			
			for(int i =0;i<removedAcc.size();i++) {
				g+= removedAcc.get(i).getDeletedInfo()+"\n\n";
			}
			
			JTextArea t = new JTextArea(g,25,20);
			JScrollPane pane = new JScrollPane(t);
			JOptionPane.showMessageDialog(null, pane, "All Removed Accounts", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void displayAddresses() {
		if (activeAcc.size()==0) {
			JOptionPane.showMessageDialog(null, "No Accounts Found");
		} else {
			String g = getDate() + "\n\n";
			
			for (int i = 0; i < activeAcc.size(); i++){
				g+= activeAcc.get(i).getCust().getAddr() + "\n\n";
			}
			
			JTextArea t = new JTextArea(g,25,20);
			JScrollPane pane = new JScrollPane(t);
			JOptionPane.showMessageDialog(null, pane, "All Account Addresses", JOptionPane.INFORMATION_MESSAGE);
		}		
	}
	
	private String getDate() { //private method to get date format
		Date d = new Date();
		DateFormat df = DateFormat.getDateInstance();
		date = df.format(d);
		return date;
	}
	
	public int search(String a){ //private method that searches for index of specified bank account
		
		for(int i = 0;i<activeAcc.size();i++) {
			if (activeAcc.get(i).getCust().getAccNo().equalsIgnoreCase(a)) {
				return i;
			} 
		}
		
		return activeAcc.size()+1;
	}
	
	public void remove(String accno) { //removes specified account, error if not found
		int i = search(accno);
		if (i>activeAcc.size()) {
			JOptionPane.showMessageDialog(null, "Account Does Not Exist");
		} else {
			removedAcc.add(activeAcc.remove(i));
			JOptionPane.showMessageDialog(null, "Removal Successful!");
		}
	}
	
	public BankAccount allowAccess(String accno) {
		if (search(accno) < activeAcc.size()) {
			return activeAcc.get(search(accno));
		}
		JOptionPane.showMessageDialog(null, "Account Not Found");
		return null;
	}
	
	public boolean accExists(String accno) { //checks if account exists
		int i =search(accno);
		if (i > activeAcc.size()) {
			return false;
		}
		return true;
	}
	
}
