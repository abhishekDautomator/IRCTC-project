package Utillities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	static XSSFWorkbook wb;
	static String s;
	static String filePath="C:\\Users\\naray\\eclipse-workspace\\AutomateIRCTCticketBooking\\TestData\\IRCTC_TestData.xlsx";
	
	public static String getCellData(String sheetName,int row,int cell) {
		// TODO Auto-generated method stub	
		
		try {
			
		FileInputStream fis=new FileInputStream(new File(filePath));
		
		try {
			
		wb=new XSSFWorkbook(fis);
		s=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
		}
		catch(IOException ie) {
			System.out.println("IOException occurs in Excel at :"+filePath);
		}
		}
		catch(FileNotFoundException fe) {
			System.out.println("Excel file is not present at : "+filePath);
		}
		
		return s;
		
	}
	
	
		

}
