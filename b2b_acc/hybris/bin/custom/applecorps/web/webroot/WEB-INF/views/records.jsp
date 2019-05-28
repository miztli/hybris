<%--
  Created by IntelliJ IDEA.
  User: miztlimelgoza
  Date: 2019-05-28
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Record Details</title>
</head>
<body>
    <h1>Record Details</h1>

    <table>
        <c:forEach var="entry" items="${recordDetails}">
            <tr>
                <td><c:out value="${entry.key}"/></td>
                <td><c:out value="${entry.value}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
