package com.tour.model;

import java.util.Date;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable {

	// Fields

	private long id;
	private TUser TUserByOrderFromuser;
	private TJyquestions TJyquestions;
	private TUser TUserByOrderTouser;
	private Integer type;
	private double price;
	private boolean state;
	private Date createTime;
	private Date paytime;

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** minimal constructor */
	public TOrder(TJyquestions TJyquestions, Date createTime, Date paytime) {
		this.TJyquestions = TJyquestions;
		this.createTime = createTime;
		this.paytime = paytime;
	}

	/** full constructor */
	public TOrder(TUser TUserByOrderFromuser, TJyquestions TJyquestions,
			TUser TUserByOrderTouser, Integer type, double price,
			boolean state, Date createTime, Date paytime) {
		this.TUserByOrderFromuser = TUserByOrderFromuser;
		this.TJyquestions = TJyquestions;
		this.TUserByOrderTouser = TUserByOrderTouser;
		this.type = type;
		this.price = price;
		this.state = state;
		this.createTime = createTime;
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

	public TJyquestions getTJyquestions() {
		return this.TJyquestions;
	}

	public void setTJyquestions(TJyquestions TJyquestions) {
		this.TJyquestions = TJyquestions;
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

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPaytime() {
		return this.paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

}