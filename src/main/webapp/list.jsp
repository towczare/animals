<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>List of animals servlet!</h2>

<h4>We have ${animals.size()} animals here.</h4>

<table border="1">
    <tr>
        <td>Index</td>
        <td>Animal</td>
        <td>Details</td>
    </tr>
<c:forEach var="animal" items="${animals}" >
    <tr>
        <td><c:out value="${animal.key}" /></td>
        <td><c:out value="${animal.value.name}" /></td>
        <td><a href="/animals/details?id=${animal.key}">Details</a></td>
    </tr>
</c:forEach>
</table>

</body>
</html>
