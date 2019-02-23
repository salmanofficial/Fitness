<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/js/jquery.emailinput.min.js" var="multiSelectJsPath"></spring:url>
<spring:url value="/resources/css/jquery.emailinput.min.css" var="multiSelectCSSPath"></spring:url>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	

<link rel="stylesheet" type="text/css" href="${multiSelectCSSPath}">	
<script src="${multiSelectJsPath}"></script>
	
<title>Send Mail</title>


</head>
<body>
	<form:form modelAttribute="MessageBean" action="sendMail.htm">
		<table>
			<tr>
				<td>To</td>
				<td><form:input path="to" id="to" name="to" /><%-- class="emailinput ei" --%>
				<td></td>
			</tr>
			<tr>
				<td>Cc</td>
				<td><form:input path="cc" name="cc" id="cc" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Bcc</td>
				<td><form:input path="bcc" name="bcc" id="bcc" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><form:input path="subject" name="subject" id="subject" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><form:textarea class="content" path="message"
						name="message" id="message" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" id="submit" value="Send" /></td>
				<td></td>
				<td></td>
			</tr>


		</table>
	</form:form>
</body>
</html>