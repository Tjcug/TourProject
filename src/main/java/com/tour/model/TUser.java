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
	private long wechatId;
	private String password;
	private short sex;
	private Date birthday;
	private String picture;
	private String country;
	private String city;
	private String creditcard;
	private String telephone;
	private double score;
	private Date createTime;
	private boolean pushnotifcation;
	private double longitude;
	private double latitude;
	private Set TReplaiesForTouser = new HashSet(0);
	private Set TReplaiesForFromuser = new HashSet(0);
	private Set TJyquestionses = new HashSet(0);
	private Set TJyanswerses = new HashSet(0);
	private Set TDiscusslikeses = new HashSet(0);
	private Set TUserlocations = new HashSet(0);
	private Set TDiscusses = new HashSet(0);
	private Set TJyanswerscontents = new HashSet(0);
	private Set TOrdersForOrderTouser = new HashSet(0);
	private Set TOrdersForOrderFromuser = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String telephone, Date createTime) {
		this.telephone = telephone;
		this.createTime = createTime;
	}

	/** full constructor */
	public TUser(String userName, String email, long wechatId, String password,
			short sex, Date birthday, String picture, String country,
			String city, String creditcard, String telephone, double score,
			Date createTime, boolean pushnotifcation, double longitude,
			double latitude, Set TReplaiesForTouser, Set TReplaiesForFromuser,
			Set TJyquestionses, Set TJyanswerses, Set TDiscusslikeses,
			Set TUserlocations, Set TDiscusses, Set TJyanswerscontents,
			Set TOrdersForOrderTouser, Set TOrdersForOrderFromuser) {
		this.userName = userName;
		this.email = email;
		this.wechatId = wechatId;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.picture = picture;
		this.country = country;
		this.city = city;
		this.creditcard = creditcard;
		this.telephone = telephone;
		this.score = score;
		this.createTime = createTime;
		this.pushnotifcation = pushnotifcation;
		this.longitude = longitude;
		this.latitude = latitude;
		this.TReplaiesForTouser = TReplaiesForTouser;
		this.TReplaiesForFromuser = TReplaiesForFromuser;
		this.TJyquestionses = TJyquestionses;
		this.TJyanswerses = TJyanswerses;
		this.TDiscusslikeses = TDiscusslikeses;
		this.TUserlocations = TUserlocations;
		this.TDiscusses = TDiscusses;
		this.TJyanswerscontents = TJyanswerscontents;
		this.TOrdersForOrderTouser = TOrdersForOrderTouser;
		this.TOrdersForOrderFromuser = TOrdersForOrderFromuser;
	}

	// Property accessors

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

	public long getWechatId() {
		return this.wechatId;
	}

	public void setWechatId(long wechatId) {
		this.wechatId = wechatId;
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

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean getPushnotifcation() {
		return this.pushnotifcation;
	}

	public void setPushnotifcation(boolean pushnotifcation) {
		this.pushnotifcation = pushnotifcation;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
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

	public Set getTJyquestionses() {
		return this.TJyquestionses;
	}

	public void setTJyquestionses(Set TJyquestionses) {
		this.TJyquestionses = TJyquestionses;
	}

	public Set getTJyanswerses() {
		return this.TJyanswerses;
	}

	public void setTJyanswerses(Set TJyanswerses) {
		this.TJyanswerses = TJyanswerses;
	}

	public Set getTDiscusslikeses() {
		return this.TDiscusslikeses;
	}

	public void setTDiscusslikeses(Set TDiscusslikeses) {
		this.TDiscusslikeses = TDiscusslikeses;
	}

	public Set getTUserlocations() {
		return this.TUserlocations;
	}

	public void setTUserlocations(Set TUserlocations) {
		this.TUserlocations = TUserlocations;
	}

	public Set getTDiscusses() {
		return this.TDiscusses;
	}

	public void setTDiscusses(Set TDiscusses) {
		this.TDiscusses = TDiscusses;
	}

	public Set getTJyanswerscontents() {
		return this.TJyanswerscontents;
	}

	public void setTJyanswerscontents(Set TJyanswerscontents) {
		this.TJyanswerscontents = TJyanswerscontents;
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

}