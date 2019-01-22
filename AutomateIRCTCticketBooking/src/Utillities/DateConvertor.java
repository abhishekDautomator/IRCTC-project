package Utillities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.openqa.selenium.By;

import pages.JourneyDetailsPage;

public class DateConvertor {
	
	static Date d;
	JourneyDetailsPage JDP;
	static SimpleDateFormat sdf;
	
	static String date;
	
	public static String dateConvert(String journeyDate) {
		
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			d = sdf.parse(journeyDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		sdf.applyPattern("dd MMM yyyy");
		date=sdf.format(d);
		return date;
	}
	
	public static void main(String[] args) {
		System.out.println(dateConvert("02-03-2018"));
	}

}
