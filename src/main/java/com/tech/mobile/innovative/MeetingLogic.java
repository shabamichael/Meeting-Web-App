package com.tech.mobile.innovative;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class MeetingLogic {
	public String WEEKEND = "WEEKEND MEETING";
	public String MIDWEEK = "MIDWEEK MEETING";
	
	public String GetTypeOfMeeting(String meetingType) {
		
	if (meetingType.equalsIgnoreCase("WEEKEND") || (meetingType.equalsIgnoreCase("WEEKEND MEETING"))) {
			meetingType = WEEKEND;			
		}
	else if(meetingType.equalsIgnoreCase("MIDWEEK") || (meetingType.equalsIgnoreCase("MIDWEEK MEETING"))) {
			meetingType = MIDWEEK;
	}
	else {
		meetingType = "INVALID MEETING TYPE";
	}
	return meetingType;
	}
	
	public String meetingDay(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		 String day = sdf.format(date);
		return day;
		
	}
	
	public Date meetingDateFormat(String dateInString) {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        //String dateInString = "7-Jun-2013";

	       

	            Date date = null;
				try {
					date = formatter.parse(dateInString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return date;
	          
	} 
	
	public String meetingDateStringFormat(Date dat) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String  date = null;
		date = formatter.toString();
		return date;
	}
	
}