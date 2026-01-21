package Pac1;

import java.util.Arrays;

import java.util.Scanner;

public class ProductSorting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");

        int n = sc.nextInt();

        sc.nextLine();   // consume newline

        String[] products = new String[n];

        // Read product names

        for (int i = 0; i < n; i++) {

            System.out.print("Enter product name " + (i + 1) + ": ");

            products[i] = sc.nextLine();

        }

        // Sort product names

        Arrays.sort(products);

        // Display sorted products

        System.out.println("\nSorted Product Names:");

        for (String product : products) {

            System.out.println(product);

        }

        sc.close();

    }

}
