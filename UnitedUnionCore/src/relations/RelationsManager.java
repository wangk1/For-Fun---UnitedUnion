package relations;

import java.util.Collection;

/**Manager for relations
 * 
 * Provided Relations Type:
 * 1. OneToOne
 * 2. OneToMany
 * 3. ManyToMany
 * 4. ManyToOne
 * 
 * */
public interface RelationsManager <Key> {
	
	/**Ascertain if a relation exists between relationsFrom to relationsTarget */
	public boolean relationExists(Relations<? extends Key> relationsFrom,Relations<? extends Key> relationsTarget);
	
	/**
	 * One to one relation mapping
	 * @param relationsFrom
	 * @param relationsTarget
	 */
	public void createRelations(Relations relationsFrom, Relations relationsTarget);
	
	/**Many to one Relations mapping
	 * <p>
	 * Deprecated as of V1.0 Pre-Alpha
	 * 
	 * */
	@Deprecated
	public void createRelations(Collection<? extends Relations> relationsFrom, Relations relationsTarget);
	
	/**One to many Relations mapping
	 * <p>
	 * Deprecated as of V1.0 Pre-Alpha
	 * 
	 * */
	@Deprecated
	public void createRelations(Relations relationsFrom, Collection<? extends Relations> relationsTarget);
	
	/**Many to many Relations mapping
	 * <p>
	 * Deprecated as of V1.0 Pre-Alpha
	 * 
	 * */
	@Deprecated
	public void createRelations(Collection<? extends Relations> relationsFrom, Collection<? extends Relations> relationsTarget);
	
}
