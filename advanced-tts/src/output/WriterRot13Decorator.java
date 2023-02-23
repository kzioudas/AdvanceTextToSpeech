package output;

import java.util.ArrayList;
import java.util.List;

public class WriterRot13Decorator implements DocumentWriter {

	
	DocumentWriter docWriter;
	WriterRot13Decorator(DocumentWriter docWriter)
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

	@Override
	public List<String> getContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContents(List<String> con) {
		// TODO Auto-generated method stub
		
	}
	public static String encrypt( String message )
    {
        StringBuilder encoded = new StringBuilder();
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
                encoded.append(c);
            } else {
                encoded.append(c);
            }
        }
        return encoded.toString();
    }

}
