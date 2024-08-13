package com.shahinkhalajestani.banktask.account.service.mapper;

import java.util.Set;

import com.shahinkhalajestani.banktask.account.model.Account;
import com.shahinkhalajestani.banktask.account.service.dto.AccountInquiryDto;
import com.shahinkhalajestani.banktask.account.service.dto.AccountSaveDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdminAccountServiceMapper {

	@BeanMapping(ignoreByDefault = true)
	AccountInquiryDto toAccountInquiryDto(Account account);

	@BeanMapping(ignoreByDefault = true)
	Set<AccountInquiryDto> toAccountInquiryDtos(Set<Account> account);

	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "accountId", expression = "java(java.util.UUID.randomUUID().toString())")
	Account toAccount(AccountSaveDto accountSaveDto);

}
