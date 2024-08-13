package com.shahinkhalajestani.banktask.account.service;

import com.shahinkhalajestani.banktask.account.service.dto.AccountInquiryDto;
import com.shahinkhalajestani.banktask.account.service.dto.AccountSaveDto;

public interface AdminAccountService {

	AccountInquiryDto getAccount(String accountId);


	void saveAccount(AccountSaveDto accountSaveDto);

}
