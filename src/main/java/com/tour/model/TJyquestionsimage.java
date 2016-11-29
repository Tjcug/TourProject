package com.tour.model;

import java.util.Date;

/**
 * TJyquestionsimage entity. @author MyEclipse Persistence Tools
 */

public class TJyquestionsimage implements java.io.Serializable {

	// Fields

	private long id;
	private TJyquestions TJyquestions;
	private String imagePack;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TJyquestionsimage() {
	}

	/** full constructor */
	public TJyquestionsimage(TJyquestions TJyquestions, String imagePack,
			Date createTime) {
		this.TJyquestions = TJyquestions;
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

	public TJyquestions getTJyquestions() {
		return this.TJyquestions;
	}

	public void setTJyquestions(TJyquestions TJyquestions) {
		this.TJyquestions = TJyquestions;
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