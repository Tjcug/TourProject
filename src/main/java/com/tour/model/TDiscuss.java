package com.tour.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TDiscuss entity. @author MyEclipse Persistence Tools
 */

public class TDiscuss implements java.io.Serializable {

	// Fields

	private long id;
	private TUser TUser;
	private String content;
	private String category;
	private String pictures;
	private String area;
	private Date createTime;
	private boolean hot;
	private long likesnumber;
	private Set TReplaies = new HashSet(0);
	private Set TDiscusslikeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TDiscuss() {
	}

	/** minimal constructor */
	public TDiscuss(Date createTime) {
		this.createTime = createTime;
	}

	/** full constructor */
	public TDiscuss(TUser TUser, String content, String category,
			String pictures, String area, Date createTime, boolean hot,
			long likesnumber, Set TReplaies, Set TDiscusslikeses) {
		this.TUser = TUser;
		this.content = content;
		this.category = category;
		this.pictures = pictures;
		this.area = area;
		this.createTime = createTime;
		this.hot = hot;
		this.likesnumber = likesnumber;
		this.TReplaies = TReplaies;
		this.TDiscusslikeses = TDiscusslikeses;
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

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean getHot() {
		return this.hot;
	}

	public void setHot(boolean hot) {
		this.hot = hot;
	}

	public long getLikesnumber() {
		return this.likesnumber;
	}

	public void setLikesnumber(long likesnumber) {
		this.likesnumber = likesnumber;
	}

	public Set getTReplaies() {
		return this.TReplaies;
	}

	public void setTReplaies(Set TReplaies) {
		this.TReplaies = TReplaies;
	}

	public Set getTDiscusslikeses() {
		return this.TDiscusslikeses;
	}

	public void setTDiscusslikeses(Set TDiscusslikeses) {
		this.TDiscusslikeses = TDiscusslikeses;
	}

}