package input;

import java.util.ArrayList;
import java.util.List;

public class ReaderAtBashDecorator implements DocumentReader {
	
	private DocumentReader docReader;
	
	private String abchars = "abcdefghijklmnopqrstuvwxyz";
    private String abcharsrev = "zyxwvutsrqponmlkjihgfedcba";
	public ReaderAtBashDecorator(DocumentReader dr) {
		
		this.docReader = dr;
		
		
	}
	
	
	public List<String> read(){
		System.out.println("In atbashdec:");
		List<String> deccontent= new ArrayList<String>();
		List<String> content =docReader.read();
		for(int i=0;i<content.size();i++)
		{
			String a =content.get(i);
			deccontent.add(i,decrypt(a));
			System.out.println("Decoded "+decrypt(a));
		}
		return deccontent;

	}
	public String decrypt( String message )
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
	
}