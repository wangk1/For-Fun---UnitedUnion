package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @author wangk1
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface Relation {

	RelationType[] value() default RelationType.OneToOne;
	
	boolean bidirectional() default false;
	
	public enum RelationType{
		OneToOne,
		ManyToOne,
		OneToMany,
		//ManyToMany
		
		
	}
	
}

