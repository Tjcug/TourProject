package com.tour.model;

import java.util.Date;

/**
 * TUserlocation entity. @author MyEclipse Persistence Tools
 */

public class TUserlocation implements java.io.Serializable {

	// Fields

	private TUserlocationId id;
	private TUser TUser;
	private double longitude;
	private double latitude;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TUserlocation() {
	}

	/** minimal constructor */
	public TUserlocation(TUserlocationId id, TUser TUser) {
		this.id = id;
		this.TUser = TUser;
	}

	/** full constructor */
	public TUserlocation(TUserlocationId id, TUser TUser, double longitude,
			double latitude, Date createTime) {
		this.id = id;
		this.TUser = TUser;
		this.longitude = longitude;
		this.latitude = latitude;
		this.createTime = createTime;
	}

	// Property accessors

	public TUserlocationId getId() {
		return this.id;
	}

	public void setId(TUserlocationId id) {
		this.id = id;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
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

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}