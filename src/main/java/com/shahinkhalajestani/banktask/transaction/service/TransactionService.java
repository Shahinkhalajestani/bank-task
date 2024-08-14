package com.shahinkhalajestani.banktask.transaction.service;

import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionInquiryDto;
import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionOperationDto;
import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionResultDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {

	TransactionResultDto doTransaction(TransactionOperationDto transactionOperationDto);


	Page<TransactionResultDto> searchTransactions(TransactionInquiryDto transactionInquiryDto, Pageable pageable);

	void refundFailedTransactions();
}
