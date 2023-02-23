package view;

import java.awt.Font;
import java.awt.Cursor;

import commands.CommandsFactory;
import commands.ReplayManager;
import model.Document;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;


import javax.swing.*;

public class TextToSpeechUserView extends JFrame {


	Document doc = new Document();
	ReplayManager replayManager = new ReplayManager();
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JButton edit,replay;
	JMenuBar menuBar;
	JMenu file, tune, play, record, help;
	JMenuItem open,save, exit, playline, playall, tunePitch, tuneVolume, tuneRate,startRec,endRec;
	JFileChooser fileChooser;
	public JTextArea textArea;
	JScrollPane scrollpane;
	Clipboard clip ;
	CommandsFactory cfactory=new CommandsFactory(TextToSpeechUserView.this);
	
	public TextToSpeechUserView() 
	{
		frame = new JFrame("Advanced Text To Speech Editor");
		file = new JMenu("File");
		edit = new JButton("Edit");
		tune = new JMenu("Tune");
		help = new JMenu("Help");
		play = new JMenu("Play");
		record = new JMenu("Record");
		replay = new JButton("Replay");
		
		open = new JMenuItem("Open");		
		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		playline = new JMenuItem("Play Line");
		playall = new JMenuItem("Play All");
		tuneVolume = new JMenuItem("Volume");
		tunePitch = new JMenuItem("Pitch");
		tuneRate = new JMenuItem("Rate");
		textArea = new JTextArea();
		fileChooser = new JFileChooser();
		menuBar = new JMenuBar();
		startRec=new JMenuItem("Start Recording");
		endRec=new JMenuItem("End Recording");
		
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Font menu = new Font("Tahoma", Font.BOLD, 16);
		Font menuitem = new Font("Tahoma", Font.PLAIN, 16);
		
		Cursor c = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		
		file.setFont(menu);
		file.setCursor(c);
		edit.setFont(menu);
		edit.setCursor(c);
		tune.setFont(menu);
		tune.setCursor(c);
		help.setFont(menu);		
		help.setCursor(c);
		replay.setFont(menu);
		replay.setCursor(c);
		open.setFont(menuitem);
		open.setCursor(c);
		
		save.setFont(menuitem);
		save.setCursor(c);
		exit.setFont(menuitem);
		exit.setCursor(c);
		play.setFont(menu);
		play.setCursor(c);
		record.setFont(menu);
		record.setCursor(c);
		startRec.setFont(menuitem);
		startRec.setCursor(c);
		endRec.setFont(menuitem);
		endRec.setCursor(c);
		playline.setFont(menuitem);
		playline.setCursor(c);
		playall.setFont(menuitem);
		playall.setCursor(c);
		tuneVolume.setFont(menuitem);
		tuneVolume.setCursor(c);
		tunePitch.setFont(menuitem);
		tunePitch.setCursor(c);
		tuneRate.setFont(menuitem);
		tuneRate.setCursor(c);
		
        frame.add(textArea);
		file.add(open);
		
		file.add(save);
		file.add(exit);
		play.add(playline);
		play.add(playall);
		tune.add(tuneVolume);
		tune.add(tunePitch);
		tune.add(tuneRate);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(play);
		menuBar.add(record);
		menuBar.add(replay);
		menuBar.add(tune);
		menuBar.add(help);
		record.add(startRec);
		record.add(endRec);
		frame.setJMenuBar(menuBar);
		
		scrollpane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		frame.add(scrollpane);
		
	
		ExitListener exitL = new ExitListener();
		tuneVolume.addActionListener(cfactory.createCommand("tunev"));
		tuneRate.addActionListener(cfactory.createCommand("tuner"));
		tunePitch.addActionListener(cfactory.createCommand("tunep"));
		
		
		edit.addActionListener(cfactory.createCommand("edit"));
		open.addActionListener( cfactory.createCommand("open"));
		
		save.addActionListener(cfactory.createCommand("save"));
		playall.addActionListener(cfactory.createCommand("play"));
		playline.addActionListener(cfactory.createCommand("playline"));
		startRec.addActionListener(cfactory.createCommand("recst")); 
		endRec.addActionListener(cfactory.createCommand("recen"));
		replay.addActionListener(cfactory.createCommand("replay"));
		exit.addActionListener(exitL);
		frame.setBounds(300, 200, 800, 600);
		frame.setVisible(true);
	}
	
	
	class ExitListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		TextToSpeechUserView newTTSUV = new TextToSpeechUserView();
		
	}
	
	public JFrame getFrame() 
	{
		return frame;
	}
	public Document getDocument() 
	{
		return this.doc;
	}
	public ReplayManager getReplayManager()
	{
		return this.replayManager;
	}
	public void setDocument()
	{
		this.doc = new Document();
	}
	
}