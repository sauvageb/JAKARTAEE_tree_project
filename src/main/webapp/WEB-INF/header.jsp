<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header class="p-3 text-bg-dark mb-5">
    <div class="container-fluid">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <img src="https://img.icons8.com/cotton/64/000000/tree.png" width="50" height="50"/>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/tree-list" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="/tree/add" class="nav-link px-2 text-secondary">Administration</a></li>
            </ul>

            <c:if test="${isMenu}">
                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                    <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..."
                           aria-label="Search">
                </form>

                <div class="text-end">
                    <button type="button" class="btn btn-outline-light me-2">Login</button>
                    <button type="button" class="btn btn-success">Sign-up</button>
                </div>
            </c:if>
        </div>
    </div>
</header>

<script>
    const url = window.location.href;
    document.querySelectorAll('header ul a').forEach(link => {
        if (url.endsWith(link.getAttribute('href'))) {
            link.classList.add("text-white");
            link.classList.remove("text-secondary");
        }
    });
</script>
