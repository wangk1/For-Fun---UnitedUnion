package clock;

public interface GameLoop extends Runnable{

	//stops the game
	public void stopLoop();

	//reset the clock
	public void resetLoop();

	//locks the lock
	public void pauseLoop();

	//unlocks the lock
	public boolean continueLoop();
	
}
