package attribute.attitude;

import core.UnitedUnionConstants;
import attribute.fraction.Fraction;

/**Global attitude manager for all fraction and consequently all the entities.
 * 
 * <p>
 * An attitude manager just stores Fraction A's attitude to Fraction B and vice versa in integer representation. Note that, like in
 * real life, both values do not have to be the same, aka A can have a low attitude level of B but B can have a high attitude level to A. 
 * 
 * 
 * @author wangk1
 *
 */
public interface Attitude{
	/**Default enum that represent various milestones in attitude between entities and fractions.
	 * 
	 * @author wangk1
	 *
	 */
	public enum AttitudeThreshold implements AttitudeLevel{
		/**Attitude that cannot be reached via normal means, reserved for special entity that must be always hostile
		 *, regardless of attitude level.
		 *<br>
		 *This is the lowest attitude that any entity can have towards another.
		 *<p>
		 *WARNING: DO NOT TAMPER WITH THIS VALUE, doing so will result in issues with the default fraction and attitude managers.
		 *<br>
		 *However, if you plan on defining your own system, then feel free to change this representation.
		 **/
		ENEMIES(Integer.MIN_VALUE),
		
		HOSTILE(UnitedUnionConstants.ATTITUDE_THRESHOLDS[0]),
		UNHAPPY(UnitedUnionConstants.ATTITUDE_THRESHOLDS[1]),
		DISINTERESTED(UnitedUnionConstants.ATTITUDE_THRESHOLDS[2]),
		NEUTRAL(UnitedUnionConstants.ATTITUDE_THRESHOLDS[3]),
		ACQUAINTED(UnitedUnionConstants.ATTITUDE_THRESHOLDS[4]),
		FRIENDLY(UnitedUnionConstants.ATTITUDE_THRESHOLDS[5]),
		HAPPY(UnitedUnionConstants.ATTITUDE_THRESHOLDS[6]),
		
		/**Attitude that cannot be reached via normal means, reserved for special entity that must be always allies
		 *, regardless of attitude level.

		 *<br>
		 *This is the highest attitude that any entity can have towards another.
		 *<p>
		 *WARNING: DO NOT TAMPER WITH THIS VALUE, doing so will result in issues with the fraction and attitude managers.
		 *<br>
		 *However, if you plan on defining your own system, then feel free to change this representation.
		 **/
		ALLIES(Integer.MAX_VALUE)
		;
		private int defaultLevel;
		
		private AttitudeThreshold(int defaultLevel) {
			this.defaultLevel=defaultLevel;
			
		}

		@Override
		public int getDefaultThresholdLevel() {
			return defaultLevel;
			
		}
		
		/**Changes the default threshold value for the 
		 * 
		 */
		@Override
		public void setDefaultThresholdLevel(int dThresh) {
			this.defaultLevel=dThresh;
			
		}
	}

	/**Set from's attitude level of target to the value of integer level*/
	void setAttitudeTo(int attitudeLevel, Fraction from, Fraction to);
	
	/**Set from's attitude level of target to the integer value of AttitudeLevel level*/
	void setAttitudeTo(AttitudeLevel level, Fraction from, Fraction to);
	
	/**Decrement(negative attitudeModifier) or increment(positive attitudeModifier) from's attitude level of target*/
	void modifyAttitudeBy(int attitudeModifier, Fraction from, Fraction target);
	
	/**Grab from's attitude level of target*/
	int getAttitude(Fraction from, Fraction target);
}