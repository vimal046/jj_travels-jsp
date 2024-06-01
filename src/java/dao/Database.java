
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author VIMAL SUKU
 */
public class Database {
     private String dbName = "jj_travels";
    private String uName = "vimal";
    private String pwd = "vimal";
    Connection con = null;

    public Connection getConnection() {

        String url = "jdbc:sqlserver://localhost:1433;database=" + dbName + ";trustServerCertificate=true;";

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            con=DriverManager.getConnection(url,uName,pwd);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return con;

    }
    
    public static void main(String[] args) {
        Connection con=new Database().getConnection();
        
        if(con!=null){
            System.out.println("Connection established");
        }else{
            System.out.println("Failed to connect");
        }
        System.out.println(new Database().getConnection());
    }
}
