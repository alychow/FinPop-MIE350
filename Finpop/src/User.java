

import java.util.ArrayList;
import java.util.Date;

public class User {
	
	private int userid;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	ArrayList<UserPortfolio> port = new ArrayList();

	public User(int userid, String firstName, String lastName, String username, String password){
		this.setUserid(userid);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPassword(password);
		this.setUsername(username);
	}
	
	public User(){
		this.firstName = "";
		this.userid = -1;
		this.lastName = "";
		this.username = "";
		this.password = "";
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String s) {
		this.username = s;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String s) {
		this.password = s;
	}
}