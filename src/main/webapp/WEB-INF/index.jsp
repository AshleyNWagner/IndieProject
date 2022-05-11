<%@include file="../includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<c:import url="../includes/head.jsp" />

<body>
<c:import url="../includes/navigation.jsp" />
<div class="container bg-white p-0">

<main class="p-3">
    <h1 class="text-dark text-left">Recent Additions</h1>
    <c:if test="${not empty recentStories}">
    <div class="row">
        <div class="card-deck">
        <c:forEach var="story" items="${recentStories}" begin="0" end="8" varStatus="loop">
        <%--https://stackoverflow.com/questions/6099066/how-to-loop-over-something-a-specified-number-of-times-in-jstl--%>

<%--            <h5 class="card-title">${story.title}</h5>--%>
<%--            <p class="card-text">${story.description}</p>--%>
<%--            <button class="align-self-end btn btn-secondary  my-2 my-sm-0" type="submit" name="submit" value="${story.id}">Read</button>--%>
            <div class="col-md-6 col-lg-4 mb-3">
            <div class="card h-100 bg-secondary" style="width: 18rem;">
<%--                <img class="card-img-top" src="/images/fantasy.jpg" width="100" height="200">--%>
                <div class="card-body bg-white">
                    <h5 class="card-title ms-2">${story.title}</h5>
                    <p class="card-text ms-2">${story.description}</p>
                </div>
                <div class="my-2 ms-3">
                    <button class="btn btn-primary px-4 py-2 my-sm-0" type="submit" name="submit" value="${story.id}">Read</button>
                </div>
            </div>
            </div>
        </c:forEach>
    </div>
    </div>
    </c:if>

</main>
</div>

<c:import url="../includes/bootstrap.jsp" />
</body>

</html>


