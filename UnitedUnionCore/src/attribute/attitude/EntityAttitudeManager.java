package attribute.attitude;

import java.util.HashMap;
import java.util.Map;

public class EntityAttitudeManager implements AttitudeManager{
	
	//Maps entity code to attitudelevel
	private Map<Integer, Integer> entityAttitudeMap;
	
	public EntityAttitudeManager() {
		entityAttitudeMap=new HashMap<>();
		
	}
	
}
