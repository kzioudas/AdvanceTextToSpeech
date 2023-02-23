package output;

import java.util.ArrayList;
import java.util.List;

public class WriterAtbashDecorator implements DocumentWriter{
	DocumentWriter docWriter;
	private String abchars = "abcdefghijklmnopqrstuvwxyz";
    private String abcharsrev = "zyxwvutsrqponmlkjihgfedcba";
	WriterAtbashDecorator(DocumentWriter docWriter)
	{
		this.docWriter=docWriter;
	}
	
	@Override
	public List<String> write() {
		List<String> enccontent= new ArrayList<String>();
		List<String> content =docWriter.getContents();
		for(int i=0;i<content.size();i++)
		{
			String a =content.get(i);
			enccontent.add(i,encrypt(a));
		}
		docWriter.setContents(enccontent);
		return docWriter.write();
	
	}
	public  String encrypt( String message )
	 {
		char[] decoded = message.toCharArray();
		for(int i=0;i<decoded.length;i++) {
			char c = decoded[i];
			
			if(c>='a' && c <='z') {
			
				int pos = abchars.indexOf(c);
				c = abcharsrev.charAt(pos);
				
			}else if(c>='A' && c <='Z') {
				
				int pos = abchars.toUpperCase().indexOf(c);
				c = abcharsrev.toUpperCase().charAt(pos);
				
			}
			decoded[i] =c;
		}
		return new String(decoded);	
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
