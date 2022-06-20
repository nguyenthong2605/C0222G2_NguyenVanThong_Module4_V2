<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="text-align: center">
<button><a href="/create">create song</a></button>
<p>${mess}</p>
<div style="text-align: center">
    <table border="1">
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Singer</th>
            <th>Kind Of Music</th>
            <th>Path</th>
        </tr>
        <c:forEach items="${songs}" var="song" varStatus="thong">
            <tr>
                <td>${thong.count}</td>
                <td>${song.name}</td>
                <td>${song.singer}</td>
                <td>${song.kindOfMusic}</td>
                <td><a href="${song.path}">click</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
