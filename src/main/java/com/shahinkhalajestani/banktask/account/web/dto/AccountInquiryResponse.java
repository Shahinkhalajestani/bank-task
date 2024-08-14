package com.shahinkhalajestani.banktask.account.web.dto;

import java.util.Set;

import com.shahinkhalajestani.banktask.base.model.ResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AccountInquiryResponse extends ResponseModel {

	private Set<AccountInquiryResourceDto> accounts;

}
