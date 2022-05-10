<%@include file="includes/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:import url="includes/head.jsp" />
<body>
<c:import url="includes/navigation.jsp" />

<main>

    <%--    https://ckeditor.com/docs/ckeditor5/latest/installation/advanced/saving-data.html--%>
    <form action="addBranch" method="post">
        <div class="form-group">
            <label for="branchDescription" class="form-label mt-4">Branch Description</label>
            <input type="text" name="branchDescription" id="branchDescription" class="form-control">
        </div>
        <div class="form-group">
            <label for="editor" class="form-label mt-4">Text Body</label>
            <textarea class="form-control" id="editor" name="branchText" rows="3"></textarea>
        </div>
        <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="submit" value="addBranch">Add Branch</button>
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
