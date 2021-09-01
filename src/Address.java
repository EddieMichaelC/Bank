
public class Address {
	
	private String street, city, state;
	private int zipcode;
	
	public Address(String st, String c, String s,int z) {
		street=st;
		city=c;
		state=s;
		zipcode=z;
	}
	
	public String getFullAddress() {
		return street+"\n                  "+city+", "+state+"\n                  "+zipcode;
	}
	
	public String getState() {
		return state;
	}
	
	public String getStreet(){
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public int getZip() {
		return zipcode;
	}

}
