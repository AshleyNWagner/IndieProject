<%@include file="includes/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:import url="includes/head.jsp" />
<body>
<c:import url="includes/navigation.jsp" />
<div class="container bg-white p-0">
    <main class="p-2">
        <h1 class="text-dark text-left mx-auto">Stories By Title</h1>
<c:choose>
    <c:when test="${not empty searchedStoriesByTitle}">
        <div class="row">
            <div class="card-deck">
        <c:forEach var="storyByTitle" items="${searchedStoriesByTitle}">
            <div class="col-md-6 col-lg-4 mb-3">
                <div class="card h-100 bg-secondary" style="width: 18rem;">
                        <%--<img class="card-img-top" src="/images/fantasy.jpg" width="100" height="200">--%>
                    <div class="card-body bg-white">
                        <h5 class="card-title ms-2">${storyByTitle.title}</h5>
                        <p class="card-text ms-2">${storyByTitle.description}</p>
                    </div>
                    <div class="my-2 ms-3">
                        <form action="readStory">
                            <button class="btn btn-primary px-4 py-2 my-sm-0" type="submit" name="indexSubmit" value="${storyByTitle.id}">Read</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <p class="mx-auto">No Results found.</p>
    </c:otherwise>
</c:choose>
        <br><br>
<h1>Stories By Tag</h1>
        <c:choose>
        <c:when test="${not empty searchedStoriesByTag}">
        <div class="row">
            <div class="card-deck">
                <c:forEach var="storyByTag" items="${searchedStoriesByTag}">
                    <div class="col-md-6 col-lg-4 mb-3">
                        <div class="card h-100 bg-secondary" style="width: 18rem;">
                                <%--<img class="card-img-top" src="/images/fantasy.jpg" width="100" height="200">--%>
                            <div class="card-body bg-white">
                                <h5 class="card-title ms-2">${storyByTag.title}</h5>
                                <p class="card-text ms-2">${storyByTag.description}</p>
                            </div>
                            <div class="my-2 ms-3">
                                <form action="readStory">
                                    <button class="btn btn-primary px-4 py-2 my-sm-0" type="submit" name="indexSubmit" value="${storyByTag.id}">Read</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        </c:when>
        <c:otherwise>
        <p>No Results found.</p>
        </c:otherwise>
        </c:choose>
        <br><br>
<h1>Stories By Author</h1>
        <c:choose>
        <c:when test="${not empty searchedStoriesByUser}">
        <div class="row">
            <div class="card-deck">
                <c:forEach var="storyByUser" items="${searchedStoriesByUser}">
                    <div class="col-md-6 col-lg-4 mb-3">
                        <div class="card h-100 bg-secondary" style="width: 18rem;">
                                <%--<img class="card-img-top" src="/images/fantasy.jpg" width="100" height="200">--%>
                            <div class="card-body bg-white">
                                <h5 class="card-title ms-2">${storyByUser.title}</h5>
                                <p class="card-text ms-2">${storyByUser.description}</p>
                            </div>
                            <div class="my-2 ms-3">
                                <form action="readStory">
                                    <button class="btn btn-primary px-4 py-2 my-sm-0" type="submit" name="indexSubmit" value="${storyByTag.id}">Read</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        </c:when>
        <c:otherwise>
        <p>No Results found.</p>
        </c:otherwise>
        </c:choose>
</main>
</div>
<c:import url="includes/bootstrap.jsp" />
</body>
</html>
