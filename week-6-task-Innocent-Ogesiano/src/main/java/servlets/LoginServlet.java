package servlets;

import dao.PostDao;
import dao.UserDao;
import models.Post;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter printer = response.getWriter();

        UserDao userDao = new UserDao();
        User user= new User();
        user.setEmail(email);
        user.setPassword(password);

        try {
            String destPage = "";
            User user1 = userDao.checkLogin(user);
//
            if (user1 != null) {
                HttpSession session = request.getSession();
                List<Post> posts = PostDao.fetchAllPosts();
                session.setMaxInactiveInterval(10*60);
                session.setAttribute("user", user1);
                session.setAttribute("posts", posts);
                response.sendRedirect(request.getContextPath()+"/dashboard");
            } else {
                request.setAttribute("no_user", "Email/Password not correct");
                destPage = "index.jsp";
                RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                dispatcher.forward(request, response);
            }
//



        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
