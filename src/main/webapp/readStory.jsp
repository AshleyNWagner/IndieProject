<%@include file="includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:import url="includes/head.jsp" />
<body>
<c:import url="includes/navigation.jsp" />
<main class="p-5">
    <h1>${currentRead.title}</h1>
    <h2>${selectedBranch.branchDescription}</h2>
    <p>${selectedBranch.branchText}</p>

    <form action="readStory">
        <c:choose>
            <c:when test="${not empty choiceIdMap}">
                <c:forEach var="choiceId" items="${choiceIdMap}">
                    <button class="btn btn-lg btn-secondary" type="submit" name="branchChoiceSubmit" value="${choiceId.key}">${choiceId.value}</button>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>End of Story.<a href="loadIndex"> Browse more titles.</a></p>
            </c:otherwise>
        </c:choose>
    </form>
</main>
<c:import url="includes/bootstrap.jsp" />
</body>
</html>