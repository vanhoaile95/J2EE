
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectSQL {
    
 Connection conn = null;
 public Connection getConnectDB()
 {
     try{
         String url="jdbc:sqlserver://localhost:1433;databaseName=QLBanHang";
         String user="sa";
         String pass="sa";
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         conn = DriverManager.getConnection(url,user,pass);
         
     }catch(ClassNotFoundException | SQLException e){}
     return conn;
  
 }
}
