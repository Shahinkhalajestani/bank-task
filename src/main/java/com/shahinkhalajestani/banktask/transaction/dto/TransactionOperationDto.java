package com.shahinkhalajestani.banktask.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionOperationDto {

	private Long amount;

	private String toAccount;

	private String fromAccount;

}
