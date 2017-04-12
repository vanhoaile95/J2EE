
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectSQL {
    
 Connection conn = null;
 public Connection getConnectDB()
 {
     try{
         String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=J2EE";
         String user="sa";
         String pass="sa";
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         conn = DriverManager.getConnection(url,user,pass);
         
     }catch(ClassNotFoundException | SQLException e){}
     return conn;
  
 }
}
