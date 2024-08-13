package com.shahinkhalajestani.banktask.customer.service.Impl;

import com.shahinkhalajestani.banktask.base.exception.DuplicateRecordException;
import com.shahinkhalajestani.banktask.customer.dao.CustomerDao;
import com.shahinkhalajestani.banktask.customer.service.dto.CustomerInquiryDto;
import com.shahinkhalajestani.banktask.customer.service.dto.CustomerSaveDto;
import com.shahinkhalajestani.banktask.customer.exception.CustomerNotFoundException;
import com.shahinkhalajestani.banktask.customer.service.AdminCustomerService;
import com.shahinkhalajestani.banktask.customer.service.mapper.AdminCustomerServiceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminCustomerServiceImpl implements AdminCustomerService {

	private final CustomerDao customerDao;

	private final AdminCustomerServiceMapper mapper;


	@Override
	public void saveCustomer(CustomerSaveDto customer) {
		log.info("going to store customer with phone number : {}",customer.getPhoneNumber());
		var customerOptional = customerDao.findByPhoneNumber(customer.getPhoneNumber());
		if (customerOptional.isPresent()) {
			throw new DuplicateRecordException("Customer already exists");
		}else {
			customerDao.save(mapper.toCustomer(customer));
		}
	}

	@Override
	public CustomerInquiryDto getCustomer(String customerId, String phoneNumber) {
		if (StringUtils.isNotBlank(customerId)) {
			var customer = customerDao.findByCustomerId(customerId)
					.orElseThrow(() ->
							new CustomerNotFoundException("customer was not found with customer id : " + customerId));
			return mapper.toCustomerInquiryDto(customer);
		}else {
			var customer = customerDao.findByPhoneNumberLike(phoneNumber)
					.orElseThrow(() -> new CustomerNotFoundException("customer was not found with phone number : " + phoneNumber));
			return mapper.toCustomerInquiryDto(customer);
		}
	}
}
