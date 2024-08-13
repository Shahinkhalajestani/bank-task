package com.shahinkhalajestani.banktask.account.web.dto;

import java.math.BigDecimal;
import java.util.Set;

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

	private Set<AccountInquiryResourceDto> accounts;

}
