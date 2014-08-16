package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**Modify the behavior of the basic default relations manager*/
@Inherited
@Target({ElementType.FIELD,ElementType.LOCAL_VARIABLE})
public @interface RelationsManagerBehavior {

	/**Only check the from side in relations mapping, somewhat more efficient
	 * <br>
	 * Default is false
	 * */
	boolean onlyCheckFromRelationSide() default false;
	
	/**Change the relationship map that maps one relation side to a storage
	 * <p>
	 * Default: HashMap
	 * <br>
	 * Map type must implement {@link Map}
	 * */
	@SuppressWarnings("rawtypes")
	Class<? extends Map> changeMappingTechnique() default HashMap.class; 
	
	/**
	 * Change the storage for once the relation side has been found in a map
	 * <p>
	 * Default: ArrayList
	 * <br>
	 * Storage type must implement {@link Collection}
	 * */
	@SuppressWarnings("rawtypes")
	Class<? extends Collection> changeRelationshipStoreTechnique() default ArrayList.class;
}
