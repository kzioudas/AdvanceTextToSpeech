package tests;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import commands.DocumentToSpeech;

import view.TextToSpeechUserView;

class DocumentToSpeechTest {

	@Test
	void test() {
		TextToSpeechUserView testview= new TextToSpeechUserView();
		DocumentToSpeech test = new DocumentToSpeech(testview);
		List<String> testlist = new ArrayList<String>();
		testlist.add("test");
		testview.getDocument().setContents(testlist);
		
		test.actionPerformed(null);
		//assertEquals(true,o);
	}

}
