package dao;

import dbConnect.DatabaseConnect;
import models.LikeUnlike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LikeUnlikeDao {

    public static int likePost(int postId, int userId){
        int status=0;
        try{
            Connection databaseconnection = DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement(
                    "insert into LikeUnlikeTable (post_Id,user_Id) values (?,?)");
            ps.setInt(1, postId);
            ps.setInt(2, userId);

            status=ps.executeUpdate();

            databaseconnection.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

    public static int unlikePost(int id){
        int status=0;
        try{
            Connection databaseconnection =DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement("delete from LikeUnlikeTable where like_Id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();

            databaseconnection.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static LikeUnlike checkLike(LikeUnlike lk){
        LikeUnlike likeUnlike = new LikeUnlike();

        try{
            Connection databaseconnection = DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement("select * from LikeUnlikeTable where post_Id=? and user_Id=?");
            ps.setInt(1, lk.getPost_Id());
            ps.setInt(2, lk.getUser_Id());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                likeUnlike.setLike_Id(rs.getInt("like_Id"));
                likeUnlike.setPost_Id(rs.getInt("post_Id"));
                likeUnlike.setUser_Id(rs.getInt("user_Id"));
            }
            databaseconnection.close();
        }catch(Exception ex){ex.printStackTrace();}

        return likeUnlike;
    }

    public static int getAllPostLikes(int postId){
        List<LikeUnlike> listOfLikes=new ArrayList<>();

        try{
            Connection databaseconnection =DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement("select * from LikeUnlikeTable where post_Id=?");
            ps.setInt(1, postId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                LikeUnlike likeUnlike = new LikeUnlike();
                likeUnlike.setLike_Id(rs.getInt("like_Id"));
                likeUnlike.setPost_Id(rs.getInt("post_Id"));
                likeUnlike.setUser_Id(rs.getInt("user_Id"));
                listOfLikes.add(likeUnlike);
            }
            databaseconnection.close();
        }catch(Exception e){e.printStackTrace();}

        return listOfLikes.size();
    }
}
