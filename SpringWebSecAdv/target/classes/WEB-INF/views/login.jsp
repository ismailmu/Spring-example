<!DOCTYPE html>
<%@include file="taglib.jsp"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<c:if test="${param.error != null}">
		<div class="alert alert-danger">Invalid UserName and Password.</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">You have been logged out.</div>
	</c:if>
	<h2>User Login Form</h2>
<!-- 			modelAttribute="user" -->
	<form:form id="loginForm" method="post" action="${rootURL}login" >
		<div>
			<label for="username">UserName*</label>
			<div>
				<input type="text" id="username" name="username" placeholder="UserName" />
			</div>
		</div>
		<div>
			<label for="password">Password*</label>
			<div>
				<input type="password" id="password" name="password" placeholder="Password" />
			</div>
		</div>
		<div>
			<div>
				<input type="submit" value="Login">
			</div>
		</div>
	</form:form>
</body>
</html>