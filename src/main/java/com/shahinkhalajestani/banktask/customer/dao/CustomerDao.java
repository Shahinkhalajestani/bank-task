package com.shahinkhalajestani.banktask.customer.dao;

import java.util.Optional;

import com.shahinkhalajestani.banktask.customer.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerId(String customerId);

	Optional<Customer> findByPhoneNumberLike(String phoneNumber);

	Optional<Customer> findByPhoneNumber(String phoneNumber);

}
