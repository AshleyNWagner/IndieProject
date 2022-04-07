<!DOCTYPE html>
<html lang="en" dir="ltr">
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/navigation.jsp"%>

<main>
    <form style="width:30%; margin: 1em auto" action="createStory" method="post">
        <div class="form-group">
            <label for="title">title</label>
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
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Create Story</button>
    </form>
</main>


<%@include file="includes/bootstrap.jsp"%>
</body>
</html>
