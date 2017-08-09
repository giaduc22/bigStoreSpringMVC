package entity;

import javax.persistence.Column;
import javax.persistence.Id;


@javax.persistence.Entity
@javax.persistence.Table(name="users")
public class User {

	@Id
	@Column(name="username")
	private String username;
	@Column(name="fullname")
	private String fullname;
	@Column(name="password")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
