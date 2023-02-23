package input;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import model.Document;


import java.nio.file.Files;
import java.nio.file.Paths;

public class WordReader implements DocumentReader{
	String path;
	Document document;
	public WordReader(String path)
	{
		super();
		this.path=path;
	}
	
	
	public WordReader() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<String> read(){
		   
		 List<String> con = new ArrayList<String>();
	        try (XWPFDocument doc = new XWPFDocument(
                Files.newInputStream(Paths.get(path)))) {

            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
            String docText = xwpfWordExtractor.getText();
            con.add(docText);
            xwpfWordExtractor.close();
            doc.close();

        }
        catch (Exception e) { 
        	System.out.println("Can't open file: "+ path);
        	 System.out.println(e);  
        }
	    
        return con;
	}

}
