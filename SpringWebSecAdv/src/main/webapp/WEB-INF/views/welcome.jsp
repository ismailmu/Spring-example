<!DOCTYPE html>
<%@page import="org.imu.springtutorials.web.controller.UserController"%>
<%@include file="taglib.jsp"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>

<h2>Welcome <%=UserController.getCurrentUser().getName() %> </h2>
<h3>Email: <sec:authentication property="name"/></h3>
<h3>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="${rootUrl}admin">Administration</a>
	</sec:authorize>
</h3>
<p>	<a href="${rootUrl}logout">Logout</a></p>
</body>
</html>