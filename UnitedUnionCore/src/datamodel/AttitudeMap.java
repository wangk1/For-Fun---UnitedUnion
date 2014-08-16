package datamodel;

import java.util.Map;


/**Custom built map to map attitude relation from Fraction A to B or Entity A to B*/
public interface AttitudeMap<KeyType> extends Map<KeyType, Integer>{
	
	int getAttitudeTo(KeyType from, KeyType to);
	
	void setAttitudeTo(KeyType from, KeyType to);
	
	void modifyAttitudeTo(int offset,KeyType from, KeyType to);
}
