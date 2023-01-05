package com.hibernate.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.product.configuration.Configurationhibernate;
import com.hibernate.product.entity.Product;

public class ProductDao {

	private SessionFactory sessionFactory;

	public ProductDao() {
		sessionFactory = Configurationhibernate.getsessionFactory();
	}

	public String saveProduct(Product product) {
		Session session = null;
		boolean isadded = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product dbproduct = session.get(Product.class, product.getProductId());
			if (dbproduct == null) {
				session.save(product);

				isadded = true;
				transaction.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		if (isadded) {
			return "Product Save..!!";
		} else {
			return "product Already Exist..!!";
		}
	}

	public Product getproductbyId(int productId) {

		Session session = null;
		Product product = null;

		try {

			session = sessionFactory.openSession();
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return product;
	}

	public String deleteproductbyId(int productId) {
		Session session = null;
		Product product = null;
		String msg = null;
		try {

			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			product = session.get(Product.class, productId);
			if (product != null) {
				session.delete(product);
				transaction.commit();
				msg = "deleted";
			} else {
				msg = "product not Exist with productid" + productId;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

		}

	
	
	
	

	public String updateProduct(Product product) {
		Session session = null;
		String msg = null;

		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product updatedProduct = session.get(Product.class, product.getProductId());
			if (updatedProduct != null) {
				updatedProduct.setProductId(product.getProductId());
				updatedProduct.setProductName(product.getProductName());
				updatedProduct.setProcuctPrice(product.getProcuctPrice());
				updatedProduct.setProdcutMgf(product.getProdcutMgf()); 
				
				updatedProduct.setProductCategory(product.getProdcutCategory());
				session.update(updatedProduct);
				transaction.commit();
				msg = "product upadated  :  " + product.toString();
			} else
				msg = "product not Exist with productid " + product.getProductId();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();

		}
		return msg;
	}

	@SuppressWarnings("unused")
	public List<Product> getallproduct() {
		Session session = null;
//		Product product=null;
		Criteria criteria = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			criteria = session.createCriteria(Product.class);
			if (list == null) {
				list = criteria.list();
				for (Product product2 : list) {
					System.out.println(product2);
				}
			} else {
				System.out.println("no product  in the list");

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();

			}

		}
		return list;
	}

	public List<Product> getallproductAsc() {
		Session session = null;
		List<Product> list = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productId"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public List<Product> getallproductDesc() {
		Session session = null;
		List<Product> list = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.desc("productId")); // we can use any property like productPrice,productid
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}

		}
		return list;

	}

	public List<Product> getallproductbetween() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setFirstResult(6);
			criteria.setMaxResults(8);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public List<Product> getallproductbetween2() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.between("productId", 1, 4));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public List<Product> getallgeneralproduct() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productCategory", "general"));
			// criteria.add(Restrictions.eq("productName", "mobile"));
			// criteria.add(Restrictions.eq("productId", 5));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public List<Product> getallproductsalbetween() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.between("productPrice", 100d, 200d)); // PRODUCT---product price between 100 to
																			// 200
			// criteria.add(Restrictions.between("productId", 1, 5)); // product --product
			// id between 1 to 5
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return list;

	}

	public List<Product> getallproductidlessthan() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.lt("productId", 3)); // product--PRODUCT ID LESS THAN 3;
			criteria.add(Restrictions.lt("productPrice", 500)); // PRODUCT--PRODUCT PRICE LESS THAN 500;
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public List<Product> getallproductpricegreaterthan() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productPrice", 500d)); // double// for product Price
			// criteria.add(Restrictions.gt("productId", 2)); // for product id
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public List<Product> getallproductlikebook() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", "book"));
			// criteria.add(Restrictions.like("productName", "%n%"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public List<Product> getproductbyalleq() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productName", "book"); // in this method we get single product
			// map.put("productName","pen"); // 2 properties error.
			// map.put("productPrice", 123d);
			criteria.add(Restrictions.allEq(map));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return list;
	}

	public List<Product> getproductbyand() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			Criterion id = Restrictions.eq("productId", 1); // both must be true
			Criterion name = Restrictions.eq("productName", "pen");
			criteria.add(Restrictions.and(id, name));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public List<Product> getproductbyor() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			Criterion id = Restrictions.eq("productId", 1);
			Criterion name = Restrictions.eq("productName", "book");
			criteria.add(Restrictions.or(id, name));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public List<Product> getproductbyin() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.in("productId", 1, 3, 5)); // product having id 1,3,5
			// criteria.add(Restrictions.in("productPrice", 123d,120d,340d)); //product
			// having price 123,120,340..
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public double getSumofprice() {
		Session session = null;
		double sum = 0;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.sum("productPrice"));
			List<Double> list = criteria.list();
			sum = list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return sum;
	}

	public double getAvgofprice() {
		Session session = null;
		double avg = 0;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.avg("productPrice"));
			List<Double> list = criteria.list();
			avg = list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return avg;
	}

	public double getmaxofprice() {
		Session session = null;
		double max = 0;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.max("productPrice"));
			List<Double> list = criteria.list();
			max = list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return max;
	}

	public double getminofprice() {
		Session session = null;
		double min = 0;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.min("productPrice"));
			List<Double> list = criteria.list();
			min = list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return min;
	}

}
