package attribute;
/**
 * Interface representing the entity attributes
 * 
 * Properties
 * Name can only be set once. Aliase can be set multiple times
 * Code is only set once by AttributeFactory
 * */
public interface Attribute extends BaseAttribute<Integer> {
	
	/**
	 * Set Aliase for the attribute, a temporary name
	 * Take away by calling this method with null
	 */
	public void setAliase(String aliase);

	/**Get the Name of the attribute
	 * If aliase is set, this method will return aliase instead. 
	 * Consult setAliase method javadoc for more info.
	 */
	@Override
	public String getName();
	
	
	
	/**
	 * Set the amount of this attribute an entity currently has
	 * 
	 */
	public void setAmount(int amount);
	
	/**
	 * 
	 * Get the amount of the attribute the entity currently has
	 **/
	public int getAmount();
	
	/**
	 * Increment/Decrement the current attribute by x amount
	 * Use negative numbers for decrement
	 */
	public void incrementOrDecrement(int amount);
	
	/**
	 * Clone the attribute, overrides the super interface
	 * BaseAttribute's clone() method
	 * 
	 */
	
	
	@Override
	public Attribute clone();
	
	
}
