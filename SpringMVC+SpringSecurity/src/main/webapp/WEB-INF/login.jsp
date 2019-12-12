<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <style>
        html, body{width:100%; height:100%; margin:0}
        #action_form{
            position:absolute;
            width:200px;
            height:150px;
            left:50%;
            top:50%;
            margin-left:-100px;
            margin-top:-100px;
            border:1px solid
        }
        form{padding:14px}
    </style>
</head>
<body>
<h1>LOGIN</h1>
<div id="action_form">
    <form action="/login" method="post">
        Email<input type="email" name="j_username"  required autofocus value="email@mail"></br>
        Password<input type="password" name="j_password" required value="*******"></br>
        <button type="submit">Войти</button>
        <p><a href="/registration">Registration</a></p>
    </form>
</div>

</body>
</html>
