<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tree Project | Details Tree</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <script src="/js/detail-tree.js" defer></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh2XeR_Ti3XZQOsZMVUDH6x5Xb7ew6l0Q&callback=initMap"
            defer></script>
</head>

<body>


<jsp:include page="header.jsp"></jsp:include>


<div class="container mt-4">

    <h1>Details Tree :</h1>

    <div class="row">
        <div class="col-12">
            <div class="card">
                <img src="${tree.pictureUrl}" class="card-img-top h-50" alt="${tree.name}">
                <div class="card-body">
                    <h5 class="card-title text">${tree.name}</h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Family : ${tree.family}</li>
                    <li class="list-group-item">Edible : <c:out value="${tree.edible ? 'yes' : 'no'}"></c:out></li>
                </ul>

                <div class="card-body p-0">
                    <div id="googleMap" style="width:100%;height:400px;"></div>
                </div>

                <div class="card-footer d-flex justify-content-end">

                    <a href="${pageContext.request.contextPath}/tree/edit?id=${tree.id}"
                       class="btn btn-success btn mx-2">Edit</a>

                    <form action="${pageContext.request.contextPath}/delete-tree" method="post" class="m-0">
                        <input hidden type="text" value="${tree.id}" name="idTree">
                        <button type="submit" class="btn btn-secondary btn">Delete</button>
                    </form>
                </div>
            </div>

        </div>

    </div>


    <%--    <div class="container mt-5">--%>
    <%--        <div class="card-deck">--%>
    <%--            <div class="card">--%>
    <%--                <!-- If I move this card to top, so it  will be on left side. Then it works!!!-->--%>
    <%--                <div class="card-body">--%>
    <%--                    <p class="card-text">This is a longer card</p>--%>
    <%--                    <div id="googleMap" style="width:100%;height:400px;"></div>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--</div>--%>


</body>
</html>
