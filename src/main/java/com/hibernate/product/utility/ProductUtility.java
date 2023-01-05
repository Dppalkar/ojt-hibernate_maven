package com.hibernate.product.utility;

import java.util.Scanner;

import com.hibernate.product.entity.Product;

public class ProductUtility {

	Product product = new Product();

	public static Product prepareproductdata(Scanner scanner) {
		System.out.println("enter product id");
		int productId = scanner.nextInt();

		System.out.println("enter product name");
		String productName = scanner.next();
		

		System.out.println("enter product price");
		double productPrice = scanner.nextDouble();

		System.out.println("enter product MFG");
		String productMfg = scanner.next();
		
		
		System.out.println("enter product Category");
		String productategory = scanner.next();

		Product product = new Product(productId, productName, productPrice, productMfg, productategory);


		return product;
	}

}
