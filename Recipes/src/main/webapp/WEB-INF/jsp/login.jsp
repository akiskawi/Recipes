<%-- 
    Document   : login
    Created on : Jul 4, 2022, 11:18:25 AM
    Author     : akisk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Existing User</h1>
        <form action="/login"method="Post">
            Name<input type="name" name="name"><br>
            Password<input type="password" name="password"><br>
            <input type="submit">
        </form>
    </body>
</html>
