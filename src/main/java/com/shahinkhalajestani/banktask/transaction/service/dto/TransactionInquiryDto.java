package com.shahinkhalajestani.banktask.transaction.service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInquiryDto {

	private String transactionId;

	private String fromAccount;

	private String toAccount;

	private LocalDateTime fromDate;

	private LocalDateTime toDate;

	private Long amount;

}
