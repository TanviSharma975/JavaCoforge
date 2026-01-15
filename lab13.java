package Pac1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class lab13 {
public static void printWarranty(int year,int month,int day,int warrantyYears,int warrantyMonths) {
	LocalDate purchaseDate=LocalDate.of(year, month, day);
	LocalDate expireDate=purchaseDate.plusYears(warrantyYears).plusMonths(warrantyMonths);
	DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy");
	System.out.println(purchaseDate.format(formatter));
	System.out.println(expireDate.format(formatter));
	
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printWarranty(2023,8,10,1,6);

	}

}
