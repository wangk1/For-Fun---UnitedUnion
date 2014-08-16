package map;

import entity.BaseEntity;

public interface BaseMap {
	
	
	BaseEntity getAllEntities();
	
	BaseTile[][] getTiles();
	
	BaseTile getTileAt();
}
