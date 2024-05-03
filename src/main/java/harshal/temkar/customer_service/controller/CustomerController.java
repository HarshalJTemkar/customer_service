package harshal.temkar.customer_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import harshal.temkar.customer_service.model.Customer;
import harshal.temkar.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/rest-api/customer/v1")
@RequiredArgsConstructor
@Log4j2
public class CustomerController {

	private final CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		log.info("CustomerController ==> getAllCustomers ==> Start");
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		log.info("CustomerController ==> createCustomer ==> Start");
		return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@NotBlank @PathVariable String id, @Valid @RequestBody Customer customer) {
		log.info("CustomerController ==> updateCustomer ==> Start");
		return ResponseEntity.ok(customerService.updateCustomer(id, customer));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@NotBlank @PathVariable String id) {
		log.info("CustomerController ==> getCustomerById ==> Start");
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@NotBlank @PathVariable String id) {
		log.info("CustomerController ==> deleteCustomer ==> Start");
		customerService.deleteCustomer(id);
		return ResponseEntity.ok().build();
	}
}
