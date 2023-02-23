package output;

import java.util.List;

public class WriterDecorator implements DocumentWriter {
	DocumentWriter dw;
	WriterDecorator(DocumentWriter dw)
	{
		this.dw=dw;
	}

	@Override
	public List<String> write() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContents(List<String> con) {
		// TODO Auto-generated method stub
		
	}

}
