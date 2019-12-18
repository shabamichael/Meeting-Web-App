<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tech.mobile.innovative.Meeting" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Saved Successfully</title>
<link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h1>Thank you for saving the meeting details.</h1>
<p>Below is the information that you entered</p>

<% 
Meeting meeting = new Meeting() ;
%>
Meeting date:
<span><% 
String meetDate = meeting.getMeetingType();
String meetingDate = (String) request.getAttribute(meetDate);
out.println("Hellott " + meetingDate );%></span></br>

Meeting Type:
<span><%meeting.getMeetingType(); %></span></br>

Sound Operator Name:
<span><%meeting.getSoundOperatorFirstName()  ;%></span></br>

Attendant Name:
<span><%meeting.getAttendantFirstName(); %></span></br>
Announcement:
<span><%meeting.getAnnouncement(); %></span>

<p>To enter another email address, click on the back button in the the browser
or the return button shown below.</p>

<form action="" method="get">
<input type="hidden" name="action" value="join">
<input type="submit"  value="Return">


</form>

</body>
</html>