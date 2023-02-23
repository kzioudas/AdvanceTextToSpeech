package input;

import java.util.List;

public  class ReaderDecorator implements DocumentReader {
	DocumentReader docReader;
	ReaderDecorator()
	{
		
		
	}
	ReaderDecorator(DocumentReader docReader)
	{
		this.docReader=docReader;
		
	}
	@Override
	public List<String> read() {
		
		return docReader.read();
	}
	

}
