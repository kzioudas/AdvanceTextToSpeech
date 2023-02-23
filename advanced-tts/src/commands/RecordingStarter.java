package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TextToSpeechUserView;

public class RecordingStarter implements ActionListener {
	TextToSpeechUserView ttsuview;
	RecordingStarter(TextToSpeechUserView ttsuview)
	{
		this.ttsuview=ttsuview;
	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ttsuview.getReplayManager().startRecording();
		
	}

}
