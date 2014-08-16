package datamodel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class AttitudeHashMap<KeyType> implements AttitudeMap<KeyType> {
	private Map<KeyType,Map<KeyType,Integer>> attitudeMap;
	
	public AttitudeHashMap() {
		attitudeMap=new HashMap<>();
		
	}

	//TAKE INTO ACCOUNT THE FACT THAT FRACTION 1 CAN BE A SUBSET OF FRACTION 2
	@Override
	public int getAttitudeTo(KeyType from, KeyType to) {
		
		if(attitudeMap.containsKey(from)){
			return attitudeMap.get(from).containsKey(to)? attitudeMap.get(from).get(to):0;
			
			//probably stored with to then
		} else if(attitudeMap.containsKey(to)) {
			return attitudeMap.get(to).containsKey(from)? attitudeMap.get(to).get(from):0;
			
		}
		
		//contains neither relations, default attitude level
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer put(KeyType key, Integer value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends KeyType, ? extends Integer> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<KeyType> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Integer> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<KeyType, Integer>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttitudeTo(KeyType from, KeyType to) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyAttitudeTo(int offset, KeyType from, KeyType to) {
		// TODO Auto-generated method stub
		
	}


}
