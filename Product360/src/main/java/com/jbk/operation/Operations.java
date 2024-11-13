package com.jbk.operation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jbk.config.SessionFactoryUtility;
import com.jbk.entity.Product;

public class Operations {

	SessionFactory sessionFactory = SessionFactoryUtility.getSessionFactory();

	// Add Product to Database
	public String addProduct(Product product) {

		try {
			Session session = sessionFactory.openSession();

			Product dbProduct = session.get(Product.class, product.getProductId());

			if (dbProduct == null) {
				session.save(product);
				session.beginTransaction().commit();
				return "Added Successfully";
			} else {
				return "Product Already Exists";
			}

		} catch (Exception e) {
			return "Something went wrong";
		}
	}

	// Delete Product from Database
	public String deleteProduct(int productId) {
		try {
			Session session = sessionFactory.openSession();
			Product dbProduct = session.get(Product.class, productId);

			if (dbProduct != null) {
				session.delete(dbProduct);
				session.beginTransaction().commit();
				return "Deleted Successfully";
			} else {
				return "Product not exists";
			}

		} catch (Exception e) {
			return "Something went wrong";
		}
	}

	// Get particular Product data from DB
	public Object getProduct(int productId) {

		try {
			Session session = sessionFactory.openSession();
			Product product = session.get(Product.class, productId);

			if (product != null) {
				return product;
			} else {
				return "Product not exits";
			}

		} catch (Exception e) {
			return "Something went wrong";
		}
	}

	// Update Particular Product
	public String updateProduct(Product product) {

		try {
			Session session = sessionFactory.openSession();

			Product dbProduct = session.get(Product.class, product.getProductId());

			if (dbProduct != null) {
				session.evict(dbProduct);
				session.update(product);
				session.beginTransaction().commit();

				return "Update Successfully";
			} else {
				return "Product Not Exists to update";
			}

		} catch (Exception e) {
			return "Something went wrong";
		}
	}

	// Retrieve All Products from Database
	public List<Product> retrievesAllProducts() {

		List<Product> productList = null;
		try {
			Session session = sessionFactory.openSession();

			productList = session.createCriteria(Product.class).list();

			return productList;

		} catch (Exception e) {
			e.getMessage();
		}
		return productList;
	}

	// Retrieve All Products in Ascending Order by Given Parameter");
	public List<Product> getProductsInAscendingOrder() {
		List<Product> productList = null;
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productName"));

			productList = criteria.list();

			return productList;

		} catch (Exception e) {
			e.getMessage();
		}
		return productList;
	}

	// Retrieve Product by Product Name");
	public List<Product> getProductByName(String productName) {

		List<Product> productList = null;
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);

			criteria.add(Restrictions.eq("productName", productName));

			productList = criteria.list();

			return productList;

		} catch (Exception e) {
			e.getMessage();
		}
		return productList;

	}

	// Retrieve Products with Price Greater Than Specified Price");
	public List<Product> getProductsByMinPrice(double productPrice) {
		List<Product> productList = null;
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);

			criteria.add(Restrictions.gt("productPrice", productPrice));

			productList = criteria.list();

			return productList;

		} catch (Exception e) {
			e.getMessage();
		}
		return productList;
	}

	// Retrieve Products by Name Pattern
	public List<Product> getProductsByNamePattern(char ch) {
		List<Product> productList = null;
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);

			criteria.add(Restrictions.like("productName", ch + "%"));

			productList = criteria.list();

			return productList;

		} catch (Exception e) {
			e.getMessage();
		}
		return productList;
	}

	// Retrieve Products Within Price Range
	public List<Product> getProductsInPriceRange(double start, double end) {
		List<Product> productList = null;
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);

			criteria.add(Restrictions.between("productPrice", start, end));

			productList = criteria.list();

			return productList;

		} catch (Exception e) {
			e.getMessage();
		}
		return productList;
	}

	// Retrieve limited product
	public List<Product> getLmitedProducts(int limit) {
		List<Product> productList = null;
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);

			criteria.addOrder(Order.asc("productName"));
			criteria.setMaxResults(limit);

			productList = criteria.list();

			return productList;

		} catch (Exception e) {
			e.getMessage();
		}
		return productList;
	}

	// Retrieve product count
	public long getProductCount() {

		long count = 0;
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);

			criteria.setProjection(Projections.rowCount());

			List<Long> list = criteria.list();

			if (!list.isEmpty()) {
				count = list.get(0);
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return count;
	}

	// Retrieve minimum product price
	public double getMinPriceProduct() {

		double count = 0;
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);

			criteria.setProjection(Projections.min("productPrice"));

			List<Double> list = criteria.list();

			if (!list.isEmpty()) {
				count = list.get(0);
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return count;
	}

	// Retrieve maximum product price
	public double getMaxPriceProduct() {

		double count = 0;
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);

			criteria.setProjection(Projections.max("productPrice"));

			List<Double> list = criteria.list();

			if (!list.isEmpty()) {
				count = list.get(0);
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return count;
	}

}
