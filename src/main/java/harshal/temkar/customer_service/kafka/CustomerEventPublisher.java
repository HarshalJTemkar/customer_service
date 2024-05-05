package harshal.temkar.customer_service.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import harshal.temkar.customer_service.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerEventPublisher {

	private final KafkaTemplate<String, Customer> kafkaTemplate;

    @Value("${kafka.topic.customerRegistered}")
    private String customerRegisteredTopic;

    public void publishCustomerCreatedEvent(Customer event) {
    	log.info("CustomerEventPublisher ==> publishCustomerCreatedEvent ==> Start");
        kafkaTemplate.send(customerRegisteredTopic, event);
    }
}
