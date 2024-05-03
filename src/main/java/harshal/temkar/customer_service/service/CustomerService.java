package harshal.temkar.customer_service.service;

import java.util.List;

import harshal.temkar.customer_service.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	
	public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(String id, Customer customer);
	
	public Customer getCustomerById(String id);
	
	public void deleteCustomer(String id);
}
