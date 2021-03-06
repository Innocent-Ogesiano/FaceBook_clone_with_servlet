<%@include file="includes/header.jsp"%>


<div class="container mt-5">

    <div class="row signup">

        <div class="col-lg-7">

            <img src="" alt="">
            <h1 class="logo pb-2">FaceBook</h1>
            <h2 class="JavaFacebook mb-5">Welcome to Facebook.</h2>
        </div>

        <div class="col-lg-5">

            <div class="shadow p-3 mb-5 bg-body rounded">
                <h3 class="">Sign Up Page</h3>
                <form action="<%=request.getContextPath()%>/RegisterNewUser" method="post">
                    <input type="hidden" name="page" value="register">
                    <div class="mb-3">
                        <input type="text" name="fullname" value="<%=request.getAttribute("fullname") != null ? request.getAttribute("fullname").toString() : ""  %>" class="form-control" placeholder="Full Name" aria-describedby="firstNameHelp">
                        <%
                            if(request.getAttribute("firstName") != null) {
                        %>
                        <div id="firstNameHelp" class="form-text text-danger"><%= request.getAttribute("fullname").toString() %></div>
                        <%
                            }
                        %>
                    </div>

                    <div class="mb-3">
                        <input type="text" name="username" value="<%=request.getAttribute("username") != null ? request.getAttribute("username").toString() : ""  %>" class="form-control" placeholder="User Name" aria-describedby="lastNameHelp">
                        <%
                            if(request.getAttribute("username") != null) {
                        %>
                        <div id="lastNameHelp" class="form-text text-danger"><%= request.getAttribute("username").toString() %></div>
                        <%
                            }
                        %>
                    </div>

                    <div class="mb-3">
                        <input type="date" name="dateofbirth" value="<%=request.getAttribute("dateofbirth") != null ? request.getAttribute("dateofbirth").toString() : ""  %>" class="form-control" placeholder="Date Of Birth" aria-describedby="emailHelp">
                        <%
                            if(request.getAttribute("dateofbirth") != null) {
                        %>
                        <div id="emailHelp" class="form-text text-danger"><%= request.getAttribute("dateofbirth").toString() %></div>
                        <%
                            }
                        %>
                    </div>

                    <div class="mb-3">
                        <input type="email" name="email" value="<%=request.getAttribute("email1") != null ? request.getAttribute("email1").toString() : ""  %>" class="form-control" placeholder="Email" aria-describedby="emailHelp">
                        <%
                            if(request.getAttribute("email") != null) {
                        %>
                        <div id="emailHelp" class="form-text text-danger"><%= request.getAttribute("email").toString() %></div>
                        <%
                            }
                        %>
                    </div>

                    <div class="mb-3">
                        <input type="text" name="country" value="<%=request.getAttribute("country") != null ? request.getAttribute("country").toString() : ""  %>" class="form-control" placeholder="Country" aria-describedby="emailHelp">
                        <%
                            if(request.getAttribute("country") != null) {
                        %>
                        <div id="emailHelp" class="form-text text-danger"><%= request.getAttribute("country").toString() %></div>
                        <%
                            }
                        %>
                    </div>

                    <div class="mb-3">
                        <input type="password" name="password" class="form-control" placeholder="Password" aria-describedby="passwordHelp">
                        <%
                            if(request.getAttribute("password") != null) {
                        %>
                        <div id="passwordHelp" class="form-text text-danger"><%= request.getAttribute("password").toString() %></div>
                        <%
                            }
                        %>
                    </div>

<%--                    <p class="m3-4">Gender</p>--%>
<%--                    <div class="mb-3">--%>
<%--                        <div class="form-check form-check-inline">--%>
<%--                            <input class="form-check-input" name="gender" type="radio" id="inlineRadio1" value="male">--%>
<%--                            <label class="form-check-label" for="inlineRadio1">Male</label>--%>
<%--                        </div>--%>
<%--                        <div class="form-check form-check-inline">--%>
<%--                            <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="female">--%>
<%--                            <label class="form-check-label" for="inlineRadio2">Female</label>--%>
<%--                        </div>--%>
<%--                        <%--%>
<%--                            if(request.getAttribute("gender") != null) {--%>
<%--                        %>--%>
<%--                        <div class="form-text text-danger"><%= request.getAttribute("gender").toString() %></div>--%>
<%--                        <%--%>
<%--                            }--%>
<%--                        %>--%>
<%--                    </div>--%>

                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary btn-lg">Register</button>
                    </div>
                </form>
                <div class="d-grid gap-2 mt-3">
                    <p class="text-center mt-2">Have An Account?</p>
                    <div class="divider"></div>
                    <a href= "index.jsp" class="btn btn-link text-center ">
                        Login
                    </a>
                </div>


            </div>

        </div>

    </div>

</div>


<%@include file="/includes/footer.jsp" %>