package commands;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import output.*;
import view.TextToSpeechUserView;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import  model.Document;
public class SaveDocument implements ActionListener {
	Document document;
	ReplayManager replayManager;
	TextToSpeechUserView ttsuview;
	
	private JFileChooser fp ;
	String path;
	String type;
	String x;
	
	DocumentWriterFactory factoryW = new DocumentWriterFactory();
	public SaveDocument(TextToSpeechUserView ttsuview)
	{
		this.ttsuview=ttsuview;
		this.document=ttsuview.getDocument();
		this.path=document.getPath();
		fp  = new JFileChooser(path);
		this.x =document.getEncoding();
		
	}
	public SaveDocument(String path2, String type, String x) {
		this.path=path2;
		this.type=type;
		this.x=x;
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
		String[] options= {"AtBash","Rot13","No"};
		if(fp.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
		{	int op = JOptionPane.showOptionDialog(
	               ttsuview.getFrame(),
	               "Save with Encryption", 
	               "Choose",            
	               JOptionPane.YES_NO_CANCEL_OPTION,
	               JOptionPane.QUESTION_MESSAGE,null,
	               options,
	               options[0]);
			if(op==0)
			{
				this.x="atBash";
			}
			else if(op==1)
			{
				this.x="rot13";
			}
			else 
			{
				this.x="no";
			}
			System.out.println(x);
			document.setEncoding(x);
			path=fp.getSelectedFile().getAbsolutePath();
			System.out.println(path);
			System.out.println("In SaveDocument size"+document.getContent().size());
			//path = document.getPath();
			document.save(path,path.substring(path.lastIndexOf("."), path.length()) );
			
		}
		ttsuview.getReplayManager().recordAction(this);
	}
	

}
