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
import java.util.List;

@WebServlet(name = "ViewUserPostServlet", value = "/ViewUserPostServlet")
public class ViewUserPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='dashboard.jsp'>Back to home</a>");
        out.println("<h1>List of Users' Posts</h1>");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<Post> list= PostDao.getAllUsersPosts(user.getUserId());

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Post Message</th><th>Edit</th><th>Delete</th></tr>");
        for(Post post :list){
            out.print("<tr><td>"+ post.getPostId()+"</td><td>"+ post.getPost()+"</td><td><a href='EditPostServlet?id="+ post.getPostId()+
                    "'>edit</a></td> <td><a href='DeletePostServlet?id="+ post.getPostId()+"'>Delete Post</a></td></tr>");
        }
        out.print("</table>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
