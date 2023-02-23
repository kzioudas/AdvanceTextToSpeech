package commands;


import java.awt.event.ActionEvent;

import model.Document;
import view.TextToSpeechUserView;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

public class TunePitch implements ActionListener{
	Document document;
	ReplayManager replayManager;
	TextToSpeechUserView ttsuview;
	public TunePitch(TextToSpeechUserView ttsuview)
	{
		this.ttsuview=ttsuview;
		this.document=ttsuview.getDocument();
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
		JSlider pit = new JSlider(0,200);
		JOptionPane optionPane = new JOptionPane();
		optionPane.setMessage(new Object[] { "Select a value: ", pit });
		optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
		JDialog dialog = optionPane.createDialog(ttsuview.getFrame(), "TunePitch");
		dialog.setVisible(true);
		pit.setMajorTickSpacing(200);
		pit.setPaintTicks(true);
		pit.setPaintLabels(true);
		pit.getValue();
		int i =pit.getValue();
		document.getTTSF().setPitch(i);
		replayManager.recordAction(this);
	}

}
