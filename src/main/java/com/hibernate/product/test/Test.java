
package com.hibernate.product.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.service.Service;
import org.omg.CosNaming.IstringHelper;

import com.hibernate.product.entity.Product;
import com.hibernate.product.service.ProductService;
import com.hibernate.product.utility.ProductUtility;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductService service = new ProductService();

		int choice;
		char ch;
		do {
			System.out.println("press 1 for save product.");                      //by session 
			System.out.println("press 2 for get product.");                       //by session 
			System.out.println("press 3 for delete product.");                     //by session 
			System.out.println("press 4 for update product.");                     //by session 
			System.out.println("press 5 for get all product.");                    //by criteria 
			System.out.println("press 6 to get  product in ascending order.");      //by criteria 
			System.out.println("press 7 to get  product in descending order.");        //by criteria 
			System.out.println("press 8 to get  product .... between id ....by  criteria ");         //by criteria --->between
			System.out.println("press 9 to get  product .....between id ... by restriction ");        //by restriction   --->between
			System.out.println("press 10 to get all  product...salary between... by restriction ");    // by restriction   --->between
			System.out.println("press 11 to get  all product  of general category...");     //by restriction we can apply for perticular name,price,id... ---> equal to
			System.out.println("press 12 to Get All products of productId less than 3");        //by restriction   --->less than
			System.out.println("press 13 to get all  product having productPrice greater than 500 ");    // by restriction     --->greater than
			System.out.println("press 14 to get  all product... product like..book"); //by restriction   we can apply for perticular name,price,id... --->  same as equal to method..
			System.out.println("press 15 to get  product..by. alleq method");  //by restriction  we get single product 
			System.out.println("press 16 to get  product..by. and method");    //by restriction    if id and price are same..single product
			System.out.println("press 17 to get  product..by. or method");//by restriction   id or name multiple product
			System.out.println("press 18 to get  product..by. in method");//by restriction    apply on perticular column/price/id
			System.out.println("press 19 to get  SUM of ProductPrice..by.Setprojection"); // by criteria
			System.out.println("press 20 to get  Average of ProductPrice..by.Setprojection");// by criteria
			System.out.println("press 21 to get Max of ProductPrice..by.Setprojection"); // by criteria
			System.out.println("press 22 to get  Min of ProductPrice..by.Setprojection"); // by criteria
			choice = scanner.nextInt();
			

			switch (choice) {
			case 1: {
				Product product = ProductUtility.prepareproductdata(scanner);
				String msg = service.saveProduct(product);
				System.out.println(msg);
				break;
			}

			case 2:{
				System.out.println("enter product id");
				int productId=scanner.nextInt();
				Product product=service.getproductbyId(productId);
				if (product!=null) {
					System.out.println(product);
				}else
				{
					System.out.println("product not found");
				}
				break;
			}
			case 3:{
				System.out.println("enter product id");
				int productId=scanner.nextInt();
				String msg= service.deleteproductbyId(productId);
				System.out.println(msg);
				break;
			}
			
			case 4:{
				Product product = ProductUtility.prepareproductdata(scanner);
				String msg= service.updateproduct(product);
				System.out.println(msg);
				break;
			}
			
			case 5:{
				System.out.println("All products are ");
				 List<Product> list=service.getallproduct();
				
				break;
			}
			
			case 6:{
				System.out.println("Get All products in ascending order of Product id ");
				 List<Product> list=service.getallproductAsc();
				 if (!list.isEmpty()) {
						for (Product product : list) {
							System.out.println(product);
						}
					}else {
						System.out.println("product not exists");
					}
				break;
			}
			
			case 7:{
				System.out.println("Get All products in descending order of Product id ");
				 List<Product> list=service.getallproductDesc();
				 if (!list.isEmpty()) {
						for (Product product : list) {
							System.out.println(product);
						}
					}else {
						System.out.println("product not exists");
					}
				break;
			}
			case 8:{
				System.out.println("Get All products of id btweeen  .. ");
				 List<Product> list=service.getallproductbetween();
				 if (!list.isEmpty()) {
						for (Product product : list) {
							System.out.println(product);
						}
					}else {
						System.out.println("product not exists");
					}
				break;
			}
			
			case 9:{
				System.out.println("Get All products of id  between .. ");
				 List<Product> list=service.getallproductbetween2();
				 if (!list.isEmpty()) {
						for (Product product : list) {
							System.out.println(product);
						}
					}else {
						System.out.println("product not exists");
					}
				break;
			}
			case 10:{
				System.out.println("Get All products of productsalary  btweeen . ");
				 List<Product> list=service.getallproductsalbetween();
				 if (!list.isEmpty()) {
						for (Product product : list) {
							System.out.println(product);
						}
					}else {
						System.out.println("product not exists");
					}
				break;
			}
			case 11:{
				System.out.println("Get All products of perticular Category ");
				 List<Product> list=service.getallgeneralproduct();
				 if (!list.isEmpty()) {
						for (Product product : list) {
							System.out.println(product);
						}
					}else {
						System.out.println("product not exists ");
					}
				break;
			}
			
			case 12:{
				System.out.println("Get All products of productId less than 3");
				 List<Product> list=service.getallproductidlessthan();
				 if (!list.isEmpty()) {
						for (Product product : list) {
							System.out.println(product);
						}
					}else {
						System.out.println("product not exists ");
					}
				break;
			}
			case 13:{
				System.out.println("Get all product having productPrice greater than 500 ");
				 List<Product> list=service.getallproductpricegreaterthan();
				 if (!list.isEmpty()) {
						for (Product product : list) {
							System.out.println(product);
						}
					}else {
						System.out.println("product not exists ");
					}
				break;
			}
			
			case 14:{
				System.out.println("Get all product like  book ");
				List<Product>list= service.getallproductlikebook();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}else {
					System.out.println("product not exist");
				}
				
				break;
			}
			case 15:{
				
				System.out.println("Get  products of productId/productName/productPrice is equal to  ");
				List<Product>list=service.getproductbyalleq();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}else {
					System.out.println("product not exists");
				}
				
				
				break;
			}
			
            case 16:{
				
				System.out.println("Get  products of productId/productName/productPrice is equal to  ");
				List<Product>list=service.getproductbyand();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);                //productid and productName
					}											 //perform like AND
				}else {											//product having id and name 
					System.out.println("product not exists");
				}
				
				
				break;
					}
            case 17:{
				
				System.out.println("Get  products of productId/productName/productPrice is   ");
				List<Product>list=service.getproductbyor();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);                //productid and productName
					}											 //perform like OR
				}else {											//product having id and name 
					System.out.println("product not exists");
				}
				
				
				break;
			}
            
case 18:{
				
				System.out.println("Get  products of productId/productName/productPrice is   ");
				List<Product>list=service.getproductbyin();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);                //productid and productName
					}											 //perform like OR
				}else {											//product having id and name 
					System.out.println("product not exists");
				}
				
				
				break;
			}
case 19:{
	
	System.out.println("Get SUM of ProductPrice   ");
	double sum =service.getSumofprice();
	System.out.println(sum);
	
	
	break;
}
case 20:{
	
	System.out.println("Get Average of ProductPrice   ");
	double avg =service.getAvgofprice();
	System.out.println(avg);
	break;
}

case 21:{
	
	System.out.println("Get Max  ProductPrice   ");
	double max =service.getmaxofprice();
	System.out.println(max);
	break;
}
case 22:{
	
	System.out.println("Get Max  ProductPrice   ");
	double min =service.getminofprice();
	System.out.println(min);
	break;
}
			default:
				System.out.println("invalid");
				break;
			}
			
			
			System.out.println(" you want to continue operaton press y/n");
			ch = scanner.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}

}
