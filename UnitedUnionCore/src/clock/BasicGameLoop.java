package clock;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BasicGameLoop implements GameLoop{

	//controls the start and end of game, atomic boolean so that no concurrency error occurs
	private volatile AtomicBoolean gameStarted;

	private int updatesPerSec;

	//lock
	private volatile Lock lock;


	/**Constructor, takes in number of updates(or tick) generated per second*/
	public BasicGameLoop(int updatePerSec) {
		gameStarted=new AtomicBoolean(true);

		this.updatesPerSec=updatePerSec;

		lock=new ReentrantLock();

	}

	//the clock started
	@Override
	public void run() {
		long startTime=System.currentTimeMillis();
		//how long of time between each update
		long updateInterval=1000/updatesPerSec;

		//number of methods put into the class that has to be updated each tick



		//clock loop
		while(gameStarted.get()) {
			//lock the lock before each update
			lock.lock();
			if(System.currentTimeMillis()-startTime>(updateInterval)) {
				//resets start time
				startTime=System.currentTimeMillis();

				

				//resets start time
				startTime=System.currentTimeMillis();
			}
			//free the lock, so other threads can pause the loop
			lock.unlock();

		}

	}

	//stops the game
	public void stopLoop() {
		gameStarted.set(false);

	}

	//reset the clock
	public void resetLoop() {
		gameStarted.set(true);

	}

	//locks the lock, the loop pauses
	public void pauseLoop() {
		lock.lock();


	}

	//unlocks the lock, the loop continues
	public boolean continueLoop() {
		try{
			lock.unlock();

		} catch( IllegalMonitorStateException e) {
			return false;

		}

		return true;

	}
}
