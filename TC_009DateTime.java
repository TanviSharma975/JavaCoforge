package Pac1;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.Period;

public class TC_009DateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Instant currTime=Instant.now();
		System.out.println(currTime);
		
		
		LocalDate now=LocalDate.now();
		LocalDate bdy=LocalDate.of(2005, Month.JULY, 9);
		Period period=bdy.until(now);
		
		System.out.println(now.format(formatter));
		System.out.println(now.format(formatter1));
		System.out.println(period);
		System.out.println(period.get(ChronoUnit.DAYS));
		System.out.println(period.get(ChronoUnit.MONTHS));
		System.out.println(period.get(ChronoUnit.YEARS));
		System.out.println(bdy);
		System.out.println(now.plusDays(1));
		System.out.println(now.minusMonths(1));
		System.out.println(now.isLeapYear());
		System.out.println(now.withDayOfMonth(30));
		
		
		ZonedDateTime time=ZonedDateTime.now();
		ZonedDateTime timeParis=ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(time);
		System.out.println(timeParis);
		System.out.println(formatter1);
		
		
		
		
		

	}

}