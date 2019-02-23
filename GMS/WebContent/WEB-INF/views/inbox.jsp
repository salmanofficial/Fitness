<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Welcome : <b>${UserName}</b><a href="logout.htm">Logout</a><br/>
<!-- <a href="sendMailForm.htm">Send Mail</a><br/> -->

<%-- <c:forEach items="${inboxMessagesList}" var="inboxList">
<b> ${inboxList.from} </b><br/>
<b> ${inboxList.subject} </b><br/>
<b> ${inboxList.receivedDate} </b><br/>
</c:forEach> --%>

<ul>
  <li><a href='createEvent'>Create an Fitness Event</a></li>
  <li><a href='viewAllEvents'>View Events Around you</a></li>
  <li><a href='requestEvents'>Events in which your Tag</a></li>
</ul>

</body>
</html>