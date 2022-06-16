<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/4/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator">
    <h1>Calculator</h1>
    <input type="text" name="soHangDau"> Số hạng đầu
    <br>
    <br>
    <input type="text" name="soHangSau"> Số hạng hai
    <br>
    <br>
    <input type="submit" name="calculator" value="+"> Phép cộng
    <input type="submit" name="calculator" value="-"> Phép trừ
    <input type="submit" name="calculator" value="*"> Phép nhân
    <input type="submit" name="calculator" value="/"> Phép chia
    <h2>Kết quả: ${result}</h2>
</form>


</body>
</html>
