<%-- 
    Document   : login
    Created on : 2022-10-12, 17:45:27
    Author     : musta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="POST">
            <label>Username:</label>
            <input name="username" autofocus />
            </br>
            <label>Password:</label>
            <input type="password" name="password" />
            </br>
            <button type="submit">Log in</button>
        </form>
        <p>${msg}</p>
    </body>
</html>
