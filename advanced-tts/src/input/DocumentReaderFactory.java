package input;

public class DocumentReaderFactory {
	
	ReaderAtBashDecorator readerAtbashDecorator;
	ReaderRot13Decorator readerRot13Decorator;
	
	public DocumentReaderFactory()
	{
		
	}
	
	public DocumentReader createReader(String path,String type,String c)
	{	
		DocumentReader reader = new WordReader();
		System.out.println("In reader fac enc:"+c);
		switch(c)
		{	
			
			case "no":
				System.out.println("In reader fac no");
				switch(type)
				{
					
				case ".docx":
					
					reader= new ReaderDecorator(new WordReader(path));
					
					break;
				case ".xlsx":
					reader= new ReaderDecorator(new ExcelReader(path));
					break;
				}
				
				break;
			case "atBash":
				System.out.println("In reader fac atbash");
				switch(type)
				{
				case ".docx":
					reader =new ReaderAtBashDecorator(new WordReader(path));
					
					break;
				case ".xlsx":
					reader= new ReaderAtBashDecorator(new ExcelReader(path));
					break;
				}
				break;
			case "rot13":
				System.out.println("In reader fac rot13");
				switch(type)
				{
				case ".docx":
					reader=new ReaderRot13Decorator(new WordReader(path));
					break;
				case ".xlsx":
					reader= new ReaderRot13Decorator(new ExcelReader(path));
					break;
				}
				break;
				
					
				
		}
		return reader; 
	}
}
