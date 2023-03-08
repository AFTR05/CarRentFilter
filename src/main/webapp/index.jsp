<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/bootwatch.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div id="space">


    <div id="information-space">
    <h6>Login</h6>
    <form action="/login" method="post">
        <div>
            <h6>Nickname</h6>
            <input type="text" name="nickname" />
        </div>
        <div>
            <h6>Password</h6>
            <input type="text" name="password" />
        </div>
        <button type="submit" name="register-client">Log in</button>
    </form>
    <a href="register.jsp">Register</a>
    </div>
</div>

</body>
</html>