<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
id: ${loginUser.id} <br>
name: ${loginUser.name}
host: ${loginUser.host}
<a href="/logout_servlet">退出</a>
</body>
</html>
