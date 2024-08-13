package com.shahinkhalajestani.banktask.account.web.dto;

import java.math.BigDecimal;

import com.shahinkhalajestani.banktask.account.model.AccountStatus;
import com.shahinkhalajestani.banktask.account.model.AccountType;
import com.shahinkhalajestani.banktask.base.model.ResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AccountInquiryResponse extends ResponseModel {


	private String accountId;

	private BigDecimal balance;

	private AccountStatus status;

	private AccountType type;

}
