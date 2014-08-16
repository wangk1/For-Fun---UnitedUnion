package ai;

/**
 * Observable side of a observer-observable relation.
 * <p>
 * This observable is mostly for the AI processing loop. Allowing for registration of an observer
 * that can observe the move that the AI made.
 * 
 * @author wangk1
 *
 */
public interface MoveObservable {

	/**
	 * Register a move observer with the current observable, most likely a class of the AI family.
	 * <p>
	 * Whenever the MoveObservable makes a move, the observer will be notified. In this case, the controller will be notified and 
	 * any ramification of the move will be dealt.
	 * 
	 * @param The Observer
	 */
	public void registerMoveObserver(MoveObserver o);
	
}
