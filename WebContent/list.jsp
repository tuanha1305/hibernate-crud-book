<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tuanictu97" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="utf-8">
<title>List Books</title>
</head>
<body>
	<div class="container">
		<h2>Manager Books</h2>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Name</th>
		      <th scope="col">Address</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tuanictu97:forEach var="book" items="${books }">
		    	<tr>
		    		<td><tuanictu97:out value="${book.getId() }"></tuanictu97:out></td>
		    		<td><tuanictu97:out value="${book.getName() }"></tuanictu97:out></td>
		    		<td><tuanictu97:out value="${book.getDesc() }"></tuanictu97:out></td>
		    		<td>
		    			<a href="<%= request.getContextPath()%>/books?action=edit&id=${book.getId() }"><button type="button" class="btn btn-outline-primary">Edit</button></a>
		    			<a href="<%= request.getContextPath()%>/books?action=doDelete&id=${book.getId() }"><button type="button" class="btn btn-outline-danger">Delete</button></a>
		    		</td>
		    	</tr>
		    </tuanictu97:forEach>
		  </tbody>
		</table>
		<a href="<%= request.getContextPath()%>/books?action=add"><button type="button" class="btn btn-info">Add new</button></a>
	</div>
</body>
</html>