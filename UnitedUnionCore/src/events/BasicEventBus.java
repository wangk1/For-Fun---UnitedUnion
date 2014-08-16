package events;

/**A Simple implementation of the eventbus. Only Contains Vanilla Classes
 * Can only use events that have super type of BasicEventImpl
 * 
 * @author wangk1
 *
 */
public class BasicEventBus implements EventBus{
	private BasicEventBus() {
		
		
	}
	
	
	
	
	/**
	 * Return a basic event bus instance. Can have many copies
	 * 
	 * @return
	 */
	public static BasicEventBus getInstance() {
		return new BasicEventBus();
		
	}
	
}
