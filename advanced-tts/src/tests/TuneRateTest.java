package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import commands.TuneRate;
import view.TextToSpeechUserView;

class TuneRateTest {

	@Test
	void test() {
		TextToSpeechUserView testview= new TextToSpeechUserView();
		TuneRate tptest = new TuneRate(testview);
		int x =testview.getDocument().getTTSF().rate;
		tptest.actionPerformed(null);
		assertEquals(true,x!=testview.getDocument().getTTSF().rate);
	}


}
