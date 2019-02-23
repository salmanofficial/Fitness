<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script type="text/javascript">

function createNewUser() {
	document.loginForm.action="createNewUserform.htm";
	document.loginForm.submit();
}

</script>
</head>
<body>

	<form:errors id="error" path="*"></form:errors>
	<form:form modelAttribute="UserBean" name="loginForm" action="ValidateUser.htm">
		<table>
			<tr>
				<td>User Name </td>
				<td><form:input path="loginId" id="loginId" name="loginId"/></td>
				<td></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="loginPassword" id="loginPassword" name="loginPassword" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" name="submit" id="submit"/></td>
				<td><input type="submit" value="Sign Up" name="singUp" id="singUp" onclick="createNewUser()"/></td>
				<td></td>
			</tr>
		</table>
	</form:form>
</body>
</html>