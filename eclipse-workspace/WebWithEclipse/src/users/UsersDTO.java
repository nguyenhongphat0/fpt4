package users;

public class UsersDTO {
	private String username;
	private String password;
	private String fullname;
	private boolean is_admin;
	
	public UsersDTO() {	
		super();
	}
	
	public UsersDTO(String username, String password, String fullname, boolean is_admin) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.is_admin = is_admin;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public boolean isIs_admin() {
		return is_admin;
	}
	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
	
	
}
