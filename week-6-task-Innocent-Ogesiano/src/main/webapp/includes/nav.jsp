<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 08/08/2021
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar mb-5 navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">

        <a class="navbar-brand" href="${pageContext.request.contextPath}/DashboardServlet">
            <b class="javabook">Face</b>Book
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

            </ul>
            <div class="d-flex ">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex justify-content-between align-items-center">
                    <li class="nav-item">
                        <%
                            if (request.getSession().getAttribute("user") != null) {
                                User user = (User) request.getSession().getAttribute("user");
//                                out.print(user.getFullName());
                            }
                        %>
                    </li>

                    <li class="nav-item">
                        <form action="<%= request.getContextPath() %>/LogoutServlet" method="get" >
<%--                            <input type="hidden" name="page" value="destroy">--%>
                            <button type="submit" class="btn btn-outline-primary btn-sm">
                                Logout
                            </button>
                        </form>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</nav>
