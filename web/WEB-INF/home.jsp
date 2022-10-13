<%-- 
    Document   : home
    Created on : 2022-10-12, 17:41:15
    Author     : musta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h2>Hello ${username}.</h2>
        <div>
            <a href="/MyLogin/login?logout">Logout</a>
        </div>
    </body>
</html>
