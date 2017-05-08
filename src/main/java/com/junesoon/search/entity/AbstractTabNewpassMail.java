package com.junesoon.search.entity;

import java.sql.Timestamp;

/**
 * AbstractTabNewpassMail entity provides the base persistence definition of the
 * TabNewpassMail entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTabNewpassMail extends
		com.junesoon.search.action.regtionAction implements java.io.Serializable {

	// Fields

	private String id;
	private String username;
	private Timestamp createdate;
	private Timestamp pastdate;

	// Constructors

	/** default constructor */
	public AbstractTabNewpassMail() {
	}

	/** full constructor */
	public AbstractTabNewpassMail(String id, String username,
			Timestamp createdate, Timestamp pastdate) {
		this.id = id;
		this.username = username;
		this.createdate = createdate;
		this.pastdate = pastdate;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getPastdate() {
		return this.pastdate;
	}

	public void setPastdate(Timestamp pastdate) {
		this.pastdate = pastdate;
	}

}