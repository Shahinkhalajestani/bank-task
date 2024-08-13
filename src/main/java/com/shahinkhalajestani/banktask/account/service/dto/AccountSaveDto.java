package com.shahinkhalajestani.banktask.account.service.dto;

import java.math.BigDecimal;

import com.shahinkhalajestani.banktask.account.model.AccountStatus;
import com.shahinkhalajestani.banktask.account.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountSaveDto {


	private BigDecimal balance;

	private AccountStatus status;

	private String customerId;

	private AccountType type;

}
