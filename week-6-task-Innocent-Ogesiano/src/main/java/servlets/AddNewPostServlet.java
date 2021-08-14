package servlets;

import dao.PostDao;
import models.Post;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddNewPostServlet", value = "/AddNewPostServlet")
public class AddNewPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String name=request.getParameter("body");

        Post post = new Post();
        post.setPost(name);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int status= PostDao.newPost(post,user);
        if(status>0){
//            user.getUserListOfPosts().add(post);
//            request.setAttribute("done", "Post successfully updated");
            request.getRequestDispatcher("dashboard.jsp").include(request, response);
//            out.print("<p>Post saved successfully!</p>");
        }else{
            out.println("Sorry! unable to process your post");
        }
        out.close();
    }
}
