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
            <label for="userName">Username</label>
            <input type="text" name="userName" id="userName" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control">
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" name="confirmPassword" id="confirmPassword" class="form-control">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" id="email" class="form-control">
        </div>
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Sign Up</button>
        <button class="btn btn-secondary my-2 my-sm-0" type="reset">Clear</button>
    </form>
</main>


<%@include file="includes/bootstrap.jsp"%>
</body>
</html>
