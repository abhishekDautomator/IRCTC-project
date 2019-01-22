package Utillities;

import java.io.BufferedReader;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	static Properties properties;
	static String filePath="C:\\Users\\naray\\eclipse-workspace\\AutomateIRCTCticketBooking\\configFile\\config.properties";
	
	
	public static void configFilereader() {
		BufferedReader reader;
		try{
			reader=new BufferedReader(new FileReader(new File(filePath)));
			properties=new Properties();
			try {
				properties.load(reader);
				reader.close();
			}
			catch(IOException io) {
				System.out.println("IOException occured");
			}
		}
		catch(FileNotFoundException f) {
			
			System.out.println("Config.properties File not found at :"+filePath);
		}
		
	}
	
	public static String readURL() {
		
		configFilereader();
		String url=properties.getProperty("URL");
		if(url!=null) 
			return url;
		else 
			return "No URL present in config.properties file";
	}
	
	public static String readUserName() {
		configFilereader();
		String userName=properties.getProperty("UserName");
		if(userName!=null) 
			return userName;
		else 
			return "No URL present in config.properties file";
	}
	
	public static String readPassword() {
		configFilereader();
		String password=properties.getProperty("Password");
		if(password!=null) 
			return password;
		else 
			return "No URL present in config.properties file";
	}
	
	
}
