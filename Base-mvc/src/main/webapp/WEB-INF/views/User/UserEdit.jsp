<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "/Base-mvc/Edit" method = "post">
		<input type = "text" name = "ID" value = "${ID }" placeholder="ID"></input>
		<input type = "text" name = "Name" value = "${Name }" placeholder="Name"></input>
		<input type = "submit" name = "update" value = "UPDATE"></input>
	</form>

</body>
</html>