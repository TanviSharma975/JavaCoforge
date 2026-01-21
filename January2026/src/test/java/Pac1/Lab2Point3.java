package Pac1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab2Point3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file=new File("C:\\Users\\Tanvi.1.Sharma\\Desktop\\numbers.txt");
			Scanner sc=new Scanner(file);
			sc.useDelimiter(",");
			System.out.println("Even Numbers are:");
			while(sc.hasNext()) {
				int number=Integer.parseInt(sc.next().trim());
				if(number%2==0) {
					System.out.println(number+" ");
				}
			}sc.close();
			
				
			
		}catch(FileNotFoundException e) {
			System.out.println("Not Found[]");
		}

	}

}
