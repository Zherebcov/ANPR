package com.project.anpr.model;

/**
 * @author:Prem Karki
 * @Version:1.0
 * @Date:{${date}
 * 
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.anpr.util.LoginStatus;
import com.project.anpr.util.LoginType;
import com.project.anpr.util.Status;

@SuppressWarnings("serial")
@Entity
@Table(name = "login")
public class Login implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "last_login")
	private Date lastLogin;

	private String password;

	private String username;

	private String email;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "login_type")
	@Enumerated(EnumType.STRING)
	private LoginType loginType;

	@Column(name = "login_status")
	@Enumerated(EnumType.STRING)
	private LoginStatus loginStatus;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LoginStatus getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(LoginStatus loginStatus) {
		this.loginStatus = loginStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
