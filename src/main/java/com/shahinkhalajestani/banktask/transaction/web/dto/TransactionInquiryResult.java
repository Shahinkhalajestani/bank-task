package com.shahinkhalajestani.banktask.transaction.web.dto;

import java.time.LocalDateTime;

import com.shahinkhalajestani.banktask.transaction.model.TransactionStatus;
import com.shahinkhalajestani.banktask.transaction.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInquiryResult {

	private String transactionId;

	private String fromAccount;

	private String toAccount;

	private TransactionStatus status;

	private TransactionType type;

	private LocalDateTime completionDate;

}
