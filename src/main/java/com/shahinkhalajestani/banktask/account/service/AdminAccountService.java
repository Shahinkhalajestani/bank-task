package com.shahinkhalajestani.banktask.account.service;

import java.util.Set;

import com.shahinkhalajestani.banktask.account.service.dto.AccountChangeStateDto;
import com.shahinkhalajestani.banktask.account.service.dto.AccountInquiryDto;
import com.shahinkhalajestani.banktask.account.service.dto.AccountSaveDto;

public interface AdminAccountService {

	AccountInquiryDto getAccount(String accountId);


	void saveAccount(AccountSaveDto accountSaveDto);

	Set<AccountInquiryDto> getCustomerAccounts(String customerId);

	void changeAccountStatus(AccountChangeStateDto accountChangeStateDto);
}
