package servlets;

import dao.UserDao;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

class LoginServletTest {
    HttpServletRequest request;
    HttpServletResponse response;
    UserDao userDao;
    @BeforeEach
    void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
       response =  Mockito.mock(HttpServletResponse.class);
       userDao = new UserDao();
    }

    @Test
    void doPost() throws SQLException, ClassNotFoundException {
        Mockito.when(request.getParameter("email")).thenReturn("ogesiano4peace@gmail.com");
        Mockito.when(request.getParameter("password")).thenReturn("12345");
        User user = new User();
        user.setEmail("ogesiano4peace@gmail.com");
        user.setPassword("12345");
        User user1 = this.userDao.checkLogin(user);

        Assertions.assertEquals(user1.getEmail(), user.getEmail());
        Assertions.assertEquals(user1.getPassword(), user.getPassword());
    }
}