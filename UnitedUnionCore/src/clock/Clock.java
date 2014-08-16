package clock;

/**
 * The most basic interface detailing the game clock. Most beneficial if the clock is multithreaded.
 * 
 * @author wangk1
 *
 */
public interface Clock {
	
	/**Starts the clock*/
	void startClock();
	
	/**Pause the clock. All normal activities will be ceased.*/
	void pauseClock();
	
	/**Restart the game clock.*/
	void restartClock();
	
	/**Completely stop the clock*/
	void stopClock();
	
	/**The clock will undergo numTicks cycles per second*/
	void setTickPerSecond(int numTicks);
}
