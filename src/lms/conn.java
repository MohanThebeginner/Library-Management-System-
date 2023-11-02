package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement l;
    conn(){
        String username = "root";
        String password = "PHW#84#jeor";
        String url = "jdbc:mysql://localhost:3306/libmansys";
        try{
            c = DriverManager.getConnection(url, username,password);
            l = c.createStatement();
            System.out.println("connetion successful!!");

        }catch (Exception e){
            System.out.println("Connection failed");
        }
    }

}
