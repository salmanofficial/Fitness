<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Create a Group</title>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<form:form>
		<table>
			<tr>
				<td>Group Name</td>
				<td><form:input path=""/></td>
				<td></td>
			</tr>
			<tr>
				<td>Group Description</td>
				<td><form:input path=""/></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><form:input path=""/></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><form:input path=""/></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><form:input path=""/></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>

		</table>
	</form:form>
</body>
</html>