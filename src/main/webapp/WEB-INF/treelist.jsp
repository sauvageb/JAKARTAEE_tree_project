<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tree Project | Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <script src="/js/tree-list.js" defer></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh2XeR_Ti3XZQOsZMVUDH6x5Xb7ew6l0Q&callback=initMap"
            defer></script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


<div class="container mt-4">

    <h1>Tree List :</h1>

    <div class="row">
        <c:forEach items="${treeList}" var="tree">

            <div class="col-lg-4 mb-3 d-flex align-items-stretch">
                <div class="card">
                    <img src="${tree.pictureUrl}" class="card-img-top" alt="${tree.name}">
                    <div class="card-body">
                        <h5 class="card-title text">${tree.name}</h5>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Family : ${tree.family}</li>
                        <li class="list-group-item">Edible : <c:out
                                value="${tree.edible ? 'yes' : 'no'}"></c:out></li>
                    </ul>

                    <div class="card-footer d-flex justify-content-end">


                        <a href="${pageContext.request.contextPath}/tree/details?id=${tree.id}"
                           class="btn btn-success btn mx-2">Details</a>

                    </div>
                </div>

            </div>


        </c:forEach>
    </div>
</div>

<div id="googleMap" class="container-fluid p-0 h-50"></div>


</body>
</html>
