package com.shahinkhalajestani.banktask.account.service.dto;

import java.math.BigDecimal;

import com.shahinkhalajestani.banktask.account.model.AccountStatus;
import com.shahinkhalajestani.banktask.account.model.AccountType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInquiryDto {

	private String accountId;

	private BigDecimal balance;

	private AccountStatus status;

	private AccountType type;

}
