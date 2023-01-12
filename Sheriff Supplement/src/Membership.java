
public class Membership {

	protected String username;
	protected String password;
	protected int month;
	public Membership(String username, String password, int month) {
		super();
		this.username = username;
		this.password = password;
		this.month = month;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getMonth() {
		return month;
	}
	@Override
	public String toString() {
		return "Membership [username=" + username + ", password=" + password + ", month=" + month + "]";
	}
	
	
	
	
}
