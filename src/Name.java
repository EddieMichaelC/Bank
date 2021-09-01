
public class Name {
	
	private String firstName;
	private String lastName;
	
	public Name(String fn, String ln){
		firstName=fn;
		lastName=ln;
	}
	
	public String getName() {
		return firstName+" "+lastName;
	}
	
	public String getInitials() { 
		return firstName.substring(0,1).toUpperCase()+ " "+ lastName.substring(0,1).toUpperCase();
	}
	
	public String getLName() {
		return lastName;
	}
	
	public String getFName() {
		return firstName;
	}

}
