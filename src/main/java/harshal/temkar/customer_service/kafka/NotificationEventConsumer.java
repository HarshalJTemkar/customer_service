package harshal.temkar.customer_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import harshal.temkar.customer_service.kafka.model.NotificationKafka;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class NotificationEventConsumer {

	@KafkaListener(topics = "${kafka.topic.notificationCreated}")
    public void consumeNotificatonCreatedEvent(NotificationKafka notification) {
		log.info("NotificationEventConsumer ==> consumeNotificatonCreatedEvent ==> Start");
		log.info(notification);
    }
}
