package com.ls.nssh.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * LsEventHandle entity. @author MyEclipse Persistence Tools
 */

public class LsEventHandle implements java.io.Serializable {

	// Fields

	private String id;
	private String userNo;
	private Integer eventType;
	private String eventDes;
	private Date eventTime;

	// Constructors

	/** default constructor */
	public LsEventHandle() {
	}

	/** full constructor */
	public LsEventHandle(String userNo, Integer eventType, String eventDes,
			Timestamp eventTime) {
		this.userNo = userNo;
		this.eventType = eventType;
		this.eventDes = eventDes;
		this.eventTime = eventTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public Integer getEventType() {
		return this.eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

	public String getEventDes() {
		return this.eventDes;
	}

	public void setEventDes(String eventDes) {
		this.eventDes = eventDes;
	}

	public Date getEventTime() {
		return this.eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

}