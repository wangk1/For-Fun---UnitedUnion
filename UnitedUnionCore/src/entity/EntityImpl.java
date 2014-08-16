package entity;
//The root of the entity family, almost all entities besides the entity handler inherits from this class

public class EntityImpl {

	private int[] attributes;

	//must have fractions
	private Fraction fraction;

	//TODO Constructors

	public EntityImpl(Fraction fraction, int[] attributes) {
		this.fraction=fraction;
		this.attributes=attributes;

	}

	//TODO Methods

	//drain the said attribute, the numerical value of attr is the index of the location of attribute
	//However, this version is not damageable unless the game wanted to
	public void drainAttribute(Attribute attr, int amount) {}

	//getters and setter for the fields
	public int getAttribute(Attribute attr) {
		if(attr.getNum()<attributes.length)
			return attributes[attr.getNum()];
		
		return 0;
	}

	public void setAttributes(Attribute attr, int amount) {
		if(attr.getNum()<attributes.length)
			this.attributes[attr.getNum()]=amount;
	}

	public Fraction getFraction() {
		return fraction;
	}

	public void setFraction(Fraction fraction) {
		this.fraction = fraction;
	}



}
