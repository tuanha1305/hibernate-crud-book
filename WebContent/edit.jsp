<%@ page import="io.github.tuanictu97.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tuanictu97" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="utf-8">
<title>Edit</title>
</head>
<body>
	<% Book book = (Book) request.getAttribute("book"); %>
	<div class="container">
		<form method="post" action="<%= request.getContextPath()%>/books?action=doEdit">
			<div class="form-group">
		    <label for="idInput">ID</label>
		    <input type="text" name="idst" class="form-control" value="<%= book.getId() %>" readonly="readonly" id="idInput" placeholder="Enter your name">
		  </div>
		  <div class="form-group">
		    <label for="nameInput">Name</label>
		    <input type="text" name="name" class="form-control" value="<%= book.getName() %>" id="nameInput" placeholder="Enter your name">
		  </div>
		  <div class="form-group">
		    <label for="descInput">Desc</label>
		    <input type="text" name="desc" class="form-control" value="<%= book.getDesc() %>"  id="descInput" placeholder="Enter your desc">
		  </div>
		  <button type="submit" class="btn btn-primary">Edit</button>
		</form>
	</div>
</body>
</html>