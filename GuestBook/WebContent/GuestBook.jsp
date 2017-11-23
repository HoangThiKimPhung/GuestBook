<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>GuestBook</title>
	<link rel="stylesheet" href="./CSS/bootstrap.min.css"/>
	<script src="./JS/jquery-3.2.1.min.js"></script>
	<script src="./JS/bootstrap.min.js"></script>

    <style>
        #id {
            width: 50px;
        }
        #name {
            width: 150px;
        }
        #thead {
            background-color: #E6E6E6 !important;
        }
    </style>
</head>
<body>

    <div class='container'>
        <h2>Guest Book</h2>
        <table class='table table-bordered'>
            <thead>
                <tr id='thead'>
                    <th id='id'>ID</th>
                    <th id='name'>Name</th>
                    <th>Message</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach items="${entries}" var="entry">
					<tr>
                   		<td><c:out value="${entry.id}"></c:out></td>
                   		<td><c:out value="${entry.name}"></c:out></td>
                   		<td><c:out value="${entry.message}"></c:out></td>
                    </tr>
               	</c:forEach>
            </tbody>
        </table>  
        <a data-toggle='modal' data-target='#addEntry'>Leave a comment</a>
    </div>    
    <!-- Modal Add -->
    <div class='modal fade' id='addEntry' role='dialog'>
        <div class='modal-dialog'>
            <div class='modal-content'>
                <div class='modal-header' style='background-color: #E6E6E6'>
                    <button type='button' class='close' data-dismiss="modal">&times;</button>
                    <h2 class='modal-title'>New Message</h2>
                </div>
                <div class='modal-body'>
                    <form action="AddEntryGuestBook" method="get">
                        <div class='form-group'>
                            <label>Name:</label>
                            <input type="text" class="form-control" name="name"
                            <%
                            	String name= (String)request.getSession().getAttribute("name");
								if(name != null){%>
								value="<%=name %>" readonly
							<%} %>
                            ></input>
                        </div>
                        <div class='form-group'>
                            <label>Message:</label>
                            <textarea name='message' class='form-control' rows='7' cols='60'></textarea>
                        </div>
                        <input type='submit' value='   Add   ' name='submit' />
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>