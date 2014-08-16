package events;

/**
 * Basic interface that describe the most basic events.
 * 
 * Very Basic, can only store the type of the value of event and the value itself.
 * 
 * The event automatically becomes dead once it has been fired.
 * 
 * @author wangk1
 *
 * @param <Type>
 */
public interface BasicEvent<Type> {
	
	/**
	 * Return the class of the type of the event
	 * 
	 * IE. if Event<Boolean>, then type returned is the Boolean class
	 * @return
	 */
	Class<?> getType();
	
	/**
	 * Set the value of the event
	 * 
	 * @param value
	 */
	Type getValue();
	
	/**
	 * Grabs the unique serial for this event
	 * 
	 * @return
	 */
	int getSerial();
	
	/**
	 * Kills the event and make it inactive
	 * 
	 */
	@Deprecated
	void killEvent();
	
	/**
	 * Returns true if event is still alive. Returns false if it is not
	 * 
	 */
	boolean isAlive();
	
	/**
	 * 
	 * @param event
	 * @param subClassLinking
	 * @return
	 */
	<EType> boolean equalsEvent(BasicEvent<EType> event, boolean... subClassLinking);
	
	
}
