package dao;

import dbConnect.DatabaseConnect;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static int userRegistration(User user){
        int status=0;
        try{
            Connection databaseconnection = DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement(
                    "insert into UserInfo(fullname,username,dateOfBirth,email,country,password) values (?,?,?,?,?,?)");
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getUserName());
            ps.setDate(3,  user.getDateOfBirth());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getCountry());
            ps.setString(6, user.getPassword());

            status=ps.executeUpdate();

            databaseconnection.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int updateUserInfo(User user){
        int status=0;
        try{
            Connection databaseconnection =DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement(
                    "update UserInfo set fullname=?,username=?,dateOfBirth=?,email=?,country=?,password=? where id=?");
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getUserName());
            ps.setDate(3, user.getDateOfBirth());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getCountry());
            ps.setString(6, user.getPassword());
            ps.setInt(7, user.getUserId());

            status=ps.executeUpdate();

            databaseconnection.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int deleteUserInfo(int id){
        int status=0;
        try{
            Connection databaseconnection =DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement("delete from UserInfo where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();

            databaseconnection.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }
    public static User getUserById(int id){
        User user =new User();

        try{
            Connection databaseconnection =DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement("select * from UserInfo where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user.setUserId(rs.getInt(1));
                user.setFullName(rs.getString(2));
                user.setUserName(rs.getString(3));
                user.setDateOfBirth(rs.getDate(4));
                user.setEmail(rs.getString(5));
                user.setCountry(rs.getString(6));
                user.setPassword(rs.getString(7));
            }
            databaseconnection.close();
        }catch(Exception ex){ex.printStackTrace();}

        return user;
    }

    public static List<User> getAllUsers(){
        List<User> list=new ArrayList<>();

        try{
            Connection databaseconnection =DatabaseConnect.connectionToDatabase();
            PreparedStatement ps= databaseconnection.prepareStatement("select * from UserInfo");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User user =new User();
                user.setUserId(rs.getInt(1));
                user.setFullName(rs.getString(2));
                user.setUserName(rs.getString(3));
                user.setDateOfBirth(rs.getDate(4));
                user.setEmail(rs.getString(5));
                user.setCountry(rs.getString(6));
                user.setPassword(rs.getString(7));
                list.add(user);
            }
            databaseconnection.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }

    public User checkLogin(User user) throws SQLException,
            ClassNotFoundException {
        User user1 = null;
        ResultSet result;
        boolean status;
        try {
            Connection databaseConnection = DatabaseConnect.connectionToDatabase();
            String sql = "SELECT * FROM UserInfo WHERE Email = ? and Password = ?";
            PreparedStatement statement = databaseConnection.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());

            result = statement.executeQuery();
//            System.out.println(result.getFetchSize());
//            status = result;

            if (result.next()) {
                user1 = new User();
                user1.setFullName(result.getString("FullName"));
                user1.setUserName(result.getString("Username"));
                user1.setUserId(result.getInt("Id"));
                user1.setCountry(result.getString("Country"));
                user1.setEmail(result.getString("Email"));
                user1.setPassword(result.getString("Password"));
//                System.out.println(user1);
            } else {
                System.out.println("No next user");
            }

            databaseConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user1;
    }
}
