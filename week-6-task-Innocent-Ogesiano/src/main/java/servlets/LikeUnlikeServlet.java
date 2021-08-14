package servlets;

import dao.LikeUnlikeDao;
import models.LikeUnlike;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LikeUnlikeServlet", value = "/LikeUnlikeServlet")
public class LikeUnlikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String postId = request.getParameter("id");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int pid = Integer.parseInt(postId);
        int uid = user.getUserId();
        LikeUnlike likeUnlike = new LikeUnlike();
        likeUnlike.setPost_Id(pid);
        likeUnlike.setUser_Id(uid);
        LikeUnlike lk = LikeUnlikeDao.checkLike(likeUnlike);
        if (lk.getLike_Id() < 1) {
            LikeUnlikeDao.likePost(pid,uid);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request, response);
        } else {
            LikeUnlikeDao.unlikePost(lk.getLike_Id());
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
