<%@include file="taglib.jsp"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<%@include file="head.jsp"%>
<body>
<%@include file="navigation.jsp"%>
    <h2>Users like ${searchTerm}</h2>
    <c:forEach var="user" items="${users}">
        <p>${user.userName}</p>
    </c:forEach>
<%@include file="bootstrap.jsp"%>
</body>
</html>
