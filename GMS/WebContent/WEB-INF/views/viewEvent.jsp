<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
function check(){
    var radios = document.getElementsByName("event");

    for (var i = 0, len = radios.length; i < len; i++) {
         if (radios[i].checked) {
             return true;
         }
    }

    return false;
}
function sendInvite(msgId) {
		var userId = document.getElementById("select"+msgId).value ;
		var msgId = msgId 
		 
	 	$.get("inviteToEvent.htm?userId="+userId+"&msgId="+msgId);
}
</script>
</head>
<body>
<table border="1">

<tr>
<td>Event Created By</td><td> Event Title</td><td>Event Desc</td><td>Coach Name</td><td>Action</td>

</tr>

<c:forEach items="${inboxMessagesList}" var="inboxList">
<tr>
<td>${inboxList.from} </td><td> ${inboxList.subject}</td><td> ${inboxList.message}</td> <td> ${inboxList.coachName}</td>
<td>
<c:if test="${requestFalg != 'Y' }">
						<select name="login" id="select${inboxList.messageSrNo}">
						<c:forEach items="${allCoachesNames}" var="map">
							<option value="${map.key}">${map.value}</option></c:forEach>
						</select>

						<a href="#" id="invite" onclick="sendInvite(${inboxList.messageSrNo})">invite</a></c:if>

</td>
   
</tr>
</c:forEach>

</table>


</body>
</html>