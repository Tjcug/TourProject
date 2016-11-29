package com.tour.model;

import java.util.Date;

/**
 * TReplay entity. @author MyEclipse Persistence Tools
 */

public class TReplay implements java.io.Serializable {

	// Fields

	private long id;
	private TUser TUserByTouser;
	private TDiscuss TDiscuss;
	private TUser TUserByFromuser;
	private String content;
	private String pictures;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TReplay() {
	}

	/** minimal constructor */
	public TReplay(TDiscuss TDiscuss, TUser TUserByFromuser, Date createTime) {
		this.TDiscuss = TDiscuss;
		this.TUserByFromuser = TUserByFromuser;
		this.createTime = createTime;
	}

	/** full constructor */
	public TReplay(TUser TUserByTouser, TDiscuss TDiscuss,
			TUser TUserByFromuser, String content, String pictures,
			Date createTime) {
		this.TUserByTouser = TUserByTouser;
		this.TDiscuss = TDiscuss;
		this.TUserByFromuser = TUserByFromuser;
		this.content = content;
		this.pictures = pictures;
		this.createTime = createTime;
	}

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TUser getTUserByTouser() {
		return this.TUserByTouser;
	}

	public void setTUserByTouser(TUser TUserByTouser) {
		this.TUserByTouser = TUserByTouser;
	}

	public TDiscuss getTDiscuss() {
		return this.TDiscuss;
	}

	public void setTDiscuss(TDiscuss TDiscuss) {
		this.TDiscuss = TDiscuss;
	}

	public TUser getTUserByFromuser() {
		return this.TUserByFromuser;
	}

	public void setTUserByFromuser(TUser TUserByFromuser) {
		this.TUserByFromuser = TUserByFromuser;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}