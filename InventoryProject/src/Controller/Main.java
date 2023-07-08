package Controller;

import java.sql.SQLException;

import java.util.Scanner;



import Model.Login;

import Model.Product;

import DAO.LoginDAO;

import DAO.ProductDAO;



public class Main {



	public static void main(String[] args) throws ClassNotFoundException, SQLException 

	{

       Scanner sc = new Scanner(System.in);  

       int choice,option;

       Login login =new Login();

       Product product=new Product();

       LoginDAO ld=new LoginDAO();

       ProductDAO productdao= new ProductDAO();

       

       do

       {

    	   System.out.println("1.Admin");

    	   System.out.println("2.Agent");

    	   System.out.println("3.Exit");

    	   System.out.println("************");

    	   System.out.println("Enter your choice: ");

    	   choice =sc.nextInt();    	   

    	   switch(choice)

    	   {

    	   case 1:

    		   sc.nextLine();

    		   System.out.println("Admin Login");

    		   System.out.println("Enter your Username");

    		   String username=sc.nextLine();

    		   System.out.println("Enter your Password");

    		   String password=sc.nextLine();

    		   login.setUsername(username);

    		   login.setPassword(password);

    		   if(ld.validate(login))

    		   {

    			   System.out.println("LOGIN sUCCESSFULLY");

    			   do

    			   {

    				   System.out.println("************");

    		    	   System.out.println("1.Add Product");

    		    	   System.out.println("2.Display Product");

    		    	   System.out.println("3.Logout");

    		    	   System.out.println("************");

    		    	   System.out.println("Enter your Option");

    		    	   option =sc.nextInt();

    		    	   switch(option) 

    		    	   {

    		    	   case 1: 

    		    		   System.out.println("Add Product");

    		    		   System.out.println("Enter theproduct Id");

    		    		   int productid=sc.nextInt();

    		    		   sc.nextLine();

    		    		   System.out.println("Enter the product Name");

    		    		   String productname=sc.nextLine();

    		    		   System.out.println("Enter the minimum sell Quantity");

    		    		   int minsellquantity=sc.nextInt();

    		    		   System.out.println("Enter the price");

    		    		   int price=sc.nextInt();

    		    		   System.out.println("Enter the quantity");

    		    		   int quantity =sc.nextInt();

    		    		   	product.setProductName(productname);

    		    		   	product.setProductId(productid);

    		    		   	product.setMinSellQuantity(minsellquantity);

    		    		   	product.setPrice(price);

    		    		   	product.setQuantity(quantity);

    		    		   	productdao.addProduct(product);

    		    		   break;

    		    	   case 2:

    		    		   System.out.println("Display Product");

    		    		   productdao.display();

    		    	   case 3:

    		    		   System.out.println("Logout");

    		    	   }

    			   }while(option!=3);

    		   }

    		   else

    		   {

    			   System.out.println("LOGIN FAILURE");

    		   }

    		   

    		   break;

    	   case 2:

    		   System.out.println("Agent Login");

    		   sc.nextLine();

    		   System.out.println("Admin Login");

    		   System.out.println("Enter your Username");

    		   String username1=sc.nextLine();

    		   System.out.println("Enter your Password");

    		   String password1=sc.nextLine();

    		   login.setUsername(username1);

    		   login.setPassword(password1);

    		   if(ld.validate(login))

    		   {

    			   System.out.println("LOGIN sUCCESSFULLY");

    			   do

    			   {

    				   System.out.println("************");

    		    	   System.out.println("1.Display Product");

    		    	   System.out.println("2.Logout");

    		    	   System.out.println("************");

    		    	   System.out.println("Enter your Option");

    		    	   option =sc.nextInt();

    		    	   switch(option) 

    		    	   {

    		    	   case 1: 

    		    		   System.out.println("Display Product");

    		    		   productdao.display();

    		    		   break;

    		    	   case 2:

    		    		   System.out.println("Logout");

    		    		   break;

    		    	   }

    			   }while(option!=2);

    		   }

    		   else

    		   {

    			   System.out.println("LOGIN FAILURE");

    		   }

    		   break;

    	   case 3:

    		   System.out.println("Exit");

    		   break;

    	   }

       }while(choice!=3);

       sc.close();

	}



}