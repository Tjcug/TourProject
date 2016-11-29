package com.tour.model;

import java.util.Date;

/**
 * TJyanswerscontentimage entity. @author MyEclipse Persistence Tools
 */

public class TJyanswerscontentimage implements java.io.Serializable {

	// Fields

	private long id;
	private TJyanswerscontent TJyanswerscontent;
	private String imagePack;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TJyanswerscontentimage() {
	}

	/** full constructor */
	public TJyanswerscontentimage(TJyanswerscontent TJyanswerscontent,
			String imagePack, Date createTime) {
		this.TJyanswerscontent = TJyanswerscontent;
		this.imagePack = imagePack;
		this.createTime = createTime;
	}

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TJyanswerscontent getTJyanswerscontent() {
		return this.TJyanswerscontent;
	}

	public void setTJyanswerscontent(TJyanswerscontent TJyanswerscontent) {
		this.TJyanswerscontent = TJyanswerscontent;
	}

	public String getImagePack() {
		return this.imagePack;
	}

	public void setImagePack(String imagePack) {
		this.imagePack = imagePack;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}