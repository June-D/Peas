package com.junesoon.search.entity;

import java.sql.Timestamp;

/**
 * TabUserinfoBase entity. @author MyEclipse Persistence Tools
 */
public class TabUserinfoBase extends AbstractTabUserinfoBase implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -1766769125755935230L;

	/** default constructor */
	public TabUserinfoBase() {
	}

	/** full constructor */
	public TabUserinfoBase(String userName, String password, String email,
			Timestamp createTime, Timestamp lastLoginTime, String userFlag) {
		super(userName, password, email, createTime, lastLoginTime, userFlag);
	}

}
