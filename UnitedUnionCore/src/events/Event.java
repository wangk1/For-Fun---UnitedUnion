package events;

/**
 * The Event type, built on top of basic event. It serves as an extension.
 * Can have 2 implementations, MutableEventImpl and ImmutableEventImpl.
 * 
 * @author wangk1
 *
 */
public interface Event<T> extends BasicEvent<T>{
	
	
	/**
	 * Set value of the event. Only supported in MutableEventImpl and subclass. 
	 * Not supported by ImmutableEventImpl and subclass
	 * 
	 * @param value
	 */
	void setValue(T value);
	
	/**
	 * Set source of the event. Supported in both mutable and immutable event implementations.
	 * However, this is only settable for immutable events one time.
	 * 
	 * @param source
	 */
	void setSource(Object source);
	
	/**
	 * Make the event alive or not. Not supported by immutable event impl
	 * 
	 * @param alive
	 */
	void setIsAlive(boolean alive);
	
	/**
	 * Set the name of the event. Will be used in toString
	 * 
	 */
	void setName(String s);
	
	/**
	 * Grabs the name of the event
	 * 
	 */
	String getName();
	
	/**
	 * Get Source of the event. May be null if not set.
	 * 
	 * @return null or event handler
	 * 
	 */
	Object getSource();
	
	@Override
	boolean isAlive();
	
}
