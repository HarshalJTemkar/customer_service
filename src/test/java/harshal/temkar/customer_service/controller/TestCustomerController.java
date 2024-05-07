package harshal.temkar.customer_service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import harshal.temkar.customer_service.model.Customer;
import harshal.temkar.customer_service.service.CustomerService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
class TestCustomerController {

	@Spy
	@InjectMocks
	private CustomerController controller;
	
	@Mock
	private CustomerService service;
	
	private Customer customer;
	
	@BeforeEach
	void setUp() {
		customer = Customer.builder().id("123445667788")
				.firstname("ABC").lastname("XYZ").email("lmn.rst.com").contact("123").build();
	}
	
	@DisabledIfEnvironmentVariable(named = "customerEventPublisher", matches = "true", disabledReason = "Skipping Kafka tests")
	@Test
	@Order(1)
	void test_createCustomer() {
		when(service.createCustomer(any())).thenReturn(customer);
		ResponseEntity<Customer> respCustomer = controller.createCustomer(customer);
		assertEquals(HttpStatus.CREATED, respCustomer.getStatusCode());
	}
}
