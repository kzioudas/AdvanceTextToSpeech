package model;


import input.*;
import output.*;

import java.util.List;

import javax.swing.JTextArea;
public class Document {
	List<String> contents;
	List<String> savecontents;
	DocumentWriter documentWriter;
	DocumentWriterFactory docWriterFactory=new DocumentWriterFactory();
	DocumentReader documentReader;
	DocumentReaderFactory docReaderFactory = new DocumentReaderFactory();
	TTSFacade tts = new TTSFacade(); 
	JTextArea textAreaOpen;
	String path;
	String type;
	String enc;
	public Document()
	{}
	public void setPath(String path)
	{
		this.path=path;
	}
	
	public void  setContents(List<String> contents)
	{
		this.contents=contents;
		System.out.println("size of cont in setcont "+this.contents.size());
		this.savecontents=contents;
	}
	void setAudioManager(TTSFacade fac)
	{
		this.tts=fac;
	}
	public void DocReaderFactory(DocumentReaderFactory docReFac)
	{
		this.docReaderFactory=docReFac;
	}
	void DocWriterFactory(DocumentWriterFactory docWrFac)
	{
		this.docWriterFactory=docWrFac;
	}
	public TTSFacade getTTSF()
	{
		return this.tts;
	}
	public void setJTextArea(JTextArea textAreaOpen)
	{
		this.textAreaOpen=textAreaOpen;
	}
	public JTextArea getJTextArea()
	{
		return this.textAreaOpen;
	}
	public String getType()
	{
		return type;
	}
	public void open(String path,String type,String info)
	{	System.out.println("path: "+path+"\n"+"type: "+type);
		if(contents!=null)
		{contents.clear();
		
		}
		documentReader=docReaderFactory.createReader(path,type,info);
		
		this.path=path;
		this.type=type;
		this.contents =documentReader.read();
		
	}
	public void playContents()
	{
		StringBuilder strbul=new StringBuilder();
        for(String str : contents)
        {
            strbul.append(str);
            //for adding comma between elements
            strbul.append(" ");
        }
        
        String str=strbul.toString();
		tts.play(str);
	}
	public void playLine(int ln)
	{
		tts.play(contents.get(ln));
	}
	public void save(String path,String type)
	{	System.out.println(enc);
		documentWriter=docWriterFactory.createWriter(path,type,enc,this.savecontents);
		documentWriter.write();
		contents.clear();
	}

	public String getPath() {
		return path;
		
	}
	public List<String> getContent() {
		
		return this.contents;
	}
	public void setEncoding(String enc) {
		
		this.enc=enc;
	}
	public String getEncoding() {
		
		return enc;
	}

}
