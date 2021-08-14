package servlets;

import dao.PostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fetchPosts(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void fetchPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PostDao postDAO = new PostDao();
        request.setAttribute("posts", PostDao.fetchAllPosts());
//        request.setAttribute("likes", LikeUnlikeDao.getAllPostLikes("posts.postId"));
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
