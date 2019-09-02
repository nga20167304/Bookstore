package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name="users")
@NamedQueries({
	@NamedQuery(name="Users.findAll",query="SELECT u FROM users u ORDER BY u.fullName"),
	@NamedQuery(name="Users.findByEmail",query="SELECT u FROM users u WHERE u.email= :email"),
	@NamedQuery(name="User.countAll",query="SELECT Count(u) FROM users u")
})
public class Users {
	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Integer userId;
	private String email;
	@Column(name = "full_name")
	private String fullName;
	private String password;

	public Users() {
		
	}
	
	public Users(Integer userId,String email, String fullName, String password) {
		this(email,fullName,password);
		this.userId=userId;
	}
	public Users(String email, String fullName, String password) {
		super();
		this.email=email;
		this.fullName=fullName;
		this.password=password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUser_id(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
