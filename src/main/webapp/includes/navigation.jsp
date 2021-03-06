<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="loadIndex">IndieProject</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav me-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="browse.jsp" role="button" aria-haspopup="true" aria-expanded="false">Browse</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Genre</a>
                        <a class="dropdown-item" href="#">Genre</a>
                        <a class="dropdown-item" href="#">Genre</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Separated link</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="createStory.jsp">Write</a>
                </li>
                <c:choose>
                    <c:when test="${empty currentUser}">
                        <li class="nav-item">
                            <a class="nav-link" href="logIn">Log In</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="loadProfile">Profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Log Out</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
            <form class="d-flex" action="search">
                <input class="form-control me-sm-2" type="text" name="searchTerm" placeholder="Search">
                <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
