<%@include file="includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<c:import url="includes/head.jsp" />
<body>

<c:import url="includes/navigation.jsp" />
<form action="chooseProgression">

    <div class="form-group">
        <label for="exampleSelect1" class="form-label mt-4">Example select</label>
        <option disabled selected value> -- select branch to continue -- </option>
        <select name="branch" class="form-select" id="exampleSelect1">
            <c:forEach var="branch" items="${currentStory.branches}">
                <option value="${branch.branchDescription}">${branch.branchDescription}</option>
            </c:forEach>
        </select>
    </div>

    <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="submit" value="chooseProgression">Continue From Branch</button>
    <button class="btn btn-secondary my-2 my-sm-0" type="submit" formaction="index.jsp" name="submit" value="finish">Finish</button>
</form>
<c:import url="includes/bootstrap.jsp" />
</body>
</html>