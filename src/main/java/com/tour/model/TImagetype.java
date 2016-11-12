package com.tour.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TImagetype entity. @author MyEclipse Persistence Tools
 */

public class TImagetype implements java.io.Serializable {

	// Fields

	private long id;
	private String typeName;
	private Set TImagelibaries = new HashSet(0);

	// Constructors

	/** default constructor */
	public TImagetype() {
	}

	/** minimal constructor */
	public TImagetype(String typeName) {
		this.typeName = typeName;
	}

	/** full constructor */
	public TImagetype(String typeName, Set TImagelibaries) {
		this.typeName = typeName;
		this.TImagelibaries = TImagelibaries;
	}

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getTImagelibaries() {
		return this.TImagelibaries;
	}

	public void setTImagelibaries(Set TImagelibaries) {
		this.TImagelibaries = TImagelibaries;
	}

}