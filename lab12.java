package Pac1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class lab12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		 Scanner sc = new Scanner(System.in);
		        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		        try {
		            System.out.print("Enter first date (yyyy-MM-dd): ");
		            String firstInput = sc.nextLine().trim();

		            System.out.print("Enter second date (yyyy-MM-dd): ");
		            String secondInput = sc.nextLine().trim();

            LocalDate d1 = LocalDate.parse(firstInput, fmt);
            LocalDate d2 = LocalDate.parse(secondInput, fmt);

            // Ensure start <= end for period calculation
            LocalDate start = d1.isBefore(d2) ? d1 : d2;
            LocalDate end   = d1.isBefore(d2) ? d2 : d1;

            Period p = Period.between(start, end);

            System.out.println();
            System.out.println("Start date : " + start);
            System.out.println("End date   : " + end);
            System.out.printf("Duration   : %d year(s), %d month(s), %d day(s)%n",
                    p.getYears(), p.getMonths(), p.getDays());

           } catch (DateTimeParseException ex) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd (e.g., 2024-02-29).");

} finally {
            sc.close();
        }
    }
}



		
		

	
