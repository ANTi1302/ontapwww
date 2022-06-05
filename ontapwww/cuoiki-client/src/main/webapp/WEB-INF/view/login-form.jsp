<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
<div class="alert alert-success">
<strong>Success!</strong> Indicates a successful or positive action.
</div>
</script>
</head>
<body>
	<c:url value="/login" var="action" />
	<c:if test="${param.error !=null }">
		<i class="alert alert-success">Sorry! You entered invalid username
			/ password </i>
	</c:if>
	<c:if test="${param.accessDenied !=null}">
		<i class="alert alert-success">Loi roi dang nhap lai di </i>
	</c:if>
	<form action="${action}" method="post">

		<p>
			User name: <input type="text" name="username" />
		<p>
			Password: <input type="password" name="password" />
		<p>
			<input type="submit" value="Login" />
	</form>

</body>
<c:if test="${param.logout !=null }">
	<i class="alert alert-success">You have been logged out </i>
</c:if>
</html>