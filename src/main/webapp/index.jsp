<!DOCTYPE html>
<html lang="en" dir="ltr">
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/navigation.jsp"%>

<c:choose>
    <c:when test="${empty userName}">
        <a href = "logIn">Log in</a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
        <p>${firstName}</p>
        <p>${lastName}</p>
        <p>${email}</p>
    </c:otherwise>
</c:choose>


<%@include file="includes/bootstrap.jsp"%>
</body>
</html>


