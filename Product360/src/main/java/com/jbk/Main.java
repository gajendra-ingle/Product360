package com.jbk;

import java.util.Iterator;
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
			System.out.println("6 : Retrieve All Products in Ascending Order by Given Parameter");
			System.out.println("7 : Retrieve Product by Product Name");
			System.out.println("8 : Retrieve Products with Price Greater Than Specified Price");
			System.out.println("9 : Retrieve Products by Name Pattern");
			System.out.println("10 : Retrieve Products Within Price Range");
			System.out.println("11 : Retrieve maximum product price");

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
				System.out.println("The available products are..");
				operation.retrievesAllProducts();

				break;
			}

			case 6: {
				//Retrieve All Products in Ascending Order by Given Parameter
				
				break;
			}

			case 7: {

				break;
			}

			case 8: {

				break;
			}

			case 9: {

				break;
			}

			case 10: {

				break;
			}

			case 11: {

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
