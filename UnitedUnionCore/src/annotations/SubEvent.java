package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import events.BasicEvent;

//Can only be used on types
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
/**
 * Mark the current event's subclasses.
 * 
 * <p>
 * Unrelated classes can even be linked via this annotation in special cases. However, it is easier to just link them via "extends"
 * keyword when possible. 
 *<br>
 *WARNING: THIS ANNOTATION is still in beta
 *
 * 
 * @author wangk1
 *
 */
public @interface SubEvent {
	
	//Suppress warnings, even though BasicEvent is a raw type. Just Making a case for ? should be implementing
	//BaseEvent
	//@SuppressWarnings("rawtypes")
	@SuppressWarnings("rawtypes")
	Class<? extends BasicEvent>[] value();
	
}
