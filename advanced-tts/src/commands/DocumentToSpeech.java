package commands;

import java.awt.event.ActionEvent;

import model.Document;
import view.TextToSpeechUserView;

import java.awt.event.ActionListener;
public class DocumentToSpeech implements ActionListener{
	
	Document document;
	ReplayManager replayManager;
	TextToSpeechUserView ttsuview;
	public DocumentToSpeech(TextToSpeechUserView ttsuview)
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
	@Override
	public void actionPerformed(ActionEvent ae) {
		//document = manage.getDocument();
		ttsuview.getDocument().playContents();
		replayManager.recordAction(this);
		
	}
	

}
