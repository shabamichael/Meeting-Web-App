<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>email subscription</title>
<link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>

<body>
<h1>Record Meeting Details.</h1>
<p>To record a meeting, please enter details of the meeting below.</p>
<form action="EmailListServlet" method="post">

<fieldset>
<legend><strong>MEETING DETAILS</strong></legend>


<strong>Meeting</strong><br>
<label for="meeting">Meeting date:</label><br>

<input type="date" id="start" name="trip-start"
       value="Select Date"
       min="2018-01-01" max="2018-12-31">
<br><br>


<label for="meeting">Meeting Day:</label><br>
<input type = "text" name="meetingDay" ><br>


<label> Meeting Type:</label><br>
<input type="radio" name="meetingType" value="midweek"> Midweek<br>
<input type="radio" name="meetingType" value="weekend"> Weekend<br><br>


  <label> Attendance:</label><br>
 <input type="number" name="attendance" requires><br><br>



<input type ="hidden" name="action" value="add">

<strong>Sound Operator:</strong><br>

<label> Name:</label>
<input type ="text" name="soundOperatorName" required><br>

<label>Surname:</label>
<input type = "text" name="soundOperatorSurname" required><br>

<input type ="hidden" name="action" value="add"><br>

<strong>Attendant:</strong><br>

<label> Name:</label>
<input type ="text" name="attendantName" required><br>

<label>Surname:</label>
<input type = "text" name="attendantSurname" required><br>
<br>

<strong>Announcement:</strong><br>

Please enter data, at most 42 characters:<br>
<td><textarea rows = "10" cols = "50" name="announcement"></textarea></td><br><br>





<label>&nbsp;</label>
<input type="submit" value="Join Now" id="submit">

</fieldset><br>








</form>
</body>
</html>