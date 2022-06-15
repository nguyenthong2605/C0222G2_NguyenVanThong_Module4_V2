<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/dictionary">
    <input type="text" name="search" placeholder="Nhập từ cần tra: "/>
    <input type="submit" value="Search"/>
    <h2>Result: ${result}</h2>
</form>

</body>
</html>
