<%-- 
    Document   : register
    Created on : Jul 4, 2022, 10:03:41 AM
    Author     : akisk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register New User</h1>
        <form action="/register"method="Post">
            Email<input type="email" name="email"><br>
            name<input type="name" name="name"><br>
            Password<input type="password" name="password"><br>
            <input type="submit">
        </form>
    </body>
</html>
