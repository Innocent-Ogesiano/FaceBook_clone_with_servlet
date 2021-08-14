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
import java.sql.Date;

@WebServlet(name = "RegisterNewUser", value = "/RegisterNewUser")
public class RegisterNewUser extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String name=request.getParameter("fullname");
        String username=request.getParameter("username");
        String dateOfBirth=request.getParameter("dateofbirth");
        Date dob= Date.valueOf(dateOfBirth);
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        String password=request.getParameter("password");

        User user=new User();
        user.setFullName(name);
        user.setUserName(username);
        user.setDateOfBirth(dob);
        user.setEmail(email);
        user.setCountry(country);
        user.setPassword(password);

        int status= UserDao.userRegistration(user);
        if(status>0){
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }else{
            out.println("Sorry! unable to Register record");
        }
        out.close();
    }
}
