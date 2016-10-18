package com.tour.model;

/**
 * TDiscusslikes entity. @author MyEclipse Persistence Tools
 */

public class TDiscusslikes implements java.io.Serializable {

	// Fields

	private long id;
	private TUser TUser;
	private TDiscuss TDiscuss;

	// Constructors

	/** default constructor */
	public TDiscusslikes() {
	}

	/** full constructor */
	public TDiscusslikes(TUser TUser, TDiscuss TDiscuss) {
		this.TUser = TUser;
		this.TDiscuss = TDiscuss;
	}

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public TDiscuss getTDiscuss() {
		return this.TDiscuss;
	}

	public void setTDiscuss(TDiscuss TDiscuss) {
		this.TDiscuss = TDiscuss;
	}

}