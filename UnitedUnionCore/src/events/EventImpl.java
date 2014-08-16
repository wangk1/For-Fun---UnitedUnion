package events;

/**
 * Implementation of the Event Interface, used to contain the common methods that MutableEventImple and ImmutableEventImpl have
 * 
 * @author wangk1
 *
 */
public abstract class EventImpl<Type> extends BasicEventImpl<Type> implements Event<Type>{
	private Object source;
	private boolean isAlive;
	
	//TODO Overloaded Constructors
	public EventImpl(Type value,Object source) {
		super(value);
		
		this.source=source;
		this.isAlive=true;
	}
	
	public EventImpl(Type value) {
		this(value,null);
		
	}

	@Override
	public abstract void setValue(Type value);

	@Override
	public void setSource(Object source) {
		this.source=source;
		
	}
	
	@Override
	public void setIsAlive(boolean alive) {
		this.isAlive=alive;
		
	}
	
	@Override
	public boolean isAlive() {
		return this.isAlive;
		
	}

	@Override
	public abstract void setName(String s);

	@Override
	public abstract String getName();

	@Override
	public Object getSource() {
		return source;
		
	}
	
}
