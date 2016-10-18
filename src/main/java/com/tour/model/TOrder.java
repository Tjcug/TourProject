package com.tour.model;

import java.util.Date;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable {

	// Fields

	private long id;
	private TUser TUserByOrderFromuser;
	private TUser TUserByOrderTouser;
	private Integer type;
	private long assistantId;
	private double price;
	private boolean state;
	private Date time;
	private Date paytime;

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** minimal constructor */
	public TOrder(Date time, Date paytime) {
		this.time = time;
		this.paytime = paytime;
	}

	/** full constructor */
	public TOrder(TUser TUserByOrderFromuser, TUser TUserByOrderTouser,
			Integer type, long assistantId, double price, boolean state,
			Date time, Date paytime) {
		this.TUserByOrderFromuser = TUserByOrderFromuser;
		this.TUserByOrderTouser = TUserByOrderTouser;
		this.type = type;
		this.assistantId = assistantId;
		this.price = price;
		this.state = state;
		this.time = time;
		this.paytime = paytime;
	}

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TUser getTUserByOrderFromuser() {
		return this.TUserByOrderFromuser;
	}

	public void setTUserByOrderFromuser(TUser TUserByOrderFromuser) {
		this.TUserByOrderFromuser = TUserByOrderFromuser;
	}

	public TUser getTUserByOrderTouser() {
		return this.TUserByOrderTouser;
	}

	public void setTUserByOrderTouser(TUser TUserByOrderTouser) {
		this.TUserByOrderTouser = TUserByOrderTouser;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public long getAssistantId() {
		return this.assistantId;
	}

	public void setAssistantId(long assistantId) {
		this.assistantId = assistantId;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getPaytime() {
		return this.paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

}