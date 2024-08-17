package com.shahinkhalajestani.banktask.transaction.service.impl;

import java.time.LocalDateTime;

import com.shahinkhalajestani.banktask.account.service.AdminAccountService;
import com.shahinkhalajestani.banktask.transaction.dao.TransactionDao;
import com.shahinkhalajestani.banktask.transaction.dao.TransactionSpecification;
import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionInquiryDto;
import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionOperationDto;
import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionResultDto;
import com.shahinkhalajestani.banktask.transaction.exception.TransactionOperationFailedException;
import com.shahinkhalajestani.banktask.transaction.mapper.TransactionServiceMapper;
import com.shahinkhalajestani.banktask.transaction.model.TransactionStatus;
import com.shahinkhalajestani.banktask.transaction.service.TransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	private final TransactionDao transactionDao;

	private final TransactionServiceMapper transactionServiceMapper;

	private final AdminAccountService adminAccountService;


	@Override
	@Transactional
	public TransactionResultDto doTransaction(TransactionOperationDto transactionOperationDto) {
		var fromAccount = adminAccountService.getAccount(transactionOperationDto.getFromAccount());
		var toAccount = adminAccountService.getAccount(transactionOperationDto.getToAccount());
		var transaction = transactionServiceMapper.toTransaction(transactionOperationDto);
		try {
			adminAccountService.withDrawFromAccount(fromAccount.getAccountId(), transactionOperationDto.getAmount());
			adminAccountService.depositToAccount(toAccount.getAccountId(), transactionOperationDto.getAmount());
		} catch (Exception e) {
			log.error("transaction with transaction Id failed : {}", transaction.getTransactionId());
			transaction.setStatus(TransactionStatus.FAILED);
			transactionDao.save(transaction);
			throw new TransactionOperationFailedException("transaction failed due to error with message : " + e.getMessage());
		}
		transaction.setStatus(TransactionStatus.SUCCEED);
		transaction.setEndDate(LocalDateTime.now());
		transactionDao.save(transaction);
		return transactionServiceMapper.toTransactionResultDto(transaction);
	}


	@Override
	public Page<TransactionResultDto> searchTransactions(TransactionInquiryDto transactionInquiryDto, Pageable pageable) {
		var transactions = transactionDao
				.findAll(TransactionSpecification.getTransactionsByRequest(transactionInquiryDto), pageable);
		return transactionServiceMapper.toTransactionResultDtoPage(transactions);
	}

	@Override
	@Transactional
	public void refundFailedTransactions() {
		var transactions = transactionDao.findByStatus(TransactionStatus.FAILED);
		transactions.forEach(transaction -> {
			var refundTransaction = transactionServiceMapper.toRefundTransaction(transaction);
			try {
				adminAccountService.depositToAccount(refundTransaction.getToAccountId(), transaction.getAmount());
			} catch (Exception e) {
				log.error("refund transaction with transaction Id failed : {}", transaction.getTransactionId());
				refundTransaction.setStatus(TransactionStatus.FOLLOW_UP);
				transactionDao.save(refundTransaction);
				throw new TransactionOperationFailedException("transaction failed due to error with message : " + e.getMessage());
			}
			refundTransaction.setEndDate(LocalDateTime.now());
			refundTransaction.setStatus(TransactionStatus.SUCCEED);
			transactionDao.save(refundTransaction);
			transaction.setStatus(TransactionStatus.CANCELLED);
			transaction.setEndDate(LocalDateTime.now());
			transactionDao.save(transaction);
		});
	}
}
