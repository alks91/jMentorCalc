<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=windows-1251" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<ul>
    <li>ID: ${user.id}</li>
    <li>Email: ${user.username}</li>
    <li>Name: ${user.userpassword}</li>
    <br/>
    <hr/>

    <form action="${pageContext.request.contextPath}/update" method="post">
        <li> New Username: <input type="text" name="username"> </li>
        <input type="number" hidden name="id" value="${user.id}"/>
        <input type="submit" value="Update">
    </form>


</ul>
</body>
</html>
