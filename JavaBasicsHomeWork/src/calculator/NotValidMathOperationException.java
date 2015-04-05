package calculator;

public class NotValidMathOperationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -640718460946963492L;

	public NotValidMathOperationException(String message) {
		super(message);
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Math error: " + super.getMessage();
	}
	
}
