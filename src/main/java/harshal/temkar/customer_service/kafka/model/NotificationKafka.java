package harshal.temkar.customer_service.kafka.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationKafka {

	private String id;
	
	private String customerid;
	
	private String message;
	
	private Date date; 
}
