<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=windows-1251" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Welcome</h1> <br>
<h2>Your Login!: <sec:authentication property="principal.username" /></h2>
<form action="/logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>
