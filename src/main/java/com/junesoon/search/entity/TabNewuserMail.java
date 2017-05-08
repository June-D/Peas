package com.junesoon.search.entity;

import java.sql.Timestamp;

/**
 * TabNewuserMail entity. @author MyEclipse Persistence Tools
 */
public class TabNewuserMail extends AbstractTabNewuserMail implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TabNewuserMail() {
	}

	/** full constructor */
	public TabNewuserMail(String id, String userName, Timestamp createtime,
			Timestamp pasttime) {
		super(id, userName, createtime, pasttime);
	}

}
