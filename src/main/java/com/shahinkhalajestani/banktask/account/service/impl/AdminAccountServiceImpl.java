package com.shahinkhalajestani.banktask.account.service.impl;

import java.util.Set;

import com.shahinkhalajestani.banktask.account.dao.AccountDao;
import com.shahinkhalajestani.banktask.account.service.dto.AccountInquiryDto;
import com.shahinkhalajestani.banktask.account.service.dto.AccountSaveDto;
import com.shahinkhalajestani.banktask.account.exception.AccountNotFoundException;
import com.shahinkhalajestani.banktask.account.service.AdminAccountService;
import com.shahinkhalajestani.banktask.account.service.mapper.AdminAccountServiceMapper;
import com.shahinkhalajestani.banktask.customer.service.AdminCustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminAccountServiceImpl implements AdminAccountService {

	private final AccountDao accountDao;

	private final AdminAccountServiceMapper mapper;

	private final AdminCustomerService adminCustomerService;

	@Override
	@Transactional
	public AccountInquiryDto getAccount(String accountId) {
		log.info("gonna fetch account with account id : {}", accountId);
		var account = accountDao.findByAccountId(accountId)
				.orElseThrow(() -> new AccountNotFoundException("account not found with account id : " + accountId));
		return mapper.toAccountInquiryDto(account);
	}

	@Override
	public void saveAccount(AccountSaveDto accountSaveDto) {
		log.info("going to save account for customer with id : {}", accountSaveDto.getCustomerId());
		var account = mapper.toAccount(accountSaveDto);
		adminCustomerService.saveAccountForCustomer(account, accountSaveDto.getCustomerId());
	}

	@Override
	public Set<AccountInquiryDto> getCustomerAccounts(String customerId) {
		var accounts =  adminCustomerService.getCustomerAccounts(customerId);
		return mapper.toAccountInquiryDtos(accounts);
	}
}
