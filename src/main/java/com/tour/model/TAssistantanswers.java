package com.tour.model;

import java.util.Date;

/**
 * TAssistantanswers entity. @author MyEclipse Persistence Tools
 */

public class TAssistantanswers implements java.io.Serializable {

	// Fields

	private long id;
	private TUser TUser;
	private long questionId;
	private boolean state;
	private double fromuserscore;
	private double touserscore;
	private String answer;
	private Date time;

	// Constructors

	/** default constructor */
	public TAssistantanswers() {
	}

	/** minimal constructor */
	public TAssistantanswers(long questionId, Date time) {
		this.questionId = questionId;
		this.time = time;
	}

	/** full constructor */
	public TAssistantanswers(TUser TUser, long questionId, boolean state,
			double fromuserscore, double touserscore, String answer, Date time) {
		this.TUser = TUser;
		this.questionId = questionId;
		this.state = state;
		this.fromuserscore = fromuserscore;
		this.touserscore = touserscore;
		this.answer = answer;
		this.time = time;
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

	public long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
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

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}