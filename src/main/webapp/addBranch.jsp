<%@include file="includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:import url="includes/head.jsp" />
<body>
<c:import url="includes/navigation.jsp" />

<main>
    <form style="width:30%; margin: 1em auto" action="addBranch" method="post">

        <div class="form-group">
            <label for="branchDescription" class="form-label mt-4">Branch Description</label>
            <input type="text" name="branchDescription" id="branchDescription" class="form-control">
        </div>

        <div class="form-group">
            <label for="branchText" class="form-label mt-4">Add Text Body</label>
            <textarea class="form-control" id="branchText" name="branchText" rows="3"></textarea>
        </div>

        <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="submit" value="addBranch">Add Branch</button>

    </form>
</main>


<c:import url="includes/bootstrap.jsp" />
</body>
</html>