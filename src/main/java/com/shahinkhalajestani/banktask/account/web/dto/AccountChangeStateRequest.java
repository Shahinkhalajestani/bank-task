package com.shahinkhalajestani.banktask.account.web.dto;

import com.shahinkhalajestani.banktask.account.model.AccountStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountChangeStateRequest {

	@NotBlank
	private String accountId;

	@NotNull
	private AccountStatus status;

}
