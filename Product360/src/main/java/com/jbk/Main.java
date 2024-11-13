package com.jbk;

import java.util.List;
import java.util.Scanner;

import com.jbk.entity.Product;
import com.jbk.operation.Operations;
import com.jbk.utility.ProductData;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Operations operation = new Operations();
		boolean doYouWantToContinue = true;

		do {

			System.out.println("\nSelect an option:");
			System.out.println("1 : Add a product");
			System.out.println("2 : Delete a product by Product ID");
			System.out.println("3 : Search for a product by Product ID");
			System.out.println("4 : Update a product");
			System.out.println("5 : View the list of all available products");
			System.out.println("6 : View All Products in Ascending Order by Given Parameter");
			System.out.println("7 : View Product by Product Name");
			System.out.println("8 : View Products with Price Greater Than Specified Price");
			System.out.println("9 : View Products by Name Pattern");
			System.out.println("10 : View Products Within Price Range");
			System.out.println("11 : View limited product");
			System.out.println("12 : Get total product count ");
			System.out.println("13 : Get Min price product ");
			System.out.println("14 : Get Max price product ");
			System.out.println("0 : Exit ");

			System.out.print("\nEnter Your Choice : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 0: {
				doYouWantToContinue = false;
				sc.close();
				break;
			}

			case 1: {
				Product product = ProductData.getProductInfo();
				String msg = operation.addProduct(product);
				System.out.println(msg);
				break;
			}

			case 2:
				System.out.println("Enter product id which you want to delete : ");
				int id = sc.nextInt();
				String deleteOrNot = operation.deleteProduct(id);
				System.out.println(deleteOrNot);
				break;

			case 3: {
				System.out.println("Enter product id which you want to see");
				int searchId = sc.nextInt();
				Object foundOrNot = operation.getProduct(searchId);
				System.out.println(foundOrNot.toString());

				break;
			}

			case 4: {
				System.out.println("Enter product Id : ");
				int productId = sc.nextInt();
				Product product = ProductData.getProductInfo();
				product.setProductId(productId);

				String updateOrNot = operation.updateProduct(product);
				System.out.println(updateOrNot);

				break;
			}

			case 5: {
				List<Product> productList = operation.retrievesAllProducts();
				if (!productList.isEmpty()) {
					for (Product product : productList) {
						System.out.println(product);
					}
				} else {
					System.out.println("Table empty...");
				}

				break;
			}

			case 6: {
				List<Product> productListAscOrder = operation.getProductsInAscendingOrder();
				if (!productListAscOrder.isEmpty()) {
					for (Product product : productListAscOrder) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record is avaliable...");
				}

				break;
			}

			case 7: {
				System.out.println("Enter product name ");
				String productName = sc.next();

				List<Product> productList = operation.getProductByName(productName);
				if (!productList.isEmpty()) {
					for (Product product : productList) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record is avaliable...");
				}

				break;
			}

			case 8: {
				System.out.println("Enter product price ");
				double productPrice = sc.nextDouble();

				List<Product> productList = operation.getProductsByMinPrice(productPrice);
				if (!productList.isEmpty()) {
					for (Product product : productList) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record is avaliable...");
				}

				break;
			}

			case 9: {
				System.out.println("Enter product name pattern : ");
				char pattern = sc.next().charAt(0);

				List<Product> productList = operation.getProductsByNamePattern(pattern);
				if (!productList.isEmpty()) {
					for (Product product : productList) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record is avaliable...");
				}

				break;
			}

			case 10: {
				// View Products Within Price Range
				System.out.println("Enter starting price : ");
				double start = sc.nextInt();
				System.out.println("Enter ending price : ");
				double end = sc.nextInt();
				List<Product> productList = operation.getProductsInPriceRange(start, end);
				if (!productList.isEmpty()) {
					for (Product product : productList) {
						System.out.println(product);
					}
				} else {
					System.out.println("No product exists in this range");
				}
				break;
			}

			case 11: {
				System.out.println("How many product you want to see");
				int limit = sc.nextInt();
				List<Product> limtedProductList = operation.getLmitedProducts(limit);
				if (!limtedProductList.isEmpty()) {
					for (Product product : limtedProductList) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record is avaliable...");
				}
				break;
			}

			case 12: {
				long count = operation.getProductCount();
				System.out.println(count);
				break;
			}

			case 13: {
				double count = operation.getMinPriceProduct();
				System.out.println(count);
				break;
			}
			case 14: {
				double count = operation.getMaxPriceProduct();
				System.out.println(count);
				break;
			}

			default:
				System.out.println("Invalid Choice....");
				break;
			}

		} while (doYouWantToContinue);

		System.out.println("\nThank You...");

	}
}
