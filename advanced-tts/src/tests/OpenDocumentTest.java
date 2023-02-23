package tests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import view.TextToSpeechUserView;

class OpenDocumentTest {

	@Test
	void test() {
		
		TextToSpeechUserView testview= new TextToSpeechUserView();
		OpenDocument testopen = new OpenDocument(testview);
		testopen.actionPerformed(null);
		String text = testopen.textAreaOpen.getText();
		System.out.println(text);
		System.out.println(text.contains("test"));
		
		
		assertEquals(true,text.contains("test"));
	}

}
