<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
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
<h1>REGISTRATION</h1>
<div id="action_form">
    <form action="/registration" method="post">
        Login<input type="email" name="username"> </br>
        Password<input type="password" name="userpassword"></br>
        <input type="submit" value="Register">
        <p><a href="/login">Login</a></p>
    </form>
</div>
</body>
</html>
