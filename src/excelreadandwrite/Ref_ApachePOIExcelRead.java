package excelreadandwrite;

import java.io.FileInputStream;
import java.util.Iterator;

import javax.swing.text.StyledEditorKit.ItalicAction;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ref_ApachePOIExcelRead {

	private static final String str_File_Name = System.getProperty("user.dir") + "/DataTest/CreateExcel.xlsx";

	
	
	public static void main(String[] args) {
	
		try {
			FileInputStream inputStream = new FileInputStream(str_File_Name);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet dataTypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = dataTypeSheet.iterator();
			
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					
					if (currentCell.getCellType() == CellType.STRING) {
						System.out.println(currentCell.getStringCellValue()+"--");
					}else if(currentCell.getCellType() == CellType.NUMERIC) {
						System.out.println(currentCell.getNumericCellValue()+"--");
					}
					
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
