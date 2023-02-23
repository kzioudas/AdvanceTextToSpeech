package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.jupiter.api.Test;

import commands.ReplayCommand;
import view.TextToSpeechUserView;

class ReplayCommandTest {

	@Test
	void test() {
		TextToSpeechUserView testview= new TextToSpeechUserView();
		ReplayCommand replaytest = new ReplayCommand(testview);
		boolean action =false;	
		replaytest.getReplayManager().startRecording();
		replaytest.getReplayManager().recordAction(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(action);
				replaytest.getReplayManager().test();
			}
			
		});
		replaytest.getReplayManager().endRecording();
		replaytest.actionPerformed(null);
		assertEquals(true,replaytest.getReplayManager().test);
	}

}
