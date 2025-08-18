package testDemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {
             public static void main(String[] args) throws IOException  {
				FileInputStream fis=new FileInputStream("\"C:\\Users\\USER\\OneDrive\\Documents\\Book.xlsx\"");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sh=wb.getSheet("Book");
				Row r=sh.getRow(0);
				Cell c=r.getCell(1);
				System.out.println(c.getStringCellValue());
				wb.close();
			}
}
