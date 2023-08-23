package TO;


public class User {
	
	private String username;
	private String password;
	private String role;
	private String name;
	
	
	public User(String username, String password, String name, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	

}
