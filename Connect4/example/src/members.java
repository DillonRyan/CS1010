
public class members {
	String name;
	String address;
	String yearOfRegistration;
	String email;
	public members(String name, String address, String yearOfRegistration, String email) {
		super();
		this.name = name;
		this.address = address;
		this.yearOfRegistration = yearOfRegistration;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getYearOfRegistration() {
		return yearOfRegistration;
	}
	public void setYearOfRegistration(String yearOfRegistration) {
		this.yearOfRegistration = yearOfRegistration;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "members [name=" + name + ", address=" + address + ", yearOfRegistration=" + yearOfRegistration
				+ ", email=" + email + ", getName()=" + getName() + ", getAddress()=" + getAddress()
				+ ", getYearOfRegistration()=" + getYearOfRegistration() + ", getEmail()=" + getEmail()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
		
	

}

