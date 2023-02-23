package commands;

import view.TextToSpeechUserView;
import java.awt.event.ActionListener;




public class CommandsFactory {
	private TextToSpeechUserView ttsuview;
	private SaveDocument saveDocument;
	private ReplayCommand replayCommand;
	private OpenDocument openDocument;
	private EditDocument editDocument;
	private LineToSpeech lineToSpeech;
	private DocumentToSpeech documentToSpeech;
	private RecordingEnder recend;
	private RecordingStarter recst;
	private TuneVoice tunev;
	private TunePitch tunep;
	private TuneRate tuner;
	

	public CommandsFactory(TextToSpeechUserView ttsuview) 
	{
		
		this.ttsuview=ttsuview;
		
	}
	
	public ActionListener createCommand(String x) {
		if(x.equalsIgnoreCase("save")) {
			saveDocument = new SaveDocument(ttsuview);
			return saveDocument;
		}else if(x.equalsIgnoreCase("open")) {
			openDocument = new OpenDocument(ttsuview);
			return openDocument;
		}else if(x.equalsIgnoreCase("edit")) {
			editDocument = new EditDocument(ttsuview);
			return editDocument;
		
		}else if(x.equalsIgnoreCase("lineToSpeech")) {
			lineToSpeech = new LineToSpeech(ttsuview);
			return lineToSpeech;
		}else if(x.equalsIgnoreCase("play")) {
			documentToSpeech = new DocumentToSpeech(ttsuview);
			return documentToSpeech;
		}else if(x.equalsIgnoreCase("playline")) {
			lineToSpeech = new LineToSpeech(ttsuview);
			return lineToSpeech;
		}else if(x.equalsIgnoreCase("tunev")) {
			tunev= new TuneVoice(ttsuview);
			return tunev;
		}else if(x.equalsIgnoreCase("tunep")) {
			tunep = new TunePitch(ttsuview);
			return tunep;
		}else if(x.equalsIgnoreCase("tuner")) {
			tuner = new TuneRate(ttsuview);
			return tuner;
		}else if(x.equalsIgnoreCase("recst")) {
			recst = new RecordingStarter(ttsuview);
			return recst;
		}else if(x.equalsIgnoreCase("recen")) {
			recend = new RecordingEnder(ttsuview);
			return recend;
		
		}else if(x.equalsIgnoreCase("replay")) {
			replayCommand = new ReplayCommand(ttsuview);
			return replayCommand;
		}
		return null;
		
	}

}
