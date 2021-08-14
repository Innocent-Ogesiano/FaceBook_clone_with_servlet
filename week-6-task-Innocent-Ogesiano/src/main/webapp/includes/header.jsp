<%@ page import="models.Post" %>
<%@ page import="dao.PostDao" %>
<%@ page import="java.util.List" %>
<%@ page import="models.LikeUnlike" %>
<%@ page import="dao.LikeUnlikeDao" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 08/08/2021
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <%
//        HttpSession session = request.getSession();
        List<Post> posts = PostDao.fetchAllPosts();
//        for (Post post: posts) {
//            int noOfLikes = LikeUnlikeDao.getAllPostLikes(post.getPostId());
//            session.setAttribute("likes", noOfLikes);
//        }
        session.setMaxInactiveInterval(10*60);
//        session.setAttribute("user", user1);
        session.setAttribute("posts", posts);
    %>
    <meta charset="utf-8">
    <title>FaceBook Clone - Welcome</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy41WvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">--%>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
<%--    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>--%>
<%--    <link rel="stylesheet" href="../assetsbootstrap.min.css.map.css" type="text/css">--%>
</head>
<body>

