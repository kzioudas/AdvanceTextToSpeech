package input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Document;



public class ExcelReader implements DocumentReader {
	String path;
	Document document;
	public ExcelReader()
	{
		super();
		
	}
	public ExcelReader(String path)
	{
		super();
		this.path=path;
	}
	
	@Override
	public List<String> read() {
		System.out.println("in ecxel read()");
		// TODO Auto-generated method stub
		List<String> file_cont = new ArrayList<String>();
		String excelFilePath = path;
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));//anoigoume ena arxeio
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//kianouruio workbook tupou workbook meso inputstream
        Sheet firstSheet = workbook.getSheetAt(0);//kainourio sheet
        Iterator<Row> iterator = firstSheet.iterator();//
		System.out.println("iterator has next: "+iterator.hasNext());
        while (iterator.hasNext()) 
        {
        	int i=0;
        	System.out.println("in ecxel read() while i: "+i);
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            String row="";
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                
                switch (cell.getCellType()) 
                {
                    case STRING:
                        row= row+"," +cell.getStringCellValue();
                        break;
                    case BOOLEAN:
                    	row= row+","+cell.getBooleanCellValue();
                        break;
                    case NUMERIC:
                    	row= row +cell.getNumericCellValue();
                        break;
                    case BLANK:
                    	row= row+"," +"		";
                        break;
                }
            }
            row= row+"\n";
            file_cont.add(i, row);
            i++;   
           
           
        }
        try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file_cont;
		
	}
	

}
