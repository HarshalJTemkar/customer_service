package harshal.temkar.customer_service.service;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import harshal.temkar.customer_service.dao.CustomerDao;
import harshal.temkar.customer_service.exception.IdNotFoundException;
import harshal.temkar.customer_service.model.Customer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
@CacheConfig(cacheNames = { "customer" })
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDao customerDao;

	@Override
	@Cacheable
	public List<Customer> getAllCustomers() {
		log.info("CustomerServiceImpl ==> getAllCustomers ==> Start");
		return customerDao.findAll();
	}

	@Override
	@CacheEvict(allEntries = true)
	public Customer createCustomer(Customer customer) {
		log.info("CustomerServiceImpl ==> createCustomer ==> Start");
		return customerDao.save(customer);
	}

	@Override
	@CachePut(key = "#id")
	@CacheEvict(allEntries = true)
	public Customer updateCustomer(String id, Customer customer) {
		log.info("CustomerServiceImpl ==> updateCustomer ==> Start");
		if (!customerDao.existsById(id)) {
			throw new IdNotFoundException("Not Found", new Throwable("Id not found: " + id));
		}
		return customerDao.save(customer);
	}

	@Override
	@Cacheable(key = "#id", unless = "#result == null")
	public Customer getCustomerById(String id) {
		log.info("CustomerServiceImpl ==> getCustomerById ==> Start");
		return customerDao.findById(id).orElseThrow(() -> new IdNotFoundException("Not Found", new Throwable("Id not found: " + id)));
	}

	@Override
	@Caching(evict = { 
			@CacheEvict(allEntries = true), 
			@CacheEvict(key = "#id")
	})
	public void deleteCustomer(String id) {
		log.info("CustomerServiceImpl ==> deleteCustomer ==> Start");
		if (!customerDao.existsById(id)) {
			throw new IdNotFoundException("Not Found", new Throwable("Id not found: " + id));
		}
		customerDao.deleteById(id);
	}

}
