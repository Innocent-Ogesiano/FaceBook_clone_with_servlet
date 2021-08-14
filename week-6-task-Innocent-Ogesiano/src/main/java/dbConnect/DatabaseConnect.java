package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {
    public static Connection connectionToDatabase(){
        Connection databaseconnection =null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserProfileInfoDb","root","Peace0247");
        }catch(Exception e){System.out.println(e);}
        return databaseconnection;
    }
}
