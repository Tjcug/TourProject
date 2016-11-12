package com.tour.model;

import java.util.Date;

/**
 * TImagelibary entity. @author MyEclipse Persistence Tools
 */

public class TImagelibary implements java.io.Serializable {

	// Fields

	private long id;
	private TImagetype TImagetype;
	private long businessTabelId;
	private String imagePack;
	private Date createTime;

	// Constructors

	/** default constructor */
	public TImagelibary() {
	}

	/** minimal constructor */
	public TImagelibary(TImagetype TImagetype, long businessTabelId) {
		this.TImagetype = TImagetype;
		this.businessTabelId = businessTabelId;
	}

	/** full constructor */
	public TImagelibary(TImagetype TImagetype, long businessTabelId,
			String imagePack, Date createTime) {
		this.TImagetype = TImagetype;
		this.businessTabelId = businessTabelId;
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

	public TImagetype getTImagetype() {
		return this.TImagetype;
	}

	public void setTImagetype(TImagetype TImagetype) {
		this.TImagetype = TImagetype;
	}

	public long getBusinessTabelId() {
		return this.businessTabelId;
	}

	public void setBusinessTabelId(long businessTabelId) {
		this.businessTabelId = businessTabelId;
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