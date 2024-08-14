package com.shahinkhalajestani.banktask.transaction.service;

import java.util.List;

import com.shahinkhalajestani.banktask.transaction.dto.TransactionInquiryDto;
import com.shahinkhalajestani.banktask.transaction.dto.TransactionOperationDto;
import com.shahinkhalajestani.banktask.transaction.dto.TransactionResultDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {

	TransactionResultDto doTransaction(TransactionOperationDto transactionOperationDto);


	Page<TransactionResultDto> searchTransactions(TransactionInquiryDto transactionInquiryDto, Pageable pageable);

}
