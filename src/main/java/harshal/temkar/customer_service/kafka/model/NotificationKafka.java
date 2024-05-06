package harshal.temkar.customer_service.kafka.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationKafka implements Serializable {

	private String id;
	
	private String customerid;
	
	private String message;
	
	private Date date; 
}
