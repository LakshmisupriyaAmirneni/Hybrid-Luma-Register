package Luma_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLUtils {
	//data driven testing supporting files

	//data driven testing supporting files

		public static FileInputStream fi;//it is converted into the reading mode
		public static FileOutputStream fo;//it is convert into the writing mode
		public static XSSFWorkbook wb;
		public static XSSFSheet sheet;
		public static XSSFRow row;
		public static XSSFCell cell;

		//get the row count of the excel sheet
		public static int getRowCount(String xlfile,String xlsheet) throws IOException {

			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			sheet=wb.getSheet(xlsheet);
			int rowcount=sheet.getLastRowNum();//last row num
			wb.close();
			fi.close();
			return rowcount;
		}
		
		
		public static int getCellcount(String xlfile,String xlsheet,int rownum) throws IOException {

			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			sheet=wb.getSheet(xlsheet);
			row=sheet.getRow(rownum);
			int cellcount=row.getLastCellNum();//find the cell count
			return cellcount;
		}
		
		public static String getcelldata(String xlfile,String xlsheet,int rownum,int cellnum) throws IOException {

			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			sheet=wb.getSheet(xlsheet);
			row=sheet.getRow(rownum);
			cell=row.getCell(cellnum);

			String data;
			
			try {
				
				DataFormatter formatter=new DataFormatter();
				String celldata=formatter.formatCellValue(cell);
				return celldata;
				
			}catch(Exception e) {
				data="";
			}
			wb.close();
			fi.close();
			return data;
		}

		//selenium some times data not read properly that why we are using this method--
		
		public  void setCellData(String xlfile,String xlsheet,int rownum,int cellnum,String data) throws IOException {
			
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			sheet=wb.getSheet(xlsheet);
			row=sheet.getRow(rownum);
			cell=row.createCell(cellnum);
			cell.setCellValue(data);

			
			//set the data (writing)
			fo=new FileOutputStream(xlfile);

			wb.write(fo);
			fi.close();
			fo.close();

		}





}
