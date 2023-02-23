package model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTSFacade {
	VoiceManager vm;
	Voice voice;
	public int volume =1;
	public int pitch=100;
	public int rate=100;
	
	TTSFacade()
	{
	
	}
	
	void play(String a)
	{
		System.out.println("In Play");
		System.out.println("Volume bef "+volume);
		System.out.println("Pitch bef "+pitch);
		System.out.println("Rate bef "+rate);
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		Voice[] voice2;
		vm = VoiceManager.getInstance();
		voice2 = vm.getVoices();
        for (Voice voice1 : voice2) { //to see the available voices
            voice = voice1;
        }
        voice.setPitch(pitch);
        voice.setRate(rate);
        voice.setVolume(volume);
		if(voice!=null) {
			voice.allocate();
		}
		try {
			voice.speak(a);
			voice.deallocate();
		}
		catch(Exception e1){
			e1.printStackTrace(); 
		}
	}
	public void setVolume(int vol)
	{	System.out.println("Volume set from "+this.volume);
		this.volume=vol;
		System.out.println("Volume set to "+this.volume);
	}
	public void setPitch(int pit)
	{
		this.pitch=pit;
	}
	public void setRate(int rate)
	{
		this.rate=rate;
	}
	

}
