<%@include file="includes/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:import url="includes/head.jsp" />
<body>
<c:import url="includes/navigation.jsp" />

<h2>Stories By Title</h2>
<c:choose>
    <c:when test="${not empty searchedStoriesByTitle}">
        <c:forEach var="storyByTitle" items="${searchedStoriesByTitle}">
            <div class="card" style="width: 18rem;">
<%--                <img class="card-img-top" src="..." alt="Card image cap">--%>
                <div class="card-body">
                    <h5 class="card-title">${storyByTitle.title}</h5>
                    <p class="card-text">${storyByTitle.description}</p>

                    <form action="readStory">
                        <button class="btn btn-secondary" type="submit" name="searchResultsSubmit" value="${storyByTitle.id}">Read</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>No Results found.</p>
    </c:otherwise>
</c:choose>

<h2>Stories By Tag</h2>
<c:choose>
    <c:when test="${not empty searchedStoriesByTag}">
        <c:forEach var="storyByTag" items="${searchedStoriesByTag}">
            <a href="readStory">${storyByTag.title}</a>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>No results found.</p>
    </c:otherwise>
</c:choose>

<h2>Stories By Author</h2>
<c:choose>
    <c:when test="${not empty searchedStoriesByUser}">
        <c:forEach var="storyByUser" items="${searchedStoriesByUser}">
            <a href="readStory">${storyByUser.title}</a>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>No results found.</p>
    </c:otherwise>
</c:choose>


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


<%--</main>--%>

<c:import url="includes/bootstrap.jsp" />
</body>
</html>
