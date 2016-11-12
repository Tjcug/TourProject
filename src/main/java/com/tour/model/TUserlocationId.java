package com.tour.model;

/**
 * TUserlocationId entity. @author MyEclipse Persistence Tools
 */

public class TUserlocationId implements java.io.Serializable {

	// Fields

	private long userId;
	private Integer number;

	// Constructors

	/** default constructor */
	public TUserlocationId() {
	}

	/** full constructor */
	public TUserlocationId(long userId, Integer number) {
		this.userId = userId;
		this.number = number;
	}

	// Property accessors

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TUserlocationId))
			return false;
		TUserlocationId castOther = (TUserlocationId) other;

		return (this.getUserId() == castOther.getUserId())
				&& ((this.getNumber() == castOther.getNumber()) || (this
						.getNumber() != null && castOther.getNumber() != null && this
						.getNumber().equals(castOther.getNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getUserId();
		result = 37 * result
				+ (getNumber() == null ? 0 : this.getNumber().hashCode());
		return result;
	}

}