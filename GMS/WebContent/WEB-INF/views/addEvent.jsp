<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="FitnessBean" name="eventForm" action="addEvent">
		<table>
			<tr>
				<td>Event Title </td>
				<td><form:input path="eventTitle" id="eventTitle" name="eventTitle"/></td>
				<td></td>
			</tr>
			<tr>
				<td>Event Description </td>
				<td><form:textarea path="eventDesc" id="eventDesc" name="eventDesc" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Assign a Coaches</td>
				<td>
				<form:select path="coaches" id="coaches" name="coaches">
						<form:options items="${allCoachesNames}"/>
					</form:select>
				
				</td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" id="submit" /></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form:form>
</body>
</html>