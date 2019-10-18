<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tuanictu97" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="utf-8">
<title>Add</title>
</head>
<body>
	<div class="container">
		<form method="post" action="<%= request.getContextPath()%>/books?action=doAdd">
		  <div class="form-group">
		    <label for="nameInput">Name</label>
		    <input type="text" name="name" class="form-control" id="nameInput" placeholder="Enter your name book">
		  </div>
		  <div class="form-group">
		    <label for="descInput">Desc</label>
		    <input type="text" name="desc" class="form-control" id="descInput" placeholder="Enter your desc">
		  </div>
		  <button type="submit" class="btn btn-primary">Add</button>
		</form>
	</div>
</body>
</html>