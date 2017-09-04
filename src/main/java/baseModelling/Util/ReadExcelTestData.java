package baseModelling.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeSuite;

public class ReadExcelTestData implements Serializable{

	private static final long serialVersionUID = 1L;

	public ReadExcelTestData() {
		
	}
	
	String testdataFilePathinString = "D:\\eclipse-jee-oxygen-R-win32-x86_64\\testdata\\Testdata.xlsx";
	File testDataFile = null;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFSheet ExcelWSBook;
	String sheetname = "Sheet1";
	String testdatasetname = "TestDataSet1";
	public static XSSFCell ExcelWCBook;
	public static HashMap<String,String> KeyvalueofStringData;

	
	@BeforeSuite
	public void GettingTestdataFromFilebeforeSuite() throws IOException {
		testDataFile = new File(testdataFilePathinString);

		try {
			if (testDataFile.exists()) {
				FileInputStream InputStreamFile =new FileInputStream(testDataFile);
				ExcelWBook = new XSSFWorkbook(InputStreamFile);
				ExcelWSBook = ExcelWBook.getSheet(sheetname);

				//  Not needed as of now				ExcelWCBook = ExcelWSBook.getRow(1).getCell(1); 
				
				KeyvalueofStringData = new HashMap<String,String>();
				KeyvalueofStringData = fetchDataRowColumWise(ExcelWSBook);
				System.out.println(KeyvalueofStringData);
			}

		} catch (FileNotFoundException e) {
			new Throwable("Check the file path");
		}

	}
	
//	method for fetching data row--> colum wise
	
	public HashMap<String,String> fetchDataRowColumWise (XSSFSheet sheet){
		
		int rowCount = sheet.getLastRowNum(); 
		HashMap<String,String> sb = new HashMap<String,String>();
		
		for (Row row : sheet) { // For each Row.
				
				if(row.getRowNum()==0) {
					continue;
				}
				Cell Cell0 = row.getCell(0);
				Cell Cell1 = row.getCell(1);// Get the Cell at the Index / Column you want.
		      	String cellvalue0 = Cell0.toString(); 
		      	String cellvalue1 = Cell1.toString();
		      	sb.put(cellvalue0, cellvalue1);
		      				      	
		}
		
		return sb;
		
		
		
	}

}
