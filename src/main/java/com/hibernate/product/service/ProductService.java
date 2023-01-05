package com.hibernate.product.service;

import com.hibernate.product.dao.ProductDao;
import  java.util.List;
import com.hibernate.product.entity.Product;



public class ProductService {

	private ProductDao dao = new ProductDao();

	public String saveProduct(Product product) {
			return dao.saveProduct(product);
		
	}
	
	
	
	public Product getproductbyId(int productId) {
		return dao.getproductbyId( productId);
		
		
	}
	
	
	public String deleteproductbyId(int productId) {
		
		return dao.deleteproductbyId( productId);
	}

	
	
	public String updateproduct(Product product) {
		return dao.updateProduct(product);
	}



	public List<Product> getallproduct() {
		return dao.getallproduct();
		
	}


	public List<Product> getallproductAsc() {
				return dao.getallproductAsc();
	}



	public List<Product> getallproductDesc() {
		return dao.getallproductDesc();
	}



	public List<Product> getallproductbetween() {
		
		return dao.getallproductbetween();
	}



	public List<Product> getallproductbetween2() {
		return dao.getallproductbetween2();
	}



	public List<Product> getallgeneralproduct() {
		
		return dao.getallgeneralproduct();
	}



	public List<Product> getallproductsalbetween() {
		
		return dao.getallproductsalbetween() ;
	}



	public List<Product> getallproductidlessthan() {
		
		return dao.getallproductidlessthan();
	}



	public List<Product> getallproductpricegreaterthan() {
		
		return dao.getallproductpricegreaterthan() ;
	}



	public List<Product> getallproductlikebook() {
		
		return dao.getallproductlikebook();
	}



	 public List<Product> getproductbyalleq() {
		
		return dao.getproductbyalleq();
	}



	public List<Product> getproductbyand() {
		
		return dao.getproductbyand();
	}



	public List<Product> getproductbyor() {
		
		return dao.getproductbyor();
	}



	public List<Product> getproductbyin() {
	
		return dao. getproductbyin();
	}



	public double getSumofprice() {
		
		return dao.getSumofprice();
	}



	public double getAvgofprice() {
		
		return dao.getAvgofprice();
	}



	public double getmaxofprice() {
		
		return dao.getmaxofprice();
	}



	public double getminofprice() {
		
		return dao. getminofprice();
	}



	
	
	
}
