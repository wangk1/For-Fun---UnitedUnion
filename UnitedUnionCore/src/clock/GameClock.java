package clock;

//Generates clock for game
/**
 * This class does its best to emulate a game clock generator.
 * The clock is delegated to another class. The classes that implements GameLoop
 * 
 * 
 */


public class GameClock implements Clock{
	
	//inner class that actually loops
	private GameLoop loop;

	//constructor, takes in update per sec
	public GameClock(GameLoop loop) {
		this.loop=loop;

	}

	//TODO START METHOD, variable arguments
	//first insert the object
	//next insert the method in the form of string name that you want to invoke that is associated with the object

	public void startClock() {
		//starts the thread and the loop
		new Thread(loop).start();

	}

	//stops the game
	public void stopClock() {
		System.out.println("Clock Stopped");
		loop.stopLoop();

	}

	//restarts the previous clock
	public void restartClock() {
		if(loop != null) {
			System.out.println("Clock resetted");
			loop.resetLoop();
			//starts the thread
			new Thread(loop).start();

		}

	}

	//pause the game clock
	public void pauseClock() {
		System.out.println("Clock Paused");
		loop.pauseLoop();

	}

	//continues the game clock after locking
	public void continueClock() {
		if(loop.continueLoop()) {
			System.out.println("Clock recontinued successfully");
			
		} else {
			System.out.println("Clock recontinue issues");
			
		}

	}

	@Override
	public void setTickPerSecond(int numTicks) {
		loop.stopLoop();
		
	}

		
}
