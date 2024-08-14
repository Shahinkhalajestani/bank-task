package com.shahinkhalajestani.banktask.transaction.scheduler;

import com.shahinkhalajestani.banktask.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TransactionRefundScheduler {

	private final TransactionService transactionService;


	@Scheduled(fixedRate = 60000)
	public void refund() {
		log.info("refund scheduler began");
		transactionService.refundFailedTransactions();
	}

}
