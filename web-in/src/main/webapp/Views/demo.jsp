<%--
  Created by IntelliJ IDEA.
  User: chenyong
  Date: 2017/8/29
  Time: 上午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo</title>
</head>
<body>
<h3>hello 张三 ${requestScope.name}</h3>
<h3>${requestScope.person.toString()}</h3>
</body>
</html>
