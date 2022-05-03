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


<%--<main class="p-3">--%>
<%--    <h1 class="text-dark text-center">Browse by Genre.</h1>--%>

<%--    <div class="row">--%>
<%--        <div class="col-md-6 col-lg-4 my-3">--%>
<%--            <div class="card">--%>
<%--                <h2 class="card-header bg-info text-white">Literature & Fiction</h2>--%>
<%--                <div class="card-body bg-light text-muted font-weight-bold">--%>
<%--                    <img class="mw-100" src="images/fiction.jpg" alt="">--%>
<%--                    <!-- Photo by Clem Onojeghuo on Unsplash -->--%>
<%--                </div>--%>
<%--                <a href="#" class="btn btn-dark">Browse></a>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--    </div>--%>

<%--    --%>
<%--    <div class="card" style="width: 18rem;">--%>
<%--        <img class="card-img-top" src="..." alt="Card image cap">--%>
<%--        <div class="card-body">--%>
<%--            <h5 class="card-title">Card title</h5>--%>
<%--            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>--%>
<%--            <a href="#" class="btn btn-primary">Go somewhere</a>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--</main>--%>

<%@include file="includes/bootstrap.jsp"%>
</body>
</html>
