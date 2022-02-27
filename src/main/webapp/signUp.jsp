<!DOCTYPE html>
<html lang="en" dir="ltr">
<%@include file="head.jsp"%>
<body>
<%@include file="navigation.jsp"%>

    <main>
        <form style="width:30%; margin: 1em auto">
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" name="firstName" id="firstName" class="form-control">
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" name="lastName" id="lastName" class="form-control">
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
                <label for="email">Email</label>
                <input type="email" name="email" id="email" class="form-control">
            </div>
        </form>
    </main>


<%@include file="bootstrap.jsp"%>
</body>
</html>
