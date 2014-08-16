package mechanics;


import java.util.Observable;
import java.util.Scanner;

//Handles message printing and console inputs

//Based on KConsole

/****IMPORTANT****
 * INCLUDED FUNCTIONS:
 * 1.AbstractClass Filter to extend from for your Filter
 * 2.AbstractClass DECODER FOR DECODING READ IN MATERIAL
 * 
 * YOU MUST INSERT YOUR OWN DECODER INTO THE CONSTRUCTOR OR ELSE NO INPUT WILL BE READ IN, if no need for decorder
 * 	set it to null in constructor
 * 
 * MUST CALL SHUTDOWN TO ENSURE DATA INTEGRITY
 * 
 * The included enum for message level importance is also usable
 * 
 * Includes a completely open JTextbox implementation that you can edit at will
 */

/****HOW TO****
 * Call Constructor
 * Then call start
 * 
 */
public class KConsole{

	//THe input section

	//the decoder, if null, then 
	private volatile Decoder decoder;
	
	//Actiavte filter with static default filter
	private static Filter filter=new DefaultFilter(MessageLevel.DIAGNOSTIC);

	private InputThread inputThread;

	//is the console started?
	private boolean isStarted;

	//The JTextPane



	//TODO SETUP section

	public KConsole(Decoder d) {
		//Set decoder, run new thread for input if the thing is okay
		setDecoder(d);

	}

	//Starts the kconsole
	public void start() {
		
		isStarted=true;

		createNewInputThread(decoder);

	}

	//Starts the console input thread, must insert decoder for scanner
	private void createNewInputThread(Decoder d) {
		//if decoder exists

		if(d != null) {
			new Thread(inputThread=new InputThread()).start();
			KConsole.printMessage("KConsole: Decoder Set, Input Service Activated", MessageLevel.GENERAL);
			
		} else
			KConsole.printMessage("KConsole: Decoder Not Set, No Input Service", MessageLevel.IMPORTANT);

	}

	//Set New Decoder
	public void setDecoder(Decoder d) {

		//if null decoder entered
		
		if((decoder=d)==null) {
			setInputOn(false);
			KConsole.printMessage("KConsole: Couldn't Set Decoder", MessageLevel.IMPORTANT);
			return;

		}

		KConsole.printMessage("KConsole: New Decoder Recieved", MessageLevel.IMPORTANT);


	}

	//TODO utility functions

	//for querying from outside this class
	public boolean isOn() {
		return isStarted;

	}

	//for inner class check if console has started
	private boolean hasStarted() {
		if(!isStarted) {
			KConsole.printMessage("KConsole: Operation requires console starting", MessageLevel.IMPORTANT);
			return false; }

		return true;

	}

	//shutdown important object
	public void shutDown() {
		KConsole.printMessage("KConsole: Shutting Down", MessageLevel.IMPORTANT);
		
		if(!hasStarted()) 
			return; 

		if(inputThread != null)
			inputThread.shutDown();

	}

	//turn off input?
	public void setInputOn(boolean bool) {
		if(!hasStarted()) 
			return; 

		//turns off input
		if(inputThread != null && !bool) {
			inputThread.shutDown();
			inputThread=null;
			KConsole.printMessage("KConsole: Turning off Input", MessageLevel.GENERAL);

			//turn on input
		} else if(inputThread==null && bool) {
			createNewInputThread(decoder);
			KConsole.printMessage("KConsole: Turning on Input", MessageLevel.GENERAL);

		}

	}

	//change filter
	public static void setFilter(Filter f) {
		filter=f;

	}

	//set filter level
	public static void setFilterLevel(MessageLevel l) {
		filter.setFilterLevel(l);

	}



	//TODO PrintMessage Section

	public static void printMessage(String message, MessageLevel level) {
		if(filter.filter(level)) {

			//diff color depends on importance level
			if(level.getNumLevel()>=MessageLevel.SEVERE.getNumLevel())
				System.err.println(level.getLevel()+" "+message);
			else
				System.out.println(level.getLevel()+" "+message);
		}
	}
	
	//TODO Input Thread

	//Individual Thread for handling inputs
	private class InputThread implements Runnable{
		private volatile Scanner consoleInput;
		private volatile boolean inputOn;

		private InputThread() {
			consoleInput=new Scanner(System.in);
			inputOn=true;

		}

		//TODO Runnable, for input. Scanning and decoder

		@Override
		public void run() {
			String input;

			try{
				//Close the server from here
				while(inputOn && decoder != null && !(input=consoleInput.nextLine()).toLowerCase().equals("server.close")) {

					if(input != null)
						decoder.decode(input);

					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}

			} catch(IllegalStateException e) {
				KConsole.printMessage("InputThread: Scanner Closed", MessageLevel.DIAGNOSTIC);

			}
			//turn off the whole thing
			shutDown();
		}

		//closes everything
		private synchronized void shutDown() {
			//tells Bridge to shutdown
			KConsole.printMessage("InputThread: Shutting Down Input", MessageLevel.DIAGNOSTIC);
			consoleInput.close();
			
			decoder.decode("SERVER.Close");

		}

	}


	//TODO Filter Section

	//built in Default filter
	private static class DefaultFilter extends Filter{

		public DefaultFilter(MessageLevel filter) {
			super(filter);

		}

		@Override
		public boolean filter(MessageLevel level) {
			return super.filter(level);

		}

		@Override
		public void setFilterLevel(MessageLevel level) {
			this.filterlevel=level;

		}


	}
	
	public static void main(String[] args) {
		
		
	}


}


//TODO MessageFilter Interface

//Super Message Filter
//Extend this for own filter
abstract class Filter{
	public MessageLevel filterlevel;

	public Filter(MessageLevel filter) {
		if(filter==null)
			filterlevel=MessageLevel.GENERAL;

		filterlevel=filter;

	}

	public boolean filter(MessageLevel level) {
		return level.compareTo(filterlevel)>=0;

	}


	abstract public void setFilterLevel(MessageLevel level);

}


//TODO Decoder Interface
//THE DECODER

abstract class Decoder extends Observable{
	//ordinary handled in decoder, no output
	abstract void decode(String stringToDecode);

	//output values, specify the return type via class<T>
	abstract <T> T decode(String stringToDecode,Class<T> returnType);

}


//TODO MessageLevel ENUM


//the severity of the message
//5 levels, will display all levels with numerical values above
/*Diagnostic-Extra information, Displays all message and more
 *General-Recommended level, displays most normal messages
 *Warning-Potential problems or above
 *Severe-Crippling issue that does not halt the server
 *Fatal-Crippling issue that will result in intervention to halt the server only
 *
 *Important-Printed no matter what
 */

enum MessageLevel{
	DIAGNOSTIC("DIAGNOSTIC",-1),
	GENERAL("GENERAL",0),
	WARNING("WARNING",1),
	SEVERE("SEVERE",2),
	FATAL("FATAL",3),

	IMPORTANT("IMPORTANT",Integer.MAX_VALUE);

	private String level;
	private int numericallevel;

	private MessageLevel(String level, int numericallevel) {
		this.level=level;
		this.numericallevel=numericallevel;
	}

	public String getLevel() {
		return "Level "+level+":";

	}

	public int getNumLevel() {
		return numericallevel;

	}

}

