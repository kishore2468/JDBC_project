package controller;
import java.sql.SQLException;

import java.util.Scanner;
import javamodel.logindao;
import javamodel.productdao;
import model.login;
import model.product;

public class main {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int choice,option;
		login l=new login();
		product p=new product();
		logindao loginDAO=new logindao();
		productdao ProductDAO =new productdao();
		do
		{
			System.out.println("1.Admin");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			System.out.println("*************************");
			System.out.println("Enter yout choice");
			choice =sc.nextInt();
			switch(choice)
			{
			case 1: System.out.println("Admin Login");
			sc.nextLine();
			System.out.println("Enter your username");
			String username=sc.nextLine();
			System.out.println("Enter your password");
			String password=sc.nextLine();
			l.setUsername(username);
			l.setPassword(password);
			if(loginDAO.validate(l)){
				System.out.println("Login Sucessfully");
						do
						{
							System.out.println("***************");
							System.out.println("1. Add Product");
							System.out.println("2.Display Product");

							System.out.println("3.Logout");

							System.out.println("**************************");
							System.out.println("Enter your option");
							option =sc.nextInt();
							switch(option)
							{
							case 1:System.out.println("Add Product");
							System.out.println("Enter the ProductId");
							int productId =sc.nextInt();
							sc.nextLine();
							System.out.println("Enter the ProductName");
							String productName=sc.nextLine();
							System.out.println("Enter the min");
							int min=sc.nextInt();
							System.out.println("Enter the price");
							int price=sc.nextInt();
							System.out.println("Enter the Quantity");
							int quantity=sc.nextInt();
							p.setProductId (productId);
							p.setProductName(productName);
							p.setMin(min);
							p.setPrice(price);
							p.setQuantity(quantity);
							ProductDAO.addproduct(p);
							break;
							case 2:System.out.println("Display Product");
							ProductDAO.display();
							break;
							case 3:System.out.println("Logout");
							break;
							}

						}while(option!=3);
					}
			          else
			{
			System.out.println("Login Failure");
			
			}
					break;
			case 2: System.out.println("Agent Login");
			sc.nextLine();
			System.out.println("Enter your username");
			String username1=sc.nextLine();
			System.out.println("Enter your password");
			String password1=sc.nextLine();
			if(username1.equals("Admin")&&password1.equals("Admin@123"))
					{
				System.out.println("Login Sucessfully");
						do
						{
							System.out.println("***************");
							//System.out.println("1. Add Product");
							System.out.println("1.Display Product");

							System.out.println("2.Logout");

							System.out.println("**************************");
							System.out.println("Enter your option");
							option =sc.nextInt();
							switch(option)
							{
							
							case 1:System.out.println("Display Product");
							ProductDAO.display();
							break;
							case 2:System.out.println("Logout");
							break;
							}

						}while(option!=2);
					}
			else
			{
			System.out.println("Login Failure");
			
			}
			break;
			case 3: System.out.println("Exit");break;
			
			}
		}while(choice!=3);

	}

}
