package tests;



import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import commands.SaveDocument;
import view.TextToSpeechUserView;

class SaveDocumentTest {

	@Test
	void test() 
	{
		List<String> testlist = new ArrayList<String>();
		TextToSpeechUserView testview= new TextToSpeechUserView();
		SaveDocument testsave = new SaveDocument(testview);
		testlist.add("testsave");
	
		testview.getDocument().setContents(testlist);
		testsave.actionPerformed(null);
		
		
		
		//assertEquals(true,text.contains("test"));
	}

}
