package com.shahinkhalajestani.banktask.account.service.dto;

import com.shahinkhalajestani.banktask.account.model.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountChangeStateDto {

	private String accountId;

	private AccountStatus status;
}
