package bankingmanagementsystem;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
           // Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///BANKMANAGEMENTSYSTEM","root","root");
            s=c.createStatement();


        } catch (Exception e){
//            System.out.println(e);
            e.printStackTrace();
        }
    }
}
