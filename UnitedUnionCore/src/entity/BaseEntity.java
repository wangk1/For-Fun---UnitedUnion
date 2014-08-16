package entity;

import tools.UniqueIdGenerator;

/**The most basic of all entity. Parent of every other entity.
 * <p>
 * Provides very little properties
 * <br>
 * 1. Get/Set Name of Entity
 * 2. Get/Set Coordinate of entity
 * 3. Get the unique entity id of the entity
 * 
 * @author wangk1
 *
 */
public interface BaseEntity {
	/***
	 * Please DO NOT get this field directly, version to version compatibility not guaranteed.
	 * <br>
	 * Please call the static method generateUniqueId instead
	 */
	static UniqueIdGenerator idgen=new UniqueIdGenerator();

	void setName(String name);
	
	void setXCoord();
	
	void setYCoord();
	
	void setZCoord();
	
	String getName();
	
	long getUniqueId();
	
	/**Static method in interface BaseEntity that returns the next available id for use.
	 * <br>
	 * Call to acquire id for the BaseEntity implementation 
	 * 
	 * @return
	 */
	static int generateUniqueId() {
		return idgen.generateNextIntID();
		
	}

}
