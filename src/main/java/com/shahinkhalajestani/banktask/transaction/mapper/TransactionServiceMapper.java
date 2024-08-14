package com.shahinkhalajestani.banktask.transaction.mapper;

import com.shahinkhalajestani.banktask.transaction.dto.TransactionOperationDto;
import com.shahinkhalajestani.banktask.transaction.dto.TransactionResultDto;
import com.shahinkhalajestani.banktask.transaction.model.Transaction;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionServiceMapper {

	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "transactionId", expression = "java(java.util.UUID.randomUUID().toString())")
	@Mapping(target = "fromAccountId" , source = "fromAccount")
	@Mapping(target = "toAccountId" , source = "toAccount")
	Transaction toTransaction(TransactionOperationDto transactionOperationDto);

	@Mapping(target = "completionDate", source = "endDate")
	@Mapping(target = "fromAccount", source = "fromAccountId")
	@Mapping(target = "toAccount", source = "toAccountId")
	TransactionResultDto toTransactionResultDto(Transaction transaction);


	default Page<TransactionResultDto> toTransactionResultDtoPage(Page<Transaction> transactions){
		return transactions.map(this::toTransactionResultDto);
	}

}
