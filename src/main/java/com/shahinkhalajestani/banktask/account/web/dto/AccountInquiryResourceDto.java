package com.shahinkhalajestani.banktask.account.web.dto;

import java.math.BigDecimal;

import com.shahinkhalajestani.banktask.account.model.AccountStatus;
import com.shahinkhalajestani.banktask.account.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInquiryResourceDto {

	private String accountId;

	private BigDecimal balance;

	private AccountStatus status;

	private AccountType type;
}
