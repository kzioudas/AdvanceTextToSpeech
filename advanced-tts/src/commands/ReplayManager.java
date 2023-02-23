package commands;

import java.util.ArrayList;
import java.awt.event.ActionListener;
public class ReplayManager {
	boolean recordingStatus;
	public boolean test=false;
	ArrayList<ActionListener> actions = new ArrayList<>();
	public ReplayManager()
	{
		
	}
	void replay()
	{
		
		System.out.println("Action List size: "+actions.size());
		System.out.println(actions.size());
		for(int i = 0; i < actions.size(); i++) 
		{
			 actions.get(i).actionPerformed(null); 
		}
	}
	public void startRecording()
	{
		recordingStatus=true;
		System.out.println("Started Recording Actions");
	}
	public void test()
	{
		this.test=true;
	}
	public void endRecording()
	{
		recordingStatus=false;
		System.out.println("Stop Recording Actions");
	}
	boolean isActiveRecording()
	{
		return recordingStatus;
	}
	public void recordAction(ActionListener action)
	{
		if(isActiveRecording()) 
		{
			actions.add(action);
		}
		else
		{
			System.out.println("Recorder Disabled");
		}
	}
}
