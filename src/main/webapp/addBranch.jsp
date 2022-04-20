<!DOCTYPE html>
<html lang="en" dir="ltr">
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/navigation.jsp"%>

<main>
    <form style="width:30%; margin: 1em auto" action="addBranch" method="post">

        <div class="form-group">
            <label for="branchDescription">Branch Description</label>
            <input type="text" name="branchDescription" id="branchDescription" class="form-control">
        </div>

        <div class="form-group">
            <label for="branchText">Text</label>
            <textarea name="branchText" id="branchText" cols="30" rows="10"></textarea>
        </div>

        <div class="form-group">
            <label for="ChoiceOne">Choice One</label>
            <input type="text" name="choiceOne" id="ChoiceOne" class="form-control">
        </div>
        <div class="form-group">
            <label for="choiceTwo">Choice Two</label>
            <input type="text" name="choiceTwo" id="choiceTwo" class="form-control">
        </div>

        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Branch</button>
    </form>
</main>


<%@include file="includes/bootstrap.jsp"%>
</body>
</html>
