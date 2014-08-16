package events;

public class ImmutableEventImpl<T> extends EventImpl<T> {
	private final String name;
	
	//TODO Constructors
	
	public ImmutableEventImpl(T value,String name,Object source) {
		super(value);
		this.name= (name==null? "Anonymous":name);
		
	}
	
	public ImmutableEventImpl(T value,String name) {
		this(value,name,null);
		
	}
	
	public ImmutableEventImpl(T value) {
		this(value,null,null);
		
	}

	//unimplemented
	@Override
	public void setValue(T value) {}

	//unimplemented
	@Override
	public void setName(String s) {}

	@Override
	public String getName() {
		return name;
		
	}

	@Override
	public String toString() {
		return "Immutable Event: "+this.name+"; "+" value type: "+super.getValue().getClass().getSimpleName();
		
	}

}
