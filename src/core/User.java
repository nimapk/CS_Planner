package core;

public class User {

	private int id;	
	private String firstName;
	private String lastName;
	//private String email;
	private String major;
	private String username;
	private String password;	
	//private BigDecimal salary;
	
	public User(String firstName, String lastName, 
			String major, String username, String password) {

		this(0, firstName, lastName,  major, username, password);
	}
	
	public User(int id, String firstName, String lastName, 
			String major, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;		
		//this.email = email;
		this.major = major;
		this.username = username;		
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}	
//	public String getEmail() {
	//	return email;
//	}
	public String getMajor() {
		return major;
	}	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}		
	
	@Override
	public String toString() {
		return String
				.format("User [id=%s, firstName=%s, lastName=%s,  major=%s, username=%s, password=%s]",
						id, firstName, lastName,  major, username, password);
	}	
}