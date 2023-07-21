<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css">
    <title>Insert Form</title>
</head>

<body>
    <div class="container">
        <div class="text-center mt-4 mb-4 h1">Update Form</div>
    </div>
    <div class="container">
        <form id="updateForm" action="/main/updateForm" method="post">
            <div class="mb-3" type="hidden">
                <label class="form-label" for="commonCodeId" type="hidden">COMMON_CODE_ID:</label>
                <input class="form-control" type="hidden" id="commonCodeId" name="COMMON_CODE_ID">
            </div>
            <div class="mb-3">
                <label class="form-label" for="name">NAME:</label>
                <input class="form-control" type="text" id="name" name="NAME">
            </div>
            <div class="mb-3">
                <label class="form-label" for="orderNumber">ORDER_NUMBER:</label>
                <input class="form-control" type="text" id="orderNumber" name="ORDER_NUMBER">
            </div>
            <div class="mb-3">
                <label class="form-label" for="description">DESCRIPTION:</label>
                <input class="form-control" type="text" id="description" name="DESCRIPTION">
            </div>
            <div class="mb-3">
                <label class="form-label" for="modifyDate">MODIFY_DATE:</label>
                <input class="form-control" type="text" id="modifyDate" name="MODIFY_DATE">
            </div>
            <div class="text-center">
                <button class="btn btn-primary" type="submit" formaction="/main/updateAndSelectSearch/${UNIQUE_ID}">Submit</button>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>