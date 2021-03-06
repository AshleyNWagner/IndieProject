<%@include file="includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:import url="includes/head.jsp" />
<body>

<c:import url="includes/navigation.jsp" />

<main>
    <form style="width:50%; margin: 1em auto" action="createStory" method="post">
        <legend>Create a New Story.</legend>
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" name="title" id="title" class="form-control">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" name="description" id="description" class="form-control">
        </div>
        <div class="form-group">
            <label for="tags">Tags</label>
            <input type="text" name="tags" id="tags" class="form-control">
        </div>
        <button class="btn btn-secondary btn-lg" type="submit" name="createStory">Create Story</button>
    </form>
</main>
<c:import url="includes/bootstrap.jsp" />
</body>
</html>
