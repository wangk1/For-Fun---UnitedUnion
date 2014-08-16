package events;

/**
 * Event is mutable.
 * 
 */
public class MutableEventImpl<T> extends EventImpl<T> {
	private String name;
	//this value will mask the super value when set
	private T value;
	
	//TODO Overloaded constructors
	
	public MutableEventImpl(T value) {
		this(value,null,null);
		
	}
	
	public MutableEventImpl(T value,Object source) {
		this(value,null,source);
		
	}
	
	public MutableEventImpl(T value, String name,Object source) {
		super(value,source);
		
		this.name= (name==null? "Anonymous":name);
	}

	@Override
	public void setValue(T value) {
		this.value=value;
		
	}

	@Override
	public void setName(String s) {
		this.name=s;
		
	}

	@Override
	public String getName() {
		return name;
		
	}
	
	//Alternative value method
	@Override
	public T getValue() {
		if(this.value != null) {
			return value;
			
		}
		
		return super.getValue();
	}
}
