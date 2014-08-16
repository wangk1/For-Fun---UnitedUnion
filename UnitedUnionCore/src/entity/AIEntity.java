package entity;

import map.BaseMap;

public interface AIEntity extends BaseEntity{
	
	/**Tell AI to make a move.
	 * <p>
	 * Takes in a representation of the current map and states.
	 * 
	 * */
	public void makeMove(BaseMap currentMap);
	
	/**
	 * Adds an entity to the current AI
	 * 
	 * @param e
	 */
	public void addEntity(BaseEntity e);
}
