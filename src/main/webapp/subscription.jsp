<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>email subscription</title>
<link rel="stylesheet" href="styles/main.css" type="text/css"/>
<script type="text/javascript" src="styles/main.js"></script>
</head>

<body>
<h1>Record Meeting Details.</h1>
<p>To record a meeting, please enter details of the meeting below.</p>
<form action="EmailListServlet" method="post">
<input type ="hidden" name="action" value="add">

<fieldset>
<legend><strong>MEETING DETAILS</strong></legend>


<strong>Meeting</strong><br>
Meeting date:<input type="date"  id="meetingDate" name="meetingDate" value="yyyy-mm-dd" min="2000-01-01" max="2050-12-31" ><br>
   

<label> Meeting Type:</label>
<input type="radio" name="meetingType" value="midweek"> Midweek
<input type="radio" name="meetingType" value="weekend"> Weekend<br><br>


  <label> Attendance:</label>
 <input type="number" name="attendance" requires><br><br>


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

Please enter the announcement made at the meeting:<br>
<td><textarea rows = "10" cols = "50" name="announcement"></textarea></td><br><br>





<label>&nbsp;</label>




<input type="submit" value="Save" id="submit">

</fieldset><br>






</form>
</body>
</html>