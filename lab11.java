package Pac1;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class lab11 {
	public static void main(String[]args) {
	LocalDate now=LocalDate.now();
	LocalDate bdy=LocalDate.of(2005, Month.JULY, 9);
	Period period=bdy.until(now);
	System.out.println(period);
	
}
}
