package attribute.fraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import attribute.BaseAttributeImpl;
import exceptions.MaxSubFractionNumberExceeded;

/**Base Implementation of the Fraction interface. 
 * <p>
 * The Subfractions are collected in an arraylist, sorted with the fraction with the 
 * 
 * */
class FractionImpl extends BaseAttributeImpl<String> implements Fraction {

	//The next available subfraction code addition
	private char subFractionNum;

	private List<Fraction> subFractions;

	private Fraction parent;

	//TODO Initialization
	FractionImpl(String name, String code,Fraction parent) {
		super(name, code);

		//start the char out at 0
		subFractionNum=0;

		subFractions=new ArrayList<Fraction>();

		this.parent=parent;
	}

	@Override
	public void setCode(String code) {
		super.setCode(code);

	}

	//TODO Parent Methods

	@Override
	public Fraction getParent() {
		return this.parent;

	}

	@Override
	public void setParent(Fraction f) {
		this.parent=f;

	}

	//TODO Subfraction Methods

	@Override
	public Collection<? extends Fraction> getSubFractions() {
		return this.subFractions;

	}

	@Override
	public boolean isSubFraction(String code) {
		//if the code has not yet been initialized
		if(super.getCode() != null) {
		
			//Check both code char by char by the current fraction code's length. 
			//If all matches, then the code argument belongs to a subfraction of the current fraction
			for( int i=0;i<this.getCode().length();i++) {
				if(this.getCode().charAt(i)!=code.charAt(i)) {
					return false;
					
				}
								
			}
			
			return true;
		}

		return false;
	}

	@Override
	public void insertSubfraction(Fraction subFraction) throws MaxSubFractionNumberExceeded {
		if(this.subFractionNum==Character.MAX_VALUE) {
			throw new MaxSubFractionNumberExceeded("The maximum number of subfractions for this fraction "
					+Character.MAX_VALUE+"has been exceeded");
			
		}
 		
		if(subFraction != null) {
			//make code
			subFraction.setCode(this.getCode()+Character.toString(this.subFractionNum++));

			subFraction.setParent(this);

			this.subFractions.add(subFraction);
		}
	}

	@Override
	public void insertSubfractions(Collection<? extends Fraction> subFractionCollection) throws MaxSubFractionNumberExceeded {
		//iterate over the collection
		for(Fraction f: subFractionCollection) {
			insertSubfraction(f);

		}

	}

	@Override
	public void removeSubfraction(Fraction subFraction) {
		//remove from subfraction list and set its parent to null
		if(subFraction != null) {
			this.subFractions.remove(subFraction);

			subFraction.setParent(null);
			
		}
	}

	//TODO Hostility Methods

	@Override
	public boolean isHostileTo(Fraction f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeHostileTo(Fraction f) {
		// TODO Auto-generated method stub
		

	}

	//TODO ToString and Equals Method

	public boolean equalToFraction(Fraction f) {
		return f.getCode().equals(this.getCode());

	}

}
