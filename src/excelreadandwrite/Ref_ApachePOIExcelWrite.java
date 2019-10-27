package excelreadandwrite;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ref_ApachePOIExcelWrite {

	// private static final String str_File_Name =
	// System.getProperty("/Practice_CoreJavaOOP_October2019/DataTest/CreateExcel.xlsx");

	private static final String str_File_Name = System.getProperty("user.dir") + "/DataTest/CreateExcel.xlsx";

	public static void main(String[] args) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Datatypes in Java");

		Object[][] datatypes = { { "Datatype", "Type", "Size(in bytes)" }, { "int", "Primitive", 2 },
				{ "float", "Primitive", 4 }, { "double", "Primitive", 8 }, { "char", "Primitive", 1 },
				{ "String", "Non-Primitive", "No fixed size" } };

		int rowNum = 0;
		System.out.println("Creating excel");

		for (Object[] dataType : datatypes) {
			Row row = sheet.createRow(rowNum++);

			int column = 0;
			for (Object field : dataType) {
				Cell cell = row.createCell(column++);

				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}

			}

		}
		
		

		try {
			FileOutputStream outputStream = new FileOutputStream(str_File_Name);
			workbook.write(outputStream);
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}

}
