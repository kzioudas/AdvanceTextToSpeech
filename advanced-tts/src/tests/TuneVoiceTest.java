package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import commands.TuneVoice;
import view.TextToSpeechUserView;

class TuneVoiceTest {

	@Test
	void test() {
		TextToSpeechUserView testview= new TextToSpeechUserView();
		TuneVoice tptest = new TuneVoice(testview);
		int x =testview.getDocument().getTTSF().volume;
		tptest.actionPerformed(null);
		assertEquals(true,x!=testview.getDocument().getTTSF().volume);
	}

}
