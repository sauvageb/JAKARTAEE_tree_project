<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tree Project | Add Tree</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <script src="/js/create-tree.js" defer></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh2XeR_Ti3XZQOsZMVUDH6x5Xb7ew6l0Q&callback=initMap"
            defer></script>
</head>
<body>


<jsp:include page="header.jsp"></jsp:include>


<div class="container mt-4">

    <h1>Add Tree :</h1>

    <div class="row">
        <div class="col-4">
            <div class="row">
                <form action="${pageContext.request.contextPath}/tree/add" method="POST">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input id="name" name="name" type="text" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="family" class="form-label">Family</label>
                        <input id="family" type="text" name="family" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="pictureUrl" class="form-label">Picture Url</label>
                        <input id="pictureUrl" type="text" name="pictureUrl" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="latitude" class="form-label">Latitude</label>
                        <input id="latitude" name="latitude" type="number" readonly name="latitude"
                               class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="longitude" class="form-label">Longitude</label>
                        <input id="longitude" name="longitude" type="number" readonly name="longitude"
                               class="form-control">
                    </div>


                    <div class="mb-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="edible">
                            <label class="form-check-label" for="edible">Edible</label>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary">Create</button>
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

</div>

<div class="row">

    <div class="card-body p-0">
        <div id="googleMap" style="width:100%;height:400px;"></div>
    </div>

</div>


</body>
</html>
