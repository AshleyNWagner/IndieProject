<%@include file="../includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<jsp: page="loadIndex" />
<c:import url="../includes/head.jsp" />
<body>
<c:import url="../includes/navigation.jsp" />

<main>
    <c:if test="${not empty recentStories}">
        <c:forEach var="story" items="${recentStories}">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="..." alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">${story.title}</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="submit" value="${story.id}">Read</button>
                </div>
            </div>
        </c:forEach>
    </c:if>

</main>


<c:import url="../includes/bootstrap.jsp" />
</body>
</html>


