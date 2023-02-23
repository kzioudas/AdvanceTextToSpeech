package output;



import java.util.List;

import java.io.FileOutputStream;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.poi.openxml4j.opc.OPCPackage;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordWriter implements DocumentWriter {
	
	
	List<String> contents ;
	String path;
	WordWriter(String path,List<String> contents)
	{
		this.path=path;
		
		this.contents=contents;
	}
	public void setContents(List<String> con)
	{
		this.contents=con;
	}
	public List<String> getContents()
	{
		return this.contents;
	}
	@Override
	public List<String> write()  {
		System.out.println("Write");
		
		try (XWPFDocument doc = new XWPFDocument(OPCPackage.open(path)) )
		{
			
			 System.out.println("Write after try");
			 XWPFParagraph p = doc.createParagraph();
			 
			 XWPFRun newr =p.createRun();
			
			 System.out.println("size of cont in setcont in write"+contents.size());
			 System.out.println("Write before for");
			 for(int i =0;i<contents.size();i++)
			 {	System.out.println("size of cont in setcont in for in write"+contents.size());
				 System.out.println(i);
				 System.out.println(contents.get(i));
				 newr.setText(contents.get(i)+"\n");
			 }
			 System.out.println("Write before for after for");
	         try (FileOutputStream out = new FileOutputStream(path+".new")) 
	         {
	        	 
	              doc.write(out);
	              out.close();
	         }
	         catch(Exception e)
	         {
	        	 e.printStackTrace(); 
	        	 System.out.println("Not Writen Save");
	         }
	         Files.delete(Paths.get(path));
	         Files.move(Paths.get(path + ".new"), Paths.get(path));
		 }catch(Exception e)
		 {
			 e.printStackTrace();   
			 System.out.println("Not Opened Save");
		 }
	
		return null;
	}
}
