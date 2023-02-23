package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TextToSpeechUserView;

public class RecordingEnder implements ActionListener {
	TextToSpeechUserView ttsuview;
	RecordingEnder(TextToSpeechUserView ttsuview)
	{
		this.ttsuview=ttsuview;
	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ttsuview.getReplayManager().endRecording();
		
	}

}
