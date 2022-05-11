<%@include file="includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<c:import url="includes/head.jsp" />
<body>

<c:import url="includes/navigation.jsp" />
<form style="width:50%; margin: 1em auto" action="chooseProgression">
    <legend>Choose Branch to Continue.</legend>
    <div class="form-group">
        <label for="branchSelect" class="form-label mt-4">Previous Branches</label>
        <select name="branch" class="form-select" id="branchSelect">
            <option disabled selected value> -- select branch to continue -- </option>
            <c:forEach var="branch" items="${currentStory.branches}">
                <option value="${branch.branchDescription}">${branch.branchDescription}</option>
            </c:forEach>
        </select>
    </div><br><br>
    <button class="btn btn-secondary btn-lg" type="submit" name="submit" value="chooseProgression">Continue From Branch</button>
    <button class="btn btn-secondary btn-lg" type="submit" formaction="loadIndex" name="submit" value="finish">Finish</button>
</form>
<c:import url="includes/bootstrap.jsp" />
</body>
</html>