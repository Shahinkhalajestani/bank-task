package com.shahinkhalajestani.banktask.account.service.impl;

import java.math.BigDecimal;
import java.util.Set;

import com.shahinkhalajestani.banktask.account.dao.AccountDao;
import com.shahinkhalajestani.banktask.account.model.Account;
import com.shahinkhalajestani.banktask.account.model.AccountStatus;
import com.shahinkhalajestani.banktask.account.service.dto.AccountChangeStateDto;
import com.shahinkhalajestani.banktask.account.service.dto.AccountInquiryDto;
import com.shahinkhalajestani.banktask.account.service.dto.AccountSaveDto;
import com.shahinkhalajestani.banktask.account.exception.AccountNotFoundException;
import com.shahinkhalajestani.banktask.account.service.AdminAccountService;
import com.shahinkhalajestani.banktask.account.service.mapper.AdminAccountServiceMapper;
import com.shahinkhalajestani.banktask.customer.service.AdminCustomerService;
import com.shahinkhalajestani.banktask.transaction.exception.AccountNotValidForOperationException;
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
		var account = findAccount(accountId);
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
		var accounts = adminCustomerService.getCustomerAccounts(customerId);
		return mapper.toAccountInquiryDtos(accounts);
	}

	@Override
	@Transactional
	public void changeAccountStatus(AccountChangeStateDto accountChangeStateDto) {
		var account = findAccount(accountChangeStateDto.getAccountId());
		account.setStatus(accountChangeStateDto.getStatus());
		accountDao.save(account);
	}

	@Override
	public void depositToAccount(String accountId, Long amount) {
		var account = findAccount(accountId);
		checkAccount(account);
		var initialBalance = account.getBalance();
		account.setBalance(initialBalance.add(new BigDecimal(amount)));
		accountDao.save(account);
	}

	@Override
	public void withDrawFromAccount(String accountId, Long amount) {
		var account = findAccount(accountId);
		checkAccount(account);
		var initialBalance = account.getBalance();
		if (initialBalance.longValue() < amount) {
			throw new AccountNotValidForOperationException("there is not enough balance in account for operation " + accountId);
		}
		account.setBalance(initialBalance.subtract(new BigDecimal(amount)));
		accountDao.save(account);
	}

	private Account findAccount(String accountId) {
		return accountDao.findByAccountId(accountId)
				.orElseThrow(() -> new AccountNotFoundException("account not found with account id : " + accountId));
	}

	private static void checkAccount(Account account) {
		if (AccountStatus.BLOCKED.equals(account.getStatus())) {
			throw new AccountNotValidForOperationException("one of the account is blocked with account Id " + account.getAccountId());
		}
	}
}
