<%@include file="includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:import url="includes/head.jsp" />
<body>
<c:import url="includes/navigation.jsp" />
<p></p>

<h1>${currentRead.title}</h1>
<h2>${selectedBranch.branchDescription}</h2>
<p>${selectedBranch.branchText}</p>

<form action="readStory">
    <c:forEach var="choiceId" items="${choiceIdMap}">
        <button class="btn btn-secondary" type="submit" name="branchChoiceSubmit" value="${choiceId.key}">${choiceId.value}</button>
    </c:forEach>
</form>
<c:import url="includes/bootstrap.jsp" />
</body>
</html>