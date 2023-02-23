package commands;

import java.awt.event.ActionEvent;

import model.Document;
import view.TextToSpeechUserView;

import java.awt.event.ActionListener;
public class ReplayCommand implements ActionListener{

	Document document;
	ReplayManager replayManager;
	TextToSpeechUserView ttsuview;
	public ReplayCommand(TextToSpeechUserView ttsuview)
	{
		this.ttsuview=ttsuview;
		this.replayManager=ttsuview.getReplayManager();
	}
	void setDocument(Document doc)
	{
		this.document = doc;
	}
	void setReplayManager(ReplayManager rm)
	{
		this.replayManager = rm;
	}
	public ReplayManager getReplayManager()
	{
		return replayManager;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		ttsuview.setDocument();
		replayManager.replay();
		//view calls
		
	}
}
