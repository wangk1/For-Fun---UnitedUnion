package attribute;

/**
 * The most basic of all attributes, not meant to be used as a normal type
 * 
 * @author wangk1
 *
 */
public interface BaseAttribute<CodeType> extends Cloneable{
	/**Get the Name of the attribute
	 * 
	 */
	String getName();
	
	/**
	 * get the code representation of the attribute
	 * 
	 */
	public String toString();
	
	/**Clone, probably a good idea to override
	 * 
	 * @return
	 */
	BaseAttribute<CodeType> clone();
	
	/**
	 * Get the unique code representation of the current attribute.
	 * For each attribute object type, such as HP, there is only
	 * 1 code common to all the HP attribute instances.
	 * <p>
	 * 
	 * For fractions, the code is a unique string identifier for the fraction
	 * @return
	 */
	public CodeType getCode();

}
