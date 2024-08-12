package com.shahinkhalajestani.banktask.customer.service;

import com.shahinkhalajestani.banktask.customer.dto.CustomerInquiryDto;
import com.shahinkhalajestani.banktask.customer.dto.CustomerSaveDto;

public interface CustomerService {

	void saveCustomer(CustomerSaveDto customer);

	CustomerInquiryDto getCustomer(String customerId, String phoneNumber);

}
