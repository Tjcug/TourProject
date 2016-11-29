package com.tour.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TJyquestions entity. @author MyEclipse Persistence Tools
 */

public class TJyquestions implements java.io.Serializable {

	// Fields

	private long id;
	private TUser TUser;
	private String content;
	private boolean state;
	private double reward;
	private Date createTime;
	private double longitude;
	private double latitude;
	private Set TJyanswerses = new HashSet(0);
	private Set TJyquestionsimages = new HashSet(0);
	private Set TOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public TJyquestions() {
	}

	/** minimal constructor */
	public TJyquestions(TUser TUser, String content, boolean state,
			double reward, Date createTime) {
		this.TUser = TUser;
		this.content = content;
		this.state = state;
		this.reward = reward;
		this.createTime = createTime;
	}

	/** full constructor */
	public TJyquestions(TUser TUser, String content, boolean state,
			double reward, Date createTime, double longitude, double latitude,
			Set TJyanswerses, Set TJyquestionsimages, Set TOrders) {
		this.TUser = TUser;
		this.content = content;
		this.state = state;
		this.reward = reward;
		this.createTime = createTime;
		this.longitude = longitude;
		this.latitude = latitude;
		this.TJyanswerses = TJyanswerses;
		this.TJyquestionsimages = TJyquestionsimages;
		this.TOrders = TOrders;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public double getReward() {
		return this.reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Set getTJyanswerses() {
		return this.TJyanswerses;
	}

	public void setTJyanswerses(Set TJyanswerses) {
		this.TJyanswerses = TJyanswerses;
	}

	public Set getTJyquestionsimages() {
		return this.TJyquestionsimages;
	}

	public void setTJyquestionsimages(Set TJyquestionsimages) {
		this.TJyquestionsimages = TJyquestionsimages;
	}

	public Set getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set TOrders) {
		this.TOrders = TOrders;
	}

}