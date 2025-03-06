package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	
	public static List<HashMap<String, String>> data(String filePath, String sheetName) throws IOException{
		
		List<HashMap<String,String>> mydata = new ArrayList<>();
		
		
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum();  // to get total row count
		
		XSSFRow headerRow = sheet.getRow(0);
		
		for(int i = 1; i<= totalRows; i++) {
			XSSFRow currentRow = sheet.getRow(i); 
			HashMap<String, String> currentMap = new HashMap<>();
			
			for(int j=0; j < currentRow.getLastCellNum(); j++) {
				
				XSSFCell currentCell = currentRow.getCell(j);  // to assign the j value to current cell
				
				currentMap.put(headerRow.getCell(j).toString(), currentCell.toString());
			}
			mydata.add(currentMap);
		}
		file.close();
		
		return mydata;
		
		
		
		
	}

}
