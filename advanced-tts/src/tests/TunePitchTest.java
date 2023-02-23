package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.TunePitch;
import view.TextToSpeechUserView;

class TunePitchTest {

	@Test
	void test() {
		TextToSpeechUserView testview= new TextToSpeechUserView();
		TunePitch tptest = new TunePitch(testview);
		int x =testview.getDocument().getTTSF().pitch;
		tptest.actionPerformed(null);
		assertEquals(true,x!=testview.getDocument().getTTSF().pitch);
	}

}
