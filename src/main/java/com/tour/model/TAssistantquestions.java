package com.tour.model;

import java.util.Date;

/**
 * TAssistantquestions entity. @author MyEclipse Persistence Tools
 */

public class TAssistantquestions implements java.io.Serializable {

	// Fields

	private long id;
	private TUser TUser;
	private String content;
	private boolean state;
	private double reward;
	private Date time;
	private double longitude;
	private double latitude;
	// Constructors

	/** default constructor */
	public TAssistantquestions() {
	}

	/** minimal constructor */
	public TAssistantquestions(String content, Date time) {
		this.content = content;
		this.time = time;
	}

	/** full constructor */
	public TAssistantquestions(TUser TUser, String content, boolean state,
			double reward, Date time) {
		this.TUser = TUser;
		this.content = content;
		this.state = state;
		this.reward = reward;
		this.time = time;
	}

	public TAssistantquestions(long id, TUser TUser, String content, boolean state, double reward, Date time, double longitude, double latitude) {
		this.id = id;
		this.TUser = TUser;
		this.content = content;
		this.state = state;
		this.reward = reward;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
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

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

    public boolean isState() {
        return state;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
