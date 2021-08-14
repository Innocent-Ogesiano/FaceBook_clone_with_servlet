<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="models.User" %>
<%@ page import="models.Post" %>
<%@ page import="dao.UserDao" %>
<%@include file="includes/header.jsp"%>
<%@include file="includes/nav.jsp"%>

<div class="container">

    <div class="row">
        <div class="col-lg-3">
            <div class="shadow p-3 mb-5 bg-body rounded text-center">
                <img class="profile-pic-icon-three mt-4" src="assets/images/avatar.png" alt="">
                <h5 class="mt-3">
                    ${user.fullName}
                </h5>
                <a href="${pageContext.request.contextPath}/ViewUserPostServlet">View User's Posts</a> <br>
                <a href="${pageContext.request.contextPath}/EditProfileServlet">Edit Profile</a> <br>
                <a href="${pageContext.request.contextPath}/ViewAllUsersServlet">View All Users</a>
            </div>
        </div>
        <div class="col-lg-9">

            <div class="shadow p-3 mb-5 bg-body rounded">
                <div class="row">
                    <%
                        if(request.getParameter("is_deleted") != null) {
                    %>
                    <div class="alert alert-danger" role="alert">
                        Post Deleted Successfully from our system.
                    </div>
                    <%
                        }
                    %>
                    <form action="<%=request.getContextPath()%>/AddNewPostServlet" method="post">
                        <input type="hidden" name="page" value="add">
                        <div class="col-lg-11 text-right">
                            <textarea class="form-control drag" name="body" placeholder="What's on your mind?" required></textarea>
                            <button class="btn btn-primary btn-md mt-3 btn-block" type="submit">Post</button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row">
                <div><h4 class="mb-4">Posts</h4></div>
            </div>

<%--            <%--%>
<%--                ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posts");--%>
<%--                if(posts.size() == 0){--%>
<%--            %><h4 style="text-align: center; color: #ffffff;">No Posts was made</h4><%--%>
<%--            }--%>
<%--            for(Post post: posts){--%>
<%--        %>--%>
            <c:forEach var="posts" items="${posts}">
<%--            <sql:setDataSource var = "snapshot" driver = "com.mysql.cj.jdbc.Driver"--%>
<%--                               url = "jdbc:mysql://localhost:3306/UserProfileInfoDb"--%>
<%--                               user = "root"  password = "Peace0247"/>--%>

<%--            <sql:query dataSource = "${snapshot}" var = "result">--%>
<%--                SELECT UserPostTable.*, UserInfo.FullName FROM UserPostTable INNER JOIN UserInfo ON UserPostTable.user_Id=UserInfo.Id ORDER BY UserPostTable.post_Id DESC;--%>
<%--            </sql:query>--%>
<%--            <c:forEach var="row" items="${result.rows}">--%>
                <div id="section-one" class="shadow p-3 mb-5 bg-body rounded">
                    <div class="row">
                        <div class="col-lg-1">
                            <img class="profile-pic-icon-two" src="${pageContext.request.contextPath}/assets/images/avatar.png" />
                        </div>
                        <div class="col-lg-11">
                            <h5 class="postName">
    <%--                            <%--%>
    <%--                                User user1 = (new UserDao().getUserById(post.getUserId()));--%>
    <%--                            %>--%>
                                <a href="<%=request.getContextPath()%>/comment?post_id=${row.post_Id}">
                                    <h6>${posts.user.fullName}</h6>
                                </a>
                            </h5>
                            <b>

                            </b>
                            <h6 class="card-subtitle mb-2 text-muted">${posts.post}</h6>
    <%--                        <p class="post-date"><%= post.getCreatedAt() %></p>--%>
                            <div class="post__options">
                                <div class="post__option">
                                    <a href="${pageContext.request.contextPath}/LikeUnlikeServlet?id=${posts.postId}">
                                        <span class="material-icons">thumb_up</span>
                                    </a>
                                    <p>${posts.likes} Likes</p>
                                </div>
                                <div class="post__option">
                                    <span class="material-icons">chat_bubble_outline</span>
                                    <a href="#">
                                        Comments.
                                    </a>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </c:forEach>
<%--            <%--%>
<%--                }--%>
<%--            %>--%>

        </div>

    </div>
</div>

<footer class="text-center mt-5 mb-5">FaceBook  Corporation- 2021</footer>