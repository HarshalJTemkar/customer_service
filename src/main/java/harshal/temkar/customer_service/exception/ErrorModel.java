package harshal.temkar.customer_service.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorModel {

	private HttpStatus status;
	
	private String errorcode;
	
	private String message;
	
	private String detail;
	
	private Date timestamp;
}
