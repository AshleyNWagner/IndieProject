<%@include file="includes/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/navigation.jsp"%>
    <h2>Users like <em>${searchTerm}</em></h2>
    <c:forEach var="user" items="${users}">
        <p>${user.userName}</p>
    </c:forEach>
<%@include file="includes/bootstrap.jsp"%>
</body>
</html>
