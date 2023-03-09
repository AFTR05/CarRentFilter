<%--
  Created by IntelliJ IDEA.
  User: AFTR
  Date: 08/03/2023
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Login</title>
</head>
<body>
    <div id="information-space">
    <h1 id="log-title">Login</h1>
    <form action="/login" method="post">
            <div>
                <h6>Nickname</h6>
                <input type="text" name="nickname" />
            </div>
            <div>
                <h6>Password</h6>
                <input type="password" name="password" />
            </div>
            <button type="submit" name="register-client" class="btn btn-outline-primary" id="log-button">Log in</button>
    </form>
    <a href="register.jsp">Register</a>
    </div>
</body>
</html>
