package com.shahinkhalajestani.banktask.account.web;

import java.util.Collections;

import com.shahinkhalajestani.banktask.account.service.AdminAccountService;
import com.shahinkhalajestani.banktask.account.web.dto.AccountChangeStateRequest;
import com.shahinkhalajestani.banktask.account.web.dto.AccountInquiryResponse;
import com.shahinkhalajestani.banktask.account.web.dto.AccountSavingRequest;
import com.shahinkhalajestani.banktask.account.web.mapper.AccountAdminResourceMapper;
import com.shahinkhalajestani.banktask.base.model.ResponseModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/account")
public class AccountAdminResource {

	private final AccountAdminResourceMapper accountAdminResourceMapper;

	private final AdminAccountService adminAccountService;

	@PostMapping
	public ResponseEntity<ResponseModel> saveAccount(@RequestBody @Valid AccountSavingRequest accountSavingRequest) {
		log.info("going to save account for customer with customer Id : {}", accountSavingRequest.getCustomerId());
		adminAccountService.saveAccount(accountAdminResourceMapper.toAccountSaveDto(accountSavingRequest));
		return ResponseEntity.ok(ResponseModel.success());
	}

	@GetMapping
	public ResponseEntity<AccountInquiryResponse> getAccount(@RequestParam("accountId") String accountId) {
		var accountInquiryDto = adminAccountService.getAccount(accountId);
		return ResponseEntity.ok(accountAdminResourceMapper.toAccountInquiryResponse(Collections.singleton(accountInquiryDto)));
	}

	@GetMapping("/customer-accounts/{customerId}")
	public ResponseEntity<AccountInquiryResponse> getCustomerAccounts(@PathVariable("customerId") String customerId) {
		log.info("going to get customer account for customer Id : {}", customerId);
		var accountInquiryDto = adminAccountService.getCustomerAccounts(customerId);
		return ResponseEntity.ok(accountAdminResourceMapper.toAccountInquiryResponse(accountInquiryDto));
	}

	@PutMapping("/change-state")
	public ResponseEntity<ResponseModel> changeAccountState(@RequestBody @Valid AccountChangeStateRequest accountChangeStateRequest) {
		log.info("going to change account state for account Id : {}", accountChangeStateRequest.getAccountId());
		adminAccountService.changeAccountStatus(accountAdminResourceMapper.toAccountChangeStateDto(accountChangeStateRequest));
		return ResponseEntity.ok(ResponseModel.success());
	}

}
