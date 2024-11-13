package com.jbk.operation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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
	public void retrievesAllProducts() {

		try {
			Session session = sessionFactory.openSession();

			List<Product> productList = session.createCriteria(Product.class).list();

			for (Product product : productList) {
				System.out.println(product);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Retrieve All Products in Ascending Order by Given Parameter");
	public void getProductsInAscendingOrder(double price, String name) {

	}

	// Retrieve Product by Product Name");
	public void getProductByName(String productName) {

	}

	// Retrieve Products with Price Greater Than Specified Price");
	public void getProductsByMinPrice() {

	}

	// Retrieve Products by Name Pattern
	public void getProductsByNamePattern() {

	}

	// Retrieve Products Within Price Range
	public void getProductsInPriceRange() {

	}

	// Retrieve maximum product price
	public void getMaxProductPrice() {

	}

}
