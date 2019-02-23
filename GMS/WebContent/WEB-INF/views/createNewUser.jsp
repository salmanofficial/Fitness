<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New User</title>
<script type="text/javascript">


	
</script>
</head>
<body>

	<form:form modelAttribute="UserBean" action="createNewUser.htm" method="POST">
		<table>
		<tr><td>
		<form:errors path="*"/>
		</td></tr>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" id="firstName"
						name="firstName" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" id="lastName" name="lastName" /></td>
				<td></td>
			</tr>
			<%-- <tr>
				<td>Date Of Birth</td>
				<td><form:input path="dob" id="dob" name="dob"  /></td>
				<td></td>
			</tr> --%>
			<tr>
				<td>Gender</td>
				<td><form:select path="genderCd" id="genderCd" name="genderCd">
						<form:options items="${allGenders}"/>
					</form:select></td>
				<td></td>
			</tr>


			<tr>
				<td>Mobile Number</td>
				<td><form:input path="mobileNo" id="mobileNo" name="mobileNo" /></td>
				<td></td>
			</tr>
			<tr>
				<td>User Id</td>
				<td><form:input path="loginId" id="loginId" name="loginId" /></td>
				<td>@gms.com</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="loginPassword" id="loginPassword"
						name="loginPassword" /></td>
				<td></td>
			</tr>
			<!-- <tr>
				<td>Re-Password</td>
				<td><input type="password" id="repassword" name="repassword" /></td>
				<td></td>
			</tr> -->
			
			<tr>
				<td>User Type : </td>
				<td>
				<form:select path="userType" id="userType" name="userType">
						<form:option value="N">Not a Coach</form:option>
						<form:option value="Y">Coach</form:option>
					</form:select>
				</td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" name="submit"
					id="submit" /></td>
				<td><input type="reset" value="Rest" name="reset" id="reset" /></td>
				<td></td>
			</tr>
		</table>
	</form:form>

</body>
</html>