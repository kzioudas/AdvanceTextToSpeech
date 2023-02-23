package output;

import java.util.List;



public class DocumentWriterFactory {
	
	WriterAtbashDecorator writerAtbashDecorator;
	WriterRot13Decorator writerRot13Decorator;
	
	public DocumentWriterFactory()
	{
		
	}
	
	public DocumentWriter createWriter(String path,String type,String c,List<String> contents)
	{
		DocumentWriter writer=new WordWriter(path,contents) ;
		switch(c)
		{	
			case "no":
				switch(type)
				{
				case ".docx":
					writer= new WordWriter(path,contents);
					break;
				case ".xlsx":
					writer= new ExcelWriter(path,contents);
					break;
				}
				break;
			case "atBash":
				switch(type)
				{
				case ".docx":
					writer= new WriterAtbashDecorator(new WordWriter(path,contents));
					break;
				case ".xlsx":
					writer= new WriterAtbashDecorator(new ExcelWriter(path,contents));
					break;
				}
				break;
			case "rot13":
				switch(type)
				{
				case ".docx":
					writer=  new WriterRot13Decorator(new WordWriter(path,contents));
					break;
				case ".xlsx":
					writer= new WriterRot13Decorator(new ExcelWriter(path,contents));
					break;
				}
				break;
				
				
		}
		return writer;
	}
}


