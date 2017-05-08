package com.junesoon.search.entity;

import java.sql.Timestamp;

/**
 * AbstractTabUserinfoBase entity provides the base persistence definition of
 * the TabUserinfoBase entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTabUserinfoBase extends
		com.junesoon.search.action.regtionAction implements java.io.Serializable {

	// Fields

	private String userName;
	private String password;
	private String email;
	private Timestamp createTime;
	private Timestamp lastLoginTime;
	private String userFlag;

	// Constructors

	/** default constructor */
	public AbstractTabUserinfoBase() {
	}

	/** full constructor */
	public AbstractTabUserinfoBase(String userName, String password,
			String email, Timestamp createTime, Timestamp lastLoginTime,
			String userFlag) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.createTime = createTime;
		this.lastLoginTime = lastLoginTime;
		this.userFlag = userFlag;
	}

	// Property accessors

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getUserFlag() {
		return this.userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}

}