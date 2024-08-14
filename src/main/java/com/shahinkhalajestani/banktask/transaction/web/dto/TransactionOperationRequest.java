package com.shahinkhalajestani.banktask.transaction.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionOperationRequest {


	private Long amount;

	private String toAccount;

	private String fromAccount;

}
