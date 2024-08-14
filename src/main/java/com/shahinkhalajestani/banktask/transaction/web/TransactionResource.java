package com.shahinkhalajestani.banktask.transaction.web;

import com.shahinkhalajestani.banktask.base.model.ResponseModel;
import com.shahinkhalajestani.banktask.transaction.service.TransactionService;
import com.shahinkhalajestani.banktask.transaction.web.dto.TransactionInquiryRequest;
import com.shahinkhalajestani.banktask.transaction.web.dto.TransactionInquiryResponse;
import com.shahinkhalajestani.banktask.transaction.web.dto.TransactionOperationRequest;
import com.shahinkhalajestani.banktask.transaction.web.mapper.TransactionResourceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/transactions")
public class TransactionResource {

	private final TransactionService transactionService;

	private final TransactionResourceMapper mapper;


	@GetMapping
	public ResponseEntity<TransactionInquiryResponse> getTransactions(@ModelAttribute TransactionInquiryRequest request
			, Pageable pageable) {
		var inquiryDto = mapper.toTransactionInquiryDto(request);
		var result = transactionService.searchTransactions(inquiryDto, pageable);
		var response = mapper.toTransactionInquiryResponse(result);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<ResponseModel> createTransaction(@RequestBody TransactionOperationRequest request) {
		transactionService.doTransaction(mapper.toTransactionOperationDto(request));
		return ResponseEntity.ok(ResponseModel.success());
	}

}
