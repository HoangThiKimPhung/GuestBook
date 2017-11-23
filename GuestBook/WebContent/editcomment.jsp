<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateComment">
		Name:<input type='text' name='name' readonly value="<%=request.getSession().getAttribute("name") %>"><br>
		Message:<textarea name='message' rows='5' cols='60'></textarea><br>
		<input type='hidden' name='id' value="<%=request.getParameter("id") %>">
		<input type='submit' name='Save' value='Save'>
	</form>
</body>
</html>