package commands;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import model.*;
import view.TextToSpeechUserView;
public class LineToSpeech  implements ActionListener
{

	private ReplayManager replayManager;
	private Document document;
	
	TextToSpeechUserView ttsuview;
	public LineToSpeech(TextToSpeechUserView ttsuview)
	{
		this.ttsuview=ttsuview;
		this.document=ttsuview.getDocument();
		this.replayManager=ttsuview.getReplayManager();
	}
	public LineToSpeech(ReplayManager rm,Document doc,int line)
	{
		this.document=doc;
		
		this.replayManager=rm;
	}
	public void setDocument(Document doc)
	{
		this.document=doc;
	}
	public void setReplayManager(ReplayManager rm)
	{
		this.replayManager=rm;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Object[] poss = new Object[document.getContent().size()];
		for(int i=0;i<poss.length;i++)
		{
			poss[i]=i;
		}
		
		int ln = (int) JOptionPane.showInputDialog(
		                    ttsuview.getFrame(),
		                    "Choose line",
		                    "Line To Speech",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    poss,
		                    "0");

		
		// TODO Auto-generated method stub
		document.playLine(ln);
		replayManager.recordAction(this);
	}

}
