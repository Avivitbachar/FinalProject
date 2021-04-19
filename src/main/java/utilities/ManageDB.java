package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps{
    public static void openConnection(String dbURL,String user,String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL,user,pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, see Details" + e);
        }
    }
 public static void closeConnection(){
     try {
         con.close();
     } catch (Exception e) {
         System.out.println("Error Occurred while closing DB, see Details" + e);
     }
 }
}
