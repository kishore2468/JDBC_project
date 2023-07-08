package javamodel;
import model.product;
import java.sql.*;
import connectionManager.connectivity;

public class productdao {
	public void addproduct(product product) throws ClassNotFoundException, SQLException
	{
		//1.JAVA and JDBC connect
		connectivity comn=new connectivity();
		Connection con =comn.establishconnectivity();
		
		String  sql_query="insert into product(productId,productName,min,price,quantity) values(?,?,?,?,?)";
		PreparedStatement ps =con.prepareStatement(sql_query);
		ps.setInt(1,product.getProductId());
		ps.setString(2, product.getProductName());
		ps.setInt(3, product.getMin());
		ps.setInt(4, product.getPrice());
		ps.setInt(5, product.getQuantity());
		ps.executeUpdate();
		comn.closeconnectivity();
	}
	public void display() throws SQLException,ClassNotFoundException
	{
		connectivity comn=new connectivity();
		Connection con =comn.establishconnectivity();
		 //statement class
		   Statement st=con.createStatement();
		   // ResultSet class
		   ResultSet rs=st.executeQuery("select * from product");
		   while(rs.next())
		   {
		   System.out.println(rs.getInt("productId")+" "+rs.getString("productName")+" "+rs.getInt("min")+" "+rs.getInt("price")+" "+rs.getInt("quantity"));
		   }
		   comn.closeconnectivity();
	}

}
