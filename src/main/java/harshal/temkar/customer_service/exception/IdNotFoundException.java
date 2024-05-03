package harshal.temkar.customer_service.exception;

public class IdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdNotFoundException(String message, Throwable cause) {
        super(message, cause);
	}
}
