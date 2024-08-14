package com.shahinkhalajestani.banktask.customer.service;

import java.util.List;
import java.util.Set;

import com.shahinkhalajestani.banktask.account.model.Account;
import com.shahinkhalajestani.banktask.account.service.dto.AccountInquiryDto;
import com.shahinkhalajestani.banktask.customer.service.dto.CustomerInquiryDto;
import com.shahinkhalajestani.banktask.customer.service.dto.CustomerSaveDto;

public interface AdminCustomerService {

	void saveCustomer(CustomerSaveDto customer);

	void saveAccountForCustomer(Account account, String customerId);

	CustomerInquiryDto getCustomerWithIdOrPhoneNumber(String customerId, String phoneNumber);

	Set<Account> getCustomerAccounts(String customerId);

}
