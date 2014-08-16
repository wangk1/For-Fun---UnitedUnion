package tools;


public class UniqueIdGenerator {
	private int nextId=0;

	public int generateNextIntID() {
		return nextId++;
		
	}
	
}
