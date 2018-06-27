<%--
  Created by IntelliJ IDEA.
  User: liujiefeng
  Date: 2018/6/24
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
        <p id="test"> <%= request.getCookies() + "中文" %></p>
        <div id="app">
            {{ message }}
        </div>
        <script type="text/javascript">
            var app = new Vue({
                el : "#app",
                data : {
                    message : "hi jack"
                }
            })
        </script>
</body>
</html>
