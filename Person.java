package Pac1;

public class Person {
	String firstName;
	String lastName;
	char Gender;
	String phone;
	
	
	public  Person(String fn, String ln, char g,String p) {
		this.firstName=fn;
		this.lastName=ln;
		this.Gender=g;
		this.phone=p;
		
	}
	
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
