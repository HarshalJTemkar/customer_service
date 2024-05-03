package harshal.temkar.customer_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import harshal.temkar.customer_service.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {

}
