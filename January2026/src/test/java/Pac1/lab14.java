package Pac1;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

public class lab14 {
	public static void printCurrDaateAndTime(String zoneIdStr) {
		ZoneId zid=ZoneId.of(zoneIdStr);
		ZonedDateTime zonedDateTime=ZonedDateTime.now(zid);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(zid);
		System.out.println(zonedDateTime.format(formatter));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printCurrDaateAndTime("America/New_York");
		printCurrDaateAndTime("Europe/London");
		printCurrDaateAndTime("Asia/Tokyo");
		printCurrDaateAndTime("US/Pacific");
		printCurrDaateAndTime("Africa/Cairo");
		printCurrDaateAndTime("Australia/Sydney");

	}

}
