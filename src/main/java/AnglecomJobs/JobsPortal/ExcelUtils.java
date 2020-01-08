package AnglecomJobs.JobsPortal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static Sheet sheet = null;
	private static Workbook workbook = null;
	private static Row row = null;
	 public static void setExcel(String excelpath) throws IOException
	 {
		 FileInputStream input = new FileInputStream(new File(excelpath));
	
		 if (excelpath.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(input);
			} else if (excelpath.endsWith("xls")) {
				workbook = new HSSFWorkbook(input);
			} else {
			 
				throw new IllegalArgumentException("The specified file is not excel file");
			}
	 }
	 
	public static void closeExcel() {
		try
		{
			workbook.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static List<String> getData(String excelpath , String sheetname) {
		List<String> value = new ArrayList<String>();
		try {
		setExcel(excelpath);
		sheet = workbook.getSheet(sheetname);
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		for(int i = 1 ; i<numberOfRows; i++)
		{
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			String data = cell.getStringCellValue();
			value.add(data);
		}
		
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return value;
		
	}
	
	public static void writeResultHeader(String filePath) throws IOException {
			
		setExcel(filePath);
	
		XSSFSheet sheet = (XSSFSheet) workbook.createSheet("Jobdetails");
		String[] resultsColumn = { "CompanyName", "JobType", "JobTitle", "JobLocation" };

		int rowCount = 0;
		 row = sheet.createRow(rowCount);
		int columnCount = 0;
		for (String header : resultsColumn) {
			Cell cell = row.createCell(columnCount++);
			cell.setCellValue(header);
		
		try {
			FileOutputStream outputStream = new FileOutputStream(filePath);
			workbook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		}
}
	public static void writeTestResult(String filePath, String companyName, String jobType, 
			String jobTitle, String jobLocation) throws IOException
	{
		setExcel(filePath);
		sheet = workbook.getSheet("Jobdetails");
		int rownumbers = sheet.getPhysicalNumberOfRows();
		int columncount = 0;
		row = sheet.createRow(rownumbers);
		Cell cell= row.createCell(columncount++);
		cell.setCellValue(companyName);		
		cell= row.createCell(columncount++);
		cell.setCellValue(jobType);
		cell= row.createCell(columncount++);
		cell.setCellValue(jobTitle);
		cell= row.createCell(columncount++);
		cell.setCellValue(jobLocation);

		try {
			FileOutputStream outputStream = new FileOutputStream(filePath);
			workbook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

	