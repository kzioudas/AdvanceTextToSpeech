package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;




import  model.Document;
import view.TextToSpeechUserView;
public class OpenDocument implements ActionListener {
	Document document;
	ReplayManager replayManager = new ReplayManager();
	String path;
	public String type;
	String x;
	private JFrame frame;
	private JFileChooser fp = new JFileChooser("C:");
	public JTextArea textAreaOpen;
	
	
	TextToSpeechUserView ttsuview;
	public OpenDocument(TextToSpeechUserView ttsuview)
	{
		this.ttsuview=ttsuview;
		this.frame=ttsuview.getFrame();
		this.document=ttsuview.getDocument();
		this.replayManager=ttsuview.getReplayManager();
		
		frame.getContentPane().removeAll();
		frame.repaint();
		textAreaOpen = new JTextArea();
		textAreaOpen.setBounds(10, 11, 300, 200);
		document.setJTextArea(textAreaOpen);
		textAreaOpen.setText("");
		frame.add(textAreaOpen);
		JScrollPane scrollpane = new JScrollPane(textAreaOpen, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		frame.add(scrollpane);
		textAreaOpen.setEditable(false);
		this.x ="no";
	}
	
	public OpenDocument(String path2, String type, String x,TextToSpeechUserView ttsuview) {
		this.path=path2;
		this.type=type;
		this.x=x;
		this.ttsuview=ttsuview;
		
	}
	void editable()
	{
		textAreaOpen.setEditable(true);
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
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object[] options= {"AtBash","Rot13","No"};
		if(fp.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
		{	int op = JOptionPane.showOptionDialog(
	               frame,
	               "If encoded Input AtBash ,Rot13 else Input No", 
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
			System.out.println("enc: "+x);
			System.out.println("op: "+op);
	        document.setEncoding(x); 
			String path =fp.getSelectedFile().getAbsolutePath();
			this.path=path;
			document.open(path,path.substring(path.lastIndexOf("."), path.length()) , x);
			int k=0;
			for(int i=0;i<document.getContent().size();i++)
			{
				textAreaOpen.append(document.getContent().get(i)+"\n");
			}
			List<String> con = new ArrayList<String>();
			for (String line : textAreaOpen.getText().split("\\n"))
        	{	System.out.println(line);
        		con.add(k,line);
        		
        		k++;
        	}
        	document.setContents(con);
					
			textAreaOpen.requestFocus();
		
		}
		
		replayManager.recordAction(this);
	}

}
