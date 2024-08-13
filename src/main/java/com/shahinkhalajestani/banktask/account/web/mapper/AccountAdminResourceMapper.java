package com.shahinkhalajestani.banktask.account.web.mapper;

import java.util.Set;

import com.shahinkhalajestani.banktask.account.service.dto.AccountInquiryDto;
import com.shahinkhalajestani.banktask.account.service.dto.AccountSaveDto;
import com.shahinkhalajestani.banktask.account.web.dto.AccountInquiryResourceDto;
import com.shahinkhalajestani.banktask.account.web.dto.AccountInquiryResponse;
import com.shahinkhalajestani.banktask.account.web.dto.AccountSavingRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AccountAdminResourceMapper {

	@Mapping(target = "balance", source = "initialBalance")
	AccountSaveDto toAccountSaveDto(AccountSavingRequest accountSavingRequest);

	@BeanMapping(ignoreByDefault = true)
	AccountInquiryResourceDto toAccountInquiryResponse(AccountInquiryDto accountInquiryDto);

	default AccountInquiryResponse toAccountInquiryResponse(Set<AccountInquiryDto> accountInquiryDtos) {

	}

}
