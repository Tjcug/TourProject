package com.tour.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TJyanswerscontent entity. @author MyEclipse Persistence Tools
 */

public class TJyanswerscontent implements java.io.Serializable {

	// Fields

	private long id;
	private TUser TUser;
	private TJyanswers TJyanswers;
	private boolean type;
	private String content;
	private Date createTime;
	private Set TJyanswerscontentimages = new HashSet(0);

	// Constructors

	/** default constructor */
	public TJyanswerscontent() {
	}

	/** minimal constructor */
	public TJyanswerscontent(TUser TUser, TJyanswers TJyanswers, boolean type,
			String content) {
		this.TUser = TUser;
		this.TJyanswers = TJyanswers;
		this.type = type;
		this.content = content;
	}

	/** full constructor */
	public TJyanswerscontent(TUser TUser, TJyanswers TJyanswers, boolean type,
			String content, Date createTime, Set TJyanswerscontentimages) {
		this.TUser = TUser;
		this.TJyanswers = TJyanswers;
		this.type = type;
		this.content = content;
		this.createTime = createTime;
		this.TJyanswerscontentimages = TJyanswerscontentimages;
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

	public TJyanswers getTJyanswers() {
		return this.TJyanswers;
	}

	public void setTJyanswers(TJyanswers TJyanswers) {
		this.TJyanswers = TJyanswers;
	}

	public boolean getType() {
		return this.type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set getTJyanswerscontentimages() {
		return this.TJyanswerscontentimages;
	}

	public void setTJyanswerscontentimages(Set TJyanswerscontentimages) {
		this.TJyanswerscontentimages = TJyanswerscontentimages;
	}

}