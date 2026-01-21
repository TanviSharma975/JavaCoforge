package Pac1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab2Point2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file=new File("C:\\Users\\Tanvi.1.Sharma\\Desktop\\numbers.txt");
			Scanner sc=new Scanner(file);
			sc.useDelimiter(",");
			System.out.println("Even numbers are:");
			while(sc.hasNext()) {
				int num=Integer.parseInt(sc.next().trim());
				if(num%2==0) {
					System.out.println(num+" ");
				}
			}sc.close();
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}

	}

}
