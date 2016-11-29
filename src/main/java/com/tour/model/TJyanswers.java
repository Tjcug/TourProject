package com.tour.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TJyanswers entity. @author MyEclipse Persistence Tools
 */

public class TJyanswers implements java.io.Serializable {

	// Fields

	private long id;
	private TUser TUser;
	private TJyquestions TJyquestions;
	private boolean state;
	private double fromuserscore;
	private double touserscore;
	private Date createTime;
	private Set TJyanswerscontents = new HashSet(0);

	// Constructors

	/** default constructor */
	public TJyanswers() {
	}

	/** minimal constructor */
	public TJyanswers(TJyquestions TJyquestions, Date createTime) {
		this.TJyquestions = TJyquestions;
		this.createTime = createTime;
	}

	/** full constructor */
	public TJyanswers(TUser TUser, TJyquestions TJyquestions, boolean state,
			double fromuserscore, double touserscore, Date createTime,
			Set TJyanswerscontents) {
		this.TUser = TUser;
		this.TJyquestions = TJyquestions;
		this.state = state;
		this.fromuserscore = fromuserscore;
		this.touserscore = touserscore;
		this.createTime = createTime;
		this.TJyanswerscontents = TJyanswerscontents;
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

	public TJyquestions getTJyquestions() {
		return this.TJyquestions;
	}

	public void setTJyquestions(TJyquestions TJyquestions) {
		this.TJyquestions = TJyquestions;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public double getFromuserscore() {
		return this.fromuserscore;
	}

	public void setFromuserscore(double fromuserscore) {
		this.fromuserscore = fromuserscore;
	}

	public double getTouserscore() {
		return this.touserscore;
	}

	public void setTouserscore(double touserscore) {
		this.touserscore = touserscore;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set getTJyanswerscontents() {
		return this.TJyanswerscontents;
	}

	public void setTJyanswerscontents(Set TJyanswerscontents) {
		this.TJyanswerscontents = TJyanswerscontents;
	}

}