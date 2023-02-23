package output;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


import model.Document;

public class ExcelWriter implements DocumentWriter{
	String path;
	Document document;
	private List<String> contents;
	ExcelWriter(String path,List<String> contents)
	{
		this.path=path;
		
		this.contents=contents;
	}
	@Override
	public void setContents(List<String> con)
	{
		this.contents=con;
	}
	@Override
	public List<String> getContents()
	{
		return this.contents;
	}

	@Override
	public List<String> write() {
		
			  
			
		try (XSSFWorkbook workbook = new XSSFWorkbook(path)) {
				XSSFSheet sheet = workbook.createSheet();
	          
				for(int i=0;i<contents.size();i++)
				{	Row row = sheet.createRow(i);
					String[] cel = contents.get(i).split(",");
					for(int k = 0;k<cel.length;k++)
					{
						 Cell cell = row.createCell(k);
						 if(cel[k]instanceof String)
						 {
							 cell.setCellValue((String)cel[k]); 
						 }
						 
					}
				}
	            try (FileOutputStream out = new FileOutputStream(path+".new")) {
	            	workbook.write(out);
	                out.close();
	            }catch(Exception e)
	            {
	            	e.printStackTrace();  
	            }
	            Files.delete(Paths.get(path));
		        Files.move(Paths.get(path + ".new"), Paths.get(path));
		 }catch(Exception e)
		 { e.printStackTrace();   }
		
		return null;
	}
	

}
	
	
