<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Insert Form</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css">
    <link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">

</head>

<body>
    <!-- Menu -->
    <%@ include file="/WEB-INF/views/commons/header.jsp" %>

    <!-- Main Content -->

    <form action="/files/insertMulti" method="post" id="insertForm" enctype="multipart/form-data">
        <div class="container mt-5">
            <div class="container mt-4">
                <div class="row">
                    <h1>Insert Form</h1>

                    <div class="mb-3">
                        <label for="title" class="form-label">Title</label>
                        <input type="text" class="form-control" id="title" name="title" value="file title">
                    </div>
                    <div class="mb-3">
                        <label for="editor" class="form-label">Content</label>
                        <div id="editor" style="height: 300px;" class="form-control"> 
                            <b>file contents</b>
                        </div>
                        <input type="hidden" name="content" id="contentInput" />
                    </div>
                    <%
                    for (int i = 0; i < 2; i += 1) {
                    %>
                    <div class="mb-3">
                        <label for="fileUpload_${i}" class="form-label">File Upload</label>
                        <input type="file" class="form-control-file" id="fileUpload_${i}" name="fileUpload_${i}" />
                    </div>
                    <%
                    }
                    %>                    

                    <button type="submit" class="btn btn-primary">Submit</button>

                </div>
            </div>
        </div>

    </form>

    <!-- Footer -->
    <%@ include file="/WEB-INF/views/commons/footer.jsp" %>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
    <script>
        var quill = new Quill('#editor', {
            theme: 'snow'
        });

        // Set hidden input value before form submission
        var form = document.querySelector('#insertForm');
        form.onsubmit = function () {
            var contentInput = document.querySelector('#contentInput');
            contentInput.value = JSON.stringify(quill.getContents());
            return true;
        };
    </script>

</body>

</html>