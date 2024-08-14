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

	AccountInquiryDto toAccountInquiryDto(Account account);

	Set<AccountInquiryDto> toAccountInquiryDtos(Set<Account> account);

	@Mapping(target = "accountId", expression = "java(java.util.UUID.randomUUID().toString())")

	Account toAccount(AccountSaveDto accountSaveDto);

}
