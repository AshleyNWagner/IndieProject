<%@include file="includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:import url="includes/head.jsp" />
<body>
<c:import url="includes/navigation.jsp" />

<main>

    <%--    https://ckeditor.com/docs/ckeditor5/latest/installation/advanced/saving-data.html--%>
    <form action="addBranch" style="width:50%; margin: 1em auto" method="post">
        <legend>Add a New Branch.</legend>
        <div class="form-group">
            <label for="branchDescription" class="form-label mt-4">Choice Description</label>
            <input type="text" name="branchDescription" id="branchDescription" placeholder="Enter something like 'Go through the door'" class="form-control">
        </div>
        <div class="form-group">
            <label for="editor" class="form-label mt-4">Text Body</label>
            <textarea class="form-control" style="height: 200px;" id="editor" name="branchText" rows="20"></textarea>
        </div>
        <div>
            <button class="btn btn-secondary btn-lg" type="submit" name="submit" value="addBranch">Add Branch</button>
        </div>
    </form>
    <script>
        ClassicEditor
            .create( document.querySelector( '#editor' ) )
            .catch( error => {
                console.error( error );
            } );
        document.querySelector( '#submit' ).addEventListener( 'click', () => {
            const editorData = editor.getData();
        } );

    </script>
</main>
<c:import url="includes/bootstrap.jsp" />
</body>
</html>
