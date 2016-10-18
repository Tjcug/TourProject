package com.tour.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private long id;
	private String userName;
	private String email;
	private String password;
	private short sex;
	private Date birthday;
	private String picture;
	private String country;
	private String city;
	private String creditcard;
	private String telephone;
	private double score;
	private Date time;
	private boolean pushnotifcation;
	private double longitude;
	private double latitude;
	transient private Set TReplaiesForTouser = new HashSet(0);
	transient private Set TReplaiesForFromuser = new HashSet(0);
	transient private Set TDiscusslikeses = new HashSet(0);
	transient private Set TAssistantquestionses = new HashSet(0);
	transient private Set TDiscusses = new HashSet(0);
	transient private Set TAssistantanswerses = new HashSet(0);
	transient private Set TOrdersForOrderTouser = new HashSet(0);
	transient private Set TOrdersForOrderFromuser = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(String userName, String email, String password, short sex,
			Date birthday, String picture, String country, String city,
			String creditcard, String telephone, double score, Date time,
			Set TReplaiesForTouser, Set TReplaiesForFromuser,
			Set TDiscusslikeses, Set TAssistantquestionses, Set TDiscusses,
			Set TAssistantanswerses, Set TOrdersForOrderTouser,
			Set TOrdersForOrderFromuser) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.picture = picture;
		this.country = country;
		this.city = city;
		this.creditcard = creditcard;
		this.telephone = telephone;
		this.score = score;
		this.time = time;
		this.TReplaiesForTouser = TReplaiesForTouser;
		this.TReplaiesForFromuser = TReplaiesForFromuser;
		this.TDiscusslikeses = TDiscusslikeses;
		this.TAssistantquestionses = TAssistantquestionses;
		this.TDiscusses = TDiscusses;
		this.TAssistantanswerses = TAssistantanswerses;
		this.TOrdersForOrderTouser = TOrdersForOrderTouser;
		this.TOrdersForOrderFromuser = TOrdersForOrderFromuser;
	}

	// Property accessors

    public boolean isPushnotifcation() {
		return pushnotifcation;
	}

	public void setPushnotifcation(boolean pushnotifcation) {
		this.pushnotifcation = pushnotifcation;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public short getSex() {
		return this.sex;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreditcard() {
		return this.creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public double getScore() {
		return this.score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set getTReplaiesForTouser() {
		return this.TReplaiesForTouser;
	}

	public void setTReplaiesForTouser(Set TReplaiesForTouser) {
		this.TReplaiesForTouser = TReplaiesForTouser;
	}

	public Set getTReplaiesForFromuser() {
		return this.TReplaiesForFromuser;
	}

	public void setTReplaiesForFromuser(Set TReplaiesForFromuser) {
		this.TReplaiesForFromuser = TReplaiesForFromuser;
	}

	public Set getTDiscusslikeses() {
		return this.TDiscusslikeses;
	}

	public void setTDiscusslikeses(Set TDiscusslikeses) {
		this.TDiscusslikeses = TDiscusslikeses;
	}

	public Set getTAssistantquestionses() {
		return this.TAssistantquestionses;
	}

	public void setTAssistantquestionses(Set TAssistantquestionses) {
		this.TAssistantquestionses = TAssistantquestionses;
	}

	public Set getTDiscusses() {
		return this.TDiscusses;
	}

	public void setTDiscusses(Set TDiscusses) {
		this.TDiscusses = TDiscusses;
	}

	public Set getTAssistantanswerses() {
		return this.TAssistantanswerses;
	}

	public void setTAssistantanswerses(Set TAssistantanswerses) {
		this.TAssistantanswerses = TAssistantanswerses;
	}

	public Set getTOrdersForOrderTouser() {
		return this.TOrdersForOrderTouser;
	}

	public void setTOrdersForOrderTouser(Set TOrdersForOrderTouser) {
		this.TOrdersForOrderTouser = TOrdersForOrderTouser;
	}

	public Set getTOrdersForOrderFromuser() {
		return this.TOrdersForOrderFromuser;
	}

	public void setTOrdersForOrderFromuser(Set TOrdersForOrderFromuser) {
		this.TOrdersForOrderFromuser = TOrdersForOrderFromuser;
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
