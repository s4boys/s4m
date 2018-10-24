package videoverleih;

public class IllegalRentalDuration extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1707517602763720205L;

	public IllegalRentalDuration(String pMessage) {
        super(pMessage);
    }
}