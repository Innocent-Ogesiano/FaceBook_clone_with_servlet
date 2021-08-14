package servlets;

import dao.PostDao;
import models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditPostServlet", value = "/EditPostServlet")
public class EditPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printer =response.getWriter();
        printer.println("<h1>Update Post Info</h1>");
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);

        Post post = PostDao.getPostById(id);

        printer.print("<form method='post'>");
        printer.print("<table>");
        printer.print("<tr><td></td><td><input type='hidden' name='id' value='"+ post.getPostId()+"'/></td></tr>");
        printer.print("<tr><td></td><td><textarea name='postBody'>"+post.getPost()+"</textarea></td></tr>");
        printer.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        printer.print("</table>");
        printer.print("</form>");

        printer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("postBody");

        Post post = new Post();
        post.setPostId(id);
        post.setPost(name);

        int status= PostDao.editPost(post);
        if(status>0){
            response.sendRedirect("ViewUserPostServlet");
        }else{
            out.println("Sorry! unable to updateUserInfo record");
        }

        out.close();
    }
}
