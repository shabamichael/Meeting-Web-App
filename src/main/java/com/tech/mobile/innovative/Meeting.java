package com.tech.mobile.innovative;

import java.io.Serializable;
import java.util.Date;


public class Meeting implements Serializable{
	
	private Date meetingDate;
	private String meetingDay;
	private String meetingType;
	private int attendance;
	private String soundOperatorFirstName;
	private String soundOperatorLastName;
	private String attendantFirstName;
	private String attendantLastName;
	private String announcement;
	
	

	
	
	public Meeting() {
	}



	public Meeting(Date meetingDate, String meetingDay, String meetingType, int attendance,
			String soundOperatorFirstName, String soundOperatorLastName, String attendantFirstName,
			String attendantLastName, String announcement) {
		super();
		this.meetingDate = meetingDate;
		this.meetingDay = meetingDay;
		this.meetingType = meetingType;
		this.attendance = attendance;
		this.soundOperatorFirstName = soundOperatorFirstName;
		this.soundOperatorLastName = soundOperatorLastName;
		this.attendantFirstName = attendantFirstName;
		this.attendantLastName = attendantLastName;
		this.announcement = announcement;
	}



	/**
	 * @return the meetingDate
	 */
	public Date getMeetingDate() {
		return meetingDate;
	}

	/**
	 * @param meetingDate the meetingDate to set
	 */
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	/**
	 * @return the meetingDay
	 */
	public String getMeetingDay() {
		return meetingDay;
	}

	/**
	 * @param meetingDay the meetingDay to set
	 */
	public void setMeetingDay(String meetingDay) {
		this.meetingDay = meetingDay;
	}

	/**
	 * @return the meetingType
	 */
	public String getMeetingType() {
		return meetingType;
	}

	/**
	 * @param meetingType the meetingType to set
	 */
	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	/**
	 * @return the attendance
	 */
	public int getAttendance() {
		return attendance;
	}

	/**
	 * @param attendance the attendance to set
	 */
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	/**
	 * @return the soundOperatorFirstName
	 */
	public String getSoundOperatorFirstName() {
		return soundOperatorFirstName;
	}

	/**
	 * @param soundOperatorFirstName the soundOperatorFirstName to set
	 */
	public void setSoundOperatorFirstName(String soundOperatorFirstName) {
		this.soundOperatorFirstName = soundOperatorFirstName;
	}

	/**
	 * @return the soundOperatorLastName
	 */
	public String getSoundOperatorLastName() {
		return soundOperatorLastName;
	}

	/**
	 * @param soundOperatorLastName the soundOperatorLastName to set
	 */
	public void setSoundOperatorLastName(String soundOperatorLastName) {
		this.soundOperatorLastName = soundOperatorLastName;
	}

	/**
	 * @return the attendantFirstName
	 */
	public String getAttendantFirstName() {
		return attendantFirstName;
	}

	/**
	 * @param attendantFirstName the attendantFirstName to set
	 */
	public void setAttendantFirstName(String attendantFirstName) {
		this.attendantFirstName = attendantFirstName;
	}

	/**
	 * @return the attendantLastName
	 */
	public String getAttendantLastName() {
		return attendantLastName;
	}

	/**
	 * @param attendantLastName the attendantLastName to set
	 */
	public void setAttendantLastName(String attendantLastName) {
		this.attendantLastName = attendantLastName;
	}

	/**
	 * @return the announcement
	 */
	public String getAnnouncement() {
		return announcement;
	}

	/**
	 * @param announcement the announcement to set
	 */
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	
	
}
	

	