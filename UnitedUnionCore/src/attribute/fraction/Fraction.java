package attribute.fraction;

import java.util.Collection;

import exceptions.MaxSubFractionNumberExceeded;
import attribute.BaseAttribute;

public interface Fraction extends BaseAttribute<String>{
	
	/**Set the code of fraction*/
	public void setCode(String code);
	
	
	/**Get the parent of the current fraction*/
	public Fraction getParent();
	
	
	/**Set the parent of the current fraction*/
	public void setParent(Fraction f);
	
	
	/**
	 * Check if the fraction denoted by the code is a subfraction of the current fraction
	 * <p>
	 * 
	 * A subfraction DOES NOT have to be a direct subfraction of this fraction. It can be subfraction of
	 * a subfraction of this fraction.
	 * @param 
	 * @return
	 */
	public boolean isSubFraction(String code);
	
	
	/**Get a collection of subfraction of the current subfraction*/
	public Collection<? extends Fraction> getSubFractions();
	
	/**
	 * Adds a subfraction. Ie if the current fraction is human, American is a subfraction.
	 * <p>
	 * 
	 * Throws {@link MaxSubFractionNumberExceeded} when there are more than 65545 subfractions to this fraction
	 * @param f
	 * @throws MaxSubFractionNumberExceeded
	 */
	public void insertSubfraction(Fraction f) throws MaxSubFractionNumberExceeded;
	
	/**
	 * Insert all fractions that are subfractions of the current fraction
	 * <p>
	 * Will try to add as many as possible before exceeding the limit for subfractions: 65545. 
	 * @param fs
	 * @throws MaxSubFractionNumberExceeded
	 */
	public void insertSubfractions(Collection<? extends Fraction> fs) throws MaxSubFractionNumberExceeded;
	
	
	/**Remove the fraction represented by f from the current collection of subfractions of this fraction*/
	public void removeSubfraction(Fraction f);
	
	//Hostility Factors
	
	/**
	 * Check if the current fraction is hostile to the fraction passed in a parameter
	 * 
	 * @param f
	 * @return true-> Hostile to, false-> not hostile to
	 */
	public boolean isHostileTo(Fraction f);
	
	/**
	 * Make the current fraction hostile to the fraction passed in as parameter.
	 * 
	 * @param f
	 */
	public void makeHostileTo(Fraction f);
	
	/**
	 * Tests if the fraction f is equal to this fraction.
	 * <br>
	 * Uses code to determine equalness.
	 * 
	 */
	public boolean equalToFraction(Fraction f);
	
	
}
