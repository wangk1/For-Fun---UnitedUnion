package attribute.fraction;

/**The Handler for everything fraction related.
 * 
 * <p>
 * 
 * 1. Handles hostility
 * <br>
 * 2. Handles and stores all fractions that the current fraction is part of
 * @author wangk1
 *
 */
public interface FractionManager {
	
	/**Set aggressor to be hostile to aggresse. But, NOT VICE VERSA
	 * 
	 * @param aggressor
	 * @param aggresse
	 */
	void setHostileTo(Fraction aggressor, Fraction target);
	
	/**Bidirectional hostility.
	 * <p>
	 * Make both aggressor and target hostile to each other
	 * 
	 * @param aggressor
	 * @param target
	 */
	void setBidirectionalHostile(Fraction aggressor, Fraction target);
	
	/**
	 * Reset the hostility between aggressor and target. Aggressor is no longer hostile to target.
	 * <br>
	 * However, target's hostility to aggressor is still unchanged
	 * 
	 * @param aggressor
	 * @param target
	 */
	void unsetHostileTo(Fraction aggressor, Fraction target);
	
	/**
	 * Make both aggressor and target not hostile to each other
	 * 
	 * @param aggressor
	 * @param target
	 */
	void unsetBidirectionalHostility(Fraction aggressor, Fraction target);
	
	boolean isHostileTo(Fraction aggressor, Fraction target);
	
}
