package input;

import java.util.ArrayList;
import java.util.List;

public  class ReaderRot13Decorator implements DocumentReader {
	
	private DocumentReader docReader;
	
	
	public ReaderRot13Decorator(DocumentReader dr) {
		
		this.docReader = dr;
		
	}
	
	public List<String> read(){
		System.out.println("In rotdec:");
		List<String> deccontent= new ArrayList<String>();
		List<String> content =docReader.read();
		for(int i=0;i<content.size();i++)
		{
			String a =content.get(i);
			deccontent.add(i,decrypt(a));
		}
		return deccontent;

	}
	public static String decrypt( String message )
    {
        StringBuilder decoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
            	if (c >= 'a' && c <= 'z') {
                    // Rotate lowercase letters.

                    if (c > 'm') {
                        c -= 13;
                    } else {
                        c += 13;
                    }
                } else if (c >= 'A' && c <= 'Z') {
                    // Rotate uppercase letters.

                    if (c > 'M') {
                        c -= 13;
                    } else {
                        c += 13;
                    }
                }
                decoded.append(c);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }
}