<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<div>
    <p style="color: lime">${msg}</p>
</div>
<form:form method="post" action="/save" modelAttribute="electronicMailbox">
    <table>
        <tr>
            <th>
                Languages:
            </th>
            <td>
                <form:select path="languages">
                    <form:option value="English">
                        English
                    </form:option>
                    <form:option value="Vietnamese">
                        Vietnamese
                    </form:option>
                    <form:option value="Japanese">
                        Japanese
                    </form:option>
                    <form:option value="Chinese">
                        Chinese
                    </form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Page Size:</th>
            <td>
                Show
                <form:select path="pageSize">
                    <form:option value="5">
                        5
                    </form:option>
                    <form:option value="10">
                        10
                    </form:option>
                    <form:option value="15">
                        15
                    </form:option>
                    <form:option value="25">
                        25
                    </form:option>
                    <form:option value="50">
                        50
                    </form:option>
                    <form:option value="100">
                        100
                    </form:option>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <th>Spams fillter:</th>
            <td>
                <form:checkbox path="spamsFillter" value="yes"></form:checkbox>
                Enable spams fillter
            </td>
        </tr>
        <tr>
            <th>Signature:</th>
            <td>
                <form:textarea path="signature" itemValue="${electronicMailbox.signature}"></form:textarea>
            </td>
        </tr>
        <tr>
            <th>
                <input type="submit" value="Update">
            </th>
            <th>
                <input type="reset" value="Reset">
            </th>
        </tr>
    </table>
</form:form>
<h3> ${languages}</h3>
<h3> ${pageSize}</h3>
<h3> ${spamsFillter}</h3>
<h3> ${signature}</h3>
</body>
</html>
