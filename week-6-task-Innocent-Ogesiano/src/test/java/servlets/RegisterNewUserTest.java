package servlets;

import dao.UserDao;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

class RegisterNewUserTest {
    HttpServletResponse response;
    HttpServletRequest request;

    @BeforeEach
    void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
    }

    @Test
    void doPost() {
        Mockito.when(request.getParameter("fullname")).thenReturn("Stephen A");
        Mockito.when(request.getParameter("username")).thenReturn("Steve");
        Mockito.when(request.getParameter("dateofbirth")).thenReturn("2000-10-30");
        Mockito.when(request.getParameter("email")).thenReturn("steveA@gmail.com");
        Mockito.when(request.getParameter("country")).thenReturn("Nigeria");
        Mockito.when(request.getParameter("password")).thenReturn("12345");
        User user = new User();
        user.setFullName("Stephen A");
        user.setUserName("Steve");
        user.setDateOfBirth(Date.valueOf("2000-10-30"));
        user.setEmail("steveA@gmail.com");
        user.setCountry("Nigeria");
        user.setPassword("12345");

        int status = UserDao.userRegistration(user);

        Assertions.assertEquals(1, status);
    }
}