package connectionManager;

import java.sql.*;

public class connectivity
{
          Connection con = null;
          
          public Connection establishconnectivity() throws ClassNotFoundException, SQLException
          {
        	  //2
        	  Class.forName("com.mysql.cj.jdbc.Driver");
        	  //3
        	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryproject","root","Chennai@07");
        	  return con;
          }
          public void closeconnectivity()throws SQLException
          {
        	  con.close();
          }
		
}
