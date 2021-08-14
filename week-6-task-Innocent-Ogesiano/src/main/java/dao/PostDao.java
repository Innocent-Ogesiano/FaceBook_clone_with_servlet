package dao;

import dbConnect.DatabaseConnect;
import models.Post;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    public static int newPost(Post post, User user){
        int status=0;
        try{
            Connection databaseconnection = DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement(
                    "insert into UserPostTable (post_body,user_Id) values (?,?)");
            ps.setString(1, post.getPost());
            ps.setInt(2, user.getUserId());

            status=ps.executeUpdate();

            databaseconnection.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

    public static int editPost(Post post){
        int status=0;
        try{
            Connection databaseconnection =DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement(
                    "update UserPostTable set post_body=? where post_Id=?");
            ps.setString(1, post.getPost());
            ps.setInt(2, post.getPostId());


            status=ps.executeUpdate();

            databaseconnection.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

    public static int deletePost(int id){
        int status=0;
        try{
            Connection databaseconnection =DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement("delete from UserPostTable where post_Id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();

            databaseconnection.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static Post getPostById(int id){
        Post post =new Post();

        try{
            Connection databaseconnection =DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement("select * from UserPostTable where post_Id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                post.setPostId(rs.getInt(1));
                post.setPost(rs.getString(2));
            }
            databaseconnection.close();
        }catch(Exception ex){ex.printStackTrace();}

        return post;
    }

    public static List<Post> getAllUsersPosts(int userId){
        List<Post> list=new ArrayList<>();

        try{
            Connection databaseconnection =DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement("select * from UserPostTable where user_Id=?");
            ps.setInt(1, userId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Post post = new Post();
                post.setPostId(rs.getInt(1));
                post.setPost(rs.getString(2));
                list.add(post);
            }
            databaseconnection.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }

    public static List<Post> fetchAllPosts()
    {
        List<Post> posts = new ArrayList<>();
        try(Connection connection = DatabaseConnect.connectionToDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT UserPostTable.*, UserInfo.FullName FROM UserPostTable INNER JOIN UserInfo ON UserPostTable.user_Id=UserInfo.Id ORDER BY UserPostTable.post_Id DESC");
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Post post = new Post();
                User user = new User();
                int id = resultSet.getInt("post_Id");
                int userId = resultSet.getInt("user_Id");
                String body = resultSet.getString("post_body");
                String fullname = resultSet.getString("FullName");
                int noOfLikes = LikeUnlikeDao.getAllPostLikes(id);

                user.setUserId(userId);
                user.setFullName(fullname);

                post.setPostId(id);
                post.setUser(user);
                post.setPost(body);
                post.setLikes(noOfLikes);
                posts.add(post);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return posts;
    }
}
