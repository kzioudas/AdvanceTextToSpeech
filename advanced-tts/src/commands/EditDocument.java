package commands;

import java.awt.event.ActionEvent;

import model.Document;
import view.TextToSpeechUserView;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JFrame;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class EditDocument implements ActionListener {
	Document document;
	ReplayManager replayManager;
	TextToSpeechUserView ttsuview;
	public JTextArea textAreaOpen;
	private JFrame frame;
	List<String> con = new ArrayList<String>();
	public EditDocument(TextToSpeechUserView ttsuview)
	{
		
		
		this.ttsuview=ttsuview;
		this.frame=ttsuview.getFrame();
		this.document=ttsuview.getDocument();
		this.replayManager=ttsuview.getReplayManager();
		
		
		textAreaOpen = new JTextArea();
		textAreaOpen.setBounds(10, 11, 300, 200);
		

	}
	public EditDocument(TextToSpeechUserView ttsuview,String test)
	{
		
		
		this.ttsuview=ttsuview;
		this.frame=ttsuview.getFrame();
		this.document=ttsuview.getDocument();
		this.replayManager=ttsuview.getReplayManager();
		
		
		textAreaOpen = new JTextArea();
		textAreaOpen.setBounds(10, 11, 300, 200);
		frame.add(textAreaOpen);

	}
	void setDocument(Document doc)
	{
		this.document = doc;
	}
	public Document getDocument()
	{
		return document;
	}
	void setReplayManager(ReplayManager rm)
	{
		this.replayManager = rm;
	}
	public void contref()
	{
		con.clear();
		int j=0;
		for (String line : document.getJTextArea().getText().split("\\n"))
		{	
			
				con.add(j,line);
				
			
			j++;
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
		System.out.println("in edit size cont"+document.getContent().size());
		
		document.getJTextArea().setEditable(true);
		document.getJTextArea().getDocument().addDocumentListener(new DocumentListener() {

	        @Override
	        public void removeUpdate(DocumentEvent e) 
	        {
	        	contref();
	        }

	        @Override
	        public void insertUpdate(DocumentEvent e) 
	        {
	        	contref();
	        }
	        
	        @Override
	        public void changedUpdate(DocumentEvent arg0) {

	        }
	    });
		document.setContents(con);
		System.out.println("in edit size after cont"+document.getContent().size());
		replayManager.recordAction(this);
		
	}

}
