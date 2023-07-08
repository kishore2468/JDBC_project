package javamodel;
import model.login;
import java.sql.*;
import connectionManager.connectivity;
public class logindao 
{
   public boolean validate(login l) throws ClassNotFoundException, SQLException
   {
	   String username = l.getUsername();
	   String password =l.getPassword();
	   
	   connectivity conm=new connectivity();
	   Connection con =conm.establishconnectivity();
	   //statement class
	   Statement st=con.createStatement();
	   // ResultSet class
	   ResultSet rt=st.executeQuery("select * from login");
	   while(rt.next())
	   {
	   if(username.equals(rt.getString("username"))&& password.equals(rt.getString("password")))
			   {
		   	conm.closeconnectivity();
		           return true;
			   }
	   }
	   conm.closeconnectivity();
	   return false;
   }
}
