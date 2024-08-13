package com.shahinkhalajestani.banktask.account.web.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.shahinkhalajestani.banktask.account.service.dto.AccountInquiryDto;
import com.shahinkhalajestani.banktask.account.service.dto.AccountSaveDto;
import com.shahinkhalajestani.banktask.account.web.dto.AccountInquiryResourceDto;
import com.shahinkhalajestani.banktask.account.web.dto.AccountInquiryResponse;
import com.shahinkhalajestani.banktask.account.web.dto.AccountSavingRequest;
import com.shahinkhalajestani.banktask.base.model.ResultStatus;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AccountAdminResourceMapper {

	@Mapping(target = "balance", source = "initialBalance")
	AccountSaveDto toAccountSaveDto(AccountSavingRequest accountSavingRequest);

	@BeanMapping(ignoreByDefault = true)
	AccountInquiryResourceDto toAccountInquiryResourceDto(AccountInquiryDto accountInquiryDto);

	default AccountInquiryResponse toAccountInquiryResponse(Set<AccountInquiryDto> accountInquiryDtos) {
		var accountInquiryResponse = new AccountInquiryResponse();
		accountInquiryResponse.setAccounts(accountInquiryDtos.stream().map(this::toAccountInquiryResourceDto)
				.collect(Collectors.toSet()));
		accountInquiryResponse.setResultStatus(ResultStatus.SUCCESS);
		return accountInquiryResponse;
	}

}
