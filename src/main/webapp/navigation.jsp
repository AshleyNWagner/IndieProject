<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">IndieProject</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp">Home
                        <span class="visually-hidden">(current)</span>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Browse</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Genre</a>
                        <a class="dropdown-item" href="#">Genre</a>
                        <a class="dropdown-item" href="#">Genre</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Separated link</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Write</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Log In</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="signUp.jsp">Sign Up</a>
                </li>

            </ul>
            <form class="d-flex" action="search">
                <input class="form-control me-sm-2" type="text" name="searchTerm" placeholder="Search">
                <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
