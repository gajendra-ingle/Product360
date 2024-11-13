package com.jbk.utility;

import java.util.Scanner;

import com.jbk.entity.Product;

public class ProductData {

	public static Product getProductInfo() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter product name : ");
		String productName = sc.next();

		System.out.println("Enter product Qty : ");
		int productQty = sc.nextInt();

		System.out.println("Enter product price : ");
		double productPrice = sc.nextDouble();

		System.out.println("Enter MFG Date : ");
		String mfgDate = sc.next();

		System.out.println("Enter EXP Date : ");
		String expDate = sc.next();

		return new Product(productName, productQty, productPrice, mfgDate, expDate);

	}
}
