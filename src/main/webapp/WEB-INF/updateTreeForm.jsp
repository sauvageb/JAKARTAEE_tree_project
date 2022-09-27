<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tree Project | Edit Tree</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>


<jsp:include page="header.jsp"></jsp:include>


<div class="container mt-4">

    <h1>Edit Tree :</h1>

    <div class="row">
        <div class="col-4">
            <div class="row">
                <form action="${pageContext.request.contextPath}/tree/edit" method="POST">
                    <input hidden type="text" name="id" value="${tree.id}">

                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input id="name" name="name" type="text" class="form-control" value="${tree.name}">
                    </div>

                    <div class="mb-3">
                        <label for="family" class="form-label">Family</label>
                        <input id="family" type="text" name="family" class="form-control" value="${tree.family}">
                    </div>

                    <div class="mb-3">
                        <label for="pictureUrl" class="form-label">Picture Url</label>
                        <input id="pictureUrl" type="text" name="pictureUrl" class="form-control"
                               value="${tree.pictureUrl}" required>
                    </div>

                    <div class="mb-3">
                        <label for="latitude" class="form-label">Latitude</label>
                        <input id="latitude" type="number" readonly name="latitude" class="form-control"
                               value="${tree.latitude}" required>

                    </div>

                    <div class="mb-3">
                        <label for="longitude" class="form-label">Longitude</label>
                        <input id="longitude" type="number" readonly name="longitude" class="form-control"
                               value="${tree.longitude}" required>
                    </div>

                    <div class="mb-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="edible" checked="${tree.edible}">
                            <label class="form-check-label" for="edible">Edible</label>
                        </div>
                    </div>

                    <div></div>


                    <div class="d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary">Edit</button>
                    </div>
                </form>
            </div>
        </div>

        <div class="col-4 offset-2">
            <div class="row">
                <img id="pictureOverview" src="">
            </div>
        </div>

        <script>
            const inputPictureUrl = document.getElementById("pictureUrl");
            const img = document.getElementById("pictureOverview");

            const regex_HTTP_HTTPS = /[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)?/gi;
            const regex = new RegExp(regex_HTTP_HTTPS);

            inputPictureUrl.addEventListener('input', (event) => {

                img.src = inputPictureUrl.value;

                let test = document.getElementById("pictureOverview").src;

                if (!test.match(regex)) {
                    setPicturePlaceholder();
                }
            });

            setPicturePlaceholder();


            function setPicturePlaceholder() {
                document.getElementById("pictureOverview").src = 'https://img.icons8.com/ios/500/000000/no-image-gallery.png';
            }
        </script>

    </div>


</body>
</html>
