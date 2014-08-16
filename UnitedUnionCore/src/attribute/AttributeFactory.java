package attribute;

import java.util.HashMap;

/**The Attribute Factory handles all the attributes.
 * 
 * The Attribute Factory must be first created with calls to createNewAttributeFactory. 
 * 
 * Then, with the returned AttributeFactory instance, new attributes can be registered for all classes to use. 
 * See createAttribute Method Javadocs for creating new attribute instructions.
 * 
 * This is a singleton.
 * 
 */
public class AttributeFactory{
	//The keycode generator
	private static int keycode=0;
	
	//the only factory instance, a singleton
	private static AttributeFactory factory;
	

	//uses String to getAttribute
	private HashMap<String, AttributeImpl> attributes;

	//Uses Attribute code instead to get attribute, may be faster
	private HashMap<Integer, AttributeImpl> attributesFromCode;
	
	//TODO Constructor
	private AttributeFactory() {
		//creates everything
		attributes=new HashMap<String,AttributeImpl>();
		attributesFromCode=new HashMap<Integer,AttributeImpl>();
	}


	//TODO METHODS
	
	
	/**
	 * Create an attribute with name name. DOES NOT RETURN, use createandget for create and get
	 * 
	 * This attribute will be avaliable to all class, instances are returned by calling getNewAttributeInstance
	 * 
	 * @param Name
	 */
	public void createAttribute(String name) {
		
		//put the attribute in the hashmap
		AttributeImpl n=new AttributeImpl(name,0,keycode++);
		
		attributes.put(name, n);
		attributesFromCode.put(n.getCode(), n);

	}

	/**
	 * Create a new attribute instance of existing attribute with the name name and amount of attribute amount.
	 * 
	 * createAttribute MUST BE called first to have the attribute with name name avaliable.
	 * 
	 * @param name
	 * @param amount
	 * @return null if createAttribute has not been called for the attribute with Name
	 */
	public Attribute getNewAttributeInstanceFromName(String name, int amount) {

		Attribute r=attributes.get(name);

		if(r != null) {
			r=r.clone();

			r.setAmount(amount);

		}

		return r;

	}
	
	/**
	 * Create a new attribute instance of existing attribute with the code integer and amount of attribute amount.
	 * 
	 * createAttribute MUST BE called first to have the attribute with code avaliable.
	 * 
	 * @param code
	 * @param amount
	 * @return null if createAttribute has not been called for the attribute with Name
	 */
	public Attribute getNewAttributeInstanceFromCode(int code, int amount) {

		Attribute r=attributesFromCode.get(code);

		if(r != null) {
			r=r.clone();

			r.setAmount(amount);

		}

		return r;

	}

	/**
	 * Register a new attribute and grab an instance of the attribute
	 * 
	 * @param name
	 * @param amount
	 * @return
	 */
	public Attribute createAndGetNewAttributeInstance(String name, int amount) {
		
		//create attribute instance if not exists
		if(attributes.get(name) == null) {
			//put the attribute in the hashmap
			AttributeImpl n=new AttributeImpl(name,0,keycode++);
			
			attributes.put(name, n);
			attributesFromCode.put(n.getCode(), n);
			
		}
		
		//make a clone
		return attributesFromCode.get(AttributeFactory.keycode-1).clone();

	}
	
	/**
	 * Create a new attribute factory instance, the only one that will be avaliable
	 * 
	 * @return an attributefactory instance
	 */
	public static AttributeFactory createNewAttributeFactory() {
		if(factory == null) {
			factory=new AttributeFactory();
			
		}
		
		return factory;
	}
	
	/**
	 * Get the currently available AttributeFactory sington instance. A new one is created if null
	 * 
	 * @return an AttributeFactory Instance
	 */
	public static AttributeFactory getAttributeFactory() {
		return createNewAttributeFactory();
		
	}
	
}
