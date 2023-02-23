package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import commands.EditDocument;

import view.TextToSpeechUserView;

class EditDocumentTest {

	@Test
	void test() {
		List<String> testlist = new ArrayList<String>();
		testlist.add("");
		TextToSpeechUserView testview= new TextToSpeechUserView();
		
		EditDocument testedit = new EditDocument(testview);
		testedit.getDocument().setContents(testlist);
		testedit.actionPerformed(null);
		testlist.add("test");
		testedit.getDocument().setContents(testlist);
		testedit.actionPerformed(null);
		
		
		StringBuilder strbul=new StringBuilder();
        for(String str : testedit.getDocument().getContent())
        {
            strbul.append(str);
            //for adding comma between elements
            strbul.append(",");
        }
       
        String str=strbul.toString();
		System.out.println(str);
		System.out.println(str.contains("test"));
		
		
		assertEquals(true,str.contains("test"));
	}

}
