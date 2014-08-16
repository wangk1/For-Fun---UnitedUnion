package attribute;

/**
 * Used by AttributeHandler to instantiate new instance. 
 * Usually not used directly outside of attribute handler class
 * 
 * Implements Attribute Interface
 */
public class AttributeImpl extends BaseAttributeImpl<Integer> implements Attribute {
	private String aliase;
	
	private int amount;
	
	//TODO CONSTRUCTORS
	AttributeImpl(String name, String aliase, int amount, int code) {
		super(name,code);
		
		this.amount=amount;
		
		this.aliase=aliase;
		
	}
	
	AttributeImpl(String name, int amount, int code) {
		this(name,null,amount,code);
		
	}

	//TODO METHODS
	
	@Override
	public void setAliase(String aliase) {
		this.aliase=aliase;
		
	}

	@Override
	public String getName() {
		return aliase==null? super.getName():aliase;
		
	}

	@Override
	public void setAmount(int amount) {
		this.amount=amount;
		
	}

	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public void incrementOrDecrement(int amount) {
		this.amount=+ amount;
		
	}
	
	/**
	 * Make a deep copy of the attribute
	 * 
	 * COPIES EVERYTHING, excluding the aliase. It is defaulted to null
	 */
	@Override
	public Attribute clone() {
		return new AttributeImpl(this.getName(),amount,this.getCode());
		
	}
	
	/**
	 * Special to string
	 * 
	 */
	@Override
	public String toString() {
		return "Attribute: "+super.getName()+"; Attribute Aliase: "+aliase+ "; Attribute amount: "+amount+"; Attribute code: "+this.getCode();
		
	}

}
