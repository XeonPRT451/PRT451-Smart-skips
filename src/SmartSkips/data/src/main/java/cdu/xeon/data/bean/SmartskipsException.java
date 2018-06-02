package cdu.xeon.data.bean;

public class SmartskipsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SmartskipsException() {
		super();
	}

	public SmartskipsException(String message, Throwable cause) {
		super(message, cause);
	}

	public SmartskipsException(String message) {
		super(message);
	}

	public SmartskipsException(Throwable cause) {
		super(cause);
	}
	
}
