package harshal.temkar.customer_service.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings("static-access")
	@ExceptionHandler(IdNotFoundException.class)
	private ResponseEntity<ErrorModel> handleGenericNotFoundException(IdNotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(new ErrorModel().builder()
				.status(HttpStatus.NOT_FOUND).errorcode(String.valueOf(HttpStatus.NOT_FOUND.value())).message(ex.getMessage())
				.detail(ex.getCause().toString()).timestamp(new Date()).build(), HttpStatus.NOT_FOUND);
	}
}
