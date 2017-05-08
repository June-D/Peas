package com.junesoon.search.entity;

import java.sql.Timestamp;

/**
 * TabNewpassMail entity. @author MyEclipse Persistence Tools
 */
public class TabNewpassMail extends AbstractTabNewpassMail implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TabNewpassMail() {
	}

	/** full constructor */
	public TabNewpassMail(String id, String username, Timestamp createdate,
			Timestamp pastdate) {
		super(id, username, createdate, pastdate);
	}

}
