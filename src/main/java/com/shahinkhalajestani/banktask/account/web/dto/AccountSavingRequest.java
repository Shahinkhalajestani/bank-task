package com.shahinkhalajestani.banktask.account.web.dto;

import java.math.BigDecimal;

import com.shahinkhalajestani.banktask.account.model.AccountStatus;
import com.shahinkhalajestani.banktask.account.model.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountSavingRequest {

	@NotNull
	private BigDecimal initialBalance;

	@NotNull
	private AccountStatus status;

	@NotBlank
	private String customerId;

	@NotNull
	private AccountType type;

}
