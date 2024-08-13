package com.shahinkhalajestani.banktask.customer.service;

import com.shahinkhalajestani.banktask.customer.service.dto.CustomerInquiryDto;
import com.shahinkhalajestani.banktask.customer.service.dto.CustomerSaveDto;

public interface AdminCustomerService {

	void saveCustomer(CustomerSaveDto customer);

	CustomerInquiryDto getCustomer(String customerId, String phoneNumber);

}
