<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thanks for subscribing</title>
<link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h1>Thank you for joining our email list</h1>
<p>Below is the information that you entered</p>

<label>Email:</label>
<span>${user.email}</span></br>

<label>First Name:</label>
<span>${user.firstName}</span></br>

<label>Last Name:</label>
<span>${user.lastName}</span></br>

<p>To enter another email address, click on the back button in the the browser
or the return button shown below.</p>

<form action="" method="get">
<input type="hidden" name="action" value="join">
<input type="submit"  value="Return">


</form>

</body>
</html>