package exceptions;

/**Error thrown when the max number of subfractions have been exceeded*/
public class MaxSubFractionNumberExceeded extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MaxSubFractionNumberExceeded(String message) {
		super(message);
		
	}
	

}
