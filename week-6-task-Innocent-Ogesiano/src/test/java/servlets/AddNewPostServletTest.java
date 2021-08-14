package servlets;

import dao.PostDao;
import dao.UserDao;
import models.Post;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

class AddNewPostServletTest {
    HttpServletRequest request;
    HttpServletResponse response;
    UserDao userDao;


    @BeforeEach
    void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        userDao = new UserDao();
    }

    @Test
    void doPost() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setEmail("ogesiano4peace@gmail.com");
        user.setPassword("12345");
        User user1 = this.userDao.checkLogin(user);
        Mockito.when(request.getParameter("body")).thenReturn("I have done my test");
        Post post = new Post();
        post.setPost("I have done my test");
        int status = PostDao.newPost(post, user1);

        Assertions.assertEquals(1, status);
    }
}