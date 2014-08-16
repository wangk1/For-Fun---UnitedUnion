package entity;

import attribute.Attribute;
import attribute.fraction.Fraction;

public interface Entity extends BaseEntity{

	
	void addFraction(Fraction f);
	
	
	
	Fraction removeFraction(Fraction f);
	
	void addAttribute(Attribute a);
	
}
