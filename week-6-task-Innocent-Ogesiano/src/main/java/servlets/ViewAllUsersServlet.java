package servlets;

import dao.UserDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ViewAllUsersServlet", value = "/ViewAllUsersServlet")
public class ViewAllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='dashboard.jsp'>Back to home</a>");
        out.println("<h1>List of Users</h1>");

        List<User> list= UserDao.getAllUsers();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>FullName</th><th>Username</th><th>Date Of Birth</th><th>Email</th><th>Country</th>");
        for(User user :list){
            out.print("<tr><td>"+ user.getFullName()+"</td><td>"+ user.getUserName()+"</td><td>"+ user.getDateOfBirth()+"</td><td>"+ user.getEmail()+
                    "</td><td>"+ user.getCountry()+"</td></tr>");
        }
        out.print("</table>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
