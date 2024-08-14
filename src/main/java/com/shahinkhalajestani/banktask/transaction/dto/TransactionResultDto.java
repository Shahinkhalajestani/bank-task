package com.shahinkhalajestani.banktask.transaction.dto;

import java.time.LocalDateTime;

import com.shahinkhalajestani.banktask.transaction.model.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResultDto {

	private String transactionId;

	private String fromAccount;

	private String toAccount;

	private TransactionStatus status;

	private LocalDateTime completionDate;

}
