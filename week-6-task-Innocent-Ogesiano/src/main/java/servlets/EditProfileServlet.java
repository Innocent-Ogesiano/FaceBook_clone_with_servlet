package servlets;

import dao.UserDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "EditProfileServlet", value = "/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printer =response.getWriter();
        printer.println("<h1>Update User Info</h1>");
        int id = 0;
        HttpSession session = request.getSession();
        if (session != null) {
            User user = (User) session.getAttribute("user");
            id = user.getUserId();
        } else {
            String sid = request.getParameter("id");
            id = Integer.parseInt(sid);
        }

        User user = UserDao.getUserById(id);

        printer.print("<form method='post'>");
        printer.print("<table>");
        printer.print("<tr><td></td><td><input type='hidden' name='id' value='"+ user.getUserId()+"'/></td></tr>");
        printer.print("<tr><td>FullName:</td><td><input type='text' name='fullname' value='"+ user.getFullName()+"'/></td></tr>");
        printer.print("<tr><td>Username:</td><td><input type='text' name='username' value='"+ user.getUserName()+"'/></td></tr>");
        printer.print("<tr><td>Date Of Birth:</td><td><input type='date' name='dateOfBirth' value='"+ user.getDateOfBirth()+"'/> </td></tr>");
        printer.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+ user.getEmail()+"'/></td></tr>");
        printer.print("<tr><td>Country:</td><td><input type='text' name='country' value='"+ user.getCountry()+"'/></td></tr>");
        printer.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+ user.getPassword()+"'/> </td></tr>");
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
        String name=request.getParameter("fullname");
        String username=request.getParameter("username");
        String dateOfBirth =request.getParameter("dateOfBirth");
        Date dob = Date.valueOf(dateOfBirth);
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        String password=request.getParameter("password");

        User user =new User();
        user.setUserId(id);
        user.setFullName(name);
        user.setUserName(username);
        user.setDateOfBirth(dob);
        user.setEmail(email);
        user.setCountry(country);
        user.setPassword(password);

        int status= UserDao.updateUserInfo(user);
        if(status>0){
            HttpSession session = request.getSession();
            if (session != null) {
                out.println("Profile updated successfully");
                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("ViewUsersServlet");
            }
        }else{
            out.println("Sorry! unable to updateUserInfo record");
        }

        out.close();
    }
}
