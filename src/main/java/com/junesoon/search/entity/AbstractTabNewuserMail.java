package com.junesoon.search.entity;

import java.sql.Timestamp;

/**
 * AbstractTabNewuserMail entity provides the base persistence definition of the
 * TabNewuserMail entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTabNewuserMail extends
		com.junesoon.search.action.regtionAction implements java.io.Serializable {

	// Fields

	private String id;
	private String userName;
	private Timestamp createtime;
	private Timestamp pasttime;

	// Constructors

	/** default constructor */
	public AbstractTabNewuserMail() {
	}

	/** full constructor */
	public AbstractTabNewuserMail(String id, String userName,
			Timestamp createtime, Timestamp pasttime) {
		this.id = id;
		this.userName = userName;
		this.createtime = createtime;
		this.pasttime = pasttime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getPasttime() {
		return this.pasttime;
	}

	public void setPasttime(Timestamp pasttime) {
		this.pasttime = pasttime;
	}

}