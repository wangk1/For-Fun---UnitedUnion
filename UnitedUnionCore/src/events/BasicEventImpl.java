package events;

import annotations.SubEvent;

/**An implementation of {@link BasicEvent}. 
 * 
 * @author wangk1
 * @since JDK8(JRE 1.8)
 * @param <Type>
 */
@SubEvent({EventImpl.class})
public class BasicEventImpl<Type> implements BasicEvent<Type>{
	private Type value;
	private boolean alive;
	
	
	//event serial derived from the eventCounter integer in Event interface
	private final int serial;
	 //counter that grants a serial to each event instance
	private static int eventCounter=0;
	
	public BasicEventImpl(Type value) {
		this.value=value;
		this.alive=true;
		this.serial=eventCounter++;
	}
	
	/**
	 * Returns the unique serial number of this event
	 * 
	 */
	@Override
	public final int getSerial() {
		return serial;
		
	}
	
	/**
	 * Returns class of the event value
	 * 
	 */
	@Override
	public Class<?> getType() {
		return value.getClass();
	}

	/**
	 * Returns value of the event.
	 * 
	 */
	@Override
	public Type getValue() {
		return value;
	}
	
	/**
	 * Make the event inactive
	 * 
	 * 
	 */
	public void killEvent() {
		this.alive=false;
		
	}

	/**
	 * Is the event still alive?
	 * 
	 */
	@Override
	public boolean isAlive() {
		return alive;
		
	}
	
	/**Special equals that compares 2 events to see if they are the same.
	 * <p>
	 * An Additional Functionality is that events that are subclasses of each other can be set so that the subclass is equal to the super
	 * event, but not vice versa.
	 * <br>
	 * WARNING: Using this method may result in heavy penalty if the super and subclass are far away
	 * <p>
	 * 
	 * @param Event that will be treated as super
	 * @param Boolean vararg. 
	See {@link BasicEvent} */
	@Override
	public <EType> boolean equalsEvent(BasicEvent<EType> event,
			boolean... subClassLinking) {
		//First check if same class, if same then true
		if(event.getClass().isInstance(this.getClass())) {
			return true;
			
		}
		
		/*
		 * If not instance of same class past this point
		 */
		
		
		//If subclass linking allowed
		if(subClassLinking.length==1? subClassLinking[0]:false) {
				
			//first check if the current class is a subclass of the parameter event
			if(event.getClass().isAssignableFrom(this.getClass())) {
				return true;
			
				//check if the passed in class have annotations
			} else {
				SubEvent e;
				
				//grab the annotation SubEvent
				if((e=event.getClass().getAnnotation(SubEvent.class)) != null) {
					
					for(Class<?> c: e.value()) {
						
						//now check if the two classes are the same
						//or if the class in e.value is a super of the current class
						if(c.getClass().isAssignableFrom(this.getClass())) {
							return true;
							
						} else {
							
							
						}
						
					}
					
					
				}
				
			}
			
		}
		
		return false;
	}
	
	
}
